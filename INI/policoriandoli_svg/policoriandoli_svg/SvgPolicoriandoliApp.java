package policoriandoli_svg;

public class SvgPolicoriandoliApp {
    public static void main(String[] args) {
        SvgPolicoriandoli.createFile("policoriandoli.svg");
        SvgPolicoriandoli.writeToFile("policoriandoli.svg", "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\"600\" height=\"400\">\n" +
                "   <circle cx=\"565\" cy=\"127\" r=\"14\" fill=\"rgb(254, 169, 246)\" />\n" +
                "   ...\n" +
                "</svg>");
    }
}

