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

	//注册方法
	User register(String username, String password, Gender gender);

	//登录方法
	User login(String username, String password);

	User getUnLockedUser(Integer id);

}
