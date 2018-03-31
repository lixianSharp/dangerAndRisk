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
<script type="text/javascript" src="<%=path%>/js/risk/riskConstitute.js"></script>
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


							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">
							<!-- 灾害类型风险构成 -->
							<div  class="col-md-12">
							<div class="col-md-6">
							<!-- <h4 align="center">当前重大风险共12处</h4> -->
							<h4 align="center" id="top"></h4>
							<table class="table table-hover table-bordered">
						<thead>
							<tr>
							<th>灾害类型</th>
							<th>风险数量</th>
							<th>占比</th>
							</tr>
							</thead>
								<tbody>
							<tr>
							<td>水</td>
							<td id="shuiCountId"></td>
							<td id="shuiScaleId"></td>
							</tr>
							<tr>
							<td>火</td>
							<td id="huoCountId"></td>
							<td  id="huoScaleId"></td>
							</tr>
							<tr>
							<td>瓦斯</td>
							<td id="wasiCountId"></td>
							<td  id="wasiScaleId"></td>
							</tr>
							<tr>
							<td>顶板</td>
							<td id="dingbanCountId"></td>
							<td  id="dingbanScaleId"></td>
							</tr>
							<tr>
							<td>煤层</td>
							<td id="meicengCountId"></td>
							<td  id="meicengScaleId"></td>
							</tr>
							<tr>
							<td>冲击地压</td>
							<td id="diyaCountId"></td>
							<td  id="diyaScaleId"></td>
							</tr>
							<tr>
							<td>提升运输</td>
							<td id="yunshuCountId"></td>
							<td id="yunshuScaleId"></td>
							</tr>
							</tbody>
							
							</table>
							</div>
							
							
							<div id="riskType" class="col-md-6" style="height:320px;">
							
							</div>
							</div>
							<!-- 失效风险责任部门分布情况 -->
							<div id="riskDep" class="col-md-12" style="height:400px;">
							
							</div>
								<script type="text/javascript">
				/* 				  // 基于准备好的dom，初始化echarts实例
						        var myChart = echarts.init(document.getElementById('riskType'));

						        // 指定图表的配置项和数据
						        var option = {
						    title : {
						        text: '风险构成',
						        x:'center'
						    },
						    tooltip : {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    legend: {
						        x : 'center',
						        y : 'bottom',
						        data:['水','火','瓦斯','顶板','煤尘','冲击地压','提升运输']
						    },
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {
						                show: true,
						                type: ['pie', 'funnel']
						            },
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    calculable : true,
						    series : [
							
						        {
						            name:'风险构成',
						            type:'pie',
						            radius : [0, 100],//设置中心是否有空心圆
						            center : ['50%', '50%'],
						         
						            data:[
						                {value:10, name:'水'},
						                {value:5, name:'火'},
						                {value:15, name:'瓦斯'},
						                {value:25, name:'顶板'},
						                {value:20, name:'煤尘'},
						                {value:35, name:'冲击地压'},
						                {value:30, name:'提升运输'},
						            ]
						        }
						    ]
						};

						        // 使用刚指定的配置项和数据显示图表。
						        myChart.setOption(option);*/
						         
						    /*  // 基于准备好的dom，初始化echarts实例
						        var myChart1 = echarts.init(document.getElementById('riskDep'));
						
						        // 指定图表的配置项和数据
						        var option1 = {
						            title: {
						                text: '失效风险地点分布情况',
					                	left: 'center'
						            },
						             tooltip: {},//提示框 
						           
						            xAxis: {
						                data: ["总数量","3256工作面","32986工作面","458工作面","井口","洗煤机出口"]
						            },
						            yAxis: {},
						            series: [{
						                name: '失效风险地点',
						                type: 'bar',
						                data: [9, 1, 1, 1, 2,4]
						            }]
						        };
						
						        // 使用刚指定的配置项和数据显示图表。
						        myChart1.setOption(option1); */
							        
							        
							       
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