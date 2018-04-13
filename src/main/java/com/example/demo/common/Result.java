package com.example.demo.common;

public class Result<E> {

	/**
	 * 空参数构造函数.
	 */
	public Result() {}

	/**
	 * 有参数的构造函数.
	 */
	public Result(String returnStatus, String returnMessage, E returnObj) {
		this.returnStatus = returnStatus;
		this.returnMessage = returnMessage;
		this.returnObj = returnObj;
	}
	/**
	 * 返回状态.
	 */
	private String returnStatus;

	/**
	 * 返回信息.
	 */
	private String returnMessage;

	/**
	 * 返回对象.
	 */
	private E returnObj;

	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	public String getReturnMessage() {
		return returnMessage;
	}
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}
	public E getReturnObj() {
		return returnObj;
	}
	public void setReturnObj(E returnObj) {
		this.returnObj = returnObj;
	}
	@Override
	public String toString() {
		return "Result [returnStatus=" + returnStatus + ", returnMessage=" + returnMessage + ", returnObj=" + returnObj
				+ "]";
	}
}
