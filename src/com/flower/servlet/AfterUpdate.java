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

public class AfterUpdate extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickName=request.getParameter("nickName");
		
        CustomerBiz cBiz=new CustomerBizImpl();
        Customer customer=cBiz.getCusByName(nickName);
        request.setAttribute("cus", customer);
        request.getRequestDispatcher("showCustomerUpdate.jsp").forward(request, response);

		
	}

}
