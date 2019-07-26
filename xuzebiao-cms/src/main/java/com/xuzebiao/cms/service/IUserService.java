package com.xuzebiao.cms.service;

import com.xuzebiao.cms.domain.User;
import com.xuzebiao.cms.enums.Gender;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author xuzebiao
 * @since 2019-07-26
 */
public interface IUserService extends IService<User> {

	User register(String username, String password, Gender gender);

	User login(String username, String password);

}
