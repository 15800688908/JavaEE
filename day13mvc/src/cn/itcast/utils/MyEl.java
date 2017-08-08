package cn.itcast.utils;

import java.net.URLDecoder;

public class MyEl {
public static String myDecode(String str){
	try{
		return URLDecoder.decode(str,"utf8");
	}catch(Exception e){
		e.printStackTrace();
	}
	return null;
}
}
