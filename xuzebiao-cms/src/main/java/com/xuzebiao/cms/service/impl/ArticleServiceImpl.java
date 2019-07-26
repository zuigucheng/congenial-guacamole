package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.Article;
import com.xuzebiao.cms.dao.ArticleMapper;
import com.xuzebiao.cms.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
