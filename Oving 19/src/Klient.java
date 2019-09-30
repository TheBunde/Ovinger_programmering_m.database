import java.sql.*;


public class Klient {
    public static void main(String[]args) throws Exception{
        String dbDriver = "com.mysql.cj.jdbc.Driver";
        Class.forName(dbDriver);

        String dbNavn ="jdbc:mysql://mysql.stud.iie.ntnu.no:3306/heleneyj?user=heleneyj&&password=FnZXOzEX&useSSL=false";
        Connection forbindelse = DriverManager.getConnection(dbNavn);
        Statement setning = forbindelse.createStatement();

        Database o = new Database(dbDriver,dbNavn);
        Bok a = new Bok("4","Hoppet", "Jens Bjørneboe");
        Bok b = new Bok("1","Hoppet", "Jens Bjørneboe");

        //riktig
        boolean sjekkA = o.regNyBok(a);
        if(sjekkA){
            System.out.println("Test 1 vellykket");
        }


        //isbn er allerede registrert
        boolean sjekkB = o.regNyBok(b);
        if(!sjekkB){
            System.out.println("Test 2 vellykket");
        }

        //riktig isbn
        int svar1 = o.regNyttEksemplar("2");
        if(svar1 != 0){
            System.out.println("Test 3 vellykket");
        }

        //feil isbn
        int svar2 = o.regNyttEksemplar("6");
        if(svar2 == 0){
            System.out.println("Test 4 vellykket");
        }

        // riktig registrering
        boolean test1 = o.lånUtEksempler("1", "Eline", 1);
        if(test1) {
            System.out.println("Test 5 vellykket");
        }

        //feil ordrenr
        boolean test2 = o.lånUtEksempler("1", "Helene", 4);
        if(!test2){
            System.out.println("Test 6 vellykket");
        }



        setning.close();
        forbindelse.close();
    }
}
