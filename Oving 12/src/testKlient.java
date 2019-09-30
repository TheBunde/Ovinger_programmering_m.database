import dyrehage.*;
public class testKlient {
    public static void main(String []args){

        Rovdyrfabrikk ny = new Rovdyrfabrikk();
        SkandinaviskeRovdyr dyret = ny.nyUlvetispe(
        213486, "Bur 65", "ada", 125678, 10,0);

        System.out.println(dyret.toString());
        System.out.println();
        System.out.println("Navn " + dyret.getNavn());
        System.out.println("Født: " + dyret.getfDato());
        System.out.println("Alder:" + dyret.getAlder());
        System.out.println("Adresse: " + dyret.getAdresse());
        dyret.flytt("Bur 34");
        System.out.println("Ny adresse: " + dyret.getAdresse());
        System.out.println("Antall kull: " + dyret.getAntKull());
        dyret.leggTilKull(2);
        dyret.leggTilNyttKull();
        System.out.println("Antall kull: " + dyret.getAntKull());
        System.out.println();
        System.out.println(dyret.skrivUtInfo());
    }
}