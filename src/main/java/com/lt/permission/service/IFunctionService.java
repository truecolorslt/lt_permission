package com.lt.permission.service;

import java.util.List;

import com.lt.permission.model.Function;

public interface IFunctionService {

	/**
	 * 查询用户具有的菜单
	 * 
	 * @param uid
	 * @return
	 */
	public List<Function> findFunctionTrees(String uid);

	/**
	 * 查询所有菜单
	 * 
	 * @return
	 */
	public List<Function> findAllFunctionTrees();
}
