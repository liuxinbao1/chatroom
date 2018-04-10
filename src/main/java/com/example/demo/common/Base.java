package com.example.demo.common;
/**
 * 实体类基础类.
 *
 * @author 刘新宝
 *
 */
public class Base {

	/**
	 * 创建人.
	 */
	private String createBy;

	/**
	 * 创建时间.
	 */
	private String createTime;

	/**
	 * 最后更新人.
	 */
	private String lastUpdateBy;

	/**
	 * 最后更新时间.
	 */
	private String lastUpdateTime;

	/**
	 * 状态.
	 */
	private String stauts;
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	@Override
	public String toString() {
		return "Base [createBy=" + createBy + ", createTime=" + createTime + ", lastUpdateBy=" + lastUpdateBy
				+ ", lastUpdateTime=" + lastUpdateTime + ", stauts=" + stauts + "]";
	}
	
}
