//页面加载的时候要执行的方法
$(function() {
	findAllRiRespon();
});

// 新增职责按钮的点击事件
function addDutyBtn() {
	// 清空表单中的数据
	$("#addquarters").val("");// 岗位
	$("#addduty").val("");// 职责
	$("#addctrlcontent").val("");// 管控内容
	$("#addctrlfrequency").val("");// 管控频率
	$("#addanalysisfrequency").val("");// 风险分析频率
}

// 新增职责的保存按钮的点击事件
function addSave() {
	// 表单校验
	var isNotNull = $("#addForm").validate({
		ignore : [],
		rules : {
			"riResponsibility.quarters" : "required",// 岗位
			"riResponsibility.duty" : "required",// 职责
			"riResponsibility.ctrlcontent" : "required",// 管控内容
			"riResponsibility.ctrlfrequency" : "required",// 管控频率
			"riResponsibility.analysisfrequency" : "required", // 风险分析频率
		},
		messages : {
			"riResponsibility.quarters" : {// 岗位
				required : "不能为空"
			},
			"riResponsibility.duty" : {// 职责
				required : "不能为空"
			},
			"riResponsibility.ctrlcontent" : {// 管控内容
				required : "不能为空"
			},
			"riResponsibility.ctrlfrequency" : {// 管控频率
				required : "不能为空"
			},
			"riResponsibility.analysisfrequency" : {// 风险分析频率
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行新增职责操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "respon_addRiRespon.action",
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

// 修改-->打开修改的模态框
function updateOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的岗位职责id
	var respid= $(obj).siblings("input").val();
	$("#updaterespid").val(respid);
	
	var $td = $(obj).parents("tr").children("td");
	var quarters = $td.eq(1).text();//岗位
	var duty = $td.eq(2).text();//职责
	var ctrlcontent = $td.eq(3).text();//管控内容
	var ctrlfrequency = $td.eq(4).text();//管控频率
	var analysisfrequency = $td.eq(5).text();//风险分析频率
	
	//2.进行表单初始化
	$("#updatequarters").val(quarters);//岗位
	$("#updateduty").val(duty);//职责
	$("#updatectrlcontent").val(ctrlcontent);//管控内容
	$("#updatectrlfrequency").val(ctrlfrequency);//管控频率
	$("#updateanalysisfrequency").val(analysisfrequency);//风险分析频率
}

//修改
function updateBtn(){
	// 2.将修改后的数据进行保存
	// 表单校验
	var isNotNull = $("#updateForm").validate({
		ignore : [],
		rules : {
			"riResponsibility.quarters" : "required",// 岗位
			"riResponsibility.duty" : "required",// 职责
			"riResponsibility.ctrlcontent" : "required",// 管控内容
			"riResponsibility.ctrlfrequency" : "required",// 管控频率
			"riResponsibility.analysisfrequency" : "required", // 风险分析频率
		},
		messages : {
			"riResponsibility.quarters" : {// 岗位
				required : "不能为空"
			},
			"riResponsibility.duty" : {// 职责
				required : "不能为空"
			},
			"riResponsibility.ctrlcontent" : {// 管控内容
				required : "不能为空"
			},
			"riResponsibility.ctrlfrequency" : {// 管控频率
				required : "不能为空"
			},
			"riResponsibility.analysisfrequency" : {// 风险分析频率
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行修改职责操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "respon_updateRiRespon.action",
			data : $("#updateForm").serialize(),
			success : function(data) {
				alert(data.result);
				// 关闭修改模态框
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


// 删除 -》打开删除的模态框前要进行的
function delOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的岗位职责id
	var respid= $(obj).siblings("input").val();
	//隐藏当前选中要删除的那条岗位职责的id 
	$("#delrespid").val(respid);
}
//删除按钮的点击事件
function delBtn(){
	// 2.根据该隐藏的岗位职责id进行删除
	$.ajax({
		type : "post",
		dataType : "json",
		url : "respon_delRiRespon.action",
		data : {
			// 当前页页号 每页显示的记录数
			"respId" : $("#delrespid").val()
		},
		success : function(data) {
			alert(data.result);
			//关闭模态框
			$("#deleteDuty").modal("hide");
			//刷新数据
			findAllRiRespon();
		},
		error : function() {
			alert("添加失败，请重新添加！");
		}
	});
}

//修改
function updateBtn(){
	// 表单校验
	var isNotNull = $("#updateForm").validate({
		ignore : [],
		rules : {
			"riResponsibility.quarters" : "required",// 岗位
			"riResponsibility.duty" : "required",// 职责
			"riResponsibility.ctrlcontent" : "required",// 管控内容
			"riResponsibility.ctrlfrequency" : "required",// 管控频率
			"riResponsibility.analysisfrequency" : "required", // 风险分析频率
		},
		messages : {
			"riResponsibility.quarters" : {// 岗位
				required : "不能为空"
			},
			"riResponsibility.duty" : {// 职责
				required : "不能为空"
			},
			"riResponsibility.ctrlcontent" : {// 管控内容
				required : "不能为空"
			},
			"riResponsibility.ctrlfrequency" : {// 管控频率
				required : "不能为空"
			},
			"riResponsibility.analysisfrequency" : {// 风险分析频率
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行新增职责操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "respon_updateRiRespon.action",
			data : $("#updateForm").serialize(),
			success : function(data) {
				alert(data.result);
				$("#modifierDuty").modal("hide");
				//刷新数据
				findAllRiRespon();
			},
			error : function() {
				alert("添加失败，请重新添加！");
			}
		});
	}
	
}


// 查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "respon_findRiRespon.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val()
		// 每页显示的记录数
		},
		success : function(data) {
			
			//删除tbody中的所有子标签
			$("#tbody").children().remove();
			var options = "";
			for (var i = 0; i < data.riResponsibilityList.productList.length; i++) {
				var respid = data.riResponsibilityList.productList[i].respid;// 岗位职责id
				var quarters = data.riResponsibilityList.productList[i].quarters;// 岗位
				var duty = data.riResponsibilityList.productList[i].duty;// 职责
				var ctrlcontent = data.riResponsibilityList.productList[i].ctrlcontent;// 管控内容
				var ctrlfrequency = data.riResponsibilityList.productList[i].ctrlfrequency;// 管控频率
				var analysisfrequency = data.riResponsibilityList.productList[i].analysisfrequency;// 风险分析频率
				
				//开始拼接
				options += "<tr>";
			    //options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.riResponsibilityList.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+quarters+"</td>";
				options +="<td>"+duty+"</td>";
				options +="<td>"+ctrlcontent+"</td>";
				options +="<td>"+ctrlfrequency+"</td>";
				options +="<td>"+analysisfrequency+"</td>";
				options +="<td>" +"<input  type='hidden' value='"+respid+"'><a data-toggle='modal' data-target='#modifierDuty' href='#' onclick='updateOpenBtn(this)' >修改</a><a data-toggle='modal' data-target='#deleteDuty' href='#' onclick='delOpenBtn(this)'>删除</a></td>";
				options += "</tr>";
			}
			
			// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
			PagePilot(data.riResponsibilityList.currentPage, data.riResponsibilityList.currentCount, data.riResponsibilityList.totalCount)
			
			
			$("#tbody").append(options);
		},
		error : function() {
			alert("失败了！");
		}
	});
}

// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
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
