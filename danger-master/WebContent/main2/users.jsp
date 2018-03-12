<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();%>
	<%@ include file="/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>yorge的用户管理</title>

	<%@ include file="/controls/cssJs.jsp"%>
	
    <!--下拉树-->
    <link rel="stylesheet" href="<%=path %>/controls/selectDropTree/demo.css" type="text/css">
    <link rel="stylesheet" href="<%=path %>/controls/selectDropTree/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="<%=path %>/controls/selectDropTree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="<%=path %>/controls/selectDropTree/jquery.ztree.excheck.js"></script>
    <!--选择角色-->
    <script type="text/javascript">
        var setting10 = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeCheck: beforeCheck
            }
        };

        var zNodes10 = [
            {id: 1, pId: 0, name: "部门 1", open: true},
            {id: 101, pId: 1, name: "角色1 1-1", open: true},
            {id: 102, pId: 1, name: "角色2 1-1", open: true},
            {id: 103, pId: 1, name: "角色2 1-1", open: true},
            {id: 11, pId: 1, name: "部门2 1-1", open: true},
            {id: 111, pId: 11, name: "角色1 1-1", open: true},
            {id: 112, pId: 11, name: "角色2 1-1", open: true},
            {id: 113, pId: 11, name: "角色2 1-1", open: true},
            {id: 113, pId: 11, name: "角色3 1-1", open: true},
            {id: 12, pId: 1, name: " 部门3 1-2", open: true},
            {id: 121, pId: 12, name: "角色2 1-1", open: true},
            {id: 122, pId: 12, name: "角色2 1-1", open: true},
            {id: 123, pId: 12, name: "角色3 1-1", open: true},
            {id: 2, pId: 0, name: "一级权限二级权限 2", open: false},
            {id: 21, pId: 2, name: "随意勾选 2-1"},
            {id: 22, pId: 2, name: "随意勾选 2-2", open: true},
            {id: 221, pId: 22, name: "随意勾选 2-2-1"},
            {id: 222, pId: 22, name: "随意勾选 2-2-2"},
            {id: 23, pId: 2, name: "随意勾选 2-3"}
        ];

        var el_chooseDepart, className10 = "dark", el_id;
        function beforeCheck(treeId, treeNode) {
            className10 = (className10 === "dark" ? "" : "dark");
            el_id = treeNode.id;
            //判断点击的节点是否被选中，返回false 和 true
            if (!treeNode.checked) {//选中
                showLog10(treeNode.name);
            } else {                //未选中
                noshowLog10(treeNode.name);
            }
            return (treeNode.doCheck !== false);
        }
        function showLog10(str) {
            if (!el_chooseDepart) el_chooseDepart = $("#el_chooseDepart");
            el_chooseDepart.append("<li class='" + className10 + "' id='" + el_id + "'>" + str + "</li>");
            if (el_chooseDepart.children("li").length > 6) {
                el_chooseDepart.get(0).removeChild(el_chooseDepart.children("li")[0]);
            }
        }
        function noshowLog10(str) {
            if (!el_chooseDepart) el_chooseDepart = $("#el_chooseDepart");
            el_chooseDepart.children("#" + el_id).remove();
        }

        function checkNode10(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo10"),
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
                        zTree.checkNode10(nodes[i], true, false, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode10(nodes[i], false, false, callbackFlag);
                    } else if (type == "toggle") {
                        zTree.checkNode10(nodes[i], null, false, callbackFlag);
                    } else if (type == "checkTruePS") {
                        zTree.checkNode10(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode10(nodes[i], false, true, callbackFlag);
                    } else if (type == "togglePS") {
                        zTree.checkNode10(nodes[i], null, true, callbackFlag);
                    }
                }
            }
        }
        function setAutoTrigger10(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo10");
            zTree.setting10.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting10.check.autoCheckTrigger ? "true" : "false");
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo10"), setting10, zNodes10);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode10);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode10);
            $("#toggle").bind("click", {type: "toggle"}, checkNode10);
            $("#checkTruePS").bind("click", {type: "checkTruePS"}, checkNode10);
            $("#checkFalsePS").bind("click", {type: "checkFalsePS"}, checkNode10);
            $("#togglePS").bind("click", {type: "togglePS"}, checkNode10);
            $("#checkAllTrue").bind("click", {type: "checkAllTrue"}, checkNode10);
            $("#checkAllFalse").bind("click", {type: "checkAllFalse"}, checkNode10);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger10);

            $("#treeDemo10").hide();
            $("#el_chooseDepart").click(function () {
                $('#treeDemo10').toggle();
            })
        });
    </script>
    <!--索引中的角色-->
    <script type="text/javascript">
        var setting2 = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true,
                chkStyle: "radio",
                radioType: "all"
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                onCheck: onCheck
            }
        };

        var zNodes2 = [
            {id: 1, pId: 0, name: "随意勾选 1", open: true},
            {id: 11, pId: 1, name: "无 radio 1-1", nocheck: true},
            {id: 12, pId: 1, name: "随意勾选 1-2", open: true},
            {id: 121, pId: 12, name: "随意勾选 1-2-1"},
            {id: 122, pId: 12, name: "随意勾选 1-2-2"},
            {id: 123, pId: 12, name: "无 radio 1-2-3", nocheck: true},
            {id: 13, pId: 1, name: "随意勾选 1-3"},
            {id: 2, pId: 0, name: "禁止勾选 2", open: true},
            {id: 21, pId: 2, name: "禁止勾选 2-1", doCheck: false},
            {id: 22, pId: 2, name: "禁止勾选 2-2", open: true},
            {id: 221, pId: 22, name: "禁止勾选 2-2-1"},
            {id: 222, pId: 22, name: "禁止勾选 2-2-2", doCheck: false},
            {id: 223, pId: 22, name: "禁止勾选 2-2-3", doCheck: false},
            {id: 23, pId: 2, name: "禁止勾选 2-3", doCheck: false}
        ];

        var log, className = "dark";

        function onCheck(e, treeId, treeNode) {
            showLog(treeNode.name);
        }

        function showLog(str) {
            if (!log) log = $("#log");
            /*清空内部的东西*/
            if ($("#log > li").length > 0) {
                $("#log").children("li").remove();
            }
            log.append("<li class='" + className + "'>" + str + "</li>");

            /*判断是否插入进入，若插入进入，关闭树框*/
            if ($("#log > li").length > 0) {
                $("#treeDemo2").hide();
            }
        }

        function checkNode(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo2"),
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
            $.fn.zTree.init($("#treeDemo2"), setting2, zNodes2);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode);

            $("#treeDemo2").hide();
            $("#log").click(function () {
                $('#treeDemo2').toggle();
            })
        });
    </script>
    <!--配置角色-->
    <script type="text/javascript">
        var setting13 = {
            view: {
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeCheck: beforeCheck
            }
        };

        var zNodes13 = [
            {id: 1, pId: 0, name: "部门 1", open: true},
            {id: 101, pId: 1, name: "角色1 1-1", open: true},
            {id: 102, pId: 1, name: "角色2 1-1", open: true},
            {id: 103, pId: 1, name: "角色2 1-1", open: true},
            {id: 11, pId: 1, name: "部门2 1-1", open: true},
            {id: 111, pId: 11, name: "角色1 1-1", open: true},
            {id: 112, pId: 11, name: "角色2 1-1", open: true},
            {id: 113, pId: 11, name: "角色2 1-1", open: true},
            {id: 113, pId: 11, name: "角色3 1-1", open: true},
            {id: 12, pId: 1, name: " 部门3 1-2", open: true},
            {id: 121, pId: 12, name: "角色2 1-1", open: true},
            {id: 122, pId: 12, name: "角色2 1-1", open: true},
            {id: 123, pId: 12, name: "角色3 1-1", open: true},
            {id: 2, pId: 0, name: "一级权限二级权限 2", open: false},
            {id: 21, pId: 2, name: "随意勾选 2-1"},
            {id: 22, pId: 2, name: "随意勾选 2-2", open: true},
            {id: 221, pId: 22, name: "随意勾选 2-2-1"},
            {id: 222, pId: 22, name: "随意勾选 2-2-2"},
            {id: 23, pId: 2, name: "随意勾选 2-3"}
        ];

        var el_chooseDepart13, className13 = "dark", el_id;
        function beforeCheck(treeId, treeNode) {
            className13 = (className13 === "dark" ? "" : "dark");
            el_id = treeNode.id;
            //判断点击的节点是否被选中，返回false 和 true
            if (!treeNode.checked) {//选中
                showLog13(treeNode.name);
            } else {                //未选中
                noshowLog13(treeNode.name);
            }
            return (treeNode.doCheck !== false);
        }
        function showLog13(str) {
            if (!el_chooseDepart13) el_chooseDepart13 = $("#el_chooseDepart13");
            el_chooseDepart13.append("<li class='" + className13 + "' id='" + el_id + "'>" + str + "</li>");
            if (el_chooseDepart13.children("li").length > 6) {
                el_chooseDepart13.get(0).removeChild(el_chooseDepart13.children("li")[0]);
            }
        }
        function noshowLog13(str) {
            if (!el_chooseDepart13) el_chooseDepart13 = $("#el_chooseDepart13");
            el_chooseDepart13.children("#" + el_id).remove();
        }

        function checkNode13(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo13"),
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
                        zTree.checkNode13(nodes[i], true, false, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode13(nodes[i], false, false, callbackFlag);
                    } else if (type == "toggle") {
                        zTree.checkNode13(nodes[i], null, false, callbackFlag);
                    } else if (type == "checkTruePS") {
                        zTree.checkNode13(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode13(nodes[i], false, true, callbackFlag);
                    } else if (type == "togglePS") {
                        zTree.checkNode13(nodes[i], null, true, callbackFlag);
                    }
                }
            }
        }
        function setAutoTrigger13(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo13");
            zTree.setting13.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting13.check.autoCheckTrigger ? "true" : "false");
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo13"), setting13, zNodes13);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode10);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode10);
            $("#toggle").bind("click", {type: "toggle"}, checkNode10);
            $("#checkTruePS").bind("click", {type: "checkTruePS"}, checkNode10);
            $("#checkFalsePS").bind("click", {type: "checkFalsePS"}, checkNode10);
            $("#togglePS").bind("click", {type: "togglePS"}, checkNode10);
            $("#checkAllTrue").bind("click", {type: "checkAllTrue"}, checkNode10);
            $("#checkAllFalse").bind("click", {type: "checkAllFalse"}, checkNode10);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger13);

            $("#treeDemo13").hide();
            $("#el_chooseDepart13").click(function () {
                $('#treeDemo13').toggle();
            })
        });
    </script>
    <!--左边的树-->
    <script>
        var setting5 = {
            data: {
                key: {
                    title: "t"
                },
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeClick: beforeClick,
            }
        };

        var zNodes5 = [
            {id: 1, pId: 0, name: "***部门", t: "我很普通，随便点我吧", open: true},
            {id: 11, pId: 1, name: "叶子节点 - 1", t: "我很普通，随便点我吧"},
            {id: 111, pId: 11, name: "叶子节点 - 1", t: "我很普通，随便点我吧"},
            {id: 112, pId: 11, name: "叶子节点 - 1", t: "我很普通，随便点我吧"},
            {id: 12, pId: 1, name: "叶子节点 - 2"},
            {id: 13, pId: 1, name: "叶子节点 - 3"},
            {id: 2, pId: 0, name: "NB的父节点", open: false},
            {id: 21, pId: 2, name: "叶子节点2 - 1"},
            {id: 22, pId: 2, name: "叶子节点2 - 2"},
            {id: 23, pId: 2, name: "叶子节点2 - 3"},
            {id: 3, pId: 0, name: "郁闷的父节点", open: false},
            {id: 31, pId: 3, name: "叶子节点3 - 1"},
            {id: 32, pId: 3, name: "叶子节点3 - 2"},
            {id: 33, pId: 3, name: "叶子节点3 - 3"}
        ];

        /*选择节点。用与在添加字典是，判断是否有选择节点*/
        var NodeNums = 0;
        var NodeName = 0;
        var className = "dark";
        function beforeClick(treeId, treeNode, clickFlag) {
            className = (className === "dark" ? "" : "dark");
            //节点名：
            NodeName = treeNode.name
            NodeNums++;//用于添加字典
            return (treeNode.click != false);
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo5"), setting5, zNodes5);
        });
    </script>

    <link rel="stylesheet" href="<%=path %>/css/public/public_style.css"/>

    <link rel="stylesheet" href="<%=path %>/css/main2_sys/users.css"/>
