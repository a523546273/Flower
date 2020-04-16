package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.OrderBiz;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Order;

public class OrderListServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int pageIndex=1;
		int pageSize=10;
		OrderBiz ordBiz=new OrderBizImpl();
		if(request.getParameter("pageIndex")!=null){
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
		
			
			List<Order> list=ordBiz.getOrderByPage(pageIndex, pageSize);
			
			if(list.size()>0){
			int orderCount=ordBiz.getOrderCount();
			int pageCount=ordBiz.getOrderPageCount(pageSize);
			request.setAttribute("orderCount", orderCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("orderList", list);
			request.getRequestDispatcher("orderList.jsp")
			.forward(request, response);
			}
		
	}

}
