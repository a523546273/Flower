package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;







import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.FlowerBiz;
import com.flower.biz.OrderBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Customer;
import com.flower.entity.Flower;
import com.flower.entity.Order;

public class BuyFlowerServlet extends HttpServlet {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9054764663497890124L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		if(request.getSession().getAttribute("customer")==null){
			out.write("<script type='text/javascript'>alert('您还未登录');location.href='shop2.jsp';</script>");
		}else{
		Customer customer=(Customer)request.getSession().getAttribute("customer");
		int buyNumber =Integer.parseInt(request.getParameter("select"));
		int num=Integer.parseInt(request.getParameter("num"));
		String address=request.getParameter("address");
        int flowerId=Integer.parseInt(request.getParameter("flowerId"));
        Order order=new Order();
        order.setCustomerId(customer.getCustomerId());
        order.setFlowerId(flowerId);
        if (num==0) {
        	order.setBuyNumber(buyNumber);
		}else if(num>0){
			order.setBuyNumber(num);
		}else{
			out.write("<script type='text/javascript'>alert('您输入的数目有误！');location.href='shop2.jsp';</script>");
		}
       order.setOrderAddress(address);
       order.setStateId(1);
       order.setPhone(customer.getPhone());
       OrderBiz oBiz=new OrderBizImpl();
       int res =oBiz.addOrder(order);
     if (res>0) {
    	  FlowerBiz floBiz=new FlowerBizImpl();
    	  Flower flower= floBiz.getFlowerById(flowerId);
    	  flower.setSold(flower.getSold()+buyNumber);
    	  flower.setStock(flower.getStock()-buyNumber);
    	  int updateFlower=floBiz.update(flower);
    	  if(updateFlower>0){
    	  response.setCharacterEncoding("UTF-8");
    	   out.write("<script type='text/javascript'>alert('购买成功！欢迎继续访问blossom花店');"
    	   		+ "location.href='shop2.jsp';</script>");
    	  }
	}else{
		out.write("<script type='text/javascript'>alert('2');location.href='shop.html';</script>");
	}
		out.flush();
		out.close();
	}
	}
}
