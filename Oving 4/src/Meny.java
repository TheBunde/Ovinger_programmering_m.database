import static javax.swing.JOptionPane.*;

class Meny {
    private final String[] VALG = {"Registrer rom","Reserver", "Skriv ut all informasjon", "Finn bestemt rom", "Avslutt"};
    Konferansesenter konf = new Konferansesenter();
    //Kunde k = new Kunde();
    //Tidspunkt fra = new Tidspunkt();
    //Tidspunkt til = new Tidspunkt();


    public int lesValg(){
        int valg = showOptionDialog(null, "Valg", "Meny", DEFAULT_OPTION, PLAIN_MESSAGE, null, VALG, VALG[0]);
        if(valg == 4){
            valg = -1;
        }
        return valg;
    }

    public void utforOppg(int valg){
        switch(valg){
            case 0:
                String romNr = showInputDialog("RomNr:");
                String ant = showInputDialog("Plass:");
                int antPlasser = Integer.parseInt(ant);
                boolean sjekk = konf.registerRom(romNr,antPlasser);
                if (sjekk == true){
                    showMessageDialog(null,"Registrering av rom fullført");
                }else{
                    showMessageDialog(null,"Registrering av rom feilet");
                }
                break;
            case 1:
                String navn = showInputDialog("Navn:");
                String tlf = showInputDialog("tlf:");
                Kunde k = new Kunde(navn,tlf);
                String gruppe = showInputDialog("Størelse på gruppen:");
                int størelse = Integer.parseInt(gruppe);
                String tidFra = showInputDialog("Reserver fra:\n Skriv i formatet ååååmmddttmm");
                long fraTid = Long.parseLong(tidFra);
                Tidspunkt fra = new Tidspunkt(fraTid);
                String tidTil = showInputDialog("Reserver til:\n Skriv i formatet ååååmmddttmm");
                long tilTid = Long.parseLong(tidTil);
                Tidspunkt til = new Tidspunkt(tilTid);
                boolean hjelp = konf.reserverRom(fra, til, k, størelse);
                if(hjelp == true){
                    showMessageDialog(null,"Reservering av rom fullført");
                }else{
                    showMessageDialog(null,"Reservering av rom feilet");
                }

                break;
            case 2:
                int rom = konf.getAntRom();
                String lister = "";
                for (int indeks = 0; indeks < rom; indeks++){
                    lister += konf.finnRom(indeks);
                }
                showMessageDialog(null,"Antall rom: " + rom + ".\nInfo om alle rom: " + lister);
                break;
            case 3:
                romNr = showInputDialog("RomNr:");
                String rommet = konf.finnBesRom(romNr);
                showMessageDialog(null,rommet);
                break;
            default:
                break;
        }
    }
}
