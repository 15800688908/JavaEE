package cn.itcast.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo6 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		System.out.println(config.getServletName());
		System.out.println(config.getInitParameter("username"));
		Enumeration<String> e=config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name=e.nextElement();
			System.out.println(config.getInitParameter(name));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
