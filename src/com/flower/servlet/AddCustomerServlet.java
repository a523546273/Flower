package com.flower.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.flower.biz.CustomerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.entity.Customer;

public class AddCustomerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		CustomerBiz cusBiz=new CustomerBizImpl();
		String type=request.getParameter("type");
		int i=1;
		if(type.equals("addCustomer")){
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List items=null;
			try {
				items=upload.parseRequest(request);
			} catch (FileUploadException e) {
			}
			Iterator iter=items.iterator();
			Map<String,String> mapList =new HashMap<String,String>();
			while(iter.hasNext()){
				FileItem item=(FileItem) iter.next();
				if (item.isFormField()) {
					String name=item.getFieldName();
					String value=item.getString().trim();
					value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					mapList.put(name, value);
				}
				else{
					i++;
					String fieldName=item.getFieldName();
					String fileName = item.getName();
					String contentType=item.getContentType();
					long size=item.getSize();
					String fix=fileName.substring(fileName.lastIndexOf(".")+1);
					java.util.Date nowDate=new java.util.Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
					fileName=sdf.format(nowDate);
					// 毫秒数,类似于随机数为了避免文件重名
					fileName+=System.currentTimeMillis()+i;
					fileName+="."+fix;
					String savePath=request.getSession().getServletContext()
							.getRealPath("/")+"upload/";
					File file=new File(savePath+fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
					mapList.put(fieldName, "upload/"+fileName);
					
				}
				
			}
			
			Customer customer=new Customer();
			
			if (mapList.size()>0) {
				for (String key :mapList.keySet()) {
					if (key.equals("nickName")) {
						customer.setNickName(mapList.get(key));
					}else if (key.equals("pwd")) {
						customer.setcPwd(mapList.get(key));
					}else if (key.equals("name")) {
						customer.setcName(mapList.get(key));
					}else if (key.equals("phone")) {
						customer.setPhone(mapList.get(key));
					}else if (key.equals("gender")) {
						customer.setGender(mapList.get(key));
					}else if (key.equals("headimg")) {
						customer.setHeadimg(mapList.get(key));
					}else if (key.equals("address")) {
						customer.setAddress(mapList.get(key));
					}else if (key.equals("miBao")) {
						customer.setMiBao(mapList.get(key));
				}else if (key.equals("answer")) {
					customer.setAnswer(mapList.get(key));
				
			}
			
			}
		}
            int res=cusBiz.register(customer);
			if (res==1) {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out =response.getWriter();
				out.write("<script type='text/javascript'>alert('新增顾客成功!');"
						+ "location.href='CustomerListServlet?type=allCustomer';</script>");
				out.flush();
				out.close();
	}

		}
	}
}
