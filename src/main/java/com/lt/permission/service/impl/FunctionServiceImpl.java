package com.lt.permission.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lt.permission.dao.FunctionDao;
import com.lt.permission.model.Function;
import com.lt.permission.service.IFunctionService;

@Service("functionService")
public class FunctionServiceImpl extends BaseServiceImpl implements
		IFunctionService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	@Qualifier("functionDao")
	private FunctionDao functionDao;

	@Override
	public List<Function> findFunctionTrees(String uid) {
		List<Function> functionList = functionDao.findFunctionTrees();
		return functionList;
	}

	@Override
	public List<Function> findAllFunctionTrees() {
		List<Function> functionList = functionDao.findFunctionTrees();
		return functionList;
	}
}
