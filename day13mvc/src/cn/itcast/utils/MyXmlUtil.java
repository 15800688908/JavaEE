package cn.itcast.utils;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class MyXmlUtil {
	public static final String PATH="d:\\user.xml";
	public static final int NAMEEXIST=1;
	public static final int EMAILEXIST=2;
	public static final int SUCCESS=3;
	public static Document getDocument(String path)throws Exception{
		SAXReader reader=new SAXReader();
		return reader.read(path);
		
	}
	public static void writeXml(Document document,String path)throws Exception{
	OutputFormat format=OutputFormat.createCompactFormat();
	XMLWriter writer =new XMLWriter(new FileOutputStream(path),format);	
	writer.write(document);
	writer.close();
	}
}
