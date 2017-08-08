package cn.itcat.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class JaxpDomUtil {
	public static Document getDocument(String path)throws Exception{
		//获取工厂类
		DocumentBuilderFactory factory=
			DocumentBuilderFactory.newInstance();
		//获取解析器
		DocumentBuilder builder=factory.newDocumentBuilder();
		//解析XML，返回document对象
		return builder.parse(path);
	}
	public static void writeXML(Document document,String path)throws Exception{
		TransformerFactory transformerFactory=TransformerFactory.newInstance();
		Transformer transformer=transformerFactory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(path));
	}
	
}
