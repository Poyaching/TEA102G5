package com.order_info.model;

import java.util.List;

import com.coupon.model.CouponVO;

public interface Order_infoDAO_interface {
	public void insert(Order_infoVO order_infoVO);
	public void update(Order_infoVO order_infoVO);
	public void delete(String order_infoVO);
	public Order_infoVO findByPrimaryKey(String order_ID);
	public List<Order_infoVO> getAll();

}
