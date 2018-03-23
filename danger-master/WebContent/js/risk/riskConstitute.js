
/*
 * 页面初始化
 */

$(function() {
	query();
	//myChart2()
});


function query() {
	
	$.ajax({
		url : 'constitute_getRiskCountByDisasterTypes.action',
		data : "",
		type : 'POST',
		dataType : 'json',
		async : true,
		success : successList,

	});

}

var successList = function List(result) {
	
	//得到数据
	var riskCounts = result.RiskCountList;
	
	$("#tbody").html("");// 清空表体
	// 获取到这个表格
	var t_body = $("#tbody");
	// 循环添加每一行
	var allCount =0;
	for (var i = 0; i < riskCounts.length; i++) {
		allCount =allCount+riskCounts[i].count;
	}
	for (var i = 0; i < riskCounts.length; i++) {
		
		var point =riskCounts[i].count/allCount
		
		var str=Number(point*100).toFixed(1);
	    str+="%";
	    /*
	     * 水
	     */
	    if(riskCounts[i].disasterTypes!="水"&&$("#shuiCountId").html()==""){
			
			$("#shuiCountId").html("0");
			$("#shuiScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="水"){
			$("#shuiCountId").html(riskCounts[i].count);
			$("#shuiScaleId").html(str);
			
		}
		
		if(riskCounts[i].disasterTypes!="火"&&$("#huoCountId").html()==""){
			
			$("#huoCountId").html("0");
			$("#huoScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="火"){
			$("#huoCountId").html(riskCounts[i].count);
			$("#huoScaleId").html(str);
		}
		
		if(riskCounts[i].disasterTypes!="瓦斯"&&$("#wasiCountId").html()==""){
			
			
			$("#wasiCountId").html("0");
			$("#wasiScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="瓦斯"){
			$("#wasiCountId").html(riskCounts[i].count);
			$("#wasiScaleId").html(str);
		}
		if(riskCounts[i].disasterTypes!="顶板"&&$("#dingbanCountId").html()==""){
			
			$("#dingbanCountId").html("0");
			$("#dingbanScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="顶板"){
			$("#dingbanCountId").html(riskCounts[i].count);
			$("#dingbanScaleId").html(str);
		}
		
		
		if(riskCounts[i].disasterTypes!="煤层"&&$("#meicengCountId").html()==""){
			$("#meicengCountId").html("0");
			$("#meicengScaleId").html("0%");
			
		}else if(riskCounts[i].disasterTypes=="煤层"){
			
			$("#meicengCountId").html(riskCounts[i].count);
			$("#meicengScaleId").html(str);
		}
		
		if(riskCounts[i].disasterTypes!="冲击地压" &&$("#diyaCountId").html()==""){
			
			$("#diyaCountId").html("0");
			$("#diyaScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="冲击地压"){
			$("#diyaCountId").html(riskCounts[i].count);
			$("#diyaScaleId").html(str);
		}
		
		if(riskCounts[i].disasterTypes!="提升运输" &&$("#yunshuCountId").html()==""){
			
			$("#yunshuCountId").html("0");
			$("#yunshuScaleId").html("0%");
		}else if(riskCounts[i].disasterTypes=="提升运输"){
			$("#yunshuCountId").html(riskCounts[i].count);
			$("#yunshuScaleId").html(str);
		}
		
		
		myChart(result);
		myChart1(result);
		
	}

}

function myChart(result){
	//得到数据
	var riskCounts = result.RiskCountList;
	var dataT=[];
	var dataTT="[";
	var shui=0,huo=0, wasi=0,dingban=0,meiceng=0,diya=0,yunshu=0;
	for (var i = 0; i < riskCounts.length; i++) {
 	   if(riskCounts[i].disasterTypes=="水"){
 		  dataT[i]="水";
 		 dataTT+="{value:shui,name:'水'},";
 		  shui=riskCounts[i].count;
 	   }
 	  if(riskCounts[i].disasterTypes=="火"){
 		 dataT[i]="火";
 		dataTT+="{value:huo,name:'火'},";
 		  huo=riskCounts[i].count;
 	   }
 	 if(riskCounts[i].disasterTypes=="瓦斯"){
 		dataTT+="{value:wasi,name:'瓦斯'},";
 		dataT[i]="瓦斯";
		  wasi=riskCounts[i].count;
	   }
 	 if(riskCounts[i].disasterTypes=="顶板"){
 		dataTT+="{value:dingban,name:'顶板'},";
 		dataT[i]="顶板";
 		dingban=riskCounts[i].count;
	   }
 	 if(riskCounts[i].disasterTypes=="煤尘"){
 		dataTT+="{value:meiceng,name:'煤尘'},";
 		dataT[i]="煤尘";
 		meiceng=riskCounts[i].count;
	   }
 	 if(riskCounts[i].disasterTypes=="冲击地压"){
 		dataTT+="{value:diya,name:'冲击地压'},";
 		dataT[i]="冲击地压";
 		diya=riskCounts[i].count;
	   }
 	 if(riskCounts[i].disasterTypes=="提升运输"){
 		dataTT+="{value:yunshu,name:'提升运输'},";
 		dataT[i]="提升运输 ";
 		yunshu=riskCounts[i].count;
	   }
    }
	dataTT+="]";
	
	
	  // 基于准备好的dom，初始化echarts实例
   var myChart = echarts.init(document.getElementById('riskType'));
	
    // 指定图表的配置项和数据
    var option = {
title : {
    text: '风险构成',
    x:'center'
},
tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
},
legend: {
    x : 'center',
    y : 'bottom',
    data:dataT
},
toolbox: {
    show : true,
    feature : {
        mark : {show: true},
        dataView : {show: true, readOnly: false},
        magicType : {
            show: true,
            type: ['pie', 'funnel']
        },
        restore : {show: true},
        saveAsImage : {show: true}
    }
},
calculable : true,
series : [

    {
        name:'风险构成',
        type:'pie',
        radius : [0, 100],//设置中心是否有空心圆
        center : ['50%', '50%'],
        /*roseType : 'area',*/
       selectedMode: 'single',
        /*data:[
            {value:10, name:'水'},
            {value:5, name:'火'},
            {value:15, name:'瓦斯'},
            {value:25, name:'顶板'},
            {value:20, name:'煤尘'},
            {value:35, name:'冲击地压'},
            {value:30, name:'提升运输'},
        ]*/
       
       
       data:eval("("+dataTT+")")
       
       
    }
]
};

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    
	
}
	function myChart1(result){
		debugger
		var address=result.addressList;
		var dataName=[];
		var dataNum=[];
		for(var i=0;i<address.length;i++){
			dataName[i]=address[i].riskAddress;
			dataNum[i]=address[i].count;
		}
	 // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('riskDep'));

    // 指定图表的配置项和数据
    var option1 = {
        title: {
            text: '失效风险地点分布情况',
        	left: 'center'
        },
         tooltip: {},//提示框 
       
        xAxis: {
//            data: ["总数量","3256工作面","32986工作面","458工作面","井口","洗煤机出口"]
        	data:dataName
        },
        yAxis: {},
        series: [{
            name: '失效风险地点',
            type: 'bar',
            data: dataNum
//        data: [9, 1, 1, 1, 2,4]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option1);
	}

