package cn.itcast.autoboxing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
	public void run(){
		List<String> list=new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		for(String str:list){
			
		}
		
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			it.next();
		}
	}
}
