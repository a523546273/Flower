package com.flower.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.CustomerBizImpl;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Customer;
import com.flower.entity.Flower;

public class UpdateCustomerInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		CustomerBiz cBiz=new CustomerBizImpl();
		
		int i=1;
	
			boolean isImg=true;
			
			DiskFileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			List items=null;
			try {
				items=upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator iter=items.iterator();
			Map<String,String> mapList=new HashMap<String, String>();
			while (iter.hasNext()) {
				FileItem item=(FileItem) iter.next();
				if (item.isFormField()) {
					String name=item.getFieldName();
					String value=item.getString();
					value=new String(value.getBytes("ISO-8859-1"),"UTF-8");
					
					mapList.put(name, value);
				}
				else{
					i++;
					String fieldName=item.getFieldName();
					String fileName = item.getName();
					if (fileName==null||fileName.length()==0) {
						isImg=false;
					}
					String contentType=item.getContentType();
					long size=item.getSize();
					
					// System.out.println(fieldName);
					// 获取到文件的后缀名
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
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mapList.put(fieldName, "upload/"+fileName);
					
				}
			}
			Customer customer=new Customer();
			int res=0;
			
			if (isImg==true) {
				if (mapList.size()>0) {
					for (String key :mapList.keySet()) {
						if (key.equals("customerId")) {
							customer.setCustomerId(Integer.parseInt(mapList.get(key)));
						}else if (key.equals("nickName")) {
							customer.setNickName(mapList.get(key));
						}else if (key.equals("cPwd")) {
							customer.setcPwd(mapList.get(key));
						}else if (key.equals("cName")) {
							customer.setcName(mapList.get(key));
						}else if (key.equals("radio")) {
							customer.setGender(mapList.get(key));
						}else if (key.equals("headimg")) {
							customer.setHeadimg(mapList.get(key));
						}else if (key.equals("phone")) {
							customer.setPhone(mapList.get(key));
						}else if (key.equals("address")) {
							customer.setAddress(mapList.get(key));
						}else if (key.equals("miBao")) {
							customer.setMiBao(mapList.get(key));
						}else if (key.equals("answer")) {
							customer.setAnswer(mapList.get(key));
						}
					}
				}
				res=cBiz.update(customer);
				}else{
					
					if (mapList.size()>0) {
						for (String key :mapList.keySet()) {
							if (key.equals("customerId")) {
								customer.setCustomerId(Integer.parseInt(mapList.get(key)));
							}else if (key.equals("nickName")) {
								customer.setNickName(mapList.get(key));
							}else if (key.equals("cPwd")) {
								customer.setcPwd(mapList.get(key));
							}else if (key.equals("cName")) {
								customer.setcName(mapList.get(key));
							}else if (key.equals("radio")) {
								customer.setGender(mapList.get(key));
							}else if (key.equals("phone")) {
								customer.setPhone(mapList.get(key));
							}else if (key.equals("address")) {
								customer.setAddress(mapList.get(key));
							}else if (key.equals("miBao")) {
								customer.setMiBao(mapList.get(key));
							}else if (key.equals("answer")) {
								customer.setAnswer(mapList.get(key));
							}
						}
					}
					res=cBiz.updateCusNotImg(customer);
				
			}
			
			PrintWriter out =response.getWriter();
			
		if (res==1) {
			response.setCharacterEncoding("UTF-8");
			
			out.write("<script type='text/javascript'>alert('更新成功！');location.href='AfterUpdate?nickName="+customer.getNickName()+"';</script>");
			
		}else{
			out.write("<script type='text/javascript'>alert('222222！');location.href='AfterUpdate';</script>");
		}
			
		out.flush();
		out.close();


		
	}

}
