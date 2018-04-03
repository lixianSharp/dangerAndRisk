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
<title>月风险管控计划</title>

<%@ include file="/controls/cssJs.jsp"%>
<!-- 弹出层插件 -->
<script type="text/javascript" src="<%=path%>/js/risk/plug-in.js"></script>



<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />

<!--验证-->
<script src="<%=path%>/controls/validate/jquery.validate.js"></script>
<script src="<%=path%>/controls/validate/messages_zh.js"></script>

<!-- 月风险管控的js -->
<script type="text/javascript" src="<%=path%>/js/risk/weekRiskControlPlan.js"></script>
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
						<span>风险管理 </span><span>>旬风险管控计划</span>
					</div>

					<div class="panel-body el_main">



						<!--内容-->
						<div class=" col-md-12">
						<!--索引-->
							<div class="row el_queryBox">
								<form action="" method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												
												<span class="el_spans el_chooseSpan">月份：</span> 
												<input id="optsdate6"
													class="selectpicker form-control" title="点击选择年份" name="year">
												
												
												
											</div> 
										</div>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
											<input type="hidden" name="riskCtrlPlanMark" value="0">
												<span class="el_spans el_chooseSpan">旬期：</span>
												  <select id=""
													class="selectpicker form-control" title="请选择" name="monthOrWeek">
													<option value="">--请选择--</option>
													<option value="1">上旬</option>
													<option value="2">中旬</option>
													<option value="3">下旬</option>
												</select>
											
											<!-- </div>
										</div> -->
												
												<input type="hidden" name="currentPage" id="currentPage" />
												<input type="hidden" name="currentCount" id="currentCount" />
											</div>
										</div>
										
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">专业类型：</span>
												 
												<select id="professionalTypesId"
													class="selectpicker form-control" title="请选择" name="specialty">
													
												</select>
											</div>
										</div>

									
										
										<button type="button"
										class="btn btn-primary el_queryButton btn-sm"  style="left: 930.62px;top: 0px;bottom: 12px;margin-bottom: 3px;padding-bottom: 0px;padding-top: 0px;"  onclick="queryButton()" id="queryId">查询</button>
									<button class="btn btn-default btn-sm" style="margin-left: 112px;" onclick="clearBtn()" >清空</button>
									
								<!-- 	
									<button  type="button" id="queryId" onclick="queryButton()" 
										class="btn btn-primary el_queryButton btn-sm" style="left: 930.62px;top: 0px;bottom: 12px;margin-bottom: 3px;padding-bottom: 0px;padding-top: 0px;"  >查询</button>
									<button class="btn btn-default btn-sm" style="margin-left: 400px;" >清空</button>
									 -->
									</div>
								</form>
							</div>
							
							<!--结束 查询表单提交-->

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									<div>
									<!-- <button  class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onClick="$.Pop('每个月每个专业只能有一个风险管控计划，可以通过“详情”维护专业的风险管控计划信息。','confirm',function(){})" >新增</button> -->
									<button  class="btn btn-primary" data-toggle="modal" onClick="$.Pop('每个月每个专业只能有一个风险管控计划，可以通过“详情”维护专业的风险管控计划信息。','confirm',function(){addWeekControlPlan()})" >新增</button>
									<button class="btn btn-primary" onclick="planReport()">计划上报</button>
									<button class=" btn btn-primary" onclick="riskCheck()">审核</button>
									
									
									</div>
									<!-- <script type="text/javascript">
									function riskCheck(){
										$('#riskCheck').modal();
									} -->
									
									</script>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>选择</th>
												<th>序号</th>
												<!-- <th>年度</th> -->
												<th>月份</th>
												<th>旬期</th>
												<th>风险辨识范围</th>
												<th>风险数量</th>
												<th>专业</th>
												<th>专业负责人</th>
												<th>创建时间</th>
												<th>审核备注信息</th>
												<th>状态</th>
												<th>操作</th>
											</tr>
										</thead>
									
										<tbody id="tbody"></tbody>
									</table> 
									
									<div id="paginationIDU"></div>

								<!-- 模态框（新增周风险管控计划信息） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增周旬险管控计划信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addControlPlanForm" method="post">
												 <div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">月&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate66"
													type="text" placeholder="点击选择月份" value=""
													name="ricontrolPlan.year" disable="disable" />
												</div>
												
												<div class="input-group el_modellist"  role="toolbar">
												<span class="el_spans">旬&nbsp;&nbsp;期：</span>
												  <select id="addxunqi"
													class="selectpicker form-control" title="请选择" name="ricontrolPlan.monthorweek">
													<option value="">--请选择--</option>
													<option value="1">上旬</option>
													<option value="2">中旬</option>
													<option value="3">下旬</option>
												</select>
												
												
												</div>
								 
												
												
												<!-- <div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">专&nbsp;&nbsp;业：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addprofessionaltypes" name="ricontrolPlan.specialty">
														
													</select>
												</div> -->
															
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">专&nbsp;&nbsp;业：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addprofessionaltypes" name="ricontrolPlan.specialty">
														<!--<option value="" id="option0">--请选择--</option>
														 <option value="采煤">采煤</option>
														<option value="挖水">挖水</option>
														 -->
													</select>
												</div>	
												
												<!-- 说明是否是周管控计划	 -->
												<input type="hidden" name="ricontrolPlan.riskctrlplanmark" value="0"/>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">负责&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="addControlPlanLeader" name="ricontrolPlan.leader" />
												</div>
								
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="saveControlPlanButton()">
													保存
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								<!-- 模态框（周风险管控计划审核） -->
								<div class="modal fade" id="riskCheck" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												旬风险管控计划审核
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="queryAuditForm">
												<div class="input-group el_modellist" role="toolbar" id="history">
													<span class="el_spans">历史审核备注信息：</span>
													<textarea id="historyAuditmsg" class="form-control texta"
										rows="3" name=""></textarea>
											
												</div>
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">本次审核备注信息：</span>
													<textarea id="benciAuditmsg" class="form-control texta"
										rows="3" name="riRiskPlanAudit.auditmsg"></textarea>
										<input type="hidden" name="riRiskPlanAudit.rictrlplanid" id="shenHeRictrlplanId" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">审核状态：</span>
													<div class="form-control texta" style=" margin-left: 51px;width: 361px;">
													<input class="" type="radio" name="riRiskPlanAudit.auditstatus" value="通过审核" />通过审核
													<input class=" "  type="radio" name="riRiskPlanAudit.auditstatus" value="未通过审核" />未通过审核
													</div>
													
												</div>
								
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="saveAuditButton()">
													保存
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								<!-- 模态框（修改月风险管控计划信息） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改周风险管控计划信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateControlPlanForm">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">月&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate666"
													type="text" placeholder="点击选择月份" value=""
													name="ricontrolPlan.year" style="left: 10px;"/>
												</div>
												
												<div class="input-group el_modellist"  role="toolbar">
												<span class="el_spans">旬&nbsp;&nbsp;期：</span>
												  <select style="left: 10px;" 
													class="selectpicker form-control" title="请选择" name="ricontrolPlan.monthorweek" id="updateWeek">
													<option value="">--请选择--</option>
													<option value="1">上旬</option>
													<option value="2">中旬</option>
													<option value="3">下旬</option>
												</select>
												</div>
								
												
												 
												 <div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">专&nbsp;&nbsp;业：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updateprofessionaltypes" name="ricontrolPlan.specialty" style="left: 10px;">
														<!--<option value="" id="option0">--请选择--</option>
														 <option value="采煤">采煤</option>
														<option value="挖水">挖水</option>
														 -->
													</select>
												</div>
												 
												
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">负责&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="updateControlPlanLeader" name="ricontrolPlan.leader" style="left: 9px;"/>
														
													<input type="hidden" id="updateControlPlanId" name="ricontrolPlan.rictrlplanid" />
												</div>
								
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" id="updateButton" onclick="updateControlPlanButton()">
													确认修改
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->


									
								<!-- 	<script>
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
									 -->

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