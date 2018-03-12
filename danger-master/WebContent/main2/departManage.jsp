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
<title>机构管理</title>
<%@ include file="/controls/cssJs.jsp"%>

<!--下拉树-->
<link rel="stylesheet" type="text/css" media="screen"
	href="../controls/zTree/zTreeStyle/zTreeStyle.css" />
	
<script type="text/javascript" src="../js/unit/unit.js"></script>

<script type="text/javascript" src="../js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="../js/jquery.validate-1.13.1.js"></script>

<!--下拉树, 用于固定分页样式。否则分页内容上漂-->
<link rel="stylesheet" href="<%=path%>/controls/selectDropTree/demo.css" type="text/css">
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
			<div class="panel-heading">
				<span>系统管理</span><span>>机构管理</span>
			</div>
			<div class="panel-body el_main">
				<!--树-->
				<div class="el_leftTree">
					<!--标题类，添加了一个颜色-->
					<span class="el_treeTitle">机构</span>
					<div class="ztree" style="width:165px;height:450px;overflow:auto;" id="treeDemo"></div>
				</div>

				<!--内容-->
				<div class="el_qlmContent">
				<form id="unitForm" method="POST">
					<!--索引-->
					<div class="row el_queryBox">
						<!-- <div class="col-md-4 el_qlmQuery">
							<div class="input-group" role="toolbar">
								<span class="el_spans">机构编号：</span> <input type="text"
									class="form-control" id="s_id" />
									
									
									
							</div>
						</div> -->
						<div class="col-md-4 el_qlmQuery">
							<div class="input-group" role="toolbar">
								<span class="el_spans">机构名称：</span> <input type="text"
									class="form-control" id="s_name" name="name"/>
									<!-- 分页 -->
									<input type="hidden" name="currentPage" id="currentPage" />
									<input type="hidden" name="currentCount" id="currentCount" />
									
									
									
							</div>
						</div>
						
						  <!--清空按钮-->

						<button type="reset"
							class="btn btn-default btn-sm"
							style="position:absolute;right:120px;top:15px;">清空</button>

                        
						<!--提交查询按钮-->
						<button type="button"
							class="btn btn-default btn-default el_queryButton btn-sm" id="condition_sub" onclick="query()">查询</button>
						
					</div>
					<!--结束 查询表单提交-->
				</form>
					<!--显示内容-->
					<h3 class="el_mainHead">机构信息</h3>
					<div class="panel panel-default el_Mainmain">

						<!--按钮面板-->
						<div class="panel-body">
							<div class="panel panel-default">
								<div class="panel-body el_MainxiaoMain">
									<div class="el_topButton">

										<button class="btn btn-primary" id="unit_add"
											data-toggle="modal" data-target="#add_modal">添加</button>
										<button class="btn btn-primary floatR modal_btn "
											id="unit_change" data-toggle="modal"
											data-target="#department_fix_modal">修改</button>
										<button class="btn btn-primary floatR modal_btn "
											id="unit_delete">删 除</button>
										<input type="hidden" value="" id="bt_unitId" name="upDepartmentId"> 
										<!-- <input type="hidden" value="" id="bt_unitId"> --> <input
											type="hidden" value="" id="bt_unitName"> <input
											type="hidden" value="" id="bt_upUnitId"> <input
											type="hidden" value="" id="bt_upUnitName"> <input
											type="hidden" value="" id="table_row">

									</div>
								</div>
							</div>

							<table class="table table-hover table-bordered" id="unitTable">
								<thead>
									<th>序号</th>
									<!-- <th>机构编号</th> -->
									<th>机构名称</th>
									<!-- <th>上级机构编号</th> -->
									<th>机构负责人</th>
									<th>联系方式</th>
								</thead>
							</table>

							<!--分页-->
							<div id="paginationIDU"></div>
							<!-- <script>
								$('#paginationIDU').pagination(
										{
											//			组件属性
											"total" : 10,//数字 当分页建立时设置记录的总数量 1
											"pageSize" : 10,//数字 每一页显示的数量 10
											"pageNumber" : 1,//数字 当分页建立时，显示的页数 1
											"pageList" : [ 10],//数组 用户可以修改每一页的大小，
											//功能
											"layout" : [ 'list', 'sep',
													'first', 'prev', 'manual',
													'next', 'last', 'links' ],
											"onSelectPage" : function(pageNumber, b) {
												alert("当前页页号pageNumber="+ pageNumber);
												alert("每页显示的记录数pageSize=" + b);
											}
										});
							</script> -->
						</div>
					</div>

					<!-- 模态框 机构添加-->
					<div class="modal fade" id="add_modal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<!--关闭符号-->
									<!--标题-->
									<h4 class="modal-title" id="myModalLabel21">添加机构信息</h4>
								</div>
								<form id="addForm">
									<div class="modal-body">
										<div class="input-group el_modellist" role="toolbar">
											<!-- <span class="el_spans">上级机构编号：</span> --> <input type="hidden"
												class="form-control el_modelinput el_chooseInput"
												id="tdap_add_id" name="" disabled />
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">上级机构名称：</span> <input type="text"
												class="form-control el_modelinput el_chooseInput"
												id="tdap_add_name" name="" disabled />
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<!-- <span class="el_spans">机构编号：</span>  --><input type="hidden"
												class="form-control el_modelinput" id="unit__id" name=""
												disabled /> <span></span>
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">机构名称：</span> <input type="text"
												class="form-control el_modelinput" id="unit__name" name="unit__name" />
											<span></span>
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">机构负责人：</span> <input type="text"
												class="form-control" id="unit__manager" name="unit__manager"/>
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">联系方式：</span> <input type="text"
												class="form-control" id="unit__phone" name="unit__phone"/>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-primary"
											id="tdapartm_add_save">保存</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>

					<!-- 模态框 机构修改-->
					<div class="modal fade" id="department_fix_modal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<!--关闭符号-->
									<!--标题-->
									<h4 class="modal-title" id="myModalLabel2">修改机构信息</h4>
								</div>
								<form id="updateForm">
									<div class="modal-body">
										<div class="input-group el_modellist" role="toolbar">
											<!-- <span class="el_spans">上级机构编号：</span>  --><input type="hidden"
												class="form-control el_modelinput el_chooseInput"
												id="xdap_add_id" name="" disabled />
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">上级机构名称：</span> <input type="text"
												class="form-control el_modelinput el_chooseInput"
												id="xdap_add_name" name="" disabled />
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<!-- <span class="el_spans">机构编号：</span> --> <input type="hidden"
												class="form-control el_modelinput" id="unit___id" name=""
												disabled /> <span></span>
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">机构名称：</span> <input type="text"
												class="form-control el_modelinput" id="unit___name" name="unit___name" />
											<span></span>
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">机构负责人：</span> <input type="text"
												class="form-control" id="unit___manager" name="unit___manager" />
										</div>
										<div class="input-group el_modellist" role="toolbar">
											<span class="el_spans">联系方式：</span> <input type="text"
												class="form-control" id="unit___phone" name="unit___phone" />
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-primary"
											id="xdapartm_add_save">保存</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">关闭</button>
									</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
				</div>
			</div>
		</div>
	</div>
		</div>
	</div>
</body>
</html>