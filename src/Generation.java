import java.util.*;

public class Generation {

    List<Mensch> aktuelleMenschen;

    public Generation(Mensch... menschen) {
        this(Arrays.asList(menschen));
    }

    public Generation(Collection<Mensch> menschen) {
        aktuelleMenschen = new ArrayList<>(menschen);
    }

    public Generation(Generation startGeneration) {
        aktuelleMenschen = new ArrayList<>(startGeneration.aktuelleMenschen);
    }

    public Generation vermehren() {
        int haelfte = aktuelleMenschen.size() / 2;
        Collections.shuffle(aktuelleMenschen);
        Set<Mensch> neueMenschen = new HashSet<>();
        for ( int i = 0; i < haelfte; i++ ) {
            for ( int j = (int) (Math.random() * 2 + 2); j >= 0; j-- ) {
                neueMenschen.add(new Mensch(aktuelleMenschen.get(i), aktuelleMenschen.get(haelfte + i)));
            }
        }
        return new Generation(neueMenschen);
    }

    @Override
    public String toString() {
        double a_ = 0, b_ = 0, ab_ = 0, null_ = 0;
        for ( Mensch mensch : aktuelleMenschen ) {
            switch ( mensch.blutgruppe ) {
                case A:
                    a_++;
                    break;
                case B:
                    b_++;
                    break;
                case AB:
                    ab_++;
                    break;
                case NULL:
                    null_++;
                    break;
                default:
            }
        }
        return String.format(
                "  A |  B | AB |  0\n" +
                        "%4.2f | %4.2f | %4.2f | %4.2f",
                a_ / aktuelleMenschen.size(),
                b_ / aktuelleMenschen.size(),
                ab_ / aktuelleMenschen.size(),
                null_ / aktuelleMenschen.size()
        );
    }
}
