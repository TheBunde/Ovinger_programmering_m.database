abstract class Tribune {
    private String tribunenavn;
    private int kapasitet;
    private int pris;
    private Billett bill;

    public Tribune(String tribunenavn, int kapasitet, int pris){
        this.tribunenavn = tribunenavn;
        this.kapasitet = kapasitet;
        this.pris = pris;
    }

    public String getTribunenavn(){
        return tribunenavn;
    }

    public int getKapasitet(){
        return kapasitet;
    }

    public int getPris(){
        return pris;
    }

    public abstract Billett  [] kjøpBilletter(int antØnsk);

    public abstract Billett [] kjøpBilletter(String [] navn);

    public abstract int finnAntallSolgteBilletter();

    public abstract int finnInntekt();

    public String toString() {
       return "Tribunenavn: " + getTribunenavn() + ". Kapasitet: " + getKapasitet() + ". Pris: " + getPris() +
               ". Antall solgte billeter: " + finnAntallSolgteBilletter() + ". Inntekt: " + finnInntekt();
    }
}
