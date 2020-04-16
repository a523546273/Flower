package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.FlowerBiz;
import com.flower.biz.OrderBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.biz.impl.OrderBizImpl;
import com.flower.entity.Order;

public class DeleteFlowerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flowerId=Integer.parseInt(request.getParameter("flowerId"));
		OrderBiz orderBiz=new OrderBizImpl();
		List<Order> list=orderBiz.getOrderByFlowerId(flowerId);
		if(list.size()>0){
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('blossom信息删除失败，找到相关订单信息！');"
					+ " location.href='FlowerListServlet';</script>");
			out.flush();
			out.close();
			
		}else{
		FlowerBiz floBiz=new FlowerBizImpl();
		int res=floBiz.delete(flowerId);
		if(res>0){
			
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('blossom信息删除成功！');"
					+ " location.href='FlowerListServlet';</script>");
			out.flush();
			out.close();
		}
		}
	}

}
