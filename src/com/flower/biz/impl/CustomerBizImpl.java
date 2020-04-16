package com.flower.biz.impl;

import java.sql.Date;
import java.util.List;

import com.flower.biz.CustomerBiz;
import com.flower.dao.CustomerDao;
import com.flower.dao.impl.CustomerDaoImpl;
import com.flower.entity.Customer;

public class CustomerBizImpl implements CustomerBiz {
	//创建dao层对象
	CustomerDao cusDao=new CustomerDaoImpl();
	/**
	 * 顾客登录验证
	 * @param nickname 昵称
	 * @param cpwd 密码
	 * @return 顾客实体对象
	 */
	@Override
	public Customer login(String nickName, String cPwd) {
		Customer customer=new Customer();
		customer=cusDao.getCusByName(nickName);
		
		if(customer!=null&&customer.getcPwd().equals(cPwd)){
			return customer;
		}else{
			return null;
		  }
	    }
	
	/**
	 * 用户注册
	 * @param customer
	 * @return 
	 */
	@Override
	public int register(Customer customer) {
		Customer cu=cusDao.getCusByName(customer.getNickName());
		if(cu==null){
		int res=cusDao.addCustomer(customer);
		if(res>0){
			return 1;//没查到该用户能注册成功
		}else{
			return 2;//没查到该用户但是注册失败
		}
		}else{
			return 3;//查到了该顾客 不能注册
		}
	}
	
	/**
	 * 更新顾客信息
	 * @param customer 顾客对象
	 * @return 被影响的行数
	 */
	@Override
	public int update(Customer customer) {
		
		return cusDao.update(customer);
	}
	
	/*
	 * 测试	
	 * // TODO Auto-generated method stub	
	 	
	public static void main(String[] args) {
		Date date=new Date(1993, 4, 2);
		CustomerBiz cBiz=new CustomerBizImpl();
		Customer customer=new Customer(101, "张欢", "123", "女", "王五", date, "1334567346", "安徽合肥", "暂无",null,null);
		int res=cBiz.update(customer);
		System.out.println(res);
	}
*/
	/**
	 * 删除顾客信息
	 * @param customerid 顾客id
	 * @return 受影响的行数
	 */
	@Override
	public int delete(int customerId) {
		
		return cusDao.delete(customerId);
		
	}

	@Override
	public List<Customer> getCustomerByPage(int pageIndex, int pageSize) {
		
		return cusDao.getCustomerByPage(pageIndex, pageSize);
	}

	@Override
	public int getCustomerCount() {
		return cusDao.getCustomerCount();
	}

	@Override
	public int getCustomerPageCount(int pageSize) {
		return cusDao.getCustomerPageCount(pageSize);
	}

	@Override
	public Customer getCusByName(String nickName) {
		return cusDao.getCusByName(nickName);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return cusDao.getCustomerById(customerId);
	}

	@Override
	public int updateCusNotImg(Customer customer) {
		return cusDao.updateCusNotImg(customer);
	}

	@Override
	public List<Customer> getCustomerByNickNameAndAddress(String nickName,
			String address, int pageIndex, int pageSize) {
		return cusDao.getCustomerByNickNameAndAddress(nickName, address, pageIndex, pageSize);
	}

	@Override
	public int getCustomerCountByNickNameAndAddress(String nickName,
			String address) {
		return cusDao.getCustomerCountByNickNameAndAddress(nickName, address);
	}

	@Override
	public int getCustomerPageCountByNickNameAndAddress(String nickName,
			String address, int pageSize) {
		return cusDao.getCustomerPageCountByNickNameAndAddress(nickName, address, pageSize);
	}
	
	
     }
