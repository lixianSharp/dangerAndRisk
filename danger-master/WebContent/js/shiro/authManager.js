//页面加载的时候要执行的方法
$(function() {
	findAllSysUser();
});

// 新增用户(注册账户)按钮的点击事件
function addDutyBtn() {
	// 清空表单中的数据
	$("#addAccount").val("");// 登陆账户
	$("#addpwd").val("");// 登陆密码
	$("#addusername").val("");// 用户名
}

//先校验表单->再判断用户输入的登陆帐户名usercode是否在数据库中已经存在->不存在的话最后执行将账户信息添加到数据库中
// 新增用户(注册账户)按钮的点击事件
function addSave() {
	// 表单校验
	var isNotNull = $("#addForm").validate({
		ignore : [],
		rules : {
			"sysUser.usercode" : "required",// 登陆账户
			"sysUser.password" : "required",// 登陆密码
			"sysUser.username" : "required",// 用户名
		},
		messages : {
			"sysUser.usercode" : {// 登陆账户
				required : "不能为空"
			},
			"sysUser.password" : {// 登陆密码
				required : "不能为空"
			},
			"sysUser.username" : {// 用户名
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行新增职责操作
	if (isNotNull.form()) {
		//查询帐户名是否重复
		$.ajax({
			type : "post",
			dataType : "json",
			url : "sysShiro_findUsercode.action",
			data : {
				"usercode":$("#addAccount").val()
			},
			success : function(data) {
				if(data.result=="true"){
					alert("登陆帐户名重复，请重新输入登录帐户名");
				}else{
					//alert("该登陆帐户名可以通过，可以添加");
					adduserClickBtn();//将账户信息添加到数据库中
				}
			},
			error : function() {
				alert("添加失败，请重新添加！");
			}
		});
	}

}
//点击保存按钮之后将账户信息添加到数据库中
function adduserClickBtn(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_insertSysUser.action",
		data : $("#addForm").serialize(),
		success : function(data) {
			alert(data.result);
			$("#addDuty").modal("hide");
			
			//初始化当前页页号和每页显示的记录数
			$("#currentPage").val("1");
			$("#currentCount").val("10");
			//刷新数据
			findAllSysUser();
		},
		error : function() {
			alert("添加失败，请重新添加！");
		}
	});
}


// 修改密码-->打开修改的模态框
function updateOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的岗位职责id
	
	var $td = $(obj).parents("tr").children("td");
	var usercode = $td.eq(1).text();//登陆账户 usercode
	var password = $td.eq(2).text();//登陆密码 
	var username = $td.eq(3).text();//用户名username
	
	
	//2.进行表单初始化
	$("#updateSysUserUsercode").val(usercode);//登陆账户 usercode  这是个隐藏域
	$("#updateSysUserPwd").val(password);//登陆密码
	$("#updateSysUserUsername").val(username);//用户名
	
}

//修改密码的保存按钮的点击事件
function updateBtn(){
	// 2.将修改后的数据进行保存
	// 表单校验
	var isNotNull = $("#updateSysUserForm").validate({
		ignore : [],
		rules : {
			"sysUser.password" : "required",// 登陆密码
			"sysUser.username" : "required",// 用户名
		},
		messages : {
			"sysUser.password" : {// 登陆密码
				required : "不能为空"
			},
			"sysUser.username" : {// 用户名
				required : "不能为空"
			}
		}
	});

	// 如果通过表单校验，则执行修改职责操作
	if (isNotNull.form()) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "sysShiro_updateSysUser.action",
			data : $("#updateSysUserForm").serialize(),
			success : function(data) {
				alert(data.result);
				// 关闭修改模态框
				$("#modifierDuty").modal("hide");
				//刷新数据
				findAllSysUser();
			},
			error : function() {
				alert("修改失败，请重新修改！");
			}
		});
	}
}


// 删除 -》打开删除的模态框前要进行的
function delOpenBtn(obj) {
	// 1。获取到当前选中的隐藏的登陆账户usercode
	var usercode= $(obj).attr("title");
	//隐藏当前选中要删除的那个账户的登陆账号usercode
	$("#delSysUserUsercode").val(usercode);
}
//删除按钮的点击事件
function delBtn(){
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_delUser.action",
		data : {
			// 当前页页号 每页显示的记录数
			"usercode" : $("#delSysUserUsercode").val()
		},
		success : function(data) {
			alert(data.result);
			//关闭模态框
			$("#deleteDuty").modal("hide");
			//清空当前页页号和每页显示的记录数
			$("#currentPage").val("1");// 当前页页号
			$("#currentCount").val("10");//每页显示的记录数
			//刷新数据
			findAllSysUser();
		},
		error : function() {
			alert("删除失败，请重新删除！");
		}
	});
}

