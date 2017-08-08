package cn.itcast.zq;

public class Demo1 {
	Person1 perso=new Person1();
}

class Person1 {
	public void eat() {
		System.out.print("吃两个馒头");
	}
}

class Student1 extends Person1 {
	public void eat() {
		super.eat();
		System.out.print("加两个鸡腿");
	}
}