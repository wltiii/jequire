package com.changent.jequire;

import java.util.*;
import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;


public class NodeTest {
	public static final void printNode(Node node) {
//		String localName = node.getLocalName();
//		System.out.println("node.getLocalName() = " + localName);

		String name = node.getNodeName();
		System.out.println("node.getNodeName() = " + name);

		NamedNodeMap nnm = node.getAttributes();
		if (nnm != null) {
			System.out.println("node.getAttributes() loop begin");
			System.out.println("nnm.getLength() = " + nnm.getLength());
			for (int i = 0; i < nnm.getLength(); i++) {
				Node namedNode = nnm.item(i);
				String nodeMapItemName = namedNode.getNodeName();
				System.out.println("node.getAttributes() = " + nodeMapItemName);
			}
			System.out.println("node.getAttributes() loop end");
		} else {
			System.out.println("node.getAttributes() = null");
		}

		NodeList nl = node.getChildNodes();
		System.out.println("node.getChildNodes() = " + nl);

//		String namespaceURI = node.getNamespaceURI();
//		System.out.println("node.getNamespaceURI() = " + namespaceURI);

		String nodeValue = node.getNodeValue();
		System.out.println("node.getNodeValue() = " + nodeValue);

		Document ownerDoc = node.getOwnerDocument();
		System.out.println("node.getOwnerDocument() = " + ownerDoc);

		Node parentNode = node.getParentNode();
		System.out.println("node.getParentNode() = " + parentNode);

//		boolean ha = node.hasAttributes();
//		System.out.println("node.hasAttributes() = " + ha);
	}

	public static final void parseProject(Node node) {
		System.out.println("------ begin ------");
		printNode(node);
		node = node.getFirstChild();

		System.out.println("------ process Children ------");
		int i = 0;
		while(node != null) {
			i++;
			System.out.println("------ Child " + i + " ------");
			printNode(node);
			node = node.getNextSibling();
		}
	}

	public static final void parseProjects(Document document,
                                         Collection project)
		throws ProjectParseException {
		int length;
		NodeList list;

		list = document.getElementsByTagName("project");
		length = list.getLength();

		for(int i=0; i < length; i++) {
			System.out.println("------ parseProjects -> node.getNodeName() ------");
			parseProject(list.item(i));
		}
	}

	/***********************************************************/
	// Loads xml project file, creates a Project object and
	// prints to stdout.
	/***********************************************************/
	public static final void main(String args[]) {
		InputSource input;
		Document document;
		ArrayList list;
		Iterator iterator;
		DocumentBuilderFactory factory;
		DocumentBuilder builder;

		try {

		} catch(Exception e) {
			e.printStackTrace();
			return;
		}

		if(args.length != 1) {
			System.err.println("usage: NodeTest xmlfile");
			return;
		}

		try {
			factory  = DocumentBuilderFactory.newInstance();
			input    = new InputSource(new FileReader(args[0]));
			builder = factory.newDocumentBuilder();
			document = builder.parse(input);
			list     = new ArrayList();

			NodeTest.parseProjects(document, list);

			iterator = list.iterator();
/*
			while(iterator.hasNext()) {
				NodeTest p = (NodeTest)iterator.next();
				System.out.println(project.toString());
			}
			*/
		} catch(IOException ioe) {
			ioe.printStackTrace();
			return;
		} catch(SAXException saxe) {
			saxe.printStackTrace();
			return;
		} catch(ProjectParseException ape) {
			ape.printStackTrace();
			return;
		} catch(ParserConfigurationException pce) {
			pce.printStackTrace();
			return;
		}
	}
}

