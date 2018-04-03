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
<script type="text/javascript" src="<%=path%>/controls/echarts/echarts.js"></script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

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
						<span>风险管理 </span><span>>失效风险分布情况</span>
					</div>
						
					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">
							<h4>月管控计划失效风险信息</h4>
						<%--   <c:set value="${[]}" var="aList" />
					        <c:forEach items="${aList}" var="aNum">
					            ${aNum}
					        </c:forEach>
						 --%>
						
								<%--  <c:forEach var="riskInfo"	items="${result.dutyDepartmentList }"  varStatus="status">
									"${riskInfo.dutyDepartment }"
									"${riskInfo.count }""
																
								</c:forEach> 
								
								<c:forEach var="riskInfo"	items="${result.addressList }"  varStatus="status">
									${riskInfo.riskAddress }
									${riskInfo.count }
									
									
								</c:forEach>  --%>

								<table class="table table-hover table-bordered">
								
										<thead>
											<tr>
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
											
											</tr>
										</thead>
										<tbody>
										<c:forEach var="riskInfo"	items="${result.riskMsgList }"  varStatus="status">
											<tr>
											
											<!-- 下面是风险信息的字段 -->
											<td>${ status.index+1 }</td>
											<td>${riskInfo.riskaddress }</td>
											<td>${riskInfo.riskdescribe }</td>
											<td>${riskInfo.risktype }</td>
											<td>${riskInfo.professionaltypes }</td>
											<td>${riskInfo.disastertypes }</td>
											<td>${riskInfo.cancauseaccidents }</td>
											<td>${riskInfo.ctrlmeasure }</td>
											<td>${riskInfo.principal }</td>
											<td>${riskInfo.superintendent }</td>
											<td>${riskInfo.monitoringperiod }</td>
											
										
										</tr>
										</c:forEach>
										</tbody>
							</table>
							
								
						
					

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">
							
							
							
							<!-- 失效风险地点分布情况 -->
							<div id="loseRiskAttribute" class="col-md-12" style="width: 1000px;height:400px;">
							
							</div>
							<!-- 失效风险责任部门分布情况 -->
							<div id="loseRiskDep" class="col-md-12" style="width: 1000px;height:400px;">
							
							</div>
								<script type="text/javascript">
								
								
								
								
								
							        // 基于准备好的dom，初始化echarts实例
							        var myChart1 = echarts.init(document.getElementById('loseRiskAttribute'));
							
							       
							        // 指定图表的配置项和数据
							        var option1 = {
							            title: {
							                text: '失效风险地点分布情况',
						                	left: 'center'
							            },
							             tooltip: {},//提示框 
							        
							            xAxis: {
							                data: [<c:forEach var="riskInfo"	items="${result.addressList }"  varStatus="status">
											"${riskInfo.riskAddress}",																				
										</c:forEach>]
							            },
							            yAxis: {},
							            series: [{
							                name: '失效风险地点',
							                type: 'bar',
							                data: [<c:forEach var="riskInfo"	items="${result.addressList }"  varStatus="status">
											"${riskInfo.count }",																				
											</c:forEach>]
							            }]
							        };
							
							        // 使用刚指定的配置项和数据显示图表。
							        myChart1.setOption(option1);
							        
							        /*  */
							        // 基于准备好的dom，初始化echarts实例
							        var myChart = echarts.init(document.getElementById('loseRiskDep'));
							
							        // 指定图表的配置项和数据
							        var option = {
							            title: {
							                text: '失效风险责任部门分布情况',
							                left: 'center'
							            },
							            tooltip: {},//提示框
							       
							            xAxis: {
							            	data: [<c:forEach var="riskInfo"	items="${result.dutyDepartmentList }"  varStatus="status">
											'${riskInfo.dutyDepartment }',																				
										</c:forEach>]
							          //  data:
							            	
							            
							            },
							            yAxis: {},
							            series: [{
							                name: '失效风险责任部门',
							                type: 'bar',
							                data: [<c:forEach var="riskInfo"	items="${result.dutyDepartmentList }"  varStatus="status">
											'${riskInfo.count }',																				
											</c:forEach>]
							            }]
							        };
							
							        // 使用刚指定的配置项和数据显示图表。
							        myChart.setOption(option);
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