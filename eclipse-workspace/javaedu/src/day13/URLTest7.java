package day13;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class URLTest7 {

	public static void main(String[] args) {
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder
					.parse("http://openapi.seoul.go.kr:8088/796143536a756e69313134667752417a/xml/LampScpgmtb/1/100/");
			
			NodeList pgmNameList = document.getElementsByTagName("CLS_NM");
			for (int i = 0; i < pgmNameList.getLength(); i++)
				System.out.println(pgmNameList.item(i).getTextContent());
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		}
	}
}
