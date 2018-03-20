//页面加载的时候要执行的方法
$(function() {
	findAllRiRespon();//查询
	initTypeAdd();//增加模态框的
});

//初始化类型的下拉框  增加模态框的
function initTypeAdd(){
	$.ajax({
		url:'initDic_initRiIdentifyRangeType.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#addrirtype option").remove();//新增模态框中的
			
			$("#updaterirtype option").remove();//修改模态框中的
			
			var str = "<option value=''>--请选择--</option>";//<option value="综采">综采</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#addrirtype").append(str);
			
			$("#updaterirtype").append(str);
		}
	});
}



//新增按钮点击事件
function addOpenBtn(){
	//清空表单
	// 清空表单中的数据
	$("#addfacename").val("");// 工作面名称
	$("#addsurvey").val("");// 概况
	$("#addrirtype").val("");// 类型
	$("#optsdate2").val("");// 开始时间
	$("#optsdate22").val("");// 结束时间
	
}

//比较开始和结束时间  开始时间不能大于结束时间
function compareTime(startTime,endTime){
	    
	 var d1 = new Date(startTime.replace(/\-/g, "\/"));    
	 var d2 = new Date(endTime.replace(/\-/g, "\/"));    
	    
	  if(startTime!=""&&endTime!=""&&d1 >d2)    {    
		  alert("开始时间不能大于结束时间！");    
		  return false;    
	  } else{
		  //开始时间小于结束时间  正确的 可以进行操作
		 //alert("时间正确");
		  return true;
	  } 
}


//增加风险辨识范围的保存按钮的点击事件
function addSave(){
	var flag=compareTime($("#optsdate2").val(),$("#optsdate22").val());
	if(flag){
		//表示开始时间 <= 结束时间  可以进行表单提交
		// 表单校验   
		var isNotNull = $("#addForm").validate({
			ignore : [],
			rules : {
				"riIdentificationRange.facename" : "required",// 工作面名称
				"riIdentificationRange.survey" : "required",// 概况
				"riIdentificationRange.rirtype" : "required",// 类型
				"riIdentificationRange.starttime" :{// 开始时间
					required:true,
				},
				"riIdentificationRange.endtime" : {// 结束时间
					required:true,
				}
			},
			messages : {
				"riIdentificationRange.facename" : {// 工作面名称
					required : "不能为空"
				},
				"riIdentificationRange.survey" : {// 概况
					required : "不能为空"
				},
				"riIdentificationRange.rirtype" : {// 类型
					required : "不能为空"
				},
				"riIdentificationRange.starttime" : {// 开始时间
					required : "不能为空",
				},
				"riIdentificationRange.endtime" : {// 结束时间
					required : "不能为空",
				}
			}
		});

		// 如果通过表单校验，则执行新增风险辨识范围信息操作
		if (isNotNull.form()) {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "identificationRange_addRiIdentificationRange.action",
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
		}//第二个if的括号
	}else{//与最大的if配对的else
		//表示 开始时间 > 结束时间 不可以进行表单提交
		
	}//else的括号
	
	

}


//修改
//修改-->打开修改的模态框
function updateOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的岗位职责id
	var idenranid= $(obj).siblings("input").val();
	$("#updateidenranid").val(idenranid);
	
	var $td = $(obj).parents("tr").children("td");
	var facename = $td.eq(1).text();//工作面
	var survey = $td.eq(2).text();//概况
	var rirtype = $td.eq(3).text();//类型
	var starttime = $td.eq(4).text();//开始时间
	var endtime = $td.eq(5).text();//结束时间
	
	//2.进行表单初始化
	$("#updatefacename").val(facename);//工作面
	$("#updatesurvey").val(survey);//概况
	$("#updaterirtype").val(rirtype);//类型
	$("#optsdate3").val(starttime);//开始时间
	$("#optsdate33").val(endtime);//结束时间
}

//确认修改的点击事件
function updateBtn(){
	var flag=compareTime($("#optsdate3").val(),$("#optsdate33").val());
	if(flag){
		//开始时间 《 结束时间  正确  可以进行表单提交
		// 表单校验   
		var isNotNull = $("#updateForm").validate({
			ignore : [],
			rules : {
				"riIdentificationRange.facename" : "required",// 工作面名称
				"riIdentificationRange.survey" : "required",// 概况
				"riIdentificationRange.rirtype" : "required",// 类型
				"riIdentificationRange.starttime" :{// 开始时间
					required:true,
				},
				"riIdentificationRange.endtime" : {// 结束时间
					required:true,
				}
			},
			messages : {
				"riIdentificationRange.facename" : {// 工作面名称
					required : "不能为空"
				},
				"riIdentificationRange.survey" : {// 概况
					required : "不能为空"
				},
				"riIdentificationRange.rirtype" : {// 类型
					required : "不能为空"
				},
				"riIdentificationRange.starttime" : {// 开始时间
					required : "不能为空",
				},
				"riIdentificationRange.endtime" : {// 结束时间
					required : "不能为空",
				}
			}
		});//表单校验的括号

		// 如果通过表单校验，则执行修改操作
		if (isNotNull.form()) {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "identificationRange_updateRiIdentificationRange.action",
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
		}//第二个if的括号
		
	}else{//与第一个if配对的else
		//开始时间大于结束时间，不进行表单提交
		
	}
	
	
}


//删除 -》打开删除的模态框前要进行的
function delOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的风险辨识范围id
	var idenranid= $(obj).siblings("input").val();
	//隐藏当前选中要删除的那条岗位职责的id 
	$("#delidenranid").val(idenranid);
}

//删除按钮的点击事件
function delBtn(){
	// 2.根据该隐藏的岗位职责id进行删除
	$.ajax({
		type : "post",
		dataType : "json",
		url : "identificationRange_delRiIdentificationRange.action",
		data : {
			// 当前页页号 每页显示的记录数
			"idenranid" : $("#delidenranid").val()
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










//查询
function findAllRiRespon() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "identificationRange_findAllRiIdentificationRange.action",
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
			for (var i = 0; i < data.pageBean.productList.length; i++) {
				var idenranid = data.pageBean.productList[i].idenranid;//风险辨识范围信息id
				var facename = data.pageBean.productList[i].facename;// 工作面
				var survey = data.pageBean.productList[i].survey;// 概况
				var rirtype = data.pageBean.productList[i].rirtype;// 类型
				var starttime = data.pageBean.productList[i].starttime;// 开始时间
				var endtime = data.pageBean.productList[i].endtime;// 结束时间
				
				var startDateTime=/\d{4}-\d{1,2}-\d{1,2}/g.exec(starttime);
				var endDateTime=/\d{4}-\d{1,2}-\d{1,2}/g.exec(endtime);
				
				//开始拼接
				options += "<tr>";
			    //options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+facename+"</td>";
				options +="<td>"+survey+"</td>";
				options +="<td>"+rirtype+"</td>";
				options +="<td>"+startDateTime+"</td>";
				options +="<td>"+endDateTime+"</td>";
				options +="<td>" +"<input  type='hidden' value='"+idenranid+"'><a data-toggle='modal' data-target='#modifierDuty' onclick='updateOpenBtn(this)' href='#'>修改</a><a data-toggle='modal' data-target='#deleteDuty' onclick='delOpenBtn(this)' href='#'>删除</a></td>";
				options += "</tr>";
			}
			
			// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
			PagePilot(data.pageBean.currentPage, data.pageBean.currentCount, data.pageBean.totalCount)
			
			
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


