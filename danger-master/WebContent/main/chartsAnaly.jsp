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
<link rel="stylesheet"
	href="<%=path%>/controls/selectDropTree/demo.css" type="text/css">
<link rel="stylesheet"
	href="<%=path%>/controls/selectDropTree/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.core.js"></script>
<script type="text/javascript"
	src="<%=path%>/controls/selectDropTree/jquery.ztree.excheck.js"></script>
    
    <script src="../controls/echarts/echarts.min.js"></script>

    <style>
        /*导航*/
        .el_stairTitle {
            margin: 5px 10px;
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
            font-weight: bolder;
        }

        #mainPage {
            background-color: #eee;
            width: 100%;
            padding-bottom: 20px;
        }

        #chart1 {
            width: 94%;
            height: 400px;
            float: left;
            background-color: white;
            margin: 3%;
            padding-bottom: 6%;
            padding-top: 10px;
        }
        #main {
            width: 70%;
            float: left;
            height: 100%;
        }

        #optionArea {
            width: 30%;
            height: 100%;
            float: right;
        }

        #optionArea .form-control,#optionArea2 .form-control {
            width: 120px;
        }

        #optionArea ul li,#optionArea2 ul li {
            float: left;
            list-style: none;
            margin-right: 20px;
            line-height: 34px;
        }

        .analyButton {
            float: right;
            margin-right: 40px;
            margin-top: 10px;
        }


        /*2*/
        #chart2 {
            clear: both;
            background-color: white;
            margin: 3%;
            padding: 3% 1%;
            height: 400px;
            padding-bottom: 6%;
            padding-top: 10px;
        }
        #main2 {
            width: 70%;
            float: right;
            height: 100%;
        }
        #optionArea2 {
            width: 30%;
            height: 100%;
            float: left;
        }
        #form2{
            margin-bottom:20px;
            height:100px;
        }
        #form22{
            clear:both;
            border-top:1px solid #eee;
            padding-top:10px;
        }
        .form22Div{
            margin:10px;
            margin-left:60px;
        }
        #form22timeInterval input{
            display:inline-block;
        }
    </style>

    <link rel="stylesheet" href="<%=path %>/css/public/public_style.css"/>
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
        <div class="el_stairTitle">
            <span>隐患管理 </span><span>> 隐患分析</span>
        </div>

        <div id="mainPage">
        
        <!-- <div><button class="btn btn-default">返回</button></div>
 -->
            <div id="chart1">
                <h3>【部门/专业】隐患分析柱状表</h3>
                <div id="main"></div>
                <script type="text/javascript">
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('main'));

                    // 指定图表的配置项和数据
                    var option = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                            }
                        },
                        legend: {
                            data: ['采煤', '开掘', '机电', '运输', '通风', '地测', '其他']
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: [
                            {
                                type: 'category',
                                data: ['一采区', '二采取', '三采取', '通风区', '抽采区', '运输区', '安装区']
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value'
                            }
                        ],
                        series: [
                            {
                                name: '采煤',
                                type: 'bar',
                                data: [32, 33, 30, 33, 39, 33, 32]
                            },
                            {
                                name: '开掘',
                                type: 'bar',
                                data: [12, 13, 10, 13, 9, 23, 21]
                            },
                            {
                                name: '机电',
                                type: 'bar',
                                data: [22, 18, 19, 23, 29, 33, 31]
                            },
                            {
                                name: '运输',
                                type: 'bar',
                                data: [15, 23, 20, 15, 19, 33, 41]
                            },
                            {
                                name: '通风',
                                type: 'bar',
                                data: [8, 10, 9, 10, 16, 16, 15],
                                markLine: {
                                    lineStyle: {
                                        normal: {
                                            type: 'dashed'
                                        }
                                    },
                                    data: [
                                        [{type: 'min'}, {type: 'max'}]
                                    ]
                                }
                            },
                            {
                                name: '地测',
                                type: 'bar',
                                barWidth: 5,
                                data: [6, 7, 7, 7, 10, 11, 11]
                            },
                            {
                                name: '其他',
                                type: 'bar',
                                data: [6, 8, 9, 8, 10, 11, 12]
                            }
                        ]
                    };


                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                </script>

                <div id="optionArea">
                    <form id="form1" action="" onsubmit="checkEndTime()">

                        <h4>时间：</h4>
                        <ul>
                            <li>
                                <input type="text" id="datepicker2" name="timeStart" class="form-control"/>
                                <script type="text/javascript">
                                    var picker = new Pikaday(
                                        {
                                            field: document.getElementById('datepicker2'),
                                            firstDay: 1,
                                            minDate: new Date('1995-01-01'),
                                            maxDate: new Date('2050-12-31'),
                                            yearRange: [1995, 2050]
                                        });
                                    $("#datepicker2").val("起始时间");
                                </script>
                            </li>
                            <li>
                                <span> 到</span>
                            </li>
                            <li>
                                <input type="text" id="datepicker" name="timeEnd" class="form-control"/>
                                <script type="text/javascript">
                                    var picker = new Pikaday(
                                        {
                                            field: document.getElementById('datepicker'),
                                            firstDay: 1,
                                            minDate: new Date('1995-01-01'),
                                            maxDate: new Date('2050-12-31'),
                                            yearRange: [1995, 2050]
                                        });
                                    $("#datepicker").val("结束时间");
                                </script>
                            </li>
                        </ul>

                        <input type="submit" class="btn btn-info analyButton btn-sm" value="分析"/>

                    </form>

                </div>
            </div>

            <div id="chart2">
                <h3>【专业】隐患分析柱状表</h3>
                <div id="main2"></div>
                <script type="text/javascript">
                    // 基于准备好的dom，初始化echarts实例
                    var myChart2 = echarts.init(document.getElementById('main2'));

                    var option2 = {
                        color: ['#3398DB'],
                        tooltip : {
                            trigger: 'axis',
                            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                            }
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis : [
                            {
                                type : 'category',
                                data: ['采煤', '开掘', '机电', '运输', '通风', '地测', '其他'],
                                axisTick: {
                                    alignWithLabel: true
                                }
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                name:'直接访问',
                                type:'bar',
                                barWidth: '60%',
                                data:[10, 52, 200, 334, 390, 330, 220]
                            }
                        ]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart2.setOption(option2);
                </script>

                <div id="optionArea2">

                    <form id="form2" action="">

                        <h4>时间：</h4>
                        <ul>
                            <li>
                                <input type="text" id="datepicker4" name="timeStart" class="form-control"/>
                                <script type="text/javascript">
                                    var picker = new Pikaday(
                                        {
                                            field: document.getElementById('datepicker4'),
                                            firstDay: 1,
                                            minDate: new Date('1995-01-01'),
                                            maxDate: new Date('2050-12-31'),
                                            yearRange: [1995, 2050]
                                        });
                                    $("#datepicker4").val("起始时间");
                                </script>
                            </li>
                            <li>
                                <span> 到</span>
                            </li>
                            <li>
                                <input type="text" id="datepicker5" name="timeEnd" class="form-control"/>
                                <script type="text/javascript">
                                    var picker = new Pikaday(
                                        {
                                            field: document.getElementById('datepicker5'),
                                            firstDay: 1,
                                            minDate: new Date('1995-01-01'),
                                            maxDate: new Date('2050-12-31'),
                                            yearRange: [1995, 2050]
                                        });
                                    $("#datepicker5").val("结束时间");
                                </script>
                            </li>
                        </ul>

                        <input type="submit" class="btn btn-info analyButton btn-sm" value="分析"/>

                    </form>


                    <form id="form22">
                        <span>选择环比时间单位：</span><br/>
                        <div id="form22TimeType" class="form22Div">
                            <label  class="btn btn-info">
                                <input type="Radio" value="月" name="timeType" class="timeType"/> 月
                            </label>
                            <label  class="btn btn-info">
                                <input type="Radio" value="年" name="timeType" class="timeType"/> 年
                            </label>
                        </div>

                        <span>输入时间间隔：</span>
                        <div id="form22timeInterval"  class="form22Div">
                            <input type="text" class="form-control"/>
                            &nbsp;&nbsp;<span id="timeUnit"></span>
                        </div>

                        <input type="" class="btn btn-success btn-sm analyButton" value="分析"/>
                    </form>

                    <script>
                        var tT = $("input[name='timeType']");

                        $(".timeType").click(function(){
                            tT.each(function () {
                                if($(this).prop("checked")){
                                    var timeValue = $(this).val();   //获取选择的单选按钮的值
                                    $("#timeUnit").text(timeValue)
                                }
                            })
                        })

                        /*比较两个日历的时间*/
                        function checkEndTime(){
                            var startTime=$("#datepicker2").val();
                            var start=new Date(startTime.replace(/-/g,"/"));
                            var endTime=$("#datepicker").val();
                            var end=new Date(endTime.replace(/-/g,"/"));
                            if(end<start){
                                alert('结束七日不能小于初始日期！');
                                return false;
                            } else{
                                return true;
                            }
                        }
                    </script>

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