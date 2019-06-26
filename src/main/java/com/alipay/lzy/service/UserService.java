package com.alipay.lzy.service;

import com.alipay.lzy.entity.User;

public interface UserService {
//	用户注册
	void regist(User user);
//	用户登录
	User login(String userName, String password);
}
