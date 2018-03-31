/*
 * 页面初始化
 */


$(function(){
	//风险信息
	initWorkFace();//工作面
	initRiType();//风险类型
	initRiProfessionType();//专业类型(隐患类型)
	initRiDisasterType();//灾害类型
	initCanCauseAccidentType();//可能导致事故
	
	//评估
	initPossibility();//可能性
	initBLPFCD();//人员暴露频繁程度
	initSSHG();//损失后果
	
	
	 //判断是否需要隐藏按钮
	 
	var reportStatus = $("#myReportStatus").val();
	var checkStatus =$("#myCheckStatus").val();
	
	if(reportStatus=='1'&&checkStatus!='0'){
		$("#conpyPrecedingMonthButton").hide();
		$("#yearRiskControlImportButton").hide();
		$("#addOpenBtnButton").hide();
		$("#caozuo").hide();
		$(".UDcaozuo").hide();
	}
	
	
})

/*
 * 分页查询
 */
/*********************分页*****************************/

function fenye(total, pageSize, pageNumber) {
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
$("#importRiskMiaoshu").val("");
$("#importRiskAddress").val("");
	queryRisk();
	$('#yearRiskControlImport').modal();
}

function queryRiskButton(){
	$("#currentPage2").val("1");
	
	queryRisk();
}

