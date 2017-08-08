package cn.itcast.web.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;

public class MyRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		// 父类没有无参构造
		this.request = request;
	}

	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		if (name == null) {
			return null;
		}
		String[] st = map.get(name);
		if (st == null || st.length == 0) {
			return null;
		}
		return st[0];
	}

	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		if (name == null) {
			return null;
		}
		String[] st = map.get(name);
		return st;
	}

	private boolean flag = true;

	// 第一次转码，第二次不转
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();
		if (flag) {
			for (String key : map.keySet()) {
				String[] values = map.get(key);
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("ISO8859-1"),
								"utf-8");

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}
		return map;
	}
}
