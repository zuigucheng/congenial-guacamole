package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.dao.ArticleMapper;
import com.xuzebiao.cms.service.IArticleService;
import com.xuzebiao.cms.vo.ArticleVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawei.common.utils.AssertUtil;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

	@Override
	public List<ArticleVo> listArticleVoByUserId(Integer userId) {
		
		AssertUtil.assertNotNull(userId,"用户id不能为空");
		List<ArticleVo> list = baseMapper.listArticlesByUserId(userId);
		
		return list;
	}

	@Override
	public List<ArticleVo> listArticlesByCateId(Integer categoryId) {
		
		AssertUtil.assertNotNull(categoryId,"类别id不能为空");
		return baseMapper.listArticlesByCateId(categoryId);
	}

	@Override
	public ArticleVo findArticleAuthorById(Integer articleId) {
		
		AssertUtil.assertNotNull(articleId,"文章id不能为空");
		return baseMapper.findArticleAuthorById(articleId);
	}

	@Override
	public ArticleVo findArticleById(Integer articleId) {
		return baseMapper.findArticleById(articleId);
	}

}
