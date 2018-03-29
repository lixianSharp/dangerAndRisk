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
<title>专项风险信息管理</title>

<%@ include file="/controls/cssJs.jsp"%>

<script type="text/javascript" src="<%=path%>/js/risk/speciaRisk.js"></script>
<!-- 用于表单校验的 -->
<script type="text/javascript" src="<%=path%>/js/jquery.validate-1.13.1.js"></script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/risk/yearRecognize.css" />
<style type="text/css">
.yearReInfo table tr td:nth-child(2n+1) {

    background-color: #eee;
    width: 20%;
    text-align: center;
    border-left: 1px solid #ccc;

}

a {
  cursor:pointer;
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
						<span>风险管理 </span><span>> 专项辨识管理</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain" style="margin-top: 0px;">

								<!--按钮面板-->
								<div class="panel-body">
									<!-- 专项辨识基本信息 -->
									<div class="row el_queryBox" style=" border-bottom-width: 0px; margin-top: 0px;">
									<h4>专项辨识信息</h4>
									<div class="yearReInfo">
									<table class="table  table-bordered">
									<tr>
									<td>年份</td>
									<td><fmt:formatDate value="${identifyMainTableY.year }" pattern="yyyy-MM-dd"/></td>
									<td>地点</td>
									<td>${identifyMainTableY.meetingaddress }</td>
									</tr>
									<tr>
									<td>主持人</td>
									<td>${identifyMainTableY.compere}</td>
									<td>记录人</td>
									<td>${identifyMainTableY.recorder}</td>
									</tr>
									<tr>
									<td>参会人员</td>
									<td colspan="3">${identifyMainTableY.participants}</td>
									</tr>
									<tr>
									<td>会议内容</td>
									<td colspan="3">${identifyMainTableY.meetingcontent}</td>
									</tr>
									</table>
									</div>
									</div>

									<div>
									<h4>专项风险信息</h4>
									<button class="btn btn-primary" data-toggle="modal" data-target="#addDuty" onclick="addOpenBtn()">新增</button>
									<a class="btn btn-primary" href="${pageContext.request.contextPath }/export_exportIdentifyYS.action?identiryid=${identifyMainTableY.identiryid }">导出</a>
									
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<!-- <th>操作</th>  -->
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
												<th>状态</th>
												<th width="140">操作</th>
											</tr>
										</thead>
										<tbody id="tbody">
           									<%-- <c:forEach items="${pageBean.productList }" var="riIdentificationRriskMsg" varStatus="varstatus">  
								                <tr>  
	           										<td>
														<input type="checkbox">
													</td>
													<td>${varstatus.count }</td>
								                    <td>${riIdentificationRriskMsg.riskaddress }</td>  
								                    <td>${riIdentificationRriskMsg.riskdescribe }</td>  
								                    <td>${riIdentificationRriskMsg.risktype }</td>  
								                    <td>${riIdentificationRriskMsg.professionaltypes }</td>  
								                    <td>${riIdentificationRriskMsg.disastertypes }</td>  
								                    <td>${riIdentificationRriskMsg.cancauseaccidents }</td>  
								                    <td>${riIdentificationRriskMsg.ctrlmeasure }</td>  
								                    <td>${riIdentificationRriskMsg.principal }</td>  
								                    <td>${riIdentificationRriskMsg.superintendent }</td>  
								                    <td>${riIdentificationRriskMsg.monitoringperiod }</td> 
								                    <c:if test="${riIdentificationRriskMsg.evaluationstatus}=='N' ">
								                    	<td>未评估</td>
								                    </c:if>
								                    <td>${riIdentificationRriskMsg.evaluationstatus }</td> 
								                    <td>
													<a data-toggle="modal" data-target="#modifierDuty" onclick="updateOpenBtn(this)" value="${riIdentificationRriskMsg.riskmsgid}">修改</a>
													<a data-toggle="modal" data-target="#deleteRisk" onclick="delOpenBtn(this)" value="${riIdentificationRriskMsg.riskmsgid}">删除</a>
													</td>
												</td>
								                </tr>  
								        	</c:forEach>  --%> 
											<!-- <tr>
												<td>
												<input type="checkbox">
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
												</td><td>
												煤灰
												</td>
												<td>
													<a data-toggle="modal" data-target="#modifierDuty" >修改</a>
													<a data-toggle="modal" data-target="#deleteRisk" >删除</a>
												</td>
											</tr> -->

										</tbody>
									</table>
									</div>

								<!-- 模态框（新增专项风险信息） -->
								<div class="modal fade" id="addDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												新增专项风险信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="addForm">
													<!-- 隐藏域，隐藏一个风险辨识主表id -->
													<input id="addidentiryid" type="hidden" name="riIdentificationRriskMsg.identiryid" value="${identifyMainTableY.identiryid }"/>
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险地点：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addriskAddressSelect" name="" onchange="addselectchange(this)">
														<option value="" id="option0">--请选择--</option>
														<option value="综采">综采</option>
														<option value="综掘">综掘</option>
														
													</select>
													<textarea id="addriskaddress" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.riskaddress" readonly="readonly"></textarea>
												</div>
												<!-- 存放选中的风险地点，用于追加到文本框中 -->
												<input id="addAddressToTextarea" type="hidden" value=""/>
												
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险描述：</span>
													<textarea id="addriskdescribe" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.riskdescribe"></textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addrisktype" name="riIdentificationRriskMsg.risktype">
														<option value="" id="option0">--请选择--</option>
														<option value="人">人</option>
														<option value="机">机</option>
														<option value="环">环</option>
														<option value="管">管</option>
														
													</select>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;专业类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addprofessionaltypes" name="riIdentificationRriskMsg.professionaltypes">
														<option value="" id="option0">--请选择--</option>
														<option value="采煤">采煤</option>
														<option value="挖水">挖水</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;灾害类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="adddisastertypes" name="riIdentificationRriskMsg.disastertypes">
														<option value="" id="option0">--请选择--</option>
														<option value="火">火</option>
														<option value="水">水</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">可能导致事故：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="addcancauseaccidents" name="riIdentificationRriskMsg.cancauseaccidents">
														<option value="" id="option0">--请选择--</option>
														<option value="人身伤害">人身伤害</option>
														<option value="死亡">死亡</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;管控措施：</span>
													<textarea id="addctrlmeasure" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.ctrlmeasure"></textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;&nbsp;负责人：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="addprincipal" name="riIdentificationRriskMsg.principal" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;&nbsp;监管人：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="addsuperintendent" name="riIdentificationRriskMsg.superintendent" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;监管周期：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="addmonitoringperiod" name="riIdentificationRriskMsg.monitoringperiod" />
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
								<!-- 模态框（修改专项辨识信息） -->
								<div class="modal fade" id="modifierDuty" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												修改专项辨识信息
												</h4>
											</div>
											<div class="modal-body">
												<form action="" id="updateForm">
													<!-- 隐藏域，隐藏一个风险辨识主表id -->
													<input id="updateidentiryid" type="hidden" name="riIdentificationRriskMsg.identiryid" value="${identifyMainTableY.identiryid }"/>
													<!-- 隐藏域，隐藏一个辨识风险信息id -->
													<input id="updateriskmsgid" type="hidden" name="riIdentificationRriskMsg.riskmsgid" value=""/>
													
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险地点：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updateriskAddressSelect" name="" onchange="updateselectchange(this)" >
														<option value="" id="option0">--请选择--</option>
														<option value="综采">综采</option>
														<option value="综掘">综掘</option>
														
													</select>
													<textarea id="updateriskaddress" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.riskaddress" readonly="readonly"></textarea>
												</div>
												<!-- 存放选中的风险地点，用于追加到文本框中 -->
												<input id="updateAddressToTextarea" type="hidden" value=""/>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险描述：</span>
													<textarea id="updateriskdescribe" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.riskdescribe"></textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;风险类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updaterisktype" name="riIdentificationRriskMsg.risktype">
														<option value="" id="option0">--请选择--</option>
														<option value="人">人</option>
														<option value="机">机</option>
														<option value="环">环</option>
														<option value="管">管</option>
														
													</select>
												</div>
								
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;专业类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updateprofessionaltypes" name="riIdentificationRriskMsg.professionaltypes">
														<option value="" id="option0">--请选择--</option>
														<option value="采煤">采煤</option>
														<option value="挖水">挖水</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;灾害类型：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updatedisastertypes" name="riIdentificationRriskMsg.disastertypes">
														<option value="" id="option0">--请选择--</option>
														<option value="火">火</option>
														<option value="水">水</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">可能导致事故：</span>
													<select	class="selectpicker form-control" title="请选择" 
													id="updatecancauseaccidents" name="riIdentificationRriskMsg.cancauseaccidents">
														<option value="" id="option0">--请选择--</option>
														<option value="人身伤害">人身伤害</option>
														<option value="死亡">死亡</option>
														
													</select>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;管控措施：</span>
													<textarea id="updatectrlmeasure" class="form-control texta"
													rows="2" name="riIdentificationRriskMsg.ctrlmeasure"></textarea>
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;&nbsp;负责人：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="updateprincipal" name="riIdentificationRriskMsg.principal" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;&nbsp;监管人：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="updatesuperintendent" name="riIdentificationRriskMsg.superintendent" />
												</div>
												<div class="input-group el_modellist" role="toolbar">
													<span class="el_spans">&nbsp;&nbsp;监管周期：</span>
													<input type="text" class="form-control el_modelinput" value=""
														id="updatemonitoringperiod" name="riIdentificationRriskMsg.monitoringperiod" />
												</div>
												
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="updateSave()">
													确认修改
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								
								<!-- 模态框（删除专项风险） -->
								<div class="modal fade" id="deleteRisk" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
													&times;
												</button>
												<h4 class="modal-title" id="myModalLabel">
												删除专项风险
												</h4>
											</div>
											<div class="modal-body">
												您确定要删除该条专项风险信息吗？
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" onclick="deleteBtn()">
													确认删除
												</button>
											</div>
										</div><!-- /.modal-content -->
									</div>
								</div><!-- /.modal -->
								<!-- 隐藏域，用于删除操作的 风险信息id -->
								<input id="delriskmsgid" type="hidden" value=""/>
								
									<div id="paginationIDU"></div>
									<!-- 隐藏当前页页号 默认值为1-->
									<input id="currentPage" type="hidden" value="1"/>
									<!-- 隐藏每页显示的记录数 默认值10 -->
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

	</div>

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>