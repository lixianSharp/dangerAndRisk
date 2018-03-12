$(document).ready(function() {
	
	searchDicTree();
	defaultSearch();

	
function defaultSearch () {	
	$.ajax({
		type : "post",
		dataType : "json",
		url : "searchDictionaryByCondition.action",
		data : {
			//dictionaryId : $("#dic_id").val(),
				"name" : $("#dic_name").val(),
				
				"currentPage":$("#currentPage").val(),
				"currentCount":$("#currentCount").val()
		},
		//data:$("#dictionaryForm").serialize(),
		success : showTable2,
		error : function() {
			
			alert("查找失败！");
		}
	});
}

	
	/**
	 * 请求树信息
	 */
	function searchDicTree() {
		$.ajax({
			type : "post",
			target : "#treeDemo",
			dataType : "json",
			url : "searchDTreeAction.action",
			success : getTree,
			error : function() {
				alert("请求树失败！");
			}
		});
	}
	
	/**
	 * 生成树
	 */
	function getTree(treeList2) {
		var treeList3 = eval("(" + treeList2 + ")");
		var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey: "dictionaryId",
						pIdKey: "upDictionaryId",
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
		var log, className = "dark";
		function onClick(event, treeId, treeNode, clickFlag) {
			clickOnTree(event, treeId, treeNode, clickFlag);
		}
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		var treeObj = $.fn.zTree.getZTreeObj("treeDemo");  
		treeObj.expandAll(false);
	}
	
	/**
	 * 点击树节点的同时，将该字典信息对应的字典编号，字典名称，上级字典编号，上级字典名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag) {
		//得到该节点的字典编号和字典名字
		document.getElementById("bt_dictionaryId").value = treeNode.dictionaryId;
		document.getElementById("bt_dictionaryName").value = treeNode.name;
		
		if (treeNode.dictionaryId == "10") {
			//如果本节点是根节点，那么就不能执行删除操作
			$("#dictionary_delete").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行删除操作
			$("#dictionary_delete").removeAttr("disabled");
			//父节点
			var fatherNode=treeNode.getParentNode();
			//得到父节点的字典编号和字典名称
			document.getElementById("bt_upDictionaryId").value = fatherNode.dictionaryId;
			
			document.getElementById("bt_upDictionaryName").value = fatherNode.name;
		}
		searchdic();
		//defaultSearch();
	}
	
	/**
	 *  点击一下树节点表格输出下级节点的字典信息
	 */
	function searchdic() {
		
			$("#currentPage").val("1")
		
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByUpId.action",
			data : {
				upDictionaryId : $("#bt_dictionaryId").val(),
				"currentPage":$("#currentPage").val(),
				"currentCount":$("#currentCount").val()
			},
			success : showTable2
		});
	}
	function searchdic2() {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByUpId.action",
			data : {
				upDictionaryId : $("#bt_dictionaryId").val(),
				"currentPage":$("#currentPage").val(),
				"currentCount":$("#currentCount").val()
			},
			success : showTable2
		});
	}
//分页


