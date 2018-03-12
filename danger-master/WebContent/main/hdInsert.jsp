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

<!--选择树-->
<link rel="stylesheet" href="<%=path%>/controls/selectDropTree/demo.css"
	type="text/css">
<link rel="stylesheet"
	href="<%=path%>/controls/selectDropTree/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.excheck.js"></script>
<script src="${pageContext.request.contextPath }/js/dateformat.js"></script>

<script type="text/javascript" src="../js/danger/hdInsert.js"></script>
<!--责任单位-->

<!--编辑器-->
<script charset="utf-8"
	src="<%=path%>/controls/kindEditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="<%=path%>/controls/kindEditor/zh-CN.js"></script>
<script>
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('#editor_id', {
			resizeType : 1,
			items : [ 'table', '|', 'fontsize', 'bold', 'italic', 'underline',
					'removeformat', '|', 'justifyleft', 'justifycenter',
					'justifyright', '|', 'image' ]

		});

		// 取得HTML内容
		//var html = editor.html();

		// 同步数据后可以直接取得textarea的value
		//editor.sync();
		//fTextContent = $('#editor_id').val(); // jQuery

		// 设置HTML当前内容
		editor.html('尊敬的上级领导：');

	});
	function getContentF() {//获取富文本框的内容

		editor.sync();
		var html = $('#editor_id').val(); // jQuery
		return html;

	}
</script>

<link rel="stylesheet" href="<%=path%>/css/public/publicSon_style.css" />

