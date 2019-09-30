package dyrehage;

public class Hannindivid extends Individ {
    private int antKull;

    public Hannindivid(String norskNavn, String latNavn, String latFamilie, int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, String farlig, int alder, int altKull){
        super(norskNavn, latNavn, latFamilie, ankommetDato, adresse, navn, fDato, hanndyr, farlig, alder);
        this.antKull = antKull;
    }

    public int getAntKull(){
        return 0;
    }

    public void leggTilNyttKull(){
    }

    public void leggTilKull(int antall){
    }

}
