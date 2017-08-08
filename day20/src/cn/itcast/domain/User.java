package cn.itcast.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
//标准javaBean要序列化的
public class User implements HttpSessionBindingListener, Serializable {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void valueBound(HttpSessionBindingEvent event) {

	}

	public void valueUnbound(HttpSessionBindingEvent event) {

	}

	public void sessionDidActivate(HttpSessionEvent se) {

	}

	public void sessionWillPassivate(HttpSessionEvent se) {
		// 钝化
	}
}
