package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class CustomerListServlet extends HttpServlet {

	
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
		CustomerBiz cusBiz=new CustomerBizImpl();
		if(request.getParameter("pageIndex")!=null){
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
	
			List<Customer> list=cusBiz.getCustomerByPage(pageIndex, pageSize);
			if(list.size()>0){
		
			int customerCount=cusBiz.getCustomerCount();
			int pageCount=cusBiz.getCustomerPageCount(pageSize);
			request.setAttribute("customerCount", customerCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("customerList", list);
			request.getRequestDispatcher("customerList.jsp")
			.forward(request, response);
			}
		}
	

}
