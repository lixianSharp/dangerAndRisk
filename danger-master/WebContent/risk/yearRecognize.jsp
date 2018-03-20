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
<title>年度辨识管理</title>

<%@ include file="/controls/cssJs.jsp"%>
<!-- 弹出层插件 -->
<script type="text/javascript" src="<%=path%>/js/risk/plug-in.js"></script>

<!-- 年度辨识管理界面对应的js文件 -->
<script type="text/javascript" src="<%=path%>/js/risk/yearRecognize.js"></script>
<!-- 用于表单校验的 -->
<script type="text/javascript" src="<%=path%>/js/jquery.validate-1.13.1.js"></script>

<!-- 设置一个JS全局变量记录项目名字 -->
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
</script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />
</head>



<body>

	<form id="detailForm" action="${pageContext.request.contextPath }/identify_detailOpY.action" method="post">
		<!-- 隐藏要提交的数据 -->
		<input id="detailidenranid" type="hidden" name="idenranid" value="">
	</form>
	
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
						<span>风险管理 </span><span>> 年度辨识管理</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									<div>
									<button  class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onClick="$.Pop('每个年度只能有一条年度辨识信息，可以通过“详情”维护年度风险辨识信息。','confirm',function(){}),addOpenBtn()" >新增</button>
									</div>
									<script type="text/javascript">
									
									</script>
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<!-- <th>操作</th> -->
												<th>序号</th>
												<th>年度</th>
												<th>风险数量</th>
												<th>会议地点</th>
												<th>主持人</th>
												<th>记录人</th>
												<th>参会人员</th>
												<th>会议内容</th>
												<th width="140">操作</th>
											</tr>
										</thead>
										<tbody id="tbody">
											<tr>
												<td>
												<input type="checkbox">
												</td>
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
												未评估
												</td>
												<td>
												张三
												</td>
												<td>
												李四
												</td>
												<td>
													<a data-toggle="modal" data-target="#modifierDuty" >修改</a>
													<a href="<%=path%>/risk/yearRisk.jsp">详情</a>
												</td>
											</tr>

										</tbody>
									</table>

								<!-- 模态框（新增年度辨识信息） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增年度辨识信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addForm">
												<!-- 隐藏域，隐藏年度辨识的标记 -->
												<input type="hidden" name="identify.identifymark" value="Y"/>
												
												<!-- 隐藏域，隐藏年度 -->
												<input id="strTime" type="hidden" name="identifyNTime">
												
												
											   <div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">年&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate5"
													type="text" placeholder="点击选择年份" value=""
													 name="yearDate" onclick="addYearChange()" /><!-- name="identify.year" -->
												</div>  
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">地&nbsp;&nbsp;点：</span>
													<input type="text" class="form-control el_modelinput"
														id="addmeetingaddress" name="identify.meetingaddress" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">主持&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="addcompere" name="identify.compere" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">记录&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="addrecorder" name="identify.recorder" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">参会人员：</span>
													<input type="text" class="form-control el_modelinput"
														id="addparticipants" name="identify.participants" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">会议内容：</span>
													<textarea id="addmeetingcontent" class="form-control texta"
													rows="5" name="identify.meetingcontent"></textarea>
												</div>
												
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="addSave()">
													保存
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								<!-- 模态框（修改年度辨识信息） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改年度辨识信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateForm">
													<!-- 隐藏域，隐藏要修改的年度辨识的id -->
													<input id="updateidenranid" type="hidden" name="identify.identiryid" value="">
													
													<!-- 隐藏域，隐藏年度 -->
													<input id="updatestrTime" type="hidden" name="identifyNTime" value="">
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">年&nbsp;&nbsp;份：</span>
													<input
													class="datainp wicon form-control" id="optsdate520"
													type="text" placeholder="" value="" name="updateYearDate" readonly="readonly"/>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">地&nbsp;&nbsp;点：</span>
													<input type="text" class="form-control el_modelinput"
														id="updatemeetingaddress" name="identify.meetingaddress" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">主持&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="updatecompere" name="identify.compere" />
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">记录&nbsp;人：</span>
													<input type="text" class="form-control el_modelinput"
														id="updaterecorder" name="identify.recorder" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">参会人员：</span>
													<input type="text" class="form-control el_modelinput"
														id="updateparticipants" name="identify.participants" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">会议内容：</span>
													<textarea id="updatemeetingcontent" class="form-control texta"
													rows="5" name="identify.meetingcontent"></textarea>
												</div>
												
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="updateBtn()">
													确认修改
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->

									<!-- 隐藏当前页页号 默认值为1 -->
									<input id="currentPage" type="hidden" value="1"/>
									<!-- 隐藏每页显示的记录数 -->
									<input id="currentCount" type="hidden" value="10"/>
									<div id="paginationIDU"></div>
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

	</div>

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>