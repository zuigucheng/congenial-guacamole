package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.Comments;
import com.xuzebiao.cms.dao.CommentsMapper;
import com.xuzebiao.cms.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
