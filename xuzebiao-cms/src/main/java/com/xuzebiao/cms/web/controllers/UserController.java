package com.xuzebiao.cms.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.common.utils.AssertUtil;
import com.xuzebiao.cms.domain.User;
import com.xuzebiao.cms.forms.UserForm;
import com.xuzebiao.cms.service.IUserService;
import com.xuzebiao.web.Constant;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

	//用户服务对象
	@Autowired
	private IUserService userService;

	@GetMapping("/reg")
	public ModelAndView toRegiest() {
		//跳转到注册页面
		ModelAndView mav = new ModelAndView("passport/reg");
		
		//绑定用户表单对象
		UserForm us = new UserForm();
		mav.addObject("userForm", us);
		
		return mav;
	}

	//接收用户表单对象验证并注册
	@PostMapping("/reg")
	public ModelAndView userRegist(@ModelAttribute("userForm") UserForm userForm) {
		ModelAndView mav = new ModelAndView();
		
		/**
		 * 
		 * 用户注册时进行断言检测
		 * 如断言抛出异常,将异常信息返回原页面并转回原页面
		 * 
		 * */
		try {
			
			//断言检测数据是否存在
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "密码不能为空");
			AssertUtil.assertTrue(userForm.getPassword().equals(userForm.getRePassword()), "两次密码输入不一致");
			AssertUtil.assertNotNull(userForm.getGender(), "性别不能为空");

			//提交用户名,密码,性别,进行注册
			userService.register(userForm.getUsername(), userForm.getPassword(), userForm.getGender());

			//登录成功后进行跳转入登陆界面,并传入用户姓名进行回显
			mav.setViewName("redirect:/user/login?username=" + userForm.getUsername());
		} catch (Exception e) {
			//返回错误信息
			mav.addObject("message", e.getMessage());
			//返回注册页面
			mav.setViewName("passport/reg");
		}

		return mav;
	}

	//登陆页面跳转
	@GetMapping("/login")
	public ModelAndView toLogin(@RequestParam(required = false) String username) {
		//跳转入登录页面
		ModelAndView mav = new ModelAndView("passport/login");

		//绑定表单对象,并传入注册成功后跳转转发来的用户姓名
		UserForm us = new UserForm();
		us.setUsername(username);

		mav.addObject("userForm", us);
		return mav;
	}
	
	//登陆验证,获取前台表单对象,并获取HttpSession对象
	@PostMapping("/login")
	public ModelAndView Login(@ModelAttribute("userForm") UserForm userForm,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		/**
		 * 
		 * 用户登录时进行断言检测
		 * 如断言抛出异常,将异常信息返回原页面并转回原页面
		 * 
		 * */
		try {
			
			//断言验证用户名密码是否为空
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "密码不能为空");
			
			//断言通过,将用户名密码传入服务层验证,并接受返回对象
			User user = userService.login(userForm.getUsername(), userForm.getPassword());
			
			//对返回对象进行非空断言检测
			AssertUtil.assertNotNull(user,"用户不存在");
			
			//断言通过则将对象信息存入session
			session.setAttribute(Constant.LOGIN_NAME, user);
			
			//返回用户主页
			mav.setViewName("user-space/home");
		} catch (Exception e) {
			//出现异常则返回异常信息
			mav.addObject("message", e.getMessage());
			//返回登陆页面
			mav.setViewName("passport/login");
		}
		
		return mav;
	}
}
