package com.xuzebiao.cms.service.impl;

import com.xuzebiao.cms.domain.User;
import com.xuzebiao.cms.enums.Gender;
import com.xuzebiao.cms.dao.UserMapper;
import com.xuzebiao.cms.service.IUserService;
import com.xuzebiao.web.Constant;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bawei.common.utils.AssertUtil;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

	@Override
	public User register(String username, String password, Gender gender) {

		User reslut = null;
		User user = new User();

		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "密码不能为空");
		AssertUtil.assertNotNull(gender, "性别不能为空");

		int count = this.count(new QueryWrapper<User>().eq("username", username));

		AssertUtil.assertTrue(count == 0, "用户名已存在");
		user.setUsername(username);

		String base = username + Constant.SALT + password;
		user.setPassword(DigestUtils.md5DigestAsHex(base.getBytes()));

		user.setGender(gender == Gender.FAMALE ? 1 : 0);
		user.setBirthday(null);
		user.setLocked(false);
		user.setNickname(username);
		user.setCreated(new Timestamp(System.currentTimeMillis()));
		user.setUpdated(user.getCreated());

		if (this.save(user)) {
			reslut = new User();
			BeanUtils.copyProperties(user, reslut, "password");
		}

		return reslut;
	}

	@Override
	public User login(String username, String password) {
		User reslut = null;

		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "密码不能为空");

		String pass = DigestUtils.md5DigestAsHex((username + Constant.SALT + password).getBytes());

		User user = this.getOne(new QueryWrapper<User>().eq("username", username).eq("password", pass));

		AssertUtil.assertNotNull(user, "用户不存在");

		reslut = new User();
		BeanUtils.copyProperties(user, reslut, "password");

		return reslut;
	}

}
