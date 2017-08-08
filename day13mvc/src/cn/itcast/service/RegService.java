package cn.itcast.service;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import cn.itcast.utils.MyXmlUtil;
import cn.itcast.vo.User;

/**
 * 操作xml
 * @author Allen
 *
 */
public class RegService {
	public User loginUser(User user)throws Exception{
		Document document=MyXmlUtil.getDocument(MyXmlUtil.PATH);
		Element root=document.getRootElement();
		List<Element> uList=root.elements("user");
		if(uList==null||uList.size()>=0){
			for(Element u:uList){
				//u.element("username").getText();
				String xmlName=u.elementText("username");
				String uName=user.getUsername();
				String xmlPassword=u.elementText("password");
				String uPassword=user.getUsername();
				if(xmlName.equals(uName)&&xmlPassword.equals(uPassword)){
					//把昵称和邮箱也存入
					user.setNickname(u.elementText("nickname"));
					user.setEmail(u.elementText("email"));
					return user;	
				}
			}
		}
		return null;
	}
	public int regUser(User user)throws Exception{
		Document document=MyXmlUtil.getDocument(MyXmlUtil.PATH);
		Element root=document.getRootElement();
		List<Element> uList=root.elements("user");
		if(uList==null||uList.size()>=0){
			for(Element u:uList){
				//u.element("username").getText();
				String xmlName=u.elementText("username");
				String uName=user.getUsername();
				if(xmlName.equals(uName)){
					return MyXmlUtil.NAMEEXIST;
				}
				String xmlEmail=u.elementText("email");
				String uEmail=user.getEmail();
				if(xmlEmail.equals(uEmail)){
					return MyXmlUtil.EMAILEXIST;
				}
			}
		}
		Element uElement=root.addElement("user");
		uElement.addElement("username").setText(user.getUsername());
		uElement.addElement("password").setText(user.getPassword());
		uElement.addElement("nickname").setText(user.getNickname());
		uElement.addElement("email").setText(user.getEmail());
		MyXmlUtil.writeXml(document, MyXmlUtil.PATH);
		return MyXmlUtil.SUCCESS;
	}
}
