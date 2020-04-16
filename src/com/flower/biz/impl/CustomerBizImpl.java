package com.flower.biz.impl;

import java.sql.Date;
import java.util.List;

import com.flower.biz.CustomerBiz;
import com.flower.dao.CustomerDao;
import com.flower.dao.impl.CustomerDaoImpl;
import com.flower.entity.Customer;

public class CustomerBizImpl implements CustomerBiz {
	//����dao�����
	CustomerDao cusDao=new CustomerDaoImpl();
	/**
	 * �˿͵�¼��֤
	 * @param nickname �ǳ�
	 * @param cpwd ����
	 * @return �˿�ʵ�����
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
	 * �û�ע��
	 * @param customer
	 * @return 
	 */
	@Override
	public int register(Customer customer) {
		Customer cu=cusDao.getCusByName(customer.getNickName());
		if(cu==null){
		int res=cusDao.addCustomer(customer);
		if(res>0){
			return 1;//û�鵽���û���ע��ɹ�
		}else{
			return 2;//û�鵽���û�����ע��ʧ��
		}
		}else{
			return 3;//�鵽�˸ù˿� ����ע��
		}
	}
	
	/**
	 * ���¹˿���Ϣ
	 * @param customer �˿Ͷ���
	 * @return ��Ӱ�������
	 */
	@Override
	public int update(Customer customer) {
		
		return cusDao.update(customer);
	}
	
	/*
	 * ����	
	 * // TODO Auto-generated method stub	
	 	
	public static void main(String[] args) {
		Date date=new Date(1993, 4, 2);
		CustomerBiz cBiz=new CustomerBizImpl();
		Customer customer=new Customer(101, "�Ż�", "123", "Ů", "����", date, "1334567346", "���պϷ�", "����",null,null);
		int res=cBiz.update(customer);
		System.out.println(res);
	}
*/
	/**
	 * ɾ���˿���Ϣ
	 * @param customerid �˿�id
	 * @return ��Ӱ�������
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
