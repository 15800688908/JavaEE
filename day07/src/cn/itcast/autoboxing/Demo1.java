package cn.itcast.autoboxing;

import java.util.ArrayList;
import java.util.List;

public class Demo1 {
	public void run1(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		//list.add(new Integer(1));
		//自动装箱
		//new Integer(1)
		Integer i=1;
		//自动拆箱
		//i.intValue()
		int j=i;
	}
	//向下兼容
	//128不等
	public void doXXX(double x){
		
	}
	public void doXXX(Integer x){
		
	}
}
