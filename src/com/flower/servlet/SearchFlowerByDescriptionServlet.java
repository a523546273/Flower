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

public class SearchFlowerByDescriptionServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pageSize=Integer.parseInt(request.getParameter("pSize"));
		String description=request.getParameter("description");
		FlowerBiz fBiz=new FlowerBizImpl();
		
		int pCounts=fBiz.getFlowerPageCountByDescription(description, pageSize);
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("pcount", String.valueOf(pCounts));
		map.put("description", description);
		JSONObject jsonStr=JSONObject.fromObject(map);
		
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();
	}

}
