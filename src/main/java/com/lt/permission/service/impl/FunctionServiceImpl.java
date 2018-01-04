package com.lt.permission.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.permission.model.Function;
import com.lt.permission.service.IFunctionService;

@Service("functionService")
public class FunctionServiceImpl extends BaseServiceImpl implements
		IFunctionService {

	@Override
	public List<Function> findFunctionTrees(String uid) {
		// TODO Auto-generated method stub
		return null;
	}
}
