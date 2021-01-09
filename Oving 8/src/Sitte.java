class Sitte extends Tribune {
    private int [] antOpptatt;

    public Sitte(String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn,kapasitet,pris);
        this.antOpptatt = new int[5];
    }

    public int finnAntallSolgteBilletter(){
        int antOppt = 0;
        if(antOpptatt == null){
            return 0;
        }
        for(int i = 0; i < antOpptatt.length; i++){
            antOppt += antOpptatt[i];
        }
        return antOppt;
    }

    public int finnInntekt(){
        int antBilleter = finnAntallSolgteBilletter();
        return antBilleter * super.getPris();
    }

    public Billett  [] kjøpBilletter(int antØnsk){
        if(antØnsk + finnAntallSolgteBilletter() > super.getKapasitet()){
            throw new IllegalArgumentException("Det er ikke plass på tribunen");
        }
        if(antØnsk <= 0){
            throw new IllegalArgumentException("Du må bestille minst 1 billett.");
        }
        Billett [] billetter = new Billett[antØnsk];
        int teller = 0;
        int rad = getRad(antØnsk);
        while(antØnsk > teller){
            int antOpt = antOpptatt[rad];
            int plass = getSete(antØnsk, antOpt);
            if (plass == -1){
                throw new IllegalArgumentException("Plass returnerer -1");
            }
            billetter[teller] = new SitteplassBillett(getTribunenavn(), getPris(), rad +1, plass + 1);
            antOpptatt[rad] = antOpptatt[rad] + 1;
            teller++;
        }
        return billetter;
    }

   public Billett [] kjøpBilletter(String [] navn){
       int antØnsk = navn.length;
       Billett [] billetter = kjøpBilletter(antØnsk);
       return billetter;
   }

   public int getRad(int antØnsk){
       int antMax = 5;
       for(int i = 0; i < antOpptatt.length;i++){
           if(antOpptatt[i] + antØnsk <= antMax) {
               return i;
           }
       }
       return -1;
   }

   public int getSete(int antØnsk, int antOppt){
       int rad = getRad(antØnsk);
       if(rad == -1){
           throw new IllegalArgumentException("Rad gir -1");
       }
       int sete = antOppt;
       return sete;

   }
}


