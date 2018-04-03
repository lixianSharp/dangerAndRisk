
/*
 * 页面初始化
 */

$(function() {
	query();
	initRiProfessionType();
	selectProfessionalTypes();
});

function addWeekControlPlan(){
	
	$("#optsdate66").val("");
	$("#addControlPlanSpecialty").val("");
	$("#addControlPlanLeader").val("");
	$("#addxunqi").val("");
	$('#addDuty').modal();
}

/**
 * 添加管控计划
 */
function saveControlPlanButton() {

	var isNotNull = $("#addControlPlanForm").validate({
		rules : {
			"ricontrolPlan.year":{
				required : true
			},
			"ricontrolPlan.monthorweek" : {
				required : true

			},
			"ricontrolPlan.specialty" : {
				required : true

			},
			"ricontrolPlan.leader" : {
				required : true
			}
		},
		messages : {
			"ricontrolPlan.year":{
				required : "请输入月份"
			},
			"ricontrolPlan.monthorweek" : {
				required : "请输入旬期"
			},
		
			"ricontrolPlan.specialty" : {
				required : "请输入专业名称"
			},

			"ricontrolPlan.leader" : {
				required : "请输入专业负责人"
			}
		
		}

	});

	if (isNotNull.form()) {
		$.ajax({
			url : 'controlPlan_addWeekControlPlan.action',
			data : $("#addControlPlanForm").serialize(),
			type : 'POST',
			dataType : 'json',
			async : true,
			success : function(result) {
				// 弹出是否录入成功
				alert(result.message);
				$('#myModal').modal('hide');
				// 全局刷新当前页面
				window.location.reload();

			}
		});
	//}
	}
}



//分页查询管控计划


/*********************分页*****************************/

function fenye(total, pageSize, pageNumber) {
	// alert(total+" "+pageSize)
	$('#paginationIDU').pagination(
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
					$("#currentPage").val(pageNumber);
					$("#currentCount").val(b);
					query();
				}
			});
}

//条件查询

function queryButton() {
	$("#currentPage").val("1");
	query();
}

function query() {

	$.ajax({
		url : 'controlPlan_getAllWeekControlPlan.action',
		data : $("#queryForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async : true,
		success : successList,

	});

}

var successList = function List(result) {
	
	//得到数据
	var controlPlans = result.pageBean.productList;
	var ricontrolPlans = result.riskCountList;
	var shenhes = result.shenheList;
	var address = result.addressList;
	
	
	//alert(address)
	
	$("#tbody").html("");// 清空表体
	// 获取到这个表格
	var t_body = $("#tbody");
	// 循环添加每一行
	for (var i = 0; i < controlPlans.length; i++) {
		var index =i+1;
		var checkstatus=null;
		var riskrange=null;
		
		
		/*
		 * 风险辨识范围
		 */
		if(address[i]!=""){
			for(var j=0;j<address[i].length;j++){
				if(riskrange!=null){
					
					riskrange=riskrange+address[i][j]+"</br>";
				}else{
					riskrange=address[i][j]+"</br>";
				}
			}
		}else{
			riskrange="无"
		}
		
		/*
		 * 审核信息
		 */
		if (shenhes[i]!="") {
			
			//for(var j=shenhes[i].length-1;j=0;j--){
			for(var j=0;j<shenhes[i].length;j++){
				
				var time=Format(new Date(shenhes[i][j].audittime.replace(/T/g, " ").replace(
						/-/g, "/")), "yyyy-MM-dd HH:ss")
				//var shenhe ="["+time+"]:"+shenhes[i][j].auditmsg+","+shenhes[i][j].auditstatus+"!</br>";
				var shenhe ="["+time+"]:"+shenhes[i][j].auditmsg+"!</br>";
				
				if(checkstatus!=null){
					checkstatus=checkstatus+shenhe;
				}else{
					checkstatus=shenhe;
				}
				
			}
			
		}else{
			checkstatus = "无";
		}
		/*
		 * 判断状态
		 */
		var status=null;
		
		if(controlPlans[i].checkstatus!=null||controlPlans[i].reportstatus!=null){
			if(controlPlans[i].checkstatus=="1"&&controlPlans[i].reportstatus=="1"){
					status ="通过审核";
			}
			if(controlPlans[i].checkstatus=="0"&&controlPlans[i].reportstatus=="1"){
				status="未通过审核";
			}
			
		}
		//controlPlans[i].checkstatus==null&&
		if(controlPlans[i].checkstatus==""&&controlPlans[i].reportstatus=="1"){
			status ="已上报";
		}
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="1"){
			status ="已上报";
		}
		
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="0"){
			status="未上报";
		}
		
		var xunqi;
		//显示旬期
		if(controlPlans[i].monthorweek=="1"){
			xunqi="上旬";
		}else if(controlPlans[i].monthorweek=="2"){
			xunqi="中旬";
		}else if(controlPlans[i].monthorweek=="3"){
			xunqi="下旬";
		}
		
		
		
		var str = "<tr><td><input type='checkbox' name='riskAna' class='planCheck'></td><td>"
			+index+"</td><td>"
			+controlPlans[i].year+"</td><td>"
			+xunqi+"</td><td>"+riskrange+"</td><td>"
			+ricontrolPlans[i]+"</td><td>"
			+controlPlans[i].specialty+"</td><td>"
			+controlPlans[i].leader+"</td><td>"
			+"<input type='hidden' id='controlPlansid' value='"+controlPlans[i].rictrlplanid+"'>"
			//+controlPlans[i].createtime+"</td><td>"
			+Format(new Date(controlPlans[i].createtime.replace(/T/g, " ").replace(
					/-/g, "/")), "yyyy-MM-dd HH:ss")+"</td><td>"
					
		
			
			
			+checkstatus+"</td><td>"
			
			
			//+controlPlans[i].reportstatus+"</td><td><a data-toggle='modal' data-target='#modifierDuty'>修改</a><a href='<%=path%>/risk/monthRiskControlPlanRisk.jsp'>详情</a></td></tr>";
			+status+"</td><td><a data-toggle='modal' onclick='updateControlPlan(this)'>修改</a>" 
			//+"<a href='/danger/controlPlanDetail_toControlPlanDetail.action?method="+controlPlans[i].rictrlplanid+"'>详情</a></td></tr>";
			+"<a href='/danger/controlPlanDetail_toWeekControlPlanDetail.action?method="+controlPlans[i].rictrlplanid+"'>详情</a></td></tr>";
			t_body.append(str);

	}

	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示

}