//初始化当前页页号和每页显示的记录数
/*$("#currentPage").val("1");
$("#currentCount").val("10");*/


//查询所有账户信息
function findAllSysUser() {
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_findAllUserByCondition.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"usercode":$("#findusercode").val(),//登陆帐户名
			"username":$("#findusername").val()//用户名
		// 每页显示的记录数
		},
		success : function(data) {
			$("#tbody").children().remove();
			var options = "";
			for(var i = 0; i < data.pageBean.productList.length; i++){
				var sysUserId = data.pageBean.productList[i].id;//账户主键id
				var usercode = data.pageBean.productList[i].usercode;//登陆账户
				var password = data.pageBean.productList[i].password;//登陆密码
				var username = data.pageBean.productList[i].username;//用户名
				//开始拼接
				options += "<tr>";
			    //options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+usercode+"</td>";
				options +="<td>"+password+"</td>";
				options +="<td>"+username+"</td>";
				/*options +="<td>"+"没了"+"</td>";*/
				options +="<td>" +"<input  type='hidden' value='"+"参数"+"'><a data-toggle='modal' data-target='#modifierDuty' href='#' onclick='updateOpenBtn(this)' >修改密码</a><a title='"+usercode+"' data-toggle='modal' data-target='#findAuth' href='#' onclick='findSysUserPermissions(this)' >查看已有权限</a><a title='"+usercode+"' data-toggle='modal' data-target='#deleteDuty' href='#' onclick='delOpenBtn(this)'>删除该账户</a><a title='"+usercode+"' data-toggle='modal' data-target='#sysuserToPermission' href='#' onclick='shareps(this)'>分配权限</a></td>";
				options += "</tr>";
			}
			
			PagePilot(data.currentPage, data.currentCount, data.pageBean.totalCount);
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
					findAllSysUser();
				}
			});
}



//查看该账户已有权限的操作  start
function findSysUserPermissions(obj){
	//获取登陆帐户名 usercode
	var usercode= $(obj).attr("title");
	//将登陆帐户名放在对应的隐藏域中
	$("#findSysUserPermissionsyscode").val(usercode);
	
	//清空当前页页号和每页显示的记录数
	$("#currentPage").val("1");// 当前页页号
	$("#currentCount").val("10");//每页显示的记录数
	//根据帐户名获取其所有权限
	findSysUserPermissionsLater();
	
}
//根据帐户名获取其所有权限
function findSysUserPermissionsLater(){
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_selectSysUserPermissions.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"usercode" : $("#findSysUserPermissionsyscode").val()//登陆帐户名
		// 每页显示的记录数
		},
		success : function(data) {
			$("#tbodyfindSysUserPermissions").children().remove();
			var options = "";
			for(var i = 0; i < data.pageBean.productList.length; i++){
				var permissionName = data.pageBean.productList[i].name;
				var permissionId = data.pageBean.productList[i].id;
				//开始拼接
				options += "<tr>";
			    //options += "<td><input type='checkbox'></td>";
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+permissionName+"</td>";//权限名称
				//options +="<td>"+permissionId+"</td>";//主键id
				options +="<td><a title='"+permissionId+"' data-toggle='modal' data-target='#delAccountPermission' href='#' onclick='delSysuserpermission(this)' >删除该权限</a></td>"
				options += "</tr>";
			}
			PagePilot3(data.currentPage, data.currentCount, data.pageBean.totalCount);
			$("#tbodyfindSysUserPermissions").append(options);
		},
		error : function() {
			alert("失败了！");
		}
	});
}

//查询账户下的所有权限用的
//currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
function PagePilot3(currentPage, currentCount, totalCount) {
	$('#paginationIDU3').pagination(
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
				findSysUserPermissionsLater();
			}
		});
}



//删除某个账户下的某个权限
function delSysuserpermission(obj){
	//获取权限的主键id
	var permissionId=$(obj).attr("title");
	$("#delpermissionId").val(permissionId);
	//清空当前页页号和每页显示的记录数
	//$("#currentPage").val("1");// 当前页页号
	//$("#currentCount").val("10");//每页显示的记录数
}

//点击 确认删除该权限按钮的事件
function delpermission(){
	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_delPermission.action",
		data : {
			// 当前页页号 每页显示的记录数
			"sysPermissionId" : $("#delpermissionId").val()
		},
		success : function(data) {
			alert(data.result);
			//关闭模态框
			$("#delAccountPermission").modal("hide");
			//刷新数据
			findSysUserPermissionsLater();
		},
		error : function() {
			alert("删除失败，请重新删除！");
		}
	});
	
}





