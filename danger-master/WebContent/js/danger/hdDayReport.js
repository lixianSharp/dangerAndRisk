//导出
function exportRiskList(){
	$.ajax({
		type : "post",
		dataType : "json",
		url : "${pageContext.request.contextPath}/export_exportDangerDayReport.action",
		data : {
			// 当前页页号 每页显示的记录数
			"findtime":$("#optsdate2").val()//发现日期
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