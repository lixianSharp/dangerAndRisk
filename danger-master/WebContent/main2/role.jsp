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
    <!--批量添加角色选择权限-->
    <script type="text/javascript">
        var setting11 = {
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

        var zNodes11 = [
            {id: 1, pId: 0, name: "一级权限 1", open: true},
            {id: 11, pId: 1, name: "随意勾选 1-1", open: true},
            {id: 111, pId: 11, name: "随意勾选 1-1-1"},
            {id: 112, pId: 11, name: "随意勾选 1-1-2"},
            {id: 12, pId: 1, name: " 1-2", open: true},
            {id: 121, pId: 12, name: "随意勾选 1-2-1"},
            {id: 122, pId: 12, name: "随意勾选 1-2-2"},
            {id: 2, pId: 0, name: "一级权限二级权限 2", open: true},
            {id: 21, pId: 2, name: "随意勾选 2-1"},
            {id: 22, pId: 2, name: "随意勾选 2-2", open: true},
            {id: 221, pId: 22, name: "随意勾选 2-2-1"},
            {id: 222, pId: 22, name: "随意勾选 2-2-2"},
            {id: 23, pId: 2, name: "随意勾选 2-3"}
        ];

        var el_chooseDepart11, className11 = "dark", el_id;
        function beforeCheck(treeId, treeNode) {
            className11 = (className11 === "dark" ? "" : "dark");
            el_id = treeNode.id;
            //判断点击的节点是否被选中，返回false 和 true
            if (!treeNode.checked) {//选中
                showLog11(treeNode.name);
            } else {                //未选中
                noshowLog11(treeNode.name);
            }
            return (treeNode.doCheck !== false);
        }
        function showLog11(str) {
            if (!el_chooseDepart11) el_chooseDepart11 = $("#el_chooseDepart11");
            el_chooseDepart11.append("<li class='" + className11 + "' id='" + el_id + "'>" + str + "</li>");
            if (el_chooseDepart11.children("li").length > 6) {
                el_chooseDepart.get(0).removeChild(el_chooseDepart11.children("li")[0]);
            }
        }
        function noshowLog11(str) {
            if (!el_chooseDepart11) el_chooseDepart11 = $("#el_chooseDepart11");
            el_chooseDepart11.children("#" + el_id).remove();
        }

        function checkNode11(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo11"),
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
                        zTree.checkNode11(nodes[i], true, false, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode11(nodes[i], false, false, callbackFlag);
                    } else if (type == "toggle") {
                        zTree.checkNode11(nodes[i], null, false, callbackFlag);
                    } else if (type == "checkTruePS") {
                        zTree.checkNode11(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode11(nodes[i], false, true, callbackFlag);
                    } else if (type == "togglePS") {
                        zTree.checkNode11(nodes[i], null, true, callbackFlag);
                    }
                }
            }
        }
        function setAutoTrigger11(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo11");
            zTree.setting11.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting11.check.autoCheckTrigger ? "true" : "false");
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo11"), setting11, zNodes11);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode11);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode11);
            $("#toggle").bind("click", {type: "toggle"}, checkNode11);
            $("#checkTruePS").bind("click", {type: "checkTruePS"}, checkNode11);
            $("#checkFalsePS").bind("click", {type: "checkFalsePS"}, checkNode11);
            $("#togglePS").bind("click", {type: "togglePS"}, checkNode11);
            $("#checkAllTrue").bind("click", {type: "checkAllTrue"}, checkNode11);
            $("#checkAllFalse").bind("click", {type: "checkAllFalse"}, checkNode11);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger11);

            $("#treeDemo11").hide();
            $("#el_chooseDepart11").click(function () {
                $('#treeDemo11').toggle();
            })
        });
    </script>
    <!--批量添加角色选择部门-->
    <script type="text/javascript">
        var setting12 = {
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

        var zNodes12 = [
            {id: 1, pId: 0, name: "部门 1", open: true},
            {id: 11, pId: 1, name: "随意勾选 1-1", open: true},
            {id: 111, pId: 11, name: "随意勾选 1-1-1"},
            {id: 112, pId: 11, name: "随意勾选 1-1-2"},
            {id: 12, pId: 1, name: " 1-2", open: true},
            {id: 121, pId: 12, name: "随意勾选 1-2-1"},
            {id: 122, pId: 12, name: "随意勾选 1-2-2"},
            {id: 2, pId: 0, name: "部门 2", open: true},
            {id: 21, pId: 2, name: "随意勾选 2-1"},
            {id: 22, pId: 2, name: "随意勾选 2-2", open: true},
            {id: 221, pId: 22, name: "随意勾选 2-2-1"},
            {id: 222, pId: 22, name: "随意勾选 2-2-2"},
            {id: 23, pId: 2, name: "随意勾选 2-3"}
        ];

        var el_chooseDepart12, className12 = "dark", el_id;
        function beforeCheck(treeId, treeNode) {
            className12 = (className12 === "dark" ? "" : "dark");
            el_id = treeNode.id;
            //判断点击的节点是否被选中，返回false 和 true
            if (!treeNode.checked) {//选中
                showLog12(treeNode.name);
            } else {                //未选中
                noshowLog12(treeNode.name);
            }
            return (treeNode.doCheck !== false);
        }
        function showLog12(str) {
            if (!el_chooseDepart12) el_chooseDepart12 = $("#el_chooseDepart12");
            el_chooseDepart12.append("<li class='" + className12 + "' id='" + el_id + "'>" + str + "</li>");
            if (el_chooseDepart12.children("li").length > 6) {
                el_chooseDepart12.get(0).removeChild(el_chooseDepart12.children("li")[0]);
            }
        }
        function noshowLog12(str) {
            if (!el_chooseDepart12) el_chooseDepart12 = $("#el_chooseDepart12");
            el_chooseDepart12.children("#" + el_id).remove();
        }

        function checkNode12(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo12"),
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
                        zTree.checkNode12(nodes[i], true, false, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode12(nodes[i], false, false, callbackFlag);
                    } else if (type == "toggle") {
                        zTree.checkNode12(nodes[i], null, false, callbackFlag);
                    } else if (type == "checkTruePS") {
                        zTree.checkNode12(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode12(nodes[i], false, true, callbackFlag);
                    } else if (type == "togglePS") {
                        zTree.checkNode12(nodes[i], null, true, callbackFlag);
                    }
                }
            }
        }
        function setAutoTrigger12(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo12");
            zTree.setting12.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting12.check.autoCheckTrigger ? "true" : "false");
        }

        $(document).ready(function () {
            $.fn.zTree.init($("#treeDemo12"), setting12, zNodes12);
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode12);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode12);
            $("#toggle").bind("click", {type: "toggle"}, checkNode12);
            $("#checkTruePS").bind("click", {type: "checkTruePS"}, checkNode12);
            $("#checkFalsePS").bind("click", {type: "checkFalsePS"}, checkNode12);
            $("#togglePS").bind("click", {type: "togglePS"}, checkNode12);
            $("#checkAllTrue").bind("click", {type: "checkAllTrue"}, checkNode12);
            $("#checkAllFalse").bind("click", {type: "checkAllFalse"}, checkNode12);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger12);

            $("#treeDemo12").hide();
            $("#el_chooseDepart12").click(function () {
                $('#treeDemo12').toggle();
            })
        });
    </script>
    <!--添加单个角色选择权限-->
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
            {id: 1, pId: 0, name: "一级权限 1", open: true},
            {id: 11, pId: 1, name: "随意勾选 1-1", open: true},
            {id: 111, pId: 11, name: "随意勾选 1-1-1"},
            {id: 112, pId: 11, name: "随意勾选 1-1-2"},
            {id: 12, pId: 1, name: " 1-2", open: true},
            {id: 121, pId: 12, name: "随意勾选 1-2-1"},
            {id: 122, pId: 12, name: "随意勾选 1-2-2"},
            {id: 2, pId: 0, name: "一级权限二级权限 2", open: true},
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
    <!--修改单个角色选择权限-->
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
            {id: 1, pId: 0, name: "一级权限 1", open: true},
            {id: 11, pId: 1, name: "随意勾选 1-1", open: true},
            {id: 111, pId: 11, name: "随意勾选 1-1-1"},
            {id: 112, pId: 11, name: "随意勾选 1-1-2"},
            {id: 12, pId: 1, name: " 1-2", open: true},
            {id: 121, pId: 12, name: "随意勾选 1-2-1"},
            {id: 122, pId: 12, name: "随意勾选 1-2-2"},
            {id: 2, pId: 0, name: "一级权限二级权限 2", open: true},
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
            $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode13);
            $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode13);
            $("#toggle").bind("click", {type: "toggle"}, checkNode13);
            $("#checkTruePS").bind("click", {type: "checkTruePS"}, checkNode13);
            $("#checkFalsePS").bind("click", {type: "checkFalsePS"}, checkNode13);
            $("#togglePS").bind("click", {type: "togglePS"}, checkNode13);
            $("#checkAllTrue").bind("click", {type: "checkAllTrue"}, checkNode13);
            $("#checkAllFalse").bind("click", {type: "checkAllFalse"}, checkNode13);
            $("#autoCallbackTrigger").bind("change", {}, setAutoTrigger13);

            $("#treeDemo13").hide();
            $("#el_chooseDepart13").click(function () {
                $('#treeDemo13').toggle();
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

        var zNodes2 =[
            { id:1, pId:0, name:"随意勾选 1", open:true},
            { id:11, pId:1, name:"无 radio 1-1", nocheck:true},
            { id:12, pId:1, name:"随意勾选 1-2", open:true},
            { id:121, pId:12, name:"随意勾选 1-2-1"},
            { id:122, pId:12, name:"随意勾选 1-2-2"},
            { id:123, pId:12, name:"无 radio 1-2-3", nocheck:true},
            { id:13, pId:1, name:"随意勾选 1-3"},
            { id:2, pId:0, name:"禁止勾选 2", open:true },
            { id:21, pId:2, name:"禁止勾选 2-1", doCheck:false},
            { id:22, pId:2, name:"禁止勾选 2-2", open:true },
            { id:221, pId:22, name:"禁止勾选 2-2-1"},
            { id:222, pId:22, name:"禁止勾选 2-2-2", doCheck:false},
            { id:223, pId:22, name:"禁止勾选 2-2-3", doCheck:false},
            { id:23, pId:2, name:"禁止勾选 2-3", doCheck:false}
        ];

        var code, log, className = "dark";

        function onCheck(e, treeId, treeNode) {
            showLog(treeNode.name );
        }

        function showLog(str) {
            if (!log) log = $("#log");
            /*清空内部的东西*/
            if($("#log > li").length > 0){
                $("#log").children("li").remove();
            }
            log.append("<li class='"+className+"'>"+str+"</li>");

            /*判断是否插入进入，若插入进入，关闭树框*/
            if($("#log > li").length > 0) {
                $("#treeDemo2").hide();
            }
        }

        function checkNode(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo2"),
                type = e.data.type,
                nodes = zTree.getSelectedNodes();
            if (type.indexOf("All")<0 && nodes.length == 0) {
                alert("请先选择一个节点");
            }

            if (type == "checkAllTrue") {
                zTree.checkAllNodes(true);
            } else if (type == "checkAllFalse") {
                zTree.checkAllNodes(false);
            } else {
                var callbackFlag = $("#callbackTrigger").attr("checked");
                for (var i=0, l=nodes.length; i<l; i++) {
                    if (type == "checkTrue") {
                        zTree.checkNode(nodes[i], true, null, callbackFlag);
                    } else if (type == "checkFalse") {
                        zTree.checkNode(nodes[i], false, null, callbackFlag);
                    }else if (type == "checkTruePS") {
                        zTree.checkNode(nodes[i], true, true, callbackFlag);
                    } else if (type == "checkFalsePS") {
                        zTree.checkNode(nodes[i], false, true, callbackFlag);
                    }
                }
            }
        }

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo2"), setting2, zNodes2);
            $("#checkTrue").bind("click", {type:"checkTrue"}, checkNode);
            $("#checkFalse").bind("click", {type:"checkFalse"}, checkNode);

            $("#treeDemo2").hide();
            $("#log").click(function () {
                $('#treeDemo2').toggle();
            })
        });
    </script>
    <!--左边的树-->
    <script>
        var setting5 = {
            data: {
                key: {
                    title:"t"
                },
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeClick: beforeClick,
            }
        };

        var zNodes5 =[
            { id:1, pId:0, name:"***部门", t:"我很普通，随便点我吧", open:true},
            { id:11, pId:1, name:"叶子节点 - 1", t:"我很普通，随便点我吧"},
            { id:111, pId:11, name:"叶子节点 - 1", t:"我很普通，随便点我吧"},
            { id:112, pId:11, name:"叶子节点 - 1", t:"我很普通，随便点我吧"},
            { id:12, pId:1, name:"叶子节点 - 2"},
            { id:13, pId:1, name:"叶子节点 - 3"},
            { id:2, pId:0, name:"NB的父节点", open:false},
            { id:21, pId:2, name:"叶子节点2 - 1"},
            { id:22, pId:2, name:"叶子节点2 - 2"},
            { id:23, pId:2, name:"叶子节点2 - 3"},
            { id:3, pId:0, name:"郁闷的父节点", open:false },
            { id:31, pId:3, name:"叶子节点3 - 1"},
            { id:32, pId:3, name:"叶子节点3 - 2"},
            { id:33, pId:3, name:"叶子节点3 - 3"}
        ];

        /*选择节点。用与在添加字典是，判断是否有选择节点*/
        var NodeNums = 0;
        var className = "dark";
        function beforeClick(treeId, treeNode, clickFlag) {
            className = (className === "dark" ? "":"dark");
            //节点名：
            //treeNode.name
            NodeNums ++;//用于添加字典
            return (treeNode.click != false);
        }

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo5"), setting5, zNodes5);
        });
    </script>
    <!--查看权限-->
    <script>
        var setting3 = {
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var zNodes3 =[
            { id:1, pId:0, name:"随意勾选 1", open:true,chkDisabled:true},
            { id:11, pId:1, name:"随意勾选 1-1", open:true,chkDisabled:true},
            { id:111, pId:11, name:"随意勾选 1-1-1",chkDisabled:true},
            { id:112, pId:11, name:"随意勾选 1-1-2",chkDisabled:true},
            { id:12, pId:1, name:"随意勾选 1-2", open:true,chkDisabled:true},
            { id:121, pId:12, name:"随意勾选 1-2-1",chkDisabled:true},
            { id:122, pId:12, name:"随意勾选 1-2-2",chkDisabled:true},
            { id:2, pId:0, name:"随意勾选 2", checked:true, open:true,chkDisabled:true},
            { id:21, pId:2, name:"随意勾选 2-1",chkDisabled:true},
            { id:22, pId:2, name:"随意勾选 2-2", open:true,chkDisabled:true},
            { id:221, pId:22, name:"随意勾选 2-2-1", checked:true,chkDisabled:true},
            { id:222, pId:22, name:"随意勾选 2-2-2",chkDisabled:true},
            { id:23, pId:2, name:"随意勾选 2-3",chkDisabled:true}
        ];

        var code;

        function setCheck3() {
            var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
                py = $("#py").attr("checked")? "p":"",
                sy = $("#sy").attr("checked")? "s":"",
                pn = $("#pn").attr("checked")? "p":"",
                sn = $("#sn").attr("checked")? "s":"",
                type = { "Y":py + sy, "N":pn + sn};
            zTree.setting3.check.chkboxType = type;
            showCode3('setting3.check.chkboxType = { "Y" : "' + type.Y + '", "N" : "' + type.N + '" };');
        }
        function showCode3(str) {
            if (!code) code = $("#code");
            code.empty();
            code.append("<li>"+str+"</li>");
        }

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo3"), setting3, zNodes3);
            setCheck3();
            $("#py").bind("change", setCheck3);
            $("#sy").bind("change", setCheck3);
            $("#pn").bind("change", setCheck3);
            $("#sn").bind("change", setCheck3);
        });
    </script>

    <link rel="stylesheet" href="<%=path %>/css/public/public_style.css"/>
	
    <link rel="stylesheet" href="<%=path %>/css/main2_sys/role.css"/>
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
        <div class="panel-heading"><span>系统管理</span><span>>角色管理</span></div>

        <div class="panel-body el_main">

            <!--树-->
            <div class="el_leftTree">
                <!--标题类，添加了一个颜色-->
                <span class="el_treeTitle">部门</span>
                <ul id="treeDemo5" class="ztree"></ul>
            </div>

            <!--内容-->
            <div class="col-md-10 el_qlmContent">

                <!--索引-->
                <div class="row el_queryBox">
                    <form action="">
                        <div class="col-md-3 el_qlmQuery">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans el_chooseSpan el_chooseSpan2">角色：</span>
                                <ul id="log" class="el_modelinput log"></ul>
                                <img src="../controls/selectDropTree/smallTriangle.png" class="el_smallTriangle"
                                     width="7"/>
                                <ul id="treeDemo2" class="ztree"></ul>
                            </div>
                        </div>

                        <div class="col-md-3 el_qlmQuery el_qlmQueryR">
                            <div class="input-group" role="toolbar">
                                <span class="el_spans">角色状态：</span>
                                <label class="el_radioBox"><input type="radio" name="el_state"> 启用</label>&nbsp;
                                <label class="el_radioBox"><input type="radio" name="el_state"> 禁用</label>
                            </div>
                        </div>

                        <!--提交查询按钮-->
                        <button type="submit" class="btn btn-default el_queryButton btn-sm">查询</button>
                    </form>

                </div>   <!--结束 查询表单提交-->

                <!--显示内容-->
                <h4 class="el_mainHead">角色管理</h4>
                <div class="panel panel-default el_Mainmain">

                    <div class="panel-body">

                        <!--按钮面板-->
                        <div class="panel panel-default">
                            <div class="panel-body el_MainxiaoMain">

                                <div class="el_topButton">
                                    <button class="btn btn-primary" onclick="el_addDictinary()">
                                        添加角色
                                    </button>

                                    <button type="button" class="btn btn-primary" onclick="piliangdelcfm()">
                                        批量删除
                                    </button>

                                    <button class="btn btn-primary" data-toggle="modal" data-target="#batchAddRoles">
                                        批量添加角色
                                    </button>

                                    <button class="btn btn-primary" onClick="searchauth()">
                                        查看权限
                                    </button>

                                </div>

                            </div>
                        </div>

                        <!--表格
                            内容都提取到json里边
                        -->
                        <table class="table table-hover table-bordered">
                            <thead>
                            <tr>
                                <th><input type="checkbox" id="el_checkQuanxuan"/></th>
                                <th>序号</th>
                                <th>角色名称</th>
                                <th>角色状态</th>
                                <th>描述</th>
                                <th>创建时间</th>
                                <th width="120">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td><input type="checkbox" class="el_checks"/></td>
                                <td>1</td>
                                <td>系统管理员</td>
                                <td>启用</td>
                                <td>维护系统</td>
                                <td>2014-11-2</td>
                                <td>
                                    <a href="" data-toggle="modal" data-target="#modifyUserInfo">修改</a>&nbsp;
                                    <a class="el_delButton" onClick="delcfm()">删除</a>&nbsp;
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="el_checks"/></td>
                                <td>2</td>
                                <td>系统管理员</td>
                                <td style="color:red">禁用</td>
                                <td>维护系统</td>
                                <td>2014-11-2</td>
                                <td>
                                    <a href="" data-toggle="modal" data-target="#modifyUserInfo">修改</a>&nbsp;
                                    <a class="el_delButton" onClick="delcfm()">删除</a>&nbsp;
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

                <!-- 模态框 添加角色-->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel2">添加角色</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色名称：</span>
                                        <input type="text" class="form-control el_modelinput" name=""/>
                                        <span></span>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色状态：</span>
                                        <label class="el_radioBox"><input type="radio" name="el_state" checked> 启用</label>&nbsp;
                                        <label class="el_radioBox"><input type="radio" name="el_state"> 禁用</label>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">配置权限：</span>
                                        <ul id="el_chooseDepart" class="form-control"></ul>
                                        <img src="../controls/selectDropTree/smallTriangle.png" class="el_smallTriangle"
                                             width="7"/>
                                        <ul id="treeDemo10" class="ztree"></ul>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色描述：</span>
                                        <textarea class="form-control el_modelinput" rows="1"></textarea>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">创建时间：</span>
                                        <input type="text" id="datepicker" class="form-control el_modelinput"/>
                                        <script type="text/javascript">
                                            var picker = new Pikaday(
                                                {
                                                    field: document.getElementById('datepicker'),
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
                                            $("#datepicker").val(year + "-" + month + "-" + day);

                                        </script>
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
                            $('#myModal').modal();
                        }
                    }
                </script>

                <!-- 模态框 批量添加角色-->
                <div class="modal fade" id="batchAddRoles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel242">批量添加权限</h4>
                            </div>
                            <form>
                                <div class="modal-body">

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色名称：</span>
                                        <input type="text" class="form-control el_modelinput" name=""/>
                                        <span></span>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色状态：</span>
                                        <label class="el_radioBox"><input type="radio" name="el_state" checked> 启用</label>&nbsp;
                                        <label class="el_radioBox"><input type="radio" name="el_state"> 禁用</label>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色描述：</span>
                                        <textarea class="form-control el_modelinput" rows="1"></textarea>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">选择部门：</span>
                                        <ul id="el_chooseDepart12" class="form-control"></ul>
                                        <img src="../controls/selectDropTree/smallTriangle.png" class="el_smallTriangle"
                                             width="7"/>
                                        <ul id="treeDemo12" class="ztree"></ul>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">配置权限：</span>
                                        <ul id="el_chooseDepart11" class="form-control"></ul>
                                        <img src="../controls/selectDropTree/smallTriangle.png" class="el_smallTriangle"
                                             width="7"/>
                                        <ul id="treeDemo11" class="ztree"></ul>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">创建时间：</span>
                                        <input type="text" id="datepicker3" class="form-control el_modelinput"/>
                                        <script type="text/javascript">
                                            var picker = new Pikaday(
                                                {
                                                    field: document.getElementById('datepicker3'),
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
                                            $("#datepicker3").val(year + "-" + month + "-" + day);

                                        </script>
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

                <!-- 模态框 修改角色信息-->
                <div class="modal fade" id="modifyUserInfo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabel24">修改角色</h4>
                            </div>
                            <form>
                                <div class="modal-body">
                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色名称：</span>
                                        <input type="text" class="form-control el_modelinput" name=""/>
                                        <span></span>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色状态：</span>
                                        <label class="el_radioBox"><input type="radio" name="el_state" checked> 启用</label>&nbsp;
                                        <label class="el_radioBox"><input type="radio" name="el_state"> 禁用</label>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans el_chooseSpan">配置权限：</span>
                                        <ul id="el_chooseDepart13" class="form-control"></ul>
                                        <img src="../controls/selectDropTree/smallTriangle.png" class="el_smallTriangle"
                                             width="7"/>
                                        <ul id="treeDemo13" class="ztree"></ul>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">角色描述：</span>
                                        <textarea class="form-control el_modelinput" rows="1"></textarea>
                                    </div>

                                    <div class="input-group el_modellist" role="toolbar">
                                        <span class="el_spans">创建时间：</span>
                                        <input type="text" id="datepicker2" class="form-control el_modelinput"/>
                                        <script type="text/javascript">
                                            var picker = new Pikaday(
                                                {
                                                    field: document.getElementById('datepicker2'),
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
                                            $("#datepicker2").val(year + "-" + month + "-" + day);

                                        </script>
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
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
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
                                <p>您确认要删除所选角色吗？</p>
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

                <!-- 模态框   配置权限 -->
                <div class="modal fade" id="setAuthority">
                    <div class="modal-dialog">
                        <div class="modal-content message_align">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">×</span></button>
                                <h4 class="modal-title">配置权限</h4>
                            </div>
                            <div class="modal-body">
                                <!--权限选择下拉树-->
                                <div class="el_seletTreeDepart">
                                    <ul id="treeDemo" class="ztree"></ul>
                                </div><!--结束树-->
                                <br/>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">保存</a>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <script>
                    function setAuth() {
                        $('#setAuthority').modal();
                    }
                </script>

                <!-- 模态框 查看权限-->
                <div class="modal fade" id="searchAuth" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"
                                        aria-hidden="true">&times;</button><!--关闭符号-->
                                <!--标题-->
                                <h4 class="modal-title" id="myModalLabe">查看权限</h4>
                            </div>
                            <div class="modal-body">
                                <!--权限选择下拉树-->
                                <div class="el_seletTreeDepart">
                                    <ul id="treeDemo3" class="ztree"></ul>
                                </div><!--结束树-->
                                <br/>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </div>

                        </div><!-- /.modal-content -->
                    </div><!-- /.modal -->
                </div>
                <script>
                    function searchauth() {
                        //累计选择的个数，若等于1，才执行，否则提示
                        var nums = 0;
                        $.each($(".el_checks"), function (i, el_check) {
                            if ($(this).prop("checked")) {
                                nums++;
                            }
                        });
                        if (nums == 1) {
                            $('#searchAuth').modal();
                        } else {
                            alert("请至选择一个角色！")
                        }
                    }
                </script>

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