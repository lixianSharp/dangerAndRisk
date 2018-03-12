
/**
 * 请求树信息
 */
//同步加载，否则出错
function searchUnitTree() {
	$.ajax({
		type : "post",
		target : "#treeDemo",
		dataType : "json",
		async:false,
		url : "searchTreeAction.action",
		success : function(data) {
			/*alert(data);
			zNodes = eval("("+data+")");*/
			$("#hidden_tree").val(data);
		},
		error : function() {
			alert("请求树失败！");
		}
	});
}