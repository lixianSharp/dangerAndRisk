
/*
 * 页面初始化
 */

$(function() {
	query();
});



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
		 * 判断状态
		 */
		var status=null;
		
		if(controlPlans[i].checkstatus!=null||controlPlans[i].reportstatus!=null){
			if(controlPlans[i].checkstatus=="1"&&controlPlans[i].reportstatus=="1"){
					status ="已审核";
			}
			if(controlPlans[i].checkstatus=="0"&&controlPlans[i].reportstatus=="1"){
				status="未审核";
			}
			
		}
		
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="1"){
			status ="已上报";
		}
		if(controlPlans[i].checkstatus==null&&controlPlans[i].reportstatus=="0"){
			status="未上报";
		}
		
		var str = "<tr><td>"
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
		
		
		
		
		
		//+controlPlans[i].reportstatus+"</td><td><a data-toggle='modal' data-target='#modifierDuty'>修改</a><a href='<%=path%>/risk/monthRiskControlPlanRisk.jsp'>详情</a></td></tr>";
		+status+"</td><td>"
		+"<a href='/danger/analysisPlan_toMonthRiskControlPlanAnalyzeInfo.action?method="+controlPlans[i].rictrlplanid+"'>详情</a></td></tr>";
	
		t_body.append(str);

	}

	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示
}








