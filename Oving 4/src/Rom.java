import java.util.ArrayList;

class Rom {
    private String romNr;
    private int antPlasser;
    private ArrayList<Reservasjon> res = new ArrayList<>();

    public Rom(String romNr, int antPlasser){
        this.romNr = romNr;
        this.antPlasser = antPlasser;
    }

    public String getRomNr(){
        return romNr;
    }

    public int getAntPlasser(){
        return antPlasser;
    }

    public boolean reserver(Reservasjon ress){
        res.add(ress);
        return true;
    }

    public boolean ledig(Reservasjon ress){
        boolean hjelp = false;
        Tidspunkt sjekkFraTid = ress.getFraTid();
        Tidspunkt sjekkTilTid = ress.getTilTid();
        for(int i = 0; i  < res.size(); i++){
            hjelp = res.get(i).overlapp(sjekkFraTid, sjekkTilTid);
            if(hjelp == true){
                return true;
            }
        }

        return hjelp;
    }

    public String toString(){
        String liste = "";
        for(int i = 0; i < res.size(); i++) {
            liste += res.get(i).toString() + "\n";
        }
        return "\nRomnummrer: " + romNr + "\nAntall plasser: " + antPlasser + " .\nReservasjoner: " + liste + ".\n";
    }

    public static void main(String[] args){
        String romNr = "1";
        Rom r1 = new Rom("1",4);

        if(r1.getRomNr().equals(romNr)){
            System.out.println("Test 1. Velykket");
        }

        if(r1.getAntPlasser() == 4){
            System.out.println("Test 2. Velykket");
        }

        Kunde meg = new Kunde("helene", "4545454");
        Tidspunkt en = new Tidspunkt(123456789012L);
        Tidspunkt to = new Tidspunkt(123456789013L);
        Tidspunkt tre = new Tidspunkt(234567890123L);
        Tidspunkt fire = new Tidspunkt(234567890124L);
        Reservasjon res1 = new Reservasjon(en,to,meg);
        Reservasjon res2 = new Reservasjon(en,to,meg);
        Reservasjon res3 = new Reservasjon(tre,fire,meg);

        r1.reserver(res1);
        if(r1.ledig(res2)==true){
            System.out.println("Test 3. Velykket");
        }

        if(r1.ledig(res3)==false){
            System.out.println("Test 4. Velykket");
        }
    }
}
