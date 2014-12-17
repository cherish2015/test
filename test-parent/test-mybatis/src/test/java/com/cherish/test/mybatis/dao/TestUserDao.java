package com.cherish.test.mybatis.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cherish.test.mybatis.po.User;

public class TestUserDao {
	
	private static Logger log = LoggerFactory.getLogger(TestUserDao.class);
	
	@Ignore
	@Test
	public void testGetUser(){
		UserDao ud = new UserDao();
		User user = ud.getUser(1);
		log.debug(user+"\n--end");
	}
	
	@Ignore
	@Test
	public void testGetAllUsers(){
		UserDao ud = new UserDao();
		List<User> users = ud.getAllUser();
		log.debug(users.size()+"");
	}
	
	@Ignore
	@Test
	public void testAddUser(){
		User user = new User("testAddUser", 20);
		UserDao ud = new UserDao();
		ud.addUser(user);
	}

}
