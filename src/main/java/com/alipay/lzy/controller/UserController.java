package com.alipay.lzy.controller;

import com.alipay.lzy.entity.User;
import org.springframework.ui.Model;
import com.alipay.lzy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
@RequestMapping("/user")
public class UserController {
	
//	引入service
	@Resource
	private UserService userService;
	
/*
 * 页面的请求为user/*.do
*/

	@SuppressWarnings("unused")
	//	1，注册页面
	@RequestMapping("/regist")
//	注：方法必须是String类型
	public String regist(User user, Model model){
		
//		打印出 输入的用户信息
		System.out.println("注册： "+user.getUserName()+" "+user.getPassword()+" "+user.getAge());

//		用户名或密码为空的情况
/*		if(user == null){
			model.addAttribute("msg","请输入用户名和密码");
			return "regist";
		}*/
		if(user.getUserName()==null | user.getPassword()==null){
				model.addAttribute("msg","请输入用户名和密码");
				return "regist";
		}
		if(user.getUserName().equals("") | user.getPassword().equals("")){
			model.addAttribute("msg","用户名/密码有误,请重新注册");
			return "regist";
		}

//		注册,用户信息添加到数据库
		userService.regist(user);
//		注册完成的提示信息
		model.addAttribute("msg", "恭喜您,注册成功!");
//		注册完成,跳转到success.jsp
		return "success";

	}
	

//	2，登录页面
	@RequestMapping("/login")
//	参数为页面输入的用户信息
	public String login(String userName,String password,Model model){
//		打印出 输入的用户名和密码
		System.out.println("登录："+" "+userName+" "+password);
		
//		调用查询方法
		User user = userService.login(userName, password);
		
//		判断用户名和密码是否真实
		if(user == null){
			model.addAttribute("msg","用户名/密码有误,请重新登录");
			return "login";
		}
		
		
//		登录成功的提示信息
		model.addAttribute("msg", "恭喜您,成功登陆!");
//		跳转到登录成功页面success.jsp
		return "success";
	}	
	
}


/*
 * 注册：页面输入的用户信息放入数据库(SQL语句)
 * 登录：SQL语句中，把输入信息和数据库做对比，一致则登录
 * 注册完成跳转到“登录”页面，登录后跳转到“登录成功”页面
*/

/**
 * Controller控制层：
return 返回的是你的jsp文件的名字（包括你文件夹的名字）
	1比如 我返回 的是login 就会去webApp下去寻找login.jsp
	2如果返回的是"User/login"  会在webContext下找User包下面的login.jsp文件
	3如果是请求重定向的情况；return "redirect:/login";
 */