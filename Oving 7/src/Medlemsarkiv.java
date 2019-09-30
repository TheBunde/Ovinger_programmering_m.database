import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

class Medlemsarkiv {
    private ArrayList<BonusMedlem> medlem = new ArrayList<BonusMedlem>();

    public Medlemsarkiv(){

    }

    public int finnPoeng(int medlNr, String passord){
        for(int i = 0; i < medlem.size(); i++){
            if(medlem.get(i).Passord(passord) == true){
                if(medlem.get(i).getMedlnr() == medlNr){
                    return medlem.get(i).getPoeng();
                }
            }
        }
        return -1;
    }

    public boolean registrerPoeng(int medlNr, int nyPoeng){
        for(int i = 0; i < medlem.size(); i++) {
            if(medlem.get(i).getMedlnr() == medlNr){
                medlem.get(i).registrerPoeng(nyPoeng);
                return true;
            }
        }
        return false;
    }

    public int nyMedlem(Personalia pers, LocalDate inmeldt){
        int nyMedlNr = finnLedigNr();
        BasicMedlem nyMedl = new BasicMedlem(nyMedlNr,pers,inmeldt);
        medlem.add(nyMedl);
        return nyMedlNr;
    }

    private int finnLedigNr(){
        boolean sjekk = false;
        int nyMedlNr = -1;
        while(true){
            Random random = new Random();
            nyMedlNr = random.nextInt(1000)+1;
            if (medlem.size() == 0) {
                return nyMedlNr;
            }
            for (int j = 0; j < medlem.size(); j++){
                if(medlem.get(j).getMedlnr() == nyMedlNr){
                    sjekk = true;
                    break;
                }
            }
            if (!sjekk){
                return nyMedlNr;
            }
            sjekk = false;
        }
    }

    public void sjekkMedlemmer(){
        LocalDate dato = LocalDate.of(2008, 5, 4);

        for(int i = 0; i < medlem.size(); i++){
            BonusMedlem m = medlem.get(i);
            if(m instanceof BasicMedlem){
                int poeng = medlem.get(i).finnKvalPoeng(dato);
                int medlNr = medlem.get(i).getMedlnr();
                Personalia pers = medlem.get(i).getPers();
                LocalDate inmeldt = medlem.get(i).getInnmeldtDato();
                if(25000 <= poeng){
                    SoelvMedlem nyGMedl = new SoelvMedlem(medlNr,pers,inmeldt, poeng);
                    medlem.set(i, nyGMedl);
                    if(75000 <= poeng) {
                        GullMedlem nySMedl = new GullMedlem(medlNr, pers, inmeldt, poeng);
                        medlem.set(i, nySMedl);
                    }
                }

            }
            if(m instanceof SoelvMedlem){
                int poeng = medlem.get(i).finnKvalPoeng(dato);
                int medlNr = medlem.get(i).getMedlnr();
                Personalia pers = medlem.get(i).getPers();
                LocalDate inmeldt = medlem.get(i).getInnmeldtDato();
                GullMedlem nyMedl = new GullMedlem(medlNr,pers,inmeldt, poeng);
                medlem.set(i, nyMedl);
            }

        }
    }

    public String toString(){
        String alt = "";
        for(int i = 0; i < medlem.size(); i++){
            alt += "\n MedlNr: " + medlem.get(i).getMedlnr() + ". " + medlem.get(i).getPers() + ". Inmeldt: " + medlem.get(i).getInnmeldtDato() + ". Poeng: " + medlem.get(i).getPoeng() + ". " + medlem.get(i);
        }
        return alt;
    }
}
