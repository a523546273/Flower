package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class FlowerListServlet extends HttpServlet {

	
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
		FlowerBiz floBiz=new FlowerBizImpl();
		if(request.getParameter("pageIndex")!=null){
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
		
			List<Flower> list=floBiz.getFlowerByPage(null, pageIndex, pageSize);
			if(list.size()>0){
			int flowerCount=floBiz.getFlowerCount(null);
			int pageCount=floBiz.getFlowerPageCount(null, pageSize);
			request.setAttribute("flowerCount", flowerCount);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("flowerList", list);
			request.getRequestDispatcher("blossomList.jsp")
			.forward(request, response);
			
		}
		
	}

}
