package com.flower.biz.impl;

import java.util.List;

import com.flower.biz.FlowerBiz;
import com.flower.dao.FlowerDao;
import com.flower.dao.impl.FlowerDaoImpl;
import com.flower.entity.Flower;

public class FlowerBizImpl implements FlowerBiz {
	//创建dao层
	FlowerDao fd=new FlowerDaoImpl();
	/**
	 * 获取所有花的信息的集合
	 * @return 所有花的信息的集合
	 */
	@Override
	public List<Flower> getAllFlower() {
		
		return fd.getAllFlower();
	}
	
	/**
	 * 获取所有花的信息的集合根据价格降序排序
	 * @return 所有花的信息的集合根据价格降序排序
	 */
	@Override
	public List<Flower> getAllFlowerByPrice() {
		
		return fd.getAllFlowerByPrice();
	}
	
	/**
	 * 获取所有花的信息的集合根据销量降序排序
	 * @return 所有花的信息的集合根据销量降序排序
	 */
	@Override
	public List<Flower> getAllFlowerBysold() {

		return fd.getAllFlowerBysold();
	}
	
	/**
	 * 根据花的 编号查询花的信息
	 * @param flowerid 花的编号
	 * @return  花的实体对象
	 */
	@Override
	public Flower getFlowerById(int flowerid) {

		return fd.getFlowerById(flowerid);
	}
	
	/**
	 * 根据花的名称模糊查询花的信息
	 * @param flowername 花的名称
	 * @return 花的实体对象
	 */
	@Override
	public List<Flower> getFlowerByName(String flowername) {

		return fd.getFlowerByName(flowername);
	}
	
	/**
	 * 更新花的信息
	 * @param flower 花的对象
	 * @return 受影响的行数
	 */
	@Override
	public int update(Flower flower) {

		return fd.update(flower);
	}
	
	/**
	 * 删除花的信息
	 * @param flowerid 花的id
	 * @return 受影响的行数
	 */
	@Override
	public int delete(int flowerid) {

		return fd.delete(flowerid);
	}

	/**
	 * 增加花的信息
	 * @param flower 花的对象
	 * @return 被影响的行数
	 */
	@Override
	public int addFlower(Flower flower) {
		
		return fd.addFlower(flower);
	}

	
	/**
	 * 根据花名和描述查询花的信息
	 * @param flowerName  花名
	 * @param description  描述
	 * @return 花信息的集合
	 */
	@Override
	public List<Flower> getByName(String flowerName, String description) {
		
		return fd.getByName(flowerName, description);
	}

	/**
	 * 根据花名分页查询花的信息
	 * @param flowerName 花名
	 * @param pageIndex 页面索引
	 * @param pageSize 页面行数
	 * @return 花的信息集合
	 */
	public List<Flower> getFlowerByPage(String flowerName, int pageIndex,
			int pageSize) {
		return fd.getFlowerByPage(flowerName, pageIndex, pageSize);
	}

	/**
	 * 根据花名查询花的数量
	 * @param flowerName 花名
	 * @return 花的数量
	 */
	public int getFlowerCount(String flowerName) {
		return fd.getFlowerCount(flowerName);
	}

	/**
	 * 根据页面行数查询页面数量
	 * @param flowerName 花名
	 * @param pageSize 页面行数
	 * @return 页面数量
	 */
	public int getFlowerPageCount(String flowerName, int pageSize) {
		return fd.getFlowerPageCount(flowerName, pageSize);
	}

	
	/**
	 * 根据花的价格查询花的信息  分页显示
	 * @param mix
	 * @param max
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<Flower> getFlowerByPrice(int mix, int max,int pageIndex,int pageSize) {
		
		return fd.getFlowerByPrice(mix, max, pageIndex, pageSize);
	}

	@Override
	public Flower getFlowerByName(String flowerName, String description) {
		return fd.getFlowerByName(flowerName, description);
	}

	@Override
	public List<Flower> getFlowerByDescription(String description,int pageIndex,int pageSize) {
		
		return fd.getFlowerByDescription(description,pageIndex, pageSize);
	}

	@Override
	public List<Flower> getFlowerByNameAndDescription(String flowerName,
			String description, int pageIndex, int pageSize) {
		return fd.getFlowerByNameAndDescription(flowerName, description, pageIndex, pageSize);
	}

	@Override
	public int getFlowerCountByNameAndDescription(String flowerName,
			String description) {
		return fd.getFlowerCountByNameAndDescription(flowerName, description);
	}

	@Override
	public int getFlowerPageCountByNameAndDescription(String flowerName,
			String description, int pageSize) {
		return fd.getFlowerPageCountByNameAndDescription(flowerName, description, pageSize);
	}

	/**
	 * 根据价格区间寻找花的集合
	 * @param min 最低价格
	 * @param max 最高价格
	 * @return 花信息的集合
	 */
	@Override
	public int getFlowerByPrice(int pageSize, int min, int max) {
		// TODO Auto-generated method stub
		return fd.getFlowerByPrice(pageSize, min, max);
	}

	
	/**
	 * 根据花的名字和页容量查询总页数
	 * @param Description 花的名字
	 * @param pageSize 页容量
	 * @return 总页数
	 */
	@Override
	public int getFlowerPageCountByDescription(String Description, int pageSize) {
		return fd.getFlowerPageCountByDescription(Description, pageSize);
	}

	
	
	
}
