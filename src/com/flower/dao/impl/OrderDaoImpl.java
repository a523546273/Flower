package com.flower.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flower.DBUtils.DBUtils;
import com.flower.biz.CustomerBiz;
import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.dao.OrderDao;
import com.flower.entity.Administrator;
import com.flower.entity.Customer;
import com.flower.entity.Flower;
import com.flower.entity.Order;

public class OrderDaoImpl implements OrderDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	DBUtils dbu = new DBUtils();
	
	/**
	 * 查询所有的订单
	 * @return 所有订单信息的集合
	 */
	@Override
	public List<Order> getAllOrder() {
		List<Order> list=new ArrayList<Order>();
		String sql="select orderno, corder.customerid, corder.flowerid, buynumber, total, "
				+ " corder.phone,creationtime, orderaddress,corder.stateid, state, price,nickname, "
				+ " flowername,description from corder,customer,flower,orderstate where corder.customerid= "
				+ " customer.customerid and corder.stateid=orderstate.stateid and corder.flowerid=flower.flowerid "
				+ " order by creationtime desc";
		list=this.getOrderBySql(sql);
		
		return list;
	}
	

	/**
	 * 根据订单的编号查询订单
	 * @param orderNo 订单的编号
	 * @return 订单实体对象
	 */
	@Override
	public Order getOrderByNo(int orderNo) {
		Order order=new Order();
			List<Order> list=new ArrayList<Order>();
			String sql="select orderno, corder.customerid,corder.stateid, corder.flowerid, buynumber, total, "
					+ " corder.phone,creationtime, orderaddress, state, price,nickname,flowerimg1, "
					+ " corder.phone,creationtime, orderaddress, state, price,nickname,flowerimg1 ,"
					+ " flowername,description from corder,customer,flower,orderstate where corder.customerid= "
					+ " customer.customerid and corder.stateid=orderstate.stateid"
					+ " and corder.flowerid=flower.flowerid and "
					+ " orderno= ? ";
			list=this.getOrderBySql(sql,orderNo);
			if(list.size()>0){
				order=list.get(0);
				return order;
			}
		return null;
	}
	/*
	 * 测试
	 */

	

	/**
	 * 添加订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	@Override
	public int addOrder(Order order) {
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
	      
         String datetime=df.format(new Date());
         
		int fid=order.getFlowerId();
		FlowerBiz fBiz=new FlowerBizImpl();
		
		Flower flower=fBiz.getFlowerById(fid);
		
		String sql="insert into corder(orderno, customerid, flowerid, buynumber, "
				+ " creationtime, orderaddress, stateid, total,phone) values (ORDER_SEQ.Nextval,"
				+ " ?, ?, ?, sysdate, ?, ?, ?, ?)";
		if (order.getBuyNumber()<=flower.getStock()) {
			Object obj[]={order.getCustomerId(),order.getFlowerId(),order.getBuyNumber(),
					order.getOrderAddress(),order.getStateId(),
					(order.getBuyNumber())*(flower.getPrice()),order.getPhone()};
			return dbu.executeUpdate(sql, obj);
		}else{
			System.out.println("库存不足");
			return 0;
		}
		
		
		
	}
	
	

	/**
	 * 更新订单
	 * @param order 订单对象
	 * @return 被影响的行数
	 */
	@Override
	public int updateOrder(Order order) {
		String sql="update corder set stateId=? where orderNo=?";
		Object obj[]={order.getStateId(),order.getOrderNo()};
		return dbu.executeUpdate(sql, obj);
	}

	
	/**
	 * 删除订单
	 * @param orderNo 订单的编号
	 * @return 被影响的行数
	 */
	@Override
	public int deleteOrder(int orderNo) {
		String sql="delete corder where orderno = ?";
		
		return dbu.executeUpdate(sql, orderNo);
	}
	
	//封装了一个查询的方法
	private List<Order> getOrderBySql(String sql, Object... obj) {
		List<Order> list = new ArrayList<Order>();
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
				Order order =new Order();
				order.setOrderNo(rs.getInt("orderno"));
				order.setCustomerId(rs.getInt("customerid"));
				order.setFlowerId(rs.getInt("flowerid"));
				order.setBuyNumber(rs.getInt("buynumber"));
				order.setCreationTime(rs.getDate("creationtime"));
				order.setStateId(rs.getInt("stateid"));
				order.setOrderAddress(rs.getString("orderaddress"));
				order.setPhone(rs.getString("phone"));
				if (isExistColumn(rs, "state")) {
					order.setState(rs.getString("state"));
				}
				if (isExistColumn(rs, "nickname")) {
					order.setNickName(rs.getString("nickname"));
				}
				if (isExistColumn(rs, "flowername")) {
					order.setFlowerName(rs.getString("flowername"));
				}
				if (isExistColumn(rs, "price")) {
					order.setPrice(rs.getDouble("price"));
				}
				if (isExistColumn(rs, "flowerimg1")) {
					order.setFlowerimg1(rs.getString("flowerimg1"));
				}
				if (isExistColumn(rs, "description")) {
					order.setDescription(rs.getString("description"));
				}
				
				order.setTotal((rs.getInt("buynumber"))*(rs.getDouble("price")));//不能这样写
				
				list.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}
	
	private boolean isExistColumn(ResultSet rs,String columname){
		try {
			if (rs.findColumn(columname)>0) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		return false;
	}


	@Override
	public List<Order> getOrderByPage(int pageIndex, int pageSize) {
		List<Order> list = new ArrayList<Order>();
		StringBuffer sb=new StringBuffer();
		sb.append(" select o.orderno, o.customerid, o.flowerid, ");
		sb.append(" buynumber,o.phone, total, creationtime, orderaddress, ");
		sb.append(" o.stateid, state, price,nickname, flowername,description ");
		sb.append(" from corder o,customer c,flower f,orderstate os, ");
		sb.append(" (select rownum rn,orderno from corder) oo ");
		sb.append(" where o.customerid= c.customerid(+) and o.stateid=os.stateid(+) ");
		sb.append(" and o.flowerid=f.flowerid(+) and oo.ORDERNO=o.orderno ");
		sb.append(" and oo.rn>= ");
		sb.append((pageIndex-1)*pageSize+1);
		sb.append(" and oo.rn<= ");
		sb.append(pageIndex*pageSize);
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order =new Order();
				order.setOrderNo(rs.getInt("orderno"));
				order.setCustomerId(rs.getInt("customerid"));
				order.setFlowerId(rs.getInt("flowerid"));
				order.setBuyNumber(rs.getInt("buynumber"));
				order.setCreationTime(rs.getDate("creationtime"));
				order.setStateId(rs.getInt("stateid"));
				order.setOrderAddress(rs.getString("orderaddress"));
				if (isExistColumn(rs, "state")) {
					order.setState(rs.getString("state"));
				}
				if (isExistColumn(rs, "nickname")) {
					order.setNickName(rs.getString("nickname"));
				}
				if (isExistColumn(rs, "flowername")) {
					order.setFlowerName(rs.getString("flowername"));
				}
				if (isExistColumn(rs, "price")) {
					order.setPrice(rs.getDouble("price"));
				}
				if (isExistColumn(rs, "description")) {
					order.setDescription(rs.getString("description"));
				}
				order.setTotal((rs.getInt("buynumber"))*(rs.getDouble("price")));//不能这样写
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}


	@Override
	public int getOrderCount() {
		String sql="select count(0) orderCount from corder";
		int orderCount=0;
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {	
				orderCount=rs.getInt("orderCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return orderCount;
	}


	@Override
	public int getOrderPageCount(int pageSize) {
		int orderCount=getOrderCount();
		if(orderCount%pageSize==0){
			return orderCount/pageSize;
		}else{
			return orderCount/pageSize+1;
		}
	}
	public int getOrderPageCount2(int pageSize,int orderCount) {
		
		if(orderCount%pageSize==0){
			return orderCount/pageSize;
		}else{
			return orderCount/pageSize+1;
		}
	}

	/**
	 * 根据顾客昵称查询订单信息
	 * @param nickName 顾客的昵称
	 * @return 订单实体对象
	 */
	@Override
	public List<Order> getOrderByNickName(String nickName) {
		
		List<Order> list=new ArrayList<Order>();
		String sql="select orderno, corder.customerid,corder.stateid, corder.flowerid, buynumber, total, "
				+ " corder.phone,creationtime, orderaddress, state, price,nickname,flowerimg1, "
				+ " corder.phone,creationtime, orderaddress, state, price,nickname,flowerimg1 ,"
				+ " flowername,description from corder,customer,flower,orderstate where corder.customerid= "
				+ " customer.customerid and corder.stateid=orderstate.stateid"
				+ " and corder.flowerid=flower.flowerid and "
				+ " customer.nickname= ? order by creationtime desc";
		list=this.getOrderBySql(sql,nickName);
		return list;
	}
public static void main(String[] args) {
	OrderDao od=new OrderDaoImpl();
	List<Order> list=od.getOrderByNickName("小王") ;
	System.out.println(list.size());
}

	@Override
	public List<Order> getOrderByIdAndNickName(int orderNo, String nickName,
			int pageIndex, int pageSize) {
		List<Order> list = new ArrayList<Order>();
		StringBuffer sb=new StringBuffer();
		sb.append(" select o.orderno, o.customerid, o.flowerid, ");
		sb.append(" buynumber,o.phone, total, creationtime, orderaddress, ");
		sb.append(" o.stateid, state, price,nickname, flowername,description ");
		sb.append(" from corder o,customer c,flower f,orderstate os, ");
		sb.append(" (select rownum rn,orderno from corder co,customer cc where co.customerid=cc.customerid ");
		
		List<Object> obj = new ArrayList<Object>();
		if (orderNo!=0) {
			sb.append(" and co.orderNo = ? ");
			obj.add(orderNo);
		}
		if (nickName!=null && (!nickName.equals("null"))) {
			sb.append(" and cc.nickName like '%'||?||'%' ");
			obj.add(nickName);
		}
		
		sb.append(" order by creationtime desc) oo ");
		sb.append(" where o.customerid= c.customerid(+) and o.stateid=os.stateid(+) ");
		sb.append(" and o.flowerid=f.flowerid(+) and oo.ORDERNO=o.orderno ");
		sb.append(" and oo.rn>= ");
		sb.append((pageIndex-1)*pageSize+1);
		sb.append(" and oo.rn<= ");
		sb.append(pageIndex*pageSize);
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sb.toString());
			for (int i = 0; i < obj.size(); i++) {
				pstmt.setObject(i + 1, obj.get(i));
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order =new Order();
				order.setOrderNo(rs.getInt("orderno"));
				order.setCustomerId(rs.getInt("customerid"));
				order.setFlowerId(rs.getInt("flowerid"));
				order.setBuyNumber(rs.getInt("buynumber"));
				order.setCreationTime(rs.getDate("creationtime"));
				order.setStateId(rs.getInt("stateid"));
				order.setOrderAddress(rs.getString("orderaddress"));
				if (isExistColumn(rs, "state")) {
					order.setState(rs.getString("state"));
				}
				if (isExistColumn(rs, "nickname")) {
					order.setNickName(rs.getString("nickname"));
				}
				if (isExistColumn(rs, "flowername")) {
					order.setFlowerName(rs.getString("flowername"));
				}
				if (isExistColumn(rs, "price")) {
					order.setPrice(rs.getDouble("price"));
				}
				if (isExistColumn(rs, "description")) {
					order.setDescription(rs.getString("description"));
				}
				order.setTotal((rs.getInt("buynumber"))*(rs.getDouble("price")));
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	
	}


	@Override
	public int getOrderCountByIdAndNickName(int orderNo, String nickName) {
		StringBuffer sb=new StringBuffer();
		sb.append("select count(0) orderCount from corder o,customer c where o.customerid=c.customerid ");
		List<Object> obj = new ArrayList<Object>();
		if (orderNo!=0) {
			sb.append(" and o.orderNo = ? ");
			obj.add(orderNo);
		}
		if (nickName!=null && (!nickName.equals("null"))) {
			sb.append(" and c.nickName like '%'||?||'%' ");
			obj.add(nickName);
		}
		conn = dbu.getConn();
		int orderCount=0;
		try {
			pstmt = conn.prepareStatement(sb.toString());
			for (int i = 0; i < obj.size(); i++) {
				pstmt.setObject(i + 1, obj.get(i));
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				orderCount=rs.getInt("orderCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}
		return orderCount;
	}


	@Override
	public int getOrderPageCountByIdAndNickName(int orderNo, String nickName,
			int pageSize) {
		int orderCount=getOrderCountByIdAndNickName(orderNo, nickName);
		if(orderCount%pageSize==0){
			return orderCount/pageSize;
		}else{
			return orderCount/pageSize+1;
		}
	}


	@Override
	public List<Order> getOrderByFlowerId(int flowerId) {
		String sql="select orderno, customerid, flowerid, buynumber,"
				+ " creationtime, orderaddress, stateid, total, phone"
				+ " from corder where flowerId=?";
		List<Order> list = new ArrayList<Order>();
		conn = dbu.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, flowerId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order order =new Order();
				order.setOrderNo(rs.getInt("orderno"));
				order.setCustomerId(rs.getInt("customerid"));
				order.setFlowerId(rs.getInt("flowerid"));
				order.setBuyNumber(rs.getInt("buynumber"));
				order.setCreationTime(rs.getDate("creationtime"));
				order.setStateId(rs.getInt("stateid"));
				order.setOrderAddress(rs.getString("orderaddress"));
				
				
				
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}	
	
	
	
	

}
