package com.order_list.model;

import java.util.List;

public class Order_listService {
	
	private Order_listDAO_interface Oli;
	
	public Order_listService() {
		Oli=new Order_listJDBCDAO();
	}
	
	public Order_listVO addOrder_list(String order_id,String class_id,String purchase_plan) {
		Order_listVO order_listVO=new Order_listVO();
		order_listVO.setOrder_id(order_id);
		order_listVO.setClass_id(class_id);
		order_listVO.setPurchase_plan(purchase_plan);
		Oli.insert(order_listVO);
		return order_listVO;
	}
	
	public Order_listVO updateOrder_listVO(String order_list_id,String order_id,String class_id,String purchase_plan) {
		Order_listVO order_listVO=new Order_listVO();
		order_listVO.setOrder_list_id(order_list_id);
		order_listVO.setOrder_id(order_id);
		order_listVO.setClass_id(class_id);
		order_listVO.setPurchase_plan(purchase_plan);
		Oli.update(order_listVO);
		return order_listVO;
	}
	public void deleteOrder_list(String order_list_id) {
		Oli.delete(order_list_id);
	}
	
	public Order_listVO getOneorder_list(String order_list_id) {
		return Oli.findByPrimaryKey(order_list_id);
	}
	
	public List<Order_listVO> getAll(){
		return Oli.getAll();
	}
	
	public List<Order_listVO> getMemberClass(String member_id){
		return Oli.getMemberClass(member_id);
	}

}
