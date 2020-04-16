package com.flower.dao;

import java.util.List;

import com.flower.entity.Flower;

public interface FlowerDao {
	/**
	 * 获取所有花的信息的集合
	 * @return 所有花的信息的集合
	 */
	public List<Flower> getAllFlower();
	
	/**
	 * 获取所有花的信息的集合根据价格降序排序
	 * @return 所有花的信息的集合根据价格降序排序
	 */
	public List<Flower> getAllFlowerByPrice();
	
	/**
	 * 获取所有花的信息的集合根据销量降序排序
	 * @return 所有花的信息的集合根据销量降序排序
	 */
	public List<Flower> getAllFlowerBysold();
	
	/**
	 * 根据花的 编号查询花的信息
	 * @param flowerid 花的编号
	 * @return  花的实体对象
	 */
	public Flower getFlowerById(int flowerId);
	
	/**
	 * 根据花的种类查询花的信息
	 * @param flowername 花的名称
	 * @return 花的实体对象
	 */
	public List<Flower> getFlowerByName(String flowerName);
	
	/**
	 * 更新花的信息
	 * @param flower 花的对象
	 * @return 受影响的行数
	 */
	public int update(Flower flower);
	
	/**
	 * 删除花的信息
	 * @param flowerid 花的id
	 * @return 受影响的行数
	 */
	public int delete(int flowerId);
	
	/**
	 * 增加花的信息
	 * @param flower 花的对象
	 * @return 被影响的行数
	 */
	public int addFlower(Flower flower);
	
	/**
	 * 根据种类和花名的信息
	 * @param flowerName  花名
	 * @param description  描述
	 * @return 花信息的集合
	 */
	public List<Flower> getByName(String flowerName,String description);
	
	/**
	 * 根据种类分页查询花的信息
	 * @param flowerName 花名
	 * @param pageIndex 页面索引
	 * @param pageSize 页面行数
	 * @return 花的信息集合
	 */
	public List<Flower> getFlowerByPage(String flowerName,int pageIndex,int pageSize);
	
	/**
	 * 根据种类查询花的数量
	 * @param flowerName 花名
	 * @return 花的数量
	 */
	public int getFlowerCount(String flowerName);
	
	/**
	 * 根据页面行数查询页面数量
	 * @param flowerName 花名
	 * @param pageSize 页面行数
	 * @return 页面数量
	 */
	public int getFlowerPageCount(String flowerName,int pageSize);
	
	/**
	 * 根据花的价格查询花的信息  分页显示
	 * @param mix
	 * @param max
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Flower> getFlowerByPrice(int mix,int max,int pageIndex,int pageSize);

	/**
	 *  根据花的品种和名称精确查询花信息
	 * @param flowerName 花的品种
	 * @param description 花的名称
	 * @return 花的信息实体
	 */
	public Flower getFlowerByName(String flowerName,String description);
	
	/**
	 * 根据花的名字模糊查询
	 * @param description 花名
	 * @return 花的实体对象
	 */
	public List<Flower> getFlowerByDescription(String description,int pageIndex,int pageSize);
	
	/**
	 * 根据花的品种和名称分页查询花的信息
	 * @param flowerName 花的品种
	 * @param description 花的名称
	 * @param pageIndex 页面索引
	 * @param pageSize 页面行数
	 * @return 花的信息集合
	 */
	public List<Flower> getFlowerByNameAndDescription(String flowerName,String description,int pageIndex,int pageSize);
	
	/**
	 * 根据花的品种和花名模糊查询花的数量
	 * @param flowerName 花的品种
	 * @param description 花的名称
	 * @return 花的数量
	 */
	public int getFlowerCountByNameAndDescription(String flowerName,String description);
	
	/**
	 * 根据花的品种、花名和页面行数模糊查询页面数量
	 * @param flowerName 花的品种
	 * @param description 花名
	 * @param pageSize 页面行数
	 * @return 页面数量
	 */
	public int getFlowerPageCountByNameAndDescription(String flowerName,String description,int pageSize);
	
	
	/**
	 * 根据页容量和花的价格区间查询总页数
	 * @param pageSize 页容量
	 * @param min 最低价格
	 * @param max 最高价格
	 * @return 总页数
	 */
	public int getFlowerByPrice(int pageSize,int min,int max);
	
	
	/**
	 * 根据花的名字和页容量查询总页数
	 * @param Description 花的名字
	 * @param pageSize 页容量
	 * @return 总页数
	 */
	public int getFlowerPageCountByDescription(String Description,int pageSize);
	
	
	
}
