package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class CustomerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		CustomerBiz cusBiz=new CustomerBizImpl();
		if(type.equals("registerCustomerOK")){
			String nickName=request.getParameter("nickName");
			Customer customer=cusBiz.getCusByName(nickName);
			String data;
			if(customer==null){
				 data="OK";
			}else{
				 data="IsHas";
			}
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		}else if(type.equals("showCustomer")){
			int customerId=Integer.parseInt(request.getParameter("customerId"));
			Customer customer=cusBiz.getCustomerById(customerId);
			if(customer!=null){
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("showCustomer.jsp")
			.forward(request, response);
			}
		}
	}

}
