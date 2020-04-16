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

public class JPaginateByDescriptionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageIndex=Integer.parseInt(request.getParameter("start"));
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String description=request.getParameter("description");
		FlowerBiz fBiz=new FlowerBizImpl();
		List<Flower> list=fBiz.getFlowerByNameAndDescription(null, description, pageIndex, pageSize);
		JSONArray jsonArr=JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.write(jsonArr.toString());
		out.flush();
		out.close();
		
	}

}
