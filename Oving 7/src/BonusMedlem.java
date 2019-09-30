import java.time.*;

import static java.time.temporal.ChronoUnit.DAYS;

abstract class BonusMedlem {
    private final int medlNr;
    private final Personalia pers;
    private final  LocalDate innmeldtDato;
    private int poeng = 0;

    public BonusMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato){
        this.medlNr = medlNr;
        this.pers = pers;
        this.innmeldtDato = innmeldtDato;
    }

    public int getMedlnr(){
        return medlNr;
    }

    public Personalia getPers(){
        return pers;
    }

    public String persInfo(){
        return pers.toString();
    }

    public LocalDate getInnmeldtDato(){
        return innmeldtDato;
    }

    public int getPoeng(){
        return poeng;
    }

    public int finnKvalPoeng(LocalDate testdato){

        long dager = innmeldtDato.until(testdato, DAYS);
        /*
        int dagerMellom = Period.between(date1, date2).getDays();
        int månedMellom = Period.between(date1, date2).getMonths();
        int årMellom = Period.between(date1, date2).getYears();
        int måned = månedMellom * 30;
        int år = årMellom * 365;
        int totDager = dagerMellom + år + måned;
        */
        if(dager < 365){
            return poeng;
        }
        return 0;
    }

    public boolean Passord(String passordet){
        return pers.okPassord(passordet);
    }

    public void setPoeng( int nyePoeng){
        this.poeng = nyePoeng;
    }

    public abstract void registrerPoeng(int nyPoeng);
}
