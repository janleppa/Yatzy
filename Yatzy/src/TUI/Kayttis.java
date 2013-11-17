package TUI;

import java.util.ArrayList;
import java.util.Scanner;
import logiikka.Yatzypeli;
import yatzy.Pelaaja;

public class Kayttis {

    /**
     * Käyttäjän komentojen lukemiseen tarkoitettu olio.
     */
    private Scanner lukija;
    /**
     * Yatzy-pelin logiikan yhteenliittävä luokka.
     */
    private Yatzypeli peli;

    /**
     * Konstruktori käyttöliittymän luomiseen. Käyttöiittymän tarvitsema
     * <code>Scanner</code>-olio välitetään parametrina.
     *
     * @param lukija <code>Scanner</code>-olio.
     */
    public Kayttis(Scanner lukija) {
        this.lukija = lukija;
    }

    public ArrayList<Pelaaja> kysyPelaajat() {
        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();

        System.out.println("Peliin mahtuu 2-5 pelaajaa. Syötä pelaajien nimet yksi kerrallaan. Tyhjä merkkijono aloittaa pelin.");

        while (true) {
            System.out.print("Pelaajan nimi: ");
            String nimi = this.lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            } else {
                pelaajat.add(new Pelaaja(nimi));
            }
        }

        if (pelaajat.size() < 2 || pelaajat.size() > 5) {
            System.out.println("Syötit virheellisen määrän pelaajia. Kokeile uudestaan.\n\n" );
            return this.kysyPelaajat();
        }
        
        return pelaajat;
    }
    
    public void run() {
        System.out.println("Tervetuloa pelaamaan Yatzya!");
        
        ArrayList<Pelaaja> pelaajat=this.kysyPelaajat();
        
        this.peli = new Yatzypeli(pelaajat);
    }
}
