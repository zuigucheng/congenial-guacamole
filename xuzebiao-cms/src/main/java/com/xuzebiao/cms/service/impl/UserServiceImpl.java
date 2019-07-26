package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.User;
import com.xuzebiao.cms.dao.UserMapper;
import com.xuzebiao.cms.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
