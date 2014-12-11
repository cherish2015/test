package com.cherish.test.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.cherish.test.mybatis.mapper.IUserMapper;
import com.cherish.test.mybatis.po.User;

public class UserDao implements IMybatisDao {
	
	private static String sql = "com.cherish.test.mybatis.mapper.userMapper";
	
	public void addUser(User user){
		SqlSession ss = ssf.openSession(true);
		ss.insert(sql+".addUser", user);
		ss.close();
	}
	
	public User getUser(int id){
		SqlSession ss = ssf.openSession();
		User user = ss.selectOne(sql+".getUser", id);
		ss.close();
		return user;
	}
	
	public List<User> getAllUser(){
		SqlSession ss = ssf.openSession();
		List<User> users = ss.selectList(sql+".getAllUser");
		ss.close();
		return users;
	}
	
	public void addUserByIf(User user){
		SqlSession ss = ssf.openSession(true);
		IUserMapper mapper = ss.getMapper(IUserMapper.class);
		mapper.addUser(user);
		ss.close();
	}
	
	public User getUserByIf(int id){
		SqlSession ss = ssf.openSession();
		IUserMapper mapper = ss.getMapper(IUserMapper.class);
		return mapper.getUser(id);
	}
	
	public List<User> getAllUsersByIf(){
		SqlSession ss = ssf.openSession();
		IUserMapper mapper = ss.getMapper(IUserMapper.class);
		return mapper.getAllUsers();
	}
	
	public static void main(String[] args) {
		List<User> users = new UserDao().getAllUser();
		System.err.println(users);
		
		User user = new UserDao().getUser(1);
		System.err.println(user);
	}

}
