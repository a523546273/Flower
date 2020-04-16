package com.flower.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flower.DBUtils.DBUtils;
import com.flower.dao.CustomerDao;
import com.flower.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	DBUtils dbu = new DBUtils();
	/**
	 * 获得所有顾客信息的集合
	 * @return 所有顾客信息的集合
	 */
	@Override
	public List<Customer> getAllCustomer() {
		String sql="select customerid, nickname, cpwd, gender, cname, "
				+ " phone, address, headimg,mibao,answer from customer";
		List<Customer> list=this.getCustomerBySql(sql);
		
		return list;
	}
	
	
	//封装了查询的方法
	private List<Customer> getCustomerBySql(String sql, Object... obj) {
		List<Customer> list = new ArrayList<Customer>();
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
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("customerid"));
				customer.setNickName(rs.getString("nickname"));
				customer.setcPwd(rs.getString("cpwd"));
				customer.setGender(rs.getString("gender"));
				customer.setcName(rs.getString("cname"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setHeadimg(rs.getString("headimg"));
				customer.setMiBao(rs.getString("mibao"));
				customer.setAnswer(rs.getString("answer"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbu.closeAll(rs, pstmt, conn);
		}

		return list;
	}

	/**
	 * 修改用户信息
	 * @param customer 顾客对象
	 * @return 受影响的行数
	 */
	@Override
	public int update(Customer customer) {
		String sql="update customer set nickname = ?,cpwd = ?,"
				+ " gender = ?,cname = ?,phone = ?,"
				+ " address = ?,headimg = ?,mibao=?,answer=? where customerid = ? ";
		Object obj[]={customer.getNickName(),customer.getcPwd(),customer.getGender(),
				customer.getcName(),customer.getPhone(),
				customer.getAddress(),customer.getHeadimg(),
				customer.getMiBao(),customer.getAnswer(),customer.getCustomerId()};
		int res=dbu.executeUpdate(sql, obj);
		
		return res;
	}
	


/**
 * 根据登录名进行模糊查询
 * @param name 顾客的姓名
 * @return 顾客信息的集合
 */
@Override
public List<Customer> getCustomerByName(String nickName) {
	List<Customer> list = new ArrayList<Customer>();
	String sql="select customerid, nickname, cpwd, gender, cname, "
			+ " phone, address, headimg,mibao,answer from customer where nickname like '%' ||?|| '%'";
	list=this.getCustomerBySql(sql, nickName);
	if(list.size()>0){
	return this.getCustomerBySql(sql, nickName);
	}else
		return null;
}	
	


 
/*public static void main(String[] args) {
	List<Customer> list = new ArrayList<Customer>();
	CustomerDao cd=new CustomerDaoImpl();
	list=cd.getCustomerByPage(1, 10);
	for (Customer customer : list) {
		System.out.println(customer.getCName());
	}
		

}*/

/**
 * 根据登录名进行精确查询
 * @param name 顾客的姓名
 * @return 顾客信息的集合
 */
@Override
public Customer getCusByName(String nickName) {
	List<Customer> list = new ArrayList<Customer>();
	Customer customer=new Customer();
	String sql="select customerid, nickname, cpwd, gender, cname, "
			+ " phone, address, headimg,mibao,answer from customer where nickname = ? ";
	list=this.getCustomerBySql(sql,nickName);
	if(list.size()>0){
		customer=list.get(0);
		return customer;
	}else{
		return null;
	}
	
}

/**
 * 增加顾客信息
 * @param customer 顾客信息
 * @return 被影响的行数
 */
@Override
public int addCustomer(Customer customer) {
	String sql=" insert into customer(customerid, nickname, cpwd, gender, cname, "
			+ "  phone, address, headimg,mibao,answer) values (CUSTOMER_SEQ.Nextval, "
			+ " ?, ?, ?, ?, ?, "
			+ " ?, ?, ?,?)";
	Object obj[]={customer.getNickName(),customer.getcPwd(),customer.getGender(),
			customer.getcName(),customer.getPhone(),
			customer.getAddress(),customer.getHeadimg(),customer.getMiBao(),
			customer.getAnswer()};
	
	return dbu.executeUpdate(sql, obj);
}

/**
 * 删除顾客信息
 * @param customerid 顾客id
 * @return 受影响的行数
 */
@Override
public int delete(int customerId) {
	String sql=" delete customer where customerid = ? ";
	return dbu.executeUpdate(sql,customerId);
}


@Override
public List<Customer> getCustomerByPage(int pageIndex, int pageSize) {
	List<Customer> list = new ArrayList<Customer>();
	StringBuffer sb=new StringBuffer();
	sb.append(" select c.customerid, nickname, cpwd, gender, cname,  ");
	sb.append(" phone, address, headimg,mibao,answer ");
	sb.append(" from customer c,(select rownum rn,customerid from customer) cc ");
	sb.append(" where cc.customerid=c.customerid ");
	sb.append(" and cc.rn>= ");
	sb.append((pageIndex-1)*pageSize+1);
	sb.append(" and cc.rn<= ");
	sb.append(pageIndex*pageSize);
	conn = dbu.getConn();
	try {
		pstmt = conn.prepareStatement(sb.toString());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customerid"));
			customer.setNickName(rs.getString("nickname"));
			customer.setcPwd(rs.getString("cpwd"));
			customer.setGender(rs.getString("gender"));
			customer.setcName(rs.getString("cname"));
			
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setHeadimg(rs.getString("headimg"));
			customer.setMiBao(rs.getString("mibao"));
			customer.setAnswer(rs.getString("answer"));
			list.add(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		dbu.closeAll(rs, pstmt, conn);
	}
	return list;
}


@Override
public int getCustomerCount() {
	String sql="select count(0) customerCount from customer";
	int customerCount=0;
	conn = dbu.getConn();
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {	
			customerCount=rs.getInt("customerCount");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		dbu.closeAll(rs, pstmt, conn);
	}

	return customerCount;
}


@Override
public int getCustomerPageCount(int pageSize) {
	int customerCount=getCustomerCount();
	if(customerCount%pageSize==0){
		return customerCount/pageSize;
	}else{
		return customerCount/pageSize+1;
	}
}


@Override
public Customer getCustomerById(int customerId) {
	List<Customer> list = new ArrayList<Customer>();
	Customer customer=new Customer();
	String sql="select customerid, nickname, cpwd, gender, cname, "
			+ " phone, address, headimg,mibao,answer from customer where customerId = ? ";
	list=this.getCustomerBySql(sql,customerId);
	if(list.size()>0){
		customer=list.get(0);
		return customer;
	}else{
		return null;
	}
}


/**
 * 修改用户信息没有头像
 * @param customer 顾客对象
 * @return 受影响的行数
 */
@Override
public int updateCusNotImg(Customer customer) {
	String sql="update customer set nickname = ?,cpwd = ?,"
			+ " gender = ?,cname = ?,phone = ?,"
			+ " address = ?,mibao=?,answer=? where customerid = ? ";
	Object obj[]={customer.getNickName(),customer.getcPwd(),customer.getGender(),
			customer.getcName(),customer.getPhone(),
			customer.getAddress(),
			customer.getMiBao(),customer.getAnswer(),customer.getCustomerId()};
	int res=dbu.executeUpdate(sql, obj);
	
	return res;
}


@Override
public List<Customer> getCustomerByNickNameAndAddress(String nickName,
		String address, int pageIndex, int pageSize) {
	List<Customer> list = new ArrayList<Customer>();
	StringBuffer sb=new StringBuffer();
	sb.append(" select c.customerid, c.nickname, cpwd, gender, cname,  ");
	sb.append(" phone, c.address, headimg,mibao,answer ");
	sb.append(" from customer c,(select rownum rn,c1.customerid from customer c1 where 1=1");
	
	List<Object> obj = new ArrayList<Object>();
	if (nickName !=null&&(!nickName.equals("null"))) {
		sb.append(" and c1.nickName like '%'||?||'%' ");
		obj.add(nickName);
	}
	if (address !=null&&(!address.equals("null"))) {
		sb.append(" and c1.address like '%'||?||'%' ");
		obj.add(address);
	}
	sb.append(" ) cc ");
	sb.append(" where cc.customerid=c.customerid ");
	sb.append(" and cc.rn>= ");
	sb.append((pageIndex-1)*pageSize+1);
	sb.append(" and cc.rn<= ");
	sb.append(pageIndex*pageSize);
	conn = dbu.getConn();
	try {
		pstmt = conn.prepareStatement(sb.toString());
		for (int i = 0; i < obj.size(); i++) {
			pstmt.setObject(i + 1, obj.get(i));
		}
		rs = pstmt.executeQuery();
		while (rs.next()) {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getInt("customerid"));
			customer.setNickName(rs.getString("nickname"));
			customer.setcPwd(rs.getString("cpwd"));
			customer.setGender(rs.getString("gender"));
			customer.setcName(rs.getString("cname"));
			customer.setPhone(rs.getString("phone"));
			customer.setAddress(rs.getString("address"));
			customer.setHeadimg(rs.getString("headimg"));
			customer.setMiBao(rs.getString("mibao"));
			customer.setAnswer(rs.getString("answer"));
			list.add(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		dbu.closeAll(rs, pstmt, conn);
	}
	return list;
}


@Override
public int getCustomerCountByNickNameAndAddress(String nickName, String address) {
	StringBuffer sb=new StringBuffer();
	sb.append("select count(0) customerCount from customer c where 1=1");
	List<Object> obj = new ArrayList<Object>();
	if (nickName !=null&&(!nickName.equals("null"))) {
		sb.append(" and c.nickName like '%'||?||'%' ");
		obj.add(nickName);
	}
	if (address !=null&&(!address.equals("null"))) {
		sb.append(" and c.address like '%'||?||'%' ");
		obj.add(address);
	}
	int customerCount=0;
	conn = dbu.getConn();
	try {
		pstmt = conn.prepareStatement(sb.toString());
		for (int i = 0; i < obj.size(); i++) {
			pstmt.setObject(i + 1, obj.get(i));
		}
		rs = pstmt.executeQuery();
		if (rs.next()) {	
			customerCount=rs.getInt("customerCount");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		dbu.closeAll(rs, pstmt, conn);
	}

	return customerCount;
}


@Override
public int getCustomerPageCountByNickNameAndAddress(String nickName,
		String address, int pageSize) {
	int customerCount=getCustomerCountByNickNameAndAddress(nickName, address);
	if(customerCount%pageSize==0){
		return customerCount/pageSize;
	}else{
		return customerCount/pageSize+1;
	}
}	
	
}
