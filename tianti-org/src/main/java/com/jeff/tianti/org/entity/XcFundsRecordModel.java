package com.jeff.tianti.org.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jeff.tianti.common.entity.BaseEntity;


/**
 * <b>description</b>：微信用户信息表模型<br>
 * <b>time</b>：2017-04-09 18:57:16 <br>
 * <b>author</b>：  percy-chen@hotmail.com
 */
@Entity
@Table(name = "xc_funds_record")
public class XcFundsRecordModel extends BaseEntity{

	/**
	* @Fields serialVersionUID
	*/
	private static final long serialVersionUID = 1L;
	
	 /*
	  * 
	  */
	private String user_id;
	 /*
	  *发生金额 
	  */
	private Double price;
	 /*
	  *-1 支出 0 不变 1 增加 
	  */
	private java.lang.Integer income;
	 /*
	  * 
	  */
	private java.lang.Integer addtime;
	 /*
	  *类型 参见枚举 
	  */
	private java.lang.Integer type;

	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	public java.lang.Integer getIncome() {
		return income;
	}

	public void setIncome(java.lang.Integer income) {
		this.income = income;
	}
	public java.lang.Integer getAddtime() {
		return addtime;
	}

	public void setAddtime(java.lang.Integer addtime) {
		this.addtime = addtime;
	}
	public java.lang.Integer getType() {
		return type;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

}
