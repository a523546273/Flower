package com.flower.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.flower.DBUtils.DBUtils;
import com.flower.dao.AdministratorDao;
import com.flower.entity.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	DBUtils dbu = new DBUtils();

	/**
	 * ��ѯ���еĹ���Ա��Ϣ
	 * @return ����Ա��Ϣ�ļ���
	 */
	@Override
	public List<Administrator> getAllAdmin() {
		List<Administrator> list = new ArrayList<Administrator>();
		String sql = "select adminid, loginname, loginpwd, gender, birthday,"
				+ " address, phone, email, mibao, answer from administrator";

		list = this.getAdminBySql(sql);
		return list;
	}
	
	/*
	 * ��װ�Ĳ�ѯ����
	 */
	private List<Administrator> getAdminBySql(String sql, Object... obj) {
		List<Administrator> list = new ArrayList<Administrator>();
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i + 1, obj[i]);
				}
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Administrator admin = new Administrator();
				admin.setAdminId(rs.getInt("adminid"));
				admin.setLoginName(rs.getString("loginname"));
				admin.setLoginPwd(rs.getString("loginpwd"));
				admin.setAddress(rs.getString("address"));
				admin.setAnswer(rs.getString("answer"));
				admin.setBirthday(rs.getDate("birthday"));
				admin.setEmail(rs.getString("email"));
				admin.setGender(rs.getString("gender"));
				admin.setMiBao(rs.getString("miBao"));
				admin.setPhone(rs.getString("phone"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}
	
	/**
	  * ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	  * @return ����Աʵ��
	  */
	@Override
	public Administrator getAdminById(int adminid) {
		List<Administrator> list = new ArrayList<Administrator>();
		Administrator admin=new Administrator();
		String sql="select adminid, loginname, loginpwd, gender, birthday, address,"
				+ " phone, email, mibao, answer from administrator where adminid=?";
		list = this.getAdminBySql(sql, adminid);
		if (list.size() > 0) {
			admin = list.get(0);
			return admin;
		} else {
			return null;
		}
	}

	/**
	  * ��������Ա
	  * @param administrator ����Աʵ�����
	  * @return ��Ӱ�������
	  */
	@Override
	public int addAdmin(Administrator admin) {
		String sql=" insert into administrator(adminid, loginname, loginpwd,"
				+ " gender, birthday, address, phone, email, mibao, answer) "
				+ "values(admin_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Object obj[]={admin.getLoginName(),admin.getLoginPwd(),
				admin.getGender(),admin.getBirthday(),
				admin.getAddress(),admin.getPhone(),
				admin.getEmail(),admin.getMiBao(),
				admin.getAnswer()
		};
		return dbu.executeUpdate(sql, obj);
	}
	/**
	  * ���ݹ���Ա��¼��  ��ѯ����Ա��Ϣ
	  * @param loginName ����Ա��¼��
	  * @return ����Աʵ�����
	  */
	@Override
	public Administrator getAdminByLoginName(String loginName) {
		
		Administrator admin=new Administrator();
     String sql="select adminid, loginname, loginpwd, gender, birthday,"
				+ " address, phone, email, mibao, answer from administrator"
				+ " where loginname= ? ";
     List<Administrator> list =	this.getAdminBySql(sql, loginName);
     
     if(list.size()>0){
    	 admin=list.get(0);
    	 return admin;
     }else
		return null;
	}
	/*
	 * ���Է���
	 */
	public static void main(String[] args) {
		AdministratorDao ad=new AdministratorDaoImpl();
		Administrator admin=ad.getAdminByLoginName("������");
		System.out.println(admin.getLoginName());
	}

	@Override
	public int updateAdmin(Administrator admin) {
		String sql=" update administrator set "
				+ " loginpwd = ?,gender = ?,"
				+ " birthday = ?, address = ?, phone = ?,"
				+ " email = ?,mibao = ?,answer = ? where loginname = ?";
		Object obj[]={admin.getLoginPwd(),
				admin.getGender(),admin.getBirthday(),
				admin.getAddress(),admin.getPhone(),
				admin.getEmail(),admin.getMiBao(),
				admin.getAnswer(),admin.getLoginName()
		};
		return dbu.executeUpdate(sql, obj);
		
	}	
	
	
	
	

}
