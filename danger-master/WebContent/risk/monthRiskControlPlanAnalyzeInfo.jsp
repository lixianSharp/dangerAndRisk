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
<title>月风险管控计划风险分析</title>

<%@ include file="/controls/cssJs.jsp"%>


<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />
<style type="text/css">
.yearReInfo table tr td:nth-child(2n+1) {

    background-color: #eee;
    width: 20%;
    text-align: center;
    border-left: 1px solid #ccc;

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
						<span>风险管理 </span><span>>月风险管控计划风险分析</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain" style="margin-top: 0px;">

								<!--按钮面板-->
								<div class="panel-body">
							
									<div>
									<button class="btn btn-primary" onclick="monthRiskControlPlanAnalyze()">分析</button>
									
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>选择</th>
												<th>序号</th>
												<th>风险地点</th>
												<th>风险描述</th>
												<th>风险类型</th>
												<th>专业类型</th>
												<th>灾害类型</th>
												<th>可能导致事故</th>
												<th>管控措施</th>
												<th>负责人</th>
												<th>监管人</th>
												<th>监管周期</th>
												<th>责任部门</th>
												<th>措施执行情况</th>
												<th>措施是否有效</th>
												<th>考核情况</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>
												<input type="checkbox" name="riskAna" class="planCheck">
												</td>
												<td>
												1
												</td>
												<td>
												井口
												</td>
												<td>
												有煤灰
												</td>
												<td>
												人
												</td>
												<td>
												煤矿
												</td>
												<td>
												煤灰
												</td>
												<td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td>
												<td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td>
												
											</tr>
											<tr>
												<td>
												<input type="checkbox" name="riskAna"  class="planCheck">
												</td>
												<td>
												1
												</td>
												<td>
												井口
												</td>
												<td>
												有煤灰
												</td>
												<td>
												人
												</td>
												<td>
												煤矿
												</td>
												<td>
												煤灰
												</td>
												<td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td>
												<td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td><td>
												煤灰
												</td>
												
											</tr>
											
										</tbody>
									</table>
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
									<script type="text/javascript">
									function monthRiskControlPlanAnalyze(){
										var choosePlan = 0;// 判断是否有风险被选中

										$(".planCheck").each(function() { // 获取选择的风险

											if ($(this).prop("checked")) {// 如果选中。。。
												choosePlan++;

											}
										})

										if (choosePlan >= 2) {
												$("#monthRiskControlPlanAnalyze2").modal();
							
										}else if(choosePlan == 1){
											$("#monthRiskControlPlanAnalyze1").modal();
										} 
										
										else {
											alert("请先选择要分析的风险！")
										}
										
									}
									</script>
									<!-- 模态框（单条评估信息） -->
								<div class="modal fade" id="monthRiskControlPlanAnalyze1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<!-- <div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												风险评估详情
												</h4>
											</div> -->
											<div class="modal-body">
											<h4>风险信息详情</h4>
												<div class="yearReInfo">
												<table class="table  table-bordered">
												<tr>
												<td>风险地点：</td>
												<td>井口</td>
												<td>风险描述：</td>
												<td>连续接触</td>
												
												</tr>
												<tr>
												
												<td>风险类型 	：</td>
												<td>连续接触</td>
												<td>专业类型：</td>
												<td>10人以上死亡</td>
												</tr>
												<tr>
												<td>管控措施：</td>
												<td>红色风险大事发生的各色人等他和我</td>
												<td>负责人 ：</td>
												<td>张三</td>
												</tr>
												
												<tr>
												
												<td>监管人 ：</td>
												<td>里斯</td>
												<td>监管周期 ：</td>
												<td>张三</td>
												
												</tr>
												
												
												</table>
												</div>
											<h4>管控计划分析</h4>
											<div class="yearReInfo">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">责任部门：</span>
													<input type="text" class="form-control el_modelinput" value="" 
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">措施执行情况：</span>
													<textarea rows="3" type="text" class="form-control el_modelinput texta" value="" 
														id="" name="" />措施执行情况</textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">措施是否有效：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="" name="">
														<option value="" id="option0">--请选择--</option>
														<option value="">有效</option>
														<option value="">无效</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">考核情况：</span>
													<textarea rows="3" type="text" class="form-control el_modelinput texta" value="" 
														id="" name="" />措施执行情况</textarea>
												</div>
												
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
								</div>
								</div><!-- /.modal -->
								<!-- 模态框（多条评估信息） -->
								<div class="modal fade" id="monthRiskControlPlanAnalyze2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												管控计划分析
												</h4>
											</div>
											<div class="modal-body">
											<div class="yearReInfo">
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">责任部门：</span>
													<input type="text" class="form-control el_modelinput" value="" 
														id="" name="" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">措施执行情况：</span>
													<textarea rows="3" type="text" class="form-control el_modelinput texta" value="" 
														id="" name="" />措施执行情况</textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">措施是否有效：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="" name="">
														<option value="" id="option0">--请选择--</option>
														<option value="">有效</option>
														<option value="">无效</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">考核情况：</span>
													<textarea rows="3" type="text" class="form-control el_modelinput texta" value="" 
														id="" name="" />措施执行情况</textarea>
												</div>
												
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
								</div>
								</div><!-- /.modal -->
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