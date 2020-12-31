package com.sub_message.model;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.LinkedHashSet;
	import java.util.List;
	import java.util.Set;


	import com.sub_message.model.Sub_messageVO;


	public class Sub_messageJDBCDAO implements Sub_messageDAO_interface {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String userid = "TEA102G5";
		String passwd = "123456";
		
		private static final String INSERT_STMT = "INSERT INTO sub_message (submsg_id,mainmsg_id,member_id,submsg_time,submsg_text,submsg_status) VALUES ('SM' || lpad(sub_message_SEQ.NEXTVAL,5,'0'),?,?,?,?,?)";

		
		private static final String DELETE_sub_message = "DELETE FROM sub_message where submsg_id  = ?";	
		
		private static final String GET_ALL_STMT = "SELECT submsg_id,mainmsg_id,member_id,submsg_time,submsg_text,submsg_status FROM sub_message order by submsg_id";
		private static final String GET_ONE_STMT = "SELECT * FROM sub_message where submsg_id = ?";
		
//		private static final String GET_mainmsg_id_Bymain_message_STMT = ""
//				+ "SELECT * "
//				+ "FROM sub_message "
//				+ "where mainmsg_id  = ? "
//				+ "order by submsg_id";
		
		private static final String UPDATE = "UPDATE sub_message set mainmsg_id=?,member_id=?,submsg_time=?,submsg_text=?,submsg_status=? where submsg_id =?";

		
//	    insert 新增
		
		@Override
		public void insert(Sub_messageVO sub_messageVO) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
	        try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(INSERT_STMT);
				
				
				pstmt.setString(1, sub_messageVO.getMainmsg_id());
				pstmt.setString(2, sub_messageVO.getMember_id());
				pstmt.setTimestamp(3, sub_messageVO.getSubmsg_time());
				pstmt.setString(4, sub_messageVO.getSubmsg_text());
				pstmt.setInt(5, sub_messageVO.getSubmsg_status());
	

				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
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
		
//	    update	更新
		
		@Override
		public void update(Sub_messageVO sub_messageVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, sub_messageVO.getMainmsg_id());
				pstmt.setString(2, sub_messageVO.getMember_id());
				pstmt.setTimestamp(3, sub_messageVO.getSubmsg_time());
				pstmt.setString(4, sub_messageVO.getSubmsg_text());
				pstmt.setInt(5, sub_messageVO.getSubmsg_status());
				pstmt.setString(6, sub_messageVO.getSubmsg_id());
				
				pstmt.executeUpdate();

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
				// Clean up JDBC resources
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
		
			
		
	// delete 刪除
		
		@Override
		public void delete(String submsg_id) {
			int updateCount_sub_message = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);

				// 1●設定於 pstm.executeUpdate()之前
				con.setAutoCommit(false);

				// 
				pstmt = con.prepareStatement(DELETE_sub_message);
				pstmt.setString(1,submsg_id);
				updateCount_sub_message = pstmt.executeUpdate();
				
				pstmt.executeUpdate();

				// 2●設定於 pstm.executeUpdate()之後
				con.commit();
				con.setAutoCommit(true);
				
				
				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				if (con != null) {
					try {
						// 3●設定於當有exception發生時之catch區塊內
						con.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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

	
		
//		findByPrimaryKey 找PK鍵
		
		@Override
		public Sub_messageVO findByPrimaryKey(String submsg_id) {

			Sub_messageVO sub_messageVO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setString(1, submsg_id);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// sub_messageVO 也稱為 Domain objects
					sub_messageVO = new Sub_messageVO();
					sub_messageVO.setSubmsg_id(rs.getString("submsg_id"));
					sub_messageVO.setMainmsg_id(rs.getString("mainmsg_id"));
					sub_messageVO.setMember_id(rs.getString("member_id"));
					sub_messageVO.setSubmsg_time(rs.getTimestamp("submsg_time"));
					sub_messageVO.setSubmsg_text(rs.getString("submsg_text"));
					sub_messageVO.setSubmsg_status(rs.getInt("submsg_status"));
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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
			return sub_messageVO;
		}
		
		
		
//	     List 列出全部
		
		@Override
		public List<Sub_messageVO> getAll() {
			List<Sub_messageVO> list = new ArrayList<Sub_messageVO>();
			Sub_messageVO sub_messageVO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					sub_messageVO  = new Sub_messageVO();
					sub_messageVO.setSubmsg_id(rs.getString("submsg_id"));
					sub_messageVO.setMainmsg_id(rs.getString("mainmsg_id"));
					sub_messageVO.setMember_id(rs.getString("member_id"));
					sub_messageVO.setSubmsg_time(rs.getTimestamp("submsg_time"));
					sub_messageVO.setSubmsg_text(rs.getString("submsg_text"));
					sub_messageVO.setSubmsg_status(rs.getInt("submsg_status"));
					list.add(sub_messageVO); // Store the row in the list
				}

				// Handle any driver errors
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Couldn't load database driver. "
						+ e.getMessage());
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
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

		
//Main方法	
		
		public static void main(String[] args) {

			Sub_messageJDBCDAO dao = new Sub_messageJDBCDAO();
			
		
			//新增
			Sub_messageVO dao1 = new Sub_messageVO();
			dao1.setMainmsg_id("MM00009");
			dao1.setMember_id("MEM00009");
			dao1.setSubmsg_time(java.sql.Timestamp.valueOf("2020-12-06 21:07:00"));
			dao1.setSubmsg_text("題目好難");
			dao1.setSubmsg_status(1);
			
			dao.insert(dao1);
			
			
			
			// 修改update
//			Sub_messageVO dao1 = new Sub_messageVO();
//			dao1.setMainmsg_id("MM00005");
//			dao1.setMember_id("MEM00005");
//			dao1.setSubmsg_time(java.sql.Timestamp.valueOf("2020-12-05 18:34:00"));
//			dao1.setSubmsg_text("題目有夠難");
//			dao1.setSubmsg_status(0);
//			dao1.setSubmsg_id("SM00005");
//			dao.update(dao1);
		
			
			//刪除
//			dao.delete("SM00012");
			
			
			
			//查詢部門
////			
//			List<Sub_messageVO> list = dao.getAll();
//			for (Sub_messageVO dao1 : list) {
//				System.out.print(dao1.getSubmsg_id()+ ",");
//				System.out.print(dao1.getMainmsg_id() + ",");
//				System.out.print(dao1.getMember_id() + ",");
//			    System.out.print(dao1.getSubmsg_time() + ",");
//				System.out.print(dao1.getSubmsg_text() + ",");
//			    System.out.print(dao1.getSubmsg_status());
//				
//				
//				System.out.println();
//			}
			
//			 查詢
//			Sub_messageVO sub_messageVO = dao.findByPrimaryKey("SM00001");
//			System.out.print(sub_messageVO.getSubmsg_id()+ ",");
//			System.out.print(sub_messageVO.getMainmsg_id() + ",");
//			System.out.print(sub_messageVO.getMember_id() + ",");
//			System.out.print(sub_messageVO.getSubmsg_time() + ",");
//			System.out.print(sub_messageVO.getSubmsg_text() + ",");
//			System.out.print(sub_messageVO.getSubmsg_status());
//			System.out.println("---------------------");	

	

	}
}
	