/*
 * 修改管控计划
 */

function updateControlPlan(obj){
	
	$tds = $(obj).parents('tr').children('td');
	
	var status = $tds.eq(10).html();
	if(status=="未上报"||status=="未通过审核"){
	
	
		//一条管控计划的id
		var controlPlansid = $(obj).parents("tr").find("#controlPlansid").val();
		$("#updateControlPlanId").val(controlPlansid);
		
		//管控计划的数据
		$tds = $(obj).parents('tr').children('td');
		$("#optsdate666").val($tds.eq(2).html());
		var i;
		if($tds.eq(3).html()=="上旬"){
			i=1;
		}
		if($tds.eq(3).html()=="中旬"){
			i=2;
		}
		if($tds.eq(3).html()=="下旬"){
			i=3;
		}
		$("select[name='ricontrolPlan.monthorweek'] option[value='"+i+"']").attr("selected", true).prop("selected", true); 
		//$("#updateWeek").val(1);
		$("select[name='ricontrolPlan.specialty'] option[value='"+$tds.eq(6).html()+"']").attr("selected", true).prop("selected", true); 
		//$("#updateControlPlanSpecialty").val($tds.eq(6).html());
		$("#updateControlPlanLeader").val($tds.eq(7).html());
		
		// 弹出模态框
		$('#modifierDuty').modal();
	}else{
		alert("已经上报的管控计划不能进行修改");
	}
}


function updateControlPlanButton(){

	var isNotNull = $("#updateControlPlanForm").validate({
		rules : {
			"ricontrolPlan.year":{
				required : true
			},
			"ricontrolPlan.monthorweek" : {
				required : true

			},
			"ricontrolPlan.specialty" : {
				required : true

			},
			"ricontrolPlan.leader" : {
				required : true
			}
		},
		messages : {
			"ricontrolPlan.year":{
				required : "请输入月份"
			},
			"ricontrolPlan.monthorweek" : {
				required : "请输入旬期"
			},
		
			"ricontrolPlan.specialty" : {
				required : "请输入专业名称"
			},

			"ricontrolPlan.leader" : {
				required : "请输入专业负责人"
			}
		
		}

	});

	if (isNotNull.form()) {
	$.ajax({
		url : 'controlPlan_updateWeekControlPlan.action',
		data : $("#updateControlPlanForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {
			// 弹出是否录入成功
			alert(result.message);
			$('#myModal').modal('hide');
			// 全局刷新当前页面
			window.location.reload();

		}

	});
	}
}

/*
 * 计划上报
 */