</head>

<body>
<!--头-->
<jsp:include page="../public/header.jsp"></jsp:include>

<!--中部-->
<div class="html_middle">

    <!--放菜单-->
    <div id="leftbackground">
    	<jsp:include page="../public/menu.jsp"></jsp:include>
    <img src="<%=path %>/image/leftArrow.jpg" id="leftArrow"/>
    </div>
    <img src="<%=path %>/image/rightArrow.jpg" id="rightArrow"/>
    
    <!--放主界面内容-->
    <div  class="el_right">

<div class="container-fluid">
    <div class="panel panel-default">
        <!--菜单连接标题-->
        <div class="panel-heading"><span>系统管理</span><span>>用户管理</span></div>

        <div class="panel-body el_main">
            <!--树-->
            <div class="el_leftTree">
                <!--标题类，添加了一个颜色-->
                <span class="el_treeTitle">部门</span>
                <ul id="treeDemo5" class="ztree"></ul>
            </div>

            <!--内容-->
            <div class="el_qlmContent">
                <!--索引-->
                <div class="row el_queryBox">
                    <form action="">
                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans">用户姓名：</span>
                                <input type="text" class="form-control" name=""/>
                            </div>
                        </div>

                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans">用户职务：</span>
                                <select class="selectpicker form-control" title="请选择">
                                    <option>--请选择--</option>
                                    <option>系统管理员</option>
                                    <option>部门管理员</option>
                                    <option>普通用户</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans">身份证：</span>
                                <input type="text" class="form-control" name=""/>
                            </div>
                        </div>

                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans el_chooseSpan">角色：</span>
                                <select class="selectpicker form-control" title="请选择">
                                    <option>--请选择--</option>
                                    <option>***角色</option>
                                    <option>***角色</option>
                                    <option>***角色</option>
                                </select>
                            </div>
                        </div>

                        <!--提交查询按钮-->
                        <button type="submit" class="btn btn-default el_queryButton btn-sm">查询</button>
                    </form>

                </div>   <!--结束 查询表单提交-->

                <!--显示内容-->
                <h4 class="el_mainHead">用户管理</h4>
                <div class="panel panel-default el_Mainmain">

                    <div class="panel-body">
                        <!--按钮面板-->
                        <div class="panel panel-default">
                            <div class="panel-body el_MainxiaoMain">

                                <div class="el_topButton">
                                    <button class="btn btn-primary" onclick="el_addDictinary()">
                                        添加用户
                                    </button>

                                    <button class="btn btn-primary" onclick="addAcc()">
                                        创建账户
                                    </button>
                                    <script>
                                        function addAcc() {
                                            var nums = 0;
                                            $.each($(".el_checks"), function (i, el_check) {
                                                if ($(this).prop("checked")) {
                                                    nums++;
                                                }
                                            });
                                            if (nums == 1) {
                                                $("#el_addAccount").modal();
                                            } else {
                                                alert("只能选择一个试卷，才能执行此操作！")
                                            }
                                        }
                                    </script>

                                    <button class="btn btn-primary" id="modifyAccount" onclick="modifyAcc()">
                                        查看/修改账户
                                    </button>
                                    <script>
                                        function modifyAcc() {
                                            var nums = 0;
                                            $.each($(".el_checks"), function (i, el_check) {
                                                if ($(this).prop("checked")) {
                                                    nums++;
                                                }
                                            });
                                            /*
                                             * 判断该用户是否有账户
                                             * */
                                            if (nums == 1) {
                                                /*判断是否有已经创建密码*/
                                                $("#el_modifyAccount").modal();
                                            } else {
                                                alert("只能选择一个试卷，才能执行此操作！")
                                            }
                                        }
                                    </script>

                                    <button class="btn btn-primary" onclick="piliangaddRols()">
                                        批量添加角色
                                    </button>

                                    <button type="button" class="btn btn-primary" onclick="piliangdelcfm()">
                                        批量删除
                                    </button>

                                </div>

                            </div>
                        </div>
                        <!--表格
                            内容都提取到json里边-->
                        <table class="table table-hover table-bordered">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="el_checkQuanxuan"/></th>
                                <th>编号</th>
                                <th>用户名称</th>
                                <th>角色</th>
                                <th width="120">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><input type="checkbox" class="el_checks"/></td>
                                <td>001</td>
                                <td>米特</td>
                                <td><a href="javascript:void(0)" data-toggle="modal" data-target="#searchAuth"
                                       style="text-decoration: none">
                                    系统管理员 ...</a>
                                </td>
                                <td>
                                    <a class="el_delButton" onClick="delcfm()">删除</a>
                                    <a class="el_delButton" data-toggle="modal"
                                       data-target="#el_configRoles">配置角色</a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                        <!--第一列，复选框基本事件-->
                        <script>
                            $("#el_checkQuanxuan").change(function () {
                                if ($(this).prop("checked") == true) {
                                    $(".el_checks").prop("checked", "true");
                                } else {
                                    $(".el_checks").removeAttr("checked");
                                }
                            })
                        </script>

                        <!--分页-->
                        <div id="paginationIDU"></div>
                        <script>
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
                        </script>
                    </div>
                </div>

                <!-- 模态框 添加用户-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel2">添加用户</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">用户编号：</span>
                                        <input type="text" class="form-control el_modelinput" name=""/>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">用户姓名：</span>
                                        <input type="text" class="form-control el_modelinput" name=""/>
                                    </div>

                                    <!--默认，左边树选择的部门。不能改动-->
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">所属部门：</span>
                                        <input type="text" class="form-control el_modelinput el_chooseInput"
                                               id="addDefaultDepart" name="" disabled/>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">联系方式：</span>
                                        <input type="text" class="form-control" name=""/>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">选择角色：</span>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="0">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="1">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="2">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="3">角色1
                                        </label>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary">保存</button>
                                </div>
                            </form>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <script>
                    function el_addDictinary() {
                        //判断是否已经选择了树,跟据上边的NodeNums
                        if (NodeNums == 0) {
                            alert("请选选择一个树！")
                        } else {
                            /*给模态框中，添加默认部门*/
                            $("#addDefaultDepart").prop("value",NodeName);
                            $('#myModal').modal();
                        }
                    }
                </script>

                <!-- 模态框 添加账户-->
                <div class="modal fade" id="el_addAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel22">添加账户</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">身份证：</span>
                                        <input type="text" class="form-control el_modelinput" value="1846859548795684"
                                               name="" disabled/>
                                        <span></span>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">密&nbsp;&nbsp;&nbsp;码：</span>
                                        <input type="text" class="form-control el_modelinput" name="" value="123456"/>
                                        <span></span>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary">保存</button>
                                </div>
                            </form>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <!-- 模态框 修改账户-->
                <div class="modal fade" id="el_modifyAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel223">修改账户</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">账号：</span>
                                        <input type="text" class="form-control el_modelinput" name=""
                                               value="1846859548795684"/>
                                        <span></span>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">密码：</span>
                                        <input type="text" class="form-control el_modelinput" name="" value="123456"/>
                                        <span></span>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary">保存</button>
                                </div>
                            </form>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <!-- 模态框 配置角色-->
                <div class="modal fade" id="el_configRoles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel24">配置用户角色</h4>
                            </div>
                            <form>
                                <div class="modal-body">
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">选择角色：</span>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="0">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="1">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="2">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="3">角色1
                                        </label>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary">保存</button>
                                </div>
                            </form>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>

                <!-- 模态框   信息删除确认 -->
                <div class="modal fade" id="delcfmModel">
                    <div class="modal-dialog">
                        <div class="modal-content message_align">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">×</span></button>
                                <h4 class="modal-title">提示</h4>
                            </div>
                            <div class="modal-body">
                                <p>您确认要删除该条信息吗？</p>
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" id="url"/>
                                <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <script>
                    function delcfm() {
                        $('#delcfmModel').modal();
                    }
                    function urlSubmit() {
                        var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
                        window.location.href = url;
                    }
                </script>

                <!-- 模态框   批量信息删除确认 -->
                <div class="modal fade" id="delcfmModel2">
                    <div class="modal-dialog">
                        <div class="modal-content message_align">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">×</span></button>
                                <h4 class="modal-title">提示</h4>
                            </div>
                            <div class="modal-body">
                                <p>您确认要删除该试卷吗？</p>
                            </div>
                            <div class="modal-footer">
                                <input type="hidden" id="url2"/>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <script>
                    function piliangdelcfm() {
                        //累计选择的个数，若大于1，才执行，否则提示
                        var nums = 0;
                        $.each($(".el_checks"), function (i, el_check) {
                            if ($(this).prop("checked")) {
                                nums++;
                            }
                        });
                        if (nums > 1) {
                            $('#delcfmModel2').modal();
                        } else {
                            alert("请至少选择两列，才能执行此操作！")
                        }
                    }
                    function urlSubmit() {
                        var url = $.trim($("#url2").val());//获取会话中的隐藏属性URL
                        window.location.href = url;
                    }
                </script>

                <!-- 模态框 批量添加角色-->
                <div class="modal fade" id="el_addRoles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel822">批量添加角色</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">选择角色：</span>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="0">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="1">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" checked value="2">角色1
                                        </label>
                                        <label class="el_radioBox el_radioBox2">
                                            <input type="checkbox" name="el_roleType" value="3">角色1
                                        </label>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                    <button type="button" class="btn btn-primary">保存</button>
                                </div>
                            </form>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <script>
                    function piliangaddRols() {
                        //累计选择的个数，若大于1，才执行，否则提示
                        var nums = 0;
                        $.each($(".el_checks"), function (i, el_check) {
                            if ($(this).prop("checked")) {
                                nums++;
                            }
                        });
                        if (nums > 1) {
                            $('#el_addRoles').modal();
                        } else {
                            alert("请至少选择两列，才能执行此操作！")
                        }
                    }
                    function urlSubmit() {
                        var url = $.trim($("#url2").val());//获取会话中的隐藏属性URL
                        window.location.href = url;
                    }
                </script>

                <!-- 模态框 查看所有角色-->
                <div class="modal fade" id="searchAuth" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabe">查看该用户的所有角色信息</h4>
                            </div>
                            <div class="modal-body">
                                <table class="el_AuthInfo">
                                    <thead>
                                    <tr>
                                        <th>部门</th>
                                        <th>角色</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>***部门</td>
                                        <td>题库管理员</td>
                                    </tr>
                                    <tr>
                                        <td>***部门</td>
                                        <td>考试管理员</td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
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