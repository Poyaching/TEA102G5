package com.order_list.model;

import java.util.List;

import com.order_info.model.Order_infoVO;

public interface Order_listDAO_interface {
	public void insert(Order_listVO Order_listVO);
	public void update(Order_listVO Order_listVO);
	public void delete(String Order_list);
	public Order_listVO findByPrimaryKey(String order_list_id);
	public List<Order_listVO> getAll();
	public List<Order_listVO> getMemberClass(String member_id);

}
