<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ include file="/tag.jsp"%>
<!-- 引入shiro标签，使用jsp标签的授权方式进行授权 -->
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单</title>

<link rel="stylesheet" href="<%=path%>/css/public/menu.css" />
</head>
<body>
<!--头-->
	<jsp:include page="public/header.jsp"></jsp:include>
	
<!-- 最大的DIV start -->
<div>
	<div class="el_left" id="el_left" style="width:13%;float: left;">
		<!--左边索引模块-->
		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">

			<!--隐患管理-->
			<div class="panel panel-default el_bigMenu" value="0">
				<div class="panel-heading" role="tab" id="heading1" style="width:180px">
					<span role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse1" aria-expanded="true" aria-controls="collapse1"
						class="el_title" id="heading11"> 隐患管理 </span>
				</div>
				<div id="collapse1" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="heading1" >
					<ul class="list-group">
						<shiro:hasPermission name="danger:insert">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/main/hdInsert.jsp" class="towmenu"
							aria-controls="profile"> 隐患录入 </a></li>
						</shiro:hasPermission>
						<%-- <li class="list-group-item"><a id="#handle"
							href="${baseurl }/queryView_findDanger.action?first=spotDispose"
							class="towmenu" aria-controls="profile" role="tab"> 现场处理 </a></li> --%>
						<shiro:hasPermission name="danger:spot">
						<li class="list-group-item"><a id="#handle"
							href="${baseurl }/queryView_findDanger.action?first=spotDispose"
							class="towmenu" aria-controls="profile" role="tab"> 现场处理 </a></li>
						</shiro:hasPermission>
						<%-- <li class="list-group-item"><a id="#hdfour"
							href="${baseurl }/queryView_findSiding.action?tag=formalSiding&first=siding"
							class="towmenu" aria-controls="profile" role="tab"> 隐患五定 </a></li> --%>
						<shiro:hasPermission name="danger:siding">
						<li class="list-group-item"><a id="#hdfour"
							href="${baseurl }/queryView_findSiding.action?tag=formalSiding&first=siding"
							class="towmenu" aria-controls="profile" role="tab"> 隐患五定 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:follow">
						<li class="list-group-item"><a id="#hdtrace"
							href="${baseurl }/queryView_findDangerS.action?first=follow"
							class="towmenu" aria-controls="profile" role="tab"> 隐患跟踪 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:recheck">
						<li class="list-group-item"><a id="#hdReview"
							href="${baseurl }/queryView_findDangerSF.action?first=review"
							class="towmenu" aria-controls="profile" role="tab"> 隐患复查 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:find">
						<li class="list-group-item"><a id="#hdQuery"
							href="${baseurl }/queryView_findDanger2.action" class="towmenu"
							aria-controls="profile" role="tab"> 隐患查询 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:dayReport">
						<li class="list-group-item"><a id="#hdDayReport"
							href="${baseurl }/queryView_findDangerSFR.action" class="towmenu"
							aria-controls="profile" role="tab"> 隐患日报 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:statistic">
						<li class="list-group-item"><a id="#hdStatistic"
							href="${baseurl }/tongjiInfo.action" class="towmenu"
							aria-controls="profile" role="tab"> 隐患统计 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="danger:monthReport">
						<li class="list-group-item"><a id="#hdMonthReport"
							href="${baseurl }/queryView_findDangerSFR1.action"
							class="towmenu" aria-controls="profile" role="tab"> 隐患月报 </a></li>
						</shiro:hasPermission>	
						<%-- <li class="list-group-item"><a id="#queryUser5"
							href="<%=path%>/hdmanage/" class="towmenu"
							aria-controls="profile" role="tab" data-toggle="tab"> 隐患分类 </a></li> --%>
							
						<%-- <li class="list-group-item"><a id="#queryUser6"
							href="<%=path%>/hdmanage/" class="towmenu"
							aria-controls="profile" role="tab" data-toggle="tab"> 短信提醒 </a></li> --%>
							
					</ul>
				</div>
				<!-- 风险管理 -->
				<div class="panel-heading" role="tab" id="heading1" style="width:180px">
					<span role="button" data-toggle="collapse" data-parent="#accordion"
						href="#collapse3" aria-expanded="true" aria-controls="collapse1"
						class="el_title" id="heading11"> 风险管理 </span>
				</div>
				<div id="collapse3" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="heading1">
					<ul class="list-group">
						<shiro:hasPermission name="risk:duty">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/risk/dutyDivide.jsp" class="towmenu"
							aria-controls="profile"> 职责分工 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:range">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/risk/riskRecognize.jsp" class="towmenu"
							aria-controls="profile"> 辨识范围 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:yearIdentify">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/risk/yearRecognize.jsp" class="towmenu"
							aria-controls="profile"> 年度辨识 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:specialIdentify">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/risk/specialRecognize.jsp" class="towmenu"
							aria-controls="profile"> 专项辨识 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:evaluate">
						<li class="list-group-item"><a id="#hdInsert"
							href="<%=path%>/risk/riskEvaluate.jsp" class="towmenu"
							aria-controls="profile"> 风险评估 </a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:list">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/riskInventory.jsp" class="towmenu"
						aria-controls="profile"> 风险清单 </a></li>
						</shiro:hasPermission>
						
						<!-- 月管控计划 -->
						<shiro:hasPermission name="risk:monthPlan">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/monthRiskControlPlan.jsp" class="towmenu"
						aria-controls="profile">月风险管控计划</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:monthPlanAnalysis">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/monthRiskControlPlanAnalyze.jsp" class="towmenu"
						aria-controls="profile">月风险管控计划分析</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:monthPlanEffective">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/monthRiskPlanValidity.jsp" class="towmenu"
						aria-controls="profile">月风险管控计划有效性</a></li>
						</shiro:hasPermission>
						
						<!-- 周风险管控 -->
						<shiro:hasPermission name="risk:xunPlan">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/weekRiskControlPlan.jsp" class="towmenu"
						aria-controls="profile">旬风险管控计划</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:xunPlanAnalysis">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/weekRiskControlPlanAnalyze.jsp" class="towmenu"
						aria-controls="profile">旬风险管控计划分析</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="risk:xunPlanEffective">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/weekRiskPlanValidity.jsp" class="towmenu"
						aria-controls="profile">旬风险管控计划有效性</a></li>
						</shiro:hasPermission>
						
						
						
						
						
						<shiro:hasPermission name="risk:statistical">
						<li class="list-group-item"><a id="#hdInsert"
						href="<%=path%>/risk/riskConstitute.jsp" class="towmenu"
						aria-controls="profile">风险构成级分布情况</a></li>
					    </shiro:hasPermission>
						
						
							
					</ul>
				</div>
				
				<!--  -->
			</div>

			<%-- <c:if test="${user.role gt 1 }"> --%>
				<!--系统管理-->
				<div class="panel panel-default el_bigMenu" value="1" >
					<div class="panel-heading" role="tab" id="heading2" style="width:180px">
						<span role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse2" aria-expanded="false"
							aria-controls="collapse2" class="el_title collapsed"
							id="heading12"> 系统管理 </span>
					</div>
					<div id="collapse2" class="panel-collapse collapse" role="tabpanel"
						aria-labelledby="heading2">
						<ul class="list-group">
							<shiro:hasPermission name="system:department">
							<li class="list-group-item"><a id="#departManage"
								href="<%=path%>/main2/departManage.jsp" class="towmenu"
								aria-controls="profile" role="tab"> 机构管理 </a></li>
							</shiro:hasPermission>
							<%-- <li class="list-group-item"><a id="#users"
								href="<%=path%>/main2/users.jsp" class="towmenu"
								aria-controls="profile" role="tab"> 用户管理 </a></li> --%>
							
							<shiro:hasPermission name="system:dictionary">
							<li class="list-group-item"><a id="#dictionary"
								href="<%=path%>/main2/dictionary.jsp" class="towmenu"
								aria-controls="profile" role="tab"> 字典管理 </a></li>
							</shiro:hasPermission>
							
							<shiro:hasPermission name="system:authority">
							<li class="list-group-item"><a id="#dictionary"
								href="<%=path%>/shiro/authManager.jsp" class="towmenu"
								aria-controls="profile" role="tab">权限管理 </a></li>
							</shiro:hasPermission>
							<%-- <li class="list-group-item"><a id="#role"
								href="<%=path%>/main2/role.jsp" class="towmenu"
								aria-controls="profile" role="tab"> 角色管理 </a></li> --%>
						</ul>
					</div>
				</div>
			<%-- </c:if> --%>

		</div>
	</div>
	
	<!-- 右边那块的div -->
	<div style="width:87%;float: right;font-size: 40px;text-align: center;color:LightGray;margin-top: 200px; ">
		欢迎使用煤矿安全隐患排查与风险分级管控管理系统
	</div>
</div><!-- 最大的DIV end -->	
	<!--放脚-->
		<jsp:include page="public/footer.jsp"></jsp:include>
</body>
</html>