import java.util.ArrayList;

class Konferansesenter {
    private ArrayList<Rom> r = new ArrayList<>();

    public Konferansesenter(){
    }

    public boolean reserverRom(Tidspunkt fra, Tidspunkt til, Kunde k, int størelse){
        Reservasjon ress = new Reservasjon(fra, til, k);
        for(int i = 0; i < r.size(); i++ ) {
            if(r.get(i).ledig(ress) == false){
                if(r.get(i).getAntPlasser() >= størelse){

                    boolean sjekk = r.get(i).reserver(ress);
                    if(sjekk == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean registerRom(String romNr, int antPlasser){
        boolean retur = true;
        for(int i = 0; i < r.size(); i++ ) {
            if(r.get(i) != null){
                if(romNr.equals(r.get(i).getRomNr())){
                    retur = false;
                }
            }
        }
        if (retur == true){
            Rom nyRom = new Rom(romNr, antPlasser);
            r.add(nyRom);
        }
        return retur;
    }

    public int getAntRom(){
        return r.size();
    }

    public String finnRom(int indeks){
        return r.get(indeks).toString();
    }

    public String finnBesRom(String romNr){
        for(int i = 0; i < r.size(); i++ ){
            if(romNr.equals(r.get(i).getRomNr())){
                return r.get(i).toString();
            }
        }
        return null;
    }
}
