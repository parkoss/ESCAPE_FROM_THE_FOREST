import java.util.Scanner;

public class Hra {

    private Pohyb pohyb;
    private Scanner scanner;

    public Hra() {
        this.pohyb = new Pohyb("startovniKemp");
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Vítej ve hře! Jsi ve: " + pohyb.getAktualniLokace());
        zobrazDostupneLokace();
        System.out.println("Použij příkaz: jdi \"lokace\" pro pohyb. Napiš 'exit' pro konec.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Hra ukončena.");
                break;
            } else if (input.startsWith("jdi ")) {
                String cilovaLokace = input.substring(4).trim();
                pohyb.jdi(cilovaLokace);
                zobrazDostupneLokace();
            } else {
                System.out.println("Neznámý příkaz!");
            }
        }
    }

    private void zobrazDostupneLokace() {
        System.out.println("Můžeš jít do: " + String.join(", ", pohyb.getDostupneLokace()));
    }
}
