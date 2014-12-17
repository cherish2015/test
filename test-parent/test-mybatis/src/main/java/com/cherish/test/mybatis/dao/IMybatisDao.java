package com.cherish.test.mybatis.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import com.cherish.test.mybatis.MybatisUtil;

public interface IMybatisDao {
	
	/**
	 * get SqlSessionFactory
	 */
	SqlSessionFactory ssf = MybatisUtil.getSqlSessionFactory();
}
