package cn.itcast.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.Admin;
import cn.itcast.service.IAdminService;
import cn.itcast.service.impl.AdminService;

public class LoginServlet1 extends HttpServlet {

	private IAdminService adminService = new AdminService();
	private String uri;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		Admin admin = new Admin();
		admin.setUserName(userName);
		Admin loginInfo = adminService.findByNameAndPwd(admin);
		if (loginInfo == null) {
			// login fail
			uri = "/login.jsp";
		} else {
			request.getSession().setAttribute("loginInfo", loginInfo);
			uri = "/index";
		}
		request.getRequestDispatcher(uri).forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
