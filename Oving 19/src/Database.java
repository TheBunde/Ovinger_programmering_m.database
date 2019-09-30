import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection forbindelse;
    private Opprydder opprdydd;
    private Statement setning;
    private ResultSet res;
    private PreparedStatement set;


    public Database(String dbDriver, String dbNavn) throws Exception {
        try {
            Class.forName(dbDriver);
            forbindelse = DriverManager.getConnection(dbNavn);
        } catch (Exception e) {
            opprdydd.skrivMelding(e, "konstruktør");
            throw e;
        }
    }

    public void lukkForbindelse(){
        opprdydd.lukkForbindelse(forbindelse);
    }

    public boolean regNyBok(Bok nyBok){
        ArrayList<String> navn = new ArrayList<>();
        String isbn1 = nyBok.getIsbn();
        String tittel1 = nyBok.getTittel();
        String forfatter1 = nyBok.getForfatter();
        try{
            forbindelse.setAutoCommit(false);
            setning = forbindelse.createStatement();
            ArrayList<String> liste = isbn();
            for(int i = 0; i < liste.size(); i++){
                String sol = liste.get(i);
                if(isbn1.trim().equals(sol.trim())){
                    opprdydd.rullTilbake(forbindelse);
                    return false;
                }
            }
            res.close();
            String sql = "insert into boktittel(isbn, forfatter, tittel) values(?, ?,?)";
            set = forbindelse.prepareStatement(sql);
            set.setString(1,isbn1);
            set.setString(2,forfatter1);
            set.setString(3,tittel1);
            int ost = set.executeUpdate();
            regNyttEksemplar(isbn1);
            //forbindelse.commit();
        } catch (SQLException e) {
            opprdydd.rullTilbake(forbindelse);
            opprdydd.skrivMelding(e, "Roll back");
        }finally {
            opprdydd.settAutoCommit(forbindelse);
            opprdydd.lukkResSet(res);
            opprdydd.lukkSetning(setning);
        }
        return true;
    }

    public ArrayList<String> isbn(){
        ArrayList<String> isbnListe = new ArrayList<>();
        String sqlsetning = "Select isbn from boktittel";

        res = null;
        setning = null;
        try{
            setning = forbindelse.createStatement();
            res = setning.executeQuery(sqlsetning);
            while(res.next()){
                String isbn = res.getString("isbn");
                isbnListe.add(isbn);
            }
        }catch (SQLException e){
            opprdydd.skrivMelding(e, "Listen");
            isbnListe = null;
        }finally {
            opprdydd.lukkResSet(res);
            opprdydd.lukkSetning(setning);
        }
        return isbnListe;
    }

    public int regNyttEksemplar(String isbn){
        int nyttnr = 1;
        boolean ok = false;
        do {
            res = null;
            setning = null;
            try {
                ArrayList<String> liste = isbn();
                boolean sjekk = false;
                for(int i = 0; i < liste.size(); i++){
                    String sol = liste.get(i);
                    if(isbn.trim().equals(sol.trim())){
                        sjekk = true;
                    }
                }
                if(!sjekk){
                    opprdydd.rullTilbake(forbindelse);
                    return 0;
                }
                forbindelse.setAutoCommit(false);
                setning = forbindelse.createStatement();
                String sql = "select max(eks_nr) as maks from eksemplar where isbn = ?";
                set = forbindelse.prepareStatement(sql);
                set.setString(1, isbn);
                res = set.executeQuery();
                res.next();
                nyttnr = res.getInt("maks") + 1;

                String sql1 = "insert into eksemplar(isbn, eks_nr) values(?, ?)";
                set = forbindelse.prepareStatement(sql1);
                set.setString(1, isbn);
                set.setInt(2, nyttnr);
                int ret = set.executeUpdate();
                forbindelse.commit();
                ok = true;
            } catch (SQLException e) {
                opprdydd.rullTilbake(forbindelse);
                opprdydd.skrivMelding(e, "Roll back");
                return 0;
            }finally{
                opprdydd.settAutoCommit(forbindelse);
                opprdydd.lukkResSet(res);
                opprdydd.lukkSetning(setning);
            }
        }while(!ok);
        return nyttnr;
    }

    public boolean lånUtEksempler(String isbn, String navn, int eksNr){
        res = null;
        setning = null;
        try {
            forbindelse.setAutoCommit(false);
            String sql = "update eksemplar set laant_av = ? where isbn = ? and eks_nr = ?";
            set = forbindelse.prepareStatement(sql);
            set.setString(1, navn);
            set.setString(2, isbn);
            set.setInt(3,eksNr);
            int retur = set.executeUpdate();
            if(retur == 0){
                return false;
            }
            forbindelse.commit();
        }catch(SQLException e){
            opprdydd.rullTilbake(forbindelse);
            opprdydd.skrivMelding(e, "Roll back");
        }finally {
            opprdydd.settAutoCommit(forbindelse);
            opprdydd.lukkResSet(res);
            opprdydd.lukkSetning(setning);
        }
        return true;
    }
}

//Driver:      com.mysql.cj.jdbc.Driver

//Databasenavn:        jdbc:mysql://mysql.stud.iie.ntnu.no:3360/heleneyj?user=heleneyj&&password=FnZXOzEX&useSSL=false"