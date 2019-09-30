import java.time.LocalDate;

class TestKlient {
    public static void main (String [] args){

        Medlemsarkiv test = new Medlemsarkiv();
        Personalia helene = new Personalia("Helene", "Jonson", "helene@dot.com", "123");
        Personalia ingunn = new Personalia("Ingunn", "Jonson", "ingunn@dot.com", "456");
        Personalia hanne = new Personalia("Hanne", "Loftesnes", "hanne@dot.com", "789");
        Personalia eline = new Personalia("Eline", "Forberg", "eline@dot.com", "012");

        LocalDate dato = LocalDate.of(2007, 11, 4);
        LocalDate dato1 = LocalDate.of(2003, 11, 4);


        int res = test.nyMedlem(helene, dato);
        int res1 = test.nyMedlem(ingunn, dato);
        int res2 = test.nyMedlem(hanne, dato);
        int res3 = test.nyMedlem(eline, dato1);


        int sjekk1 = test.finnPoeng(res, "123");
        if(sjekk1 != -1){
            System.out.println("Test 1. OK");
        }

        if(test.registrerPoeng(res1, 5000) == true){
            System.out.println("Test 2. OK");
        }

        System.out.println(test.toString());
        test.registrerPoeng(res1, 90000);
        test.registrerPoeng(res2, 30000);
        test.registrerPoeng(res3, 90000);
        test.sjekkMedlemmer();
        System.out.println(test.toString());




    }
}
