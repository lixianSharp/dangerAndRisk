$(function(){
	initWorkFace();//工作面
	initRiType();//风险类型
	initRiProfessionType();//专业类型(隐患类型)
	initRiDisasterType();//灾害类型
	initCanCauseAccidentType();//可能导致事故
	initPossibility();//可能性
	initBLPFCD();//人员暴露频繁程度
	initSSHG();//损失后果
	findAllRiRespon();
})

//初始化工作面地点  == 从风险辨识范围中查询，查询出所有工作面名称
function initWorkFace(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/identify_initWorkFace.action",
		data : "",
		success : function(data) {
			$("#addriskAddressSelect option").remove();//新增模态框中的
			
			var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
			for(var i=0;i<data.riIdentificationRangeList.length;i++){
				str +="<option value="+data.riIdentificationRangeList[i].facename+">"+data.riIdentificationRangeList[i].facename+"</option>";
			}
			
			$("#addriskAddressSelect").append(str);
			
		},
		error : function() {
			alert("初始化字典失败，请重新初始化！");
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
				$("#addrisktype option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addrisktype").append(str);
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
			
				$("#addprofessionaltypes option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addprofessionaltypes").append(str);
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
				$("#adddisastertypes option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#adddisastertypes").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}

//初始化可能导致事故
function initCanCauseAccidentType(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initCanCauseAccident.action",
		data : "",
		success : function(data) {
			
				$("#addcancauseaccidents option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addcancauseaccidents").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}

//=============

//初始化可能性(L)
function initPossibility(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initPossibility.action",
		data : "",
		success : function(data) {
				$("#evaluatePossibility option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option title='"+data.dictionaryList[i].description+"' value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#evaluatePossibility").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}


//初始化人员暴露频繁程度(E)
function initBLPFCD(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initBLPFCD.action",
		data : "",
		success : function(data) {
				$("#evaluatePersondegreeofexposure option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option title='"+data.dictionaryList[i].description+"' value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#evaluatePersondegreeofexposure").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}

//初始化损失后果(C)
function initSSHG(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/initDic_initSSHG.action",
		data : "",
		success : function(data) {
				$("#evaluateLossfcconsequence option").remove();//新增模态框中的

				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option title='"+data.dictionaryList[i].description+"' value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#evaluateLossfcconsequence").append(str);

		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}

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

//+========================================================================


//打开新增模态框之前要进行的操作
function addOpenBtn(){
	//初始化表单(清空表单)
	$("#addriskAddressSelect").val("");//选择风险地点的select下拉框
	$("#addriskaddress").val("");//风险地点
	$("#addriskdescribe").val("");//风险描述
	$("#addrisktype").val("");//风险类型
	$("#addprofessionaltypes").val("");//专业类型
	$("#adddisastertypes").val("");//灾害类型
	$("#addcancauseaccidents").val("");//可能导致事故
	$("#addctrlmeasure").val("");//管控措施
	$("#addprincipal").val("");//负责人
	$("#addsuperintendent").val("");//监管人
	$("#addmonitoringperiod").val("");//管控周期
	
	$("#addAddressToTextarea").val("");//存放选中的风险地点，用于追加到文本框中 -
	
	//获取选中的那条数据的辨识主表id，用于添加风险信息操作用
	//alert($("input[type='checkbox']").val())//风险辨识主表id
	var identiryidSelected=$("input[type='checkbox']:checked").val();//风险辨识主表id
	$("#addidentiryid").val(identiryidSelected);//为隐藏域中的风险辨识主表id赋值
	var checkboxCount = $("input[type='checkbox']:checked").length;
	
	 //data-toggle="modal" data-target="#addDuty"
	if(checkboxCount==1){
		$("#addDuty").modal();//打开模态框
	}else if(checkboxCount>1){
		alert("只能选中一行");
	}else if(checkboxCount<1){
		alert("请选中一行");
	}
	
}

//新增
////将选择风险地点的select下拉框选中的值追加到 风险地点文本框中
function addselectchange(obj){
	var riskAddress = $("#addriskAddressSelect option:selected").text();//选择风险地点的select下拉框
	
	var before = $("#addAddressToTextarea").val();//之前的    隐藏域中的
	$("#addAddressToTextarea").val(riskAddress);//将现在选中的添加到隐藏域中
	
	//1.如果值重复选中了，或者选中的值为无效的("--请选择--")，则不进行任何操作
	//2.如果隐藏域中的值为"",则说明是第一次添加,则不将""拼接到隐藏域中,直接将当前选中的值保存在隐藏域中
	if(before==""){
		//说明第一次选择，直接将当前选中的值放在隐藏域中
		$("#addAddressToTextarea").val(riskAddress);//将最终的值保存在隐藏域中
		$("#addriskaddress").val(riskAddress);//添加到文本框中
	}else if(before.indexOf(riskAddress)>-1){
		//说明值重复选中，则不进行任何操作，只需将隐藏域中原来的值进行恢复
		$("#addAddressToTextarea").val("");//清空隐藏域中的值
		$("#addAddressToTextarea").val(before);//恢复隐藏域中原来的值
	}else if(riskAddress=="--请选择--"){
		//说明是选择的值无效，则不进行任何操作，只需将隐藏域中原来的值进行恢复
		$("#addAddressToTextarea").val("");//清空隐藏域中的值
		$("#addAddressToTextarea").val(before);//恢复隐藏域中原来的值
	}else{
		var laterTextArea = $("#addAddressToTextarea").val()+","+before;
		$("#addAddressToTextarea").val(laterTextArea);//将最终的值(以前+当前选中的)保存在隐藏域中
		$("#addriskaddress").val($("#addAddressToTextarea").val());//添加到文本框中
	}
}



//增加辨识风险信息的保存按钮的点击事件
function addSave(){
	// 表单校验   
	var isNotNull = $("#addForm").validate({
		ignore : [],
		rules : {
			"riIdentificationRriskMsg.riskaddress" : "required",//风险地点
			"riIdentificationRriskMsg.riskdescribe" : "required",//风险描述
			"riIdentificationRriskMsg.risktype" :"required",//风险类型
			"riIdentificationRriskMsg.professionaltypes":"required",//专业类型
			"riIdentificationRriskMsg.disastertypes":"required",//灾害类型
			"riIdentificationRriskMsg.cancauseaccidents" : "required",//可能导致事故
			"riIdentificationRriskMsg.ctrlmeasure" : "required",//管控措施
			"riIdentificationRriskMsg.principal" :"required",//负责人
			"riIdentificationRriskMsg.superintendent":"required",//监管人
			"riIdentificationRriskMsg.monitoringperiod":"required"//管控周期
		},
		
		messages : {
			"riIdentificationRriskMsg.riskaddress" :{
				required:"不能为空"//风险地点
			},
			"riIdentificationRriskMsg.riskdescribe" : {
				required:"不能为空"//风险描述
			},
			"riIdentificationRriskMsg.risktype" :{
				required:"不能为空"//风险类型
			},
			"riIdentificationRriskMsg.professionaltypes":{
				required:"不能为空"//专业类型
			},
			"riIdentificationRriskMsg.disastertypes":{
				required:"不能为空"//灾害类型
			},
			"riIdentificationRriskMsg.cancauseaccidents" : {
				required:"不能为空"//可能导致事故
			},
			"riIdentificationRriskMsg.ctrlmeasure" : {
				required:"不能为空"//管控措施
			},
			"riIdentificationRriskMsg.principal" :{
				required:"不能为空"//负责人
			},
			"riIdentificationRriskMsg.superintendent":{
				required:"不能为空"//监管人
			},
			"riIdentificationRriskMsg.monitoringperiod":{
				required:"不能为空"//管控周期
			}
				
			
		}
	});

	// 如果通过表单校验，则执行新增年度辨识信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/assment_addYOrSRiskMsg.action",
			data : $("#addForm").serialize(),
			success : function(data) {
				alert(data.result);
				$("#addDuty").modal("hide");
				//刷新数据
				findAllRiRespon();
			},
			error : function() {
				alert("添加失败，请重新添加！");
			}
		});
	}

}


//评估
function riskEvaluate(){
	//0.表单初始化
	$("#evaluateRiskGrade").val("");//风险评估
	$("#evaluateRiskValue").val("");//风险值
	$("#evaluateLossfcconsequence").val("");//损失后果
	$("#evaluatePersondegreeofexposure").val("");//人员暴露频繁程度
	$("#evaluatePossibility").val("");//可能性
	
	//1.将选中的那行的风险信息id赋给隐藏域中用于评估的风险信息id
	var checkboxCount = $("input[type='checkbox']:checked").length;
	
	var riskmsgid=$("input[type='checkbox']:checked").siblings("input").val();//辨识风险信息id
	$("#assessmentToriskmsgid").val(riskmsgid);//为辨识风险信息id的隐藏域赋值  用于风险评估
	 //data-toggle="modal" data-target="#addDuty"
	//查看评估状态，状态为"已评估"的不能再进行评估
	var evaluateStatus=$("input[type='checkbox']:checked").siblings("input").attr("title");//获取评估状态
	
	
	if(checkboxCount==1&&evaluateStatus!="已评估"){
		$("#riskEvaluate").modal();//打开模态框
	}else if(checkboxCount>1){
		alert("只能选中一行");
	}else if(checkboxCount<1){
		alert("请选中一行");
	}else if(evaluateStatus=="已评估"){
		alert("已评估的不能重复进行评估");
	}
	
}

//保存评估
function assessmentSaveBtn(){
	//1.表单校验
	// 表单校验   
	var isNotNull = $("#evalueateForm").validate({
		ignore : [],
		rules : {
			"riAssessment.possibility" : "required",//可能性
			"riAssessment.persondegreeofexposure" : "required",//人员暴露频繁程度
			"riAssessment.lossofcconsequences" :"required",//损失后果
			"riAssessment.riskvalue":"required",//风险值
			"riAssessment.riskgrade":"required"//风险等级
		},
		
		messages : {
			"riAssessment.possibility" :{
				required:"不能为空"//可能性
			},
			"riAssessment.persondegreeofexposure" : {
				required:"不能为空"//人员暴露频繁程度
			},
			"riAssessment.lossofcconsequences" :{
				required:"不能为空"//损失后果
			},
			"riAssessment.riskvalue":{
				required:"不能为空"//风险值
			},
			"riAssessment.riskgrade":{
				required:"不能为空"//风险等级
			}				
			
		}
	});

	// 如果通过表单校验，则执行保存评估信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/assment_addRiAssessment.action",
			data : $("#evalueateForm").serialize(),
			success : function(data) {
				alert(data.result);
				$("#riskEvaluate").modal("hide");//关闭模态框
				//刷新数据
				findAllRiRespon();
			},
			error : function() {
				alert("评估失败，请重新评估！");
			}
		});
	}

}






