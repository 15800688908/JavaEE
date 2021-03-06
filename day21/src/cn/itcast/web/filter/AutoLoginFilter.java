package cn.itcast.web.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.entity.User;
import cn.itcast.service.UserService;
import cn.itcast.utils.CookieUtils;

public class AutoLoginFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		// 1.强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		User u = (User) request.getSession().getAttribute("user");
		if (u == null) {
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			String path = uri.substring(contextPath.length());

			if (!(path.equals("") || path.equals("login"))) {
				// 2.操作
				Cookie cookie = CookieUtils.findCookieByName(request
						.getCookies(), "autologin");
				if (cookie != null) {

					String username = URLDecoder.decode(cookie.getValue()
							.split("::")[0], "utf-8");
					String password = cookie.getValue().split("::")[1];
					UserService service = new UserService();
					User user;
					try {
						user = service.login(username, password);
						if (user != null) {
							request.getSession().setAttribute("user", user);
							// response.sendRedirect("");
							// return;

						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}
		// 3.放行
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {

	}
}
