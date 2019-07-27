package com.xuzebiao.cms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * CMS首页控制器
 * @author xuzebiao
 * @since 2017-07-26
 *
 */

@Controller
public class HomeController {

	/**
	 * 获得系统首页
	 * @return 
	 *
	 */
	@GetMapping({"/","/index","/home"})
	public ModelAndView toHome() {
		//返回主页信息
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
