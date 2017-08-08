package cn.itcast.test;

import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import cn.itcast.servlet.HelloServlet;

public class Demo {
	public void run() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read("src/mydemo.xml");
		Element root = document.getRootElement();
		Element servlet = root.element("servlet");
		Element servletClass = servlet.element("servlet-class");
		String path = servletClass.getText();
		Class clazz = Class.forName(path);
		HelloServlet hello = (HelloServlet) clazz.newInstance();
		Method m = clazz.getDeclaredMethod("run");
		m.setAccessible(true);
		m.invoke(hello);
		// invoke调用
	}
}
