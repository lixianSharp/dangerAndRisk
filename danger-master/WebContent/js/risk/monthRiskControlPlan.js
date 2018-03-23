
/*
 * 页面初始化
 */

$(function() {
	query();
});



/**
 * 添加管控计划
 */
function saveControlPlanButton() {
/*	
	var isNotNull = $("#addControlPlanForm").validate({
		rules : {
			"month" : {
				required : true

			},
			"specialty" : {
				required : true

			},
			"leader" : {
				required : true
			}
		},
		messages : {
			"month" : {
				required : "请输入日期"
			},
		
			"specialty" : {
				required : "请输入专业名称"
			},

			"leader" : {
				required : "请输入专业负责人"
			}
		
		}

	});

	if (isNotNull.form()) {*/
		$.ajax({
			url : 'controlPlan_addControlPlan.action',
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
		url : 'controlPlan_getAllControlPlan.action',
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
				var shenhe ="["+time+"]:"+shenhes[i][j].auditmsg+","+shenhes[i][j].auditstatus+"!</br>";
				
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
		
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="1"){
			status ="已上报";
		}
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="0"){
			status="未上报";
		}
		
		var str = "<tr><td><input type='checkbox' name='riskAna'></td><td>"
		+index+"</td><td>"
		+controlPlans[i].year+"</td><td>"
		+controlPlans[i].monthorweek+"</td><td>"+riskrange+"</td><td>"
		+ricontrolPlans[i]+"</td><td>"
		+controlPlans[i].specialty+"</td><td>"
		+controlPlans[i].leader+"</td><td>"
		//+controlPlans[i].createtime+"</td><td>"
		+Format(new Date(controlPlans[i].createtime.replace(/T/g, " ").replace(
				/-/g, "/")), "yyyy-MM-dd HH:ss")+"</td><td>"
				
		+"<input type='hidden' id='controlPlansid' value='"+controlPlans[i].rictrlplanid+"'>"
		
		
		+checkstatus+"</td><td>"
		
		
		//+controlPlans[i].reportstatus+"</td><td><a data-toggle='modal' data-target='#modifierDuty'>修改</a><a href='<%=path%>/risk/monthRiskControlPlanRisk.jsp'>详情</a></td></tr>";
		+status+"</td><td><a data-toggle='modal' onclick='updateControlPlan(this)'>修改</a>" 
		+"<a href='/danger/controlPlanDetail_toControlPlanDetail.action?method="+controlPlans[i].rictrlplanid+"'>详情</a></td></tr>";
	
		t_body.append(str);

	}

	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示

}


/*
 * 修改管控计划
 */

function updateControlPlan(obj){
	//一条管控计划的id
	var controlPlansid = $(obj).parents("tr").find("#controlPlansid").val();
	$("#updateControlPlanId").val(controlPlansid);
	
	//管控计划的数据
	$tds = $(obj).parents('tr').children('td');
	$("#optsdate666").val($tds.eq(2).html()+"-"+$tds.eq(3).html())
	$("#updateControlPlanSpecialty").val($tds.eq(6).html());
	$("#updateControlPlanLeader").val($tds.eq(7).html());
	
	// 弹出模态框
	$('#modifierDuty').modal();
}


function updateControlPlanButton(){
	
	
	$.ajax({
		url : 'controlPlan_updateControlPlan.action',
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

/*
 * 计划上报
 */
function planReport(){
	var controlPlansid = $("input[name='riskAna']:checked").parents('tr').find("#controlPlansid").val();
	
	var $tds = $("input[name='riskAna']:checked").parents('tr').find('td');
	var status = $tds.eq(10).html();
	if(status=="未上报"){
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
	}else{
		alert("该管控计划已经上报，请开始审核");
	}
	
	
}

/*
 * 审核管控计划
 */

//获取到历史审核备注信息
function riskCheck(){
	
	$tds = $("input[name='riskAna']:checked").parents('tr').find('td');
	$("#historyAuditmsg").val($tds.eq(9).html());
	
	//隐藏一个管控计划id
	var controlPlansid = $("input[name='riskAna']:checked").parents('tr').find("#controlPlansid").val();
	$("#shenHeRictrlplanId").val(controlPlansid);
	
	//判断是否已经上报
	var idReport =$tds.eq(10).html();
	if(idReport=="未上报"){
		alert("上报之后才可以审核，请您现上报");
	}else{
		$('#riskCheck').modal();
	}
	
	
}

function saveAuditButton(){
	//alert($("#shenHeRictrlplanId").val());
	
	
	
	
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


