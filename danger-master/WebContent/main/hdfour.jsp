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
<link rel="stylesheet"
	href="<%=path%>/controls/selectDropTree/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.excheck.js"></script>

<script type="text/javascript" src="<%=path%>/js/danger/hdfour.js"></script>
<script src="<%=path%>/js/tree.js"></script>
<!--索引责任单位-->
<script type="text/javascript">
$(function(){
	searchUnitTree();
	/**
	 * 请求树信息
	 */
	function searchUnitTree() {
		$.ajax({
			type : "post",
			target : "#treeDemo",
			dataType : "json",
			url : "searchTreeAction.action",
			success : getTree,
			error : function() {
				alert("请求树失败！");
			}
		});
	}

	/**
	 * 生成树
	 */
	var log, className = "dark";
	function getTree(treeList2) {
		var treeList3 = eval("(" + treeList2 + ")");
		var setting = {
			data : {
				simpleData : {
					enable : true,
					idKey : "departmentId",
					pIdKey : "upDepartmentId",
					rootPId : "10",
				},
				key : {
					name : "name",
				}
			},
			callback : {
				onClick : onClick
			}
		};
		var zNodes = treeList3;
		//添加 树节点的 点击事件；
		
		function onClick(event, treeId, treeNode, clickFlag) {
			//$("#unitId").val(treeNode.name);//为责任单位的隐藏域赋值
			showLog3(treeNode.name);
		}
		$.fn.zTree.init($("#treeDemo3"), setting, zNodes);
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		//treeObj.expandAll(false);
		
	}

	
	function showLog3(str) {
		if (!log){
			log = $("#log3");
		}
		/*清空内部的东西*/
		if ($("#log3 > li").length > 0) {
			$("#log3").children("li").remove();
		}
		log.append("<li class='" + className + "'>" + str + "</li>");
		
		$("#unitId").prop("value",str);
		/*判断是否插入进入，若插入进入，关闭树框*/
		if ($("#log3 > li").length > 0) {
			$("#treeDemo3").hide();
		}
	}
	
	$("#treeDemo3").hide();
    $("#log3").click(function () {
        $('#treeDemo3').toggle();
    })
});
</script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<!--选择树-->
<style>
#treeDemo3 {
	width: 215px;
	overflow: visible;
	padding: 10px;
	height: auto;
	position: absolute;
	top: 14px;
	border: 1px solid #ccc;
	z-index: 100;
}

/*单选*/
#log3 {
	background-color: white;
	height: 25px;
	width: 100%;
	border-color: rgb(204, 204, 204);
	border-radius: 0 3px 3px 0;
	padding-left: 10px;
	padding-top: 2px;
	box-shadow: 0 1px 1px #eee inset;
}

#log3:active {
	border-color: #66afe9;
	-webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, .075), 0 0 8px
		rgba(102, 175, 233, .6);
}

#log3 li {
	background-color: white;
	padding: 0;
	height: 20px;
	line-height: 20px;
}
</style>

