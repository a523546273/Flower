package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;

public class GetFlowerPCountByFnameServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageSize=Integer.parseInt(request.getParameter("pSize"));
		String flowerName=request.getParameter("flowerName");
		
		
		FlowerBiz fBiz=new FlowerBizImpl();
		
		int pCounts=fBiz.getFlowerPageCount(flowerName, pageSize);
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("pcount", String.valueOf(pCounts));
		map.put("flowerName", flowerName);
		JSONObject jsonStr=JSONObject.fromObject(map);

		
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();

		
	}

}
