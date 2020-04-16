package com.flower.biz.impl;



import java.util.List;

import com.flower.biz.AdministratorBiz;
import com.flower.dao.AdministratorDao;
import com.flower.dao.impl.AdministratorDaoImpl;
import com.flower.entity.Administrator;

public class AdministratorBizImpl implements AdministratorBiz {
	//����dao�����
	AdministratorDao ad=new AdministratorDaoImpl();

	/**
	 * ����Ա��¼
	 * @param loginName ����Ա��¼��
	 * @param loginPwd ����Ա����
	 * @return ����Աʵ�����
	 */
	@Override
	public Administrator login(String loginName, String loginPwd) {
		
		Administrator admin=ad.getAdminByLoginName(loginName);
		
		if (admin!=null&&admin.getLoginPwd().equals(loginPwd)) {
			
			return admin;
			
		}else{
			return null;
		}
	}
	
	

	/**
	 * ��������Ա��Ϣ(ע��)
	 * @param administrator ����Աʵ�����
	 * @return ��Ӱ�������
	 */
	@Override
	public int register(Administrator administrator) {
		Administrator admin=ad.getAdminByLoginName(administrator.getLoginName());
		
		if(admin==null){
			int res=ad.addAdmin(administrator);
			if (res>0) {
				return 1;//û�鵽�ù���Ա��ע��ɹ�
			}else{
				return 2;//û�鵽�ù���Ա����ע��ʧ��
			}
		}
	return 3;//�鵽�˸ù���Ա����ע��
	}



	@Override
	public int updateAdmin(Administrator administrator) {
		return ad.updateAdmin(administrator);
	}



	@Override
	public Administrator getAdminByLoginName(String loginName) {
		return ad.getAdminByLoginName(loginName);
	}



	@Override
	public Administrator getAdminById(int adminid) {
		return ad.getAdminById(adminid);
	}
	


}
