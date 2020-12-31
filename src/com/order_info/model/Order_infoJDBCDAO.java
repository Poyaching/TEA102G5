package com.order_info.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Order_infoJDBCDAO implements Order_infoDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEA102G5";
	String passwd = "123456";
	private static final String INSERT_STMT = "INSERT INTO Order_info (order_ID,member_id,order_time,payment_time,pay_way,order_status,coupon_ID) VALUES ('OID' || lpad(order_infoSQE.NEXTVAL,5, '0'), ?, ?,?,?,?,?)";
	private static final String UPDATE = "UPDATE Order_info set member_id=?, order_time=?, payment_time=?,pay_way=?, order_status=?,coupon_ID=?where order_ID = ?";
	private static final String DELETE_STMT = "DELETE FROM Order_info WHERE order_ID = ?";
	private static final String GET_ONE_STMT = "SELECT order_ID, member_id, order_time, payment_time, pay_way,order_status,coupon_ID FROM Order_info where order_ID = ?";
	private static final String GET_ALL_STMT = "SELECT order_ID , member_id, order_time, payment_time,pay_way,order_status, coupon_ID FROM Order_info";
	
	

	public void insert(Order_infoVO order_infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, order_infoVO.getMember_id());
			pstmt.setTimestamp(2, order_infoVO.getOrder_time());
			pstmt.setTimestamp(3, order_infoVO.getPayment_time());
			pstmt.setString(4, order_infoVO.getPay_way());
			pstmt.setInt(5, order_infoVO.getOrder_status());
			pstmt.setString(6, order_infoVO.getCoupon_ID());
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

	public void update(Order_infoVO order_infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, order_infoVO.getMember_id());
			pstmt.setTimestamp(2, order_infoVO.getOrder_time());
			pstmt.setTimestamp(3, order_infoVO.getPayment_time());
			pstmt.setString(4, order_infoVO.getPay_way());
			pstmt.setInt(5, order_infoVO.getOrder_status());
			pstmt.setString(6, order_infoVO.getCoupon_ID());
			pstmt.setString(7, order_infoVO.getOrder_ID());
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

	public void delete(String order_infoVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setString(1, order_infoVO);
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

	public Order_infoVO findByPrimaryKey(String order_ID) {
		Order_infoVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			pstmt.setString(1, order_ID);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new Order_infoVO();
				vo.setOrder_ID(rs.getString("order_ID"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setOrder_time(rs.getTimestamp("order_time"));
				vo.setPayment_time(rs.getTimestamp("payment_time"));
				vo.setPay_way(rs.getString("pay_way"));
				vo.setOrder_status(rs.getInt("order_status"));
				vo.setCoupon_ID(rs.getString("coupon_ID"));
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

	public List<Order_infoVO> getAll() {
		List<Order_infoVO> empList = new ArrayList<Order_infoVO>();
		Order_infoVO vo2 = null;
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
				vo2 = new Order_infoVO();
				vo2.setOrder_ID(rs.getString("order_ID"));
				vo2.setMember_id(rs.getString("member_id"));
				vo2.setOrder_time(rs.getTimestamp("order_time"));
				vo2.setPayment_time(rs.getTimestamp("payment_time"));
				vo2.setPay_way(rs.getString("pay_way"));
				vo2.setOrder_status(rs.getInt("order_status"));
				vo2.setCoupon_ID(rs.getString("coupon_ID"));
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
		Order_infoJDBCDAO order = new Order_infoJDBCDAO();
		Order_infoVO inf = new Order_infoVO();
		inf.setMember_id("MEM00011");
		inf.setOrder_time(java.sql.Timestamp.valueOf("2020-12-02 04:16:00"));
		inf.setPayment_time(java.sql.Timestamp.valueOf("2020-12-02 04:16:00"));
		inf.setPay_way("我是誰");
		inf.setOrder_status(1);
		inf.setCoupon_ID("COU00001");
		order.insert(inf);

		// 修改
//		Order_infoVO inf = new Order_infoVO();
//		inf.setMember_id("MEM00019");
//		inf.setOrder_time(java.sql.Timestamp.valueOf("2020-12-02 04:16:00"));
//		inf.setPayment_time(java.sql.Timestamp.valueOf("2020-12-02 04:16:00"));
//		inf.setPay_way("江明哲");
//		inf.setOrder_status(0);
//		inf.setCoupon_ID("我我我");
//		inf.setOrder_ID("OID00028");
//		order.update(inf);

		// 刪除
//		order.delete("OID00029");

		// 查詢
//		Order_infoVO vo1 = order.findByPrimaryKey("OID00028");
//		System.out.println(vo1.getOrder_ID());
//		System.out.println(vo1.getMember_id());
//		System.out.println(vo1.getOrder_time());
//		System.out.println(vo1.getPayment_time());
//		System.out.println(vo1.getPay_way());
//		System.out.println(vo1.getOrder_status());
//		System.out.println(vo1.getCoupon_ID());
//		
//		// 查詢全部
//		List<Order_infoVO> li = order.getAll();
//		for (Order_infoVO apt : li) {
//			System.out.println(apt.getOrder_ID());
//			System.out.println(apt.getMember_id());
//			System.out.println(apt.getOrder_time());
//			System.out.println(apt.getPayment_time());
//			System.out.println(apt.getPay_way());
//			System.out.println(apt.getOrder_status());
//			System.out.println(apt.getCoupon_ID());
//		}
	}
}