function planReport(){
	
	var count=0;
	$(".planCheck").each(function() { // 获取选择的风险
		
		
		if ($(this).prop("checked")) {// 如果选中。。。
			
			count++;
		}
			
		})
		
	if(count==1){
		
		var $tds = $("input[name='riskAna']:checked").parents('tr').find("td");
		
		var isAddRisk = $tds.eq(5).html();
		if(isAddRisk==0){
			alert("该管控计划还没有风险信息，请您先添加需要管控的风险信息");
		}else{
			
		var controlPlansid = $("input[name='riskAna']:checked").parents('tr').find("#controlPlansid").val();
		
		var $tds = $("input[name='riskAna']:checked").parents('tr').find('td');
		var status = $tds.eq(10).html();

		//if(status=="未上报"||status=="审核不通过"){
		if(status=="通过审核"){
			
			alert("该管控计划已经通过审核，不能上报")
		}else{
			
			if(status=="已上报"){
				alert("该管控计划已经上报，不可以再次上报");
			}else{
				
			
				$.ajax({
					url : 'controlPlan_reportPlan.action',
					data : {
						"controlPlansid":controlPlansid
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
		}
		
	}
	}else if(count==0){
		alert("请先选择一条月管控记录");
	}
	
	
	
	
}



/*
 * 审核管控计划
 */

//获取到历史审核备注信息
//获取到历史审核备注信息
function riskCheck(){
	
	var count=0;
	
	$(".planCheck").each(function() { // 获取选择的风险
		
		
		if ($(this).prop("checked")) {// 如果选中。。。
			count++;
		}
			
	})
	if(count==1){
		
		   $("#benciAuditmsg").val("");
		   // $("input[name='riRiskPlanAudit.auditstatus'][value='通过审核']").attr("checked","checked");
			$("input[name='riRiskPlanAudit.auditstatus'][value='通过审核']").prop( "checked", true );
			
			$tds = $("input[name='riskAna']:checked").parents('tr').find('td');
			
			//eval("("+$tds.eq(9).html()+")")
			$("#historyAuditmsg").val($tds.eq(9).text().replace(/<br>/g, '\n'));
			if($("#historyAuditmsg").val()=="无"){
				$("#history").hide();
			}
			
			//隐藏一个管控计划id
			var controlPlansid = $("input[name='riskAna']:checked").parents('tr').find("#controlPlansid").val();
			$("#shenHeRictrlplanId").val(controlPlansid);
			
			//判断是否已经上报
			var idReport =$tds.eq(10).text();
			//alert(idReport)
			if(idReport=="未上报"){
				alert("上报之后才可以审核，请您先上报");
			}else if(idReport=="已上报"){ //if(idReport!="通过审核"&&idReport=="未通过审核"){
					$('#riskCheck').modal();
			}else if(idReport=="通过审核"){
					alert("审核已经通过，不能再次审核");
			}else if(idReport=="未通过审核"){
				    alert("未通过审核，请重新上报再审核");
			}
			
			
	}else /*if(count==0)*/{
		alert("请先选择一条月管控记录");
	}
	
	
	
}
/*function riskCheck(){
	
	var count=0;
	$(".planCheck").each(function() { // 获取选择的风险
		
		
		if ($(this).prop("checked")) {// 如果选中。。。
			
			count++;
		}
			
		})
	
	if(count==1){
		$("#benciAuditmsg").val("");
		
		   // $("input[name='riRiskPlanAudit.auditstatus'][value='通过审核']").attr("checked","checked");
			$("input[name='riRiskPlanAudit.auditstatus'][value='通过审核']").prop( "checked", true );
			
			$tds = $("input[name='riskAna']:checked").parents('tr').find('td');
			eval("("+$tds.eq(9).html()+")")
			
			$("#historyAuditmsg").val($tds.eq(9).text().replace(/<br>/g, '\n'));
			
			if($("#historyAuditmsg").val()=="无"){
				$("#history").hide();
			}
			
			//隐藏一个管控计划id
			var controlPlansid = $("input[name='riskAna']:checked").parents('tr').find("#controlPlansid").val();
			$("#shenHeRictrlplanId").val(controlPlansid);
			
			//判断是否已经上报
			var idReport =$tds.eq(10).html();
			if(idReport=="未上报"){
				alert("上报之后才可以审核，请您先上报");
			}else{
				if(idReport=="通过审核"){
					alert("审核已经通过，不能再次审核")
				}
				
				if(idReport=="未通过审核"){
					alert("未通过审核，请重新上报再审核")
				}
				
				if(idReport!="通过审核"&&idReport=="未通过审核"){
					$('#riskCheck').modal();
				}
				
				
				
				
			}
			
	}else if(count==0){
		alert("请先选择一条月管控记录");
	}
	
	
	
}*/

function saveAuditButton(){
	
	
	var isNotNull = $("#queryAuditForm").validate({
		rules : {
			"riRiskPlanAudit.auditmsg" : {
				required : true

			}
		},
		messages : {
			"riRiskPlanAudit.auditmsg" : {
				required : "请输入本次审核备注信息"
			}
		
		}

	});

	if (isNotNull.form()) {
	
	$.ajax({
		url : 'controlPlan_auditPlan.action',
		data : $("#queryAuditForm").serialize(),
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

