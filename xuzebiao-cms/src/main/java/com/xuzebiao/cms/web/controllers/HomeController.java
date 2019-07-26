package com.xuzebiao.cms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * CMS首页控制器
 * @author 醉孤城
 *
 */

@Controller
public class HomeController {

	/**
	 * 
	 * 获得系统首页
	 * @return
	 *
	 */
	@GetMapping({"/","/index","/home"})
	public ModelAndView toHome() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
