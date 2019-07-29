package com.xuzebiao.cms.dao;

import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.vo.ArticleVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
public interface ArticleMapper extends BaseMapper<Article> {

	List<ArticleVo> listArticlesByUserId(Integer userId);

	List<ArticleVo> listArticlesByCateId(Integer categoryId);

	ArticleVo findArticleAuthorById(Integer articleId);

}
