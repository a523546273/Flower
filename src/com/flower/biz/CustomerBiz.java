package com.flower.biz;

import java.util.List;

import com.flower.entity.Administrator;
import com.flower.entity.Customer;

public interface CustomerBiz {
	
	
	/**
	 * 顾客登录验证
	 * @param nickname 昵称
	 * @param cpwd 密码
	 * @return 顾客实体对象
	 */
	public Customer login(String nickName,String cPwd);
	
	/**
	 * 用户注册
	 * @param customer
	 * @return 
	 */
	public int register(Customer customer);
	
	/**
	 * 更新顾客信息
	 * @param customer 顾客对象
	 * @return 被影响的行数
	 */
	public int update(Customer customer);
	
	/**
	 * 删除顾客信息
	 * @param customerid 顾客id
	 * @return 受影响的行数
	 */
	public int delete(int customerId);
	
	/**
	 * 分页显示顾客信息
	 * @param pageIndex 页面索引 
	 * @param pageSize 页面行数
	 * @return 顾客信息集合
	 */
	 public List<Customer> getCustomerByPage(int pageIndex,int pageSize);
	 
	 /**
	  * 查询所有顾客数量
	  * @return 顾客数量
	  */
	 public int getCustomerCount();
	 
	 /**
	  * 根据页面行数查询页面数量
	  * @param pageSize 页面行数
	  * @return 页面数量
	  */
	 public int getCustomerPageCount(int pageSize);
	
	 /**
		 * 根据登录名进行精确查询
		 * @param name 顾客的姓名
		 * @return 顾客信息的集合
		 */
	public Customer getCusByName(String nickName);
	
	 /**
	  * 根据顾客编号查询顾客信息 
	  * @param customerId 顾客编号
	  * @return 顾客信息实体
	  */
	 public Customer getCustomerById(int customerId);
	 
	 /**
		 * 修改用户信息没有头像
		 * @param customer 顾客对象
		 * @return 受影响的行数
		 */
		public int updateCusNotImg(Customer customer);
		
		 /**
		  * 根据顾客昵称和现居住地分页显示顾客信息
		  * @param nickName 顾客昵称
		  * @param address 现居住地
		  * @param pageIndex 页面索引
		  * @param pageSize 页面行数
		  * @return 顾客信息集合
		  */
		 public List<Customer> getCustomerByNickNameAndAddress(String nickName,String address,int pageIndex,int pageSize);
		 
		 /**
		  * 根据顾客昵称和现居住地模糊查询顾客数量
		  * @param nickName 顾客昵称
		  * @param address 现居住地
		  * @return 顾客数量
		  */
		 public int getCustomerCountByNickNameAndAddress(String nickName,String address);
		 
		 /**
		  * 根据顾客昵称、现居住地和页面行数迷糊查询页面数量
		  * @param nickName 顾客昵称
		  * @param address 现居住地
		  * @param pageSize 页面行数
		  * @return 页面数量
		  */
		 public int getCustomerPageCountByNickNameAndAddress(String nickName,String address,int pageSize);
	}

