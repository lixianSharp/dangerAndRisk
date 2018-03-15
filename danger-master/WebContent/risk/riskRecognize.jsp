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
<title>风险辨识范围</title>

<%@ include file="/controls/cssJs.jsp"%>

<script type="text/javascript" src="<%=path%>/js/risk/riskRecognize.js"></script>

<!-- 用于表单校验的 -->
<script type="text/javascript" src="<%=path%>/js/jquery.validate-1.13.1.js"></script>


<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/riskRecognize.css" />
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
						<span>风险管理 </span><span>> 风险辨识范围</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									<div>
									<button class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onclick="addOpenBtn()">新增</button>
									</div>
									
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>操作</th>
												<th>序号</th>
												<th>工作面名称</th>
												<th>概况</th>
												<th>类型</th>
												<th>开始时间</th>
												<th>结束时间</th>
												<th width="140">操作</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<tr>
												<td>
												<input type="checkbox">
												</td>
												<td>
												1
												</td>
												<td>
												井口
												</td>
												<td>
												井口一米内不可由杂物
												</td>
												<td>
												技术合理性
												</td>
												<td>
												2018-03-02
												</td>
												<td>
												2018-03-09
												</td>
												<td>
													<a data-toggle="modal" data-target="#modifierDuty" >修改</a>
													<a data-toggle="modal" data-target="#deleteDuty">删除</a>
												</td>
											</tr>

										</tbody>
									</table>

								<!-- 模态框（新增风险辨识范围） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增风险辨识范围
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addForm">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">工作面名称：</span>
													<input type="text" class="form-control el_modelinput"
														id="addfacename" name="riIdentificationRange.facename" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">概&nbsp;&nbsp;况：</span>
													<input type="text" class="form-control el_modelinput"
														id="addsurvey" name="riIdentificationRange.survey" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">类&nbsp;&nbsp;型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addrirtype" name="riIdentificationRange.rirtype">
														<option value="" id="option0">--请选择--</option>
														<!-- <option value="综采">综采</option>
														<option value="综掘">综掘</option> -->
														
													</select>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">开始时间：</span>
													<input
													class="datainp wicon form-control" id="optsdate2"
													type="text" placeholder="点击选择开始时间" value=""
													name="riIdentificationRange.starttime" readonly />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">结束时间：</span>
													<input
													class="datainp wicon form-control" id="optsdate22"
													type="text" placeholder="点击选择结束时间" value=""
													name="riIdentificationRange.endtime" readonly />
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
								<!-- 模态框（修改风险辨识范围） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改风险辨识范围
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateForm">
													<!-- 隐藏域，隐藏要修改的风险辨识范围的id -->
													<input id="updateidenranid" type="hidden" name="riIdentificationRange.idenranid" value="">
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">工作面名称：</span>
													<input type="text" class="form-control el_modelinput"
														id="updatefacename" name="riIdentificationRange.facename" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">概&nbsp;&nbsp;况：</span>
													<input type="text" class="form-control el_modelinput"
														id="updatesurvey" name="riIdentificationRange.survey" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">类&nbsp;&nbsp;型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updaterirtype" name="riIdentificationRange.rirtype">
														<option value="" id="option0">--请选择--</option>
														<!-- <option value="综采">综采</option>
														<option value="综掘">综掘</option> -->
														
													</select>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">开始时间：</span>
													<input
													class="datainp wicon form-control" id="optsdate3"
													type="text" placeholder="" value="2018-03-02"
													name="riIdentificationRange.starttime" readonly />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">结束时间：</span>
													<input
													class="datainp wicon form-control" id="optsdate33"
													type="text" placeholder="" value="2018-03-03"
													name="riIdentificationRange.endtime" readonly />
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
								<!-- 模态框（删除风险辨识范围） -->
								<div class="modal fade" id="deleteDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												删除风险辨识范围
												</h4>
											</div>
											<div class="modal-body">
												您确认要删除这条风险辨识范围吗？
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="delBtn()">
													删除
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->

									<div id="paginationIDU"></div>
									<!-- 隐藏当前页页号  默认值为1 -->
									<input id="currentPage"  type="hidden" value="1"/>
									<!-- 隐藏每页显示的记录数 默认为10 -->
									<input id="currentCount" type="hidden" value="10"/>
									<!-- 隐藏删除用的风险辨识范围信息id -->
									<input id="delidenranid" type="hidden" value=""/>
									
									<script>
										/* $('#paginationIDU').pagination(
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
												}); */
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