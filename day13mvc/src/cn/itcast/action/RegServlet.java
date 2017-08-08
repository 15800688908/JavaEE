package cn.itcast.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.service.RegService;
import cn.itcast.utils.MyXmlUtil;
import cn.itcast.vo.User;

public class RegServlet extends HttpServlet {

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
		//设置request缓冲区的编码（post）
		request.setCharacterEncoding("utf-8");
		//设置字符中文乱码问题
		response.setContentType("text/html;charset=utf8");
		//获取session的验证码和页面的验证码
		String sessCode=(String)request.getSession().getAttribute("sessionCode");
		String reqCode=request.getParameter("code");
		
		if(reqCode==null||!reqCode.equals(sessCode)){
			request.setAttribute("msg", "yanzhengmac");
			request.getRequestDispatcher(request.getContextPath()+"/reg/reg.jsp");
			return;
		}
		//获取请求头
		String referer=request.getHeader("referer");
		if(referer==null||!referer.endsWith("reg.jsp")){
			
			response.sendRedirect(request.getContextPath()+"reg/reg.jsp");
			return;
		}
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		try{
			BeanUtils.populate(user, map);
			RegService reg=new RegService();
			int flag=reg.regUser(user);
			if(flag==MyXmlUtil.NAMEEXIST){
				request.setAttribute("msg", "username exsists");
				request.getRequestDispatcher("/reg/reg.jsp").forward(request, response);
			}else if(flag==MyXmlUtil.EMAILEXIST){
				request.setAttribute("msg", "email exsists");
				request.getRequestDispatcher("/reg/reg.jsp").forward(request, response);
			
			}else if(flag==MyXmlUtil.SUCCESS){
				response.getWriter().write(" regist success");
			}
		}catch(Exception e){
			e.printStackTrace();
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

		doGet(request,response);
	}

}
