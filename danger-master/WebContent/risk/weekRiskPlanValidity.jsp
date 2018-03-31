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
<title>旬风险管控计划</title>

<%@ include file="/controls/cssJs.jsp"%>
<!-- 弹出层插件 -->
<script type="text/javascript" src="<%=path%>/js/risk/plug-in.js"></script>
<script type="text/javascript" src="<%=path%>/js/risk/weekRiskPlanValidity.js"></script>
<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />
<style type="text/css">
.warnInfo{
background-color:#EEEE00;
}

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
						<span>风险管理 </span><span>>旬风险管控计划有效性</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class="col-md-12">
						<!--索引-->
							<div class="row el_queryBox">
								<form
									action=""
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												
												<span class="el_spans el_chooseSpan">月份：</span> 
												<input id="optsdate6" class="selectpicker form-control" title="点击选择年份" name="year">
													<input type="hidden" name="currentPage" id="currentPage" />
													<input type="hidden" name="currentCount" id="currentCount" />
													<input type="hidden" name="riskCtrlPlanMark" value="0">
													<input type="hidden" name="checkstatus" value="1"/>
												
											</div>
											</div>
											<div class="col-md-3 el_qlmQuery">
											<div class="input-group el_chooseSpan"  role="toolbar">
												<span class="el_spans">旬期：</span>
												  <select id=""
													class="selectpicker form-control" title="请选择" name="monthOrWeek">
													<option value="">--请选择--</option>
													<option value="1">上旬</option>
													<option value="2">中旬</option>
													<option value="3">下旬</option>
												</select>
												
												
											
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

									
										
										<button  type="button" id="queryId" onclick="queryButton()" 
										class="btn btn-primary el_queryButton btn-sm" style="left: 930.62px;top: 0px;bottom: 12px;margin-bottom: 3px;padding-bottom: 0px;padding-top: 0px;"  >查询</button>
									<button class="btn btn-default btn-sm" style="margin-left: 100px;" >清空</button>
									</div>
								</form>
							</div>
							<!--结束 查询表单提交-->

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									
									<table class="risk table table-hover table-bordered">
										<thead>
											<tr>
												
												<th>序号</th>
												<th>月份</th>
												<th>旬期</th>
												<th>风险辨识范围</th>
												
												<th>专业</th>
												<th>专业负责人</th>
												<th>创建时间</th>
												<th>风险总数</th>
												<th>措施失效风险数量</th>
											</tr>
										</thead>
										<%-- <tbody>
											<tr>
												
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
												井口
												</td>
												<td>
												3
												</td>
												<td>
												采煤
												</td>
												<td>
												张三
												</td>
												
												<td>
												5
												</td>
												<td title="点击查看失效风险具体情况">
													<a class="loseRiskNum" href="<%=path%>/risk/losePlanDis.jsp">0</a>
												</td>
											</tr>
										</tbody> --%>
										<tbody id="tbody"></tbody>
									</table>
									<div id="paginationIDU"></div>

									<script type="text/javascript">
									$(document).ready(function(){
										var loseRiskNum=$(".loseRiskNum").text();
										if(loseRiskNum>0){
											$(".risk tr td:last-child").addClass("warnInfo");
										}
									});
									</script>
									
									<!-- <script>
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
									</script> -->
									

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