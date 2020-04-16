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

public class GetFlowerPageCountServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7223290829056833424L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		//ªÒ»°“≥»›¡ø
				int pageSize=Integer.parseInt(request.getParameter("pSize"));
				
				FlowerBiz fBiz=new FlowerBizImpl();
				
				int pCounts=fBiz.getFlowerPageCount(null, pageSize);
				
				
				
				Map<String, Integer> map=new HashMap<String, Integer>();
				map.put("pcount", pCounts);
				
			
				
				JSONObject jsonStr=JSONObject.fromObject(map);

				
				PrintWriter out = response.getWriter();
				out.write(jsonStr.toString());
				out.flush();
				out.close();
	}

}
