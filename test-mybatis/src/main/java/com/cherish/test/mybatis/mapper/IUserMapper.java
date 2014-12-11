package com.cherish.test.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.cherish.test.mybatis.po.User;

public interface IUserMapper {
	
	@Select("select * from users where id=#{id}")
	public User getUser(int id);
	
	@Select("select * from users")
	public List<User> getAllUsers();
	
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public void addUser(User user);

}
