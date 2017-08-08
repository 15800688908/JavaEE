package cn.itcast.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo1 {
	public void run() throws ClassNotFoundException {
		// 已知类名
		Class clazz = Person.class;
		// 未知类名，object
		Class clazz2 = new Person().getClass();
		Class.forName("cn.itcast.reflect.Person");
	}

	public void run2() throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		// clazz.getConstructors();//获取所有的构造方法
		// 创建实例,相当于调用无参构造
		// Person person=(Person)clazz.newInstance();
		Constructor c = clazz.getConstructor(int.class, String.class);
		Person p2 = (Person) c.newInstance(1, "meomeo");
		p2.getName();
	}

	public void run3() throws Exception {
		Class clazz = Class.forName("cn.itcast.reflect.Person");
		Person p = (Person) clazz.newInstance();
		// clazz.getField("name");共有
		Field name = clazz.getDeclaredField("name");// 共有和私有
		name.setAccessible(true);
		name.set(p, "mem");
		name.get(p);
		Method m = clazz.getDeclaredMethod("setName", String.class);
		m.setAccessible(true);
		m.invoke(p, "凤姐");
	
	}
}
