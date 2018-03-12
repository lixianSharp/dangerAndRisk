<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ include file="/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>yorge的用户管理</title>

<%@ include file="/controls/cssJs.jsp"%>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<style>
.el_right {
	position: relative;
}

#baseInfo {
	width: 400px;
	height: auto;
	position: absolute;
	top: 20px;
	left: 70%;
	padding: 20px;
	/* box-shadow:4px 4px 3px #ccc,-4px -4px 3px #ccc; */
}

#baseInfo span {
	display: block;
	color: black;
	font-size: 20px;
	font-weight: bolder;
    -webkit-animation: marquee 15s linear infinite;
    animation: marquee 3s linear infinite;
}
@keyframes marquee {
    0% {
        transform: translateX(-30px);
    }
    100% {
        transform: translateX(+30px); // 每行高50
    }
}
</style>
<script>
	$(function(){	
        $("#leftbackground").hide();
        $(this).hide();
        $(".el_right").css("width","100%");
        $("#rightArrow").css("display","block");
	})
</script>
</head>
<body>
	<!--头-->
	<jsp:include page="public/header.jsp"></jsp:include>

	<!--中部-->
	<div class="html_middle">

		<!--放菜单-->
		<div id="leftbackground">
			<jsp:include page="public/menu.jsp"></jsp:include>
			<img src="<%=path%>/image/leftArrow.jpg" id="leftArrow" />
		</div>
		<img src="<%=path%>/image/rightArrow.jpg" id="rightArrow" />

		<!--放主界面内容-->
		<div class="el_right" style="background:#aee6fe;margin-bottom:10px;position:relative;top:-3px;">
			<%-- <img src="<%=path %>/image/hdMain.jpg" width="100%" /> --%>
			<span style="font-size:60px;font-weight:bolder;position:absolute;left:25%;top:20%;">欢迎进入隐患排查系统</span>
			
			<div id="baseInfo">
				<!-- <span>未五定隐患：23</span>
				<span>复查不通过隐患：23</span> -->
				<span><a href="${baseurl }/queryView_findDanger2.action"><h3>点击这里进行隐患处理>></h3></a></span>
			</div>
		</div>

		</div>
		<!--放脚-->
		<jsp:include page="public/footer.jsp"></jsp:include>
</body>
</html>