package com.class_chapter.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.class_info.model.Class_infoVO;

public class Class_chapterJDBCDAO implements Class_chapterDAO_interface {
	private static final String INSERT = "INSERT INTO CLASS_CHAPTER VALUES('CLC'||lPAD(CLASS_CHAPTER_SEQ.NEXTVAL,5,'0'),?,?)";
	private static final String UPDATE = "UPDATE CLASS_CHAPTER SET CLASS_ID= ?,CHAPTER_NAME = ? WHERE CHAPTER_ID= ?";
	private static final String DELETE = "DELETE FROM CLASS_CHAPTER WHERE CHAPTER_ID= ?";
	private static final String SELECT = "SELECT * FROM CLASS_CHAPTER WHERE CHAPTER_ID= ?";
	private static final String GET_ALL = "SELECT * FROM CLASS_CHAPTER";
	private static final String GET_ALL_CLASS_ID = "SELECT * FROM CLASS_CHAPTER  WHERE CLASS_ID= ? ";
	
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "TEA102G5";
	public static final String PASSWORD = "123456";
//	=========================================================
//	public static void main(String[] args) {
//		Class_chapterDAO_interface dao = new Class_chapterJDBCDAO();
//		Class_chapterVO vo = new Class_chapterVO();
////		test_insert
//		vo.setClass_id("CLA00021");
//		vo.setChapter_name("DAO-insert");
//		dao.insert(vo);
////		test_select
//		Class_chapterVO vo_select = dao.select("CLC00116");
//		System.out.println("class_id:"+vo_select.getClass_id());
//		System.out.println("chapter:"+vo_select.getChapter_name());
////		test_update
//		vo.setChapter_id("CLC00116");
//		vo.setClass_id("CLA00022");
//		vo.setChapter_name("DAO-update");
////		===
//		dao.update(vo);
//		vo_select = dao.select("CLC00116");
//		System.out.println("class_id:"+vo_select.getClass_id());
//		System.out.println("chapter:"+vo_select.getChapter_name());
////		test_delete
//		dao.delete("CLC00116");
//		System.out.println("");
//	}
	
	
//	==========================================================
//	static {
//		try {
//			Class.forName(DRIVER);
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		}
//	}

	@Override
	public List<Class_chapterVO> getAll(Map<String, String[]> map) {
		List<Class_chapterVO> list = new ArrayList<Class_chapterVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		String sql = "SELECT * FROM CLASS_CHAPTER" + get_WhereCondition(map) + " ORDER BY CHAPTER_ID";
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Class_chapterVO class_chapterVO = new Class_chapterVO();
				class_chapterVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_chapterVO.setClass_id(rs.getString("CLASS_ID"));
				class_chapterVO.setChapter_name(rs.getString("CHAPTER_NAME"));
				list.add(class_chapterVO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	//�ޤJMap servlet �Q��request.getParameterMap();  ���� �ҥH����Map�����O<String, String[]>
	public static String get_WhereCondition(Map<String, String[]> map) {
		//��map�Ҧ���key
		Set<String> keys = map.keySet();
		//StringBuffer �إߥi�H���Y���r��
		StringBuffer whereCondition = new StringBuffer();
		int count = 0;
		//���X�Ҧ���key
		for (String key : keys) {
			//�Q��key���^�Ҧ���value
																					//������[0] checkbox��L��T????
			String value = map.get(key)[0];
			if (value != null && value.trim().length() != 0 && !"action".equals(key)) {    //action�O�̫�@��name
				count++;
				String aCondition = get_aCondition_For_Oracle(key, value.trim()); //���W��=form��檺name  +  ��J�����e
				
				//�Ĥ@���e���nwhere ��L�� �e���nand
				if (count == 1)
					whereCondition.append(" where " + aCondition);
				else
					whereCondition.append(" and " + aCondition);
			}
		}

		return whereCondition.toString();
	}
													//���W��=form��檺name  +  ��J�����e
	public static String get_aCondition_For_Oracle(String columnName, String value) {
		String aCondition =null;
		//�P�_�Ƕi�h���Ȱ����P���B�z
		//�S���j�p���� ID + ���A
		if ("chapter_id".equals(columnName) || "class_id".equals(columnName)  )     //�Ʀr��̬۵�
			aCondition = columnName + "='" + value+"'";
		// �r�곡���ŦXlike
		else if ("chapter_name".equals(columnName) || "mainClass_name".equals(columnName)) 
			aCondition = columnName + " like '%" + value + "%'";
		
		return aCondition + " ";
	}

	@Override
	public void insert(Class_chapterVO class_chapterVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, class_chapterVO.getClass_id());
			pstmt.setString(2, class_chapterVO.getChapter_name());
			
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
	public void update(Class_chapterVO class_chapterVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, class_chapterVO.getClass_id());
			pstmt.setString(2, class_chapterVO.getChapter_name());
			pstmt.setString(3, class_chapterVO.getChapter_id());
			
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
	public void delete(String chapter_id) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, chapter_id);

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
	public Class_chapterVO select(String chapter_id) {
		Class_chapterVO class_chapterVO = new Class_chapterVO();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = con.prepareStatement(SELECT);

			pstmt.setString(1, chapter_id);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				class_chapterVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_chapterVO.setClass_id(rs.getString("CLASS_ID"));
				class_chapterVO.setChapter_name(rs.getString("CHAPTER_NAME"));
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
		return class_chapterVO;
	}
	
	@Override
	public List<Class_chapterVO> getAll() {
		List<Class_chapterVO> list = new ArrayList<Class_chapterVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = con.prepareStatement(GET_ALL);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Class_chapterVO class_chapterVO = new Class_chapterVO();
				class_chapterVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_chapterVO.setClass_id(rs.getString("CLASS_ID"));
				class_chapterVO.setChapter_name(rs.getString("CHAPTER_NAME"));
				list.add(class_chapterVO);
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
	@Override
	public List<Class_chapterVO> getClassAll(String class_id) {
		List<Class_chapterVO> list = new ArrayList<Class_chapterVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			
			pstmt = con.prepareStatement(GET_ALL_CLASS_ID);
			pstmt.setString(1, class_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Class_chapterVO class_chapterVO = new Class_chapterVO();
				class_chapterVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_chapterVO.setClass_id(rs.getString("CLASS_ID"));
				class_chapterVO.setChapter_name(rs.getString("CHAPTER_NAME"));
				list.add(class_chapterVO);
			}
			// Handle any driver errors
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
		return list;
	}
	
}
