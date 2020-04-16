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

public class OrderServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		OrderBiz ordBiz=new OrderBizImpl();
		if(type.equals("showOrder")){
			int orderNo=Integer.parseInt(request.getParameter("orderNo"));
			Order order=ordBiz.getOrderByNo(orderNo);
			if(order!=null){
			request.setAttribute("order", order);
			request.getRequestDispatcher("showOrder.jsp").forward(request, response);
			}
	}else if(type.equals("updateOrder")){
		int orderNo=Integer.parseInt(request.getParameter("orderNo"));
		Order order=ordBiz.getOrderByNo(orderNo);
		if(order!=null){
		request.setAttribute("order", order);
		request.getRequestDispatcher("updateOrder.jsp").forward(request, response);
		}
	}

	}
}
