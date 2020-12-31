
package com.admin_list.model;

import java.util.List;


public interface Admin_list_interface {

	public void insert(Admin_listVO admin_listVO);
	public void update(Admin_listVO admin_listVO);
	public void delete(String admin_listVO);
	public Admin_listVO findByPrimaryKey(String admin_listVO);
	public List<Admin_listVO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map);
	
}
