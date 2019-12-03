import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static Allel[] allele = Allel.values();
    public static Blutgruppe[] blutgruppen = Blutgruppe.values();

    public static Random random = new Random();

    public static void main(String[] args) throws IOException {
        int anzahlStartMenschen = 0;
        int anzahlGenerationen = 0;
        if (args.length == 2){
            anzahlStartMenschen = Integer.parseInt(args[0]);
            anzahlGenerationen = Integer.parseInt(args[1]);
        } else {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Anzahl StartMenschen:");
            anzahlStartMenschen = Integer.parseInt(br.readLine());
            System.out.println("Anzahl Generation:");
            anzahlGenerationen = Integer.parseInt(br.readLine());
        }
        Erbschaftsimulator simulator = new Erbschaftsimulator(anzahlStartMenschen);
        simulator.starteSimulation(anzahlGenerationen);
        simulator.ergebniss();
    }
}
