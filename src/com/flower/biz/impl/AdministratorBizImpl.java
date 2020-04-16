package com.flower.biz.impl;



import java.util.List;

import com.flower.biz.AdministratorBiz;
import com.flower.dao.AdministratorDao;
import com.flower.dao.impl.AdministratorDaoImpl;
import com.flower.entity.Administrator;

public class AdministratorBizImpl implements AdministratorBiz {
	//创建dao层对象
	AdministratorDao ad=new AdministratorDaoImpl();

	/**
	 * 管理员登录
	 * @param loginName 管理员登录名
	 * @param loginPwd 管理员密码
	 * @return 管理员实体对象
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
	 * 新增管理员信息(注册)
	 * @param administrator 管理员实体对象
	 * @return 被影响的行数
	 */
	@Override
	public int register(Administrator administrator) {
		Administrator admin=ad.getAdminByLoginName(administrator.getLoginName());
		
		if(admin==null){
			int res=ad.addAdmin(administrator);
			if (res>0) {
				return 1;//没查到该管理员能注册成功
			}else{
				return 2;//没查到该管理员但是注册失败
			}
		}
	return 3;//查到了该管理员不能注册
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
