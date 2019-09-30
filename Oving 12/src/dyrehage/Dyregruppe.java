package dyrehage;
abstract class Dyregruppe extends Dyr {
    private String gruppenavn;
    private int antIndivider;

    public Dyregruppe(String norskNavn, String latNavn, String latFamilie,
                      int ankommetDato, String adresse, String gruppenavn, int antIndivider){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.gruppenavn = gruppenavn;
        this.antIndivider = antIndivider;
    }

    public String getGruppenavn(){
        return gruppenavn;
    }

    public int getAntIndivider(){
        return antIndivider;
    }

    public void setAntIndivider(int nyttAntall){
        this.antIndivider = nyttAntall;
    }

    @Override
    public String getNorskeNavn(){
        return "Gruppe av " + super.getNorskNavn();
    }

    public String toString(){
        return super.toString() + "\nGruppenavn: " + gruppenavn + ". Antall individer: " + antIndivider +".";
    }
}
