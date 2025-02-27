import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapaLesa {
    private int start = 0;
    private int poloha=start;
    private ArrayList<String> povolenyLokace=new ArrayList<>();
    private ArrayList<Lokace>vsechnyLokace=new ArrayList<>();
    Lokace lokace;
    private HashMap<String, Lokace> lokaceMapa = new HashMap<>();
    private String aktualniLokace;

    public boolean nactiMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] lines = line.split("-");
                String nazevLokace =lines[0];
                for (int i = 0; i < lines.length; i++) {
                    povolenyLokace.add(lines[i]);
                }
                lokaceMapa.put(nazevLokace, new Lokace(nazevLokace, povolenyLokace));
                lokace=new Lokace(lines[0],povolenyLokace);
                vsechnyLokace.add(lokace);
                lokaceMapa.put(lokace.getNazev(), new Lokace(lokace.getNazev(), povolenyLokace));
            }
            aktualniLokace="startovniKemp";
            return true;

        }catch (IOException e){
            return false;
        }
    }
    public Lokace getLokace(String nazev) {
        return lokaceMapa.get(nazev);
    }

    public String getAktualniLokace() {
        return aktualniLokace;
    }

    public void setAktualniLokace(String novaLokace) {
        aktualniLokace = novaLokace;
    }
}
