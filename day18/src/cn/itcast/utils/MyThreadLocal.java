package cn.itcast.utils;

import java.util.HashMap;
import java.util.Map;

public class MyThreadLocal<T> {
	private Map<Thread,T> map;
	public MyThreadLocal(){
		map=new HashMap<Thread,T>();
	}
	public void set(T t){
		map.put(Thread.currentThread(), t);
	}
	public T get(){
		return map.get(Thread.currentThread());
	}
}
