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
			//ͨ���ļ��ķ�ʽ����xml�ļ��õ�document����
			Document doc = reader.read(book_xml);
			//�õ���ǰxml�ĵ��ĸ����
			Element root = doc.getRootElement();
			//�õ����ڵ�����������ӽڵ�
			List<Element> list = root.elements();
			//�����ӽڵ�
			for(Element child:list){
				System.out.println("*"+child.getName()+":"+child.getText());
				//������ǰ�ӽڵ������
				List<Attribute> attrs = child.attributes();
				for(Attribute attr:attrs){
					System.out.println(attr.getName()+":"+attr.getValue());
				}
				//���ڸ�����µ��ӽڵ��»����ӽڵ㣬����Ҫ����Щ�ӽڵ���б���
				List<Element> elementList = child.elements();
				for(Element ec:elementList){
					System.out.println("-------"+ec.getName()+":"+ec.getText());
				}
				
				
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	@Test	//JUnit���Է���
	
	
	
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
	
		//�ݹ鷽��
		private void travelElement(Element root){
			System.out.println("��ǩ��"+root.getName()+"��"+root.getText());
			List<Attribute> attrs = root.attributes();
			for(Attribute attr:attrs){
				System.out.println("���ԣ�"+attr.getName()+"��"+attr.getValue());
			}
			List<Element> es = root.elements();
			for(Element child:es){
				travelElement(child);
			}
		}
	
			
	
}
