package dyrehage;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

public class Hunnindivid extends Individ{
    private int antKull;

    public Hunnindivid(String norskNavn, String latNavn, String latFamilie,
                       int ankommetDato, String adresse, String navn, int fDato, boolean hanndyr, String farlig, int alder, int antKull){
        super(norskNavn,latNavn,latFamilie, ankommetDato, adresse, navn, fDato, hanndyr, farlig, alder);
        this.antKull = antKull;
    }

    public int getAntKull(){
        return antKull;
    }


    public void leggTilNyttKull(){
        antKull++;
    }

    public void leggTilKull(int antall){
        this.antKull = antall;
    }

    public String toString(){
        return super.toString() + " Antall kull: " + antKull + ".";
    }
}
