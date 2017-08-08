package cn.itcast.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// 转型
		final HttpServletRequest request = (HttpServletRequest) req;// post有效
		HttpServletResponse response = (HttpServletResponse) res;

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		/**
		 * 出现Get中文乱码，是因为request.getParameter()没判断 对接口中的某一个方法进行扩展，创建代理对象
		 */
		HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(),
				new Class[] { HttpServletRequest.class },
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						Object returnValue = null;
						String methodName = method.getName();
						if ("getParameter".equals(methodName)) {
							// 判断是否是GET提交，处理数据
							String value = request.getParameter(args[0]
									.toString());
							String methodSubmit = request.getMethod();
							if (value != null && !"".equals(value.trim())) {
								if ("GET".equals(methodSubmit)) {
									value = new String(value
											.getBytes("ISO8859-1"), "utf-8");
								}
							}

							// 如果value中出现dirtyData中数据，用***替换
							for (String data : dirtyData) {
								// 判断当前输入数据value
								if (value.contains(data)) {
									value = value.replace(data, "***");
								}
							}
							// 返回处理后的
							return value;
						} else {
							returnValue = method.invoke(request, args);
						}
						return returnValue;
					}
				});
		// 对目标对象实现的接口类型
		// 放行
		chain.doFilter(proxy, response);// 传入代理对象

	}

	// 初始化无效数据
	private List<String> dirtyData;

	public void init(FilterConfig filterConfig) throws ServletException {
		dirtyData = new ArrayList<String>();
		dirtyData.add("NND");
		dirtyData.add("炸使馆");
	}

}
