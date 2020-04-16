package com.flower.biz.impl;

import java.util.List;

import com.flower.biz.OrderBiz;
import com.flower.dao.OrderDao;
import com.flower.dao.impl.OrderDaoImpl;
import com.flower.entity.Order;

public class OrderBizImpl implements OrderBiz {
	//创建dao层对象
	OrderDao od=new OrderDaoImpl();

	/**
	 * 查询所有的订单
	 * @return 所有订单信息的集合
	 */
	@Override
	public List<Order> getAllOrder() {
		
		return od.getAllOrder();
	}

	/**
	 * 根据订单的编号查询订单
	 * @param orderNo 订单的编号
	 * @return 订单实体对象
	 */
	@Override
	public Order getOrderByNo(int orderNo) {
		
		return od.getOrderByNo(orderNo);
	}

	/**
	 * 添加订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	@Override
	public int addOrder(Order order) {
		return od.addOrder(order);
	}

	/**
	 * 更新订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	@Override
	public int updateOrder(Order order) {
		return od.updateOrder(order);
	}

	/**
	 * 删除订单
	 * @param orderNo 订单的编号
	 * @return 被影响的行数
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
	 * 根据顾客昵称查询订单信息
	 * @param nickName 顾客的昵称
	 * @return 订单实体对象
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
