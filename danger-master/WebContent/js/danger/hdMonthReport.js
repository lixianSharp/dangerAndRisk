$(document).ready(function() {
	//初始化检查单位
	initChechUnit();

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




//===初始化责任单位的树=======
//导出
function exportRiskList(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/export_exportDangerMonthReport.action",
		data : {
			// 当前页页号 每页显示的记录数
			"startTime":$("#optsdate2").val(),//起始时间
			"endTime":$("#optsdate22").val(),//结束时间
			"unit":$("#unitId").val(),//责任单位
			"checkunit":$("#checkUnitId").val()//检查单位
			
			
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