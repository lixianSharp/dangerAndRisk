$(document).ready(function() {
	//初始化检查单位
	initChechUnit();
	//初始化隐患类型
	initDangerType();
	//初始化隐患状态
	initDangerStatus();
	//初始化班次
	initBanCi();
	
	//初始化检查单位  修改
	initChechUnitUpdate();
	//初始化隐患类型 修改
	initDangerTypeUpdate();
	
});
//初始化检查单位
function initChechUnit(){
	$.ajax({
		url:'initDic_initCheckUnit.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#checkUnitId option").remove();
			
			var str = "<option value='0'>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#checkUnitId").append(str);
			//当点击查询按钮的时候，回显下拉框中的值
			var typevalue= $("#checkunitValue").val();
			$("#checkUnitId option[value='"+typevalue+"']").attr("selected","selected");
		}
	});
}

//初始化隐患类型
function initDangerType(){
	$.ajax({
		url:'initDic_initDangerType.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#findDangerType option").remove();
			
			var str = "<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#findDangerType").append(str);
			//当点击查询按钮的时候，回显下拉框中的值
			var typevalue= $("#typeValue").val();
			$("#findDangerType option[value='"+typevalue+"']").attr("selected","selected");
		}
	});
}

//初始化隐患状态
function initDangerStatus(){
	$.ajax({
		url:'initDic_initDangerStatus.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#dangerStatus option").remove();
			
			var str = "<option value=''>--请选择--</option>";//"<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#dangerStatus").append(str);
			//当点击查询按钮的时候，回显下拉框中的值
			var typevalue= $("#dangerstatusValue").val();
			$("#dangerStatus option[value='"+typevalue+"']").attr("selected","selected");
		}
	});
}




//初始化修改的模态框中的下拉列表

//初始化班次  修改
function initBanCi(){
	$.ajax({
		url:'initDic_initBanCi.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#upclasstype option").remove();
			
			var str = "<option value='0'>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#upclasstype").append(str);
		}
	});
}

//初始化检查单位  修改
//初始化检查单位
function initChechUnitUpdate(){
	$.ajax({
		url:'initDic_initCheckUnit.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#upcheckunit option").remove();
			
			var str = "<option value='0'>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#upcheckunit").append(str);
		}
	});
}


//初始化隐患类型  修改
function initDangerTypeUpdate(){
	$.ajax({
		url:'initDic_initDangerType.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#updangertype option").remove();
			
			var str = "<option>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#updangertype").append(str);
		}
	});
}



//修改模态框中的责任单位树start
var setting4 = {
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

    var code, log4, className = "dark";

    function onCheck(e, treeId, treeNode) {
    	$("#upnuit").val(treeNode.name);
        showLog4(treeNode.name);
    }

    function showLog4(str) {
        if (!log4) log4 = $("#log4");
        /*清空内部的东西*/
        if ($("#log4 > li").length > 0) {
            $("#log4").children("li").remove();
        }
        log4.append("<li class='" + className + "'>" + str + "</li>");

        /*判断是否插入进入，若插入进入，关闭树框*/
        if ($("#log4 > li").length > 0) {
            $("#treeDemo4").hide();
        }
    }

    function checkNode(e) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo4"),
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
    	console.log(zNodes);
        $.fn.zTree.init($("#treeDemo4"), setting4, zNodes);
        $("#checkTrue").bind("click", {type: "checkTrue"}, checkNode);
        $("#checkFalse").bind("click", {type: "checkFalse"}, checkNode);

        $("#treeDemo4").hide();
        $("#log4").click(function () {
            $('#treeDemo4').toggle();
        })
    });
//修改的模态框中的责任单位树 end
//===初始化责任单位的树=======

    
    
    
 //导出
function exportRiskList(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/export_exportDangerFind.action",
		data : {
			// 当前页页号 每页显示的记录数
			"checkunit":$("#checkUnitId").val(),//检查单位
			"findtime":$("#optsdate2").val(),//发现日期
			"unit":$("#unitId").val(),//责任单位
			"address":$("#dangerAddress").val(),//地点
			"content":$("#findDangerContent").val(),//隐患内容
			"dangergrade":$("#dangerLevel").val(),//隐患级别
			"type":$("#findDangerType").val(),//隐患类型
			"dangerstatus":$("#dangerStatus").val()//隐患状态
			
		// 每页显示的记录数
		},
		success:function(data){
			//返回文件名
			$("#exportFileNameHidden").val(data.fileNameExcel);
			//为导出的a标签的href属性赋值
			$("#exportATag").attr("href", "${pageContext.request.contextPath}/export_down.action?name="+$("#exportFileNameHidden").val());
		}
	});
	
	//打开模态框
	$("#deleteDuty").modal();
	
}

//点击确定导出按钮之后 将模态框关闭
function clickCloseModal(){
	$("#deleteDuty").modal("hide");
}