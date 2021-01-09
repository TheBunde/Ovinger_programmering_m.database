class Restaurant{
	private Bord bordene;
	private String restNavn;
	private int etabl�r;

	public Restaurant(Bord bordene, String restNavn, int etabl�r){
		this.bordene = bordene;
		this.restNavn = restNavn;
		this.etabl�r = etabl�r;
	}

	/*get navn*/
	public String getNavn(){
		return restNavn;
	}

	/*set navn*/
	public void setNavn(String nyNavn){
		this.restNavn = nyNavn;
	}

	/*etablerings�r*/
	public int getEtablerings�r(){
		return etabl�r;
	}

	/*hvor gammel er restauranten*/
	public int alderRestaurant(){
		java.util.Calendar �r = java.util.Calendar.getInstance();
		int n� = �r.get(java.util.Calendar.YEAR);
		int alder = n� - etabl�r;
		return alder;
	}

	/*ant ledige bord*/
	public int getLedig(){
		return bordene.getAntLedig();
	}


	/*reserver flere bord p� en person*/
	public String reservasjon(String navn, int antBord){
		int ledig = getLedig();
		int bord = antBord;
		boolean verdi = true;
		if(ledig >= bord){
			while(verdi == true && bord != 0){
				boolean test = bordene.resBord(navn);
				bord--;
				if(test == false){
					verdi = false;
				}
			}
		}else{
			verdi = false;
		}
		if(verdi == true){
			return "Vellykket";
		}else{
			return "Fullt";
		}
	}

	/*Finn bord en person har reservert*/
	public int [] bordPers(String resNavn){
		String [] liste = bordene.alleBord();
		int[]resPers = new int[liste.length];
		int teller = 0;
		for(int i = 0; i < resPers.length; i++){
			if(liste[i].equals(resNavn)){
				resPers[teller] = i+1;
				teller++;
			}
		}
		return resPers;
	}

	/*Finn alle ledige bord*/
	public int ledig(){
		String [] liste = bordene.alleBord();
		//int[]ledig = new int[liste.length];
		//int teller = 0;
		int led = 0;
		for(int i = 0; i < liste.length; i++){
			if(liste[i] == ""){
				led++;
				//ledig[teller] = i;
			}
		}


		return led;
	}
}