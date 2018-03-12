$(document).ready(function() {
	
	searchUnitTree();
	defaultSearch2();
	
	function defaultSearch2() {
		/*alert("0");
		alert($("#s_name").val());*/
		/*alert($("#s_id").val());
		alert($("#s_name").val());*/
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByCondition.action",
			/*data : {
				departmentId : $("#s_id").val(),
				name : $("#s_name").val()
			},*/
			data:$("#unitForm").serialize(),
			success : showTable,
			error : function() {
				alert("查找失败！");
			}
		});
	}
	
	/**
	 * 请求树信息
	 */
	function searchUnitTree(){
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
	function getTree(treeList2){
		var treeList3 = eval("(" + treeList2 + ")");
		var setting = {
				data : {
					simpleData : {
						enable : true,
						idKey: "departmentId",
						pIdKey: "upDepartmentId",
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
	 * 点击树节点的同时，将该机构信息对应的机构编号，机构名称，上级机构编号，上级机构名称保存下来
	 */
	function clickOnTree(event, treeId, treeNode, clickFlag) {
		//得到该节点的机构编号和机构名字
		document.getElementById("bt_unitId").value = treeNode.departmentId;
		document.getElementById("bt_unitName").value = treeNode.name;
		
		/*alert("当前选中的树的id"+treeNode.departmentId);
		alert("当前选中的树的名字"+treeNode.name);*/

		
		if (treeNode.departmentId == "10") {
			//如果本节点是根节点，那么就不能执行删除操作
			$("#unit_delete").attr("disabled","disabled");
		} else {
			//如果本节点不是根节点，就可以执行删除操作
			$("#unit_delete").removeAttr("disabled");
			//父节点
			var fatherNode=treeNode.getParentNode();
			
			/*alert(fatherNode.departmentId);
			alert(fatherNode.name);*/
			
			//得到父节点的机构编号和机构名称
			document.getElementById("bt_upUnitId").value = fatherNode.departmentId;
			document.getElementById("bt_upUnitName").value = fatherNode.name;
		}
	searchUnit();
		//defaultSearch();
	}

	/**
	 *  点击一下树节点表格输出下级节点的机构信息
	 */
	function searchUnit() {
		$("#currentPage").val("1")
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByUpId.action",
			data : {
				"upDepartmentId" : $("#bt_unitId").val(),
				"currentPage":$("#currentPage").val(),
				"currentCount":$("#currentCount").val()
			},
			success : showTable2
		});
	}
	function searchUnit2() {
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByUpId.action",
			data : {
				"upDepartmentId" : $("#bt_unitId").val(),
				"currentPage":$("#currentPage").val(),
				"currentCount":$("#currentCount").val()
			},
			success : showTable2
		});
	}
	
	/*$("#condition_sub").click(function() {
		$("#currentPage").val("1");
		defaultSearch();
	});*/
	
	
/******分页*******/
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
						
						searchUnit2();
					}
				});
	}
	

	/**
	 * 显示表格
	 */
	function showTable2(result) {
		
		var unitList = result.pageBean.productList;
		//var unitList = eval("(" + result + ")");
		// 清空表格  
		$("#unitTable  tr:not(:first)").html("");
		// 在表格中添加数据
	/*	for (var i = 0; i < unitList.length; i++) {
			var index = i + 1;
			$("#unitTable").append(
					"<tr><td>" + index+"</td><td>"
					+ unitList[i].departmentId + "</td><td>"
					+ unitList[i].name+ "</td><td>"
					+ unitList[i].upDepartmentId+ "</td><td>"
					+ unitList[i].manager+ "</td><td>"
					+ unitList[i].phone+ "</td></tr>"
			);
		}*/
		var total = (result.pageBean.currentPage-1)*10;
		for (var i = 0; i < unitList.length; i++) {
			
			
			var index = i + 1+total;
			$("#unitTable").append(
					"<tr><td>" + index+"</td><td>"
					/*+ unitList[i].departmentId + "</td><td>"*/
					/*+"<input type='hidden' id='departmentId' value='"+ unitList[i].departmentId + "'/>"
					+"<input type='hidden' id='upDepartmentId' value='"+ unitList[i].upDepartmentI + "'/></td><td>"*/
					+ unitList[i].name+ "</td><td>"
					/*+ unitList[i].upDepartmentId+ "</td><td>"*/
					+ unitList[i].manager+ "</td><td>"
					+ unitList[i].phone+ "</td></tr>"
					
			);
			

		}
		
		fenye2(result.pageBean.totalCount, result.pageBean.currentCount,
				result.pageBean.currentPage);// 分页显示
	}
		
	/**
	 * 实现机构信息的删除 
	 */
	$("#unit_delete").click(function() {
		deleteUnit();
	});

	/**
	 * 点击删除按钮后需要 删除表+删除数据库
	 */
	function deleteUnit(){
		var choose = isChoosed();
		if(!choose){
			alert("选择机构后才能删除");
		}else{
			if(confirm("是否确定删除当前机构？")){

				//找到删除的是第几行
				var index = getRowInTable(); 
				//简单的删除,要删除的表中的机构信息
				$("#unitTable tr").eq(index).remove();
				//删除数据库中的机构信息
				$.ajax({
					type : "post",
					dataType : "json",
					url : "deleteUnitAction.action",
					data : {
						departmentId : $("#bt_unitId").val(),
					},
					success : function() {
						alert("删除成功");
						searchUnitTree();
						
					},
					error:function(){
						alert("请确认该机构是否存在子机构！");
					}
				});
			}
		}
	}
		
	/**
	 * 判断是否选中树节点
	 */
	function isChoosed(){
		var choose = $("#bt_unitId").val();
		if(""==choose || choose==null|| "null"==choose){
			return false;
		}else{
			return true;
		}
	}
		
	/**
	 *  此处是为了识别 按钮事件是保存还是修改 
	 */
	var isAdd = false;
	var isChange = false;
	/**
	 *  添加按钮的实现 
	 */
	$('#unit_add').click(function() {
		var choose = isChoosed();
		if(!choose){
			alert("选择上级机构后才能添加");
			//隐藏模态框
			$("#unit_add").attr("data-target","");
		}else{
			//alert("我是添加");
			setModalOfAdd();
		}
	});
		
	/**
	 * 设置添加的弹出框 (上级机构编号，上级机构名称，要添加机构的编号)
	 */
	function setModalOfAdd(){
		//alert("我是添加"),
		
		//设置模态框是属于增加还是更新
		isAdd = true;
		isChange = false;
		//弹出模态框
		$("#unit_add").attr("data-target","#add_modal");
		
		//填充上级级机构的值 （即当前点击的树节点,对于添加而言）
		var bt_uname = $("#bt_unitName").val();
		$("#tdap_add_name").val(bt_uname);
		var bt_uId = $("#bt_unitId").val();
		$("#tdap_add_id").val(bt_uId);
		
		/*alert($('#bt_unitName').val());
		alert($('#bt_unitId').val());*/
		
		//请求下一个添加的机构的编号Id
		$.ajax({
			type : "post",
			datatype : "json",
			url : "searchNextUnitId.action",
			data : {
				upDepartmentId: $('#bt_unitId').val(),
			},
			success : function(nextId) {
				//得到下一个添加的机构的编号Id
				$("#unit__id").val(nextId);
			}
		});	
	}
		
	/**
	 *  实现点击修改按钮的时候，弹出框的处理
	 */
	$("#unit_change").click(function() {
		var choose = isChoosed();
		if(choose){
			//从数据库查找数据添加到修改界面中
			setModalOfChange();
		}else{
			alert("选择机构后才能修改");
			$("#unit_change").attr("data-target","");//隐藏模态框
		}
	});

	/**
	 * 设置修改的弹出框 (上级机构编号，上级机构名称，要修改的机构的原始信息)
	 */
	function setModalOfChange(){
		isChange = true;
		isAdd = false;
		//弹出模态框
		$("#unit_change").attr("data-target","#department_fix_modal");
		//请求要修改的字典的原始信息
		$.ajax({
			type : "post",
			datatype : "json",
			url : "getUpdateUnit.action",
			data : {
				departmentId : $('#bt_unitId').val(),
			},
			success : getInfoForChangeModal
		});
	}
		
	/**
	 * 得到需要修改的机构的原始信息
	 */
	function getInfoForChangeModal(result){
		//填充上级机构的信息
		var upUnitName = $("#bt_upUnitName").val();
		$("#xdap_add_name").val(upUnitName);
		var upUnitId = $("#bt_upUnitId").val();
		$("#xdap_add_id").val(upUnitId);
		
		//填充要修改的机构的信息
		$('#unit___id').val(result.departmentId);
		$('#unit___name').val(result.name);
		$('#unit___manager').val(result.manager);
		$('#unit___phone').val(result.phone);
		
		/*alert($('#bt_upUnitId').val());
		alert($('#bt_upUnitName').val());*/
		
	}

	/**
	 *  实现保存机构和修改机构 
	 */
	$('#tdapartm_add_save').click(function() {
		if (isAdd) {
			//在表的末尾追加新增的机构信息
			//aveAddOfTable();
	
			
			
			// 手机号码验证
			jQuery.validator
					.addMethod(
							"isMobile",
							function(value, element) {
								var length = value.length;
								var mobile = /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)/;
								var tel = /^\d{3,4}-?\d{7,9}$/;
								var tel2 = /^\d{7,9}$/;
								return this.optional(element) || (tel.test(value))
										|| (mobile.test(value)) || (tel2.test(value));

							}, "请正确填写您的联系电话");
			//验证
			var isNotNull = $("#addForm").validate({
				rules : {
					"unit__name" : {
						required : true

					},
					"unit__manager" : {
						required : true
					},
					"unit__phone" : {
						required : true,
						"isMobile" : true
					},
				},
				messages : {
					"unit__name" : {
						required : "请输入该机构的名称"
					},

					"unit__manager" : {
						required : "请输入上该机构的负责人"
					},
					"unit__phone" : {
						required : "请输入该机构的联系方式",
						"isMobile" : "请输入正确的联系电话"
					},
	
				}

			});
			
			
			
			//将新增的机构信息保存到数据库中
			
			if(isNotNull.form()){
			saveAddOfDatabase();
			}
		} 
	});
	$('#xdapartm_add_save').click(function() {
		if(isChange){
			
			// 手机号码验证
			jQuery.validator
					.addMethod(
							"isMobile",
							function(value, element) {
								var length = value.length;
								var mobile = /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\(\d{3}\))|(\d{3}\-))?(1[358]\d{9})$)/;
								var tel = /^\d{3,4}-?\d{7,9}$/;
								var tel2 = /^\d{7,9}$/;
								return this.optional(element) || (tel.test(value))
										|| (mobile.test(value)) || (tel2.test(value));

							}, "请正确填写您的联系电话");
			
			//验证
			var isNotNull = $("#updateForm").validate({
				rules : {
					
					"unit___name" : {
						required : true
					},
					"unit___manager" : {
						required : true
					},
					"unit___phone":{
						required:true,
						"isMobile" : true
					}
				},
				messages : {
					"unit___name" : {
						required : "请输入该机构的名称"
					},
					"unit___manager" : {
						required : "请输入该机构的负责人",
						
					},
					"unit___phone":{
						required:"请输入联系方式",
						"isMobile" : "请输入正确的联系电话"
					}
	
				}

			});
			
			
			
			/*alert("我是修改的保存");*/
			//将表中对应的那条修改的信息内容进行更新
			if(isNotNull.form()){
			saveChangeOfDatabase();
			}
			//将更新的信息保存到数据库中
			saveChangeOfTable();
			
		}
	});

	/**
	 * 如果是添加的保存的话，在表的末尾追加新增的机构信息
	 */
	function saveAddOfTable(){
		//找到要添加的机构信息在表中的序号
		var index=parseFloat($("#unitTable tr:last").find("td:first").text());
		//追加到表的末尾
		/*$("#unitTable").append(
				"<tr><td>"+(++index)+"</td><td>"
				+ $('#unit__id').val()+"</td><td>"
				+ $('#unit__name').val()+"</td><td>"
				+ $('#bt_unitId').val()+"</td><td>"
				+ $('#unit__manager').val()+"</td><td>"
				+ $('#unit__phone').val()+"</td></tr>"
		);*/
		$("#unitTable").append(
				"<tr><td>"+(++index)+"</td><td>"
				+ $('#unit__name').val()+"</td><td>"
				+ $('#unit__manager').val()+"</td><td>"
				+ $('#unit__phone').val()+"</td></tr>"
		);
		
	}

	/**
	 * 将新增的机构信息保存到数据库中
	 */
	function saveAddOfDatabase(){
		$.ajax({
			type : "post",
			dataType : "json",
			url : "addUnitAction.action",
			data : {
				name : $('#unit__name').val(),
				upDepartmentId : $('#bt_unitId').val(),
				manager : $('#unit__manager').val(),
				phone : $('#unit__phone').val(),
			},
			success : function(addResult) {
				alert("保存成功");
				$("#unit__name").val("");
				$("#unit__manager").val("");
				$("#unit__phone").val("");
				$(".modal").modal("hide");
				$("input[type=reset]").trigger("click");
				searchUnitTree();
				//window.location.reload();
			
				searchUnit2();
				
			},
			error : function(addResult) {
				alert(addResult)
				alert("保存失败");
				$("#unit__name").val("");
				$("#unit__manager").val("");
				$("#unit__phone").val("");
				$("input[type=reset]").trigger("click");
			}
		});
		
		
	}
		
	/**
	 * 将更新的信息保存到数据库中
	 */
	function saveChangeOfDatabase(){
		
		/*alert("更新数据到数据库");
		alert($('#unit___manager').val());*/
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "updateUnit.action",
			data : {
				"department.departmentId":$('#unit___id').val(),
				"department.name":$('#unit___name').val(),
				"department.manager":$('#unit___manager').val(),
				"department.phone":$('#unit___phone').val(),
			},
			success : function(updateResult) {
				alert("修改成功");
				searchUnitTree();
				searchUnit2();
				//window.location.reload();
				$(".modal").modal("hide");
			}
		});
	}
		
	/**
	 * 将表中对应的那条修改的信息内容进行更新
	 */
	function saveChangeOfTable(){
		//找到修改的是第几行
		var index = getRowInTable(); 
		/*$("#unitTable tr").eq(index).find("td").eq(2).text($('#unit___name').val()); 
		$("#unitTable tr").eq(index).find("td").eq(4).text($('#unit___manager').val()); 
		$("#unitTable tr").eq(index).find("td").eq(5).text($('#unit___phone').val());*/
		
		$("#unitTable tr").eq(index).find("td").eq(2).text($('#unit___name').val()); 
		$("#unitTable tr").eq(index).find("td").eq(3).text($('#unit___manager').val()); 
		$("#unitTable tr").eq(index).find("td").eq(4).text($('#unit___phone').val());
	}
	
	/**
	 * 根据机构编号判断树对应机构与该机构对应的信息在表的哪一行
	 */
	function getRowInTable(){
		var index; 
		$("#unitTable tr:gt(0)").each(function(i){
			if($(this).children("td").eq(1).text()==$('#bt_unitId').val()){
				index = i;
			}
		});
		return index = index + 1;
	}
	
})

	function defaultSearch() {
		/*alert("0");
		alert($("#s_name").val());*/
		/*alert($("#s_id").val());
		alert($("#s_name").val());*/
		
		$.ajax({
			type : "post",
			dataType : "json",
			url : "searchUnitByCondition.action",
			/*data : {
				departmentId : $("#s_id").val(),
				name : $("#s_name").val()
			},*/
			data:$("#unitForm").serialize(),
			success : showTable,
			error : function() {
				alert("查找失败！");
			}
		});
	}


