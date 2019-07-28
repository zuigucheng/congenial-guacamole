package com.xuzebiao.cms.service;

import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.vo.ArticleVo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
public interface IArticleService extends IService<Article> {

	List<ArticleVo> listArticleVoByUserId(Integer userId);

}
