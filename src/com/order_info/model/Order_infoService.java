package com.order_info.model;

import java.sql.Timestamp;
import java.util.List;

public class Order_infoService {
	private Order_infoDAO_interface Ord;
	
	public Order_infoService() {
		Ord =new Order_infoJDBCDAO();
	}
	
	public Order_infoVO addOrder_info(String member_id,Timestamp order_time,Timestamp payment_time,String pay_way,Integer order_status,String coupon_ID)
{
		Order_infoVO order_infoVO=new Order_infoVO();
		order_infoVO.setMember_id(member_id);
		order_infoVO.setOrder_time(order_time);
		order_infoVO.setPayment_time(payment_time);
		order_infoVO.setPay_way(pay_way);
		order_infoVO.setOrder_status(order_status);
		order_infoVO.setCoupon_ID(coupon_ID);
		Ord.insert(order_infoVO);
		return order_infoVO;
	}
	
	public Order_infoVO updateOrder_infoVO(String order_ID,String member_id,Timestamp order_time,Timestamp payment_time,String pay_way,Integer order_status,String coupon_ID) {
		Order_infoVO order_infoVO=new Order_infoVO();
		order_infoVO.setMember_id(member_id);
		order_infoVO.setOrder_time(order_time);
		order_infoVO.setPayment_time(payment_time);
		order_infoVO.setPay_way(pay_way);
		order_infoVO.setOrder_status(order_status);
		order_infoVO.setCoupon_ID(coupon_ID);
		order_infoVO.setOrder_ID(order_ID);
		Ord.update(order_infoVO);
		return order_infoVO;

	}
	
	public void deleorder_info(String order_ID) {
		Ord.delete(order_ID);
	}
	
	public Order_infoVO getOneOrder_infoVO(String order_ID) {
		return Ord.findByPrimaryKey(order_ID);
	}
	
	public List<Order_infoVO>getAll(){
		return Ord.getAll();
	}
}
