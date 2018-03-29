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
<title>隐患日报</title>
<%@ include file="/controls/cssJs.jsp"%>

<!--下拉树, 用于固定分页样式。否则分页内容上漂-->
<link rel="stylesheet" href="<%=path%>/controls/selectDropTree/demo.css" type="text/css">

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<script type="text/javascript" src="<%=path%>/js/danger/hdDayReport.js"></script>

<script>
/* 根据部门修改颜色 */
/* 定义颜色数组 */
var randColor = {"#ffe5e5","#ecffe5","#e5ffff","#f6e5ff","feffe5"};

var trLength = $("#tableStyle tr").length;
var depart = $("#tableStyle tr");
var departName = $("#tableStyle tr").children(".unitName").text();
for(int i = 0; i < trLenght; i ++) {
	departName[0];
	
	/* if(i == 0) {
		depart[0].css("background-color",randColor[0]);
	} else {
		if(departName[i] == departName[i-1]) {
			depart[i].css("background-color",randColor[0]);			
		} else {
			depart[i]
		}
	} */
	
}
</script>

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
						<span>隐患管理 </span><span>> 隐患日报</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--索引-->
							<div class="row el_queryBox">
								<form action="${baseurl }/queryView_findDangerSFR.action"
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">发现日期：</span>
												<input class="datainp wicon form-control el_modelinput" id="optsdate2" type="text" 	name="findtime" value="${findtime }" /> 
											</div>
										</div>

									</div>
									<!-- 隐藏的当前页大小与页号 -->
									<input type="hidden" name="currentPage" id="currentPage" /> 
									<input	type="hidden" name="currentCount" id="currentCount" />
									<!--提交查询按钮-->
									<button type="submit" class="btn btn-default el_queryButton btn-sm">查询</button>
									<!-- 清空按钮 -->
									<button class="btn btn-default el_queryButton btn-sm" style="right:120px;" onclick="clearBtn()">清空</button>						
								</form>

							</div>
							<!--结束 查询表单提交-->
							<!-- 清空按钮 的点击事件-->
							<script type="text/javascript">
								function clearBtn(){
									$("#optsdate2").val("");
								}
							</script>
							

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!-- <div class="el_ReportTime">
                        <span>时间：</span>
                        <span>2014-12-15</span>
                    </div> -->

								<!--按钮面板-->
								<div class="panel-body">
										<button class="btn btn-primary" onclick="exportRiskList()">导出</button>
									<!-- 表格  -->
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>序号</th>
												<th>责任单位</th>
												<th>存在的隐患问题</th>
												<th>隐患类型</th>
												<th>级别</th>
												<th>隐患发现人</th>
												<th>解决时间</th>
												<th>负责人</th>
												<th>督办人</th>
												<th>复查时间</th>
												<th>复查人</th>
												<th>是否销号</th>
											</tr>
										</thead>
										<tbody id="tableStyle">
											<c:forEach var="danger"
												items="${result.pageBean.productList }" varStatus="status">
												<tr>
													<td>${ status.index + (result.pageBean.currentPage-1)*10+1}</td>
													<td class="unitName">${danger.unit }</td>
													<td>${danger.content}</td>
													<td>${danger.type }</td>
													<td>${danger.dangergrade }</td>
													<td>${danger.findperson }</td>
													<td><fmt:formatDate value="${danger.rechecktime}"
															pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
													<td>${danger.dutyperson}</td><%-- <td>${danger.manager}</td> --%>
													<td>${danger.supervisor}</td>
													<td><fmt:formatDate value="${danger.recheckdate}"
															pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
													<td>${danger.recheckman }</td>
													<td><c:if test="${danger.recheckresult eq 0 }">否</c:if>
														<c:if test="${danger.recheckresult eq 1 }">是</c:if></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>


							<!-- 模态框（导出） -->
							<div class="modal fade" id="deleteDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
											导出
											</h4>
										</div>
										<div class="modal-body">
											您确定要导出吗?
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">关闭
											</button>
											<!-- 隐藏导出的文件的文件名 -->
											<input id="exportFileNameHidden" type="hidden" value=""/>
											<%-- // href="${pageContext.request.contextPath}/export_down.action?name=" --%>
											<a id="exportATag" class="btn btn-primary" href="#" onclick="clickCloseModal()">
												导出
											</a>
										</div>
									</div><!-- /.modal-content -->
								</div>
							</div><!-- /.modal -->



									<div id="paginationIDU"></div>
									<script>
										$('#paginationIDU').pagination(
												{
													//			组件属性
													"total" :${result.pageBean.totalCount},//数字 当分页建立时设置记录的总数量 1
													"pageSize" : 10,//数字 每一页显示的数量 10
													"pageNumber" : ${result.pageBean.currentPage},//数字 当分页建立时，显示的页数 1
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