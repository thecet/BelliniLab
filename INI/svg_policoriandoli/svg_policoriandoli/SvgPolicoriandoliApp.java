package svg_policoriandoli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SvgPolicoriandoliApp {
    public static void main(String[] args) {
        SvgPolicoriandoli.createFile("policoriandoli.svg");
        PolicoriandoliDocument doc = new PolicoriandoliDocument(600, 400);

        for (int i = 0; i < 20; i++) {
            doc.addCoriandolo();
        }

        SvgPolicoriandoli.writeToFile("policoriandoli.svg", doc.getDocument());
    }
}

class SvgPolicoriandoli {

    public static void createFile(String filename) { // policoriandoli.svg
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filename, String text) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void GeneratePolicoriandoloProperties() {

    }
}