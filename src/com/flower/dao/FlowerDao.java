package com.flower.dao;

import java.util.List;

import com.flower.entity.Flower;

public interface FlowerDao {
	/**
	 * ��ȡ���л�����Ϣ�ļ���
	 * @return ���л�����Ϣ�ļ���
	 */
	public List<Flower> getAllFlower();
	
	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 * @return ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 */
	public List<Flower> getAllFlowerByPrice();
	
	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ���������������
	 * @return ���л�����Ϣ�ļ��ϸ���������������
	 */
	public List<Flower> getAllFlowerBysold();
	
	/**
	 * ���ݻ��� ��Ų�ѯ������Ϣ
	 * @param flowerid ���ı��
	 * @return  ����ʵ�����
	 */
	public Flower getFlowerById(int flowerId);
	
	/**
	 * ���ݻ��������ѯ������Ϣ
	 * @param flowername ��������
	 * @return ����ʵ�����
	 */
	public List<Flower> getFlowerByName(String flowerName);
	
	/**
	 * ���»�����Ϣ
	 * @param flower ���Ķ���
	 * @return ��Ӱ�������
	 */
	public int update(Flower flower);
	
	/**
	 * ɾ��������Ϣ
	 * @param flowerid ����id
	 * @return ��Ӱ�������
	 */
	public int delete(int flowerId);
	
	/**
	 * ���ӻ�����Ϣ
	 * @param flower ���Ķ���
	 * @return ��Ӱ�������
	 */
	public int addFlower(Flower flower);
	
	/**
	 * ��������ͻ�������Ϣ
	 * @param flowerName  ����
	 * @param description  ����
	 * @return ����Ϣ�ļ���
	 */
	public List<Flower> getByName(String flowerName,String description);
	
	/**
	 * ���������ҳ��ѯ������Ϣ
	 * @param flowerName ����
	 * @param pageIndex ҳ������
	 * @param pageSize ҳ������
	 * @return ������Ϣ����
	 */
	public List<Flower> getFlowerByPage(String flowerName,int pageIndex,int pageSize);
	
	/**
	 * ���������ѯ��������
	 * @param flowerName ����
	 * @return ��������
	 */
	public int getFlowerCount(String flowerName);
	
	/**
	 * ����ҳ��������ѯҳ������
	 * @param flowerName ����
	 * @param pageSize ҳ������
	 * @return ҳ������
	 */
	public int getFlowerPageCount(String flowerName,int pageSize);
	
	/**
	 * ���ݻ��ļ۸��ѯ������Ϣ  ��ҳ��ʾ
	 * @param mix
	 * @param max
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Flower> getFlowerByPrice(int mix,int max,int pageIndex,int pageSize);

	/**
	 *  ���ݻ���Ʒ�ֺ����ƾ�ȷ��ѯ����Ϣ
	 * @param flowerName ����Ʒ��
	 * @param description ��������
	 * @return ������Ϣʵ��
	 */
	public Flower getFlowerByName(String flowerName,String description);
	
	/**
	 * ���ݻ�������ģ����ѯ
	 * @param description ����
	 * @return ����ʵ�����
	 */
	public List<Flower> getFlowerByDescription(String description,int pageIndex,int pageSize);
	
	/**
	 * ���ݻ���Ʒ�ֺ����Ʒ�ҳ��ѯ������Ϣ
	 * @param flowerName ����Ʒ��
	 * @param description ��������
	 * @param pageIndex ҳ������
	 * @param pageSize ҳ������
	 * @return ������Ϣ����
	 */
	public List<Flower> getFlowerByNameAndDescription(String flowerName,String description,int pageIndex,int pageSize);
	
	/**
	 * ���ݻ���Ʒ�ֺͻ���ģ����ѯ��������
	 * @param flowerName ����Ʒ��
	 * @param description ��������
	 * @return ��������
	 */
	public int getFlowerCountByNameAndDescription(String flowerName,String description);
	
	/**
	 * ���ݻ���Ʒ�֡�������ҳ������ģ����ѯҳ������
	 * @param flowerName ����Ʒ��
	 * @param description ����
	 * @param pageSize ҳ������
	 * @return ҳ������
	 */
	public int getFlowerPageCountByNameAndDescription(String flowerName,String description,int pageSize);
	
	
	/**
	 * ����ҳ�����ͻ��ļ۸������ѯ��ҳ��
	 * @param pageSize ҳ����
	 * @param min ��ͼ۸�
	 * @param max ��߼۸�
	 * @return ��ҳ��
	 */
	public int getFlowerByPrice(int pageSize,int min,int max);
	
	
	/**
	 * ���ݻ������ֺ�ҳ������ѯ��ҳ��
	 * @param Description ��������
	 * @param pageSize ҳ����
	 * @return ��ҳ��
	 */
	public int getFlowerPageCountByDescription(String Description,int pageSize);
	
	
	
}
