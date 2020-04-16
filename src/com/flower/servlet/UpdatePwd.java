package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class UpdatePwd extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		String pwd=request.getParameter("pwd");
		CustomerBiz cusBiz=new CustomerBizImpl();
		Customer customer=cusBiz.getCustomerById(customerId);
		customer.setcPwd(pwd);
		int res=cusBiz.update(customer);
		PrintWriter out = response.getWriter();
		HashMap<String, String> hash=new HashMap<String, String>();
		if(res>0){
			hash.put("nickName", customer.getNickName());
			hash.put("pwd", pwd);
			JSONObject json=JSONObject.fromObject(hash);
			out.write(json.toString());
		}
		out.flush();
		out.close();
	
	}

}
