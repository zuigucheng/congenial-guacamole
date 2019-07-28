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

	//注册方法
	@Override
	public User register(String username, String password, Gender gender) {

		//声明空句柄,等待数据验证,注册成功后赋值对象并拷贝
		User reslut = null;
		//新建用户对象用于注册
		User user = new User();

		//断言验证各项数据是否为空
		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "密码不能为空");
		AssertUtil.assertNotNull(gender, "性别不能为空");

		//获取此用户名在数据库中存在数量
		int count = this.count(new QueryWrapper<User>().eq("username", username));

		//断言验证用户是否存在
		AssertUtil.assertTrue(count == 0, "用户名已存在");
		
		/**
		 * 
		 * 为对象属性赋值
		 * 
		 * */
		//姓名
		user.setUsername(username);

		//通过 用户名 + 加密盐 + 密码 并进行md5加密 进行密码赋值
		String base = username + Constant.SALT + password;
		user.setPassword(DigestUtils.md5DigestAsHex(base.getBytes()));

		//判断性别,如果为女士则赋值为1,如果为男士则赋值为0
		user.setGender(gender == Gender.FAMALE ? 1 : 0);
		
		user.setBirthday(null);
		user.setLocked(false);
		
		//设置昵称,默认为注册名
		user.setNickname(username);
		
		//设置创建时间为系统当前时间,首次更新时间与创建时间相同
		user.setCreated(new Timestamp(System.currentTimeMillis()));
		user.setUpdated(user.getCreated());

		/**
		 * 
		 * 保存对象
		 * 如保存成功,为句柄赋予对象并拷贝已有对象,排除密码属性
		 * 
		 * */
		if (this.save(user)) {
			reslut = new User();
			BeanUtils.copyProperties(user, reslut, "password");
		}

		return reslut;
	}

	//登录方法
	@Override
	public User login(String username, String password) {
		//声明空句柄,等待数据验证,注册成功后赋值对象并拷贝
		User reslut = null;

		//断言验证各项数据是否为空
		AssertUtil.assertHasLength(username, "用户名不能为空");
		AssertUtil.assertHasLength(password, "密码不能为空");

		//通过 用户名 + 加密盐 + 密码 进行md5解加密进行密码还原 
		String pass = DigestUtils.md5DigestAsHex((username + Constant.SALT + password).getBytes());

		//通过用户名,密码获取对象
		User user = this.getOne(new QueryWrapper<User>().eq("username", username).eq("password", pass));

		//断言判断用户是否存在
		AssertUtil.assertNotNull(user, "用户不存在");

		//断言通过,为句柄赋予对象并拷贝已有对象,排除密码属性
		reslut = new User();
		BeanUtils.copyProperties(user, reslut, "password");

		return reslut;
	}

	@Override
	public User getUnLockedUser(Integer id) {
		User result;
		
		User user = this.getOne(new QueryWrapper<User>().eq("id", id).eq("locked", 0));
		AssertUtil.assertNotNull(user, "该用户已锁定");
		
		result = new User();
		
		BeanUtils.copyProperties(user, result);
		return result;
	}

}
