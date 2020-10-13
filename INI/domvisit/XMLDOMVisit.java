import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLDOMVisit {
    /**
     * Return a string representation of an XML document
     * @param filename document's filename
     * @return a string representation of an XML document
     */
    public static String readXMLFile(String filename) {
        String s = "";
        try {
            File file = new File(filename);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            s += "Root element: " + doc.getDocumentElement().getNodeName();

            if (doc.hasChildNodes()) {
                s += readNodeListRecursively(doc.getChildNodes());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

    /*     * Return a string representation of a node list using recursion.
     * @param nodeList node list to be parsed
     * @return a string representation of a node list
     */
    private static String readNodeListRecursively(NodeList nodeList) {
        String s = "";

        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                s += "\nNode Name = " + tempNode.getNodeName() + " [OPEN]\n";
                s += "Node Value = " + tempNode.getTextContent() +"\n";

                if (tempNode.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        s += "attr name: " + node.getNodeName() +"\n";
                        s += "attr value: " + node.getNodeValue() +"\n";
                    }
                }

                if (tempNode.hasChildNodes()) {
                    // loop again if has child nodes
                    s += readNodeListRecursively(tempNode.getChildNodes());
                }

                s += "Node Name = " + tempNode.getNodeName() + " [CLOSE]\n";
            }
        }
        return s;
    }

    /*
     * Return a string representation of a node list using iteration.
     * TODO: Too complex, see https://stackoverflow.com/questions/19589231/can-i-iterate-through-a-nodelist-using-for-each-in-java
     * @param nodeList node list to be parsed
     * @return a string representation of a node list
     */
    private static String readNodeListIteratively(NodeList nodeList) {
        String s = "";
        int count = 0;

        while (count < nodeList.getLength()) {
            Node tempNode = nodeList.item(count);

            // make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                // get node name and value
                s += "\nNode Name = " + tempNode.getNodeName() + " [OPEN]";
                s += "Node Value = " + tempNode.getTextContent();

                if (tempNode.hasAttributes()) {
                    // get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();

                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        s += "attr name: " + node.getNodeName();
                        s += "attr value: " + node.getNodeValue();
                    }
                }

                for (int i = 0; i < tempNode.getChildNodes().getLength(); i++) {
                    tempNode.getParentNode().appendChild(tempNode.getChildNodes().item(i));
                    // loop again if has child nodes
                    // NodeList tempNodeList = new N;
                    // s += readNodeListRecursively(tempNode.getChildNodes());
                }
                count++;
                // System.out.println("Node Name = " + tempNode.getNodeName() + " [CLOSE]");
            }
        }
        return s;
    }
}
