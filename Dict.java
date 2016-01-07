// Commad line based dictionary - returns definition of the given word from Merriam-Webster open API
// Jacob H Clarkson
// January 2016

import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Dict {
    public static void main(String[]args) {
        // form request url from user args
        String request = "http://www.dictionaryapi.com/api/v1/references/collegiate/xml/" + args[0] + "?key=fb7c4a13-d80d-4cb5-811b-1d9f97c58b5a";

        try {
            // try and retrieve xml definitions from merriam-webster api
            URL url = new URL(request.toString());
            URLConnection conn = url.openConnection();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            
            // hand xml over to parser
            grab(doc);

        } catch(Exception e){
            System.out.println("Whoops, something went wrong.");
        }
    }



    // parse xml from merriam-webster api and print results
    public static void grab(Document doc) {
        doc.getDocumentElement().normalize();
        
        // get suggestions if the word is not found and print them out
        NodeList suggestionList = doc.getElementsByTagName("suggestion");
        if(suggestionList.getLength() > 0)
            System.out.println("\nNo matches found. Did you mean:\n");
        for(int i=0; i<suggestionList.getLength(); i++) {
            Node suggestion = suggestionList.item(i);
            if(suggestion.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(suggestion.getTextContent());
            }
        }

        // get every entry for the word
        NodeList entryList = doc.getElementsByTagName("entry");

        // for each entry
        for(int i=0; i<entryList.getLength(); i++) {
            Node node = entryList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element eElement = (Element) node;
                System.out.println("\n" + eElement.getAttribute("id")); // get the entry
                NodeList defList = node.getChildNodes();


                for(int j=0; j<defList.getLength(); j++) {
                    Node child = defList.item(j);
                    if(child.getNodeType() == Node.ELEMENT_NODE) {
                        if(child.getNodeName() == "def") {
                            NodeList dtList = child.getChildNodes();
                           

                            // get each definition                            
                            for(int k=0; k<dtList.getLength(); k++) {
                                Node dt = dtList.item(k);
                                if(dt.getNodeType() == Node.ELEMENT_NODE) {
                                    if(dt.getNodeName() == "dt") {
                                        System.out.println(dt.getTextContent());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

