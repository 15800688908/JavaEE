package cn.itcast.servlet;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vo.User;

public class UserServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String username=request.getParameter("username");
//		String password=request.getParameter("password");
//		User user=new User();
//		user.setPassword(password);
//		user.setUsername(username);
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		try{
			populate(map,user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
	}

	private void populate(Map<String, String[]> map, User user)throws Exception {
		BeanInfo info=Introspector.getBeanInfo(user.getClass());
		//获取属性描述
		PropertyDescriptor[] pds =info.getPropertyDescriptors();
		for(PropertyDescriptor pd:pds){
			String name=pd.getName();
			//map的key
			if(map.containsKey(name)){
				//获取写的方法
				Method m=pd.getWriteMethod();
				m.invoke(user, map.get(name)[0]);
			}
				
			
			
		}
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
