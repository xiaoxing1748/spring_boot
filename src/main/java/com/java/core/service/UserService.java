package com.java.core.service;

import com.java.core.po.User;

/**
 * 用户Service层接口
 */
public interface UserService {
	// 通过账号和密码查询用户
	public User findUser(String usercode, String password);
	//更新用户
	public int updateUser(User user);
}
