package com.flower.biz;

import com.flower.entity.Administrator;

public interface AdministratorBiz {
	
	/**
	 * 管理员登录
	 * @param loginName 管理员登录名
	 * @param loginPwd 管理员密码
	 * @return 管理员实体对象
	 */
	public Administrator login(String loginName,String loginPwd);
	
	/**
	 * 新增管理员信息
	 * @param administrator 管理员实体对象
	 * @return 被影响的行数
	 */
	public int register(Administrator administrator);
	
	/**
	  * 更新管理员信息
	  * @param administrator 管理员
	  * @return 受影响行数
	  */
	 public int updateAdmin(Administrator administrator);
	 
	 /**
	  * 根据管理员登录名  查询管理员信息
	  * @param loginName 管理员登录名
	  * @return 管理员实体对象
	  */
	 public Administrator getAdminByLoginName(String loginName);
	 /**
	  * 根据管理员编号查询管理员信息
	  * @return 管理员实体
	  */
	 public Administrator getAdminById(int adminid);

}
