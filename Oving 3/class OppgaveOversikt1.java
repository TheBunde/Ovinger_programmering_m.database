import java.util.ArrayList;
class OppgaveOversikt1{
	Student student;
	private ArrayList<Student> studenter = new ArrayList <Student>();
	private int antStud = 0;

	public OppgaveOversikt1(){
		this.student = student;
		this.antStud = antStud;
	}

	/*Registrer ny student*/
	public boolean regNyStudent(String navn){
		boolean retur = true;
		for(int i = 0; i < studenter.size(); i++){
			if(studenter.get(i) != null){
				if(navn.equals(studenter.get(i).getNavn())){
					retur = false;
				}
			}
		}
		studenter.add(new Student(navn,0));
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
		for(int i = 0; i < studenter.size(); i++){
			if (studenter.get(i) != null){
				if (navn.equalsIgnoreCase(studenter.get(i).getNavn())){
					return studenter.get(i).getAntOppg();
				}
			}
		}
		return oppg;
	}


	/*Øk ant oppgaver for student*/
	public boolean økAntOppg(String navn, int økning){
		boolean hjelp = false;
		for(int i = 0; i < studenter.size(); i++){
			if (studenter.get(i) != null){
				int oppg = studenter.get(i).getAntOppg();
				if (navn.equalsIgnoreCase(studenter.get(i).getNavn())){
					int antOppg = oppg + økning;
					studenter.get(i).setAntOppg(antOppg);
					//Student s = (studenter.get(i).setAntOppg(antOppg));
					//studenter.remove(i);
					//s.setAntOppg(antOppg);
					//studenter.add(i, s);
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
			for(int i = 0; i < studenter.size(); i++){
				if (studenter.get(i) != null){
					String navn = studenter.get(i).getNavn();
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
			if(studenter.get(i) == null){
				alt += "ikke registrert";
			}else{
				alt += studenter.get(i) + "\n";
			}
		}
		return alt;
	}
}