function fenye2(total, pageSize, pageNumber) {
	// alert(total+" "+pageSize)
	$('#paginationIDU').pagination(
			{
				// 组件属性
				"total" : total,// 数字 当分页建立时设置记录的总数量 1
				"pageSize" : pageSize,// 数字 每一页显示的数量 10
				"pageNumber" : pageNumber,// 数字 当分页建立时，显示的页数 1
				"pageList" : [10],// 数组 用户可以修改每一页的大小，
				// 功能
				"layout" : [ 'list', 'sep', 'first', 'prev', 'manual', 'next',
						'last', 'links' ],
				"onSelectPage" : function(pageNumber, b) {
				
					$("#currentPage").val(pageNumber);
					$("#currentCount").val(b);
					searchdic2();
				}
			});
}
	/**
	 * 点击查询按钮，按条件查询字典信息
	 *//*
	$("#condition_sub").click(function() {
		$("#currentPage").val("1")
		defaultSearch();
	});
	*/
	/**
	 * 显示表格
	 */

	
	function showTable2(result) {
		
		var beanList = result.pageBean.productList;
		
		// 清空表格  
		$("#dictionaryTable  tr:not(:first)").html("");
		var total = (result.pageBean.currentPage-1)*10;
		// 在表格中添加数据
		for (var i = 0; i < beanList.length; i++) {
			//var index = i + 1;
			var index = i + 1+total;
			var isUse;
			if(beanList[i].use==true) {
				isUse="启用";
			}else{
				isUse="禁用";
			}
			
			$("#tbody").append(
					/*"<tr><td>"+"<input type='checkbox' name='all'/>"+ "</td><td>"
					+ index+ "</td><td>"
					+ beanList[i].name+ "</td><td>"
					+ beanList[i].dictionaryId+ "</td><td>"
					+ beanList[i].upDictionaryId+ "</td><td>"
					+ isUse+ "</td><td>"
					+ beanList[i].description+ "</td><td>"
					+"<input type='hidden' class='mydictionaryId' value='"+beanList[i].dictionaryId+"'/>"
					//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a></td></tr>"
					+ "<a href='javaScript:void(0)' class='operation_delete'>删除</a></td></tr>"  
					//+"<a href='javaScript:void(0)' class='operation_delete'>删除</a></td></tr>"*/					
					
					"<tr><td>"
					+ index+ "</td><td>"
					+ beanList[i].name+ "</td><td>"
					/*+ beanList[i].dictionaryId+ "</td><td>"
					+ beanList[i].upDictionaryId+ "</td><td>"*/
					+ isUse+ "</td><td>"
					+ beanList[i].description+ "</td><td>"
					+"<input type='hidden' class='mydictionaryId' value='"+beanList[i].dictionaryId+"'/>"
					+"<input type='hidden' class='myupDictionaryId' value='"+beanList[i].upDictionaryId+"'/>"
					//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a></td></tr>"
					+ "<a href='javaScript:void(0)' class='operation_delete'>删除</a></td></tr>"  
					//+"<a href='javaScript:void(0)' class='operation_delete'>删除</a></td></tr>"
			);
			
			
		}
		
		
		fenye2(result.pageBean.totalCount, result.pageBean.currentCount,
				result.pageBean.currentPage);// 分页显示
	}
	
	/**
	 * 点击表格中的删除按钮按钮进行的操作，单行删除 
	 **/
	$("#dictionaryTable").on("click",".operation_delete",function() {
	
		var currentDicId = $(this).parent().find(".mydictionaryId").val();
		var upDictionaryId = $(this).parent().find(".myupDictionaryId").val();
		
		if(currentDicId=='10101'||upDictionaryId=='10101'){
			alert("该字典不允许删除")
		}else{
			
		
		if(confirm("是否确认删除？")){
			//var currentDicId = $(this).parent().siblings("td:eq(3)").text();mydictionaryId
			/*var currentDicId =$(".mydictionaryId").val();
			alert("currentDicId"+currentDicId);
			*/
			
			
			var $this = this;
			
			
			$.ajax({
				type : "post",
				dataType : "json",
				url : "deleteSingleDic.action",
				data : {
					"dictionaryIds" : currentDicId,
				},
				success : function(deleteSingleResult2) {
					
					
					if(deleteSingleResult2==1){
						
					
					alert("删除成功");
					searchDicTree();
					$($this).parent().parent().remove();
					$(".modal").modal("hide");
					}
					
					if(deleteSingleResult2==2){
						alert("该字典还有下级字典，不可以删除");
					}
					//window.location.reload();
				}
			});
			}
		}
	});
	

	
	/**
	 * 实现字典信息的删除 
	 */
	$("#dictionary_delete").click(function() {
		deletedic();
	});
	
	/**
	 * 得到要删除字典的编号（复选框选中的）
	 */
	function getDictionaryIdsChoosed(){
		var deleteIds = "";
		// 遍历选中的checkbox
		
		
		$("input[name='all']:checked").each(function() { 
			//得到删除的字典的编号
			/*var dingjiId = $(this).parents("tr").find(".mydictionaryId").val();
			if(dingjiId=="10"){
				alert("不可以删除顶级部门");
			}*/
		deleteIds += $(this).parents("tr").find(".mydictionaryId").val()+",";
		
			
			console.log("deleteIds: " + deleteIds);
		});
		deleteIds = deleteIds.substring(0, deleteIds.length-1);
		return deleteIds;
	}
	
	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deletedic(){
		var isChoosed = $("input[name='all']:checked").length > 0;
		if(!isChoosed){
			alert("选择字典后才能删除");
		}else{
			//得到要删除字典的编号
			var dictionaryIds = getDictionaryIdsChoosed();
			if(confirm("是否确定删除当前字典？")){
				//删除数据库中对应的字典的信息
				deleteDictionaryOfDatabase(dictionaryIds);
			}
		}
	}
	
	/**
	 * 删除数据库中的字典信息
	 */
	function deleteDictionaryOfDatabase(dictionaryIds) {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "deleteDictionaryAction.action",
			data : {
				dictionaryIds : dictionaryIds,
			},
			success : function(deleteResult) {
				if(deleteResult) {
					alert("删除成功");
					deleteDictionarysOfTable();
					searchDicTree();
				} else {
					alert("服务内部错误,删除失败!");
				}
			},
			error:function(){
				alert("删除失败！");
			}
		});
	}
	
	/**
	 * 批量删除表中选中的行
	 */
	function deleteDictionarysOfTable(){
		// 遍历选中的checkbox
		$("input[name='all']:checked").each(function() { 
			// 获取checkbox所在行的顺序
			index = $(this).parents("tr").index()+1;
			//删除表中选中的信息
			$("table#dictionaryTable").find("tr:eq("+index+")").remove();
		});
	}
	
	/**
	 * 判断是否选中树节点
	 */
	function isChoosed(){
		var choose = $("#bt_dictionaryId").val();
		if(""==choose || choose==null|| "null"==choose) {
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 *  添加按钮的实现 
	 */
	$('#dictionary_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择上级字典后才能添加");
			//隐藏模态框
			
			$("#dictionary_add").attr("data-target","");
			
		}else{
			
			if($("#bt_dictionaryId").val()=='10101'||$("#bt_upDictionaryId").val()=='10101'){
				alert("请不要添加隐患类型");
				$("#dictionary_add").attr("data-target","");
			}else{
				setModalOfAdd();
			}
		}
	});
	
	/**
	 *  此处是为了识别 按钮事件是添加还是修改 
	 */
	var isAdd = false;
	var isChange = false;
	
	/**
	 * 设置添加的弹出框 (上级字典编号，上级字典名称，要添加字典的编号)
	 */
	function setModalOfAdd(){
		/*alert($("#bt_dictionaryId").val())
		alert($("#bt_upDictionaryId").val())
		
		*/
		//设置模态框是属于增加还是更新
		isAdd = true;
		isChange = false;
		//弹出模态框
		$("#dictionary_add").attr("data-target","#dictionary_add_modal");
		
		//填充上级字典的值 （即当前点击的树节点,对于添加而言）
		var bt_uname = $("#bt_dictionaryName").val();
		$("#dap_add_name").val(bt_uname);
		var bt_uId = $("#bt_dictionaryId").val();
		$("#dap_add_id").val(bt_uId);
		
		//请求下一个添加的字典的编号Id
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchDicNextId.action",
			data : {
				upDictionaryId: $('#bt_dictionaryId').val(),
			},
			success : function(nextId) {
				//得到下一个添加的字典的编号Id
				$("#dictionary_id").val(nextId);
			}
		});	
		
	}
	
	/**
	 *  实现点击修改按钮的时候，弹出框的处理
	 */
	$("#dictionary_change").click(function() {
		var choose = isChoosed();
		if(choose){
			//从数据库查找数据添加到修改界面中
			setModalOfChange();
		}else{
			alert("选择字典后才能修改");
			$("#dictionary_change").attr("data-target","");//隐藏模态框
		}
	});
	
	/**
	 * 设置修改的弹出框 (上级字典编号，上级字典名称，要修改的字典的原始信息)
	 */
	function setModalOfChange(){
	
		isChange = true;
		isAdd = false;
		
		if($('#bt_upDictionaryId').val()=='10101'){
			alert("请不要修改该字典");
			$("#dictionary_change").attr("data-target","");
		}else{
			//弹出模态框
		$("#dictionary_change").attr("data-target","#dictionary_fix_modal");
		//请求要修改的字典的原始信息
		$.ajax({
			type : "post",
			datatype : "json",
			url : "getUpdateDictionary.action",
			data : {
				dictionaryId : $('#bt_dictionaryId').val(),
			},
			success : getInfoForChangeModal
		});
		}
	}
	
	/**
	 * 得到需要修改的字典的原始信息
	 */
	function getInfoForChangeModal(result){
		//设置启用和禁用
		if(result.use){
			$(".dic_isUse:first").attr("checked", true);
		}else{
			$(".dic_isUse:last").attr("checked", true);
		}
		//填充上级字典的信息
		var updicName = $("#bt_upDictionaryName").val();
		$("#upDicName").val(updicName);
		var updicId = $("#bt_upDictionaryId").val();
		$("#upDicId").val(updicId);
		
		//填充要修改的字典的信息
		$('#dict_id').val(result.dictionaryId);
		$('#dict_name').val(result.name);
		$('#dict_description').val(result.description);
	}
	
	/**
	 *  实现保存字典和修改字典 
	 */
	$('#dictionary_add_save').click(function() {
		if (isAdd) {
			//在表的末尾追加新增的机构信息
			//saveAddOfTable();
			//将新增的机构信息保存到数据库中
			
			
			var isNotNull = $("#addForm").validate({
				rules : {
					
					"dap_add_name" : {
						required : true
					},
					"dictionary_name" : {
						required : true
					},
				},
				messages : {

					"dap_add_name" : {
						required : "请输入上级字典名称"
					},
					"dictionary_name" : {
						required : "请输入字典名称",
						
					},
	
				}

			});
			
			if(isNotNull.form()){
				saveAddOfDatabase();
				
				
			}
			
		} 
	});
	$('#dictionary_update_save').click(function() {
	
		if(isChange){
			//将表中对应的那条修改的信息内容进行更新
			
			
			var isNotNull = $("#updateForm").validate({
				rules : {
					
					"dict_name" : {
						required : true
					},
					
				},
				messages : {
					"dict_name" : {
						required : "请输入字典名称"
					},
					
				}

			});
			if(isNotNull.form()){
				//将更新的信息保存到数据库中
				saveChangeOfDatabase();
				
			}
			
			saveChangeOfTable();
		}
	});
	
	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的字典信息
	 */
	function saveAddOfTable(){
		//找到要添加的机构信息在表中的序号
		//var index=parseFloat($("#dictionaryTable tr:last").find("td:first").text());
		var index = parseFloat($("#dictionaryTable tr:last").find("td:eq(1)").text());
		//追加到表的末尾
		$("#dictionaryTable").append(
				/*"<tr><td>"+"<input type='checkbox' name='all'/>"+ "</td><td>"
				+ (++index)+"</td><td>"
				+ $('#dictionary_name').val()+"</td><td>"
				+ $('#dictionary_id').val()+"</td><td>"
				+ $('#bt_dictionaryId').val()+"</td><td>"
				+ $("input[type='radio'][class='dictionary_isUse']:checked").val()+"</td><td>"
				+ $('#dictionary_description').val()+"</td><td>"
				//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"+ "</td></tr>"
				+ "<a href='javaScript:void(0)'  class='operation_delete'>删除</td></tr>"*/
				
				"<tr><td>"
				+ (++index)+"</td><td>"
				+ $('#dictionary_name').val()+"</td><td>"
				/*+ $('#dictionary_id').val()+"</td><td>"
				+ $('#bt_dictionaryId').val()+"</td><td>"*/
				+ $("input[type='radio'][class='dictionary_isUse']:checked").val()+"</td><td>"
				+ $('#dictionary_description').val()+"</td><td>"
				//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a>"+ "</td></tr>"
				+ "<a href='javaScript:void(0)'  class='operation_delete'>删除</td></tr>"
				
		
		);
	}
	
	/**
	 * 将新增的字典信息保存到数据库中
	 */
	function saveAddOfDatabase(){
		//alert($("input[type='radio'][class='dictionary_isUse']:checked").val()=="启用");
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addDictionaryAction.action",
			data : {
				dictionaryId : $('#dictionary_id').val(),
				name : $('#dictionary_name').val(),
				upDictionaryId : $('#bt_dictionaryId').val(),
				isUse : $("input[type='radio'][class='dictionary_isUse']:checked").val()=="启用",
				description : $('#dictionary_description').val(),
			},
			success : function(addResult) {
				alert("保存成功");
				$("#dictionary_name").val("");
				$(".dictionary_isUse").val("");
				$("#dictionary_description").val("");
				$(".modal").modal("hide");
				searchdic2();
				searchDicTree();
				//window.location.reload();
			},
			error : function(addResult) {
				alert("保存失败");
				$("#dictionary_name").val("");
				$(".dictionary_isUse").val("");
				$("#dictionary_description").val("");
			}
		});
	}
	
	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateDictionaryAction.action",
			data : {
				"dictionary.dictionaryId":$('#dict_id').val(),
				"dictionary.name":$('#dict_name').val(),
				"dictionary.isUse":$(":radio[name='dic_isUse'][class='dic_isUse']:checked").val()=="启用",
				"dictionary.description":$('#dict_description').val(),
			},
			success : function(updateResult) {
				alert("修改成功");
				searchDicTree();
				$(".modal").modal("hide");
				//window.location.reload();
			}
		});
	}
		
	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(){
		//找到修改的是第几行
		var index = getRowInTable(); 
		$("#dictionaryTable tr").eq(index).find("td").eq(2).text($('#dict_name').val()); 
		$("#dictionaryTable tr").eq(index).find("td").eq(5).text($('.dic_isUse').val()); 
		$("#dictionaryTable tr").eq(index).find("td").eq(6).text($('#dict_description').val());
	}
	
	/**
	 * 根据字典编号判断树对应字典与该字典对应的信息在表的哪一行
	 */
	function getRowInTable(){
		var index; 
		$("#dictionaryTable tr:gt(0)").each(function(i){
			//if($(this).children("td").eq(3).text()==$('#bt_dictionaryId').val()){
			if($("#mydictionaryId").val()==$('#bt_dictionaryId').val()){
				index = i;
			}
		});
		return index = index + 1;
	}
	
	//全选
    $("#all").click(function(){
		if(this.checked){				 //如果当前点击的多选框被选中
			 $('input[type=checkbox][name=all]').prop("checked", true );
		}else{								
		     $('input[type=checkbox][name=all]').prop("checked", false );
		}
	 });
    

});	
/**
	 * 点击查询按钮，按条件查询字典信息
	 */
	/*$("#condition_sub").click(function() {
		debugger;
		$("#currentPage").val("1")
		defaultSearch();
	});*/
    function defaultSearch2 () {
			
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchDictionaryByCondition.action",
			data : {
				//dictionaryId : $("#dic_id").val(),
					"name" : $("#dic_name").val(),
					
					"currentPage":$("#currentPage").val(),
					"currentCount":$("#currentCount").val()
			},
			//data:$("#dictionaryForm").serialize(),
			success : showTable,
			error : function() {
				
				alert("查找失败！");
			}
		});
	}
    

    function fenye(total, pageSize, pageNumber) {
    	// alert(total+" "+pageSize)
    	$('#paginationIDU').pagination(
    			{
    				// 组件属性
    				"total" : total,// 数字 当分页建立时设置记录的总数量 1
    				"pageSize" : pageSize,// 数字 每一页显示的数量 10
    				"pageNumber" : pageNumber,// 数字 当分页建立时，显示的页数 1
    				"pageList" : [10],// 数组 用户可以修改每一页的大小，
    				// 功能
    				"layout" : [ 'list', 'sep', 'first', 'prev', 'manual', 'next',
    						'last', 'links' ],
    				"onSelectPage" : function(pageNumber, b) {
    					$("#currentPage").val(pageNumber);
    					$("#currentCount").val(b);
    					defaultSearch2();
    				}
    			});
    }
    
	function showTable(result) {
		var beanList = result.pageBean.productList;
		// 清空表格  
		$("#dictionaryTable  tr:not(:first)").html("");
		var total = (result.pageBean.currentPage-1)*10;
		// 在表格中添加数据
		for (var i = 0; i < beanList.length; i++) {
			//var index = i + 1;
			var index = i + 1+total;
			var isUse;
			if(beanList[i].use==true) {
				isUse="启用";
			}else{
				isUse="禁用";
			}
			$("#tbody").append(
					/*"<tr><td>"+"<input type='checkbox' name='all'/>"+ "</td><td>"
					+ index+ "</td><td>"
					+ beanList[i].name+ "</td><td>"
					+ beanList[i].dictionaryId+ "</td><td>"
					+ beanList[i].upDictionaryId+ "</td><td>"
					+ isUse+ "</td><td>"
					+ beanList[i].description+ "</td><td>"
					+"<input type='hidden' class='mydictionaryId' value='"+beanList[i].dictionaryId+"'/>"
					//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a></td></tr>"  
					+ "<a href='javaScript:void(0)'  class='operation_delete'>删除</td></tr>"*/
					
					"<tr><td>"
					+ index+ "</td><td>"
					+ beanList[i].name+ "</td><td>"
					/*+ beanList[i].dictionaryId+ "</td><td>"
					+ beanList[i].upDictionaryId+ "</td><td>"*/
					+ isUse+ "</td><td>"
					+ beanList[i].description+ "</td><td>"
					+"<input type='hidden' class='mydictionaryId' value='"+beanList[i].dictionaryId+"'/>"
					//+ "<a href='javaScript:void(0)' class='operation_delete'  title='删除'><i class='glyphicon glyphicon-trash'></i></a></td></tr>"  
					+ "<a href='javaScript:void(0)'  class='operation_delete'>删除</td></tr>"
			);
			
			
		}
		
		
		fenye(result.pageBean.totalCount, result.pageBean.currentCount,
				result.pageBean.currentPage);// 分页显示
	}
	
function query(){
	$("#currentPage").val("1")
	defaultSearch2();
}

	