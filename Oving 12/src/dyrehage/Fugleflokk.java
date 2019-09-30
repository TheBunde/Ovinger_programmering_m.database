package dyrehage;
class Fugleflokk extends Dyregruppe{
    private int gjennomsnittligVekt;
    private String svømmer;

    public Fugleflokk(String norskNavn, String latNavn, String latFamilie,
    int ankommetDato, String adresse, String gruppenavn, int antIndivider, int gjennomsnittligVekt, String svømmer) {
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, gruppenavn, antIndivider);
        this.gjennomsnittligVekt = gjennomsnittligVekt;
        this.svømmer = svømmer;
    }

    public int getGjennomsnittligVekt(){
        return gjennomsnittligVekt;
    }

    public String getSvømmer(){
        return svømmer;
    }

    public String toString(){
        return super.toString() + "\nGjennomsnittlig vekt: " + gjennomsnittligVekt + ". Svømmer: " + svømmer + ".";
    }
}
