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

public class UpdateFlowerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String flowerName = request.getParameter("flowerName");
		String description = request.getParameter("description");
		int flowerId = Integer.parseInt(request.getParameter("flowerId"));
		double price = Double.parseDouble(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		int sold = Integer.parseInt(request.getParameter("sold"));
		
		Flower flower=new Flower();
		flower.setFlowerId(flowerId);
		flower.setDescription(description);
		flower.setFlowerName(flowerName);
		flower.setPrice(price);
		flower.setSold(sold);
		flower.setStock(stock);
		
		FlowerBiz floBiz=new FlowerBizImpl();
		int res=floBiz.update(flower);
		if(res>0){
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('Blossom信息更新成功！');"
					+ " location.href='FlowerListServlet';</script>");
			out.flush();
			out.close();
		}
	}

}
