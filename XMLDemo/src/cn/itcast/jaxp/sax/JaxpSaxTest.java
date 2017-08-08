package cn.itcast.jaxp.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JaxpSaxTest {
	public static void main(String[] args){
		
	}
	/*
	 * 获取所有解析的内容
	 */
	public static void run1()throws Exception{
		//获取SAX的解析器工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//获取解析器
		SAXParser parser=factory.newSAXParser();
		//解析
		parser.parse("src/book2.xml", new MyHandler());
	}
}
/*
 * 获取作者标签的文本内容
 */

class MyHandler1 extends DefaultHandler{
	private boolean flag=false;
	private int count=0;
	public void characters(char[] ch, int start, int length) 
	throws SAXException {
		if(flag&&count==1){
			String str=new String(ch,start,length);
			System.out.println(str);
		}
		
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		flag=false;
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("作者".equals(qName)){
			flag=true;
			count++;
		}
	}
	
}
class MyHandler extends DefaultHandler{

	public void characters(char[] ch, int start, int length) throws SAXException {
		String str=new String(ch,start,length);
		System.out.println(str);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("end 标签"+qName);
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.println("start 标签"+qName);
	}
	
}