package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class CustomerLoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5926758075685549843L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String cName=request.getParameter("loginId");
		String cPwd=request.getParameter("loginPwd");
		
		CustomerBiz cBiz=new CustomerBizImpl();
		
		Customer customer=cBiz.login(cName, cPwd);
		String str="";
		if (customer!=null) {
			str="success"+cName;
			request.getSession().setAttribute("customer", customer);//用来判断用户是否登录
			//request.getSession().setMaxInactiveInterval(100*60);
			
		}else{
			str="faile";
		}
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(str);
			out.flush();
			out.close();
			
		
		

		//response.setContentType("text/html");
		
	}

}
