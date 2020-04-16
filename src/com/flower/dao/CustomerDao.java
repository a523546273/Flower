package com.flower.dao;

import java.util.List;

import com.flower.entity.Customer;

public interface CustomerDao {
	/**
	 * ������й˿���Ϣ�ļ���
	 * @return ���й˿���Ϣ�ļ���
	 */
	public List<Customer> getAllCustomer();
	
	
	
	/**
	 * ���ݵ�¼�����о�ȷ��ѯ
	 * @param name �˿͵�����
	 * @return �˿���Ϣ�ļ���
	 */
	public Customer getCusByName(String nickname);
	
	
	
	
	
	/**
	 * ���ݵ�¼������ģ����ѯ
	 * @param name �˿͵�����
	 * @return �˿���Ϣ�ļ���
	 */
	
	public List<Customer> getCustomerByName(String nickname);
	
	/**
	 * ���ӹ˿���Ϣ
	 * @param customer �˿���Ϣ
	 * @return ��Ӱ�������
	 */
	public int addCustomer(Customer customer);
	
	/**
	 * �޸��û���Ϣ
	 * @param customer �˿Ͷ���
	 * @return ��Ӱ�������
	 */
	public int update(Customer customer);
	
	/**
	 * �޸��û���Ϣû��ͷ��
	 * @param customer �˿Ͷ���
	 * @return ��Ӱ�������
	 */
	public int updateCusNotImg(Customer customer);
	/**
	 * ɾ���˿���Ϣ
	 * @param customerid �˿�id
	 * @return ��Ӱ�������
	 */
	public int delete(int customerid);

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
	  * ���ݹ˿ͱ�Ų�ѯ�˿���Ϣ 
	  * @param customerId �˿ͱ��
	  * @return �˿���Ϣʵ��
	  */
	 public Customer getCustomerById(int customerId);
	 
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
