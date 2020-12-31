package com.teacher_homework.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Teacher_homeworkJDBCDAO implements Teacher_homeworkDAO_interface {
	private static final String INSERT = "INSERT INTO TEACHER_HOMEWORK VALUES('TH'||lPAD(TEACHER_HOMEWORK_SEQ.NEXTVAL,5,'0'),?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE TEACHER_HOMEWORK SET UNIT_ID= ?,HW_NAME= ?,HW_CONTENT= ?,FILE_DATA= ?,HW_UPLOADTIME= ?,HW_UPDATETIME= ? WHERE TEACHERHW_ID= ?";
	private static final String DELETE = "DELETE FROM TEACHER_HOMEWORK WHERE TEACHERHW_ID= ?";
	private static final String SELECT = "SELECT * FROM TEACHER_HOMEWORK WHERE TEACHERHW_ID= ?";
	private static final String GET_ALL = "SELECT * FROM TEACHER_HOMEWORK";
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "TEA102G5";
	public static final String PASSWORD = "123456";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(Teacher_homeworkVO teacher_homeworkVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, teacher_homeworkVO.getUnit_id());
			pstmt.setString(2, teacher_homeworkVO.getHw_name());
			pstmt.setString(3, teacher_homeworkVO.getHw_content());
			pstmt.setBytes(4, teacher_homeworkVO.getFile_data());
			pstmt.setTimestamp(5, teacher_homeworkVO.getHw_uploadtime());
			pstmt.setTimestamp(6, teacher_homeworkVO.getHw_updatetime());
			
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
	public void update(Teacher_homeworkVO teacher_homeworkVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, teacher_homeworkVO.getUnit_id());
			pstmt.setString(2, teacher_homeworkVO.getHw_name());
			pstmt.setString(3, teacher_homeworkVO.getHw_content());
			pstmt.setBytes(4, teacher_homeworkVO.getFile_data());
			pstmt.setTimestamp(5, teacher_homeworkVO.getHw_uploadtime());
			pstmt.setTimestamp(6, teacher_homeworkVO.getHw_updatetime());
			pstmt.setString(7, teacher_homeworkVO.getTeacherhw_id());
			
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
	public void delete(String teacherhw_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, teacherhw_id);

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
	public Teacher_homeworkVO select(String teacherhw_id) {
		Teacher_homeworkVO teacher_homeworkVO = new Teacher_homeworkVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(SELECT);

			pstmt.setString(1, teacherhw_id);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				teacher_homeworkVO.setTeacherhw_id(rs.getString("TEACHERHW_ID"));
				teacher_homeworkVO.setUnit_id(rs.getString("UNIT_ID"));
				teacher_homeworkVO.setHw_name(rs.getString("HW_NAME"));
				teacher_homeworkVO.setHw_content(rs.getString("HW_CONTENT"));
				teacher_homeworkVO.setFile_data(rs.getBytes("FILE_DATA"));
				teacher_homeworkVO.setHw_uploadtime(rs.getTimestamp("HW_UPLOADTIME"));
				teacher_homeworkVO.setHw_updatetime(rs.getTimestamp("HW_UPDATETIME"));
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
		return teacher_homeworkVO;
	}
	@Override
	public List<Teacher_homeworkVO> getAll() {
		List<Teacher_homeworkVO> list = new ArrayList<Teacher_homeworkVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Teacher_homeworkVO teacher_homeworkVO = new Teacher_homeworkVO();
				teacher_homeworkVO.setTeacherhw_id(rs.getString("TEACHERHW_ID"));
				teacher_homeworkVO.setUnit_id(rs.getString("UNIT_ID"));
				teacher_homeworkVO.setHw_name(rs.getString("HW_NAME"));
				teacher_homeworkVO.setHw_content(rs.getString("HW_CONTENT"));
				teacher_homeworkVO.setFile_data(rs.getBytes("FILE_DATA"));
				teacher_homeworkVO.setHw_uploadtime(rs.getTimestamp("HW_UPLOADTIME"));
				teacher_homeworkVO.setHw_updatetime(rs.getTimestamp("HW_UPDATETIME")); 
				list.add(teacher_homeworkVO);
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
