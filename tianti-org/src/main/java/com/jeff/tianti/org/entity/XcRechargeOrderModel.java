package com.jeff.tianti.org.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jeff.tianti.common.entity.BaseEntity;

/**
 * <b>description</b>：微信用户信息表模型<br>
 * <b>time</b>：2017-04-09 18:57:55 <br>
 * <b>author</b>：  percy-chen@hotmail.com
 */
@Entity
@Table(name = "xc_recharge_order")
public class XcRechargeOrderModel extends BaseEntity{

	/**
	* @Fields serialVersionUID
	*/
	private static final long serialVersionUID = 1L;
	
	 /*
	  *充值金额 
	  */
	private Double price;
	 /*
	  * 
	  */
	private Long addtime;
	 /*
	  *org_role管理员id 
	  */
	private String admin_id;
	 /*
	  *状态 1成功 
	  */
	private java.lang.Integer status;
	 /*
	  * 
	  */
	private Long uptime;

	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getAddtime() {
		return addtime;
	}

	public void setAddtime(Long addtime) {
		this.addtime = addtime;
	}
	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public java.lang.Integer getStatus() {
		return status;
	}

	public void setStatus(java.lang.Integer status) {
		this.status = status;
	}
	public Long getUptime() {
		return uptime;
	}

	public void setUptime(Long uptime) {
		this.uptime = uptime;
	}

}
