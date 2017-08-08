package cn.itcast.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class MyDateConverter implements Converter {

	public Object convert(Class clazz, Object obj) {
		//把输入的字符串转换成日期的类型
		String dDate=(String)obj;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date;//date=null
		try{
			date=sdf.parse(dDate);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException("zhuanhuanriqi cuowu");
		}
		return date;
	}

}
