import java.util.ArrayList;

public class Lokace {
    private String nazev;
    private ArrayList<String>povolenyLokace=new ArrayList<>();

    public Lokace(String nazev, ArrayList<String> povolenyLokace) {
        this.nazev = nazev;
        this.povolenyLokace = povolenyLokace;
    }
    public String getNazev() {
        return nazev;
    }

    public ArrayList<String> getPovoleneLokace() {
        return povolenyLokace;
    }
}
