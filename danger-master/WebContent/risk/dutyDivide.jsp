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
<title>职责分工</title>

<%@ include file="/controls/cssJs.jsp"%>

<script type="text/javascript" src="<%=path%>/js/risk/dutyDivide.js"></script>

<!-- 用于表单校验的 -->
<script type="text/javascript" src="<%=path%>/js/jquery.validate-1.13.1.js"></script>


<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/dutyDivide.css" />
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
						<span>风险管理 </span><span>> 职责分工</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">
									<div>
									<button class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onclick="addDutyBtn()">新增职责</button>
									</div>
									
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<!-- <th>操作</th> -->
												<th>序号</th>
												<th>岗位</th>
												<th>职责</th>
												<th>管控内容</th>
												<th>管控频率</th>
												<th>风险分析频率</th>
												<th width="140">操作</th>
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

								<!-- 模态框（新增职责） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增职责
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addForm">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">岗&nbsp;&nbsp;位：</span>
													<input type="text" class="form-control el_modelinput"
														id="addquarters" name="riResponsibility.quarters" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">职&nbsp;&nbsp;责：</span>
													<input type="text" class="form-control el_modelinput"
														id="addduty" name="riResponsibility.duty" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">管控内容：</span>
													<input type="text" class="form-control el_modelinput"
														id="addctrlcontent" name="riResponsibility.ctrlcontent" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">管控频率：</span>
													<input type="text" class="form-control el_modelinput"
														id="addctrlfrequency" name="riResponsibility.ctrlfrequency" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">风险分析频率：</span>
													<input type="text" class="form-control el_modelinput"
														id="addanalysisfrequency" name="riResponsibility.analysisfrequency" />
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
								
								<!-- 模态框（修改职责） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改职责
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateForm">
													<!-- 隐藏域，隐藏当前选中要修改的那条岗位职责的id -->
													<input id="updaterespid" type="hidden" name="riResponsibility.respid" value="">
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">岗&nbsp;&nbsp;位：</span>
													<input type="text" class="form-control el_modelinput" value="技术岗位"
														id="updatequarters" name="riResponsibility.quarters" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">职&nbsp;&nbsp;责：</span>
													<input type="text" class="form-control el_modelinput" value="技术更新"
														id="updateduty" name="riResponsibility.duty" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">管控内容：</span>
													<input type="text" class="form-control el_modelinput" value="技术合理性"
														id="updatectrlcontent" name="riResponsibility.ctrlcontent" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">管控频率：</span>
													<input type="text" class="form-control el_modelinput" value="一月一次"
														id="updatectrlfrequency" name="riResponsibility.ctrlfrequency" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">风险分析频率：</span>
													<input type="text" class="form-control el_modelinput" value="一月一次"
														id="updateanalysisfrequency" name="riResponsibility.analysisfrequency" />
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
								<!-- 模态框（删除职责） -->
								<div class="modal fade" id="deleteDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												删除职责
												</h4>
											</div>
											<div class="modal-body">
												您确定要删除该条职责信息吗？
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
									
									<!-- 隐藏域，隐藏当前页页号   -->
									<input id="currentPage" type="hidden" value="1"/>
									<!-- 隐藏域，每页显示的记录数 -->
									<input id="currentCount" type="hidden" value="10"/>
									
									<!-- 隐藏域，隐藏当前选中要删除的那条岗位职责的id -->
									<input id="delrespid" type="hidden" value="">
									
									
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