<!--验证-->
<script src="<%=path%>/controls/validate/jquery.validate.js"></script>
<script src="<%=path%>/controls/validate/messages_zh.js"></script>
<link rel="stylesheet" href="<%=path%>/css/main_hd/hdInsert.css"/>
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
						<span>隐患管理 </span><span>> 隐患录入</span>
					</div>
					<div class="panel-body">

						<form id="addhdform">
							<div class="modal-body">

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">发现日期：</span> <input
										class="datainp form-control el_modelinput span4" id="optsdate"
										type="text" placeholder="请选择日期" name="danger.findtime"
										readonly style="background-color: white">
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：</span>
									<select id="className" class="selectpicker form-control"
										name="danger.classtype" title="请选择">
										<option value="">--请选择--</option>
										<!-- <option value="甲班">甲班</option>
										<option value="乙班">乙班</option>
										<option value="丙班">丙班</option> -->
									</select>
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">发&nbsp;&nbsp;现&nbsp;&nbsp;人：</span> <input
										type="text" class="form-control el_modelinput" id="findPerson"
										name="danger.findperson" />
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">检查单位：</span> 
									<select class="selectpicker form-control" name="danger.checkunit"
										id="fmchechunit" title="请选择">
										<option value="">--请选择--</option>
										<!-- <option value="安全小分组">安全小分组</option>
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
									<span class="el_spans">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：</span>
									<input id="didian" type="text"
										class="form-control el_modelinput" name="danger.address" />
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">隐患内容：</span>
									<textarea id="dangerneirong" class="form-control texta"
										rows="10" name="danger.content"></textarea>
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">隐患类型：</span>
									 <select id="dangerType" class="selectpicker form-control" title="请选择" name="danger.type">
										<option value="">--请选择--</option>
										<!-- <option value="采煤">采煤</option>
										<option value="开掘">开掘</option>
										<option value="机电">机电</option>
										<option value="运输">运输</option>
										<option value="通风">通风</option>
										<option value="地测">地测</option>
										<option value="其他">其他</option> -->
									</select>
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans" id="unitSpan">责任单位：</span>
									<ul id="log" class="el_modelinput el_chooseInput log form-control">
										<img src="<%=path%>/controls/selectDropTree/smallTriangle.png" class="el_smallTriangle" width="7"/>
									</ul>
									<span id="dutyUnit"></span>
									<ul id="treeDemo2" class="ztree"></ul>
									<!-- 隐藏域 把ul的内容，提到name=unit 的 hidden input 中  -->
									<input id="unit" type="hidden" name="danger.unit" value="" />
								</div>

								<div class="input-group el_modellist" role="toolbar">
									<span class="el_spans">隐患级别：</span> 
									<select	class="selectpicker form-control" title="请选择" 
									id="bankHigh" name="danger.dangergrade">
										<option value="" id="option0">--请选择--</option>
										<option value="无">无</option>
										<option value="D">D级</option>
										<option value="C">C级</option>
										<option value="B">B级</option>
										<option value="A">A级</option>
									</select>
								</div>

								<!-- 安全隐患上报报告内容 -->
								<input id="reportCon" type="hidden" name="danger.dangerreport" />
								<!-- 隐藏域 -->

							</div>
							<div class="modal-footer">
								<!-- <button type="submit" class="btn btn-primary" id="submitButton">保存</button> -->
								<button type="button" class="btn btn-primary" id="submitButton"
									onclick="saveButton()">保存</button>
							</div>

							<!--form原来在这里的  -->
						</form>

					</div>
					<script type="text/javascript">
						function saveButton() {
							var isNotNull = $("#addhdform").validate({
								ignore : [],
								rules : {
									"danger.findtime" : "required",//发现日期
									"danger.classtype" : {
										required : true
									},
									"danger.findperson" : "required",//验证文本框的。前边是 name 属性
									"danger.checkunit" : {
										required : true
									},//验证下拉框的，下拉框中的option 独有一个value 从 0 ， 1 ，2 往下排
									"danger.address" : "required",
									"danger.content" : "required",
									"danger.dangergrade" : {
										required : true
									},
									"danger.unit" : "required",
									"danger.type" : {
										required : true
									}
									
								},
								messages : {
									"danger.findtime" : {
										required : "不能为空"
									},//下边与上边对应
									"danger.classtype" : {
										required : "必须选择"
									},
									"danger.findperson" : {
										required : "不能为空"
									},
									"danger.checkunit" : {
										required : "必须选择"
									},
									"danger.address" : {
										required : "不能为空"
									},
									"danger.content" : {
										required : "不能为空"
									},
									"danger.dangergrade" : {
										required : "必须选择"
									},
									"danger.type" : {
										required : "必须选择"
									},
									"danger.unit" : {
										required : "责任单位不能为空"
									}
								}

							});

							if (isNotNull.form()) {
								console.log(isNotNull);
								$.ajax({
									url : '${pageContext.request.contextPath}/danger_addDanger.action',
									data : $("#addhdform").serialize(),
									type : 'POST',
									dataType : 'json',
									async : true,
									success : function(data) {
										//弹出是否录入成功
										alert(data.result);
										if (confirm("您需要继续录入吗？")) {
											//刷新当前页面
											window.location.reload(); 
											
											
											//清空责任单位
											if ($("#log > li").length > 0) {//先清空
												$("#log").children("li").remove();
											}
											//清空责任单位隐藏域的值
											$("#unit").val("");
											
											
											//班次
											$("#className").val("");//
											//发现人
											$("#findPerson").val("");
											//检查单位
											$("#fmchechunit").val("");//
											//地点
											$("#didian").val("");
											//隐患内容
											$("#dangerneirong").val('');
											//隐患类型
											$("#dangerType").val("");//
											//隐患级别
											$("#bankHigh").val("");//
											//安全隐患上报报告内容中隐藏域的值
											$("#reportCon").val("");
											
											//刷新当前页面，当作页面初始化
											//window.location.reload(); 
										} else {
											window.location.href = "${baseurl }/queryView_findDanger2.action";
										}
									}
								});
							}//if的括号
						}//saveButton()方法的括号
					</script>

					<!-- 模态框 上级部门汇报-->
					<div class="modal fade" id="el_setFour" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<!--关闭符号-->
									<!--标题-->
									<h3 class="modal-title">重大安全隐患上级部门汇报</h3>
								</div>

								<div class="modal-body">
									<div class="el_parperInfo">
										<table>
											<tr>
												<td>检查日期：</td>
												<td id="mtcheckdate">2017-12-10</td>
												<td>检查单位：</td>
												<td id="mtcheckuni">机电科</td>
												<td>检查人：</td>
												<td id="mtcheckperson">张明</td>
											</tr>
											<tr>
												<td>地点：</td>
												<td id="mtaddress">1# 工程部</td>
												<td>隐患类型：</td>
												<td id="mtdangertype">机电</td>
												<td>隐患级别：</td>
												<td id="mtdangergrade"></td>
											</tr>
											<tr>
												<td>隐患内容：</td>
												<td id="mtdangercontent" colspan="5">道超过扩散通风距离（实测长约××m、瓦斯浓度×%),未设置栅栏,揭示警标<</td>
											</tr>
										</table>
									</div>

									<h3 id="el_h3">重大安全隐患上报报告</h3>
									<div>
										<textarea id="editor_id" name="content"
											style="width: 100%; height: 300px;"></textarea>
									</div>
								</div>

								<div class="modal-footer">
									<button id="textaSave" type="submit" class="btn btn-primary">保存</button>
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
								</div>
								<script type="text/javascript">
									//为保存按钮添加点击事件
									$("#textaSave").click(function() {
										//alert("a")
										var cF = getContentF();//获取值
										/* editor.sync();//动态
										var html = $('#editor_id').val(); // jQuery
										return html; */

										//将id=editor_id标签文本框中的内容赋值给id=reportCon的文本框
										//var areaText = fTextContent;
										$("#reportCon").val(cF);
										//alert(cF);
										$('#el_setFour').modal('hide');
									});
								</script>

							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
					<!--完成录入，判断隐患级别是否是B A 当隐患类型的内容改变的时候执行这个方法-->
					<script>
						$("#bankHigh").change(function() {
								
								var bankValue = $("#bankHigh").val();
								
								//alert($("#bankHigh option:selected").text());

								if (bankValue == "B"	|| bankValue == "A") {
									//隐患类型为A级或者B级
									//初始化对应模态框中上面表格中的内容
									//alert($("#reservationtime").val());
									//检查日期
									$("#mtcheckdate").text($("#reservationtime").val());
									//检查单位
									$("#mtcheckuni").text($("#fmchechunit option:selected").text());
									//alert($("#fmchechunit option:selected").text());
									//检查人
									$("#mtcheckperson").text($("#findPerson").val());
									//地点
									$("#mtaddress").text($("#didian").val());
									//隐患类型
									$("#mtdangertype").text($("#dangerType option:selected").text());
									//隐患级别
									$("#mtdangergrade").text($("#bankHigh option:selected").text());
									//隐患内容
									$("#mtdangercontent").text($("#dangerneirong").val());

									$("#el_setFour").modal();
								}
							})
					</script>
				</div>
			</div>


		</div>

	</div>

	<!--放脚-->
	<jsp:include page="../public/footer.jsp"></jsp:include>
</body>
</html>


<!-- 机构树-责任单位的树 -->
<script>

</script>