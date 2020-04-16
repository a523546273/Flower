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

public class SearchCustomerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerBiz cusBiz = new CustomerBizImpl();
		int pageSize = 10;
		int pageIndex = 1;
		String type = null;
		String nickName = null;
		String address =null;
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
			
			if (request.getParameter("txtAddress").length()!=0) {
				address = request.getParameter("txtAddress");
			}
		}
		List<Customer> list = cusBiz.getCustomerByNickNameAndAddress(nickName, address, pageIndex, pageSize);
			if (list.size() > 0) {
			int customerCount = cusBiz.getCustomerCountByNickNameAndAddress(nickName, address);
			int pageCount = cusBiz.getCustomerPageCountByNickNameAndAddress(nickName, address, pageSize);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("customerList", list);
			request.setAttribute("customerCount", customerCount);
			request.setAttribute("txtAddress", address);
			request.setAttribute("txtName", nickName);
			request.getRequestDispatcher("searchCustomer.jsp").forward(request,
					response);
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('未查询到该顾客！');"
					+ " location.href='CustomerListServlet';</script>");
			out.flush();
			out.close();
		}
		
	}

}
