package com.flower.dao;

import java.util.List;

import com.flower.entity.Administrator;

public interface AdministratorDao {
	/**
	 * ��ѯ���еĹ���Ա��Ϣ
	 * @return ����Ա��Ϣ�ļ���
	 */
	 public List<Administrator> getAllAdmin();
	 
	 
	 /**
	  * ���ݹ���Ա��¼��  ��ѯ����Ա��Ϣ
	  * @param loginName ����Ա��¼��
	  * @return ����Աʵ�����
	  */
	 public Administrator getAdminByLoginName(String loginName);
	 /**
	  * ���ݹ���Ա��Ų�ѯ����Ա��Ϣ
	  * @return ����Աʵ��
	  */
	 public Administrator getAdminById(int adminid);
	 
	 /**
	  * ��������Ա
	  * @param administrator ����Աʵ�����
	  * @return ��Ӱ�������
	  */
	 public int addAdmin(Administrator administrator);
	 
	 /**
	  * ���¹���Ա��Ϣ
	  * @param administrator ����Ա
	  * @return ��Ӱ������
	  */
	 public int updateAdmin(Administrator administrator);
	 
	

}
