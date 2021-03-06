package com.example.demo.entity;

import com.example.demo.common.Base;

/**
 * 用户实体类.
 * @author 刘新宝
 *
 */
public class UserVO extends Base{

	/**
	 * 用户id.
	 */
	private String id;

	/**
	 * 用户名称.
	 */
	private String name;

	/**
	 * 用户密码.
	 */
	private String psswd;

	/**
	 * 管理员.
	 */
	private String admin;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsswd() {
		return psswd;
	}
	public void setPsswd(String passwd) {
		this.psswd = passwd;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", passwd=" + psswd + ", admin=" + admin + "]";
	}
	
}
