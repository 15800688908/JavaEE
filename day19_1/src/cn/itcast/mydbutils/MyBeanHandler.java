package cn.itcast.mydbutils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class MyBeanHandler implements MyResultSetHandler {
	private Class clazz;

	public MyBeanHandler(Class clazz) {
		this.clazz = clazz;
	}

//	public Object handle(ResultSet rs) throws SQLException {
//		Object obj = null;
//		try {
//			BeanInfo bif = Introspector.getBeanInfo(clazz);
//			PropertyDescriptor[] pds = bif.getPropertyDescriptors();
//
//			if (rs.next()) {
//				obj = clazz.newInstance();
//				for (PropertyDescriptor pd : pds) {
//					String name = pd.getName();
//					Method setMethod = pd.getWriteMethod();
//					if (setMethod != null)
//						setMethod.invoke(obj, rs.getObject(name));
//				}
//			}
//		} catch (IntrospectionException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return obj;
//	}
	//从结果集方向封装
//	public Object handle(ResultSet rs) throws SQLException {
//		Object obj=null;
//		ResultSetMetaData md=rs.getMetaData();
//		int count=md.getColumnCount();
//		if(rs.next()){
//			try{
//			BeanInfo bif = Introspector.getBeanInfo(clazz);
//			PropertyDescriptor[] pds = bif.getPropertyDescriptors();
//	
//				obj=clazz.newInstance();
//				
//				for(int i=1;i<=count;i++){
//					String name=md.getColumnName(i);
//					for(PropertyDescriptor pd:pds){
//						if(name.equals(pd.getName())){
//							pd.getWriteMethod().invoke(obj, rs.getObject(name));
//						}
//					}
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//		
//		}
//return obj;
//	}
	public Object handle(ResultSet rs)throws SQLException{
		Object obj=null;
		Map<String,String[]>map=new HashMap<String,String[]>();
		ResultSetMetaData md=rs.getMetaData();
		int count=md.getColumnCount();
		if(rs.next()){
			try{
			obj=clazz.newInstance();
			for(int i=1;i<=count;i++){
				map.put(md.getColumnName(i), new String[]{rs.getString(md.getColumnClassName(i))});
			}
			BeanUtils.populate(obj,map);
		}
		catch(Exception e ){
			e.printStackTrace();
		}}
		return obj;
	}
}
