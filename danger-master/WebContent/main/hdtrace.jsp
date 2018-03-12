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
<script type="text/javascript" src="<%=path%>/js/danger/hdtrace.js"></script>
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
						<span>隐患管理 </span><span>> 隐患跟踪</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">


							<!--索引-->
							<div class="row el_queryBox">
								<form action="${baseurl }/queryView_findDangerS.action"
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<!-- 隐藏域，隐藏从后台action中传过来的检查单位 -->
												<input id="checkunitValue" type="hidden" value="${checkunit }"/>
												<span class="el_spans el_chooseSpan">检查单位：</span> <select
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
										
										<!-- 隐藏域，隐藏从后台action中传过来的检查单位 -->
										<input id="typeValue" type="hidden" value="${type }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">隐患类型：</span> 
												<select id="findDangerType"
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
										
										<!-- 隐藏域，隐藏从后台action中传过来的检查单位 -->
										<input id="dangerstatusValue" type="hidden" value="${dangerstatus }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">隐患状态：</span> 
												<select id="findDangerStatus"
													class="selectpicker form-control" title="请选择"
													name="dangerstatus">
												    <option value="已五定"
														<c:if test="${'已五定' eq dangerstatus}">selected</c:if>>已五定</option>
													<!-- 新加的start -->
													<option value="未五定"
														<c:if test="${'未五定' eq dangerstatus}">selected</c:if>>未五定</option>
													<!-- 新加的end -->
													<option value="已整改"
														<c:if test="${'已整改' eq dangerstatus}">selected</c:if>>已整改</option> 
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
												<span class="el_spans el_chooseSpan">责任单位：</span> <input
													id="unitId" type="hidden" name="unit" value="${unit}" />
												<ul id="log3" class="el_modelinput el_chooseInput log"></ul>
												<img
													src="${baseurl }/controls/selectDropTree/smallTriangle.png"
													class="el_smallTriangle" width="7" />
												<ul id="treeDemo3" class="ztree"></ul>
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
									<button type="submit" class="btn btn-default el_queryButton btn-sm">查询</button>
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
									$("#checkunitValue").val("");
									
									//清空隐患级别
									$("#dangerLevel").val("");
									
									//清空隐患类型
									$("#findDangerType").val("");
									
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

									<div class="el_topButton">
										<!-- 按钮触发模态框1-->
										<!-- <button class="btn btn-primary" data-toggle="modal"
											data-target="#el_Export">导出</button> -->
									</div>

									<!--表格   内容都提取到json里边-->
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>序号</th>
												<th>级别</th>
												<th>类型</th>
												<th>责任单位</th>
												<th>隐患内容</th>
												<th>责任人</th>
												<th>检查日期</th>
												<th>检查单位</th>
												<th>检查人</th>
												<th>整改时间</th>
												<th>五定时间</th>
												<th>状态</th>
												<th width="160">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="danger"
												items="${result.pageBean.productList }" varStatus="status">
												<td>${ status.index + (result.pageBean.currentPage-1)*10+1}
													<input type="hidden" id="danger_IdNum" value="${danger.dangerid }" /> 
													<input type="hidden" id="siding_IdNum" value="${danger.sidingid }" /> 
													<input type="hidden" class="address_hidden"	value="${danger.address }" /> 
													<input type="hidden" class="dutyPerson_hidden" value="${danger.dutyperson}" />
													<input type="hidden" class="supervisor_hidden" value="${danger.supervisor }" /> 
													<input type="hidden" class="rectificationmeasure_hidden" value="${danger.rectificationmeasure }" />

												</td>
												<td>${danger.dangergrade }</td>
												<td>${danger.type }</td>
												<td>${danger.unit }</td>
												<td>${danger.content}</td>
												<td>${danger.dutyperson}</td>
												<td><fmt:formatDate value="${danger.findtime }"
														pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
												<td>${danger.checkunit }</td>
												<td>${danger.findperson }</td>
												<td><fmt:formatDate
														value="${danger.rectificationtime }"
														pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
												<td><fmt:formatDate value="${danger.sidingtime }"
														pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
												<td>${danger.dangerstatus }</td>
												<td><c:if test="${'已五定' eq danger.dangerstatus }">
														<a href="javascript:void(0)" onClick="trace(this)">隐患跟踪</a>
														<a href="javascript:void(0)" onClick="postpone(this)">延期</a>
													</c:if> <c:if test="${'已整改' eq danger.dangerstatus }">
														<a href="javascript:void(0)" onClick="allInfo(this)">详情</a>
														<a href="javascript:void(0)" onClick="deleteFollowInfo(this)">删除</a>
														<a href="javascript:void(0)" onClick="updateFollowInfo(this)">修改</a>
													</c:if></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

									<!-- 模态框 隐患跟踪-->
									<div class="modal fade" id="trace" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true" onclick="closeModal_symbol()">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患-跟踪记录</h3>
												</div>

												<div class="modal-body">
													<div class="el_parperInfo">
														<h3>&nbsp;&nbsp;隐患基本信息</h3>
														<table>
															<tr>
																<td>检查日期：</td>
																<td id="findTime1"></td>
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
																<td id="dangerType"></td>
																<td>隐患级别：</td>
																<td id="dangerGrade"></td>
															</tr>
															<tr>
																<td>隐患内容：</td>
																<td colspan="3" id="dangerContent"></td>
															</tr>
															<tr>
																<td>责任单位：</td>
																<td id="dutyUnit"></td>
															</tr>
														</table>
														<br />
														<h3>&nbsp;&nbsp;五定基本信息</h3>
														<table>
															<tr>
																<td>五定时间：</td>
																<td id="siding_sidingTime1"></td>
																<td>责任人：</td>
																<td id="siding_dutyPerson"></td>
															</tr>
															<tr>
																<td>整改时间：</td>
																<td id="rectificationTime"></td>
																<td>督办人：</td>
																<td id="supervisor"></td>
															</tr>
															<tr>
																<td>整改措施：</td>
																<td colspan="3" id="rectificationMeasure"></td>
															</tr>
														</table>
													</div>
													<br />
													<form action="" id="traceform">
														<h2>隐患跟踪信息录入</h2>
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">安全技术措施：</span> <label
																class="el_radioBox el_radioBox2"> <input
																type="radio" name="hassecurity" checked value="1">
																有
															</label> <label class="el_radioBox el_radioBox2"> <input
																type="radio" name="hassecurity" value="0"> 无
															</label>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">现&nbsp;&nbsp;场&nbsp;&nbsp;领&nbsp;&nbsp;导&nbsp;：</span>
															<input type="text" class="form-control el_modelinput"
																name="managername" id="managerName" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">整&nbsp;&nbsp;改&nbsp;&nbsp;时&nbsp;&nbsp;间&nbsp;：</span>
																<input class="datainp wicon form-control el_modelinput" id="optsdate" type="text" 
															name="rechecktime"  readonly>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">现 场 安 全 员：</span> <input
																type="text" class="form-control el_modelinput"
																name="safetytechnician" id="safetytechnician" />
														</div>

														<div class="modal-footer">
															<button type="button" class="btn btn-primary"
																onclick="submitFollowInfo()">保存</button>
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
							//点击隐患追踪的操作
		                    function trace(obj) {
		                    	//初始化
		                    	initForm_followInof();
		                    	
		            			var address_hidden = $(obj).parents("tr").find(".address_hidden").val();
		            			var supervisor_hidden = $(obj).parents("tr").find(".supervisor_hidden").val();
		            			var rectificationmeasure_hidden = $(obj).parents("tr").find(".rectificationmeasure_hidden").val();
		                    	
		                    	//获取当前行中的所有列的信息
		            			$tds = $(obj).parents('tr').children('td');
		            			//alert($tds.eq(0).html() + $tds.eq(1).html());
		            			//alert($("#findTime").text());
		            			//$("#dangerGrade").text($tds.eq(1).html());
		            			$("#dangerGrade").text($tds.eq(1).html());
		            			$("#dangerType").text($tds.eq(2).html());
		            			$("#dutyUnit").text($tds.eq(3).html());
		            			$("#dangerContent").text($tds.eq(4).html());
		            			$("#findTime1").text($tds.eq(6).html());
		            			$("#checkUnit").text($tds.eq(7).html());
		            			$("#findPerson").text($tds.eq(8).html());
		            			$("#rectificationTime").text($tds.eq(9).html());
		            			$("#siding_dutyPerson").text($tds.eq(5).html());
		            			$("#siding_sidingTime1").text($tds.eq(10).html());
		            			
		            			/* 隐藏域设置值 */
		            			$("#address").text(address_hidden);
		            			$("#rectificationMeasure").text(rectificationmeasure_hidden);
		            			$("#supervisor").text(supervisor_hidden);
		            			
		            			
		            			//获取隐患id
		            			var dangerId = $(obj).parents("tr").find("#danger_IdNum").val();
		            			//获取五定id
		            			var sidingId = $(obj).parents("tr").find("#siding_IdNum").val();

		            			//alert(dangerId+ +sidingId);
		            			
		            			//将获取的隐患编号的的id添加到到form表单中
			            		$("#traceform").append("<input type='hidden' id='dangerId' value= " + dangerId + " name='dangerid'/>");
			            		//将获取的五定编号的id添加到到form表单中
		            			$("#traceform").append("<input type='hidden' id='sidingId' value= " + sidingId + " name='sidingid'/>");
			
		            			
		            			//打开模态框
		                        $('#trace').modal();
		                    }
		                    
		                    //初始化页面
		                    function initForm_followInof(){
		                		//现场领导
		                		$("#managerName").val("");
		                		//现场安全员
		                		$("#safetytechnician").val("");
		                		//alert("nihao");
		                	}
		                    
		                    
		                    //向action中提交数据
		                    function submitFollowInfo(){
		                    	
		                    	var isNotNull = $("#traceform").validate({
		            				rules : {
		            					managername:"required",
		            					safetytechnician : "required",
		            					rechecktime : "required"
		            					
		            				},
		            				messages : {
		            					managername:{
		            						required : "不能为空"
		            						},
		            						safetytechnician : {
		            						required : "不能为空"
		            					},
		            					rechecktime : {
		            						required : "不能为空"
		            					}
	            			
		            				}
		            			});
		                    	//alert(isNotNull.form())
		                    	if(isNotNull.form()){
		                    		$.ajax({
			            				url : '${pageContext.request.contextPath }/followHander_addFollow.action',
			            				data : $("#traceform").serialize(),
			            				type : 'POST',
			            				dataType : 'json',
			            				async:true,
			            				success : function(data) {
			            					alert(data.result);
			            					//关闭模态框
			            					$('#trace').modal('hide');
			            					//添加跟踪信息成功后刷新当前页面
			            					window.location.reload();
			            				}
			            			});
		                    	}
			               	  
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
														onclick="closeModal_symbol()" aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患-跟踪详情</h3>
												</div>
												<form>
													<div class="modal-body">
														<div class="el_parperInfo">
															<h3>&nbsp;&nbsp;隐患基本信息</h3>
															<table>
																<tr>
																	<td>检查日期：</td>
																	<td id="findTime_detail"></td>
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
																	<td>责任单位：</td>
																	<td id="dutyUnit_detail"></td>
																</tr>
																<tr>
																	<td>隐患内容：</td>
																	<td colspan="3" id="dangerContent_detail"><</td>
																</tr>
															</table>

															<br />


															<h3>&nbsp;&nbsp;五定基本信息</h3>
															<table>
																<tr>
																	<td>五定时间：</td>
																	<td id="sidingTime_detail"></td>
																	<td>督办人：</td>
																	<td id="supervisor_detail"></td>

																</tr>
																<tr>
																	<td>整改时间：</td>
																	<td id="rectificationTime_detail"></td>
																	<td>责任人</td>
																	<td id="dutyPerson_detail"></td>
																</tr>
																<tr>
																	<td>整改措施：</td>
																	<td colspan="3" id="rectificationmeasure_detail"></td>
																</tr>
															</table>


															<h3>
																<br />&nbsp;&nbsp;跟踪基本信息
															</h3>
															<table>
																<tr>
																	<td>整改时间</td>
																	<td id="recheckTime_detail"></td>
																	<td>安全技术员</td>
																	<td id="safetyTechnician_detail"></td>
																</tr>
																<tr>
																	<td>现场领导</td>
																	<td id="managerNameFollow_detail"></td>
																	<td>是否有安全措施</td>
																	<td id="hasSecurity_detail"></td>
																</tr>
															</table>
														</div>
													</div>
													<div class="modal-footer">
														<button type="button" class="btn btn-default"
															data-dismiss="modal" onclick="closeModal_symbol()">关闭</button>
													</div>
												</form>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>
									<script>
							//点击详情按钮进行的操作
		                    function allInfo(obj) {
		                    	
								//获取隐藏域值
		                    	var address_hidden = $(obj).parents("tr").find(".address_hidden").val();
		            			var dutyPerson_hidden = $(obj).parents("tr").find(".dutyPerson_hidden").val();
		            			var supervisor_hidden = $(obj).parents("tr").find(".supervisor_hidden").val();
		            			var rectificationmeasure_hidden = $(obj).parents("tr").find(".rectificationmeasure_hidden").val();
		                    	
								
		                    	//获取当前行中的所有列的信息
		            			$tds = $(obj).parents('tr').children('td');
		            			//alert($tds.eq(0).html() + $tds.eq(1).html());
		            			//alert($("#findTime").text());
		            			//$("#dangerGrade").text($tds.eq(1).html());
		            			$("#dangerGrade_detail").text($tds.eq(1).html());
		            			$("#dangerType_detail").text($tds.eq(2).html());
		            			$("#dutyUnit_detail").text($tds.eq(3).html());
		            			$("#dangerContent_detail").text($tds.eq(4).html());
		            			$("#findTime_detail").text($tds.eq(6).html());
		            			$("#checkUnit_detail").text($tds.eq(7).html());
		            			$("#findPerson_detail").text($tds.eq(8).html());
		            			$("#rectificationTime_detail").text($tds.eq(9).html());
		            			$("#sidingTime_detail").text($tds.eq(10).html());
		            			
		            			//添加隐藏域信息
		            			$("#address_detail").text(address_hidden);
		            			$("#dutyPerson_detail").text(dutyPerson_hidden);
		            			$("#rectificationmeasure_detail").text(rectificationmeasure_hidden);
		            			$("#supervisor_detail").text(supervisor_hidden);
		                    	
		            			//从数据库中获取跟踪表的相关信息
		            			
		            			//获取当前行的隐患信息的五定ID
		            			var sidingId = $(obj).parents("tr").find("#siding_IdNum").val();
		            			//alert(sidingId);
		            			//异步提交获取数据
		            			$.ajax({
			            				url : '${pageContext.request.contextPath }/followHander_getDetailInfo.action',
			            				data : {"sidingId":sidingId},
			            				type : 'POST',
			            				dataType : 'json',
			            				async:true,
			            				success : function(data) {
			            						//alert(data.followInfo);
			            						//是否有安全措施--判断输出
			            						$("#hasSecurity_detail").text(data.followInfo.hassecurity>0?"是":"否");
			            						//追踪详情信息
			            						$("#safetyTechnician_detail").text(data.followInfo.safetytechnician);
			            						$("#managerNameFollow_detail").text(data.followInfo.managername);
			            						$("#recheckTime_detail").text(Format(new Date(data.followInfo.rechecktime),
			                                    "yyyy-MM-dd HH:mm:ss"));
			            					}
			            				});
		                        $('#allInfo').modal();
		                    }
		                </script>

									<!-- 模态框 延期-->
									<div class="modal fade" id="postpone" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														onclick="closeModal_symbol()" aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">延期</h3>
												</div>

												<div class="modal-body">
													<h3>基本信息:</h3>
													<div class="el_parperInfo">
														<table>
															<tr>
																<td>检查日期：</td>
																<td id="findTime_delay">2017-12-10</td>
																<td>检查人：</td>
																<td id="findPerson_delay">王芳</td>
															</tr>
															<tr>
																<td>检查单位：</td>
																<td id="checkUnit_delay">机电科</td>
																<td>地点：</td>
																<td id="address_delay">1# 工程部</td>
															</tr>
															<tr>
																<td>隐患类型：</td>
																<td id="dangerType_delay">机电</td>
																<td>隐患级别：</td>
																<td id="dangerGrade_delay">C</td>
															</tr>
															<tr>
																<td>责任单位：</td>
																<td id="dutyUnit_delay">安装二队</td>
																<td>隐患内容：</td>
																<td id="dangerContent_delay">道超过扩散通风距离（实测长约××m、瓦斯浓度×%),未设置栅栏,揭示警标<</td>
															</tr>
														</table>
													</div>
													<form action="" id="delayform">
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">延期原因：</span>
															<textarea class="form-control texta" rows="10"
																name="deleayreason" id="deleayreason"></textarea>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">延期时间：</span>
															<input class="datainp wicon form-control el_modelinput" id="optsdate4" type="text" 
															name="delaytime"  readonly>
														</div>
														
														<div class="modal-footer">
															<!--  <button type="submit" class="btn btn-primary">保存</button> -->
															<button type="button" class="btn btn-primary"
																onclick="submitDelayInfo()">保存</button>
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
							//点击延期进行的操作
		                    function postpone(obj) {
		                    	
		                    	//初始化
		                    	initForm_delay();
		                    	
		                    	//获取当前行中的所有列的信息
		            			$tds = $(obj).parents('tr').children('td');
		            			//alert($tds.eq(0).html() + $tds.eq(1).html());
		            			//alert($("#findTime").text());
		            			//$("#dangerGrade").text($tds.eq(1).html());
		            			$("#dangerGrade_delay").text($tds.eq(1).html());
		            			$("#dangerType_delay").text($tds.eq(2).html());
		            			$("#dutyUnit_delay").text($tds.eq(3).html());
		            			$("#dangerContent_delay").text($tds.eq(4).html());
		            			$("#findTime_delay").text($tds.eq(6).html());
		            			$("#checkUnit_delay").text($tds.eq(7).html());
		            			$("#findPerson_delay").text($tds.eq(8).html());
		            			
		            			
		            			//获取五定id
		            			var sidingId = $(obj).parents("tr").find("#siding_IdNum").val();
		            			//alert(sidingId);
		            			
		            			//将获取的五定编号的id添加到到form表单中
		            			$("#delayform").append("<input type='hidden' id='sidingId' value= " + sidingId + " name='sidingid'/>");
			
								//加载模态框
		                        $('#postpone').modal();
		                    }
							
		                 	 //初始化页面
		                    function initForm_delay(){
		                		//延期原因
		                		$("#deleayreason").val("");
		        
		                		//alert("nihao");
		                	}
		                 	 
		                    //向action中提交数据
		                	function submitDelayInfo(){
		                    	
		                
		                	var isHasNull = $("#delayform").validate({
	            				rules : {
	            					deleayreason:"required",
	            					delaytime : "required"
	            			},
	            				messages : {
	            					deleayreason:{
	            						required : "不能为空"
	            						},
	            					delaytime:{
	            						required : "不能为空"
	            						}
	            				}
	            			});
		                	 
		                	//alert(isHasNull.form())
		                	if(isHasNull.form()){
		                		$.ajax({
		            				url : '${pageContext.request.contextPath }/delayHander_addDelay.action',
		            				data : $("#delayform").serialize(),
		            				type : 'POST',
		            				dataType : 'json',
		            				async:true,
		            				success : function(data) {
		            					alert(data.result);
		            					//关闭模态框
		            					$('#postpone').modal('hide');
		            					//刷新当前页面
		            					window.location.reload();
		            				}
		            			});
		                	}
		               
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
														<button type="button" class="btn btn-primary">导出</button>
														<button type="button" class="btn btn-default"
															data-dismiss="modal">关闭</button>
													</div>
												</form>

											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal -->
									</div>

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
					
					
					<!-- 模态框   隐患跟踪信息删除确认 -->
							<div class="modal fade" id="deleteTraceInfo_Model">
									<div class="modal-dialog" style="width:50%;">
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
												<input type="hidden" id="sidingId_url" /> <a onclick="sidingId_urlSubmit()"
													class="btn btn-success" data-dismiss="modal">确定</a>
												<button type="button" class="btn btn-default"
													data-dismiss="modal">取消</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal-dialog -->
								</div>
								<!-- /.modal -->
					<script>
						//点击删除按钮进行的相关操作
						function deleteFollowInfo(obj) {
							
							//获取当前行的隐患信息的五定ID
	            			var sidingId = $(obj).parents("tr").find("#siding_IdNum").val();
							//将五定编号设置到id为五定Id_url的标签中
							$("#sidingId_url").val(sidingId);
							$('#deleteTraceInfo_Model').modal();
						}
						//点击删除模态框的确定按钮实现删除事件
						function sidingId_urlSubmit() {
							/* var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
							window.location.href = url; */
							var sidingId = $("#sidingId_url").val();
							//alert(sidingId);
							$.ajax({
	            				url : '${pageContext.request.contextPath }/followHander_deleteFollowInfoBySidingId.action',
	            				data : {"sidingId_followInfo":sidingId},
	            				type : 'POST',
	            				dataType : 'json',
	            				async:true,
	            				success : function(data) {
	            					alert(data.result);
	            					//关闭模态框
	            					$('#deleteTraceInfo_Model').modal('hide');
	            					//删除成功后刷新页面
	            					window.location.reload();
	            				}
	            			});
							
						}
					</script>
					
					
						<!-- 模态框 修改 五定-->
							<div class="modal fade" id="traceFormModel_update" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" onclick="closeModal_symbol()"
												aria-hidden="true">&times;</button>
											<!--关闭符号-->
											<!--标题-->
											<h3 class="modal-title">安全隐患问题跟踪信息修改</h3>
										</div>

										<div class="modal-body">
										
											<form action="" id="traceform_update">
                                            <div class="input-group el_modellist" role="toolbar">
                                                <span class="el_spans">安全技术措施：</span>
                                                <label class="el_radioBox el_radioBox2">
                                                    <input type="radio" name="hassecurity"  value="1" id="hassecurity_update_1"> 有
                                                </label>
                                                <label class="el_radioBox el_radioBox2">
                                                    <input type="radio" name="hassecurity" value="0" id="hassecurity_update_0"> 无
                                                </label>
                                            </div>

                                            <div class="input-group el_modellist" role="toolbar">
                                                <span class="el_spans">现&nbsp;&nbsp;场&nbsp;&nbsp;领&nbsp;&nbsp;导&nbsp;：</span>
                                                <input type="text" class="form-control el_modelinput" name="managername" id="managerName_update"/>
                                            </div>

                                            <div class="input-group el_modellist" role="toolbar">
                                                <span class="el_spans">整&nbsp;&nbsp;改&nbsp;&nbsp;时&nbsp;&nbsp;间&nbsp;：</span>
                                                <input type="text" id="recheckTime_update" class="form-control el_modelinput" name="rechecktime" readonly="readonly"/>
                                                <script type="text/javascript">
                                                    var picker = new Pikaday(
                                                        {
                                                            field: document.getElementById('recheckTime_update'),
                                                            firstDay: 1,
                                                            minDate: new Date('1995-01-01'),
                                                            maxDate: new Date('2050-12-31'),
                                                            yearRange: [1995, 2050]
                                                        });

                                                    //获取当前日期
                                                    var mydate = new Date();
                                                    var year = mydate.getFullYear();
                                                    var month = mydate.getMonth() + 1;
                                                    if (month < 9) {
                                                        month = "0" + month;
                                                    }
                                                    var day = mydate.getDate();
                                                    if (day < 9) {
                                                        day = "0" + day;
                                                    }
                                                    $("#recheckTime_update").val(year + "-" + month + "-" + day);
                                                </script>
                                            </div>

                                            <div class="input-group el_modellist" role="toolbar">
                                                <span class="el_spans">现 场 安 全 员：</span>
                                                <input type="text" class="form-control el_modelinput" name="safetytechnician" id="safetyTechnician_update"/>
                                            </div>
												

												<div class="modal-footer">
													
													<button type="button" class="btn btn-primary" onclick="updateFollow_info()">修改</button>
													
													<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal_symbol()">关闭</button>
												</div>
											</form>

										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal -->
							</div>
							<script>
							
								function updateFollowInfo(obj){
									
									//获取当前行的隐患信息的五定ID
			            			var sidingId = $(obj).parents("tr").find("#siding_IdNum").val();
									//获取当前行的隐患信息的隐患编号
									var dangerId = $(obj).parents("tr").find("#danger_IdNum").val(); 
									
			            			//将获取的隐患编号的的id添加到到form表单中
				            		$("#traceform_update").append("<input type='hidden' id='dangerId' value= " + dangerId + " name='dangerid'/>");
				            		//将获取的五定编号的id添加到到form表单中
			            			$("#traceform_update").append("<input type='hidden' id='sidingId' value= " + sidingId + " name='sidingid'/>");
				
			            			//alert(sidingId);
			            			//异步提交获取数据
			            			$.ajax({
				            				url : '${pageContext.request.contextPath }/followHander_getDetailInfo.action',
				            				data : {"sidingId":sidingId},
				            				type : 'POST',
				            				dataType : 'json',
				            				async:true,
				            				success : function(data) {
				            						//alert(data.followInfo);
				            						//是否有安全措施--判断输出
				            						if(data.followInfo.hassecurity>0){
				            							//将是的按钮选中
				            							$("#hassecurity_update_1").attr("checked",true);
				            						}else{
				            							$("#hassecurity_update_0").attr("checked",true);
				            						}
				            						//追踪详情信息
				            						$("#safetyTechnician_update").val(data.followInfo.safetytechnician);
				            						$("#managerName_update").val(data.followInfo.managername);
				            						$("#recheckTime_update").val(Format(new Date(data.followInfo.rechecktime),"yyyy-MM-dd HH:mm:ss"));
				            						
				            						//将获取的隐患编号的id添加到form表单中
							            			$("#traceform_update").append("<input type='hidden'  value= " + data.followInfo.followid + " name='followid'/>");
							
				            					}
				            				});
			            			
									
									//打开修改隐患信息的模态框
									$("#traceFormModel_update").modal();
								}
								
								//点击修改保存按钮进行的操作
								function updateFollow_info(){
									//信息校验
									var isNotNull_update = $("#traceform_update").validate({
			            				rules : {
			            					managername:"required",
			            					safetytechnician : "required",
			            					rechecktime : "required"
			            					
			            				},
			            				messages : {
			            					managername:{
			            						required : "不能为空"
			            						},
			            						safetytechnician : {
			            						required : "不能为空"
			            					},
			            					rechecktime : {
			            						required : "不能为空"
			            					}
		            			
			            				}
			            			});
			                    	//alert(isNotNull.form())
			                    	if(isNotNull_update.form()){
			                    		$.ajax({
				            				url : '${pageContext.request.contextPath }/followHander_updateFollowInfo.action',
				            				data : $("#traceform_update").serialize(),
				            				type : 'POST',
				            				dataType : 'json',
				            				async:true,
				            				success : function(data) {
				            					alert(data.result);
				            					//关闭模态框
				            					$('#traceFormModel_update').modal('hide');
				            					//添加跟踪信息成功后刷新当前页面
				            					window.location.reload();
				            				}
				            			});
			                    	}
									
									
								}
							</script>






	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
	
	
	
</body>
</html>