//查看该账户已有权限的操作  end











































//分配权限 操作

//根据登陆帐户名查询该账户所有未分配的权限
function findAllPermissionByCondition() {
	$.ajax({
		type : "post",
		dataType : "json",
		url : "sysShiro_findPermissionByCondition.action",
		data : {
			// 当前页页号 每页显示的记录数
			"currentPage" : $("#currentPage").val(),// 当前页页号
			"currentCount" : $("#currentCount").val(),//每页显示的记录数
			"usercode":$("#sharePermissionUsername").val()
		// 每页显示的记录数
		},
		success : function(data) {
			$("#sysUserToPermissionBody").children().remove();
			var options = "";
			for(var i = 0; i < data.pageBean.productList.length; i++){
				var permissionId = data.pageBean.productList[i].id;//权限主键id
				var permissionName = data.pageBean.productList[i].name;//权限名字
				var permissionType = data.pageBean.productList[i].type;//权限类型
				//开始拼接
				options += "<tr>";
				if(permissionType=="permission"){
					options += "<td><input name='permissionCheckBox' value='"+permissionId+"' type='checkbox'></td>";
				}else{
					options += "<td></td>";
				}
			    
				options +="<td>"+((data.pageBean.currentPage-1)*10+i+1)+"</td>";
				options +="<td>"+permissionId+"</td>";
				if(permissionType=="permission"){
					options +="<td>"+permissionName+"</td>";
				}else{
					options +="<td><font color='blue'><h3>"+permissionName+"</h3></font></td>";
				}
				
				options +="<td>"+permissionType+"</td>";
				options += "</tr>";
			}
			PagePilot2(data.currentPage, data.currentCount, data.pageBean.totalCount);
			$("#sysUserToPermissionBody").append(options);
		},
		error : function() {
			alert("失败了！");
		}
	});
}

//分配权限操作用的
// currentPage：当前页页号 currentCount：每页显示的记录数 totalCount：总记录数
function PagePilot2(currentPage, currentCount, totalCount) {
	$('#paginationIDU2').pagination(
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
					findAllPermissionByCondition();
				}
			});
}


//点击分配权限按钮之后执行的操作  获取要给哪个账户分配权限
function shareps(obj){
	var usercode=$(obj).attr("title");
	//存放在对应的隐藏域中，用于分配权限操作
	$("#sharePermissionUsername").val(usercode);
	
	//清空当前页页号和每页显示的记录数
	$("#currentPage").val("1");// 当前页页号
	$("#currentCount").val("10");//每页显示的记录数
	//将该账户所未分配的权限显示出来
	findAllPermissionByCondition();
}



//确定分配权限按钮的事件
function sharePermission(){
	//获取所有选中的权限的id
	var permissionIds = "";
	$("input:checkbox[name=permissionCheckBox]:checked").each(function(i){  
	    if(0==i){  
	    	permissionIds = $(this).val();  
	    }else{  
	    	permissionIds += (","+$(this).val());  
	    }  
	});  
	//alert("permissionIds:"+permissionIds)
	//选中的所有权限的id
	$("#sharePermissionIds").val(permissionIds);
	//当前选中的用户名
	
	//如果没有选中权限，则不能执行分配权限操作
	if($("#sharePermissionIds").val()==""){
		alert("请先选择需要分配的权限");
	}else{
		//执行分配权限
		$.ajax({
			type : "post",
			dataType : "json",
			url : "sysShiro_permissionToUser.action",
			data : {
				"sysPermissionIds" : $("#sharePermissionIds").val(),//所有权限的id
				"usercode" : $("#sharePermissionUsername").val() //用户名
			},
			success : function(data) {
				alert(data.result);
				//关闭模态框
				$("#delAccountPermission").modal("hide");
				//刷新数据
				findAllPermissionByCondition();
			},
			error : function() {
				alert("分配失败，请重新分配权限！");
			}
		});
	}
	
	
}





//分配权限操作 结束



//根据条件查询账户信息
//点击查询按钮的事件
function selectSysUser(){
	//先清空当前页页号和每页显示的记录数
	$("#currentPage").val("1");// 当前页页号
	$("#currentCount").val("10");//每页显示的记录数
	findAllSysUser();
}

function clearData(){
	$("#findusercode").val("");
	$("#findusername").val("");
	//清空之后恢复原始数据
	$("#currentPage").val("1");// 当前页页号
	$("#currentCount").val("10");//每页显示的记录数
	findAllSysUser();
}
