package com.login_history.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Login_historyJDBCDAO implements Login_historyDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEA102G5";
	String passwd = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO login_history  VALUES ('LOGIN' || lpad(LOGID_SEQ.NEXTVAL,5, '0'),?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT login_id,login_time ,login_arrange ,login_ip,member_id FROM login_history order by login_id";
	private static final String GET_ONE_STMT = "SELECT login_id,login_time ,login_arrange ,login_ip,member_id FROM login_history where login_id = ?";
	private static final String DELETE = "DELETE FROM login_history where login_id = ?";
	private static final String UPDATE = "UPDATE login_history set login_time=?,login_arrange=?,login_ip=?,member_id=? where login_id = ?";


	@Override
	public void insert(Login_historyVO login_historyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setTimestamp(1, login_historyVO.getLogin_time());
			pstmt.setString(2, login_historyVO.getLogin_arrange());
			pstmt.setString(3, login_historyVO.getLogin_ip());
			pstmt.setString(4, login_historyVO.getMember_id());
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(Login_historyVO login_historyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setTimestamp(1, login_historyVO.getLogin_time());
			pstmt.setString(2, login_historyVO.getLogin_arrange());
			pstmt.setString(3, login_historyVO.getLogin_ip());
			pstmt.setString(4, login_historyVO.getMember_id());
			pstmt.setString(5, login_historyVO.getLogin_id());
			
			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(String login_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, login_id);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Login_historyVO findByPrimaryKey(String login_id) {
		Login_historyVO login_historyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, login_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				login_historyVO = new Login_historyVO();
				login_historyVO.setLogin_id(rs.getString("login_id"));
				login_historyVO.setLogin_time(rs.getTimestamp("login_time"));
				login_historyVO.setLogin_arrange(rs.getString("login_arrange"));
				login_historyVO.setLogin_ip(rs.getString("login_ip"));
				login_historyVO.setMember_id(rs.getString("member_id"));
				
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
		return login_historyVO;


	}

	@Override
	public List<Login_historyVO> getAll() {
		List<Login_historyVO> list = new ArrayList<Login_historyVO>();
		Login_historyVO login_historyVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				login_historyVO = new Login_historyVO();
				login_historyVO.setLogin_id(rs.getString("login_id"));
				login_historyVO.setLogin_time(rs.getTimestamp("login_time"));
				login_historyVO.setLogin_arrange(rs.getString("login_arrange"));
				login_historyVO.setLogin_ip(rs.getString("login_ip"));
				login_historyVO.setMember_id(rs.getString("member_id"));
				
				
				list.add(login_historyVO);
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
		return list;
	}
	public static void main(String[] args) {
		Login_historyJDBCDAO dao = new Login_historyJDBCDAO();
		
		
		//新增
//		Login_historyVO login_historyVO1=new Login_historyVO();
//		login_historyVO1.setLogin_time(java.sql.Timestamp.valueOf("2020-11-27 19:48:51"));
//		login_historyVO1.setLogin_arrange("IOS6");
//		login_historyVO1.setLogin_ip("140.115.19.42");
//		login_historyVO1.setMember_id("MEM00001");
//		dao.insert(login_historyVO1);
		
		//修改
//		Login_historyVO login_historyVO2=new Login_historyVO();
//		login_historyVO2.setLogin_id("LOGIN00004");
//		login_historyVO2.setLogin_time(java.sql.Timestamp.valueOf("2020-12-02 19:48:51"));
//		login_historyVO2.setLogin_arrange("IOS7");
//		login_historyVO2.setLogin_ip("140.115.19.42");
//		login_historyVO2.setMember_id("MEM00001");
//		
//		dao.update(login_historyVO2);
//		
		//刪除
//		dao.delete("LOGIN00004");
		
		//查詢
//		Login_historyVO login_historyVO3=dao.findByPrimaryKey("LOGIN00001");
//		System.out.println(login_historyVO3.getLogin_id()+",");
//		System.out.println(login_historyVO3.getLogin_time()+",");
//		System.out.println(login_historyVO3.getLogin_arrange()+",");
//		System.out.println(login_historyVO3.getLogin_ip()+",");
//		System.out.println(login_historyVO3.getMember_id()+",");
//		System.out.println("--------------------------------------");
		
		//查詢
//		List<Login_historyVO> list = dao.getAll();
//		for (Login_historyVO aLogin_history : list) {
//			System.out.print(aLogin_history.getLogin_id() + ",");
//			System.out.print(aLogin_history.getLogin_time() + ",");
//			System.out.print(aLogin_history.getLogin_arrange() + ",");
//			System.out.print(aLogin_history.getLogin_ip() + ",");
//			System.out.print(aLogin_history.getMember_id() + ",");
//	
//			System.out.println();
//		}
		
		
	}

}
