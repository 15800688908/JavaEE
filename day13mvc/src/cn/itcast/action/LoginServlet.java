package cn.itcast.action;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.service.RegService;
import cn.itcast.vo.User;

public class LoginServlet extends HttpServlet {

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
		request.setCharacterEncoding("utf-8");
		Map<String,String[]> map=request.getParameterMap();
		User user=new User();
		try{
			BeanUtils.populate(user,map);
			RegService service=new RegService();
			User succUser=service.loginUser(user);
			if(succUser==null){
				request.setAttribute("msg", "dengluc");
				request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			}else{
				//使用cookie记住用户名
				String remember=request.getParameter("remember");
				if(remember!=null&&"remember".equals(remember)){
					//可以拼接getPassword()
					//先把中文名称编码
					String username=succUser.getUsername();
					username=URLEncoder.encode(username,"utf8");
					Cookie cookie=new Cookie("username",username);
					//设置有效时间
					cookie.setMaxAge(60*60);
					//设置有效路径
					cookie.setPath("/");
					//回写cookie
					response.addCookie(cookie);
				}
				
				request.getSession().setAttribute("succUser", succUser);
				response.sendRedirect(request.getContextPath()+"/reg/success.jsp");
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
