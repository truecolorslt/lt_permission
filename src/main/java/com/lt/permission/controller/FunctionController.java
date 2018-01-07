package com.lt.permission.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.permission.model.Function;
import com.lt.permission.service.IFunctionService;
import com.lt.permission.util.JsonUtils;

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

	@RequestMapping(value = "/findUserFunctionTrees")
	@ResponseBody
	public String findUserFunctionTrees() {
		String treesJson = "";
		try {
			List<Function> functionList = functionService
					.findFunctionTrees(null);
			List<Map<String, Object>> mapList = null;
			if (functionList != null && functionList.size() > 0) {
				mapList = new ArrayList<Map<String, Object>>();
				for (Function f : functionList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("F_ModuleId", f.getFid());
					map.put("F_ParentId", f.getPfid());
					map.put("F_EnCode", f.getFcode());
					map.put("F_FullName", f.getFname());
					map.put("F_Icon", f.getFicon());
					map.put("F_UrlAddress", f.getFurl());
					// map.put("F_Target", "expand");
					// map.put("F_IsMenu", 0);
					// map.put("F_AllowExpand", 1);
					// map.put("F_IsPublic", 0);
					// map.put("F_AllowEdit", null);
					// map.put("F_AllowDelete", null);
					// map.put("F_SortCode", 1);
					// map.put("F_DeleteMark", 0);
					// map.put("F_EnabledMark", 1);
					// map.put("F_Description", null);
					// map.put("F_CreateDate", null);
					// map.put("F_CreateUserId", null);
					// map.put("F_CreateUserName", null);
					// map.put("F_ModifyDate", "2015-11-17 11,22,46");
					// map.put("F_ModifyUserId", "System");
					// map.put("F_ModifyUserName", "超级管理员");
					mapList.add(map);
				}
				treesJson = this.toJSONArray(mapList).toString();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return treesJson;
	}

	@RequestMapping(value = "/findFunctionTrees")
	@ResponseBody
	public String findFunctionTrees() {
		String treesJson = "";
		try {
			List<Function> functionList = functionService
					.findFunctionTrees(null);
			List<Map<String, Object>> mapList = null;
			if (functionList != null && functionList.size() > 0) {
				mapList = new ArrayList<Map<String, Object>>();
				Map<String, Object> rootMap = new HashMap<String, Object>();
				rootMap.put("id", "0");
				rootMap.put("pId", null);
				rootMap.put("name", "管理系统");
				rootMap.put("open", true);
				mapList.add(rootMap);

				for (Function f : functionList) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("id", f.getFid());
					map.put("pId", f.getPfid());
					map.put("name", f.getFname());
					if ("0".equals(f.getPfid())) {
						map.put("open", true);
					}
					mapList.add(map);
				}
				treesJson = this.toJSONArray(mapList).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treesJson;
	}

	/**
	 * 进入功能菜单管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/functionMgt")
	public String functionMgt() {
		return "/function/function_mgt";
	}
}
