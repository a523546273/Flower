package com.flower.dao;

import java.util.List;

import com.flower.entity.Administrator;

public interface AdministratorDao {
	/**
	 * 查询所有的管理员信息
	 * @return 管理员信息的集合
	 */
	 public List<Administrator> getAllAdmin();
	 
	 
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
	 
	 /**
	  * 新增管理员
	  * @param administrator 管理员实体对象
	  * @return 被影响的行数
	  */
	 public int addAdmin(Administrator administrator);
	 
	 /**
	  * 更新管理员信息
	  * @param administrator 管理员
	  * @return 受影响行数
	  */
	 public int updateAdmin(Administrator administrator);
	 
	

}
