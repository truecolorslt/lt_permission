var setting;

var treeNodes;

$(document).ready(function() {
	initFunctionTrees();
});

/**
 * 初始化树形菜单
 */
function initFunctionTrees() {
	setting = {
		treeId : "function_tree",
		view : {
			addHoverDom : addHoverDom,
			removeHoverDom : removeHoverDom,
			selectedMulti : false
		},
		check : {
			enable : false
		},
		data : {
			simpleData : {
				enable : true,
				idKey : "id",
				pIdKey : "pId",
				rootPId : 0
			}
		},
		edit : {
			enable : true,
			showRenameBtn : false,
			removeTitle : "删除功能菜单"
		},
		callback : {
			onClick : getFunction,
			beforeClick : isRootNode
		}
	};

	$.ajax({
		async : false,
		type : 'POST',
		dataType : "json",
		url : "findFunctionTrees",// 请求的action路径
		error : function() {// 请求失败处理函数
			alert('树形菜单加载失败');
		},
		success : function(data) { // 请求成功后处理函数。
			treeNodes = data; // 把后台封装好的简单Json格式赋给treeNodes
		}
	});
	$.fn.zTree.init($("#functionTree"), setting, treeNodes);
}

function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='增加子功能菜单' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			$("#functionModalLabel").text("新增功能菜单");
			$('#functionModal').modal();
			return false;
		});
};
function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};

/**
 * 获取功能菜单详情
 * 
 * @param fid
 */
function getFunction(event, treeId, treeNode) {
	var pTreeNode = treeNode.getParentNode();
	var param = {
		fid : treeNode.id
	};

	$.ajax({
		async : false,
		type : 'POST',
		contentType : "application/json;charset=UTF-8",
		dataType : "json",
		url : "getFunction",// 请求的action路径
		data : JSON.stringify(param),
		error : function() {// 请求失败处理函数
			alert('获取[' + treeNode.name + ']功能菜单信息失败');
		},
		success : function(data) { // 请求成功后处理函数。
			$("#pFunctionName").html(pTreeNode.name);
			$("#fname").val(data.fname);
			$("#fcode").val(data.fcode);
			$("#fsort").val(data.fsort);
			$("#ficon").val(data.ficon);
			$("#furl").val(data.furl);
		}
	});
}

/**
 * 判断是否为根节点
 * 
 * @param treeId
 * @param treeNode
 * @param clickFlag
 */
function isRootNode(treeId, treeNode, clickFlag) {
	return treeNode.id != "0";
}