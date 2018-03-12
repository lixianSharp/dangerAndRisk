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
<title>yorge的用户管理</title>

<%@ include file="/controls/cssJs.jsp"%>

<script type="text/javascript" src="<%=path%>/js/danger/hdQuery.js"></script>
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


<script src="<%=path%>/js/tree.js"></script> 
<!--索引责任单位-->
<script type="text/javascript">

         var setting3 = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            data: {
            	simpleData : {
					enable : true,
					idKey : "departmentId",
					pIdKey : "upDepartmentId",
					rootPId : "10",
				}
            },
            callback: {
                onCheck: onCheck
            }
        };

        var code, log3, className = "dark";

        function onCheck(e, treeId, treeNode) {
        	$("#unitId").val(treeNode.name);
            showLog3(treeNode.name);
        }

        function showLog3(str) {
            if (!log3) log3 = $("#log3");
            //清空内部的东西
            if ($("#log3 > li").length > 0) {
                $("#log3").children("li").remove();
            }
            log3.append("<li class='" + className + "'>" + str + "</li>");

            //判断是否插入进入，若插入进入，关闭树框
            if ($("#log3 > li").length > 0) {
                $("#treeDemo3").hide();
            }
        }

        function checkNode(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo3"),
                type = e.data.type,
                nodes = zTree.getSelectedNodes();
            if (type.indexOf("All") < 0 && nodes.length == 0) {
                alert("请先选择一个节点");
            }

            if (type == "checkAllTrue") {
                zTree.checkAllNodes(true);
            } else if (type == "checkAllFalse") {
                zTree.checkAllNodes(false);
            } else {
                var callbackFlag = $("#callbackTrigger").attr("checked");
                for (var i = 0, l = nodes.length; i < l; i++) {
                    if (type == "checkTrue") {
                        zTree.checkNode(nodes[i], true, null, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode(nodes[i], false, null, callbackFlag);
                    } else if (type == "checkTruePS") {
                        zTree.checkNode(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode(nodes[i], false, true, callbackFlag);
                    }
                }
            }
        }

        $(document).ready(function () {
        	searchUnitTree();
        	var zNodes = eval("("+$("#hidden_tree").val()+")"); 
            $.fn.zTree.init($("#treeDemo3"), setting3, zNodes);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode);

            $("#treeDemo3").hide();
            $("#log3").click(function () {
                $('#treeDemo3').toggle();
            })

        }); 
    </script>

<link rel="stylesheet" href="<%=path%>/css/public/public_style.css" />

<link rel="stylesheet" href="<%=path%>/css/main_hd/hdQuery.css" />
</head>

<body>
	<input type="hidden" id="hidden_tree" value="">
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
						<span>隐患管理 </span><span>> 隐患查询</span>
					</div>

					<div class="panel-body el_main">

						<!--内容-->
						<div class=" col-md-12">

							<!--索引-->
							<div class="row el_queryBox">
								<form action="${baseurl }/queryView_findDanger2.action"
									method="post" id="queryForm">
									<div class="row el_queryBoxrow">
										
										<!-- 隐藏域，隐藏从后台action中传过来的检查单位 -->
										<input id="checkunitValue" type="hidden" value="${checkunit }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
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
										
										<!-- 隐藏域，隐藏从后台action中传过来的隐患类型 -->
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
										
										<!-- 隐藏域，隐藏从后台action中传过来的隐患类型 -->
										<input id="dangerstatusValue" type="hidden" value="${dangerstatus }"/>
										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">隐患状态：</span> 
												<select id="dangerStatus"
													class="selectpicker form-control" title="请选择"
													name="dangerstatus">
													<%-- <option value="">--请选择--</option>
													<option value="未五定"
														<c:if test="${'未五定' eq dangerstatus}">selected</c:if>>未五定</option>
													<option value="已五定"
														<c:if test="${'已五定' eq dangerstatus}">selected</c:if>>已五定</option>
													<option value="已整改"
														<c:if test="${'已整改' eq dangerstatus}">selected</c:if>>已整改</option>
													<option value="已复查"
														<c:if test="${'已复查' eq dangerstatus}">selected</c:if>>已复查</option>
													<option value="现场处理"
														<c:if test="${'已现场处理' eq dangerstatus}">selected</c:if>>已现场处理</option> --%>
												</select>
											</div>
										</div>
									</div>

									<div class="row el_queryBoxrow">

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans">发现日期：</span> <input
													class="datainp wicon form-control" id="optsdate2"
													type="text" placeholder="请选择发现日期" value="${findtime }"
													name="findtime" readonly />
											</div>
										</div>

										<div class="col-md-3 el_qlmQuery">
											<div class="input-group" role="toolbar">
												<span class="el_spans el_chooseSpan">责任单位：</span> 
												<!-- 隐藏域，隐藏从选中的树中提取过来的数据 -->
												<input id="unitId" type="hidden" name="unit" value="${unit}" />
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
									<button class="btn btn-default el_queryButton btn-sm" style="right:120px;" onclick="clearBtn()" >清空</button>
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
									$("#findDangerType").val("");
									
									//清空隐患地点
									$("#dangerAddress").val("");
									
									//清空隐患内容
									$("#findDangerContent").val("");
									
									//清空隐患状态
									$("#dangerStatus").val("");
									
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

											<!-- <div class="el_topButton">
												<button class="btn btn-primary" data-toggle="modal"
													data-target="#el_Export">导出</button>
											</div> -->

										</div>
									</div>

									<!--表格
                            		内容都提取到json里边
                        -->
									<table class="table table-hover table-bordered">
										<thead>
											<tr>
												<th>序号</th>
												<th>级别</th>
												<th>类型</th>
												<th>责任单位</th>
												<th>隐患内容</th>
												<th>地点</th>
												<th>检查日期</th>
												<th>检查单位</th>
												<th>检查人</th>
												<th>状态</th>
												<th width="140">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="danger"	items="${result.pageBean.productList }" varStatus="status">
											<tr>
												<td>${ status.index + (result.pageBean.currentPage-1)*10+1}</td>
												<td>${danger.dangergrade }</td>
												<td>${danger.type }</td>
												<td>${danger.unit }</td>
												<td> 
													<c:set var="dangerContent" value="${danger.content }"/>
													<c:if test="${fn:length(dangerContent) < 12}">
									               	 ${danger.content } 
													</c:if>
													<c:if test="${fn:length(dangerContent) >= 12}">
														 ${fn:substring(dangerContent,0,12)} ... 
													</c:if>
												</td> 
												<!-- 隐藏一个班次 -->
												<input type="hidden" name="classType" value="${danger.classtype }" class="hiddenClass" />
												<td>${danger.address }</td>
												<td><fmt:formatDate value="${danger.findtime }"	pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
												<td>${danger.checkunit }</td>
												<td>${danger.findperson }</td>
												<td>${danger.dangerstatus }</td>
												<td>
													<!-- 隐藏域 隐患id  用于存放每一条记录的隐患id-->
													<input type="hidden" class="uppdangerid" value="${danger.dangerid}" />
													 <!--对应查询出来的每一条隐患信息的隐患id  -->
													<a href="javascript:void(0)" onClick="allInfo(${danger.dangerid})">详情</a> 
													<a href="javascript:void(0)" onClick="modify(this)" name="${danger.classtype }">修改</a>
													<a class="el_delButton" onClick="delcfm()">删除</a>
												</td>
											</tr>
											</c:forEach>

										</tbody>
									</table>
						<!-- 修改隐患 -->
						<script>
                        	function modify(obj){
                        		var tr = $(obj).parents("tr");//获取当前行对象
                        		var $tds = tr.children("td");
                        		
                        		
                        		//为隐藏域隐患id赋值
                        		$("#updatedangerid").val($(obj).siblings("input").val());
                        		
                        		//日期
                        		$("#optsdate").val($tds.eq(6).html());
                        		//班次
                        		$("#upclasstype").val(tr.children("input").val());
                        		//发现人
                        		$("#upfindperson").val($tds.eq(8).html());
                        		//检查单位
                        		var checkunit = $tds.eq(7).html();
                        		$("#upcheckunit option[value='"+checkunit+"']").attr("selected","selected");
                        		//地点
                        		$("#upaddress").val($tds.eq(5).html());
                        		//隐患内容
                        		$("#updangercontent").text($tds.eq(4).html());
                        		//隐患级别
                        		$("#bankHigh").val($tds.eq(1).html());
                        		//隐患类型
                        		$("#updangertype").val($tds.eq(2).html());
                        		
                        		//责任单位
                        		//把获取的责任单位内容，放到ul中，同时放到input 隐藏于中。
                        		//放到ul 中，是以文本形式放入的，没有连接树的单选按钮，若要修改，则选择树，清空ul 内容。
                        		//每次点击修改，需要先清空log4
                        		$("#upnuit").val($tds.eq(3).html());
                        		$("#log4").html("");
                        		var unitname = $tds.eq(3).html();
                        		$("#log4").append("<li>" + unitname + "</li>");//"<li class='" + className + "'>" + str + "</li>"
                        		
                        		$("#modify").modal();
                        	}
                        </script>

									<!-- 模态框  修改内容-->
									<div class="modal fade" id="modify" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">&times;</button>
													<!--关闭符号-->
													<!--标题-->
													<h3 class="modal-title">安全隐患详情</h3>
												</div>
												<form id="submitForm"
													action="${pageContext.request.contextPath }/danger/danger_updateBydanger.action"
													method="POST">
													
													<!-- 隐藏域，隐藏一个隐患id -->
													<input id="updatedangerid" type="hidden" name="danger.dangerid" />

													<div class="modal-body">
														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">发现日期：</span> <input
																class="datainp wicon form-control el_modelinput span4"
																id="optsdate" name="danger.findtime" type="text"
																readonly>
															<!-- <input type="text"
																name="danger.findtime" id="upfinddate"
																class="form-control el_modelinput span4"
																value="2017-08-01 1:00 PM" /> -->
														</div>


														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">班&nbsp;&nbsp;次：</span>
															<select class="selectpicker form-control"
																name="danger.classtype" id="upclasstype" title="请选择">
																<!-- <option value="0">--请选择--</option>
																<option value="甲班">甲班</option>
																<option value="乙班">乙班</option>
																<option value="C班">C班</option> -->
															</select>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">发&nbsp;现人：</span>
															<input type="text" class="form-control el_modelinput"
																id="upfindperson" name="danger.findperson" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">检查单位：</span> <select
																id="upcheckunit" class="selectpicker form-control"
																name="danger.checkunit" title="请选择">
																<!-- <option value="0">--请选择--</option>
																<option value="安全小分组">安全小分组</option>
																<option value="矿领导">矿领导</option>
																<option value="科领导">科领导</option>
																<option value="屯兰安监处">屯兰安监处</option>
																<option value="五人小组">五人小组</option>
																<option value="省厅">省厅</option>
																<option value="山西焦煤">山西焦煤</option>
																<option value="西山煤电">西山煤电</option>
																<option value="西山煤电安监局">西山煤电安监局</option> -->
															</select>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">地&nbsp;&nbsp;点：</span>
															<input id="upaddress" type="text"
																class="form-control el_modelinput" name="danger.address" />
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">隐患内容：</span>
															<textarea id="updangercontent" class="form-control texta"
																rows="10" name="danger.content"></textarea>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">隐患级别：</span> <select
																class="selectpicker form-control" title="请选择"
																id="bankHigh" name="danger.dangergrade">
																<option value="无">无</option>
																<option value="C">C</option>
																<option value="B">B</option>
																<option value="A">A</option>
															</select>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">隐患类型：</span> <select
																id="updangertype" class="selectpicker form-control"
																title="请选择" name="danger.type">
																<!-- <option>--请选择--</option>
																<option value="采煤">采煤</option>
																<option value="开掘">开掘</option>
																<option value="机电">机电</option>
																<option value="运输">运输</option>
																<option value="通风">通风</option>
																<option value="地测">地测</option>
																<option value="其他">其他</option> -->
															</select>
														</div>

														<div class="input-group el_modellist" role="toolbar">
															<span class="el_spans">责任单位：</span>
															 <input type="hidden"
																id="upnuit" name="danger.unit" /> 
															<!-- 隐藏域，隐藏一个隐患id -->
															<input type="hidden" id="updangerid" />
															<ul id="log4"
																class="el_modelinput el_chooseInput log form-control"
																name="dutyperson">
																<img src="<%=path%>/controls/selectDropTree/smallTriangle.png"
																	class="el_smallTriangle" width="7" />
															</ul>
															<ul id="treeDemo4" class="ztree"></ul>
														</div>


													</div>
													<div class="modal-footer">
														<!-- <button type="submit" class="btn btn-primary" id="submitButton">保存</button> -->
														<button type="button" onclick="submitButton1()"
															class="btn btn-primary" id="submitButton">保存</button>
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
		                   /*  function mosify() {
		                        $('#mosify').modal();
		                    } */
		                    
		                    <!--修改按钮的保存事件-->
		                    function submitButton1(){
		                    	$.ajax({
		                    		url:'${pageContext.request.contextPath }/danger/danger_updateBydanger.action',
		                    		data:$("#submitForm").serialize(),
		                    		type:'POST',
		                    		dataType:'json',
		                    		async:true,
		                    		success:function(data){
		                    			//alert("进入回掉函数");
		                    			alert(data.result);
		                    			window.location.reload();
		                    		}
		                    	});
		                    	$('#modify').modal("hide");
		                    }
		                </script>

									<!-- 模态框 详细信息(qiaoliqiang  start)-->
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
														<div class="el_parperInfo" id="motaiinfo">
															<!-- 动态放入数据 -->
														</div>
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

									<!-- 查询详细信息并开启模态框 -->
									<script>
		                    function allInfo(dangerId) {
		                    	$.ajax({
		                    		url : "${baseurl}/queryDetailInfo.action",
		                    		async : true,
		                    		type : "POST",
		                    		data : {
		                    			"dangerId" : dangerId
		                    		},
		                    		// 成功后开启模态框
		                    		success : showQuery2,
		                    		error : function() {
		                    			alert("请求失败");
		                    		},
		                    		dataType : "json"
		                    	});
		                    }
		                    function showQuery2(data){
		                    	
		                    	$("#motaiinfo").html("");
		                    	
		                    	/* var manger = "";
		                    	if(data.danger.manager==null){
		                    		manger="无";
		                    	}else{
		                    		manger = data.danger.manager;
		                    	}
		                    	 */
		                    	//模态框中添加隐患信息
		                    	var danger = data.danger;
		                    	var html = "&nbsp;&nbsp;基本信息<table class='Infotable'>"+
		                    	"<tr><td>" + "检查单位"+"</td><td>"+ danger.checkunit + "</td><td>"
                                +"检查人"+"</td><td>"+danger.findperson+"</td></tr>"+
                                "<tr><td>" + "检查日期"+"</td><td>"+ danger.findtime + "</td><td>"
                                +"地点"+"</td><td>"+danger.address+"</td></tr>"+
                                "<tr><td>" + "隐患类型"+"</td><td>"+ danger.type + "</td><td>"
                                +"隐患级别"+"</td><td>"+danger.dangergrade+"</td></tr>"+
                                "<tr><td>" + "隐患内容"+"</td><td>"+ danger.content + "</td><td>"
                                +"责任单位"+"</td><td>"+danger.unit+"</td></tr>"+
                                "<tr><td>" + "状态"+"</td><td>"+ danger.dangerstatus + "</td></tr>"+
		                                 "</table><br/>";
		                         $("#motaiinfo").append(html);
		                         
		                         //<td>"+"负责人"+"</td><td>"+ danger.manager+"</td>
		                         
		                         //五定信息
		                         var siding = data.siding;
		                         if(siding!=null){
		                         for(var i=0;i<siding.length;i++){
			                    	var html = "&nbsp;&nbsp;五定信息<table class='Infotable'>"+
			                    	"<tr><td>" + "五定时间"+"</td><td>"+ siding[i].sidingtime+ "</td><td>"
	                                +"督办人"+"</td><td>"+siding[i].supervisor+"</td></tr>"+
	                                "<tr><td>" + "整改时间"+"</td><td>"+ siding[i].rectificationtime + "</td><td>"
	                                +"整改措施"+"</td><td>"+siding[i].rectificationmeasure+"</td></tr>"+
			                                  "</table><br/>";
			                         $("#motaiinfo").append(html);
		                         }
		                         }
		                         
		                       //跟踪信息
		                         var follow = data.followlist;
		                         if(follow!=null){
		                         for(var i=0;i<follow.length;i++){
			                    	var html = "&nbsp;&nbsp;跟踪信息<table class='Infotable'>"+
			                    	"<tr><td>" + "现场领导"+"</td><td>"+ follow[i].managername+ "</td><td>"
	                                +"安全技术员"+"</td><td>"+follow[i].safetytechnician+"</td></tr>"+
	                                "<tr><td>" + "整改时间"+"</td><td>"+ follow[i].rechecktime +"</td></tr>"+
			                                  "</table><br/>";
			                         $("#motaiinfo").append(html);
		                         }
		                         }
		                         
		                         
		                       //复查信息
		                         var recheck = data.rechecklist;
		                         if(recheck!=null){
		                        	 $("#motaiinfo").append("<br/>");
		                        	 
		                        	 var rechechresult = "";
			                         for(var i=0;i<recheck.length;i++){
			                        	 
			                        	
			                        	if( recheck[i].recheckresult==0){
			                        		rechechresult = "合格";
			                        	}else if( recheck[i].recheckresult==1){
			                        		rechechresult = "不合格";
			                        		//recheck[i].recheckresult
			                        	}
				                    	var html = "&nbsp;&nbsp;复查信息<table  class='Infotable'>"+
				                    	"<tr><td>" + "复查人"+"</td><td>"+ recheck[i].recheckman+ "</td><td>"
		                                +"复查时间"+"</td><td>"+recheck[i].recheckdate+"</td></tr>"+
		                                "<tr><td>" + "复查结果"+"</td><td>"+  rechechresult+ "</td><td>"
		                                +"备注"+"</td><td>"+recheck[i].comment+"</td></tr>"+
				                                  "</table>";
				                         $("#motaiinfo").append(html);
			                         }
			                         }
		                         
		                    $('#allInfo').modal();
		                    }
		                    
		                </script>
									<!-- 模态框 详细信息(qiaoliqiang  end)-->



									<!-- 模态框   信息删除确认 -->
									<div class="modal fade" id="delcfmModel">
										<div class="modal-dialog">
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
													<!-- 隐藏域 用于存放隐患id -->
													<input type="hidden" id="url" /> <a
														onclick="urlSubmit(this)" class="btn btn-success"
														data-dismiss="modal">确定</a>
													<button type="button" class="btn btn-default"
														data-dismiss="modal">取消</button>
												</div>
											</div>
											<!-- /.modal-content -->
										</div>
										<!-- /.modal-dialog -->
									</div>
									<!-- /.modal -->
									<script type="text/javascript">
		                    function delcfm() {
		                        $('#delcfmModel').modal();
		                    }
		                    //确定删除的方法
		                    function urlSubmit(obj) {
		                		//var dangerid = $(obj).siblings("input").val();
		                		var dangerid = $(".uppdangerid").val();
		                	 	$.ajax({
		                			url:'${pageContext.request.contextPath}/danger/danger_deletebydangerid.action?dangerid='+dangerid,
		                			data:'',
		                			type:'POST',
		                			dataType:'json',
		                    		async:false,
		                			success:function(data){
		                				alert(data.message);
		                			}
		                			
		                		}); 
		                    	//刷新页面，当作刷新数据
		                	 	window.location.reload();
		                        /* var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
		                        window.location.href = url; */
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

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>