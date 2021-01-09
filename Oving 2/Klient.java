import static javax.swing.JOptionPane.*;
class Klient{
	public static void main(String[] args){
		String [] tabell = {"Anne","","Anne","Per",""};
		Bord bordene = new Bord(tabell,5);
		Restaurant rest = new Restaurant(bordene, "Egon", 1972);

		System.out.println("Navn: " + rest.getNavn() + ". Grunnlagt: " + rest.getEtableringsår() + "\når: " + rest.alderRestaurant());
		System.out.println("Hele lista: \n" + bordene.toString());
		System.out.println("Antall optatt: " + bordene.getAntOptatt());
		System.out.println("Antall ledige: " + bordene.getAntLedig());
		System.out.println();


		String[] VALG = {"Reserver bord","Reservasjon på navn", "frigi bord", "Avslutt"};
		int valg = showOptionDialog(null, "Valg", "Meny", DEFAULT_OPTION, PLAIN_MESSAGE, null, VALG, VALG[0]);
		if(valg == 3){
			valg = -1;
		}
		switch(valg){
			case 0:
				String navn = showInputDialog("Navn:");
				String tall = showInputDialog("Antall bord");
				int antBord = Integer.parseInt(tall);
				System.out.println("Reservasjon: " + rest.reservasjon(navn,antBord));
				System.out.println(bordene.toString());
				break;
			case 1:
				String resNavn = showInputDialog("Navn:");
				int [] lis = rest.bordPers(resNavn);
				int tell = 0;
				int nummer = 0;
				for(int i = 0; i < lis.length; i++){
					if(lis[i] != 0){
						tell++;
					}
				}
				System.out.println("Det er reservert " + tell + " bord på navnet " + resNavn);
				break;
			case 2:
				String tall2 = showInputDialog("Frigi bord: ");
				int ledig = Integer.parseInt(tall2);
				bordene.frigiBord(ledig);
				System.out.println("Det er " + rest.ledig() + " ledige bord.");
				System.out.println(bordene.toString());
				break;
			default:
			break;
		}
	}
}

