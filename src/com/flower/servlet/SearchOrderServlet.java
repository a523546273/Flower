package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.CustomerBiz;
import com.flower.biz.OrderBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Customer;
import com.flower.entity.Order;

public class SearchOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OrderBiz ordBiz = new OrderBizImpl();
		int pageSize = 10;
		int pageIndex = 1;
		String type = null;
		String nickName = null;
		int orderNo=0;
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		if (type.equals("search")){
			if (request.getParameter("pageIndex") != null) {
				pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			}
			
			if (request.getParameter("txtName").length()!=0) {
				nickName =request.getParameter("txtName");
			}
			
			if (request.getParameter("txtOrderNo").length()!=0) {
				orderNo = Integer.parseInt(request.getParameter("txtOrderNo"));
			}
		}
		List<Order> list=ordBiz.getOrderByIdAndNickName(orderNo, nickName, pageIndex, pageSize);
			if (list.size() > 0) {
			int orderCount = ordBiz.getOrderCountByIdAndNickName(orderNo, nickName);
			int pageCount = ordBiz.getOrderPageCountByIdAndNickName(orderNo, nickName, pageSize);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("orderList", list);
			request.setAttribute("orderCount", orderCount);
			request.setAttribute("txtOrderNo", orderNo);
			request.setAttribute("txtName", nickName);
			request.getRequestDispatcher("searchOrder.jsp").forward(request,
					response);
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('未查询到相关订单！');"
					+ " location.href='OrderListServlet';</script>");
			out.flush();
			out.close();
		}
		
	}

}
