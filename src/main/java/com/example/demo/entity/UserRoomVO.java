package com.example.demo.entity;

import com.example.demo.common.Base;

/**
 * 用户聊天室实体类.
 *
 * @author 刘新宝
 *
 */
public class UserRoomVO extends Base {

	/**
	 * 用户聊天室id.
	 */
	private String id;

	/**
	 * 用户id.
	 */
	private String userId;

	/**
	 * 聊天室id.
	 */
	private String roomId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "UserRoomVO [id=" + id + ", userId=" + userId + ", roomId=" + roomId + "]";
	}
	
}
