package com.lt.permission.dao;

import com.lt.permission.model.Function;

public interface FunctionDao {
	int deleteByPrimaryKey(String fid);

	int insert(Function record);

	int insertSelective(Function record);

	Function selectByPrimaryKey(String fid);

	int updateByPrimaryKeySelective(Function record);

	int updateByPrimaryKey(Function record);
}