package cn.itcast.utils;

import javax.servlet.http.Cookie;

public class MyCookieUtil {
	public static Cookie getCookieByName(Cookie[] cookies,String name){
		//如果数组是空
		if(cookies==null){
			return null;
		}else{
			for(Cookie cookie:cookies){
				if(cookie.getName().equals(name)){
					return cookie;
				}
			}
			return null;
		}
		
	}
}
