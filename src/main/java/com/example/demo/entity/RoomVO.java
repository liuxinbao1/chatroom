package com.example.demo.entity;

import com.example.demo.common.Base;
/**
 * 聊天室实体类.
 *
 * @author 刘新宝
 *
 */
public class RoomVO extends Base {

	/**
	 * id.
	 */
	private String id;

	/**
	 * 聊天室名称.
	 */
	private String name;
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
	
}
