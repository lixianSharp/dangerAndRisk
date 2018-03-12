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
<title>年度辨识管理</title>

<%@ include file="/controls/cssJs.jsp"%>
<!-- 弹出层插件 -->
<%-- <script type="text/javascript" src="<%=path%>/js/risk/postbirdAlertBox.js"></script>
<link rel="stylesheet" href="<%=path%>/css/risk/postbirdAlertBox.css" /> --%>

<script type="text/javascript" src="<%=path%>/js/risk/yearRecognize.js"></script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />
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
						<span>风险管理 </span><span>> 专项辨识管理</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									<div>
									<button  class="btn btn-primary" data-toggle="modal" data-target="#addDuty" >新增</button>
									</div>
									<script type="text/javascript">
									
									</script>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>操作</th>
												<th>序号</th>
												<th>年度</th>
												<th>风险数量</th>
												<th>状态</th>
												<th>主持人</th>
												<th>记录人</th>
												<th width="140">操作</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
												<input type="checkbox">
												</td>
												<td>
												1
												</td>
												<td>
												2017
												</td>
												<td>
												2
												</td>
												<td>
												未评估
												</td>
												<td>
												张三
												</td>
												<td>
												李四
												</td>
												<td>
													<a data-toggle="modal" data-target="#modifierDuty" >修改</a>
													<a href="<%=path%>/risk/specialRisk.jsp">详情</a>
												</td>
											</tr>

										</tbody>
									</table>

								<!-- 模态框（新增专项辨识信息） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增专项辨识信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">年&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate5"
													type="text" placeholder="点击选择年份" value=""
													name="" readonly />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">专项信息：</span>
													<select	class="selectpicker form-control" title="请选择专项信息" 
													id="" name="">
														<option value="" id="option0">--请选择--</option>
														<option value="综采">新水平、新采（盘）区、新工作面设计前</option>
														<option value="综掘">生产系统、生产工艺、主要设施设备、重大灾害因素等发生重大变化时</option>
														<option value="综采">启封火区、排放瓦斯、突出矿井过构造带及石门揭煤等高危作业实施前，新技术、新材料试验或推广应用前</option>
														<option value="综掘">本矿发生死亡事故或涉险事故、出现重大事故隐患或所在省份发生重特大事故后</option>
													</select>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">地&nbsp;&nbsp;点：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">主持&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">记录&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">参会人员：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">会议内容：</span>
													<textarea id="dangerneirong" class="form-control texta"
													rows="5" name="danger.content"></textarea>
												</div>
												
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary">
													保存
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								<!-- 模态框（修改专项辨识信息） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改专项辨识信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">年&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate5"
													type="text" placeholder="" value="2018"
													name="" readonly />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">地&nbsp;&nbsp;点：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">主持&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">记录&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">参会人员：</span>
													<input type="text" class="form-control el_modelinput"
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">会议内容：</span>
													<textarea id="dangerneirong" class="form-control texta"
													rows="5" name="danger.content"></textarea>
												</div>
												
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary">
													确认修改
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->


									<div id="paginationIDU"></div>
									<script>
										$('#paginationIDU').pagination(
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