package cn.itcat.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	/**
	 * xpath
	 * @throws Exception
	 */
	public static void run5()throws Exception{
		SAXReader reader=new SAXReader();
		Document document = reader.read("src/book2.xml");
		List<Node>list=document.selectNodes("/书架/书/作者");
		Node author2=list.get(1);
		System.out.println(author2.getText());
	}
	public static void run4()throws Exception{
		// 获取解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml，返回Document对象
		Document document = reader.read("src/book2.xml");
		// 获取根节点
		Element root = document.getRootElement();
		//获取猫
		Element book2=(Element)root.elements("书").get(1);
		Element cat=book2.element("猫");
		book2.remove(cat);
	}
	
	public static void run3() throws Exception {
		// 获取解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml，返回Document对象
		Document document = reader.read("src/book2.xml");
		// 获取根节点
		Element root = document.getRootElement();
		List<Element> books = root.elements("书");
		Element book2 = books.get(1);
		List<Element> list=book2.elements();
		//创建元素对象DocumentHelper.createElement()
		Element dog=DocumentHelper.createElement("狗");
		dog.setText("this is a dog");
		list.add(1,dog);
		// 回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		//可以设置编码
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"),
				format);
		writer.write(document);
		writer.close();
	}
	public static void run2() throws Exception {
		// 获取解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml，返回Document对象
		Document document = reader.read("src/book2.xml");
		// 获取根节点
		Element root = document.getRootElement();
		List<Element> books = root.elements("书");
		Element book2 = books.get(1);
		book2.addElement("猫").setText("我是猫");
		// 回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		//可以设置编码
		format.setEncoding("GBK");
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book2.xml"),
				format);
		writer.write(document);
		writer.close();
	}

	public static void run1() throws Exception {
		// 获取解析器对象
		SAXReader reader = new SAXReader();
		// 解析xml，返回Document对象
		Document document = reader.read("src/book2.xml");
		// 获取根节点
		Element root = document.getRootElement();
		// 获取书的节点
		List<Element> books = root.elements("书");
		Element book2 = books.get(1);
		// 获取作者及内容
		Element author2 = book2.element("作者");
		String text = author2.getText();
	}
}
