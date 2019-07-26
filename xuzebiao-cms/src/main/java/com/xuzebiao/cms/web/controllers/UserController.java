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

	@Autowired
	IUserService userService;

	@GetMapping("/reg")
	public ModelAndView toRegiest() {
		ModelAndView mav = new ModelAndView("passport/reg");
		UserForm us = new UserForm();
		mav.addObject("userForm", us);
		return mav;
	}

	@PostMapping("/reg")
	public ModelAndView userRegist(@ModelAttribute("userForm") UserForm userForm) {
		ModelAndView mav = new ModelAndView();
		System.out.println(userForm.toString());
		try {
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "密码不能为空");
			AssertUtil.assertTrue(userForm.getPassword().equals(userForm.getRePassword()), "两次密码输入不一致");
			AssertUtil.assertNotNull(userForm.getGender(), "性别不能为空");

			userService.register(userForm.getUsername(), userForm.getPassword(), userForm.getGender());

			mav.setViewName("redirect:/user/login?username=" + userForm.getUsername());
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("passport/reg");
		}

		return mav;
	}

	@GetMapping("/login")
	public ModelAndView toLogin(@RequestParam(required = false) String username) {
		ModelAndView mav = new ModelAndView("passport/login");

		UserForm us = new UserForm();
		us.setUsername(username);

		mav.addObject("userForm", us);
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView Login(@ModelAttribute("userForm") UserForm userForm,
			HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		try {
			AssertUtil.assertHasLength(userForm.getUsername(), "用户名不能为空");
			AssertUtil.assertHasLength(userForm.getPassword(), "密码不能为空");
			
			User user = userService.login(userForm.getUsername(), userForm.getPassword());
			
			AssertUtil.assertNotNull(user,"用户不存在");
			
			session.setAttribute(Constant.LOGIN_NAME, user);
			
			mav.setViewName("user-space/home");
		} catch (Exception e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("passport/login");
		}
		
		return mav;
	}
}
