package com.java.core.web.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.java.core.po.User;
import com.java.core.service.UserService;

/**
 * 用户控制器类
 */
@Controller
public class UserController {
	// 依赖注入
	@Autowired
	private UserService userService;

	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String usercode, String password, Model model, HttpSession session) {
		// 通过账号和密码查询用户
		User user = userService.findUser(usercode, password);
		if (user != null) {
			// 将用户对象添加到Session
			System.out.println("usercode=" + usercode + ",password=" + password);
			session.setAttribute("USER_SESSION", user);
			// 跳转到主页面
			// return "customer";
			System.out.println("用户" + usercode + "登录成功");
			return "redirect:customer/list.action";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
		// 返回到登录页面
		return "login";
	}

	/**
	 * 模拟其他类中跳转到客户管理页面的方法
	 */
	@RequestMapping(value = "/toCustomer.action")
	public String toCustomer() {
		return "customer";
	}

	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
		// 清除Session
		session.invalidate();
		// 重定向到登录页面的跳转方法
		return "redirect:login.action";
	}

	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/user/changepass.action")
	public String changePass(String new_user_name,String new_user_password, Model model, HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
//		System.out.println(user.getUser_name());
//		System.out.println(user.getUser_password());
//		System.out.println(new_user_name);
//		System.out.println(new_user_password);
		user.setUser_password(new_user_password);
		int rows=userService.updateUser(user);
		if (rows > 0) {
			System.out.println(user.getUser_code() + "修改了密码");
			return "OK";
		} else {
			return "FAIL";
		}
	}

}
