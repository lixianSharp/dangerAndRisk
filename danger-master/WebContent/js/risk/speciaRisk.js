$(function(){
	initWorkFace();//工作面
	initRiType();//风险类型
	initRiProfessionType();//专业类型(隐患类型)
	initRiDisasterType();//灾害类型
	initCanCauseAccidentType();//可能导致事故
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

			$("#updateriskAddressSelect option").remove();//修改模态框中的
				
			var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
			for(var i=0;i<data.riIdentificationRangeList.length;i++){
				str +="<option value="+data.riIdentificationRangeList[i].facename+">"+data.riIdentificationRangeList[i].facename+"</option>";
			}
			
			$("#addriskAddressSelect").append(str);

			$("#updateriskAddressSelect").append(str);
		
			//刷新数据
			//findAllRiRespon();
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

	// 如果通过表单校验，则执行新增专项辨识信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/identify_addIdentifyRiskMsgS.action",
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



//修改
//打开修改模态框之前要进行的操作
function updateOpenBtn(obj){
	var address = $(obj).parents("tr").children("td").eq(1).text();//风险地点
	var describe = $(obj).parents("tr").children("td").eq(2).text();//风险描述
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
	var result= $(obj).attr("value");
	$("#updateriskmsgid").val(result);
}

////将选择风险地点的select下拉框选中的值追加到 风险地点文本框中
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
			url : "${pageContext.request.contextPath}/identify_updateIdentifyRiskMsgS.action",
			data : $("#updateForm").serialize(),
			success : function(data) {
				alert(data.result);
				$("#modifierDuty").modal("hide");
				//刷新数据
				findAllRiRespon();
			},
			error : function() {
				alert("修改失败，请重新修改！");
			}
		});
	}

}



//删除  打开删除的模态框
function delOpenBtn(obj){
	//为辨识风险信息id 隐藏域赋值  用于修改操作的
	var result= $(obj).attr("value");
	$("#delriskmsgid").val(result);
}
//确认删除按钮的点击事件
function deleteBtn(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/identify_delIdentifyRiskMsgS.action",
		data : {"riskMsgId":$("#delriskmsgid").val()},
		success : function(data) {
			alert(data.result);
			$("#deleteRisk").modal("hide");
			//刷新数据
			findAllRiRespon();
		},
		error : function() {
			alert("删除失败，请重新删除！");
		}
	});
}




//查询  分页
//查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/identify_findIdentifyByConditionS.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"identiryid":$("#addidentiryid").val()//风险辨识主表id
		// 每页显示的记录数
		},
		success : function(data) {
			
			//删除tbody中的所有子标签
			$("#tbody").children().remove();
			var options = "";
			for (var i = 0; i < data.pageBean.productList.length; i++) {
				var riskaddress = data.pageBean.productList[i].riskaddress;
				var riskdescribe = data.pageBean.productList[i].riskdescribe;
				var risktype = data.pageBean.productList[i].risktype;
				var professionaltypes = data.pageBean.productList[i].professionaltypes;
				var disastertypes = data.pageBean.productList[i].disastertypes;
				
				var cancauseaccidents = data.pageBean.productList[i].cancauseaccidents;
				var ctrlmeasure = data.pageBean.productList[i].ctrlmeasure;
				var principal = data.pageBean.productList[i].principal;
				var superintendent = data.pageBean.productList[i].superintendent;
				var monitoringperiod = data.pageBean.productList[i].monitoringperiod;
				var evaluationstatus = data.pageBean.productList[i].evaluationstatus;
				if(evaluationstatus=="N"){
					evaluationstatus = "未评估";
				}else if(evaluationstatus=="Y"){
					evaluationstatus = "已评估";
				}
				
				
				var riskmsgid = data.pageBean.productList[i].riskmsgid;//辨识风险信息id
				var identiryid = data.pageBean.productList[i].identiryid;//风险辨识主表id
				//开始拼接
				options += "<tr>";
			    //options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+riskaddress+"</td>";//风险地点
				options +="<td>"+riskdescribe+"</td>";//风险描述
				options +="<td>"+risktype+"</td>";//风险类型
				options +="<td>"+professionaltypes+"</td>";//专业类型
				options +="<td>"+disastertypes+"</td>";//灾害类型
				
				options +="<td>"+cancauseaccidents+"</td>";//可能导致事故
				options +="<td>"+ctrlmeasure+"</td>";//管控措施
				options +="<td>"+principal+"</td>";//负责人
				options +="<td>"+superintendent+"</td>";//监管人
				options +="<td>"+monitoringperiod+"</td>";//监管周期
				options +="<td>"+evaluationstatus+"</td>";//评估状态
				options +="<td><a data-toggle='modal' data-target='#modifierDuty' onclick='updateOpenBtn(this)' value='"+riskmsgid+"'>修改</a><a data-toggle='modal' data-target='#deleteRisk' onclick='delOpenBtn(this)' value='"+riskmsgid+"'>删除</a></td>";
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





