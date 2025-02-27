import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Pohyb {

    private Map<String, List<String>> mapa;
    private String aktualniLokace;

    public Pohyb(String startovniLokace) {
        this.mapa = new HashMap<>();
        this.aktualniLokace = startovniLokace;
        nactiMapu("map.txt");
    }

    private void nactiMapu(String soubor) {
        try (BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] casti = line.split("-");
                if (casti.length > 1) {
                    mapa.put(casti[0], Arrays.asList(Arrays.copyOfRange(casti, 1, casti.length)));
                }
            }
        } catch (IOException e) {
            System.out.println("Chyba při načítání mapy: " + e.getMessage());
        }
    }

    public void jdi(String novaLokace) {
        List<String> sousedniLokace = mapa.getOrDefault(aktualniLokace, new ArrayList<>());
        if (sousedniLokace.contains(novaLokace)) {
            aktualniLokace = novaLokace;
            System.out.println("Přesunul ses do: " + aktualniLokace);
        } else {
            System.out.println("Nemůžeš jít do této lokace!");
        }
    }

    public String getAktualniLokace() {
        return aktualniLokace;
    }

    public List<String> getDostupneLokace() {
        return mapa.getOrDefault(aktualniLokace, new ArrayList<>());
    }
}
