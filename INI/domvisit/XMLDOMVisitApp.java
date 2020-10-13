public class XMLDOMVisitApp {
    /**
     * Program entry point
     * @param args arguments
     */
    public static void main(String[] args) {
        String filename = "data/world.xml";
        String s = XMLDOMVisit.readXMLFile(filename);
        System.out.println(s);
    }
}
