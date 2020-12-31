package com.order_info.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Order_infoVO implements Serializable {
	private String order_ID;// PK
	private String member_id;// FK
	private Timestamp order_time;
	private Timestamp payment_time;
	private String pay_way;
	private Integer order_status;
	private String coupon_ID;

	@Override
	public String toString() {
		return "order_info [order_ID=" + order_ID + ", member_id=" + member_id + ", order_time=" + order_time
				+ ", payment_time=" + payment_time + ", pay_way=" + pay_way + ", order_status=" + order_status
				+ ", coupon_ID=" + coupon_ID + "]";
	}

	public String getOrder_ID() {
		return order_ID;
	}

	public void setOrder_ID(String order_ID) {
		this.order_ID = order_ID;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Timestamp getOrder_time() {
		return order_time;
	}

	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}

	public Timestamp getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(Timestamp payment_time) {
		this.payment_time = payment_time;
	}

	public String getPay_way() {
		return pay_way;
	}

	public void setPay_way(String pay_way) {
		this.pay_way = pay_way;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public String getCoupon_ID() {
		return coupon_ID;
	}

	public void setCoupon_ID(String coupon_ID) {
		this.coupon_ID = coupon_ID;
	}

}
