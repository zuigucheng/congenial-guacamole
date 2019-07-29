package com.xuzebiao.cms.forms;

import java.sql.Date;

/**
 * @author xuzebiao
 * 用户信息表单类
 *
 */
public class UserProfileForm extends UserForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//用户id
	private Integer id;
	
	//用户昵称
	private String nickname;
	
	//用户生日
	private Date birthday;
	
	
	//无参构造
	public UserProfileForm() {
		super();
	}

	
	/**
	 * 
	 * getter和setter方法
	 * 
	 * */
	public Integer getId() {
		return id;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	//重写tostring
	@Override
	public String toString() {
		return super.toString() + "UserProfileForm [id=" + id + ", nickname=" + nickname + ", birthday=" + birthday + "]";
	}


	

	/**
	 * 
	 * 重写 hashCode()和equals()
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfileForm other = (UserProfileForm) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}
	
	
}
