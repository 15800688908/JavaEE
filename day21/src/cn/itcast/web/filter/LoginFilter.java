package cn.itcast.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		// 1.获取请求资源，截取
		String uri = request.getRequestURI();
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri
				.length());
		// 2.放行一些资源
		if ("login".equals(requestPath) || "login.jsp".equals(requestPath)) {
			chain.doFilter(request, response);
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
				Object obj = session.getAttribute("loginInfo");
				if (obj != null) {
					chain.doFilter(request, response);

				} else {
					uri = "/login.jsp";
				}
			} else {
				uri = "/login.jsp";
			}
			request.getRequestDispatcher("/").forward(request, response);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}