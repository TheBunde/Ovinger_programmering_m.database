import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class Liste extends JFrame {
    private static String [] VALUTA = {"Ny valuta", "Euro","US Dollar","Britiske pund","Svenske kroner","Danske kroner","Yen","Islandske kroner","Norske kroner"};
    private JTextField tekst = new JTextField("Velg valuta");
    private DefaultListModel listeInnhold = new DefaultListModel();
    private JList fraValuta = new JList(listeInnhold);
    private JList tilValuta = new JList(listeInnhold);
    private Valuta[] valutaListe;

    public Liste(String tittel, Valuta[] valutaliste){
        setTitle(tittel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel ledetekst = new JLabel("Velg fravaluta og tilvaluta");
        add(ledetekst, BorderLayout.NORTH);

        JScrollPane fraRullefelt = new JScrollPane(fraValuta);
        add(fraRullefelt,BorderLayout.WEST);
        JScrollPane tilRullefelt = new JScrollPane(tilValuta);
        add(tilRullefelt,BorderLayout.EAST);

        lytter lytte1 = new lytter();
        lytter lytte2 = new lytter();
        fraValuta.addListSelectionListener(lytte1);
        tilValuta.addListSelectionListener(lytte2);

        tekst.setEditable(false);
        add(tekst,BorderLayout.SOUTH);
        pack();

        this.valutaListe = valutaliste;

        for(int i = 0; i < VALUTA.length; i++){
            String liste = VALUTA[i];
            listeInnhold.addElement(liste);
        }
    }

    public double omregn(int fraVerdi,int tilVerdi, int belop){
        Valuta fra = valutaListe[fraVerdi-1];
        Valuta til = valutaListe[tilVerdi-1];
        double nyBelop = (belop * fra.getKurs() * til.getEnhet())/(til.getKurs()*fra.getEnhet());
        return nyBelop;
    }

    private class lytter implements ListSelectionListener{
        public void valueChanged(ListSelectionEvent hendelse){
            int fraVerdi = fraValuta.getSelectedIndex();
            int tilVerdi = tilValuta.getSelectedIndex();
            if(fraVerdi == 0 || tilVerdi == 0){
                add();
            }
            if(fraVerdi >= 0 && tilVerdi >= 0){
                String belopLest = showInputDialog("Oppgi beløp:");
                int belop = Integer.parseInt(belopLest);
                double omregn = omregn(fraVerdi,tilVerdi,belop);
                String fra = valutaListe[fraVerdi-1].getValutanavn();
                String til = valutaListe[tilVerdi-1].getValutanavn();
                showMessageDialog(null, belop + " " + fra + " = " + omregn + " " + til);
            }
        }
    }

    public void add(){
        String valuttanavn = showInputDialog("Nytt valutanavn: ");
        String kursL = showInputDialog("Ny kurs: ");
        double kurs = Double.parseDouble(kursL);
        String enhetL = showInputDialog("Enhet: ");
        int enhet = Integer.parseInt(enhetL);
        listeInnhold.addElement(valuttanavn);
        Valuta[] ny = new Valuta[valutaListe.length + 1];
        for(int i = 0; i < valutaListe.length; i++){
            ny[i] =  valutaListe[i];
        }
        ny[valutaListe.length] = new Valuta(valuttanavn,kurs,enhet);
        valutaListe = ny;
    }
}



