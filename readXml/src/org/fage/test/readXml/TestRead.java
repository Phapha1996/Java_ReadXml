package org.fage.test.readXml;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestRead {
	
	
	@Test
	public void testRead_1(){
		try{
			URL url = this.getClass().getClassLoader().getResource("bean.xml");
			File book_xml = new File(url.getPath());
			SAXReader reader = new SAXReader();
			//File book_xml = new File("/book.xml");
			//通过文件的方式加载xml文件得到document对象
			Document doc = reader.read(book_xml);
			//得到当前xml文档的根结点
			Element root = doc.getRootElement();
			//得到根节点下面的所有子节点
			List<Element> list = root.elements();
			//遍历子节点
			for(Element child:list){
				System.out.println("*"+child.getName()+":"+child.getText());
				//遍历当前子节点的属性
				List<Attribute> attrs = child.attributes();
				for(Attribute attr:attrs){
					System.out.println(attr.getName()+":"+attr.getValue());
				}
				//由于根结点下的子节点下还有子节点，所以要对这些子节点进行遍历
				List<Element> elementList = child.elements();
				for(Element ec:elementList){
					System.out.println("-------"+ec.getName()+":"+ec.getText());
				}
				
				
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test	//JUnit测试方法
	
	
	
	public void testReadXml(){
		try{
			URL url = this.getClass().getClassLoader().getResource("bean.xml");
			File bean_xml = new File(url.getPath());
			SAXReader reader = new SAXReader();
			Document doc = reader.read(bean_xml);
			Element root = doc.getRootElement();
			travelElement(root);
			}catch(Exception e){
				e.printStackTrace();
			}
	}			
	
		//递归方法
		private void travelElement(Element root){
			System.out.println("标签："+root.getName()+"："+root.getText());
			List<Attribute> attrs = root.attributes();
			for(Attribute attr:attrs){
				System.out.println("属性："+attr.getName()+"："+attr.getValue());
			}
			List<Element> es = root.elements();
			for(Element child:es){
				travelElement(child);
			}
		}
	
			
	
}
