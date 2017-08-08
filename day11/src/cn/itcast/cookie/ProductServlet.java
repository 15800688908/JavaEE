package cn.itcast.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.utils.MyCookieUtil;

public class ProductServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		Cookie[] cookies=request.getCookies();
		Cookie cookie=MyCookieUtil.getCookieByName(cookies,"product");
		if(cookie==null){
			Cookie c=new Cookie("product",id);
			//設置有效時間
			c.setMaxAge(7*24*60*60);
			//设置有效路径
			c.setPath("/");
			response.addCookie(c);
		}else{
			String value=cookie.getValue();
			String[] values=value.split(",");
			if(!checkId(values,id)){
				cookie.setValue(value+","+id);
				cookie.setMaxAge(7*24*60*60);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}
		response.sendRedirect("/day11/cookie/product.jsp");
	}
	private boolean checkId(String[] values,String id){
		for(String s:values){
			if(s.equals(id)){
				return true;
			}
			
		}
		return false;
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
