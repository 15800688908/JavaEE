package cn.itcast.jaxp;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcat.utils.JaxpDomUtil;






/*
 * JAXP的Dom解析XML
 */
public class JaxpDemoTest {
public static void main(String[] args){
	
}
public static void run1()throws Exception{
	//获取解析器工厂类
	DocumentBuilderFactory factory=
		DocumentBuilderFactory.newInstance();
	//获取解析器对象
	DocumentBuilder builder=factory.newDocumentBuilder();
	//解析XML文档，返回document对象
	Document document=builder.parse("src/book.xml");
	//获取作者元素对象的集合，返回Nodelist
	NodeList nodeList=
		document.getElementsByTagName("作者");
	//循环遍历，getTextContent()
	for(int i=0;i<nodeList.getLength();i++){
		Node node=nodeList.item(i);
		System.out.println(node.getTextContent());
	}
}

	public static void run2() throws Exception{
		//获取工厂类
		DocumentBuilderFactory factory=
			DocumentBuilderFactory.newInstance();
		//获取解析器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//解析XML，返回document对象
		Document document=builder.parse("src/book.xml");
		//获取第二本书
		Node book2=document.getElementsByTagName("书").item(1);
		//创建元素对象
		Element cat=document.createElement("猫");
		//设置文本内容
		cat.setTextContent("我是猫");
		//把元素对象添加到第二本书下
		book2.appendChild(cat);
		//回写
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult("src/book2.xml"));
	}
	
	public static void run3()throws Exception{
		//获取文档对象
		String path="src/book.xml";
		Document document=JaxpDomUtil.getDocument(path);
		//获取书
		Node cat =document.getElementsByTagName("猫").item(0);
		//通过书删除猫
		Node book2=cat.getParentNode();
		book2.removeChild(cat);
		//回写
		JaxpDomUtil.writeXML(document, path);
	}
	
public static void run4()throws Exception{
	//获取工厂类
	DocumentBuilderFactory factory=
		DocumentBuilderFactory.newInstance();
	//获取解析器
	DocumentBuilder builder=factory.newDocumentBuilder();
	//解析XML，返回document对象
	Document document=builder.parse("src/book.xml");
	Node author2=document.getElementsByTagName("作者").item(1);
	Node book2=author2.getParentNode();
	Element tgj=document.createElement("团购价");
	tgj.setTextContent("90");
	book2.insertBefore(tgj,author2);
	//回写
	TransformerFactory transformerFactory=TransformerFactory.newInstance();
	Transformer transformer=transformerFactory.newTransformer();
	transformer.transform(new DOMSource(document), new StreamResult("src/book2.xml"));
	}
	public static void run5()throws Exception{
		//获取工厂类
		DocumentBuilderFactory factory=
			DocumentBuilderFactory.newInstance();
		//获取解析器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//解析XML，返回document对象
		Document document=builder.parse("src/book.xml");
		Node book1=document.getElementsByTagName("书").item(0);
		Element book=(Element) book1;
		System.out.println(book.getAttribute("编号"));
	}
}