<!--验证-->
<script src="<%=path%>/controls/validate/jquery.validate.js"></script>
<script src="<%=path%>/controls/validate/messages_zh.js"></script>
<style>
.error {
	color: red;
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
						<span>隐患管理 </span><span>> 隐患五定</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--索引-->
							<div class="row el_queryBox">
								<form
									action="${baseurl }/queryView_findSiding.action?tag=checkedSiding"
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<!-- 隐藏域，用于接收从后台action传过来的检查单位 -->
												<input id="checkunitValue" type="hidden" value="${checkunit }"/>
												<span class="el_spans el_chooseSpan">检查单位：</span> 
												<select
													class="selectpicker form-control" name="checkunit"
													id="checkUnitId" title="请选择">
													<%-- <option value="0">--请选择--</option>
													<option value="安全小分组"
														<c:if test="${'安全小分组' eq checkunit}">selected</c:if>>安全小分组</option>
													<option value="矿领导"
														<c:if test="${'矿领导' eq checkunit}">selected</c:if>>矿领导</option>
													<option value="科领导"
														<c:if test="${'科领导' eq checkunit}">selected</c:if>>科领导</option>
													<option value="屯兰安监处"
														<c:if test="${'屯兰安监处' eq checkunit}">selected</c:if>>屯兰安监处</option>
													<option value="五人小组"
														<c:if test="${'五人小组' eq checkunit}">selected</c:if>>五人小组</option>
													<option value="省厅"
														<c:if test="${'省厅' eq checkunit}">selected</c:if>>省厅</option>
													<option value="山西焦煤"
														<c:if test="${'山西焦煤' eq checkunit}">selected</c:if>>山西焦煤</option>
													<option value="西山煤电"
														<c:if test="${'西山煤电' eq checkunit}">selected</c:if>>西山煤电</option>
													<option value="西山煤电安监局"
														<c:if test="${'西山煤电安监局' eq checkunit}">selected</c:if>>西山煤电安监局</option> --%>
												</select>

											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">隐患级别：</span>
												 <select id="dangerLevel"
													class="selectpicker form-control" title="请选择"
													name="dangergrade">
													<option value="">--请选择--</option>
													<option vaule="无"
														<c:if test="${'无' eq dangergrade}">selected</c:if>>无</option>
													<option vaule="A"
														<c:if test="${'A' eq dangergrade}">selected</c:if>>A</option>
													<option vaule="B"
														<c:if test="${'B' eq dangergrade}">selected</c:if>>B</option>
													<option vaule="C"
														<c:if test="${'C' eq dangergrade}">selected</c:if>>C</option>
													<!-- 新加的 start -->
													<option vaule="D"
														<c:if test="${'D' eq dangergrade}">selected</c:if>>D</option>
													<!-- 新加的 end -->
												</select>
											</div>
										</div>
										
										<!-- 隐藏域，用于接收从后台action传过来的隐患类型-->
										<input id="typeValue" type="hidden" value="${type }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">隐患类型：</span>
												 <select id="dangertype"
													class="selectpicker form-control" title="请选择" name="type">
													<%-- <option value="">--请选择--</option>
													<option value="采煤"
														<c:if test="${'采煤' eq type}">selected</c:if>>采煤</option>
													<option value="开掘"
														<c:if test="${'开掘' eq type}">selected</c:if>>开掘</option>
													<option value="机电"
														<c:if test="${'机电' eq type}">selected</c:if>>机电</option>
													<option value="运输"
														<c:if test="${'运输' eq type}">selected</c:if>>运输</option>
													<option value="通风"
														<c:if test="${'通风' eq type}">selected</c:if>>通风</option>
													<option value="地测"
														<c:if test="${'地测' eq type}">selected</c:if>>地测</option>
													<option value="其他"
														<c:if test="${'其他' eq type}">selected</c:if>>其他</option> --%>
												</select>
											</div>
										</div>
									</div>

									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">隐患地点：</span> 
												<input id="dangerAddress"
													type="text" class="form-control" name="address"
													value="${address }" />
											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">隐患内容：</span>
												 <input id="findDangerContent"
													type="text" class="form-control" name="content"
													value="${content }" />
											</div>
										</div>
										
										<!-- 隐藏域，用于接收从后台action传过来的隐患状态-->
										<input id="dangerstatusValue" type="hidden" value="${dangerstatus }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">隐患状态：</span>
												 <select id="findDangerStatus"
													class="selectpicker form-control" title="请选择"
													name="dangerstatus">
													<option value="未五定"
														<c:if test="${'未五定' eq dangerstatus}">selected</c:if>>未五定</option>
													<option value="已五定"
														<c:if test="${'已五定' eq dangerstatus}">selected</c:if>>已五定</option>
													<option value="已复查"
														<c:if test="${'已复查' eq dangerstatus}">selected</c:if>>已复查</option> 
												</select>
											</div>
										</div>
									</div>

									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">发现日期：</span>
												<input class="datainp wicon form-control" id="optsdate2" type="text" 
												placeholder="请选择发现日期" value="${findtime }" name="findtime" readonly/>
											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">责任单位：</span> 
												<ul id="log3" class="el_modelinput el_chooseInput log"></ul>
												<img
													src="${baseurl }/controls/selectDropTree/smallTriangle.png"
													class="el_smallTriangle" width="7" />
												<ul id="treeDemo3" class="ztree"></ul>
												<!-- 隐藏域，隐藏责任单位 -->
												<input id="unitId" type="hidden" name="unit" value="${unit}" />
											</div>
										</div>
										<!-- 从unitId 的input 隐藏域拿过来的值，放ul到文本框上。并且，把下边的树节点选中。 -->
										<script>
										 	var hiV = $("#unitId").val();
											if ($("#log3 > li").length > 0) {//先清空
												$("#log3").children("li").remove();
											}
											//插入值
											$("#log3").append("<li>" + hiV + "</li>");
											
										</script>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<%-- <span class="el_spans el_chooseSpan">责任人&nbsp;&nbsp;&nbsp;：</span>
												<input id="dangerManager" type="text" class="form-control" name="manager"
													value="${manager }" /> --%>
												<!-- 隐藏的当前页大小与页号 -->
												<input type="hidden" name="currentPage" id="currentPage" />
												<input type="hidden" name="currentCount" id="currentCount" />
											</div>
										</div>
									</div>

									<!--提交查询按钮-->
									<button type="submit"
										class="btn btn-default el_queryButton btn-sm">查询</button>
									<!-- 清空按钮 -->
									<button class="btn btn-default el_queryButton btn-sm" style="right:120px;" onclick="clearBtn()">清空</button>
								</form>

							</div>
							<!--结束 查询表单提交-->
							<!-- 清空按钮 的点击事件-->
							<script type="text/javascript">
								function clearBtn(){
									//清空责任单位
									if ($("#log3 > li").length > 0) {//先清空
										$("#log3").children("li").remove();
									}
									//清空责任单位隐藏域的值
									$("#unitId").val("");
									
									
									//清空检查单位
									$("#checkUnitId").val("");
									
									//清空隐患级别
									$("#dangerLevel").val("");
									
									//清空隐患类型
									$("#dangertype").val("");
									
									//清空隐患地点
									$("#dangerAddress").val("");
									
									//清空隐患内容
									$("#findDangerContent").val("");
									
									//清空隐患状态
									//$("#findDangerStatus").val("");
									
									//清空发现日期
									$("#optsdate2").val("");
									
									//清空责任人
									$("#dangerManager").val("");
								}
							</script>

							<!--显示内容-->
							<div class="panel panel-default el_Mainmain">

								<!--按钮面板-->
								<div class="panel-body">

									<div class="panel panel-default">
										<div class="panel-body el_MainxiaoMain">
											
											<!-- 暂时把导出按钮屏蔽 -->
											<!-- <div class="el_topButton">
												按钮触发模态框1
												<div class="col-md-2">
													<button class="btn btn-primary" data-toggle="modal"
														data-target="#el_Export">导出</button>
												</div>
											</div> -->

										</div>
									</div>

									<!--表格
                            内容都提取到json里边
                        -->
									<table class="table table-hover table-bordered">
										<c:if test="${result.tag eq 'checkedSiding' }">
											<thead>
												<tr>
													<th>序号</th>
													<th>级别</th>
													<th>类型</th>
													<th>责任单位</th>
													<th>隐患内容</th>
													<!-- <th>问题/隐患</th> -->
													<th>检查日期</th>
													<th>检查单位</th>
													<th>检查人</th>
													<th>复查结果</th>
													<th>状态</th>
													<th width="100">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="danger"
													items="${result.pageBean.productList }" varStatus="status">
													<td>${ status.index + (result.pageBean.currentPage-1)*8+1}
													<input type="hidden" class="danger_IdNum"
														value="${danger.dangerid }" /> <input type="hidden"
														class="address_hidden" value="${danger.address }" />
													</td>
													<td>${danger.dangergrade }</td>
													<td>${danger.type }</td>
													<td>${danger.unit }</td>
													<td>${danger.content }</td>
													<!-- <td>问题</td> -->
													<td><fmt:formatDate value="${danger.findtime }"
															pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
													<td>${danger.checkunit }</td>
													<td>${danger.findperson }</td>
													<c:if test="${danger.recheckresult eq 0 }">
														<td>检查合格</td>
													</c:if>
													<c:if test="${danger.recheckresult eq 1 }">
														<td style="background-color: #1C86EC">检查不合格</td>
													</c:if>
													<td>${danger.dangerstatus }</td>
													<td><c:if test="${danger.recheckresult eq 1 }">
															<a href="javascript:void(0)" onClick="el_setFour(this)">重新五定</a>
														</c:if> <c:if test="${danger.recheckresult eq 0 }">
															<a href="javascript:void(0)" onClick="allInfo(this)">详情</a>
														</c:if></td>
													</tr>
												</c:forEach>

											</tbody>
										</c:if>
										<c:if test="${result.tag eq 'formalSiding' }">
											<thead>
												<tr>
													<th>序号</th>
													<th>级别</th>
													<th>类型</th>
													<th>责任单位</th>
													<th>隐患内容</th>
													<th>问题/隐患</th>
													<th>检查日期</th>
													<th>检查单位</th>
													<th>检查人</th>
													<th>状态</th>
													<th width="100">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="danger"
													items="${result.pageBean.productList }" varStatus="status">
													<td>${ status.index + (result.pageBean.currentPage-1)*10+1}
														<input type="hidden" class="danger_IdNum"
														value="${danger.dangerid }" /> <input type="hidden"
														class="address_hidden" value="${danger.address }" />
													</td>

													<td>${danger.dangergrade }</td>
													<td>${danger.type }</td>
													<td>${danger.unit }</td>
													<td>${danger.content }</td>
													<td>问题</td>
													<td><fmt:formatDate value="${danger.findtime }"
															pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
													<td>${danger.checkunit }</td>
													<td>${danger.findperson }</td>
													<td>${danger.dangerstatus }</td>
													<td><c:if test="${'未五定' eq danger.dangerstatus }">
															<a href="javascript:void(0)" onClick="el_setFour(this)"
																id="sidingButton">五定</a>
														</c:if> <c:if test="${'已五定' eq danger.dangerstatus}">
															<a href="javascript:void(0)" onClick="allInfo(this)">详情</a>
														</c:if> <!-- <a
														href="javascript:void(0)" onClick="updateSidingInfo(this)">修改</a>
														<a href="javascript:void(0)"
														onClick="deleteSidingInfo(this)">删除</a> -->
													</tr>
												</c:forEach>
											</tbody>
										</c:if>
									</table>



									<!-- 模态框 五定-->
									<div class="modal fade" id="el_setFour" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														onclick="closeModal_symbol()" aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患-问题五定</h3>
												</div>

												<div class="modal-body">
													<h3>基本信息:</h3>
													<div class="el_parperInfo">
														<table>
															<tr>
																<td>检查日期：</td>
																<td id="findTime"></td>
																<td>检查人：</td>
																<td id="findPerson"></td>
															</tr>
															<tr>
																<td>检查单位：</td>
																<td id="checkUnit"></td>
																<td>地点：</td>
																<td id="address"></td>
															</tr>
															<tr>
																<td>隐患类型：</td>
																<td id="dangerStatus"></td>
																<td>隐患级别：</td>
																<td id="dangerGrade"></td>
															</tr>
															<tr>
																<td>责任单位：</td>
																<td id="dutyUnit"></td>
															</tr>
															<tr>
																<td>隐患内容：</td>
																<td id="dangerContent" colspan="3"></td>
																</td>
															</tr>
															<!-- <tr>
														<td>责任人</td>
														<td colspan="3">黎明</td>
													</tr> -->
														</table>
													</div>
													&nbsp;&nbsp;
													<h3>五定信息录入</h3>
													<form action="" id="hdfourform">
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">责&nbsp;&nbsp;任&nbsp;人：</span> <input
																type="text" class="form-control el_modelinput"
																name="dutyperson" id="dutyperson" />
														</div>
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">督&nbsp;&nbsp;办&nbsp;人：</span> <input
																type="text" class="form-control el_modelinput"
																name="supervisor" id="supervisor" />
														</div>
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">整改措施：</span>
															<textarea class="form-control texta" rows="10"
																name="rectificationmeasure" id="rectificationmeasure"></textarea>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">整改时间：</span>
															<input class="datainp wicon form-control el_modelinput" id="optsdate" type="text" 
															name="rectificationtime"  readonly>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">五定时间：</span>
															<input class="datainp wicon form-control el_modelinput" id="optsdate4" type="text" 
															name="sidingtime" readonly>
														</div>

														<div class="modal-footer">
															<!-- <button type="submit" class="btn btn-primary" ">保存</button> -->
															<button type="button" class="btn btn-primary"
																onclick="submitSidingInfo()" id="submitSiding_Info">保存</button>
															<!--  <button type="button" class="btn btn-primary" onclick="cancleSidingInfo()">关闭</button> -->
															<button type="button" class="btn btn-default"
																data-dismiss="modal" onclick="closeModal_symbol()">关闭</button>
														</div>
													</form>

												</div>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>
							<script>
								//点击五定执行的函数
			                    function el_setFour(obj) {
			                    	//alert("a");
			            			//对页面进行初始化
			            			addsiding_initForm();
			            			var address_hidden = $(obj).parents("tr").find(".address_hidden").val();
			            			//获取当前行中的所有列的信息
			            			$tds = $(obj).parents('tr').children('td');
			            			//alert($tds.eq(0).html() + $tds.eq(1).html());
			            			//alert($("#findTime").text());
			            			$("#dangerGrade").text($tds.eq(1).html());
			            			$("#dangerStatus").text($tds.eq(2).html());
			            			$("#dutyUnit").text($tds.eq(3).html());
			            			$("#dangerContent").text($tds.eq(4).html());
			            			$("#findTime").text($tds.eq(6).html());
			            			$("#checkUnit").text($tds.eq(7).html());
			            			$("#findPerson").text($tds.eq(8).html());
			            			$("#address").text(address_hidden);
			            			//获取隐患id
			            			var dangerId = $(obj).parents("tr").find(".danger_IdNum").val();
			            			
			            			
			            			
			            			//alert(dangerId);
			            			//将获取的隐患编号的的id添加到到form表单中
			            			$("#hdfourform").append("<input type='hidden' id='dangerId' value= " + dangerId + " name='dangerid'/>");
			          
			                        $('#el_setFour').modal();//开启模态框
			                    }
			                    
			                  //初始化页面
			                	function addsiding_initForm(){
			                	  	//责任人
			                	  	$("#dutyperson").val("");
			                		//整改措施
			                		$("#rectificationmeasure").val("");
			                		//督办人
			                		$("#supervisor").val("");
			                		//alert("nihao");
			                	}
			                  
			                  //向action中提交数据
			                function submitSidingInfo(){
			                	
			                	 //对文本框的信息进行校验，判断是否为空
			                	 //采用jquery的validate插件进行校验，返回一个对象
			                	var isNotNull = $("#hdfourform").validate({
			            				rules : {
			            					dutyperson:"required",
			            					rectificationmeasure : "required",//整改措施
			            					supervisor : "required",
			            					rectificationtime : "required",
			            					sidingtime : "required"
			            				},
			            				messages : {
			            					dutyperson:{
			            						required : "不能为空"
			            						},
			            					rectificationmeasure : {
			            						required : "不能为空"
			            					},
			            					supervisor : {
			            						required : "不能为空"
			            					},
			            					rectificationtime : {
			            						required : "不能为空"
			            					},
			            					sidingtime : {
			            						required : "不能为空"
			            					}
			            				}
			            			});
			                	 //测试执行该对象的form()函数，该函数返回一个布尔变量
			                	//alert(isNotNull.form())
			                		//判断当返回为true的是否执行添加操作
			                	  if(isNotNull.form()){
			                		  $.ajax({
				            				url : '${pageContext.request.contextPath }/sidingHander_addSiding.action',
				            				data : $("#hdfourform").serialize(),
				            				type : 'POST',
				            				dataType : 'json',
				            				async:true,
				            				success : function(data) {
				            					alert(data.result);
				            					//关闭模态框
				            					$('#el_setFour').modal('hide');
				            					//刷新当前页面
				            					window.location.reload();
				            					//window.location.href="${baseurl }/queryView_findSiding.action?tag=formalSiding&dangerstatus=已五定";//"${baseurl }/queryView_findSiding.action?tag=formalSiding&first=siding";//原来的url："${baseurl }/queryView_findSiding.action?tag=formalSiding&dangerstatus=已五定";
				            				}
				            			});
			                	  }
			                	  
			                	   
			                  }
			                	  //点击模态中的取消进行的操作，将状态改为未五定，将五定按钮显示，将模态框关闭
			                	  function cancleSidingInfo(){
				                		  //将状态改为未五定，将五定按钮显示
				                		  cancleAddSiding();
			                			//关闭模态框
		            					$('#el_setFour').modal('hide');
		            					//刷新当前页面
		            					window.location.reload();
			                	  }
			                	  
			                	  //将状态改为未五定，将五定按钮显示具体实现
			                	  function cancleAddSiding(obj){
			                		  
			                			//将隐患状态改为未五定
				            			$(obj).parents("tr").find("#dangerStatus").html("未五定");
				            			//将五定按钮显示
				            			$(obj).parents("tr").find("#sidingButton").css("display","inline");
				            
			                	  }
			                  
			                </script>


									<!-- 模态框 修改 五定-->
									<div class="modal fade" id="modify_Four" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														onclick="closeModal_symbol()" aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患问题五定信息修改</h3>
												</div>

												<div class="modal-body">

													<form action="" id="hdfour_updateform">

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">责&nbsp;&nbsp;任&nbsp;人：</span> <input
																type="text" class="form-control el_modelinput"
																name="dutyperson" id="dutyperson_update" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">督&nbsp;&nbsp;办&nbsp;人：</span> <input
																type="text" class="form-control el_modelinput"
																name="supervisor" id="supervisor_update" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">整改时间：</span>
															 <input type="text"
																name="rectificationtime" 
																id="reservationtime_update" readonly
																class="datainp wicon form-control el_modelinput span4" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">整改措施：</span>
															<textarea class="form-control texta" rows="10"
																name="rectificationmeasure"
																id="rectificationmeasure_update"></textarea>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">五定时间：</span> <input type="text"
																id="sidingTime_update" readonly
																class="datainp wicon form-control el_modelinput" name="sidingtime" />
														</div>

														<div class="modal-footer">
															<!-- <button type="submit" class="btn btn-primary">保存</button> -->
															<button type="button" class="btn btn-primary"
																onclick="updateSiding_info()">保存</button>
															<!-- <button type="button" class="btn btn-default" onclick="cancleUpdateSiding_info()">关闭</button> -->
															<button type="button" class="btn btn-default"
																data-dismiss="modal" onclick="closeModal_symbol()">关闭</button>
														</div>
													</form>

												</div>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>
									<script>
							//点击修改按钮执行相应的操作
								function updateSidingInfo(obj) {
									//获取隐患编号
			                    	var dangerId = $(obj).parents("tr").find(".danger_IdNum").val();
									//获取五定编号
			                    	var sidingId = $(obj).parents("tr").find(".siding_IdNum").val();
			                    	
			                    	//将获取的隐患编号的的id添加到到form表单中
			            			$("#hdfour_updateform").append("<input type='hidden' id='dangerId' value= " + dangerId + " name='dangerid'/>");
			            			$("#hdfour_updateform").append("<input type='hidden' id='sidingId' value= " + sidingId + " name='sidingid'/>");
									
			            			//从数据库中获取相应的信息
			                    	$.ajax({
			            				url : '${pageContext.request.contextPath }/sidingHander_getSidingInfoBySidingId.action',
			            				data : {"sidingId":sidingId},
			            				type : 'POST',
			            				dataType : 'json',
			            				async:true,
			            				success : function(data) {
			            					//alert(data.sidingInfo.sidingid);
			            					//alert(data.sidingInfo.supervisor)
			            					//input标签采用val()的方法进行数据的注入,普通文本框采用text()
			            					
			            					//alert(data.sidingInfo.sidingtime)
			            					$("#dutyperson_update").val(data.sidingInfo.dutyperson);
			            					$("#supervisor_update").val(data.sidingInfo.supervisor);
			            					//将整改时间按照自定义方式进行显示
			            					var rectificationtime_update = new Date(data.sidingInfo.rectificationtime);	
			            					var rectificationtime_update = Format(rectificationtime_update, "yyyy-MM-dd HH:mm:ss");			            												            					
			            					//将五定时间按照正常方式进行显示
			            					var sidingtime_update = new Date(data.sidingInfo.sidingtime);	
			            					var sidingtime_update = Format(sidingtime_update,"yyyy-MM-dd HH:mm:ss");				            					            				
			            					
			            					$("#reservationtime_update").val(rectificationtime_update);
			            					$("#rectificationmeasure_update").text(data.sidingInfo.rectificationmeasure);
			            					$("#sidingTime_update").val(sidingtime_update);
			            								            					
			            				}
			            					
			            				});
			            			
			            			//关闭详情模态框
			            			$("#allInfo").modal("hide");
			            			//打开修改模态 
									$('#modify_Four').modal();
								}
							
							//点击保存按钮完成对五定信息的修改
							function updateSiding_info(){
								var isNotNull = $("#hdfour_updateform").validate({
		            				rules : {
		            					dutyperson:"required",
		            					rectificationmeasure : "required",//整改措施
		            					supervisor : "required",
		            					rectificationtime : "required",
		            					sidingtime : "required"
		            				},
		            				messages : {
		            					dutyperson:{
		            						required : "不能为空"
		            						},
		            					rectificationmeasure : {
		            						required : "不能为空"
		            					},
		            					supervisor : {
		            						required : "不能为空"
		            					},
		            					rectificationtime : {
		            						required : "不能为空"
		            					},
		            					sidingtime : {
		            						required : "不能为空"
		            					}
		            				}
		            			});
								
								if(isNotNull.form()){
									$.ajax({
			            				url : '${pageContext.request.contextPath }/sidingHander_updateSidingInfo.action',
			            				data : $("#hdfour_updateform").serialize(),
			            				type : 'POST',
			            				dataType : 'json',
			            				async:true,
			            				success : function(data) {
			            					alert(data.result);
			            					//关闭模态框
			            					$('#modify_Four').modal('hide');
			            					//刷新当前页面
			            					window.location.reload();
			            				}
			            			});
								}
								 
							}
								//点击修改五定信息的模态框中的取消按钮进行的操作
							 function cancleUpdateSiding_info(){									
									//关闭模态框
	            					$('#modify_Four').modal('hide');
	            					//刷新当前页面
	            					window.location.reload();
							 }
							</script>



									<!-- 模态框 详细信息-->
									<div class="modal fade" id="allInfo" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														 aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患详情</h3>
												</div>
												<form>
													<div class="modal-body">
														<div class="el_parperInfo">
															<table>
																<tr>
																	<td>检查日期：</td>
																	<td id="findTime_detail">2017-12-10</td>
																	<td>检查人：</td>
																	<td id="findPerson_detail"></td>
																</tr>
																<tr>
																	<td>检查单位：</td>
																	<td id="checkUnit_detail"></td>
																	<td>地点：</td>
																	<td id="address_detail"></td>
																</tr>
																<tr>
																	<td>隐患类型：</td>
																	<td id="dangerType_detail"></td>
																	<td>隐患级别：</td>
																	<td id="dangerGrade_detail"></td>
																</tr>
																<tr>
																	<td>隐患内容：</td>
																	<td colspan="3" id="dangerContent_detail"></td>
																</tr>
																<tr>
																	<td>责任单位：</td>
																	<td id="dutyUnit_detail">安装十二队</td>
																	<!-- <td>责任负责人</td>
															<td id="manager_detail">王建</td> -->
																</tr>
															</table>
														</div>
														<br />
														<table class="table-hover table table-bordered"
															style="width: 95%; max-width: 95%; margin: 0 auto;">
															<thead>
																<th>序号</th>
																<th>责任人</th>
																<th>整改措施</th>
																<th>整改时间</th>
																<th>五定时间</th>
																<th>督办人</th>
																<th>操作</th>

															</thead>
															<tbody id="sidingListInfo">
																<tr>
																	<!-- <td>道超过扩散通风距离（实测长约××m、瓦斯浓度×%),未设置栅栏,揭示警标</td>
															<td>2017-12-1</td>
															<td>2017-12-1</td>
															<td>分特</td> -->

																</tr>
															</tbody>
														</table>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
													</div>
												</form>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>
									<script>
								//点击详情显示信息
			                    function allInfo(obj) {
									//获取隐患编号
			                    	var dangerId = $(obj).parents("tr").find(".danger_IdNum").val();
			                    	var address_hidden = $(obj).parents("tr").find(".address_hidden").val();
			                    	//从数据库中获取相应的信息
			                    	$.ajax({
			            				url : '${pageContext.request.contextPath }/sidingHander_getSidingById.action',
			            				data : {"dangerId":dangerId},
			            				type : 'POST',
			            				dataType : 'json',
			            				async:true,
			            				success : function(data) {
			            					/* //先刷新当前页面
			            					window.location.reload(); */
			            					
			            					/* alert(data.dangerInfo.address); */
			            	 				$("#dangerGrade_detail").text(data.dangerInfo.dangergrade);
					            			$("#dangerType_detail").text(data.dangerInfo.type);
					            			$("#dutyUnit_detail").text(data.dangerInfo.unit);
					            			$("#dangerContent_detail").text(data.dangerInfo.content);					            			
					            			$("#findTime_detail").text(Format(new Date(data.dangerInfo.findtime), "yyyy-MM-dd HH:mm"));
					            			$("#checkUnit_detail").text(data.dangerInfo.checkunit);
					            			$("#findPerson_detail").text(data.dangerInfo.findperson);					        
					            			$("#address_detail").text(data.dangerInfo.address);
			            					
					            			//alert(data.sidingListInfo[0].rectificationmeasure);
					            			var sidingListInfo = "";
					            			//循环显示所有五定信息
					            			for(var i=0;i<data.sidingListInfo.length;i++){
					            				//alert(data.sidingListInfo[i].rectificationtime);
					            				//将整改时间进行自定义显示
					            				var rectificationtime_display = new Date(data.sidingListInfo[i].rectificationtime);
					            				var rectificationtime_display = Format(rectificationtime_display, "yyyy-MM-dd HH:mm");
					            				//将五定时间进行自定义显示
					            				var sidingtime_display = new Date(data.sidingListInfo[i].sidingtime);
			            				        var sidingtime_display = Format(sidingtime_display, "yyyy-MM-dd HH:mm");
					            				sidingListInfo += "<tr><td>"+ (i+1) 
		            							+"<input type='hidden' class='danger_IdNum' value= " + data.sidingListInfo[i].dangerid + " name='dangerid'/>"
					            				+"<input type='hidden' class='siding_IdNum' value= " + data.sidingListInfo[i].sidingid + " name='sidingid'/>"
		            							+"</td><td>"+data.sidingListInfo[i].dutyperson+"</td><td>"
					            				+data.sidingListInfo[i].rectificationmeasure +"</td><td>"
					            				+rectificationtime_display+"</td><td>"
					            				+sidingtime_display+"</td><td>"
					            				+data.sidingListInfo[i].supervisor+"</td><td>"
					            				+"<a href='javascript:void(0)' onClick='updateSidingInfo(this)' >修改</a>"
					            				+"<a href='javascript:void(0)' onClick='deleteSidingInfo(this)' >删除</a>"
					            				+"</td></tr>";
					            			}
					            			//先将表格中的所有数据清空
					            			$("#sidingListInfo").empty();
					            			//将拼接的字符串添加到表格中					            			
					            			$("#sidingListInfo").append(sidingListInfo);					           								            	
			            				}
			            			});
			                    	
			                    	
			                        $('#allInfo').modal();
			                    }
			                </script>


									<!-- 模态框   信息删除确认 -->
									<div class="modal fade" id="delcfmModel">
										<div class="modal-dialog" style="width: 50%;">
											<div class="modal-content message_align">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														 aria-label="Close">
														<span aria-hidden="true">×</span>
													</button>
													<h4 class="modal-title">提示</h4>
												</div>
												<div class="modal-body">
													<p>您确认要删除该条信息吗？</p>
												</div>
												<div class="modal-footer">
													<input type="hidden" id="sidingId_url" /> <a
														onclick="sidingId_urlSubmit()" class="btn btn-success"
														data-dismiss="modal">确定</a>
													<button type="button" class="btn btn-default"
														data-dismiss="modal" >取消</button>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
									<!-- /.modal -->
									<script>
						//点击删除按钮进行的相关操作
						function deleteSidingInfo(obj) {
							
							//获取五定编号
							var sidingId = $(obj).parents("tr").find(".siding_IdNum").val();
							//将五定编号设置到id为sidingId_url的标签中
							$("#sidingId_url").val(sidingId);
							$('#delcfmModel').modal();
						}
						//点击删除模态框的确定按钮实现删除事件
						function sidingId_urlSubmit() {
							/* var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
							window.location.href = url; */
							var sidingId = $("#sidingId_url").val();
							//alert(sidingId);
							$.ajax({
	            				url : '${pageContext.request.contextPath }/sidingHander_deleteSidingInfoBySidingId.action',
	            				data : {"sidingId":sidingId},
	            				type : 'POST',
	            				dataType : 'json',
	            				async:true,
	            				success : function(data) {
	            					alert(data.result);
	            					//关闭模态框
	            					$('#el_setFour').modal('hide');
	            					//删除成功后刷新页面
	            					window.location.reload();
	            				}
	            			});
							
						}
					</script>



									<!-- 模态框 导出-->
									<div class="modal fade" id="el_Export" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">导出提示</h3>
												</div>
												<form>
													<div class="modal-body">
														<span>是否导出当前信息？</span>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
														<button type="button" class="btn btn-primary">提交更改</button>
													</div>
												</form>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>







									<!--分页-->
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

	<!-- 模态框右上角关闭符号执行页面刷新事件
				当点击模态框中的取消和关闭按钮时进行的操作 -->
		<script> 
						function closeModal_symbol(){
							//刷新当前页面
							window.location.reload();
						}
					</script> 

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>