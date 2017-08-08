package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo2 implements Servlet {
	/**
	 * 不是服务器已启动就创建，第一次访问才创建，
	 * 只调用一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init...");
	}
	/**
	 * 服务器关闭时，或者手动移除
	 * 调用一次
	 */
	@Override
	public void destroy() {
		System.out.println("destroy...");

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 调用n次与请求对应
	 */

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service...");

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
