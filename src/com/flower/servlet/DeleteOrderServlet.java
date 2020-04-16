package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.FlowerBiz;
import com.flower.biz.OrderBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.biz.impl.OrderBizImpl;

public class DeleteOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int orderNo=Integer.parseInt(request.getParameter("orderNo"));
		OrderBiz ordBiz=new OrderBizImpl();
		int res=ordBiz.deleteOrder(orderNo);
		if(res>0){
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('订单信息删除成功！');"
					+ " location.href='OrderListServlet';</script>");
			out.flush();
			out.close();
		}
		
	}

}