function queryRisk(){
	$("#specialtyId").val($("#myspecialty").html())
	
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
	var RiIdentificationMainTableIds = result.RiIdentificationMainTableIdList;

	$("#t_body").html("");// 清空表体
	// 获取到这个表格
	var t_body = $("#t_body");
	// 循环添加每一行
	var index=0;
	for (var i = 0; i < riskInfos.length; i++) {
		index=i+1;
		
		var RiIdentificationMainTableId;
		if(RiIdentificationMainTableIds[i]=="Y"){
			RiIdentificationMainTableId="年度辨识";
		}
		//if(RiIdentificationMainTableIds[i]=="Y")
		var str = "<tr><td><input type='checkbox' class='planCheck'></td><td>"
		+index+"</td><td>"
		+RiIdentificationMainTableId+"</td><td>"
		//+"</td><td>"
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
	
	
	
	var dataArray = new Array();

	$(".planCheck").each(function() { // 获取选择的风险
		
	
	if ($(this).prop("checked")) {// 如果选中。。。
		
		//shuzu[i]=$(this).parents('tr').find("#riskmsgid").val();
		 dataArray.push($(this).parents('tr').find("#riskmsgid").val());
		
	}
		
	})
	//alert(JSON.stringify(dataArray))
	
	
	
	$.ajax({
		url : 'controlPlan_importRiskInfo2.action',
		data : {
			"rictrlplanid" : $("#myRictrlplanid").val(),
			//"shuzu":shuzu
			data: JSON.stringify(dataArray)
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
	$.ajax({
		url : 'controlPlan_iconpyPrecedingMonthRiskInfo.action',
		data : {
			"riCtrlPlanId" : $("#myRictrlplanid").val(),
			"specialty":$("#myspecialty").html()
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



/**********************风险信息***************************/
//初始化工作面地点(风险地点)  == 从风险辨识范围中查询，查询出所有工作面名称
function initWorkFace(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/identify_initWorkFace.action",
		data : "",
		success : function(data) {
			$("#addriskAddressSelect option").remove();//新增模态框中的

			$("#updateriskAddressSelect option").remove();//修改模态框中的
				
			var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
			for(var i=0;i<data.riIdentificationRangeList.length;i++){
				str +="<option value="+data.riIdentificationRangeList[i].facename+">"+data.riIdentificationRangeList[i].facename+"</option>";
			}
			
			$("#addriskAddressSelect").append(str);

			$("#updateriskAddressSelect").append(str);
		
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

				$("#updaterisktype option").remove();//修改模态框中的
				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addrisktype").append(str);

				$("#updaterisktype").append(str);
			
			//刷新数据
			//findAllRiRespon();
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

				$("#updateprofessionaltypes option").remove();//修改模态框中的
				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addprofessionaltypes").append(str);

				$("#updateprofessionaltypes").append(str);
			
			//刷新数据
			//findAllRiRespon();
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

				$("#updatedisastertypes option").remove();//修改模态框中的
				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#adddisastertypes").append(str);

				$("#updatedisastertypes").append(str);
			
			//刷新数据
			//findAllRiRespon();
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

				$("#updatecancauseaccidents option").remove();//修改模态框中的
				var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
				for(var i=0;i<data.dictionaryList.length;i++){
					str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
				}
				$("#addcancauseaccidents").append(str);

				$("#updatecancauseaccidents").append(str);
			
			//刷新数据
			//findAllRiRespon();
		},
		error : function() {
			alert("字典初始化失败，请重新初始化！");
		}
	});
}
/*************************************************/

/******************风险评估*********************/

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

/***************************************/



//打开新增模态框之前要进行的操作
function addOpenBtn(){
	
	//添加管控计划id到隐藏域中
	
	$("#addRictrlplanid").val($("#myRictrlplanid").val());
	
	$("#addprofessionaltypes2").val($("#myspecialty").html());
	//添加
	
	//风险信息初始化表单(清空表单)
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
	
	
	
	//风险评估表单初始化
	$("#evaluateRiskGrade").val("");//风险等级
	$("#evaluateRiskValue").val("");//风险值
	$("#evaluateLossfcconsequence").val("");//损失后果
	$("#evaluatePersondegreeofexposure").val("");//人员暴露频繁程度
	$("#evaluatePossibility").val("");//可能性
}


//新增
////将选择风险地点的select下拉框选中的值追加到 风险地点文本框中
function addselectchange(obj){
	var riskAddress = $("#addriskAddressSelect option:selected").text();//选择风险地点的select下拉框
	
	var before = $("#addAddressToTextarea").val();//之前的    隐藏域中的
	$("#addAddressToTextarea").val(riskAddress);//将现在选中的添加
	if(before==""){
		var laterTextArea = $("#addAddressToTextarea").val();
		$("#addAddressToTextarea").val(laterTextArea);
		$("#addriskaddress").val($("#addAddressToTextarea").val());//添加到文本框中
	}else{
		var laterTextArea = $("#addAddressToTextarea").val()+","+before;
		$("#addAddressToTextarea").val(laterTextArea);
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
			"riIdentificationRriskMsg.monitoringperiod":"required",//管控周期
				
			//风险评估
			"riAssessment.possibility" : "required",//可能性
			"riAssessment.persondegreeofexposure" : "required",//人员暴露频繁程度
			"riAssessment.lossofcconsequences" :"required",//损失后果
			"riAssessment.riskvalue":"required",//风险值
			"riAssessment.riskgrade":"required"//风险等级	
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
			},
			
			//风险评估
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

	// 如果通过表单校验，则执行新增年度辨识信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			//url : "${pageContext.request.contextPath}/identify_addIdentifyRiskMsg.action",
			url : "controlPlan_addRiskMsgToControlPlan.action",
			data : $("#addForm").serialize(),
			success : function(data) {
				alert(data.message);
				$("#addDuty").modal("hide");
				//刷新数据
				window.location.reload();
			},
			error : function() {
				alert("添加失败，请重新添加！");
			}
		});
	}

}



/******************************修改风险信息************/

//修改
//打开修改模态框之前要进行的操作
function updateOpenBtn(obj){


	
	var address = $(obj).parents("tr").children("td").eq(1).text();//风险地点

	var describe = $(obj).parents("tr").children("td").eq(2).text();//风险描述

	
//	$("select[name='ricontrolPlan.monthorweek'] option[value='"+$tds.eq(3).html()+"']").attr("selected", true).prop("selected", true); 
	var riType = $(obj).parents("tr").children("td").eq(3).text();//风险类型
	
	
	var proType = $(obj).parents("tr").children("td").eq(4).text();//专业类型
	var disasterType = $(obj).parents("tr").children("td").eq(5).text();//灾害类型
	var cancauseAccident = $(obj).parents("tr").children("td").eq(6).text();//可能导致事故
	var ctrlMeasure = $(obj).parents("tr").children("td").eq(7).text();//管控措施
	var principal = $(obj).parents("tr").children("td").eq(8).text();//负责人
	var superintendent = $(obj).parents("tr").children("td").eq(9).text();//监管人
	var monitoringperiod = $(obj).parents("tr").children("td").eq(10).text();//管控周期
	
	
	//初始化表单(回显数据)
	$("#updateriskAddressSelect").val("");//选择风险地点的select下拉框
	$("#updateriskaddress").val(address);//风险地点
	$("#updateriskdescribe").val(describe);//风险描述
	$("#updaterisktype").val(riType);//风险类型
	$("#updateprofessionaltypes").val(proType);//专业类型
	$("#updatedisastertypes").val(disasterType);//灾害类型
	$("#updatecancauseaccidents").val(cancauseAccident);//可能导致事故
	$("#updatectrlmeasure").val(ctrlMeasure);//管控措施
	$("#updateprincipal").val(principal);//负责人
	$("#updatesuperintendent").val(superintendent);//监管人
	$("#updatemonitoringperiod").val(monitoringperiod);//管控周期
	
	$("#updateAddressToTextarea").val("");//存放选中的风险地点，用于追加到文本框中 
	
	//为辨识风险信息id 隐藏域赋值  用于修改操作的
	/*var result= $(obj).attr("value");
	$("#updateriskmsgid").val(result);
	*/
	$("#updateriskmsgid").val($(obj).parents("tr").find("#myRiskInfoId").val());
	//添加管控计划id
	//$("#updateriskmsgid").val($("#myRictrlplanid"));
	
	//添加辨识id
	
	$("#updateidentiryid").val($(obj).parents("tr").find("#myIdentiryid").val());
}

//将选择风险地点的select下拉框选中的值追加到 风险地点文本框中
function updateselectchange(obj){
	var riskAddress = $("#updateriskAddressSelect option:selected").text();//选择风险地点的select下拉框
	
	var before = $("#updateAddressToTextarea").val();//之前的    隐藏域中的
	$("#updateAddressToTextarea").val(riskAddress);//将现在选中的添加
	if(before==""){
		var laterTextArea = $("#updateAddressToTextarea").val();
		$("#updateAddressToTextarea").val(laterTextArea);
		$("#updateriskaddress").val($("#updateAddressToTextarea").val());//添加到文本框中
	}else{
		var laterTextArea = $("#updateAddressToTextarea").val()+","+before;
		$("#updateAddressToTextarea").val(laterTextArea);
		$("#updateriskaddress").val($("#updateAddressToTextarea").val());//添加到文本框中
	}
}



//修改辨识风险信息的保存按钮的点击事件
function updateSave(){

	// 表单校验   
	var isNotNull = $("#updateForm").validate({
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

	// 如果通过表单校验，则执行修改辨识风险信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/identify_updateIdentifyRiskMsg.action",
			
			data : $("#updateForm").serialize(),
			success : function(data) {
				alert(data.result);
				$("#modifierDuty").modal("hide");
				//刷新数据
				window.location.reload();
			},
			error : function() {
				alert("修改失败，请重新修改！");
			}
		});
	}

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
function clearBtn(){
	$("#importRiskMiaoshu").val("");
	$("#importRiskAddress").val("");
	queryRisk();
}


