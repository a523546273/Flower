package com.flower.servlet;

import java.io.IOException;





import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.OrderBiz;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Customer;
import com.flower.entity.Order;



public class DingDanServlet extends HttpServlet {

	
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
		int orderCount=0;
		int pageCount=0;
		OrderBiz ordBiz=new OrderBizImpl();
		String nickName=null;
		if (request.getParameter("nickName")!=null) {
			 nickName=request.getParameter("nickName");
		}
		if(request.getParameter("pageIndex")!=null){
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
	
			List<Order> list=ordBiz.getOrderByIdAndNickName(0, nickName, pageIndex, pageSize);
		
			if(list.size()>0){
				if (nickName!=null) {
					 orderCount=ordBiz.getOrderCountByIdAndNickName(0, nickName);
				}
			
			if (orderCount!=0) {
				 pageCount=ordBiz.getOrderPageCount2(pageSize, orderCount);
			}
			
			request.setAttribute("orderCount", orderCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("orderList", list);
			request.setAttribute("nickName", nickName);
			request.getRequestDispatcher("showOrderDetail.jsp").forward(request, response);
			}else{
				response.sendRedirect("noOrder.html");
			}
		
		
	}

}
