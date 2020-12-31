package com.student_homework.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class Student_homeworkJDBCDAO implements Student_homeworkDAO_interface {
	private static final String INSERT = "INSERT INTO STUDENT_HOMEWORK VALUES('SH'||lPAD(STUDENT_HOMEWORK_SEQ.NEXTVAL,5,'0'),?,?,?,?,?)";
	private static final String UPDATE = "UPDATE STUDENT_HOMEWORK SET TEACHERHW_ID= ?,MEMBER_ID= ?,FILE_DATA= ?,HW_UPLOADTIME= ?,HW_UPDATETIME= ? WHERE STUDENTHW_ID = ?";
	private static final String DELETE = "DELETE FROM STUDENT_HOMEWORK WHERE STUDENTHW_ID = ?";
	private static final String SELECT = "SELECT * FROM STUDENT_HOMEWORK WHERE STUDENTHW_ID = ?";
	private static final String SELECT_BY = "SELECT * FROM STUDENT_HOMEWORK WHERE ? = ?";
	private static final String GET_ALL = "SELECT * FROM STUDENT_HOMEWORK ORDER BY STUDENTHW_ID";
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "TEA102G5";
	public static final String PASSWORD = "123456";
	
	public static void main(String[] args) {
		Student_homeworkDAO_interface dao = new Student_homeworkJDBCDAO();
		Student_homeworkVO vo = new Student_homeworkVO();
		
////		time_test
//		Timestamp uploadtime = Timestamp.valueOf("2020-10-11 20:08:32");
//		Timestamp updatetime = new Timestamp(System.currentTimeMillis());
//		
////		test_insert
//		vo.setTeacherhw_id("TH00003");
//		vo.setMember_id("MEM00007");
//		vo.setFile_data(null);
//		vo.setHw_uploadtime(uploadtime);
//		vo.setHw_updatetime(updatetime);
//		dao.insert(vo);
////		test_select
//		Student_homeworkVO vo_select = dao.select("SH00011");
//		System.out.println("teacherhw_id:"+vo_select.getTeacherhw_id());
//		System.out.println("member_id:"+vo_select.getMember_id());
//		System.out.println("file_data:"+vo_select.getFile_data());
//		System.out.println("hw_uploadtime:"+vo_select.getHw_uploadtime());
//		System.out.println("hw_updatetime:"+vo_select.getHw_updatetime());
//		System.out.println("=============================");
////		test_update
//		Timestamp uploadtime2 = Timestamp.valueOf("1998-03-21 03:41:22");
//		Timestamp updatetime2 = new Timestamp(System.currentTimeMillis());
//		vo.setTeacherhw_id("TH00004");
//		vo.setMember_id("MEM00001");
//		vo.setFile_data(null);
//		vo.setHw_uploadtime(uploadtime2);
//		vo.setHw_updatetime(updatetime2);
//		dao.update(vo);
////		===
//		Student_homeworkVO vo_select2 = dao.select("SH00011");
//		System.out.println("teacherhw_id:"+vo_select2.getTeacherhw_id());
//		System.out.println("member_id:"+vo_select2.getMember_id());
//		System.out.println("file_data:"+vo_select2.getFile_data());
//		System.out.println("hw_uploadtime:"+vo_select2.getHw_uploadtime());
//		System.out.println("hw_updatetime:"+vo_select2.getHw_updatetime());
//		System.out.println("=============================");
////		===
//		List<Student_homeworkVO> list = dao.getAll();
//		
//		for(Student_homeworkVO temp_vo: list) {
//			System.out.println(temp_vo.getStudenthw_id());
//			System.out.println(temp_vo.getTeacherhw_id());
//			System.out.println(temp_vo.getMember_id());
//			System.out.println(temp_vo.getFile_data());
//			System.out.println(temp_vo.getHw_uploadtime());
//			System.out.println(temp_vo.getHw_updatetime());
//			System.out.println("=======================================");
//		}
////		===
//		dao.delete("TH00011");
//		System.out.println("delete success");
	}
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(Student_homeworkVO student_homeworkVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT);
            
			pstmt.setString(1, student_homeworkVO.getTeacherhw_id());
			pstmt.setString(2, student_homeworkVO.getMember_id());
			pstmt.setBytes(3, student_homeworkVO.getFile_data());
			pstmt.setTimestamp(4, student_homeworkVO.getHw_uploadtime());
			pstmt.setTimestamp(5, student_homeworkVO.getHw_updatetime());
			
			pstmt.executeUpdate();
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	@Override
	public void update(Student_homeworkVO student_homeworkVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, student_homeworkVO.getTeacherhw_id());
			pstmt.setString(2, student_homeworkVO.getMember_id());
			pstmt.setBytes(3, student_homeworkVO.getFile_data());
			pstmt.setTimestamp(4, student_homeworkVO.getHw_uploadtime());
			pstmt.setTimestamp(5, student_homeworkVO.getHw_updatetime());
			pstmt.setString(6,student_homeworkVO.getStudenthw_id());
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	@Override
	public void delete(String studenthw_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, studenthw_id);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	@Override
	public Student_homeworkVO select(String studenthw_id) {
		Student_homeworkVO student_homeworkVO = new Student_homeworkVO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(SELECT);
			pstmt.setString(1, studenthw_id);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				student_homeworkVO.setStudenthw_id(rs.getString("STUDENTHW_ID"));
				student_homeworkVO.setTeacherhw_id(rs.getString("TEACHERHW_ID"));
				student_homeworkVO.setMember_id(rs.getString("MEMBER_ID"));
				student_homeworkVO.setFile_data(rs.getBytes("FILE_DATA"));
				student_homeworkVO.setHw_uploadtime(rs.getTimestamp("HW_UPLOADTIME"));
				student_homeworkVO.setHw_updatetime(rs.getTimestamp("HW_UPDATETIME"));
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return student_homeworkVO;
	}
	@Override
	public List<Student_homeworkVO> getAll() {
		List<Student_homeworkVO> list = new ArrayList<Student_homeworkVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Student_homeworkVO student_homeworkVO = new Student_homeworkVO();
				student_homeworkVO.setStudenthw_id(rs.getString("STUDENTHW_ID"));
				student_homeworkVO.setTeacherhw_id(rs.getString("TEACHERHW_ID"));
				student_homeworkVO.setMember_id(rs.getString("MEMBER_ID"));
				student_homeworkVO.setFile_data(rs.getBytes("FILE_DATA"));
				student_homeworkVO.setHw_uploadtime(rs.getTimestamp("HW_UPLOADTIME"));
				student_homeworkVO.setHw_updatetime(rs.getTimestamp("HW_UPDATETIME"));
				list.add(student_homeworkVO);
			}
			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return list;
	}
}
