package cn.itcast.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//c3p0配置文件可以是xml
public class C3p0Test {
	//会自动按默认路径去查找
	ComboPooledDataSource cpds=new ComboPooledDataSource();
	//c3p0会自动查找路径
	//classpath下（web classes 下）
}
