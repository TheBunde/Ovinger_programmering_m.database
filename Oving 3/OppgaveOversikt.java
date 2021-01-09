class OppgaveOversikt{
	Student student;
	private Student[] studenter = new Student[5];
	private int antStud = 0;

	public OppgaveOversikt(){
		this.student = student;
		this.studenter = new Student[5];
		this.antStud = antStud;
	}

	/*Registrer ny student*/
	public boolean regNyStudent(String navn){
		boolean retur = true;
		if(antStud == studenter.length){
			Student[] nyTab = new Student[studenter.length + 5];
			for (int i = 0; i < antStud; i++) {
			  nyTab[i] = studenter[i];
			}
			studenter = nyTab;
		}
		for(int i = 0; i < studenter.length; i++){
			if(studenter[i] != null){
				if(navn.equals(studenter[i].getNavn())){
					retur = false;
				}
			}
		}
		studenter[antStud] = new Student(navn,0);
		antStud++;
		return retur;
	}

	/*Finn antall studenter registrert*/
	public int finnAntStud(){
		return antStud;
	}

	/*Finn antall oppgaver*/
	public int finnAntOppgaver(String navn){
		int oppg = -1;
		for(int i = 0; i < studenter.length; i++){
			if (studenter[i] != null){
				if (navn.equalsIgnoreCase(studenter[i].getNavn())){
					oppg = studenter[i].getAntOppg();
				}
			}
		}
		return oppg;
	}


	/*Øk ant oppgaver for student*/
	public boolean økAntOppg(String navn, int økning){
		boolean hjelp = false;
		for(int i = 0; i < studenter.length; i++){
			if (studenter[i] != null){
				int oppg = studenter[i].getAntOppg();
				if (navn.equalsIgnoreCase(studenter[i].getNavn())){
					int antOppg = oppg + økning;
					studenter[i].setAntOppg(antOppg);
					hjelp = true;
				}
			}
		}
		return hjelp;
	}

	/*Finn alle navnene*/
	public String[] finnAlleNavn(){
		String [] tabell = new String[antStud + 1];
		if(antStud > 0){
			for(int i = 0; i < studenter.length; i++){
				if (studenter[i] != null){
					String navn = studenter[i].getNavn();
					tabell[i] = navn;
				}
			}
		}
		return tabell;
	}

	/*toString*/
	public String toString(){
		String alt = "";
		for(int i = 0; i < antStud; i++){
			if(studenter[i] == null){
				alt += "ikke registrert";
			}else{
				alt += studenter[i] + "\n";
			}
		}
		return alt;
	}
}