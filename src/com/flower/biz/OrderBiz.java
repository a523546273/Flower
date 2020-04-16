package com.flower.biz;

import java.util.List;

import com.flower.entity.Order;

public interface OrderBiz {
	
	/**
	 * 查询所有的订单
	 * @return 所有订单信息的集合
	 */
	public List<Order> getAllOrder();
	
	/**
	 * 根据订单的编号查询订单
	 * @param orderNo 订单的编号
	 * @return 订单实体对象
	 */
	public  Order getOrderByNo(int orderNo);
	
	/**
	 * 添加订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	public int addOrder(Order order);
	
	/**
	 * 更新订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	public int updateOrder(Order order);
	
	/**
	 * 删除订单
	 * @param orderNo 订单的编号
	 * @return 被影响的行数
	 */
	public int deleteOrder(int orderNo);
	
	/**
	 * 分页显示订单信息
	 * @param pageIndex 页面索引
	 * @param pageSize 页面行数
	 * @return 订单信息集合
	 */
	public List<Order> getOrderByPage(int pageIndex,int pageSize);
	
	/**
	 * 查询所有订单数量
	 * @return 订单数量
	 */
	public int getOrderCount();
	
	/**
	 * 根据页面行数查询页面数量
	 * @param pageSize 页面行数
	 * @return 页面数量
	 */
	public int getOrderPageCount(int pageSize);
	
	/**
	 * 根据顾客昵称查询订单信息
	 * @param nickName 顾客的昵称
	 * @return 订单实体对象
	 */
	public List<Order> getOrderByNickName(String nickName);

	/**
	 * 根据订单编号和顾客昵称分页查询订单信息
	 * @param orderNo 订单编号
	 * @param nickName 顾客昵称
	 * @param pageIndex 页面索引
	 * @param pageSize 页面行数
	 * @return 订单信息集合
	 */
	public List<Order> getOrderByIdAndNickName(int orderNo,String nickName,int pageIndex,int pageSize);
	
	/**
	 * 根据订单编号和顾客昵称查询订单数量
	 * @param orderNo 订单编号
	 * @param nickName 顾客昵称
	 * @return 订单数量
	 */
	public int getOrderCountByIdAndNickName(int orderNo,String nickName);
	
	/**
	 * 根据订单编号、顾客昵称和页面行数查询页面数量
	 * @param orderNo 订单编号
	 * @param nickName 顾客昵称
	 * @param pageSize 页面行数
	 * @return 页面数量
	 */
	public int getOrderPageCountByIdAndNickName(int orderNo,String nickName,int pageSize);
	/**
	 * 根据页面索引和页面行数查询页面数量
	 * @param pageSize 页面索引
	 * @param orderCount 页面行数
	 * @return 页面数量
	 */
	public int getOrderPageCount2(int pageSize,int orderCount);
	
	/**
	 * 根据花的编号查询订单
	 * @param flowerId 花的编号
	 * @return 订单
	 */
	public List<Order> getOrderByFlowerId(int flowerId);
}

