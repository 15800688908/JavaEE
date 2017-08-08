package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	/**
	 *request获取中文乱码
	 *post请求setCharacterEncoding设置缓冲区编码
	 *
	 *get请求方案一修改server.xml
	 *逆向编解码username=URLEncoder.encode(usename,"ISO8859-1")
	 *username=URLDecoder.decode(username,"utf-8")
	 *方案三推荐username=new String(username.getBytes("ISO-8859-1"),"UTF-8")
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//get方式
		//String username=new String(username.getBytes("ISO-8859-1"),"UTF-8");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		String sex=request.getParameter("sex");
		String city=request.getParameter("city");
		String[] loves=request.getParameterValues("love");
		System.out.println(Arrays.toString(loves));
		
		Map<String,String[]>map=request.getParameterMap();
		Set<String> keys=map.keySet();
		for(String key:keys){
			String[] values=map.get(key);
			System.out.println(Arrays.toString(values));
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
