<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ include file="/tag.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限管理</title>

<%@ include file="/controls/cssJs.jsp"%>

<!-- 引入js文件 -->
<script type="text/javascript" src="<%=path%>/js/shiro/authManager.js"></script>

<!-- 用于表单校验的 -->
<script type="text/javascript" src="<%=path%>/js/jquery.validate-1.13.1.js"></script>


<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/dutyDivide.css" />


<style type="text/css">
	

</style>


</head>

<body>
	<!--头-->
	<jsp:include page="../public/header.jsp"></jsp:include>

	<!--中部-->
	<div class="html_middle">

		<!--放菜单-->
		<div id="leftbackground">
			<jsp:include page="../public/menu.jsp"></jsp:include>
			<img src="<%=path%>/image/leftArrow.jpg" id="leftArrow" />
		</div>
		<img src="<%=path%>/image/rightArrow.jpg" id="rightArrow" />

		<!--放主界面内容-->
		<div class="el_right">

			<div class="container-fluid">
				<div class="panel panel-default">
					<!--菜单连接标题-->
					<div class="el_stairTitle">
						<span>系统管理 </span><span>> 权限管理</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">
									<form
									action=""
									method="post" id="">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												
												<span class="el_spans el_chooseSpan">登陆帐户名：</span> 
												<input type="text"
													class="selectpicker form-control" name=""
													id="findusercode" value=""/>
												
											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">用户名：</span>
												 <input type="text" id="findusername" class="selectpicker form-control" name="" value=""/>
												
											</div>
										</div>
										<button type="button" onclick="selectSysUser()">查询</button>
										<button type="button" onclick="clearData()">清空</button>
									</div>

								</form>
								
									<div>
									 <button class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onclick="addDutyBtn()">增加账户(注册账户)</button>
									</div>
									
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<!-- <th>操作</th> -->
												<th>序号</th>
												<th>登陆帐户</th>
												<th>登陆密码</th>
												<th>用户名</th>
												<th width="200">操作</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<!-- <tr>
												<td>
												<input type="checkbox">
												</td>
												<td>
												1
												</td>
												<td>
												技术岗位
												</td>
												<td>
												技术更新
												</td>
												<td>
												技术合理性
												</td>
												<td>
												一月一次
												</td>
												<td>
												一月一次
												</td>
												<td>
													<a data-toggle="modal" data-target="#modifierDuty" onclick="updateBtn()" >修改</a>
													<a data-toggle="modal" data-target="#deleteDuty" onclick="delBtn()">删除</a>
												</td>
											</tr> -->

										</tbody>
									</table>

								<!-- 模态框（增加账户，注册账户） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content" >
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												增加账户(注册账户)
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addForm">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">登陆账户：</span>
													<input type="text" class="form-control el_modelinput"
														id="addAccount" name="sysUser.usercode" value=""/>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">登陆密码：</span>
													<input type="text" class="form-control el_modelinput"
														id="addpwd" name="sysUser.password" />
												</div>
												
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;用户名：</span>
													<input type="text" class="form-control el_modelinput"
														id="addusername" name="sysUser.username" />
												</div> 
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="addSave()">
													保存
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								<!-- 模态框（修改账户密码） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改账户
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateSysUserForm">
												<!-- <div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">登陆账户：</span>
													<input type="text" class="form-control el_modelinput"
														id="addquarters" name="sysUser.usercode" />
												</div> -->
												
												<!-- 隐藏域，隐藏登陆账户 usercode -->
												<input type="hidden" id="updateSysUserUsercode" name="sysUser.usercode" />
												
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">登陆密码：</span>
													<input type="text" class="form-control el_modelinput"
														id="updateSysUserPwd" name="sysUser.password" />
												</div>
												
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;用户名：</span>
													<input type="text" class="form-control el_modelinput"
														id="updateSysUserUsername" name="sysUser.username" />
												</div>
																				
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="updateBtn()">
													确认修改
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								<!-- 模态框（查看已有权限） -->
								<div class="modal fade" id="findAuth" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												该账户已有的权限
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateForm">
													<table class="table table-hover table-bordered">
														<thead>
															<th>序号</th>
															<th>权限名称</th>
															<th>操作</th>
														</thead>
														<tbody id="tbodyfindSysUserPermissions" >
															
														</tbody>
													</table>
												</form>
											</div>
											<div id="paginationIDU3"></div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<!-- <button type="button" class="btn btn-primary" onclick="s()">
													确认修改
												</button> -->
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								
								<!-- 模态框（分配权限） -->
								<div class="modal fade" id="sysuserToPermission" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												系统的所有权限
												</h4>
											</div>
											<div class="modal-body">
													<table class="table table-hover table-bordered">
														<thead>
															<tr>
																<th></th>
																<th>序号</th>
																<th>权限id</th>
																<th>权限名称</th>
																<th>权限类型</th>
															</tr>
														</thead>
														<tbody id="sysUserToPermissionBody" >
															
														</tbody>
													</table>
											</div>
											<div id="paginationIDU2"></div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="sharePermission()">
													确定分配这些权限
												</button> 
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								
								<!-- 模态框（删除账户） -->
								<div class="modal fade" id="deleteDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												删除该账户
												</h4>
											</div>
											<div class="modal-body">
												您确定要删除该账户信息吗？
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="delBtn()">
													删除该账户信息
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								<!-- 删除账户下的某个权限 -->
								<div class="modal fade" id="delAccountPermission" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												删除该权限
												</h4>
											</div>
											<div class="modal-body">
												您确定要删除这个权限吗吗？
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="delpermission()">
													确认删除该权限
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
									<div id="paginationIDU"></div>
									
									<!-- 隐藏域，隐藏当前页页号   -->
									<input id="currentPage" type="hidden" value="1"/>
									<!-- 隐藏域，每页显示的记录数 -->
									<input id="currentCount" type="hidden" value="10"/>
									
									<!-- 隐藏域，隐藏当前选中要删除的那条账户信息的 登陆账户名usercode -->
									<input id="delSysUserUsercode" type="hidden" value=""/>
									
									<!-- 隐藏域，隐藏查询该账户权限需要用到的usercode -->
									<input  id="findSysUserPermissionsyscode" type="hidden" value=""/>
									
									<!-- 隐藏域，隐藏要删除的权限的主键id -->
									<input id="delpermissionId" type="hidden" value=""/>
									
									<!-- 隐藏域，存放分配权限的权限id集合 -->
									<input id="sharePermissionIds" type="hidden" value=""/>
									<!-- 隐藏域，存放分配权限时候要用到的登陆账户usercode -->
									<input id="sharePermissionUsername" type="hidden" value=""/>
									
								
									<script> 
/* 										$('#paginationIDU').pagination(
												{
													//			组件属性
													"total" :"${result.pageBean.totalCount}",//数字 当分页建立时设置记录的总数量 1
													"pageSize" : 10,//数字 每一页显示的数量 10
													"pageNumber" : "${result.pageBean.currentPage}",//数字 当分页建立时，显示的页数 1
													"pageList" : [ 10 ],//数组 用户可以修改每一页的大小，
													//功能
													"layout" : [ 'list', 'sep',
															'first', 'prev',
															'manual', 'next',
															'last', 'links' ],
													"onSelectPage" : function(
															pageNumber, b) {
														$("#currentPage").val(pageNumber);
														$("#currentCount").val(b);
														$("#queryForm").submit();
													}
												});
										
										 */
									</script>
									

								</div>
							</div>

						</div>

					</div>
				</div>

			</div>


		</div>

	</div>

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>