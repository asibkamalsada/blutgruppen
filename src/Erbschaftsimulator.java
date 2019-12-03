import java.util.HashSet;
import java.util.Set;

public class Erbschaftsimulator {

    public Generation startGeneration;
    public Generation endGeneration;

    public Erbschaftsimulator(int startMenschenAnzahl) {
        Set<Mensch> startMenschen = new HashSet<>();
        for ( int i = 0; i < startMenschenAnzahl; i++ ) {
            startMenschen.add(
                    new Mensch(
                            Main.allele[ (int) (Math.random() * 3) ],
                            Main.allele[ (int) (Math.random() * 3) ]
                    )
            );
        }
        startGeneration = new Generation(startMenschen);
    }

    public void starteSimulation(int anzahlGenerationen) {
        endGeneration = new Generation(startGeneration);
        for ( int i = 0; i < anzahlGenerationen; i++ ) {
            System.out.println(
                    i + 1 + ". Generation (" + endGeneration.aktuelleMenschen.size() + ")\n" + endGeneration + "\n"
            );
            endGeneration = endGeneration.vermehren();
        }
    }

    public void ergebniss() {
        if ( endGeneration != null ) {
            System.out.println(
                    "Startgeneration:\n" +
                            startGeneration + "\n" +
                            "Endgeneration:\n" +
                            endGeneration
            );
        }
    }
}
