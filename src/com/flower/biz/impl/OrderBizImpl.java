package com.flower.biz.impl;

import java.util.List;

import com.flower.biz.OrderBiz;
import com.flower.dao.OrderDao;
import com.flower.dao.impl.OrderDaoImpl;
import com.flower.entity.Order;

public class OrderBizImpl implements OrderBiz {
	//����dao�����
	OrderDao od=new OrderDaoImpl();

	/**
	 * ��ѯ���еĶ���
	 * @return ���ж�����Ϣ�ļ���
	 */
	@Override
	public List<Order> getAllOrder() {
		
		return od.getAllOrder();
	}

	/**
	 * ���ݶ����ı�Ų�ѯ����
	 * @param orderNo �����ı��
	 * @return ����ʵ�����
	 */
	@Override
	public Order getOrderByNo(int orderNo) {
		
		return od.getOrderByNo(orderNo);
	}

	/**
	 * ��Ӷ���
	 * @param order ��������
	 * @return ��Ӱ�������
	 */
	@Override
	public int addOrder(Order order) {
		return od.addOrder(order);
	}

	/**
	 * ���¶���
	 * @param order ��������
	 * @return ��Ӱ�������
	 */
	@Override
	public int updateOrder(Order order) {
		return od.updateOrder(order);
	}

	/**
	 * ɾ������
	 * @param orderNo �����ı��
	 * @return ��Ӱ�������
	 */
	@Override
	public int deleteOrder(int orderNo) {
		return od.deleteOrder(orderNo);
	}

	@Override
	public List<Order> getOrderByPage(int pageIndex, int pageSize) {
		return od.getOrderByPage(pageIndex, pageSize);
	}

	@Override
	public int getOrderCount() {
		return od.getOrderCount();
	}

	@Override
	public int getOrderPageCount(int pageSize) {
		return od.getOrderPageCount(pageSize);
	}

	/**
	 * ���ݹ˿��ǳƲ�ѯ������Ϣ
	 * @param nickName �˿͵��ǳ�
	 * @return ����ʵ�����
	 */
	@Override
	public List<Order> getOrderByNickName(String nickName) {
		
		return od.getOrderByNickName(nickName);
	}

	@Override
	public List<Order> getOrderByIdAndNickName(int orderNo, String nickName,
			int pageIndex, int pageSize) {
		return od.getOrderByIdAndNickName(orderNo, nickName, pageIndex, pageSize);
	}

	@Override
	public int getOrderCountByIdAndNickName(int orderNo, String nickName) {
		return od.getOrderCountByIdAndNickName(orderNo, nickName);
	}

	@Override
	public int getOrderPageCountByIdAndNickName(int orderNo, String nickName,
			int pageSize) {
		return od.getOrderPageCountByIdAndNickName(orderNo, nickName, pageSize);
	}

	@Override
	public int getOrderPageCount2(int pageSize, int orderCount) {
		// TODO Auto-generated method stub
		return od.getOrderPageCount2(pageSize, orderCount);
	}

	@Override
	public List<Order> getOrderByFlowerId(int flowerId) {
		return od.getOrderByFlowerId(flowerId);
	}

}
