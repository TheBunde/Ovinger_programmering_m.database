class Restaurant{
	private Bord bordene;
	private String restNavn;
	private int etablår;

	public Restaurant(Bord bordene, String restNavn, int etablår){
		this.bordene = bordene;
		this.restNavn = restNavn;
		this.etablår = etablår;
	}

	/*get navn*/
	public String getNavn(){
		return restNavn;
	}

	/*set navn*/
	public void setNavn(String nyNavn){
		this.restNavn = nyNavn;
	}

	/*etableringsår*/
	public int getEtableringsår(){
		return etablår;
	}

	/*hvor gammel er restauranten*/
	public int alderRestaurant(){
		java.util.Calendar år = java.util.Calendar.getInstance();
		int nå = år.get(java.util.Calendar.YEAR);
		int alder = nå - etablår;
		return alder;
	}

	/*ant ledige bord*/
	public int getLedig(){
		return bordene.getAntLedig();
	}


	/*reserver flere bord på en person*/
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