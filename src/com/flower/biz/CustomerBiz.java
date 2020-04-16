package com.flower.biz;

import java.util.List;

import com.flower.entity.Administrator;
import com.flower.entity.Customer;

public interface CustomerBiz {
	
	
	/**
	 * �˿͵�¼��֤
	 * @param nickname �ǳ�
	 * @param cpwd ����
	 * @return �˿�ʵ�����
	 */
	public Customer login(String nickName,String cPwd);
	
	/**
	 * �û�ע��
	 * @param customer
	 * @return 
	 */
	public int register(Customer customer);
	
	/**
	 * ���¹˿���Ϣ
	 * @param customer �˿Ͷ���
	 * @return ��Ӱ�������
	 */
	public int update(Customer customer);
	
	/**
	 * ɾ���˿���Ϣ
	 * @param customerid �˿�id
	 * @return ��Ӱ�������
	 */
	public int delete(int customerId);
	
	/**
	 * ��ҳ��ʾ�˿���Ϣ
	 * @param pageIndex ҳ������ 
	 * @param pageSize ҳ������
	 * @return �˿���Ϣ����
	 */
	 public List<Customer> getCustomerByPage(int pageIndex,int pageSize);
	 
	 /**
	  * ��ѯ���й˿�����
	  * @return �˿�����
	  */
	 public int getCustomerCount();
	 
	 /**
	  * ����ҳ��������ѯҳ������
	  * @param pageSize ҳ������
	  * @return ҳ������
	  */
	 public int getCustomerPageCount(int pageSize);
	
	 /**
		 * ���ݵ�¼�����о�ȷ��ѯ
		 * @param name �˿͵�����
		 * @return �˿���Ϣ�ļ���
		 */
	public Customer getCusByName(String nickName);
	
	 /**
	  * ���ݹ˿ͱ�Ų�ѯ�˿���Ϣ 
	  * @param customerId �˿ͱ��
	  * @return �˿���Ϣʵ��
	  */
	 public Customer getCustomerById(int customerId);
	 
	 /**
		 * �޸��û���Ϣû��ͷ��
		 * @param customer �˿Ͷ���
		 * @return ��Ӱ�������
		 */
		public int updateCusNotImg(Customer customer);
		
		 /**
		  * ���ݹ˿��ǳƺ��־�ס�ط�ҳ��ʾ�˿���Ϣ
		  * @param nickName �˿��ǳ�
		  * @param address �־�ס��
		  * @param pageIndex ҳ������
		  * @param pageSize ҳ������
		  * @return �˿���Ϣ����
		  */
		 public List<Customer> getCustomerByNickNameAndAddress(String nickName,String address,int pageIndex,int pageSize);
		 
		 /**
		  * ���ݹ˿��ǳƺ��־�ס��ģ����ѯ�˿�����
		  * @param nickName �˿��ǳ�
		  * @param address �־�ס��
		  * @return �˿�����
		  */
		 public int getCustomerCountByNickNameAndAddress(String nickName,String address);
		 
		 /**
		  * ���ݹ˿��ǳơ��־�ס�غ�ҳ�������Ժ���ѯҳ������
		  * @param nickName �˿��ǳ�
		  * @param address �־�ס��
		  * @param pageSize ҳ������
		  * @return ҳ������
		  */
		 public int getCustomerPageCountByNickNameAndAddress(String nickName,String address,int pageSize);
	}

