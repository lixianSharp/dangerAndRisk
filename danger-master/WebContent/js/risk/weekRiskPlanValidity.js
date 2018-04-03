
/*
 * 页面初始化
 */

$(function() {
	query();
	selectProfessionalTypes();
	
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
		url : 'validPlan_getWeekAllVaildPlanInfo.action',
		data : $("#queryForm").serialize(),
		type : 'POST',
		dataType : 'json',
		async : true,
		success : successList,

	});

}

var successList = function List(result) {
	
	//得到数据
	var valids = result.pageBean.productList;
	
	var riskCounts = result.riskCountList;
	
	var validCounts = result.validCountList;
	var address = result.addressList;
	
	$("#tbody").html("");// 清空表体
	// 获取到这个表格
	var t_body = $("#tbody");
	// 循环添加每一行
	for (var i = 0; i < valids.length; i++) {
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
		
		var xunqi;
		//显示旬期
		
		if(valids[i].monthorweek=="1"){
			xunqi="上旬";
		}else if(valids[i].monthorweek=="2"){
			xunqi="中旬";
		}else if(valids[i].monthorweek=="3"){
			xunqi="下旬";
		}
		
		
		var str = "<tr><td>"
			+index+"</td><td>"
			+valids[i].year+"</td><td>"
			+xunqi+"</td><td>"+riskrange+"</td><td>"
			+valids[i].specialty+"</td><td>"
			+valids[i].leader+"</td><td>"
			
			+Format(new Date(valids[i].createtime.replace(/T/g, " ").replace(
					/-/g, "/")), "yyyy-MM-dd HH:ss")+"</td><td>"
					
			+"<input type='hidden' id='controlPlansid' value='"+valids[i].rictrlplanid+"'>"
			+riskCounts[i]+"</td><td>"
			+"<a href='/danger/validPlan_toLosePlanDis.action?method="+valids[i].rictrlplanid+"'>"+validCounts[i]+"</a></td></tr>";
			//+"</td></tr>";
		
		
		t_body.append(str);

	}

	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示

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



