package svg_policoriandoli;

public class Policoriandolo {
    private int cx;
    private int cy;
    private int r;
    private String fill;

    public Policoriandolo(int cx, int cy, int r, String fill) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
        this.fill = fill;
    }

    public String getSvg() {
        String s = "<circle " +
                "cx=\""+ cx +"\" "+
                "cy=\""+ cy +"\" "+
                "r=\""+ r +"\" " +
                "fill=\""+ fill + "\"";
        s += "/>\n";
        return s;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }

    public int getCy() {
        return cy;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }
}
