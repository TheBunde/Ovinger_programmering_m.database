
class Klient{
    public static void main(String[] args){
        Meny meny = new Meny();

        int valg = meny.lesValg();
        while(valg >= 0){
            meny.utforOppg(valg);
            valg = meny.lesValg();
        }

    }
}