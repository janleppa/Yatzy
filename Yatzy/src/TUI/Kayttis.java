package TUI;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import logiikka.Yatzypeli;
import yatzy.Noppakasi;
import yatzy.Pelaaja;

/**
 * Tekstikäyttöliittymä luokka.
 * @author Janne
 */

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
            System.out.println("Syötit virheellisen määrän pelaajia. Kokeile uudestaan.\n\n");
            return this.kysyPelaajat();
        }

        return pelaajat;
    }

    public void run() {
        System.out.println("Tervetuloa pelaamaan Yatzya!");

        ArrayList<Pelaaja> pelaajat = this.kysyPelaajat();

        this.peli = new Yatzypeli(pelaajat);
        this.peli.luoPisteTaulukotPelaajille();
        
        while(this.peli.jatkuukoPeli()) {
        pelaaKierros();    
        }
        
        pelinLopetus();
        
    }

    private void pelaaKierros() {
        ArrayList<Pelaaja> pelaajat = this.peli.getPelaajaLista();

        for (Pelaaja pelaaja : pelaajat) {
            this.pelaajanVuoro(pelaaja);
        }
    }

    private void pelaajanVuoro(Pelaaja pelaaja) {
        Noppakasi kasi = this.peli.getNoppakasi();
        kasi.poistaKaikkiNoppaValinnat();

        System.out.println("\nPelaajan " + pelaaja.getNimi() + " vuoro.");
        System.out.println("Nopat kolisevat pöytään.");

        kasi.heitaValitsemattomat();
        int heitot = 1;


        while (true) {


            if (heitot >= 3) {
                System.out.println("Lopullinen noppakätesi:");
                kasi.poistaKaikkiNoppaValinnat();
                System.out.println(kasi);
                System.out.println("Paina enter asettaaksesi käden pisteet.");
                lueKayttajanKomento();
                asetaKasiTaulukkoon(pelaaja);
                break;
            }

            System.out.println("\nNoppakätesi:");
            System.out.println(kasi);

            tulostaToimintovalikko();
            String komento = lueKayttajanKomento();

            if (komento.equals("1")) {
                valitseNoppia();
            } else if (komento.equals("2")) {
                heitot++;
                kasi.heitaValitsemattomat();
            } else if (komento.equals("3")) {
                printtaaTaulukko(pelaaja);
            } else if (komento.equals("4")) {
                asetaKasiTaulukkoon(pelaaja);
                break;
            } else {
                System.out.println("Väärä komento. Kokeile uudelleen.");
            }

        }

    }

    private void tulostaToimintovalikko() {
        System.out.println("Mitä haluat tehdä? Syötä komennon numero ilman pistettä.");
        System.out.println("    1. Valitse noppia");
        System.out.println("    2. Heitä valitsemattomat nopat.");
        System.out.println("    3. Katso pistetaulukko.");
        System.out.println("    4. Aseta noppakäsi pistetaulukkoon.");
    }

    private String lueKayttajanKomento() {
        return this.lukija.nextLine();
    }

    private void valitseNoppia() {
        Noppakasi kasi = this.peli.getNoppakasi();

        System.out.println("\nSyötä niiden noppien järjestysnumerot, jotka haluat valita. "
                + "Voit poistaa valinnan antamalla jo valitun nopan järjestysnumero. "
                + "Kun olet tehnyt haluamasi valinnat, syötä luku 0 vahvistaaksesi noppien valinta.");

        while (true) {
            System.out.print("Nopan numero: ");
            try {
                int luku = this.lukija.nextInt();

                if (luku == 0) {
                    break;
                } else if (luku < 1 || luku > 6) {
                    System.out.println("Syötä luku väliltä 1-5!");
                } else {
                    if (kasi.getNoppaNroN(luku).onkoValittu()) {
                        kasi.getNoppaNroN(luku).poistaValinta();
                    } else {
                        kasi.getNoppaNroN(luku).valitse();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Et tainnut syöttää kokonaislukua.");
                valitseNoppia();
            }

        }

    }

    private void asetaKasiTaulukkoon(Pelaaja pelaaja) {
        System.out.println("Pistetaulukkosi:");
        System.out.println(pelaaja.getTaulukko().toString());
        System.out.println("Mihin kohtaan haluat sijoittaa pisteesi?\n"
                + "Syötä sen kohdan nimi täsmälleen samoin kun se lukee taulukossa.");
        
        String minne = this.lueKayttajanKomento();
        pelaaja.getTaulukko().lisaaPisteet(minne);
        System.out.println("Pistetaulukkosi:");
        System.out.println(pelaaja.getTaulukko().toString());
    }

    private void printtaaTaulukko(Pelaaja pelaaja) {
        while (true) {
            System.out.println("\n" + pelaaja.getTaulukko().toString());
            System.out.print("\nPaina enter palataksesi valikkoon.");
            this.lueKayttajanKomento();

            break;
        }

    }

    private void pelinLopetus() {
        System.out.println("\nPeli loppui!");
    }
}
