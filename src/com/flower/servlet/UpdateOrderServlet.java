package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.OrderBiz;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Order;

public class UpdateOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int stateId=Integer.parseInt(request.getParameter("stateId"));
		int orderNo=Integer.parseInt(request.getParameter("orderNo"));
	
		Order order=new Order();
		order.setStateId(stateId);
		order.setOrderNo(orderNo);
		
		OrderBiz orderBiz=new OrderBizImpl();
		int res=orderBiz.updateOrder(order);
		if(res>0){
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('订单信息更新成功！');"
					+ " location.href='OrderListServlet';</script>");
			out.flush();
			out.close();
		}
		
	}

}
