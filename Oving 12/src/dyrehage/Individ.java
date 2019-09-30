package dyrehage;
abstract class Individ extends Dyr implements SkandinaviskeRovdyr {
    private String navn;
    private int fDato;
    private boolean hanndyr;
    private String farlig;
    private int alder;

    public Individ (String norskNavn, String latNavn, String latFamilie,
                    int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, String farlig, int alder){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse);
        this.navn = navn;
        this.fDato = fDato;
        this.hanndyr = hanndyr;
        this.farlig = farlig;
        this.alder = alder;
    }

    public String getNavn(){
        return navn;
    }

    public int getfDato(){
        return fDato;
    }

    public boolean getHanndyr(){
        return hanndyr;
    }

    public String getFarlig(){
        return farlig;
    }

    public  int getAlder(){
        return alder;
    }

    public void flytt(String nyAdresse){
        super.setAdresse(nyAdresse);
    }

    public String  skrivUtInfo(){
        return toString();
    }


    public abstract int getAntKull();


    public abstract void leggTilKull(int antall);


    public abstract void leggTilNyttKull();

    public String toString(){
        String kjønn = "";
        if(hanndyr == true) {
            kjønn = "Hannkjønn";
        }else{
            kjønn = "Hunnkjønn";
        }

        return super.toString() + "\nNavn: " + navn + ". Fødselsdato: " + fDato + ". Kjønn: " + kjønn + ". Farlig: " + farlig + ".";
    }
}
