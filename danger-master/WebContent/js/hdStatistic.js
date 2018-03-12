/**
 * 统计JS
 */
// 获取数据
function queryNum(checkunit, dangergrade, type,startTime,endTime) {
//	window.location.reload();
	$.ajax({
		url : "/danger/queryDangerTongji.action",
		async : true,
		data : {
			"currentPage" : $("#currentPage").val(), // 查询隐藏的页号
			"checkunit" : checkunit,
			"dangergrade" : dangergrade,
			"type" : type,
			"startTime":startTime,
			"endTime":endTime
		},
		dataType : "text",
		type : "POST",
		success : showTable,
		error : function() {
			alert("请求失败！");
		}

	});
}

/**
 * 显示表格
 */
function showTable(data) {
	var result = eval("(" + data + ")");
	var dangerList = result.productList;
	// 清空表格
	$("#dangerTable  tr:not(:first)").remove();
	if (dangerList != null) {
		// 在表格中添加数据
		for (var i = 0; i < dangerList.length; i++) {
			var index = i + 1;
			$("#dangerTable").append(
					"<tr><td>"
							+ (index + (result.currentPage - 1) * 6)
							+ "</td><td>"
							+ dangerList[i].checkunit
							+ "</td><td>"
							+ dangerList[i].address
							+ "</td><td>"
							+ dangerList[i].findperson
							+ "</td><td>"
							+ dangerList[i].dangergrade
							+ "</td><td>"
							+ dangerList[i].unit
							+ "</td><td>"
							+ dangerList[i].dangerstatus
							+ "</td><td>"
							+ dangerList[i].type
							+ "</td><td>"
							+ Format(new Date(dangerList[i].findtime),
									"yy-MM-dd HH:mm") + "</td></tr>");
		}
	}
	/**
	 * 显示分页
	 */
	var currentPage = result.currentPage; // 当前页
	var totalCount = result.totalCount; // 数据总数
	var checkunit = result.checkunit; // 数据总数
	var type = result.type; // 数据总数
	var dangergrade = result.dangergrade; // 数据总数
	// 开启模态框
	$('#dangerTongjiInfo').modal('show');

	page(currentPage, totalCount, checkunit, type, dangergrade);

}

/**
 * 模态框中的分页
 */
function page(currentPage, totalCount, checkunit, type, dangergrade) {
	// 修改分页的基本属性
	$('#paginationIDU1').pagination(
			{
				// 组件属性
				"total" : totalCount,// 数字 当分页建立时设置记录的总数量 1
				"pageSize" : 6,// 数字 每一页显示的数量 10
				"pageNumber" : currentPage,// 数字 当分页建立时，显示的页数 1
				"pageList" : [ 6 ],// 数组 用户可以修改每一页的大小，
				// 功能
				"layout" : [ 'list', 'sep', 'first', 'prev', 'manual', 'next',
						'last', 'links' ],
				"onSelectPage" : function(pageNumber, b) {
					// 给页面中隐藏的页号赋值(便于在ajax第二次时候获取页号)
					$("#currentPage").val(pageNumber);
					// 带着页号调用上面的ajax函数再次请求数据
					queryNum(checkunit, dangergrade, type);
				}
			});
}
