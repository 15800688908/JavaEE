package cn.itcast.listener;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
	public static void main(String[] args) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				System.out.print("hello timer");
			}

		}, 1000, 2000);
	}
}
