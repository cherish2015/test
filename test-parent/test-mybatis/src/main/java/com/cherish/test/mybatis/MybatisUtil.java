package com.cherish.test.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MybatisUtil {
	
	private static Logger log = LoggerFactory.getLogger(MybatisUtil.class);
	
	private static SqlSessionFactory ssf = getSqlSessionFactoryInstance();
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if (ssf == null) {
			ssf = getSqlSessionFactoryInstance();
		}
		return ssf;
	}
	
	private static SqlSessionFactory getSqlSessionFactoryInstance(){
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("config/mybatis-conf.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(inputStream);
			return ssf;
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}
	
	public static void main(String[] args) {
		getSqlSessionFactory();
	}

}
