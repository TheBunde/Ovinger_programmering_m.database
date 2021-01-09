class Staa extends Tribune{
    private int antSolgteBiletter;

    public Staa (String tribunenavn, int kapasitet, int pris) {
        super(tribunenavn,kapasitet,pris);
    }

    public int finnAntallSolgteBilletter(){
        return antSolgteBiletter;
    }

    public int finnInntekt(){
        int antBilleter = finnAntallSolgteBilletter();
        return antBilleter * super.getPris();
    }

    public Billett[] kjøpBilletter(int antØnsk){
        if(antØnsk + antSolgteBiletter > super.getKapasitet()){
            throw new IllegalArgumentException("Det er ikke plass på tribunen");
        }
        if(antØnsk <= 0){
            throw new IllegalArgumentException("Du må bestille minst 1 billett.");
        }
        Billett [] billetter = new Billett[antØnsk];
        for(int i = 0; i < billetter.length; i++){
            billetter[i] = new StaaplassBillett(getTribunenavn(), getPris());

        }
        antSolgteBiletter = antSolgteBiletter + antØnsk;
        return billetter;
    }

    public Billett [] kjøpBilletter(String [] navn){
        int antØnsk = navn.length;
        Billett [] billetter = kjøpBilletter(antØnsk);
        return billetter;
    }
}
