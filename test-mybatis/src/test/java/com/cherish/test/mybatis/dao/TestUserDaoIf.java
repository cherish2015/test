package com.cherish.test.mybatis.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cherish.test.mybatis.po.User;

public class TestUserDaoIf {
	
	private static Logger log = LoggerFactory.getLogger(TestUserDaoIf.class);
	
	@Ignore
	@Test
	public void testGetUserIf(){
		UserDao ud = new UserDao();
		User user = ud.getUserByIf(10);
		log.debug(user+"\n--");
	}
	
	@Ignore
	@Test
	public void testGetAllUsersByIf(){
		UserDao ud = new UserDao();
		List<User> users = ud.getAllUsersByIf();
		log.debug(users.size()+"");
	}

}
