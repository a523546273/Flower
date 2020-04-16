package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class FlowerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type=null;
		if(request.getParameter("type")!=null){
			type=request.getParameter("type");
		}
		FlowerBiz floBiz=new FlowerBizImpl();
		if(type.equals("registerFlowerOK")){
			String flowerName=request.getParameter("flowerName");
		
			String description=request.getParameter("description");
			
			Flower flower=floBiz.getFlowerByName(flowerName, description);
			
			String data;
			if(flower==null){
				 data="OK";
			}else{
				 data="IsHas";
			}
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		}else if(type.equals("showFlower")){
			int flowerId=Integer.parseInt(request.getParameter("flowerId"));
			Flower flower=floBiz.getFlowerById(flowerId);
			if(flower!=null){
			request.setAttribute("flower", flower);
			request.getRequestDispatcher("showBlossom.jsp")
			.forward(request, response);
			}
		}else if(type.equals("updateFlower")){
			int flowerId=Integer.parseInt(request.getParameter("flowerId"));
			Flower flower=floBiz.getFlowerById(flowerId);
			if(flower!=null){
				request.setAttribute("flower", flower);
				request.getRequestDispatcher("updateBlossom.jsp")
				.forward(request, response);
				}
		}
		
	}

}