/**
 * 显示表格
 */
function showTable(result) {
	
	var unitList = result.pageBean.productList;
	//var unitList = eval("(" + result + ")");
	// 清空表格  
	$("#unitTable  tr:not(:first)").html("");
	// 在表格中添加数据
/*	for (var i = 0; i < unitList.length; i++) {
		var index = i + 1;
		$("#unitTable").append(
				"<tr><td>" + index+"</td><td>"
				+ unitList[i].departmentId + "</td><td>"
				+ unitList[i].name+ "</td><td>"
				+ unitList[i].upDepartmentId+ "</td><td>"
				+ unitList[i].manager+ "</td><td>"
				+ unitList[i].phone+ "</td></tr>"
		);
	}*/
	var total = (result.pageBean.currentPage-1)*10;
	for (var i = 0; i < unitList.length; i++) {
		
		
		var index = i + 1+total;
		$("#unitTable").append(
				"<tr><td>" + index+"</td><td>"
				/*+ unitList[i].departmentId + "</td><td>"*/
				/*+"<input type='hidden' id='departmentId' value='"+ unitList[i].departmentId + "'/>"
				+"<input type='hidden' id='upDepartmentId' value='"+ unitList[i].upDepartmentI + "'/></td><td>"*/
				+ unitList[i].name+ "</td><td>"
				/*+ unitList[i].upDepartmentId+ "</td><td>"*/
				+ unitList[i].manager+ "</td><td>"
				+ unitList[i].phone+ "</td></tr>"
				
		);
		

	}
	
	
	
	fenye(result.pageBean.totalCount, result.pageBean.currentCount,
			result.pageBean.currentPage);// 分页显示
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
					
					defaultSearch();
				}
			});
}
/**
	 * 点击查询按钮，按条件查询机构信息
	 */
	function query() {
		
		$("#currentPage").val("1");
		defaultSearch();
	}