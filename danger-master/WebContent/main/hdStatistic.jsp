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

<!--下拉树-->
<link rel="stylesheet" href="<%=path%>/controls/selectDropTree/demo.css"
	type="text/css">

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />
<script type="text/javascript" src="${baseurl }/js/dateformat.js"></script>
<script type="text/javascript" src="${baseurl }/js/hdStatistic.js"></script>
<!--索引-->
<style>
#optsdate22 {
	position: absolute;
	top: 0;
	left: 200px;
}

#optsdate2, #optsdate22 {
	width: 100px;
	margin-top: 5px;
}
/*表格最后一行的样式，合计样式*/
.table1 tr:last-child {
	font-weight: bolder;
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
						<span>隐患管理 </span><span>> 隐患统计</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--索引-->
							<div class="row el_queryBox">
								<form action="${baseurl }/tongjiInfo.action" method="POST">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">时间：</span>
												 <input type="text"
													name="startTime" id="optsdate2" value="${startTime }"
													class="form-control el_modelinput" readonly
													placeholder="起始时间" />
												<span>&nbsp;&nbsp;&nbsp;&nbsp;到</span> <input type="text"
													name="endTime" id="optsdate22" value="${endTime }"
													class="form-control el_modelinput" readonly
													placeholder="结束时间" />
											</div>
										</div>

									</div>
									<!-- 隐藏查询条件的页号 -->
									<input type="hidden" name="currentPage" id="currentPage">
									<!--提交查询按钮-->
									<button type="submit"
										class="btn btn-default el_queryButton btn-sm">查询</button>
									<!-- 清空按钮 -->
									<button class="btn btn-default el_queryButton btn-sm" style="right:120px;" onclick="clearBtn()" >清空</button>
								</form>

							</div>
							<!--结束 查询表单提交-->
							<!-- 清空按钮 的点击事件-->
							<script type="text/javascript">
								function clearBtn(){
									//清空起始时间
									$("#optsdate2").val("");
									
									//清空结束时间
									$("#optsdate22").val("");									
								}
							</script>
							

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">


								<!--按钮面板-->
								<div class="panel panel-default">
									<div class="panel-body el_MainxiaoMain">

										<%-- <div class="el_topButton">
											<a href="${baseurl }/main/chartsAnaly.jsp">
												<button class="btn btn-primary">统计分析</button>
											</a>
										</div> --%>

									</div>

									<!--表格
                            内容都提取到json里边
                        -->
									<table class="table table-hover table-bordered table1">
										<thead>
											<th>序号</th>
											<th>单位</th>
											<th>A级别</th>
											<th>B级别</th>
											<th>C级别</th>
											<th>采煤</th>
											<th>开掘</th>
											<th>机电</th>
											<th>运输</th>
											<th>通风</th>
											<th>地测</th>
											<th>其他</th>
										</thead>
										
										<tbody>
											<c:forEach var="tongjiInfo" items="${result.tongjiInfoList}"
												varStatus="status">
												<tr>
													<td>${ status.index +1}</td>

													<td>${tongjiInfo.checkunit }</td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','A','','${startTime }','${endTime }')">${tongjiInfo.aji }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','B','','${startTime }','${endTime }')">${tongjiInfo.bji }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','C','','${startTime }','${endTime }')">${tongjiInfo.cji }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','采煤','${startTime }','${endTime }')">${tongjiInfo.caimei }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','开掘','${startTime }','${endTime }')">${tongjiInfo.kaijue }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','机电','${startTime }','${endTime }')">${tongjiInfo.jidian }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','运输','${startTime }','${endTime }')">${tongjiInfo.yunshu }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','通风','${startTime }','${endTime }')">${tongjiInfo.tongfeng }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','地测','${startTime }','${endTime }')">${tongjiInfo.dice }</a></td>
													<td><a href="javascript:void(0)"
														onclick="queryNum('${tongjiInfo.checkunit }','','其他','${startTime }','${endTime }')">${tongjiInfo.qita }</a></td>
												</tr>
											</c:forEach>

											<tr style="background-color: #D1EEEE">
												<td></td>
												<td>合计</td>
												<td>${result.totalInfo.aji }</td>
												<td>${result.totalInfo.bji }</td>
												<td>${result.totalInfo.cji }</td>
												<td>${result.totalInfo.caimei }</td>
												<td>${result.totalInfo.kaijue }</td>
												<td>${result.totalInfo.jidian }</td>
												<td>${result.totalInfo.yunshu }</td>
												<td>${result.totalInfo.tongfeng }</td>
												<td>${result.totalInfo.dice }</td>
												<td>${result.totalInfo.qita }</td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>


						</div>

					</div>

					<!-- 模态框 统计详细信息-->
					<div class="modal fade" id=dangerTongjiInfo tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<!--关闭符号-->
									<!--标题-->
									<h3 class="modal-title">安全隐患列表</h3>
								</div>
								<form>
									<div class="modal-body">
										<div class="" id="motaiinfo">
											<!-- 动态放入数据 -->
											<table class="table table-bordered  table-hover"
												id="dangerTable">
												<thead>
													<tr>
														<th>序号</th>
														<th>检查单位</th>
														<th>地点</th>
														<th>发现人</th>
														<th>隐患级别</th>
														<th>责任单位</th>
														<th>隐患状态</th>
														<th>隐患类型</th>
														<th>检查时间</th>
													</tr>
												</thead>
											</table>
											<!--分页-->
											<!-- <div id="paginationIDU"></div> -->
										</div>

									</div>
									<div class="modal-footer">
										<!-- 分页组件 -->
										<div id="paginationIDU1"></div>
										<!-- <button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button> -->
									</div>

								</form>

							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>



					<!--放脚-->
					<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>

