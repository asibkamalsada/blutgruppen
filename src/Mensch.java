public class Mensch {
    public Allel allel1;
    public Allel allel2;
    public Blutgruppe blutgruppe;

    public Mensch(Allel allel1, Allel allel2) {
        this.allel1 = allel1;
        this.allel2 = allel2;
        refreshBlutgruppe();
    }

    public Mensch(Mensch mensch1, Mensch mensch2){
        this(mensch1.allel1, mensch1.allel2, mensch2.allel1, mensch2.allel2);
    }

    public Mensch(Allel allel1, Allel allel2, Allel allel3, Allel allel4) {

        if ( Main.random.nextBoolean() ) {
            this.allel1 = allel1;
        } else {
            this.allel1 = allel2;
        }

        if ( Main.random.nextBoolean() ) {
            this.allel2 = allel3;
        } else {
            this.allel2 = allel4;
        }
        refreshBlutgruppe();

    }

    private void refreshBlutgruppe() {
        switch ( allel1 ) {
            case A:
                if ( allel2 == Allel.B ) {
                    this.blutgruppe = Blutgruppe.AB;
                } else {
                    this.blutgruppe = Blutgruppe.A;
                }
                break;
            case B:
                if ( allel2 == Allel.A ) {
                    this.blutgruppe = Blutgruppe.AB;
                } else {
                    this.blutgruppe = Blutgruppe.B;
                }
                break;
            default:
                switch ( allel2 ) {
                    case A:
                        this.blutgruppe = Blutgruppe.A;
                        break;
                    case B:
                        this.blutgruppe = Blutgruppe.B;
                        break;
                    default:
                        this.blutgruppe = Blutgruppe.NULL;
                }
        }
    }

}