//查询  分页
//查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/assment_findRiskMsgAndAssessmentByCondition.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"riskdescribe":$("#riskDescribeFindCondition").val(),//风险描述
			"riskaddress":$("#riskAddressFindCondition").val(),//风险地点
			"evaluationstatus":$("#evaluateFindCondition").val()//评估状态
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
				if(typeof(riskGrade)==undefined||riskGrade==null||riskGrade==""){
					riskGrade ="=";//风险等级
				}
				
				var evaluationstatus = data.pageBean.productList[i].evaluationStatus;//评估状态
				if(evaluationstatus=="N"){
					evaluationstatus = "未评估";
				}else if(evaluationstatus=="Y"){
					evaluationstatus = "已评估";
				}
				
				var possibility = data.pageBean.productList[i].possibility;//可能性
				var lossOfCconsequences = data.pageBean.productList[i].lossOfCconsequences;//损失后果
				var personDegreeOfExposure = data.pageBean.productList[i].personDegreeOfExposure;//人员暴露平凡程度
				var riskValue = data.pageBean.productList[i].riskValue;//风险值
				if(typeof(possibility)==undefined||possibility==null||possibility==""){
					possibility ="=";//可能导致事故
					lossOfCconsequences ="=";//损失后果
					personDegreeOfExposure ="=";//人员暴露频繁程度
					riskValue ="=";//风险值
				}
				
				var riskGrade=dealWithRiGradeColor(riskValue,riskGrade);
				
				
				//开始拼接
				options += "<tr>";
			    options += "<td><input type='checkbox' value='"+identifyMainId+"'><input type='hidden' title='"+evaluationstatus+"' value='"+riskmsgid+"'></td>";
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
				options +="<td>"+riskGrade+"</td>";//风险等级
				if(evaluationstatus=="未评估"){
					options +="<td><font color='red'>未评估</font></td>";//评估状态
				}else if(evaluationstatus=="已评估"){
					options +="<td><font color='blue'>已评估</font></td>";//评估状态
				}
				//options +="<td>"+evaluationstatus+"</td>";//评估状态
				options +="<td><input type='hidden' value='"+possibility+"'><input type='hidden' value='"+lossOfCconsequences+"'><input type='hidden' value='"+personDegreeOfExposure+"'><input type='hidden' value='"+riskValue+"'><a href='#' onclick='riskEvaluateDetailInfo(this)'>详情</a></td>";
				options += "</tr>";
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

