package com.flower.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flower.DBUtils.DBUtils;
import com.flower.dao.FlowerDao;
import com.flower.entity.Flower;

public class FlowerDaoImpl implements FlowerDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	DBUtils dbu = new DBUtils();

	/**
	 * ��ȡ���л�����Ϣ�ļ���
	 * 
	 * @return ���л�����Ϣ�ļ���
	 */
	@Override
	public List<Flower> getAllFlower() {
		List<Flower> list = new ArrayList<Flower>();
		String sql = "select flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description from flower";
		list = this.getFlowerBySql(sql);

		return list;
	}

	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 * 
	 * @return ���л�����Ϣ�ļ��ϸ��ݼ۸�������
	 */
	@Override
	public List<Flower> getAllFlowerByPrice() {
		List<Flower> list = new ArrayList<Flower>();
		String sql = "select flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description from flower order by price desc";
		list = this.getFlowerBySql(sql);

		return list;
	}

	/**
	 * ��ȡ���л�����Ϣ�ļ��ϸ���������������
	 * 
	 * @return ���л�����Ϣ�ļ��ϸ���������������
	 */
	@Override
	public List<Flower> getAllFlowerBysold() {
		List<Flower> list = new ArrayList<Flower>();
		String sql = "select flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description from flower order by stock desc";
		list = this.getFlowerBySql(sql);

		return list;
	}

	/**
	 * ���ݻ��� ��Ų�ѯ������Ϣ
	 * 
	 * @param flowerid
	 *            ���ı��
	 * @return ����ʵ�����
	 */
	@Override
	public Flower getFlowerById(int flowerId) {
		List<Flower> list = new ArrayList<Flower>();
		Flower flower = new Flower();
		String sql = "select flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description from flower where flowerid=?";
		list = this.getFlowerBySql(sql, flowerId);

		if (list.size() > 0) {
			flower = list.get(0);
			return flower;
		} else {
			return null;
		}
	}

	/**
	 * ���ݻ��������ѯ������Ϣ
	 * 
	 * @param flowername
	 *            ��������
	 * @return ����ʵ�����
	 */
	@Override
	public List<Flower> getFlowerByName(String flowerName) {
		List<Flower> list = new ArrayList<Flower>();
		Flower flower = new Flower();
		String sql = "select flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, "
				+ " description from flower where flowername like '%' ||?|| '%'";
		list = this.getFlowerBySql(sql, flowerName);

		if (list.size() > 0) {

			return list;
		} else {
			return null;
		}
	}

	/**
	 * ��ѯ��װ�ķ���
	 * 
	 * @param sql
	 *            sql���
	 * @param obj
	 *            �ɱ����
	 * @return ����Ϣ�ļ���
	 */
	private List<Flower> getFlowerBySql(String sql, Object... obj) {
		List<Flower> list = new ArrayList<Flower>();
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					pstmt.setObject(i + 1, obj[i]);
				}
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Flower flower = new Flower();
				flower.setFlowerId(rs.getInt("flowerid"));
				flower.setFlowerName(rs.getString("flowername"));
				flower.setPrice(rs.getDouble("price"));
				flower.setStock(rs.getInt("stock"));
				flower.setSold(rs.getInt("sold"));
				flower.setFlowerimg1(rs.getString("flowerimg1"));
				flower.setFlowerimg2(rs.getString("flowerimg2"));
				flower.setDescription(rs.getString("description"));
				list.add(flower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}

	/**
	 * ���»�����Ϣ
	 * 
	 * @param flower
	 *            ���Ķ���
	 * @return ��Ӱ�������
	 */
	@Override
	public int update(Flower flower) {
		String sql = " update flower set flowername = ?,price = ?, "
				+ " stock = ?,sold = ?,description = ? where flowerid = ?";
		Object obj[] = { flower.getFlowerName(), flower.getPrice(),
				flower.getStock(), flower.getSold(), flower.getDescription(),
				flower.getFlowerId() };
		return dbu.executeUpdate(sql, obj);
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param flowerid
	 *            ���ı��
	 * @return ��Ӱ�������
	 */
	@Override
	public int delete(int flowerId) {
		String sql = "delete flower where flowerid = ?";
		return dbu.executeUpdate(sql,flowerId);
	}

	/**
	 * ���ӻ�����Ϣ
	 * 
	 * @param flower
	 *            ���Ķ���
	 * @return ��Ӱ�������
	 */
	@Override
	public int addFlower(Flower flower) {
		String sql = " insert into flower(flowerid, flowername, price, stock, "
				+ " sold, flowerimg1,flowerimg2, description ) values ( FLOWER_SEQ.Nextval, "
				+ " ?, ?, ?, ?, ?, ?��?) ";
		Object obj[] = { flower.getFlowerName(), flower.getPrice(),
				flower.getStock(), flower.getSold(), flower.getFlowerimg1(),
				flower.getFlowerimg2(), flower.getDescription() };

		int res = dbu.executeUpdate(sql, obj);
		return res;
	}

	/*
	 * ����
	 
	public static void main(String[] args) {
		FlowerDao fd = new FlowerDaoImpl();
		Flower flower = new Flower(1, "��ɫ����", 200.5, 20, 5, "����", "����", "�ʺ�������");
		int i = fd.addFlower(flower);
		System.out.println(i);

	}*/

	/**
	 * ���ݻ�����������ѯ
	 * 
	 * @param flowerName
	 *            ����
	 * @param description
	 *            ����
	 * @return ����Ϣ�ļ���
	 */
	@Override
	public List<Flower> getByName(String flowerName, String description) {
		List<Flower> list = new ArrayList<Flower>();
		StringBuilder sb = new StringBuilder();
		sb.append("select flowerid, flowername, price, stock, sold, flowerimg1, description, flowerimg2 from flower where 1=1 ");
		List<Object> obj = new ArrayList<Object>();
		if (flowerName.length() > 0 && flowerName != null) {
			sb.append(" and flowername like '%'||?||'%' ");
			obj.add(flowerName);
		}
		if (description.length() > 0 && description != null) {
			sb.append(" and description like '%'||?||'%' ");
			obj.add(description);
		}
		if (obj.size() <= 0) {
			sb.append(" and 1=2 ");
		}
		list = this.getFlowerBySql(sb.toString(), obj.toArray());
		return list;
	}

	/**
	 * ���ݻ�����ҳ��ѯ������Ϣ
	 * 
	 * @param flowerName
	 *            ����
	 * @param pageIndex
	 *            ҳ������
	 * @param pageSize
	 *            ҳ������
	 * @return ������Ϣ����
	 */
	public List<Flower> getFlowerByPage(String flowerName, int pageIndex,
			int pageSize) {
		List<Flower> list = new ArrayList<Flower>();
		StringBuffer sb=new StringBuffer();
		sb.append(" select f.flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description ");
		sb.append(" from flower f, ");
		sb.append(" (select rownum rn,flowerid from flower ");
		
		if(flowerName!=null){
			sb.append(" where flowername like '%'||?||'%' ");
		}
		sb.append(") f2 ");
		sb.append(" where f.flowerid=f2.flowerid ");
		sb.append(" and f2.rn <= ");
		sb.append(pageIndex*pageSize);
		sb.append(" and f2.rn>= ");
		sb.append((pageIndex-1)*pageSize+1);
		
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			if(flowerName!=null){
				
				pstmt.setString(1, flowerName);
			}
			rs = pstmt.executeQuery();
			
				while (rs.next()) {
					Flower flower = new Flower();
					flower.setFlowerId(rs.getInt("flowerid"));
					flower.setFlowerName(rs.getString("flowername"));
					flower.setPrice(rs.getDouble("price"));
					flower.setStock(rs.getInt("stock"));
					flower.setSold(rs.getInt("sold"));
					flower.setFlowerimg1(rs.getString("flowerimg1"));
					flower.setFlowerimg2(rs.getString("flowerimg2"));
					flower.setDescription(rs.getString("description"));
					list.add(flower);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;

	}

	@Override
	public int getFlowerCount(String flowerName) {
		StringBuffer sb =new StringBuffer();
		sb.append("select count(0) flowerCount from flower where 1=1");
		int flowerCount=0;
		if(flowerName!=null){
			sb.append(" and flowerName=?");
		}
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			if(flowerName!=null){
				pstmt.setString(1, flowerName);
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				flowerCount=rs.getInt("flowerCount");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		return flowerCount;
	}

	@Override
	public int getFlowerPageCount(String flowerName,int pageSize) {
		int flowerCount=getFlowerCount(flowerName);
		if(flowerCount%pageSize==0){
			return flowerCount/pageSize;
		}else{
			return flowerCount/pageSize+1;
		}
		
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
		List<Flower> list = new ArrayList<Flower>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select f.flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description ");
		sb.append(" from flower f, ");
		sb.append(" (select rownum rn,flowerid from flower ");
		sb.append(" where price>= ");
		sb.append(mix);
		sb.append(" and price <=");
		sb.append(max);
		sb.append(") f2 ");
		sb.append(" where f.flowerid=f2.flowerid ");
		sb.append(" and f2.rn <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" and f2.rn>= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			rs = pstmt.executeQuery();
			
				while (rs.next()) {
					Flower flower = new Flower();
					flower.setFlowerId(rs.getInt("flowerid"));
					flower.setFlowerName(rs.getString("flowername"));
					flower.setPrice(rs.getDouble("price"));
					flower.setStock(rs.getInt("stock"));
					flower.setSold(rs.getInt("sold"));
					flower.setFlowerimg1(rs.getString("flowerimg1"));
					flower.setFlowerimg2(rs.getString("flowerimg2"));
					flower.setDescription(rs.getString("description"));
					list.add(flower);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;

	}
	
	@Override
	public Flower getFlowerByName(String flowerName, String description) {
		Flower flower=new Flower();
		StringBuilder sb=new StringBuilder();
		sb.append("select flowerid, flowername, price, stock, sold, flowerimg1, description, flowerimg2 from flower where 1=1 ");
			sb.append(" and flowername = ? ");
			sb.append(" and description = ? ");
		conn = dbu.getConn();
		int i=0;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, flowerName);
			pstmt.setString(2, description);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				
				flower.setFlowerId(rs.getInt("flowerid"));
				flower.setFlowerName(rs.getString("flowername"));
				flower.setPrice(rs.getDouble("price"));
				flower.setStock(rs.getInt("stock"));
				flower.setSold(rs.getInt("sold"));
				flower.setFlowerimg1(rs.getString("flowerimg1"));
				flower.setFlowerimg2(rs.getString("flowerimg2"));
				flower.setDescription(rs.getString("description"));
				i=1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		if(i==0){
			return null;
			}else{
		return flower;}
	}
/*
	public static void main(String[] args) {
		FlowerDao fd=new FlowerDaoImpl();
		List<Flower> list=fd.getFlowerByDescription("ף��", 1, 16);
		System.out.println(list.size());
	}
	*/
	/**
	 * ���ݻ�������ģ����ѯ
	 * @param description ����
	 * @return ����ʵ�����
	 */
	@Override
	public List<Flower> getFlowerByDescription(String description,int pageIndex,int pageSize) {
		List<Flower> list = new ArrayList<Flower>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select f.flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description ");
		sb.append(" from flower f, ");
		sb.append(" (select rownum rn,flowerid from flower ");
		sb.append(" where description like  '%'||?||'%' ");
		sb.append(") f2 ");
		sb.append(" where f.flowerid=f2.flowerid ");
		sb.append(" and f2.rn <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" and f2.rn>= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, description);
			rs = pstmt.executeQuery();
				while (rs.next()) {
					Flower flower = new Flower();
					flower.setFlowerId(rs.getInt("flowerid"));
					flower.setFlowerName(rs.getString("flowername"));
					flower.setPrice(rs.getDouble("price"));
					flower.setStock(rs.getInt("stock"));
					flower.setSold(rs.getInt("sold"));
					flower.setFlowerimg1(rs.getString("flowerimg1"));
					flower.setFlowerimg2(rs.getString("flowerimg2"));
					flower.setDescription(rs.getString("description"));
					list.add(flower);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
		
	}

	@Override
	public List<Flower> getFlowerByNameAndDescription(String flowerName,
			String description, int pageIndex, int pageSize) {
		List<Flower> list = new ArrayList<Flower>();
		StringBuffer sb = new StringBuffer();
		sb.append(" select f.flowerid, flowername, price, stock, sold, flowerimg1,flowerimg2, description ");
		sb.append(" from flower f, ");
		sb.append(" (select rownum rn,ff.flowerid from flower ff where 1=1 ");
		List<Object> obj = new ArrayList<Object>();
		if (flowerName !=null&&(!flowerName.equals("null"))) {
			sb.append(" and ff.flowerName like '%'||?||'%' ");
			obj.add(flowerName);
		}
		if (description !=null&&(!description.equals("null"))) {
			sb.append(" and ff.description like '%'||?||'%' ");
			obj.add(description);
		}
		
		sb.append(") f2 ");
		sb.append(" where f.flowerid=f2.flowerid ");
		sb.append(" and f2.rn <= ");
		sb.append(pageIndex * pageSize);
		sb.append(" and f2.rn>= ");
		sb.append((pageIndex - 1) * pageSize + 1);
		
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			for (int i = 0; i < obj.size(); i++) {
				pstmt.setObject(i + 1, obj.get(i));
			}
			rs = pstmt.executeQuery();
				while (rs.next()) {
					Flower flower = new Flower();
					flower.setFlowerId(rs.getInt("flowerid"));
					flower.setFlowerName(rs.getString("flowername"));
					flower.setPrice(rs.getDouble("price"));
					flower.setStock(rs.getInt("stock"));
					flower.setSold(rs.getInt("sold"));
					flower.setFlowerimg1(rs.getString("flowerimg1"));
					flower.setFlowerimg2(rs.getString("flowerimg2"));
					flower.setDescription(rs.getString("description"));
					list.add(flower);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}

	@Override
	public int getFlowerCountByNameAndDescription(String flowerName,
			String description) {
		StringBuffer sb =new StringBuffer();
		sb.append("select count(0) flowerCount from flower ff where 1=1 ");
		int flowerCount=0;
		List<Object> obj = new ArrayList<Object>();
		if (flowerName !=null&&(!flowerName.equals("null"))) {
			sb.append(" and ff.flowerName like '%'||?||'%' ");
			obj.add(flowerName);
		}
		if (description !=null&&(!description.equals("null"))) {
			sb.append(" and ff.description like '%'||?||'%' ");
			obj.add(description);
		}
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			for (int i = 0; i < obj.size(); i++) {
				pstmt.setObject(i + 1, obj.get(i));
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				flowerCount=rs.getInt("flowerCount");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		return flowerCount;
	}

	@Override
	public int getFlowerPageCountByNameAndDescription(String flowerName,
			String description, int pageSize) {
		int flowerCount=getFlowerCountByNameAndDescription(flowerName, description);
		if(flowerCount%pageSize==0){
			return flowerCount/pageSize;
		}else{
			return flowerCount/pageSize+1;
		}
	}

	/**
	 * ����ҳ�����ͻ��ļ۸������ѯ��ҳ��
	 * @param pageSize ҳ����
	 * @param min ��ͼ۸�
	 * @param max ��߼۸�
	 * @return ��ҳ��
	 */
	@Override
	public int getFlowerByPrice(int pageSize, int min, int max) {
		StringBuilder sb=new StringBuilder();
		sb.append("select count(0) flowerCount from flower where price> = ");
		sb.append(min);
		sb.append(" and price <= ");
		sb.append(max);
		conn = dbu.getConn();
		int flowerCount=0;
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			if(rs.next()){
				flowerCount=rs.getInt("flowerCount");
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		if(flowerCount%pageSize==0){
			return flowerCount/pageSize;
		}else{
			return flowerCount/pageSize+1;
		}
		
	}

	@Override
	public int getFlowerPageCountByDescription(String description, int pageSize) {
		String sql="select count(0) flowerCount from flower where Description like '%'||?||'%'";
		conn = dbu.getConn();
		int flowerCount=0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, description);
			rs = pstmt.executeQuery();
			if(rs.next()){
				flowerCount=rs.getInt("flowerCount");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		if(flowerCount%pageSize==0){
			return flowerCount/pageSize;
		}else{
			return flowerCount/pageSize+1;
		}
		
	}

	
	

	}
