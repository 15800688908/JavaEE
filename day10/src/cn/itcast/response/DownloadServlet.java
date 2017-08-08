package cn.itcast.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

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
		
		String path=getServletContext().getRealPath("/img/Chrysanthemum.jpg");
		//截取，获取最后一个/的位置
		String filename=null;
		int index=path.lastIndexOf("\\");
		if(index!=-1){
			filename=path.substring(index+1);
		}
		//判断是什么浏览器
		String agent=request.getHeader("User-Agent");
		System.out.println(agent);
		if(agent.contains("MSIE")){
			filename=URLEncoder.encode(filename,"UTF-8");
		}
		if(filename!=null){
			response.setHeader("Content-Disposition", "attachment;filename="+filename);
			System.out.println(request.getRemoteAddr());
				
		}
		InputStream is=new FileInputStream(path);
		OutputStream os=response.getOutputStream();
		byte[] b=new byte[1024];
		int len=0;
		while((len=is.read(b))!=-1){
			os.write(b,0,len);
		}
		os.close();
		//is.close()服务器可以自动管理的
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
