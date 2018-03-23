


/**
 * 专业类型下拉菜单
 */
function selectProfessionalTypes() {
	
	$.ajax({
		url : 'validPlan_getProfessionalTypesList.action',
		data : '',
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {

			var ptLists = result.ptList;
			
			$("#professionalTypesId").empty();
			var professionalTypes = $("#professionalTypesId");
			// duty.append("<option value=''>无</option>");
			// console.log("ceshi"+dictionarys)
			// alert(dictionarys.length);
			var str="<option value=''>--全部--</option>";
			for (var i = 0; i < ptLists.length; i++) {
				
				var s="<option value='" + ptLists[i]
						+ "'>" + ptLists[i]
						+ "</option>";
				str=str+s;
				
			}
			professionalTypes.append(str);
			

		}
	});
}

/*
 * 分页查询
 */
/*********************分页*****************************/

function fenye(total, pageSize, pageNumber) {
	// alert(total+" "+pageSize)
	$('#paginationIDU2').pagination(
			{
				// 组件属性
				"total" : total,// 数字 当分页建立时设置记录的总数量 1
				"pageSize" : pageSize,// 数字 每一页显示的数量 10
				"pageNumber" : pageNumber,// 数字 当分页建立时，显示的页数 1
				"pageList" : [10],// 数组 用户可以修改每一页的大小，
				// 功能
				"layout" : [ 'list', 'sep', 'first', 'prev', 'manual', 'next',
						'last', 'links' ],
				"onSelectPage" : function(pageNumber, b) {
					$("#currentPage2").val(pageNumber);
					$("#currentCount2").val(b);
					queryRisk();
				}
			});
}


function yearRiskControlImport(){
	queryRisk();
	$('#yearRiskControlImport').modal();
}

function queryRiskButton(){
	$("#currentPage2").val("1");
	queryRisk();
}

function queryRisk(){

	$.ajax({
		url : 'controlPlan_getAllRiskInfo.action',
		data : $("#queryRiskForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async : true,
		success : successList,

	});
}



var successList = function List(result) {
	
	//得到数据
	var riskInfos = result.pageBean.productList;

	$("#t_body").html("");// 清空表体
	// 获取到这个表格
	var t_body = $("#t_body");
	// 循环添加每一行
	var index=0;
	for (var i = 0; i < riskInfos.length; i++) {
		index=i+1;
		var str = "<tr><td><input type='checkbox' class='planCheck'></td><td>"
		+index+"</td><td>fdsfds"
		+"</td><td>"
		+riskInfos[i].riskaddress+"</td><td>"
		+riskInfos[i].riskdescribe+"</td><td>"
		+riskInfos[i].risktype+"</td><td>"
		+riskInfos[i].professionaltypes+"</td><td>"
		+riskInfos[i].disastertypes+"</td><td>"
		+riskInfos[i].cancauseaccidents+"</td><td>"
		+riskInfos[i].ctrlmeasure+"</td><td>"
		+riskInfos[i].principal+"</td><td>"
		+riskInfos[i].superintendent+"</td><td>"
		+"<input type='hidden' id='riskmsgid' value='"+riskInfos[i].riskmsgid+"'>"
		+riskInfos[i].monitoringperiod+"</td></tr>";

	
		t_body.append(str);
	}
	

	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示

}

/*
 * 导入风险信息到管控计划中
 */
function confirmImport(){
	/*var shuzu =[];
	var count=0;
	//多条风险信息导入到管控计划中
	$(".planCheck").each(function() { // 获取选择的风险
		
		if ($(this).prop("checked")) {// 如果选中。。。
			
		count++;
		}
		for(var i=0;i<count;i++){
			if ($(this).prop("checked")) {// 如果选中。。。
				
				shuzu[i]=$(this).parents('tr').find("#riskmsgid").val();
			}
		}
		
	})*/
	
	var choosePlan = 0;// 判断是否有风险被选中

	$(".planCheck").each(function() { // 获取选择的风险

		if ($(this).prop("checked")) {// 如果选中。。。
			choosePlan++;

		}
	})
	
	
	//多条风险信息导入到管控计划中
	$(".planCheck").each(function() { // 获取选择的风险
		
		
			if ($(this).prop("checked")) {// 如果选中。。。
				
				//shuzu[i]=$(this).parents('tr').find("#riskmsgid").val();
				alert($(this).parents('tr').find("#riskmsgid").val())
				addOneRisk($(this).parents('tr').find("#riskmsgid").val())
			}
		
		
	})
	
}


function addOneRisk(riskmsgid){
	$.ajax({
		url : 'controlPlan_importRiskInfo.action',
		data : {
			"rictrlplanid" : $("#myRictrlplanid").val(),
			"riskmsgid":riskmsgid
		},
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {
			alert(result.message);
			
			$('#yearRiskControlImport').modal('hide');
			// 全局刷新当前页面
			window.location.reload();

		}

	});
	
}


/**
 * 删除风险信息
 */
/*
 * 点击删除按钮
 */

function deleteRiskInfo(obj) {

	var myRiskInfoId = $(obj).parents("tr").find("#myRiskInfoId").val();

	$("#url").val(myRiskInfoId);
	
	// 打开删除模态框
	$('#deleteRisk').modal();
}
/*
 * 点击删除模态框的确定按钮实现删除事件
 */
function urlSubmit() {
	// 获取单位id
	var riskmsgid = $("#url").val();
	var rictrlplanid = $("#myRictrlplanid").val();
	$.ajax({
		url : 'controlPlan_deleteRiskInfo.action',
		data : {
			"riCtrlPlanId" : rictrlplanid,
			"riskMsgId":riskmsgid
		},
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {
			alert(result.message);
			// 关闭模态框
			$('#deleteRisk').modal('hide');
			// 删除成功后刷新页面
			window.location.reload();
		}
	});

}

/*
 * 复制上月的管控计划风险数据
 */
//获取这个月的id
function conpyPrecedingMonth(){
	alert($("#myRictrlplanid").val())
	$.ajax({
		url : 'controlPlan_iconpyPrecedingMonthRiskInfo.action',
		data : {
			"Myrictrlplanid" : $("#myRictrlplanid").val()
		},
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {
			// 弹出是否录入成功
			alert(result.message);

			// 全局刷新当前页面
			window.location.reload();

		}

	});
}



