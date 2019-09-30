import java.time.LocalDate;

class GullMedlem extends BonusMedlem {

    public GullMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng){
        super(medlNr, pers,innmeldtDato);
        super.setPoeng(poeng);
    }

    public void registrerPoeng( int nyPoeng){
        int poenger = super.getPoeng();
        double ny = nyPoeng * 1.5;
        int nyePoeng = (int) ny + poenger;
        super.setPoeng(nyePoeng);
    }
}
