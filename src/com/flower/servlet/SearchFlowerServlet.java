package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flower.biz.CustomerBiz;
import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Customer;
import com.flower.entity.Flower;

public class SearchFlowerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FlowerBiz floBiz = new FlowerBizImpl();
		int pageSize = 10;
		int pageIndex = 1;
		String type = null;
		String flowerName = null;
		String description =null;
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		if (type.equals("search")){
			if (request.getParameter("pageIndex") != null) {
				pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			}
			
			if (request.getParameter("txtName").length()!=0) {
				flowerName =request.getParameter("txtName");
			}
			
			if (request.getParameter("txtDescription").length()!=0) {
				description = request.getParameter("txtDescription");
			}
		}
		List<Flower> list = floBiz.getFlowerByNameAndDescription(flowerName, description, pageIndex, pageSize);
			if (list.size() > 0) {
			int flowerCount = floBiz.getFlowerCountByNameAndDescription(flowerName, description);
			int pageCount = floBiz.getFlowerPageCountByNameAndDescription(flowerName, description, pageSize);
			request.setAttribute("pageIndex", pageIndex);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("flowerList", list);
			request.setAttribute("flowerCount", flowerCount);
			request.setAttribute("txtDescription", description);
			request.setAttribute("txtName", flowerName);
			request.getRequestDispatcher("searchBlossom.jsp").forward(request,
					response);
		} else {
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('未查询到该花束！');"
					+ " location.href='FlowerListServlet';</script>");
			out.flush();
			out.close();
		}
	}

}
