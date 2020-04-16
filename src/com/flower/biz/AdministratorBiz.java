package com.flower.biz;

import com.flower.entity.Administrator;

public interface AdministratorBiz {
	
	/**
	 * ����Ա��¼
	 * @param loginName ����Ա��¼��
	 * @param loginPwd ����Ա����
	 * @return ����Աʵ�����
	 */
	public Administrator login(String loginName,String loginPwd);
	
	/**
	 * ��������Ա��Ϣ
	 * @param administrator ����Աʵ�����
	 * @return ��Ӱ�������
	 */
	public int register(Administrator administrator);
	
	/**
	  * ���¹���Ա��Ϣ
	  * @param administrator ����Ա
	  * @return ��Ӱ������
	  */
	 public int updateAdmin(Administrator administrator);
	 
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

}
