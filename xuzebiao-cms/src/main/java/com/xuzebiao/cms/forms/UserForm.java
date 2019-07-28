package com.xuzebiao.cms.forms;

import java.io.Serializable;

import com.xuzebiao.cms.enums.Gender;


/**
 * 
 * <p>
 * 前台表单信息
 * </p>
 * 
 * @author xuzebiao
 * @since 2019-07-27
 *
 *
 */

public class UserForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户姓名
	private String username;
	//用户密码
	private String password;
	//重复输入密码
	private String rePassword;
	//
	private String url;
	//性别
	private Gender gender;
	
	//无参构造
	public UserForm() {
		super();
	}

	/**
	 * 私有变量getter,setter
	 *
	 */
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public String getUrl() {
		return url;
	}

	public Gender getGender() {
		return gender;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	//重写toString用于信息展示
	@Override
	public String toString() {
		return "UserForm [username=" + username + ", password=" + password + ", rePassword=" + rePassword + ", url="
				+ url + ", gender=" + gender + "]";
	}

	
	/**
	 * 
	 * 重写 hashCode()和equals()
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rePassword == null) ? 0 : rePassword.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserForm other = (UserForm) obj;
		if (gender != other.gender)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rePassword == null) {
			if (other.rePassword != null)
				return false;
		} else if (!rePassword.equals(other.rePassword))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
