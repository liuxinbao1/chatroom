package com.example.demo.entity;

import com.example.demo.common.Base;

/**
 * 聊天记录.
 *
 * @author 刘新宝
 *
 */
public class ChatListVO extends Base {

	/**
	 * 聊天记录id.
	 */
	private String id;

	/**
	 * 聊天记录.
	 */
	private String value;

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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "ChatListVO [id=" + id + ", value=" + value + ", roomId=" + roomId + "]";
	}
	
}
