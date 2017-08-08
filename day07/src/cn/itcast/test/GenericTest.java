package cn.itcast.test;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class GenericTest {
	public void run1() {
		List<String> list = new ArrayList<String>();
		list.add("meimei");
		list.add("wangwang");
		list.add("furong");

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}

		for (String str : list) {
			System.out.println(str);
		}

		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void run2() {
		Set<String> set = new HashSet<String>();
		set.add("kezhendong");
		set.add("fangzuming");
		set.add("zhangyaoyang");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for (String str : set) {
			System.out.println(str);
		}
	}

	public void run3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("aa", 1);
		map.put("bb", 2);

		Set<String> keys = map.keySet();
		for (String key : keys) {
			Integer value = map.get(key);
			System.out.println(key + "" + value);
		}
		Set<Entry<String, Integer>> entrys = map.entrySet();
		for(Entry<String,Integer> entry:entrys){
			System.out.println(entry.getKey()+""+entry.getValue());
		}
	}
	
	public void run4(){
		List list1=new ArrayList();
		List<String> list2=new ArrayList();
		List list3=new ArrayList<String>();
		List<String> list4=new ArrayList<String>();
		
	}
	public void demo1(List list){
		
	}
	public void demo(){
		demo1(new ArrayList<String>());
	}
}
