package cn.itcast.enumtest;

public class Demo1 {

}

enum Color {
	RED("红色") {
		public void run2() {

		}
	},
	GREEN("红色") {
		public void run2() {

		}
	},
	BLUE("红色") {
		public void run2() {

		}
	};

	private Color(String name) {
		System.out.println(name);
	}

	public void run() {

	}

	public abstract void run2();
}