package com.lt.permission.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.support.json.JSONUtils;
import com.lt.permission.service.IFunctionService;

/**
 * 功能菜单控制器
 * 
 * @author lantian
 * 
 */
@Controller
@RequestMapping("/function")
public class FunctionController extends BaseController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IFunctionService functionService;

	@RequestMapping(value = "/findFuntionTrees")
	@ResponseBody
	public String findFunctionTrees() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("F_ModuleId", "1");
		map.put("F_ParentId", "0");
		map.put("F_EnCode", "SysManage");
		map.put("F_FullName", "系统管理");
		map.put("F_Icon", "fa fa-desktop");
		map.put("F_UrlAddress", null);
		map.put("F_Target", "expand");
		map.put("F_IsMenu", 0);
		map.put("F_AllowExpand", 1);
		map.put("F_IsPublic", 0);
		map.put("F_AllowEdit", null);
		map.put("F_AllowDelete", null);
		map.put("F_SortCode", 1);
		map.put("F_DeleteMark", 0);
		map.put("F_EnabledMark", 1);
		map.put("F_Description", null);
		map.put("F_CreateDate", null);
		map.put("F_CreateUserId", null);
		map.put("F_CreateUserName", null);
		map.put("F_ModifyDate", "2015-11-17 11,22,46");
		map.put("F_ModifyUserId", "System");
		map.put("F_ModifyUserName", "超级管理员");
		return JSONUtils.toJSONString(map);
	}
}
