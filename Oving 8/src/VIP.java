class VIP extends Tribune{
    private String [][] tilskuer;

    public VIP (String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn,kapasitet,pris);
        this.tilskuer = new String [4][5];
    }

    public int finnAntallSolgteBilletter(){
        int antSolgte = 0;
        for(int i = 0; i < tilskuer.length;  i++){
            for(int j = 0; j < tilskuer[i].length; j++){
                if(tilskuer[i][j] != null){
                    antSolgte++;
                }
            }
        }
        return antSolgte;
    }

    public int finnInntekt(){
        int antBilleter = finnAntallSolgteBilletter();
        return antBilleter * super.getPris();
    }

    public Billett  [] kjøpBilletter(int antØnsk){
        return null;
    }

    public Billett [] kjøpBilletter(String [] navn){
        if(navn.length <= 0){
            throw new IllegalArgumentException("Må bestille minst 1 billett.");
        }
        int antØnsk = navn.length;
        Billett [] billetter = new Billett[antØnsk];
        int teller = 0;
        while(antØnsk > 0){
            int rad = getRad(antØnsk);
            int plass = getSete(antØnsk);
            billetter[teller] = new SitteplassBillett(getTribunenavn(), getPris(), rad +1, plass +1);
            tilskuer[rad][plass] = navn[teller];
            teller++;
            antØnsk--;
        }
        return billetter;
    }

    public int getRad(int antØnsk){
        int antLedig = 0;
        for(int i = 0; i < tilskuer.length;i++){
            for (int j = 0; j < tilskuer[i].length; j++){
                if(tilskuer[i][j] == null){
                    antLedig++;
                }
                if (antLedig >= antØnsk){
                    return i;
                }
            }

        }
        return -1;
    }

    public int getSete(int antØnsk){
        int rad = getRad(antØnsk);
        for(int i = 0; i < tilskuer[rad].length; i++){
            if(tilskuer[rad][i] == null){
                return (i);
            }
        }
        return -1;
    }
}
