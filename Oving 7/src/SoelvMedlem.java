import java.time.LocalDate;

class SoelvMedlem extends BonusMedlem {

    public SoelvMedlem(int medlNr, Personalia pers, LocalDate innmeldtDato, int poeng){
        super(medlNr, pers,innmeldtDato);
        super.setPoeng(poeng);
    }

    public void registrerPoeng( int nyPoeng){
        int poenger = super.getPoeng();
        double ny = nyPoeng * 1.2;
        int nyePoeng = (int) ny + poenger;
        super.setPoeng(nyePoeng);
    }
}
