package com.class_unit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Class_unitJDBCDAO implements Class_unitDAO_interface {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String userid = "TEA102G5";
	private String passwd = "123456";

	private static final String INSERT = "INSERT INTO CLASS_UNIT VALUES('UNI'||lPAD(CLASS_UNIT_SEQ.NEXTVAL,5,'0'),?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE CLASS_UNIT SET CHAPTER_ID= ?,UNIT_NAME= ?,VIDEO= ?,VIDEO_LONG= ?,VIDEO_UPDATETIME= ?,VIDEO_STATUS= ? WHERE UNIT_ID= ?";
	private static final String DELETE = "DELETE FROM CLASS_UNIT WHERE UNIT_ID= ?";
	private static final String SELECT = "SELECT * FROM CLASS_UNIT WHERE UNIT_ID= ?";
	private static final String GET_ALL = "SELECT * FROM CLASS_UNIT ORDER BY UNIT_ID";
	private static final String GET_ALL_CHAPTER_ID = "SELECT * FROM CLASS_UNIT  WHERE CHAPTER_ID= ? ORDER BY UNIT_ID";

	@Override
	public void insert(Class_unitVO class_unitVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT);

			pstmt.setString(1, class_unitVO.getChapter_id());
			pstmt.setString(2, class_unitVO.getUnit_name());
			pstmt.setBytes(3, class_unitVO.getVideo());
			pstmt.setString(4, class_unitVO.getVideo_long());
			pstmt.setTimestamp(5, class_unitVO.getVideo_updatetime());
			pstmt.setInt(6, class_unitVO.getVideo_status());
			
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
	public void update(Class_unitVO class_unitVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, class_unitVO.getChapter_id());
			pstmt.setString(2, class_unitVO.getUnit_name());
			pstmt.setBytes(3, class_unitVO.getVideo());
			pstmt.setString(4, class_unitVO.getVideo_long());
			pstmt.setTimestamp(5, class_unitVO.getVideo_updatetime());
			pstmt.setInt(6, class_unitVO.getVideo_status());
			pstmt.setString(7,class_unitVO.getUnit_id());
			
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
	public void delete(String unit_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setString(1, unit_id);
			pstmt.executeUpdate();

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
	public Class_unitVO findByPrimaryKey(String unit_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Class_unitVO class_unitVO = new Class_unitVO();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(SELECT);
			pstmt.setString(1, unit_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				class_unitVO.setUnit_id(rs.getString("UNIT_ID"));
				class_unitVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_unitVO.setUnit_name(rs.getString("UNIT_NAME"));
				class_unitVO.setVideo(rs.getBytes("VIDEO"));
				class_unitVO.setVideo_long(rs.getString("VIDEO_LONG"));
				class_unitVO.setVideo_updatetime(rs.getTimestamp("VIDEO_UPDATETIME"));
				class_unitVO.setVideo_status(rs.getInt("VIDEO_STATUS"));
			}


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
		return class_unitVO;
	}

	@Override
	public List<Class_unitVO> getAll() {
		List<Class_unitVO> list = new ArrayList<Class_unitVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Class_unitVO class_unitVO = new Class_unitVO();
				class_unitVO.setUnit_id(rs.getString("UNIT_ID"));
				class_unitVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_unitVO.setUnit_name(rs.getString("UNIT_NAME"));
				class_unitVO.setVideo_long(rs.getString("VIDEO_LONG"));
				class_unitVO.setVideo_updatetime(rs.getTimestamp("VIDEO_UPDATETIME"));
				class_unitVO.setVideo_status(rs.getInt("VIDEO_STATUS"));
				list.add(class_unitVO);
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
		}		return list;
	}

	@Override
	public List<Class_unitVO> getChapter_id(String chapter_id) {
		List<Class_unitVO> list = new ArrayList<Class_unitVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_CHAPTER_ID);
			pstmt.setString(1, chapter_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Class_unitVO class_unitVO = new Class_unitVO();
				class_unitVO.setUnit_id(rs.getString("UNIT_ID"));
				class_unitVO.setChapter_id(rs.getString("CHAPTER_ID"));
				class_unitVO.setUnit_name(rs.getString("UNIT_NAME"));
				class_unitVO.setVideo_long(rs.getString("VIDEO_LONG"));
				class_unitVO.setVideo_updatetime(rs.getTimestamp("VIDEO_UPDATETIME"));
				class_unitVO.setVideo_status(rs.getInt("VIDEO_STATUS"));
				list.add(class_unitVO);
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
		}		return null;
	}

}
