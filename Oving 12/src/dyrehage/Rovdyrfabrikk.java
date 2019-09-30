package dyrehage;

public class Rovdyrfabrikk {
    public SkandinaviskeRovdyr nyBinne(int ankommetDato, String adresse, String navn, int fDato, int alder, int antKull){
        return new Hunnindivid( "Brunbjørn",  "Ursus arctos",  "Ursidae", ankommetDato,  adresse,  navn,  fDato,  false,  "Ja",  alder, antKull);
    }

    public SkandinaviskeRovdyr nyHannbjørn(int ankommetDato, String adresse, String navn, int fDato, int alder, int antKull) {
        return new Hannindivid("Brunbjørn", "Ursus arctos", "Ursidae", ankommetDato, adresse, navn, fDato, true, "Ja", alder,antKull);
    }

    public SkandinaviskeRovdyr nyUlvetispe(int ankommetDato, String adresse, String navn, int fDato, int alder, int antKull) {
        return new Hunnindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, navn, fDato, false, "Ja", alder,antKull);
    }

    public SkandinaviskeRovdyr nyUlvehann(int ankommetDato, String adresse, String navn, int fDato, int alder, int antKull) {
        return new Hannindivid("Ulv", "Canis lupus", "Canidae", ankommetDato, adresse, navn, fDato, true, "Ja", alder,antKull);
    }
}
