package cn.itcast.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.itcast.vo.User;

public class IntrospectorTest {
@Test
public void run()throws Exception{
	User user=new User();
	//获得类信息
	BeanInfo info=Introspector.getBeanInfo(user.getClass());
	//获取属性描述
	PropertyDescriptor[] pds =info.getPropertyDescriptors();
	for(PropertyDescriptor pd:pds){
		System.out.println(pd);
		if("class".equals(pd.getName())){
			//获取写的方法
			Method m=pd.getWriteMethod();
			m.invoke(user, "admin");
		}
		
	}
	System.out.println(user.getUsername());
	System.out.println(user.getPassword());
}
}
