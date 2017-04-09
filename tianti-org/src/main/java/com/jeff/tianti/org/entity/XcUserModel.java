package com.jeff.tianti.org.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.jeff.tianti.common.entity.BaseEntity;

/**
 * <b>description</b>：微信用户信息表模型<br>
 * <b>time</b>：2017-04-09 18:56:46 <br>
 * <b>author</b>：  percy-chen@hotmail.com
 */
@Entity
@Table(name = "xc_user")
public class XcUserModel extends BaseEntity{

	/**
	* @Fields serialVersionUID
	*/
	private static final long serialVersionUID = 1L;
	
	 /*
	  * 
	  */
	private java.lang.String username;
	 /*
	  * 
	  */
	private java.lang.String mobile;
	 /*
	  *可用余额 
	  */
	private Double balance;
	 /*
	  * 
	  */
	private java.lang.Integer version;
	 /*
	  * 
	  */
	private Long addtime;
	 /*
	  * 
	  */
	private Long uptime;
	 /*
	  * 
	  */
	private java.lang.String weixin;
	 /*
	  *状态 0正常 1停用 
	  */
	private java.lang.Integer status;
	 /*
	  *冻结金额 
	  */
	private Double frozen;


	public java.lang.String getUsername() {
		return username;
	}

	public void setUsername(java.lang.String username) {
		this.username = username;
	}
	public java.lang.String getMobile() {
		return mobile;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
	public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}
	public Long getUptime() {
		return uptime;
	}

	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}
	public java.lang.String getWeixin() {
		return weixin;
	}

	public void setWeixin(java.lang.String weixin) {
		this.weixin = weixin;
	}
	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public Double getFrozen() {
		return frozen;
	}

	public void setFrozen(Double frozen) {
		this.frozen = frozen;
	}

}
