class Bord{
	private String [] bord;
	private int antBord;

	public Bord(String [] bord, int antBord){
		this.antBord = antBord;
		this.bord = new String[antBord];
		for(int i = 0; i < antBord; i++){
			this.bord[i] = bord[i];
		}
	}
	/*

	/*Finn antall ledige*/
	public int getAntLedig(){
		int antLedig = 0;
		for(int i = 0; i < bord.length; i++){
			if(bord[i]== ""){
				antLedig++;
			}
		}
		return antLedig;
	}

	/*Finn antall optatt*/
	public int getAntOptatt(){
		int antOptatt = 0;
		for(int i = 0; i < bord.length; i++){
			if(bord[i] != ""){
				antOptatt++;
			}
		}
		return antOptatt;
	}

	/*Frigi bord*/
	public void frigiBord(int ledig){
		int led = ledig - 1;
		bord[led] = "";
	}

	/*Reserver bord*/
	public boolean resBord(String navn){
		boolean sjekk = false;
		int teller = 0;
		while(sjekk == false && teller < bord.length){
			if(bord[teller] == ""){
				bord[teller] = navn;
				sjekk = true;
			}
			teller++;
		}
		return sjekk;
	}

	/*henter hele tabellen*/
	public String [] alleBord(){
		String [] alleBord = new String[bord.length];
		for(int i = 0; i < bord.length; i++){
			alleBord[i] = bord[i];
		}
		return alleBord;
	}

	/*henter hele tabellen som String*/
		public String toString(){
			String [] alleBord = new String[bord.length];
			String alle = "";
			for(int i = 0; i < bord.length; i++){
				alleBord[i] = bord[i];
			}
			for(int i = 0; i < bord.length; i++){
				if(alleBord[i] == ""){
					alle += (i+1) + ". ledig. \n";
				}else{
					alle += (i+1) + ". " + alleBord[i] + ". \n";
				}
			}

			return alle;
	}

}