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
<title>字典管理</title>
<%@ include file="/controls/cssJs.jsp"%>
  
    <!--下拉树-->
    <link rel="stylesheet" type="text/css" media="screen" href="../controls/zTree/zTreeStyle/zTreeStyle.css" />
    <script type="text/javascript" src="../js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="../js/jquery.validate-1.13.1.js"></script>
    <link rel="stylesheet" href="../css/public/public_style.css"/>
    <script type="text/javascript" src="../js/dictionary/dictionary.js"></script>
    
    
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
        <div class="panel-heading"><span>系统管理</span><span>>字典管理</span></div>
        <div class="panel-body el_main">
            <!--树-->
            <div class="el_leftTree">
                <!--标题类，添加了一个颜色-->
                <span class="el_treeTitle">字典</span>
                <ul class="ztree"f style="width:165px;height:450px;overflow:auto;" id="treeDemo"></ul>
            </div>

            <!--内容-->
            <div class="el_qlmContent">
			<form id="dictionaryForm" method="post">
                <!--索引-->
                <div class="row el_queryBox">
                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans">字典名称：</span>
                                <input type="text" class="form-control" id="dic_name" />
                                
                                <input type="hidden" name="currentPage" id="currentPage" />
								<input type="hidden" name="currentCount" id="currentCount" />
								<input type="hidden" value="" id="bt_dictionaryId"/>
                            </div>
                        </div>
                        
                        <!--清空按钮-->
						<button type="reset"
							class="btn btn-default btn-sm"
							style="position:absolute;right:120px;top:15px;">清空</button>

                        <button type="submit" class="btn btn-default el_queryButton btn-sm" id="condition_sub">查询</button>
                 
                 	 <!--提交查询按钮-->
                        <button type="button" class="btn btn-default el_queryButton btn-sm" id="condition_sub" onclick="query()">查询</button>
                 </div>  <!--结束 查询表单提交-->
		</form>
                <!--显示内容-->
                <h4 class="el_mainHead">字典信息</h4>
                <div class="panel panel-default el_Mainmain">

                    <!--按钮面板-->
                    <div class="panel-body">
                        <div class="panel panel-default">
                            <div class="panel-body el_MainxiaoMain">
                                <div class="el_topButton">
                                
                                    <button class="btn btn-primary" id="dictionary_add" data-toggle="modal" 
                                    data-target="#dictionary_add_modal">添加</button>
                                    <button class="btn btn-primary" id="dictionary_change" data-toggle="modal" 
                                    data-target="#dictionary_fix_modal">修 改</button>
                                    <!-- <button type="button" class="btn btn-primary" id="dictionary_delete">批量删除</button> -->
                                    
                                    <!-- <input type="hidden" value="" id="bt_dictionaryId"> --> 
									<input type="hidden" value="" id="bt_dictionaryName"> 
									<input type="hidden" value="" id="bt_upDictionaryId"> 
									<input type="hidden" value="" id="bt_upDictionaryName"> 
									<input type="hidden" value="" id="table_row">	
									<input type="hidden" value="" id="leaf" />
									
                                </div>
                            </div>
                        </div>

                        <table class="table table-hover table-bordered" id="dictionaryTable">
                            <thead>
		                        <tr>
		                           <!-- <th><input type="checkbox" id="all" name="all"/></th> -->
		                           <th>序号</th>
		                           <th>字典名称</th>
		                          <!--  <th>字典编号</th> -->
		                         <!--   <th>上级字典编号</th> -->
		                           <th>字典状态</th>
		                           <th>描述</th>
		                           <th>操作</th>
		                        </tr>
                            </thead>
                            <tbody id="tbody"></tbody>
                        </table>

                        <!--分页-->
                        <div id="paginationIDU"></div>
                        <!-- <script>
                            $('#paginationIDU').pagination({
                                //			组件属性
                                "total": 1000,//数字 当分页建立时设置记录的总数量 1
                                "pageSize": 10,//数字 每一页显示的数量 10
                                "pageNumber": 1,//数字 当分页建立时，显示的页数 1
                                "pageList": [10, 20],//数组 用户可以修改每一页的大小，
                                //功能
                                "layout": ['list', 'sep', 'first', 'prev', 'manual', 'next', 'last', 'links'],
                                "onSelectPage": function (pageNumber, b) {
                                    alert("pageNumber=" + pageNumber);
                                    alert("pageSize=" + b);
                                }
                            });
                        </script> -->
                       
                        
                    </div>
                </div>

                <!-- 模态框 添加字典-->
                <div class="modal fade" id="dictionary_add_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel2">添加字典</h4>
                            </div>
                            <form id="addForm">
                                <div class="modal-body">
                                    <div class="input-group el_modellist" role="toolbar">
                                       <!--  <span class="el_spans">上级字典编号：</span> -->
                                        <input type="hidden" class="form-control" 
                                        	id="dap_add_id" name="dap_add_id" disabled/>
                                    </div>
									<div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">上级字典名称：</span>
                                        <input type="text" class="form-control" 
                                        	id="dap_add_name" name="dap_add_name" disabled/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">字&nbsp;典&nbsp;名&nbsp;称：</span>
                                        <input type="text" class="form-control" id="dictionary_name" name="dictionary_name" style="left: 14px;"/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                       <!--  <span class="el_spans">字典编号：</span> -->
                                        <input type="hidden" class="form-control" id="dictionary_id" name="" readonly="readonly"/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">&nbsp;字&nbsp;典&nbsp;状&nbsp;态：</span>
                                        <label class="el_radioBox"><input type="radio" class="dictionary_isUse" name="dictionary_isUse" 
                                        	value="启用" checked="checked"/>启用</label>&nbsp;
                                        <label class="el_radioBox"><input type="radio" class="dictionary_isUse" name="dictionary_isUse" 
                                        	value="禁用"/>禁用</label>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">字典描述：</span>
                                        <textarea class="form-control el_modelinput" id="dictionary_description" name="dictionary_description" rows="2" style="left: 24px;"></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" id="dictionary_add_save">保存</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <!-- 模态框 修改字典信息-->
                <div class="modal fade" id="dictionary_fix_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel24">修改字典信息</h4>
                            </div>
                            <form id="updateForm">
                                <div class="modal-body">
                                	<div class="input-group el_modellist" role="toolbar">
                                        <!-- <span class="el_spans">上级字典编号：</span> -->
                                        <input type="hidden" class="form-control" id="upDicId" name="upDicId" disabled/>
                                    </div>
									<div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">上级字典名称：</span>
                                        <input type="text" class="form-control" id="upDicName" name="" disabled/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                       <!--  <span class="el_spans">字典编号：</span> -->
                                        <input type="hidden" class="form-control" id="dict_id" name="" disabled/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">字典名称：</span>
                                        <input type="text" class="form-control" id="dict_name" name="dict_name"/>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">字典状态：</span>
                                        <label class="el_radioBox"><input type="radio" name="dic_isUse" class="dic_isUse" value="启用"> 启用</label>&nbsp;
                                        <label class="el_radioBox"><input type="radio" name="dic_isUse" class="dic_isUse" value="禁用"> 禁用</label>
                                    </div>
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">字典描述：</span>
                                        <textarea class="form-control el_modelinput" id="dict_description" name="dict_description" rows="2"></textarea>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary" id="dictionary_update_save">保存</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
            </div>
        </div>
    </div>
</div>
		</div>
		</div>
</body>
</html>