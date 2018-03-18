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
<title>风险清单</title>

<%@ include file="/controls/cssJs.jsp"%>
<script type="text/javascript" src="<%=path%>/js/risk/plug-in.js"></script>
<script type="text/javascript" src="<%=path%>/js/risk/riskInventory.js"></script>

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
						<span>风险管理 </span><span>> 风险清单</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">
							<!--索引-->
							<div class="row el_queryBox">
								<form
									action=""
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												
												<span class="el_spans el_chooseSpan">风险等级：</span> 
												<select id="riskGradeCondition"
													class="selectpicker form-control" title="请选择" name="type">
													<!-- <option value="0">--全部--</option>
													<option value="未评估">一级</option>
													<option value="已评估">二级</option> -->
												</select>
											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">风险类型：</span>
												 <select id="riskTypeCondition"
													class="selectpicker form-control" title="请选择" name="type">
													<!-- <option value="0">--全部--</option>
													<option value="未评估">火</option>
													<option value="已评估">水</option> -->
												</select>
											</div>
										</div>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">专业类型：</span>
												  <select id="proTypeCondition"
													class="selectpicker form-control" title="请选择" name="type">
													<!-- <option value="0">--全部--</option>
													<option value="未评估">煤矿</option>
													<option value="已评估">井口</option> -->
												</select>
											</div>
										</div>
										<div class="col-md-3 el_qlmQuery" style="top: 5px;">
											<div class="input-group" role="toolbar">
												<span class="el_spans">灾害类型：</span>
												  <select id="disasterTypeCondition"
													class="selectpicker form-control" title="请选择" name="type">
													<!-- <option value="0">--全部--</option>
													<option value="未评估">煤矿</option>
													<option value="已评估">井口</option> -->
												</select>
											</div>
										</div>
										<button type="button"
										class="btn btn-primary el_queryButton btn-sm"  style="left: 963.617px;" onclick="findBtn()">查询</button>
									<button type="button" class="btn btn-default btn-sm" style="margin-top: 20px;margin-left: 135px;" onclick="clearBtn()" >清空</button>
									</div>
								</form>
							</div>
							<!--结束 查询表单提交-->
							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">
								<!--按钮面板-->
								<div class="panel-body">
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>序号</th>
												<th>风险来源</th>
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
												<th>可能性（L）</th>
												<th>人员暴露频繁程度（E）</th>
												<th>损失后果（C）</th>
												<th>风险值（D）</th>
												<th>风险等级</th>
												
											</tr>
										</thead>
										<tbody id="tbody">
											<!-- <tr>
												<td>
												1
												</td>
												<td>
												年度专项辨识
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
												</td>
												<td>
												煤灰
												</td>
												<td>
												一级风险
												</td>
												<td>
												未评估
												</td>
												<td>
												十人死亡
												</td>
												<td>
												666
												</td>
												<td>
												一级风险
												</td>
												
											</tr> -->

										</tbody>
									</table>
								</div>
								<div id="paginationIDU"></div>
									<!-- 隐藏当前页页号 -->
									<input id="currentPage" type="hidden" value="1"/>
									<!-- 隐藏每页显示的记录数 -->
									<input id="currentCount" type="hidden" value="10"/>
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

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>