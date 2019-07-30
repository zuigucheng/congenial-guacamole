package com.xuzebiao.cms.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.domain.Category;
import com.xuzebiao.cms.domain.Channel;
import com.xuzebiao.cms.service.IArticleService;
import com.xuzebiao.cms.service.ICategoryService;
import com.xuzebiao.cms.service.IChannelService;
import com.xuzebiao.web.Constant;

/**
 * 
 * CMS首页控制器
 * 
 * @author xuzebiao
 * @since 2017-07-26
 *
 */

@Controller
public class HomeController {

	@Autowired
	IChannelService channelService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IArticleService articleService;

	/**
	 * 获得系统首页
	 * 
	 * @return
	 *
	 */
	@GetMapping({ "/", "/index", "/home" })
	public ModelAndView toHome(@RequestParam(required = false, value = "channel") Integer channelId,
			@RequestParam(required = false, value = "category") Integer categoryId) {
		// 返回主页信息
		ModelAndView mav = new ModelAndView("home");
		
		List<Map<Channel, List<Category>>> list = new ArrayList<Map<Channel, List<Category>>>();
		List<Channel> channels = channelService.list();
		for (Channel channel : channels) {
			List<Category> categories = categoryService
					.list(new QueryWrapper<Category>().eq("channel_id", channel.getId()));
			Map<Channel, List<Category>> map = new HashMap<Channel, List<Category>>();
			map.put(channel, categories);
			list.add(map);
		}

		mav.addObject(Constant.CHANNELS_AND_CATEGORIES, list);

		if (channelId != null) {
			Channel channel = channelService.getById(channelId);
			mav.addObject("channel", channel);
		}
		
//		List<ArticleVo> lista = articleService.listArticlesByCateId(categoryId);
//		
//		mav.addObject("articles", lista);
		
		Page<Article> page = new Page<Article>(0, 10);
		List<Article> records = articleService.page(page, new QueryWrapper<Article>().orderByDesc("created"))
				.getRecords();
		mav.addObject("lastArticles", records);
		
		return mav;
	}
}
