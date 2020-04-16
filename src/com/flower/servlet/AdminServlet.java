package com.flower.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flower.biz.AdministratorBiz;
import com.flower.biz.impl.AdministratorBizImpl;
import com.flower.entity.Administrator;

public class AdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = null;
		String loginName = null;
		if (request.getParameter("type") != null) {
			type = request.getParameter("type");
		}
		AdministratorBiz adminBiz = new AdministratorBizImpl();
		if (type.equals("showAdmin")) {
			if (request.getSession().getAttribute("administrator") != null) {
				Administrator admin1 = (Administrator) request.getSession()
						.getAttribute("administrator");
				loginName = admin1.getLoginName();

			}
			Administrator admin = adminBiz.getAdminByLoginName(loginName);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("showAdmin.jsp").forward(request,
					response);
		} else if (type.equals("updateAdmin")) {
			if (request.getSession().getAttribute("administrator") != null) {
				Administrator admin1 = (Administrator) request.getSession()
						.getAttribute("administrator");
				loginName = admin1.getLoginName();

			}
			Administrator admin = adminBiz.getAdminByLoginName(loginName);
			request.setAttribute("admin", admin);
			request.getRequestDispatcher("updateAdmin.jsp").forward(request,
					response);
		}else if (type.equals("updateAdmin2")) {
			loginName=request.getParameter("loginName");
			String loginPwd=request.getParameter("loginPwd");
			
			String miBao=request.getParameter("miBao");
			String answer=request.getParameter("answer");
			String gender=request.getParameter("gender");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			Date birthday=Date.valueOf(request.getParameter("birthday"));
			String address=request.getParameter("address");
			int adminId=Integer.parseInt(request.getParameter("adminId"));
			
			Administrator admin =new Administrator();
			admin.setAddress(address);
			admin.setAdminId(adminId);
			admin.setAnswer(answer);
			admin.setBirthday(birthday);
			admin.setEmail(email);
			admin.setGender(gender);
			admin.setLoginName(loginName);
			admin.setLoginPwd(loginPwd);
			admin.setMiBao(miBao);
			admin.setPhone(phone);
			
			int res=adminBiz.updateAdmin(admin);
			if(res>0){
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>alert('信息更新成功！');"
						+ " location.href='AdminServlet?type=showAdmin';</script>");
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>alert('更新信息时发生不可预知的错误！');"
						+ " location.href='AdminServlet?type=showAdmin';</script>");
				out.flush();
				out.close();
			}
		}else if(type.equals("modifyPwd")){
			
			if (request.getSession().getAttribute("administrator") != null) {
				Administrator admin1 = (Administrator) request.getSession()
						.getAttribute("administrator");
				loginName = admin1.getLoginName();
			}
			Administrator admin = adminBiz.getAdminByLoginName(loginName);
			String loginPwd=request.getParameter("pwd1");
			admin.setLoginPwd(loginPwd);
			
			int res=adminBiz.updateAdmin(admin);
			if(res>0){
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>alert('密码更改成功！');"
						+ " location.href='AdminServlet?type=showAdmin';</script>");
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>alert('更改密码时发生不可预知的错误！');"
						+ " location.href='AdminServlet?type=showAdmin';</script>");
				out.flush();
				out.close();
			}
		}else if(type.equals("surePwd")){
			if (request.getSession().getAttribute("administrator") != null) {
				Administrator admin1 = (Administrator) request.getSession()
						.getAttribute("administrator");
				loginName = admin1.getLoginName();
			}
			Administrator admin = adminBiz.getAdminByLoginName(loginName);
			String pwd=request.getParameter("pwd");
			String data;
			if(admin.getLoginPwd().equals(pwd)){
				 data="OK";
			}else{
				 data="No";
			}
			PrintWriter out = response.getWriter();
			out.write(data);
			out.flush();
			out.close();
		}else if(type.equals("sureLoginName")){
			loginName=request.getParameter("loginName");
			Administrator admin=adminBiz.getAdminByLoginName(loginName);
			int adminId=admin.getAdminId();
			PrintWriter out = response.getWriter();
			if(admin!=null){
			HashMap<String, String> hash=new HashMap<String, String>();
			hash.put("miBao", admin.getMiBao());
			hash.put("answer", admin.getAnswer());
			hash.put("adminId",String.valueOf(adminId));
			JSONObject json=JSONObject.fromObject(hash);
			out.write(json.toString());
			}
			out.flush();
			out.close();
		}else if(type.equals("resetPwd")){
			int adminId=Integer.parseInt(request.getParameter("adminId"));
			String loginPwd=request.getParameter("loginPwd");
			Administrator admin=adminBiz.getAdminById(adminId);
			admin.setLoginPwd(loginPwd);
			
			int res=adminBiz.updateAdmin(admin);
			PrintWriter out = response.getWriter();
			if(res>0){
				HashMap<String, Integer> hash=new HashMap<String, Integer>();
				hash.put("res", res);
				JSONObject json=JSONObject.fromObject(hash);
				out.write(json.toString());
			}else{
				
			}
			out.flush();
			out.close();
		}

	}

}
