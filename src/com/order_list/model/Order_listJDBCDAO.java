package com.order_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Order_listJDBCDAO implements Order_listDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEA102G5";
	String passwd = "123456";
	private static final String INSERT_STMT = "INSERT INTO Order_list (order_list_id,order_id,class_id,purchase_plan) VALUES ('OL' || lpad(order_list_SQE.NEXTVAL,5, '0'), ?, ?,?)";
	private static final String UPDATE = "UPDATE Order_list set order_id=?, class_id=?, purchase_plan=? where order_list_id = ?";
	private static final String DELETE_STMT = "DELETE FROM Order_list WHERE order_list_id = ?";
	private static final String GET_ONE_STMT = "SELECT order_list_id, order_id, class_id, purchase_plan FROM Order_list where order_list_id = ?";
	private static final String GET_ALL_STMT = "SELECT order_list_id , order_id, class_id, purchase_plan FROM Order_list";
	

	@Override
	public void insert(Order_listVO Order_listVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, Order_listVO.getOrder_id());
			pstmt.setString(2, Order_listVO.getClass_id());
			pstmt.setString(3, Order_listVO.getPurchase_plan());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Order_listVO Order_listVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, Order_listVO.getOrder_id());
			pstmt.setString(2, Order_listVO.getClass_id());
			pstmt.setString(3, Order_listVO.getPurchase_plan());
			pstmt.setString(4, Order_listVO.getOrder_list_id());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(String Order_list) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setString(1,Order_list);
			pstmt.executeUpdate();
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Order_listVO findByPrimaryKey(String order_list_id) {
		Order_listVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, order_list_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new Order_listVO();
				vo.setOrder_list_id(rs.getString("order_list_id"));
				vo.setOrder_id(rs.getString("order_id"));
				vo.setClass_id(rs.getString("class_id"));
				vo.setPurchase_plan(rs.getString("purchase_plan"));
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return vo;
	}


	@Override
	public List<Order_listVO> getAll() {
		List<Order_listVO> empList = new ArrayList<Order_listVO>();
		Order_listVO vo2 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new Order_listVO();
				vo2.setOrder_list_id(rs.getString("order_list_id"));
				vo2.setOrder_id(rs.getString("order_id"));
				vo2.setClass_id(rs.getString("class_id"));
				vo2.setPurchase_plan(rs.getString("purchase_plan"));
				empList.add(vo2);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empList;
	}


	public static void main(String[] args) {
		// 新增
		Order_listJDBCDAO order = new Order_listJDBCDAO();
//		Order_listVO inf = new Order_listVO();
//		inf.setOrder_id("OID00028");
//		inf.setClass_id("CLA00008");
//		inf.setPurchase_plan("我是誰");
//		order.insert(inf);

		// 修改
//	    Order_listVO inf = new Order_listVO();
//	    inf.setOrder_id("OID00028");
//	    inf.setClass_id("CLA00008");
//	    inf.setPurchase_plan("肚肚物度");
//	    inf.setOrder_list_id("OL00068");
//	    order.update(inf);
		
		//刪除
//		order.delete("OL00068");
		
//		 查詢
//		Order_listVO vo1 = order.findByPrimaryKey("OL00065");
//		System.out.println(vo1.getOrder_list_id());
//		System.out.println(vo1.getOrder_id());
//		System.out.println(vo1.getClass_id());
//		System.out.println(vo1.getPurchase_plan());
		
		// 查詢全部
		List<Order_listVO> li = order.getAll();
		for (Order_listVO apt : li) {
			System.out.println(apt.getOrder_list_id());
			System.out.println(apt.getOrder_id());
			System.out.println(apt.getClass_id());
			System.out.println(apt.getPurchase_plan());

		}
	}
	
	//取該用戶的所有成功購買課程
	@Override
	public List<Order_listVO> getMemberClass(String member_id) {
		List<Order_listVO> empList = new ArrayList<Order_listVO>();
		Order_listVO vo2 = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, userid, passwd);
			String sql = "select * from ORDER_INFO inner Join ORDER_LIST on ORDER_INFO.ORDER_ID =ORDER_LIST.ORDER_ID where member_id = ? and  ORDER_STATUS=1";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo2 = new Order_listVO();
				vo2.setOrder_list_id(rs.getString("order_list_id"));
				vo2.setOrder_id(rs.getString("order_id"));
				vo2.setClass_id(rs.getString("class_id"));
				vo2.setPurchase_plan(rs.getString("purchase_plan"));
				empList.add(vo2);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return empList;
	}
}