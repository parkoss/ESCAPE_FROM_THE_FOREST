import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapaLesa {
    private int start = 0;
    private int poloha=start;
    private ArrayList<String> povolenyLokace=new ArrayList<>();
    private ArrayList<Lokace>vsechnyLokace=new ArrayList<>();
    Lokace lokace;

    public boolean nactiMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] lines = line.split("-");
                for (int i = 0; i < lines.length; i++) {
                    povolenyLokace.add(lines[i]);
                }
                lokace=new Lokace(lines[0],povolenyLokace);
                vsechnyLokace.add(lokace);

            }


            return true;
        }catch (IOException e){
            return false;
        }
    }
}
