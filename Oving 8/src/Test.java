import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.io.*;
import static javax.swing.JOptionPane.*;

class Test {
    public static void main (String[] args) throws IOException{

        Tribune staa1 = new Staa ("Rød",20,50);
        Tribune staa2 = new Staa ("Blå",20,50);
        Tribune sitt = new Sitte ("Gul",20,100);
        Tribune vip = new VIP("VIP",20,150);
        Tribune[] tribuner = {staa2, staa1, sitt, vip};
        Tribune[] trib ={sitt, vip};

        String filnavn = "tribune.txt";


        FileReader les = new FileReader(filnavn);
        BufferedReader leser = new BufferedReader(les);
        String liste = leser.readLine();
        String lestInn = "Lest fra fil";
        while(liste != null){
            lestInn += ("\n" + liste);
            liste = leser.readLine();
        }
        leser.close();
        System.out.println(lestInn);

			FileWriter skriv = new FileWriter(filnavn, true);
			PrintWriter skriver = new PrintWriter(new BufferedWriter(skriv));
			for(int i = 0; i < trib.length; i++){
				skriver.println(trib[i].toString());
			}
			skriver.close();


        ArrayList<Tribune> tribune = new ArrayList<Tribune>();
        tribune.add(staa2);
        tribune.add(staa1);
        tribune.add(vip);
        tribune.add(sitt);
        Collections.sort(tribune, new SortbyInntekt());
        String[] navn ={"Hanne", "Helene"};

        staa1.kjøpBilletter(4);
        Billett[] kjøp = staa1.kjøpBilletter(navn);
        System.out.println("\nKjøpte ståbilletter:");
        for(int i = 0; i < kjøp.length; i++){
            System.out.println(kjøp[i]);
        }

        Billett[] kjøp2 = sitt.kjøpBilletter(navn);
        System.out.println("\nKjøpte sittebilletter :");
        for(int i = 0; i < kjøp2.length; i++){
            System.out.println(kjøp2[i]);
        }
        Billett[] kjøp3 = sitt.kjøpBilletter(4);
        System.out.println("\nKjøpte   sittebilletter :");
        for(int i = 0; i < kjøp3.length; i++){
            System.out.println(kjøp3[i]);
        }

        Billett[] kjøp4 = vip.kjøpBilletter(navn);
        System.out.println("\nKjøpte VIP sittebilletter :");
        for(int i = 0; i < kjøp4.length; i++){
            System.out.println(kjøp4[i]);
        }

        System.out.println("\nNye:");

        for(int i = 0; i < tribune.size(); i++){
            System.out.println(tribune.get(i).toString());
        }
    }
}
class SortbyInntekt implements Comparator<Tribune> {
    public int compare(Tribune a, Tribune b) {
        double TOLERANSE = 0.001;
        int inntekt1 = a.finnInntekt();
        int inntekt2 = b.finnInntekt();
        if(Math.abs(inntekt2 - inntekt1)<TOLERANSE){
            return 0;
        }else if(inntekt1 < inntekt2){
            return -1;
        }else{
            return 1;
        }
    }
}

