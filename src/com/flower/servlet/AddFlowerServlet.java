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

import com.flower.biz.FlowerBiz;
import com.flower.biz.impl.FlowerBizImpl;
import com.flower.entity.Flower;

public class AddFlowerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		FlowerBiz fBiz = new FlowerBizImpl();
		List<Flower> list = new ArrayList<Flower>();
		int i = 1;
		if (type.equals("addFlower")) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator iter = items.iterator();
			Map<String, String> mapList = new HashMap<String, String>();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString();
					value = new String(value.getBytes("ISO-8859-1"), "UTF-8");

					mapList.put(name, value);
				} else {
					i++;
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long size = item.getSize();

					// System.out.println(fieldName);
					// 获取到文件的后缀名
					String fix = fileName
							.substring(fileName.lastIndexOf(".") + 1);
					java.util.Date nowDate = new java.util.Date();
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyyMMddhhmmss");
					fileName = sdf.format(nowDate);
					// 毫秒数,类似于随机数为了避免文件重名
					fileName += System.currentTimeMillis() + i;
					fileName += "." + fix;
					String savePath = request.getSession().getServletContext()
							.getRealPath("/")
							+ "upload/";

					File file = new File(savePath + fileName);
					try {
						item.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mapList.put(fieldName, "upload/" + fileName);

				}
			}
			Flower flower = new Flower();
			if (mapList.size() > 0) {
				for (String key : mapList.keySet()) {
					if (key.equals("flowerName")) {
						flower.setFlowerName(mapList.get(key));
					} else if (key.equals("price")) {
						flower.setPrice(Double.valueOf(mapList.get(key)));
					} else if (key.equals("stock")) {
						flower.setStock(Integer.valueOf(mapList.get(key)));
					} else if (key.equals("sold")) {
						flower.setSold(Integer.valueOf(mapList.get(key)));
					} else if (key.equals("description")) {
						flower.setDescription(mapList.get(key));
					} else if (key.equals("flowerimg1")) {
						flower.setFlowerimg1(mapList.get(key));
					} else if (key.equals("flowerimg2")) {
						flower.setFlowerimg2(mapList.get(key));
					}
				}
				flower.setSold(0);
			}

			int res = fBiz.addFlower(flower);
			if (res == 1) {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.write("<script type='text/javascript'>alert('新增blossom成功！');location.href='FlowerListServlet';</script>");
				out.flush();
				out.close();
			}

		}

	}

}
