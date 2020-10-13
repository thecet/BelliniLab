package svg_policoriandoli;

import javax.swing.*;
import java.util.Random;
import java.util.Vector;

public class PolicoriandoliDocument {
    private int h = 400;
    private int w = 600;
    private Vector<Policoriandolo> coriandoli = new Vector<Policoriandolo>(1,1);

    public PolicoriandoliDocument(int w, int h) {
        this.h = h;
        this.w = w;
    }

    public String getDocument() {
        String s = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                   "<svg xmlns=\"http://www.w3.org/2000/svg\" width=\""+ w +"\" height=\""+ h +"\">\n";
        for (Policoriandolo p: coriandoli) {
            s += p.getSvg();
        }
        s += "</svg>";
        return s;
    }

    public void addCoriandolo() {
        Random r = new Random();
        coriandoli.add(new Policoriandolo(
                r.nextInt(600),
                r.nextInt(400),
                r.nextInt(50),
                String.format("rgb(%d, %d, %d)", r.nextInt(255), r.nextInt(255), r.nextInt(255))
        ));
    }
}
