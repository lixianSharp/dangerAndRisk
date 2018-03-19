$(function(){
	findAllRiRespon();
})

//打开新增模态框之前要进行的操作
function addOpenBtn(){
	//初始化表单(清空表单)
	$("#optsdate5").val("");//年份
	$("#addmeetingaddress").val("");//会议地点
	$("#addcompere").val("");//主持人
	$("#addrecorder").val("");//记录人
	$("#addparticipants").val("");//参会人员
	$("#addmeetingcontent").val("");//会议内容
}

//增加专项辨识的保存按钮的点击事件
function addSave(){
	$("#strTime").val($("#optsdate5").val());//将年度保存在对应的隐藏域中
	// 表单校验   
	var isNotNull = $("#addForm").validate({
		ignore : [],
		rules : {
			"yearDate" : "required",// 年份
			"identify.meetingaddress" : "required",// 会议地点
			"identify.compere" : "required",//主持人
			"identify.recorder" :"required",// 记录人
			"identify.participants":"required",//参会人员	
			"identify.meetingcontent":"required"//会议内容
		},
		
		messages : {
			"yearDate" : {// 年份
				required : "不能为空"
			},
			"identify.meetingaddress" : {// 会议地点
				required : "不能为空"
			},
			"identify.compere" : {// 主持人
				required : "不能为空"
			},
			"identify.recorder" : {// 记录人
				required : "不能为空"
			},
			"identify.participants" : {// 参会人员
				required : "不能为空"
			},
			"identify.meetingcontent":{//会议内容
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行新增专项辨识信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/identify_addRiIdentificationMainTableS.action",
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


//打开修改按钮的模态框
function updateOpenBtn(obj){
	//初始化表单
	// 1。获取到当前选中的隐藏的专项辨识id
	var idenranid= $(obj).siblings("input").val();
	$("#updateidenranid").val(idenranid);
	var $td = $(obj).parents("tr").children("td");
	var year = $td.eq(2).text();//年份
	var meetingaddress = $td.eq(4).text();//会议地点
	var compere = $td.eq(5).text();//主持人
	var recorder = $td.eq(6).text();//记录人
	var participants = $td.eq(7).text();//参会人员
	var meetingcontent = $td.eq(8).text();//会议内容
	
	$("#updatestrTime").val(year);//将年度保存在对应的隐藏域中
	
	$("#optsdate55").val(year);//年份
	$("#updatemeetingaddress").val(meetingaddress);//会议地点
	$("#updatecompere").val(compere);//主持人
	$("#updaterecorder").val(recorder);//记录人
	$("#updateparticipants").val(participants);//参会人员
	$("#updatemeetingcontent").val(meetingcontent);//会议内容
}

//确认修改按钮的点击事件
function updateBtn(){
	$("#updatestrTime").val($("#optsdate55").val());//将年度保存在对应的隐藏域中
	// 表单校验   
	var isNotNull = $("#updateForm").validate({
		ignore : [],
		rules : {
			"updateYearDate" : "required",// 年份
			"identify.meetingaddress" : "required",// 会议地点
			"identify.compere" : "required",//主持人
			"identify.recorder" :"required",// 记录人
			"identify.participants":"required",//参会人员	
			"identify.meetingcontent":"required"//会议内容
		},
		
		messages : {
			"updateYearDate" : {// 年份
				required : "不能为空"
			},
			"identify.meetingaddress" : {// 会议地点
				required : "不能为空"
			},
			"identify.compere" : {// 主持人
				required : "不能为空"
			},
			"identify.recorder" : {// 记录人
				required : "不能为空"
			},
			"identify.participants" : {// 参会人员
				required : "不能为空"
			},
			"identify.meetingcontent":{//会议内容
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行修改专项辨识信息操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "${pageContext.request.contextPath}/identify_updateRiIdentificationMainTableS.action",
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







//查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "identify_findRiIdentificationMainTableByConditionS.action",
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
			for (var i = 0; i < data.resultMapList.length; i++) {
				var identiryid = data.resultMapList[i].identiryId;//辨识信息id
				var year = data.resultMapList[i].year;// 专项
				var meetingaddress = data.resultMapList[i].meetingAddress;//会议地点
				var compere = data.resultMapList[i].compere;// 主持人
				var recorder = data.resultMapList[i].recorder;// 记录人
				var participants = data.resultMapList[i].participants;//参会人员
				var meetingcontent = data.resultMapList[i].meetingContent;//会议内容
				var identifymark = data.resultMapList[i].identifyMark;//标记(Y/S 专项/专项)
				var createtime = data.resultMapList[i].createTime;//创建时间
				var riskmsgcount = data.resultMapList[i].riskmsgcount;//辨识风险信息数量
				
				var yearDealWith =/\d{4}/g.exec(year);//让年度的显示只显示年份
				
				//开始拼接
				options += "<tr>";
			    options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+yearDealWith+"</td>";//年份
				options +="<td>"+riskmsgcount+"</td>";//该专项辨识对应的辨识风险信息数量
				//options +="<td>"+"未评估"+"</td>";
				options +="<td>"+meetingaddress+"</td>";//会议地点
				options +="<td>"+compere+"</td>";//主持人
				options +="<td>"+recorder+"</td>";//记录人
				options +="<td>"+participants+"</td>";//参会人员
				options +="<td>"+meetingcontent+"</td>";//会议内容
				options +="<td>" +"<input  type='hidden' value='"+identiryid+"'><a data-toggle='modal' data-target='#modifierDuty' onclick='updateOpenBtn(this)' >修改</a><a href='#' onclick='detailYRecognize(this) '>详情</a></td>";
				options += "</tr>";
			}
		
			// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
			PagePilot(data.currentPage, data.currentCount, data.totalCount);
			
			
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




//详情
function detailYRecognize(obj){
	// 1。获取到当前选中的隐藏的专项辨识id
	var idenranid= $(obj).siblings("input").val();
	
	//为form表单的input隐藏域赋值
	$("#detailidenranid").val(idenranid);
	$("#detailForm").submit();//提交form表单
}






