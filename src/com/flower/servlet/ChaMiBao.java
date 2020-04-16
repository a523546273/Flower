package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class ChaMiBao extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nickName=request.getParameter("nickName");
		String phone=request.getParameter("phone");
		CustomerBiz cBiz=new  CustomerBizImpl();
		Customer customer=cBiz.getCusByName(nickName);
		PrintWriter out = response.getWriter();
		if (customer==null||!(phone.equals(customer.getPhone()))) {
			
		}else{
			List<Customer> list=new ArrayList<Customer>();
			list.add(customer);
			JSONArray jsonArr=JSONArray.fromObject(list);
			out.write(jsonArr.toString());
			
		}
		out.flush();
		out.close();
		
		

		
		
		
	
	}

}
