
$(function(){
	duoxuan();
});


function monthRiskControlPlanAnalyze(){
	var choosePlan = 0;// 判断是否有风险被选中

	var riskMsgIdArray = new Array();
	var indentiryIdArray = new Array();
	$(".planCheck").each(function() { // 获取选择的风险

		if ($(this).prop("checked")) {// 如果选中。。。
			choosePlan++;

		}
	})

	if (choosePlan >= 2) {
		
			
			$(".planCheck").each(function() { // 获取选择的风险

				if ($(this).prop("checked")) {// 如果选中。。。
				/*	$(this).parents('tr').find("#riskmsgid").val()
					$("#addRiskmsgid2").val($(this).parents('tr').find("#myriskmsgid").val());
					$("#addIdentiryid2").val($(this).parents('tr').find("#myrictrlplanid").val());*/
					$("#monthRiskControlPlanAnalyze2").modal();
	
					riskMsgIdArray.push($(this).parents('tr').find("#myriskmsgid").val());
					indentiryIdArray.push($(this).parents('tr').find("#myrictrlplanid").val());
					
				}
			})
			
			//将分析信息赋为空
			$("#addDutydepartment2").val("");
			$("#addImplementationofmeasures2").val("");
			$("#addMeasureisvalid2").val("");
			$("#addInspectionsituation2").val("");
			
			
			$("#addRiskmsgid2").val(JSON.stringify(riskMsgIdArray));
			$("#addIdentiryid2").val(JSON.stringify(indentiryIdArray));
			
			$("#monthRiskControlPlanAnalyze2").modal();
			
	}else if(choosePlan == 1){
		//$("#monthRiskControlPlanAnalyze1").modal();
		analyze1();
	} 
	
	else {
		alert("请先选择要分析的风险！")
	}
	
	
	
}





function analyze1(){

	//风险信息
	$tds = $("input[name='riskAna']:checked").parents('tr').find('td');
	
	//单条风险信息分析
	$("#addRiskmsgid1").val($("input[name='riskAna']:checked").parents('tr').find("#myriskmsgid").val());
	$("#addRiCtrlPlanId1").val($("input[name='riskAna']:checked").parents('tr').find("#myrictrlplanid").val());
	
	
	
	$("#riskaddress").html($tds.eq(2).html());
	$("#riskdescribe").html($tds.eq(3).html());
	$("#risktype").html($tds.eq(4).html());
	$("#professionaltypes").html($tds.eq(5).html());
	$("#ctrlmeasure").html($tds.eq(6).html());
	$("#principal").html($tds.eq(7).html());
	$("#superintendent").html($tds.eq(8).html());
	$("#monitoringperiod").html($tds.eq(9).html());
	
	//管控计划分析信息
	
	
	//将分析信息赋为空
	$("#addDutydepartment1").val("");
	$("#addImplementationofmeasures1").val("");
	$("#addMeasureisvalid1").val("");
	$("#addInspectionsituation1").val("");
	
	//打开模态框
	$("#monthRiskControlPlanAnalyze1").modal();
}



function addAnalysisRisk1(){
	
	
	var isNotNull = $("#addAnalysisPlanForm1").validate({
		rules : {
			"riDetailedOfRiskCtrlPlan.dutydepartment" : {
				required : true

			},
			"riDetailedOfRiskCtrlPlan.implementationofmeasures" : {
				required : true

			},
			"riDetailedOfRiskCtrlPlan.measureisvalid" : {
				required : true
			},
			"riDetailedOfRiskCtrlPlan.inspectionsituation" : {
				required : true
			}
		},
		messages : {
			"riDetailedOfRiskCtrlPlan.dutydepartment" : {
				required : " 请输入责任部门"
			},
		
			"riDetailedOfRiskCtrlPlan.implementationofmeasures" : {
				required : "请输入措施执行情况"
			},

			"riDetailedOfRiskCtrlPlan.measureisvalid" : {
				required : "请选择措施是否有效"
			},
			"riDetailedOfRiskCtrlPlan.inspectionsituation" : {
				required : " 请输入考核情况"
			}
			
		
		}

	});

	if (isNotNull.form()) {
	$.ajax({
		url : 'analysisPlan_addControlPlanAnalysis.action',
		data : $("#addAnalysisPlanForm1").serialize(),
		type : 'POST',
		dataType : 'json',
		async : true,
		success : function(result) {
			// 弹出是否录入成功
			alert(result.message);
			$('#monthRiskControlPlanAnalyze1').modal('hide');
			// 全局刷新当前页面
			window.location.reload();

		}

	});
}

}

function addAnalysisRisk2(){
	
	

	var isNotNull = $("#addAnalysisPlanForm1").validate({
		rules : {
			"riDetailedOfRiskCtrlPlan.dutydepartment" : {
				required : true

			},
			"riDetailedOfRiskCtrlPlan.implementationofmeasures" : {
				required : true

			},
			"riDetailedOfRiskCtrlPlan.measureisvalid" : {
				required : true
			},
			"riDetailedOfRiskCtrlPlan.inspectionsituation" : {
				required : true
			}
		},
		messages : {
			"riDetailedOfRiskCtrlPlan.dutydepartment" : {
				required : " 请输入责任部门"
			},
		
			"riDetailedOfRiskCtrlPlan.implementationofmeasures" : {
				required : "请输入措施执行情况"
			},

			"riDetailedOfRiskCtrlPlan.measureisvalid" : {
				required : "请选择措施是否有效"
			},
			"riDetailedOfRiskCtrlPlan.inspectionsituation" : {
				required : " 请输入考核情况"
			}
			
		
		}

	});

	if (isNotNull.form()) {
	$.ajax({
		url : 'analysisPlan_addControlPlanAnalysis2.action',
		data : $("#addAnalysisPlanForm2").serialize(),
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


	
function duoxuan(){
	// 全选和全不选操作
	$("#selectAllId").change(function() {
		if ($(this).prop("checked") == true) {
			$("input[name='riskAna']").prop("checked", "true");
		} else {
			$("input[name='riskAna']").removeAttr("checked");
		}
	})
	
}




