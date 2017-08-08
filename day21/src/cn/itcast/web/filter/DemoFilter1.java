package cn.itcast.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DemoFilter1 implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 放行,才可以访问到
		chain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// 初始化參數的获取
		String filterName = filterConfig.getFilterName();
		// Filter的名称获取
		String encoding = filterConfig.getInitParameter("encoding");
		Enumeration<String> names = filterConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			System.out.print(names.nextElement());
		}
		// ServletContext对象获取
		filterConfig.getServletContext();
	}
}
