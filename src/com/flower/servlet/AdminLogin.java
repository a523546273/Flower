package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.AdministratorBiz;
import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.AdministratorBizImpl;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Administrator;
import com.flower.entity.Customer;

public class AdminLogin extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8230779472984573787L;


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
		AdministratorBiz aBiz=new AdministratorBizImpl();
		
		Administrator administrator=aBiz.login(cName, cPwd);
		String str="";
		if (administrator!=null) {
			str="success";
			request.getSession().setAttribute("administrator", administrator);//用来判断用户是否登录
			request.getSession().setMaxInactiveInterval(100*60);
			
			
		}else{
			str="faile";
		}
			
			
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(str);
			out.flush();
			out.close();
		
	}
}


