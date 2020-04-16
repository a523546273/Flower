package com.flower.biz.impl;

import java.util.List;

import com.flower.biz.FlowerBiz;
import com.flower.dao.FlowerDao;
import com.flower.dao.impl.FlowerDaoImpl;
import com.flower.entity.Flower;

public class FlowerBizImpl implements FlowerBiz {
	//����dao��
	FlowerDao fd=new FlowerDaoImpl();
	/**
	 * ��ȡ���л�����Ϣ�ļ���
	 * @return ���л�����Ϣ�ļ���
	 */
	@Override
	public List<Flower> getAllFlower() {
		
		return fd.getAllFlower();
	}
	
	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 * @return ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 */
	@Override
	public List<Flower> getAllFlowerByPrice() {
		
		return fd.getAllFlowerByPrice();
	}
	
	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ���������������
	 * @return ���л�����Ϣ�ļ��ϸ���������������
	 */
	@Override
	public List<Flower> getAllFlowerBysold() {

		return fd.getAllFlowerBysold();
	}
	
	/**
	 * ���ݻ��� ��Ų�ѯ������Ϣ
	 * @param flowerid ���ı��
	 * @return  ����ʵ�����
	 */
	@Override
	public Flower getFlowerById(int flowerid) {

		return fd.getFlowerById(flowerid);
	}
	
	/**
	 * ���ݻ�������ģ����ѯ������Ϣ
	 * @param flowername ��������
	 * @return ����ʵ�����
	 */
	@Override
	public List<Flower> getFlowerByName(String flowername) {

		return fd.getFlowerByName(flowername);
	}
	
	/**
	 * ���»�����Ϣ
	 * @param flower ���Ķ���
	 * @return ��Ӱ�������
	 */
	@Override
	public int update(Flower flower) {

		return fd.update(flower);
	}
	
	/**
	 * ɾ��������Ϣ
	 * @param flowerid ����id
	 * @return ��Ӱ�������
	 */
	@Override
	public int delete(int flowerid) {

		return fd.delete(flowerid);
	}

	/**
	 * ���ӻ�����Ϣ
	 * @param flower ���Ķ���
	 * @return ��Ӱ�������
	 */
	@Override
	public int addFlower(Flower flower) {
		
		return fd.addFlower(flower);
	}

	
	/**
	 * ���ݻ�����������ѯ������Ϣ
	 * @param flowerName  ����
	 * @param description  ����
	 * @return ����Ϣ�ļ���
	 */
	@Override
	public List<Flower> getByName(String flowerName, String description) {
		
		return fd.getByName(flowerName, description);
	}

	/**
	 * ���ݻ�����ҳ��ѯ������Ϣ
	 * @param flowerName ����
	 * @param pageIndex ҳ������
	 * @param pageSize ҳ������
	 * @return ������Ϣ����
	 */
	public List<Flower> getFlowerByPage(String flowerName, int pageIndex,
			int pageSize) {
		return fd.getFlowerByPage(flowerName, pageIndex, pageSize);
	}

	/**
	 * ���ݻ�����ѯ��������
	 * @param flowerName ����
	 * @return ��������
	 */
	public int getFlowerCount(String flowerName) {
		return fd.getFlowerCount(flowerName);
	}

	/**
	 * ����ҳ��������ѯҳ������
	 * @param flowerName ����
	 * @param pageSize ҳ������
	 * @return ҳ������
	 */
	public int getFlowerPageCount(String flowerName, int pageSize) {
		return fd.getFlowerPageCount(flowerName, pageSize);
	}

	
	/**
	 * ���ݻ��ļ۸��ѯ������Ϣ  ��ҳ��ʾ
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
	 * ���ݼ۸�����Ѱ�һ��ļ���
	 * @param min ��ͼ۸�
	 * @param max ��߼۸�
	 * @return ����Ϣ�ļ���
	 */
	@Override
	public int getFlowerByPrice(int pageSize, int min, int max) {
		// TODO Auto-generated method stub
		return fd.getFlowerByPrice(pageSize, min, max);
	}

	
	/**
	 * ���ݻ������ֺ�ҳ������ѯ��ҳ��
	 * @param Description ��������
	 * @param pageSize ҳ����
	 * @return ��ҳ��
	 */
	@Override
	public int getFlowerPageCountByDescription(String Description, int pageSize) {
		return fd.getFlowerPageCountByDescription(Description, pageSize);
	}

	
	
	
}