//极其危险（红色）  高度危险（橙色）  显著危险（黄色）  一般危险（蓝色） 稍有危险（黑色）
//根据风险值处理风险等级颜色  参数：风险值  风险等级    返回值：带有颜色的风险等级
function dealWithRiGradeColor(riskValue,riskGrade){
	var riskGradeWithColor ="";
	if(riskValue>320){
		riskGradeWithColor = "<font color='red'>"+riskGrade+"</td>";
	}else if(riskValue>160 && riskValue<320){
		riskGradeWithColor = "<font color='orange'>"+riskGrade+"</td>";
	}else if(riskValue>70 && riskValue<160){
		riskGradeWithColor = "<font color='yellow'>"+riskGrade+"</td>";
	}else if(riskValue>20 && riskValue<70){
		riskGradeWithColor = "<font color='blue'>"+riskGrade+"</td>";
	}else if(riskValue<20){
		riskGradeWithColor = "<font color='black'>"+riskGrade+"</td>";
	}else{
		riskGradeWithColor = "=";
	}
	
	return riskGradeWithColor;
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




//详情
function riskEvaluateDetailInfo(obj){
	//1.打开模态框
	$('#riskEvaluateDetailInfo').modal();
	
	//获取表格中的值用于详情页面初始化
	var riskSource = $(obj).parents("tr").children("td").eq(2).text();//风险来源
	var riskAddress = $(obj).parents("tr").children("td").eq(3).text();//风险地点
	var riskDescribe = $(obj).parents("tr").children("td").eq(4).text();//风险描述
	var riskType = $(obj).parents("tr").children("td").eq(5).text();//风险类型
	var riskProType = $(obj).parents("tr").children("td").eq(6).text();//专业类型
	var riskDisasterType=$(obj).parents("tr").children("td").eq(7).text();//灾害类型
	var riskCancauseAccident=$(obj).parents("tr").children("td").eq(8).text();//可能导致事故
	var riskctrlMeasure=$(obj).parents("tr").children("td").eq(9).text();//管控措施
	var riskPrincipal=$(obj).parents("tr").children("td").eq(10).text();//负责人
	var risksuperintendent=$(obj).parents("tr").children("td").eq(11).text();//监管人
	var riskMonitoringPeriod=$(obj).parents("tr").children("td").eq(12).text();//监管周期
	var riskRiskGrade=$(obj).parents("tr").children("td").eq(13).text();//风险等级
	
	var possible = $(obj).siblings("input").eq(0).val();//可能性
	var lossOfCconsequences = $(obj).siblings("input").eq(1).val();//损失后果
	var personDegreeOfExposure=$(obj).siblings("input").eq(2).val();//人员暴露频繁程度
	var riskValue=$(obj).siblings("input").eq(3).val();//风险值
	
	//2.为初始化模态框中的数据
	$("#detailRiskIn").text(riskSource);//风险来源
	$("#detailRiskAddress").text(riskAddress);//风险地点
	$("#detailRiskDetail").text(riskDescribe);//风险描述
	$("#detailRiskType").text(riskType);//风险类型
	$("#detailProfessType").text(riskProType);//专业类型
	$("#detailDisasterType").text(riskDisasterType);//灾害类型
	$("#detailPrincipal").text(riskPrincipal);//负责人
	$("#detailsuperintendent").text(risksuperintendent);//监管人
	$("#detailMonitoringPeriod").text(riskMonitoringPeriod);//监管周期
	$("#detailRiskType").text(riskType);//风险类型
	$("#detailCanCauseAccident").text(riskCancauseAccident);//可能导致事故
	$("#detailCtrlMeasure").text(riskPrincipal);//管控措施
	$("#detailPossibility").text(possible);//可能性
	$("#detailPersonDegreeOfExposure").text(personDegreeOfExposure);//人员暴露频繁程度
	$("#detailLossOfCconsequences").text(lossOfCconsequences);//损失后果
	$("#detailRiskValue").text(riskValue);//风险值
	$("#detailRiskGrade").text(riskRiskGrade);//风险等级
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
	
	//alert($("#evaluateFindCondition option:selected").attr("title"))
	
	//清空查询条件和 当前页页号 每页显示的记录数，恢复初始值
	$("#currentPage").val("1");
	$("#currentCount").val("10");
	
	$("#riskDescribeFindCondition").val("");//风险描述
	$("#riskAddressFindCondition").val("");//风险地点
	$("#evaluateFindCondition").val("");//评估状态
}


//计算LEC
function optionChange3(){
	var possibility = $("#evaluatePossibility option:selected").attr("title");//可能性
	var exposure = $("#evaluatePersondegreeofexposure option:selected").attr("title");//人员暴露频繁程度
	var consequence = $("#evaluateLossfcconsequence option:selected").attr("title");//损失后果
	
	
	var riskValue = possibility*exposure*consequence;//计算出风险值
	//alert(possibility*exposure*consequence)
	if(!isNaN(riskValue)){
		$("#evaluateRiskValue").val(riskValue);//风险值
	}
	
	
	if(riskValue>320){
		$("#evaluateRiskGrade").val("极其危险,不能继续作业");
	}else if(riskValue>20 && riskValue<70){
		$("#evaluateRiskGrade").val("一般危险,需要注意");
	}else if(riskValue>160 && riskValue<320){
		$("#evaluateRiskGrade").val("高度危险,需立即整改");
	}else if(riskValue<20){
		$("#evaluateRiskGrade").val("稍有危险,可以接受");
	}else if(riskValue>70 && riskValue<160){
		$("#evaluateRiskGrade").val("显著危险,需要整改");
	}
}

//计算LEC
function optionChange2(){
	var possibility = $("#evaluatePossibility option:selected").attr("title");//可能性
	var exposure = $("#evaluatePersondegreeofexposure option:selected").attr("title");//人员暴露频繁程度
	var consequence = $("#evaluateLossfcconsequence option:selected").attr("title");//损失后果
	
	
	var riskValue = possibility*exposure*consequence;//计算出风险值
	//alert(possibility*exposure*consequence)
	if(!isNaN(riskValue)){
		$("#evaluateRiskValue").val(riskValue);//风险值
	}
	
	if(riskValue>320){
		$("#evaluateRiskGrade").val("极其危险,不能继续作业");
	}else if(riskValue>20 && riskValue<70){
		$("#evaluateRiskGrade").val("一般危险,需要注意");
	}else if(riskValue>160 && riskValue<320){
		$("#evaluateRiskGrade").val("高度危险,需立即整改");
	}else if(riskValue<20){
		$("#evaluateRiskGrade").val("稍有危险,可以接受");
	}else if(riskValue>70 && riskValue<160){
		$("#evaluateRiskGrade").val("显著危险,需要整改");
	}
}

//计算LEC
function optionChange1(){
	var possibility = $("#evaluatePossibility option:selected").attr("title");//可能性
	var exposure = $("#evaluatePersondegreeofexposure option:selected").attr("title");//人员暴露频繁程度
	var consequence = $("#evaluateLossfcconsequence option:selected").attr("title");//损失后果
	
	
	var riskValue = possibility*exposure*consequence;//计算出风险值
	//alert(possibility*exposure*consequence)
	if(!isNaN(riskValue)){
		$("#evaluateRiskValue").val(riskValue);//风险值
	}
	
	if(riskValue>320){
		$("#evaluateRiskGrade").val("极其危险,不能继续作业");
	}else if(riskValue>20 && riskValue<70){
		$("#evaluateRiskGrade").val("一般危险,需要注意");
	}else if(riskValue>160 && riskValue<320){
		$("#evaluateRiskGrade").val("高度危险,需立即整改");
	}else if(riskValue<20){
		$("#evaluateRiskGrade").val("稍有危险,可以接受");
	}else if(riskValue>70 && riskValue<160){
		$("#evaluateRiskGrade").val("显著危险,需要整改");
	}
}





