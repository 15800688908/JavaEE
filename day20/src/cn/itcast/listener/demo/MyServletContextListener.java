package cn.itcast.listener.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {
	// 线程安全的
	private List<HttpSession> sessions = Collections
			.synchronizedList(new ArrayList<HttpSession>());

	public void contextDestroyed(ServletContextEvent sce) {
		// 

	}

	public void contextInitialized(ServletContextEvent sce) {
		// 执行说明项目启动了
		ServletContext context = sce.getServletContext();
		context.setAttribute("sessions", sessions);

		// 开始扫描
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				// 10秒不使用销毁
				for (Iterator<HttpSession> it = sessions.iterator(); it
						.hasNext();) {
					// for (HttpSession session : sessions) {
					HttpSession session = it.next();
					if (System.currentTimeMillis()
							- session.getLastAccessedTime() > 10000) {
						session.invalidate();
						sessions.remove(session);
						System.out.print(session.getId());
					}
				}
			}

		}, 1000, 3000);
	}
	// 集合要考虑同步问题，使用迭代器遍历
}
