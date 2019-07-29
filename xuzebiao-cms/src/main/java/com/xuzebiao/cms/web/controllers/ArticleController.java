package com.xuzebiao.cms.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bawei.common.utils.AssertUtil;
import com.bawei.common.utils.AssertionException;
import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.domain.Category;
import com.xuzebiao.cms.domain.Comments;
import com.xuzebiao.cms.domain.User;
import com.xuzebiao.cms.forms.BlogForm;
import com.xuzebiao.cms.service.IArticleService;
import com.xuzebiao.cms.service.ICategoryService;
import com.xuzebiao.cms.vo.ArticleVo;
import com.xuzebiao.web.Constant;

import java.io.File;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IArticleService articleService;

	//跳转到文章编译页面
	@GetMapping("edit")
	public ModelAndView toEditArticle() {
		ModelAndView mav = new ModelAndView("user-space/blog_edit");

		//新建blog表单对象
		BlogForm blog = new BlogForm();

		//获取所有栏目列表
		List<Category> list = categoryService.list();

		//返回对象
		mav.addObject("blog", blog);
		mav.addObject(Constant.CATEGORIES, list);

		return mav;
	}

	/**
	 * 
	 *  添加修改方法
	 *  @param blog 表单对象
	 *  	   file 上传文件
	 *  	   session 会话对象,用于获取对象
	 *         request 用于获取服务器地址
	 *      
	 *  添加记录并保存上传文件
	 * 
	 * */
	@PostMapping("edit")
	public ModelAndView editArticle(@ModelAttribute("blog") BlogForm blog, MultipartFile file, HttpSession session,
			HttpServletRequest request) {

		//获取对象
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		ModelAndView mav = new ModelAndView("redirect:/article/list?userId=" + user.getId());
		try {
			
			//断言验证
			AssertUtil.assertHasLength(blog.getTitle(), "标题不能为空");
			AssertUtil.assertHasLength(blog.getContent(), "内容不能为空");
			AssertUtil.assertNotNull(blog.getCategory(), "栏目不能为空");

			System.out.println(blog.getTitle());
			//新建对象并赋值
			Article article = new Article();

			article.setId(null);
			article.setTitle(blog.getTitle());
			article.setContent(blog.getContent());
			article.setCategoryId(blog.getCategory().getId());
			article.setChannelId(0);
			article.setSummary(blog.getSummary());
			article.setUserId(user.getId());
			article.setCreated(new Timestamp(System.currentTimeMillis()));
			article.setUpdated(article.getCreated());

			
			//上传对象
			if (file.getSize() != 0) {
				// 获得当前应用部署在服务器上的根路径，它是一个文件系统绝对路径
				String picRealDir = request.getServletContext().getRealPath("/") + Constant.UPLOAD_DIR;
				// 上传工作
				String fileOriginalName = file.getOriginalFilename();
				String fileSuffix = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
				String newFileName = "" + System.currentTimeMillis() + (Math.random() * 1000 + 1) + fileSuffix;

				file.transferTo(new File(picRealDir + "/" + newFileName));

				article.setPicture(Constant.UPLOAD_DIR + "/" + newFileName);
			}
			
			//保存数据库
			boolean result = articleService.saveOrUpdate(article);
			
			//验证是否成功
			AssertUtil.assertTrue(result, "文章保存失败");
			
			//保存失败异常
		} catch (AssertionException e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("user-space/blog_edit");
			
			//文件上传异常
		} catch (Exception e) {
			mav.addObject("message", "文件上传失败");
			mav.setViewName("user-space/blog_edit");
		}

		return mav;
	}
	
	//展示列表页面
	@GetMapping("list")
	public ModelAndView toShowList(@ModelAttribute("userId") Integer userId) {
		ModelAndView mav = new ModelAndView("user-space/blog_list");
		
		//通过用户id获取博客列表
		List<ArticleVo> blogs = articleService.listArticleVoByUserId(userId);
		mav.addObject("blogs",blogs);
		
		return mav;
	}
	
	@GetMapping("/{articleId}")
	public ModelAndView toShowArticle(@PathVariable("articleId") Integer articleId) {
		ModelAndView mav = new ModelAndView("blog");
		Article blog = articleService.findArticleAuthorById(articleId);
		
		Comments comments = null;
		Article hotBlogs = null;
		
		mav.addObject("blog",blog);
		mav.addObject("comments",comments);
		mav.addObject("hotBlogs",hotBlogs);
		
		return mav;
	}
}
