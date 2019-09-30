class Valuta {
    private String valutanavn;
    private double kurs;
    private int enhet;

    public Valuta(String valutanavn, double kurs, int enhet){
        this.valutanavn = valutanavn;
        this.kurs = kurs;
        this.enhet = enhet;
    }

    public String getValutanavn(){
        return valutanavn;
    }


    public double getKurs(){
        return kurs;
    }

    public int getEnhet(){
        return enhet;
    }

    public String toString(){
        return "Valtanavn: " + valutanavn + ", Kurs: " + kurs + ", Enhet: " + enhet +".";
    }
}
