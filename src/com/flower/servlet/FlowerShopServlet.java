package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class FlowerShopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String flowerName = request.getParameter("flowerName");
		int pageIndex = 1;
		int pageSize = 16;

		if (request.getParameter("pageIndex") != null) {
			pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		}
		FlowerBiz fBiz = new FlowerBizImpl();

		List<Flower> list = fBiz.getFlowerByPage(flowerName, pageIndex,
				pageSize);

		int flowerCount = fBiz.getFlowerCount(flowerName);
		int pageCount = fBiz.getFlowerPageCount(flowerName, pageSize);

		JSONArray jsonArr = JSONArray.fromObject(list);
		

		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.write(jsonArr.toString());

		out.flush();
		out.close();
	}

}
