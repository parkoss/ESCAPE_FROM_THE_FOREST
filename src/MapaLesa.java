import javax.xml.stream.Location;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MapaLesa {
    private int start = 0;
    private int poloha=start;

    public boolean nactiMapu(){
        try(BufferedReader br = new BufferedReader(new FileReader("mapa.txt"))){
            String line;
            while((line=br.readLine())!=null) {
                String[] lines = line.split(";");
            }


            return true;
        }catch (IOException e){
            return false;
        }
    }
}
