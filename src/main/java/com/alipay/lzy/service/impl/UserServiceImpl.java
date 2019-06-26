package com.alipay.lzy.service.impl;

import com.alipay.lzy.dao.UserDao;
import com.alipay.lzy.entity.User;
import com.alipay.lzy.service.UserService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

//"userService"是默认值,可以不写
@Service("userService")
public class UserServiceImpl implements UserService {

	//	调用dao接口
	@Resource
	private UserDao userDao;

	//	注册
	@Override
	public void regist(User user) {
		userDao.insert(user);
	}

	//	登录
	@Override
	public User login(String userName, String password) {
		return userDao.selectByNameAndPwd(userName, password);
	}

}
