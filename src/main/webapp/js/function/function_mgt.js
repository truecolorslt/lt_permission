var setting = {
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
		showRenameBtn: false,
		removeTitle: "删除功能菜单"
	}
};

var treeNodes;

$(document).ready(function() {
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
});

var newCount = 1;
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