package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.Category;
import com.xuzebiao.cms.dao.CategoryMapper;
import com.xuzebiao.cms.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章分类表 服务实现类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
