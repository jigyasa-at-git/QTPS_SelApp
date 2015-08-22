import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Client {

	public static void main(String[] args) {
		try{
		File file = new File("F:\\xmlfiles\\student.xml");
		 
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
	                             .newDocumentBuilder();
	 
		Document doc = dBuilder.parse(file);
		
		
		NodeList childNodes1 = doc.getChildNodes();
		System.out.println("Total nodes - "+childNodes1.getLength());
		Node rootNode = childNodes1.item(0);
		System.out.println(rootNode.getNodeName());
		System.out.println(rootNode.getTextContent());
		
		
		NodeList childNodes2 =rootNode.getChildNodes();
		System.out.println("Total nodes under root node - "+childNodes2.getLength());
		
		for(int count=0;count<childNodes2.getLength();count++){
			Node tempNode = childNodes2.item(count);

			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println(tempNode.getNodeName());
				System.out.println(tempNode.getTextContent());
			}
		}
		
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
