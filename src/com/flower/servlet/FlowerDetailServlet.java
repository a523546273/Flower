package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class FlowerDetailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4683158173574168382L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int flowerId = Integer.parseInt(request.getParameter("fid"));
		FlowerBiz fBiz = new FlowerBizImpl();
		Flower flower = fBiz.getFlowerById(flowerId);
		
		request.getSession().setAttribute("flower", flower);
		
	    request.getRequestDispatcher("shop2.jsp").forward(request, response);
		
	}

}
