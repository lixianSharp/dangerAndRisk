<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>菜单</title>

    <link rel="stylesheet" href="<%=path %>/css/public/menu.css"/>
</head>
<body>

    <div class="el_left" id="el_left">
        <!--左边索引模块-->
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

            <!--隐患管理-->
            <div class="panel panel-default el_bigMenu" value="0">
                <div class="panel-heading" role="tab" id="heading1">
                    <span role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapse1" aria-expanded="true" aria-controls="collapse1" class="el_title" id="heading11">
                        隐患管理
                    </span>
                </div>
                <div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a id="#hdInsert" href="<%=path %>/main/hdInsert.jsp" class="towmenu" aria-controls="profile">
                                隐患录入
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#handle" href="<%=path %>/main/handle.jsp" class="towmenu" aria-controls="profile" role="tab">
                                现场处理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdfour" href="<%=path %>/main/hdfour.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患四定
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdtrace" href="<%=path %>/main/hdtrace.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患跟踪
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdReview" href="<%=path %>/main/hdReview.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患复查
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdQuery" href="<%=path %>/main/hdQuery.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患查询
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdDayReport" href="<%=path %>/main/hdDayReport.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患日报
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdStatistic" href="<%=path %>/main/hdStatistic.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患统计
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#hdMonthReport" href="<%=path %>/main/hdMonthReport.jsp" class="towmenu" aria-controls="profile" role="tab">
                                隐患月报
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#queryUser5" href="<%=path %>/hdmanage/" class="towmenu" aria-controls="profile" role="tab" data-toggle="tab">
                                隐患分类
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#queryUser6" href="<%=path %>/hdmanage/" class="towmenu" aria-controls="profile" role="tab" data-toggle="tab">
                                短信提醒
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

            <!--系统管理-->
            <div class="panel panel-default el_bigMenu" value="1">
                <div class="panel-heading" role="tab" id="heading2">
                    <span role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapse2" aria-expanded="false" aria-controls="collapse2" class="el_title collapsed" id="heading12">
                        系统管理
                    </span>
                </div>
                <div id="collapse2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading2">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a id="#departManage" href="<%=path %>/main2/departManage.jsp" class="towmenu" aria-controls="profile" role="tab">
                                机构管理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#users" href="<%=path %>/main2/users.jsp" class="towmenu" aria-controls="profile" role="tab">
                                用户管理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#dictionary" href="<%=path %>/main2/dictionary.jsp" class="towmenu" aria-controls="profile" role="tab">
                                字典管理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#role" href="<%=path %>/main2/role.jsp" class="towmenu" aria-controls="profile" role="tab">
                                角色管理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a id="#authority" href="<%=path %>/main2/authority.jsp" class="towmenu" aria-controls="profile" role="tab">
                                查看权限
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>
    </div>

</body>
</html>