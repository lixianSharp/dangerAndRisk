/*$(document).ready(function() {
	//初始化检查单位
	initChechUnit();
	//初始化隐患类型
	initDangerType();
	//初始化隐患状态
	//initDangerStatus();
	//初始化班次
	initBanCi();
});*/
//初始化检查单位
function initChechUnit(){
	$.ajax({
		url:'initDic_initCheckUnit.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#fmchechunit option").remove();
			
			var str = "<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#fmchechunit").append(str);
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
			
			$("#dangerType option").remove();
			
			var str = "<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#dangerType").append(str);
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
			
			$("#fmchechunit option").remove();
			
			var str = "<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#fmchechunit").append(str);
		}
	});
}

//初始化班次
function initBanCi(){
	$.ajax({
		url:'initDic_initBanCi.action',
		data:'',
		dataType:'json',
		type:'POST',
		async:true,
		success:function(data){
			
			$("#className option").remove();
			
			var str = "<option value=''>--请选择--</option>";//<option value="安全小分组">安全小分组</option>
			for(var i=0;i<data.dictionaryList.length;i++){
				//str += data.dictionaryList[i].dictionary;
				//alert(data.dictionaryList[i].name)
				str +="<option value="+data.dictionaryList[i].name+">"+data.dictionaryList[i].name+"</option>";
			}
			$("#className").append(str);
		}
	});
}

$(function(){
	
   //初始化检查单位
	initChechUnit();
	//初始化隐患类型
	initDangerType();
	//初始化隐患状态
	//initDangerStatus();
	//初始化班次
	initBanCi(); 
	
	//初始化责任的单位的机构树
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
			$("#unit").val(treeNode.name);
			showLog3(treeNode.name);
		}
		$.fn.zTree.init($("#treeDemo2"), setting, zNodes);
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
		treeObj.expandAll(false);
	}
	
	function showLog3(str) {
		if (!log){
			log = $("#log");
		}
		/*清空内部的东西*/
		if ($("#log > li").length > 0) {
			$("#log").children("li").remove();
		}
		log.append("<li class='" + className + "'>" + str + "</li>");

		/*判断是否插入进入，若插入进入，关闭树框*/
		if ($("#log > li").length > 0) {
			$("#treeDemo2").hide();
		}

		//表单验证
		$("#addhdform").validate({
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
	}
	
	$("#treeDemo2").hide();
    $("#log").click(function () {
        $('#treeDemo2').toggle();
    })
});
