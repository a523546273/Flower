package com.flower.DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtils {
	public static Properties properties = null;
	public static Connection conn = null;
	public static ResultSet rs = null;
	public static PreparedStatement pstm = null;


	public DBUtils() {
		// ��ȡ�����ļ�
		initProperties();

	}

	/**
	 * ��ȡ�����ļ� �����driver��url
	 */
	public void initProperties() {
		properties = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/db.properties");
		try {
			properties.load(in);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public  Connection getConn() {
		Connection connection = null;
		try {
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(
					properties.getProperty("url"),
					properties.getProperty("user"),
					properties.getProperty("pwd"));
		} catch (Exception err) {
			System.out.println("����ConDB-->getCon()____JDBC����!");
			err.printStackTrace();
			return null;
		}
		return connection;
	}

	/**
	 * �ر�������Դ
	 * 
	 * @param rs
	 *            �����
	 * @param pstmt
	 *            ������� ִ��sql�����ߴ洢����
	 * @param conn
	 *            ���Ӷ���
	 */
	public  void closeAll(ResultSet rs, PreparedStatement ps,
			Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �ر�����
	public void closeAll(PreparedStatement ps, Connection con) {
		try {

			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��װ������ɾ����
	 * 
	 * @param sql
	 *            SQL���
	 * @param obj
	 *            �ɱ�Ĳ���
	 * @return Ӱ�������
	 */
	public  int executeUpdate(String sql, Object... obj) {
		int result = 0;
		conn =getConn();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ����SQL�������Ĳ���
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject((i + 1), obj[i]);
				}
			}
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	

}
