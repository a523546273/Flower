package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class PriceShopServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		FlowerBiz fBiz=new FlowerBizImpl();
		int min=Integer.parseInt(request.getParameter("min"));
		int max=Integer.parseInt(request.getParameter("max"));
		int pageSize=Integer.parseInt(request.getParameter("pSize"));
		int pCounts=fBiz.getFlowerByPrice(pageSize, min, max);
		
        Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("pcount", pCounts);
		JSONObject jsonStr=JSONObject.fromObject(map);
		
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();
		
		
	}

}
