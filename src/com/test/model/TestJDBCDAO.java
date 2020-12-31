package com.test.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TestJDBCDAO implements TestDAO_interface {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid = "TEA102G5";
	String passwd = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO TEST VALUES ('TU'||lPAD(TEST_SEQ.NEXTVAL,5,'0'),?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT test_id,unit_id ,test_answer ,test_content,opta,optb,optc,optd FROM Test order by test_id";
	private static final String GET_ONE_STMT = "SELECT test_id,unit_id ,test_answer ,test_content,opta,optb,optc,optd FROM Test where test_id = ?";
	private static final String DELETE = "DELETE FROM Test where test_id = ?";
	private static final String UPDATE = "UPDATE Test set unit_id=?,test_answer=?,test_content=?,opta=?,optb=?,optc=?,optd=? where test_id = ?";

	
	

	@Override
	public void insert(TestVO testVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, testVO.getUnit_id());
			pstmt.setString(2, testVO.getTest_answer());
			pstmt.setString(3, testVO.getTest_content());
			pstmt.setString(4, testVO.getOpta());
			pstmt.setString(5, testVO.getOptb());
			pstmt.setString(6, testVO.getOptc());
			pstmt.setString(7, testVO.getOptd());
			
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
	public void update(TestVO testVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, testVO.getUnit_id());
			pstmt.setString(2, testVO.getTest_answer());
			pstmt.setString(3, testVO.getTest_content());
			pstmt.setString(4, testVO.getOpta());
			pstmt.setString(5, testVO.getOptb());
			pstmt.setString(6, testVO.getOptc());
			pstmt.setString(7, testVO.getOptd());
			pstmt.setString(8, testVO.getTest_id());
			
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
	public void delete(String test_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, test_id);

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
	public TestVO findByPrimaryKey(String test_id) {
		TestVO testVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, test_id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				testVO = new TestVO();
				testVO.setTest_id(rs.getString("test_id"));
				testVO.setUnit_id(rs.getString("unit_id"));
				testVO.setTest_answer(rs.getString("test_answer"));
				testVO.setTest_content(rs.getString("test_content"));
				testVO.setOpta(rs.getString("opta"));
				testVO.setOptb(rs.getString("optb"));
				testVO.setOptc(rs.getString("optc"));
				testVO.setOptd(rs.getString("optd"));
				
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
		return testVO;
	}

	@Override
	public List<TestVO> getAll() {
		List<TestVO> list = new ArrayList<TestVO>();
		TestVO testVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				testVO = new TestVO();
				testVO.setTest_id(rs.getString("test_id"));
				testVO.setUnit_id(rs.getString("unit_id"));
				testVO.setTest_answer(rs.getString("test_answer"));
				testVO.setTest_content(rs.getString("test_content"));
				testVO.setOpta(rs.getString("opta"));
				testVO.setOptb(rs.getString("optb"));
				testVO.setOptc(rs.getString("optc"));
				testVO.setOptd(rs.getString("optd"));
				
				
				list.add(testVO);
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
		TestJDBCDAO dao=new TestJDBCDAO();
		
		//新增
//		TestVO testVO1 =new TestVO();
//		testVO1.setUnit_id("UNI00001");
//		testVO1.setTest_answer("CHOOSE1");
//		testVO1.setTest_content("螞蟻能夠安全過冬是因為bai螞蟻儲存了足夠的食物。而蟋蟀因為沒有儲存食物，冬天裡被餓死、凍死的不計其數。那麼，是什麼原因讓蟋蟀沒能儲存食物呢？");
//		testVO1.setOpta("沒有倉庫");
//		testVO1.setOptb("演出去了");
//		testVO1.setOptc("打仗去了");
//		testVO1.setOptd("睡著惹");
//		
//		dao.insert(testVO1);
		
		//修改
//		TestVO testVO2 =new TestVO();
//		testVO2.setTest_id("TU00011");
//		testVO2.setUnit_id("UNI00001");
//		testVO2.setTest_answer("CHOOSE5");
//		testVO2.setTest_content("螞蟻能夠安全過冬是因為bai螞蟻儲存了足夠的食物。而蟋蟀因為沒有儲存食物，冬天裡被餓死、凍死的不計其數。那麼，是什麼原因讓蟋蟀沒能儲存食物呢？");
//		testVO2.setOpta("沒有倉庫");
//		testVO2.setOptb("演出去了");
//		testVO2.setOptc("打仗去了");
//		testVO2.setOptd("睡著惹");
//		dao.update(testVO2);
		
		//刪除
//		dao.delete("TU00011");
		
		//查詢
//		TestVO testVO3=dao.findByPrimaryKey("TU00001");
//		System.out.println(testVO3.getTest_id()+",");
//		System.out.println(testVO3.getUnit_id()+",");
//		System.out.println(testVO3.getTest_answer()+",");
//		System.out.println(testVO3.getTest_content()+",");
//		System.out.println(testVO3.getOpta()+",");
//		System.out.println(testVO3.getOptb()+",");
//		System.out.println(testVO3.getOptc()+",");
//		System.out.println(testVO3.getOptd()+",");
//		System.out.println("-------------------------------");
		
		//查詢
//		List<TestVO> list = dao.getAll();
//		for (TestVO aTestVO : list) {
//			System.out.print(aTestVO.getTest_id() + ",");
//			System.out.print(aTestVO.getUnit_id() + ",");
//			System.out.print(aTestVO.getTest_answer() + ",");
//			System.out.print(aTestVO.getTest_content() + ",");
//			System.out.print(aTestVO.getOpta() + ",");
//			System.out.print(aTestVO.getOptb() + ",");
//			System.out.print(aTestVO.getOptc() + ",");
//			System.out.print(aTestVO.getOptd() + ",");
//			System.out.println();
//		}
		
		
	}

}
