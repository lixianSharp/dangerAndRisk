$(function(){
	
	findAllRiRespon();
	initRiGrade();//初始化风险等级
	initRiType();//初始化风险类型
	initRiProfessionType();//初始化专业类型
	initRiDisasterType();//初始化灾害类型
})

//初始化风险等级
function initRiGrade(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initRiGrade.action",
		data : "",
		success : function(data) {
				$("#riskGradeCondition option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#riskGradeCondition").append(str);
		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}




//初始化风险类型
function initRiType(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initRiType.action",
		data : "",
		success : function(data) {
				$("#riskTypeCondition option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#riskTypeCondition").append(str);
		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}



//初始化专业类型
function initRiProfessionType(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initDangerType.action",
		data : "",
		success : function(data) {
			
				$("#proTypeCondition option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#proTypeCondition").append(str);
		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}

//初始化灾害类型
function initRiDisasterType(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initDisasterType.action",
		data : "",
		success : function(data) {
				$("#disasterTypeCondition option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#disasterTypeCondition").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}




//查询  分页
//查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/risklist_findRiskMsgAndAssessmentByCondition.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"riskgrade":$("#riskGradeCondition").val(),//风险等级
			"risktype":$("#riskTypeCondition").val(),//风险类型
			"professionaltypes":$("#proTypeCondition").val(),//专业类型
			"disastertypes":$("#disasterTypeCondition").val()//灾害类型
		// 每页显示的记录数
		},
		success : function(data) {
			//删除tbody中的所有子标签
			$("#tbody").children().remove();
			var options = "";
			for (var i = 0; i < data.pageBean.productList.length; i++) {
				var identifyMainId = data.pageBean.productList[i].identifyMainId;//辨识主表id
				
				var riskmsgid = data.pageBean.productList[i].riskMsgId;//辨识风险信息id
				
				var identifyMainMsg = data.pageBean.productList[i].identifyMainMsg;//辨识主表名称(也就是风险来源)
				var riskAddress = data.pageBean.productList[i].riskAddress;//风险地点
				var riskDescribe = data.pageBean.productList[i].riskDescribe;//风险描述
				var riskType = data.pageBean.productList[i].riskType;//风险类型
				var professionaltypes = data.pageBean.productList[i].professionalTypes;//专业类型
				var disastertypes = data.pageBean.productList[i].disasterTypes;//灾害类型
				var cancauseaccidents = data.pageBean.productList[i].canCauseAccidents;//可能导致事故
				var ctrlmeasure = data.pageBean.productList[i].ctrlMeasure;//管控措施
				var principal = data.pageBean.productList[i].principal;//负责人
				var superintendent = data.pageBean.productList[i].superintendent;//监管人
				var monitoringperiod = data.pageBean.productList[i].monitoringPeriod;//管控周期
				
				var riskGrade = data.pageBean.productList[i].riskGrade;//风险等级
				var evaluationstatus = data.pageBean.productList[i].evaluationStatus;//评估状态
				var possibility = data.pageBean.productList[i].possibility;//可能性
				var lossOfCconsequences = data.pageBean.productList[i].lossOfCconsequences;//损失后果
				var personDegreeOfExposure = data.pageBean.productList[i].personDegreeOfExposure;//人员暴露平凡程度
				var riskValue = data.pageBean.productList[i].riskValue;//风险值
				
				//开始拼接
				options += "<tr>";
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+identifyMainMsg+"</td>";//风险来源
				options +="<td>"+riskAddress+"</td>";//风险地点
				options +="<td>"+riskDescribe+"</td>";//风险描述
				options +="<td>"+riskType+"</td>";//风险类型
				options +="<td>"+professionaltypes+"</td>";//专业类型
				options +="<td>"+disastertypes+"</td>";//灾害类型
				options +="<td>"+cancauseaccidents+"</td>";//可能导致事故
				options +="<td>"+ctrlmeasure+"</td>";//管控措施
				options +="<td>"+principal+"</td>";//负责人
				options +="<td>"+superintendent+"</td>";//监管人
				options +="<td>"+monitoringperiod+"</td>";//监管周期
				options +="<td>"+possibility+"</td>";//可能性
				options +="<td>"+personDegreeOfExposure+"</td>";//人员暴露频繁程度
				options +="<td>"+lossOfCconsequences+"</td>";//损失后果
				options +="<td>"+riskValue+"</td>";//风险值
				options +="<td>"+riskGrade+"</td>";//风险等级
			}
			// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
			PagePilot(data.pageBean.currentPage, data.pageBean.currentCount, data.pageBean.totalCount);
			
			$("#tbody").append(options);
		},
		error : function() {
			alert("失败了！");
		}
	});
}





//分页条
//currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
function PagePilot(currentPage, currentCount, totalCount) {
	$('#paginationIDU').pagination(
		{
			// 组件属性
			"total" : totalCount,// 数字 当分页建立时设置记录的总数量 1 总记录数
			"pageSize" : currentCount,// 数字 每一页显示的数量 10 每页显示的记录数
			"pageNumber" : currentPage,// 数字 当分页建立时，显示的页数 1 当前页页号
			"pageList" : [ 10 ],// 数组 用户可以修改每一页的大小，
			// 功能
			"layout" : [ 'list', 'sep', 'first', 'prev', 'manual', 'next',
					'last', 'links' ],
			"onSelectPage" : function(pageNumber, b) {
				$("#currentPage").val(pageNumber);// 当前页页号
				$("#currentCount").val(b);// 每页显示的记录数
				//刷新数据
				findAllRiRespon();
			}
		});
}


//查询按钮的点击事件
function findBtn(){
	//条件查询之前先清空页号和每页显示的记录数，恢复初始值
	$("#currentPage").val("1");
	$("#currentCount").val("10");
	findAllRiRespon();
}
//清空按钮的点击事件
function clearBtn(){
	//清空查询条件和 当前页页号 每页显示的记录数，恢复初始值
	$("#currentPage").val("1");
	$("#currentCount").val("10");
	
	$("#disasterTypeCondition").val("");//灾害类型
	$("#proTypeCondition").val("");//专业类型
	$("#riskTypeCondition").val("");//风险类型
	$("#riskGradeCondition").val("");//风险等级
}
