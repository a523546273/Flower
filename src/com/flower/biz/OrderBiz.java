package com.flower.biz;

import java.util.List;

import com.flower.entity.Order;

public interface OrderBiz {
	
	/**
	 * ��ѯ���еĶ���
	 * @return ���ж�����Ϣ�ļ���
	 */
	public List<Order> getAllOrder();
	
	/**
	 * ���ݶ����ı�Ų�ѯ����
	 * @param orderNo �����ı��
	 * @return ����ʵ�����
	 */
	public  Order getOrderByNo(int orderNo);
	
	/**
	 * ��Ӷ���
	 * @param order ��������
	 * @return ��Ӱ�������
	 */
	public int addOrder(Order order);
	
	/**
	 * ���¶���
	 * @param order ��������
	 * @return ��Ӱ�������
	 */
	public int updateOrder(Order order);
	
	/**
	 * ɾ������
	 * @param orderNo �����ı��
	 * @return ��Ӱ�������
	 */
	public int deleteOrder(int orderNo);
	
	/**
	 * ��ҳ��ʾ������Ϣ
	 * @param pageIndex ҳ������
	 * @param pageSize ҳ������
	 * @return ������Ϣ����
	 */
	public List<Order> getOrderByPage(int pageIndex,int pageSize);
	
	/**
	 * ��ѯ���ж�������
	 * @return ��������
	 */
	public int getOrderCount();
	
	/**
	 * ����ҳ��������ѯҳ������
	 * @param pageSize ҳ������
	 * @return ҳ������
	 */
	public int getOrderPageCount(int pageSize);
	
	/**
	 * ���ݹ˿��ǳƲ�ѯ������Ϣ
	 * @param nickName �˿͵��ǳ�
	 * @return ����ʵ�����
	 */
	public List<Order> getOrderByNickName(String nickName);

	/**
	 * ���ݶ�����ź͹˿��ǳƷ�ҳ��ѯ������Ϣ
	 * @param orderNo �������
	 * @param nickName �˿��ǳ�
	 * @param pageIndex ҳ������
	 * @param pageSize ҳ������
	 * @return ������Ϣ����
	 */
	public List<Order> getOrderByIdAndNickName(int orderNo,String nickName,int pageIndex,int pageSize);
	
	/**
	 * ���ݶ�����ź͹˿��ǳƲ�ѯ��������
	 * @param orderNo �������
	 * @param nickName �˿��ǳ�
	 * @return ��������
	 */
	public int getOrderCountByIdAndNickName(int orderNo,String nickName);
	
	/**
	 * ���ݶ�����š��˿��ǳƺ�ҳ��������ѯҳ������
	 * @param orderNo �������
	 * @param nickName �˿��ǳ�
	 * @param pageSize ҳ������
	 * @return ҳ������
	 */
	public int getOrderPageCountByIdAndNickName(int orderNo,String nickName,int pageSize);
	/**
	 * ����ҳ��������ҳ��������ѯҳ������
	 * @param pageSize ҳ������
	 * @param orderCount ҳ������
	 * @return ҳ������
	 */
	public int getOrderPageCount2(int pageSize,int orderCount);
	
	/**
	 * ���ݻ��ı�Ų�ѯ����
	 * @param flowerId ���ı��
	 * @return ����
	 */
	public List<Order> getOrderByFlowerId(int flowerId);
}

