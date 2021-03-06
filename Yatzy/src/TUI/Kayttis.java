package TUI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import logiikka.Yatzypeli;
import yatzy.Noppakasi;
import yatzy.Pelaaja;

/**
 * Tekstikäyttöliittymä luokka.
 *
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

    /**
     * Metodi, joka käynnistää pelin. Ensin kysytään pelaajien määrä ja sen
     * jälkeen pelataan kieroksia niin kauan kun pelaajilla on tyhjiä paikkoja
     * pistelistoissa.
     */
    public void run() {
        System.out.println("Tervetuloa pelaamaan Yatzya!");

        uusiPeli();

        while (this.peli.jatkuukoPeli()) {
            pelaaKierros();
        }

        pelinLopetus();

    }

    /**
     * Kysytään käyttäjältä pelaajat ja pelaajien nimet. Metodi kysyy nimiä niin
     * kauan kunnes käyttäjä syöttää tyhjän merkkijonon. Pelaajia täytyy olla
     * vähintään kaksi ja korkeintaan viisi.
     *
     * @return ArrayList, joka sisältää pelaaja-olioita.
     */
    public ArrayList<Pelaaja> kysyPelaajat() {
        ArrayList<Pelaaja> pelaajat = new ArrayList<Pelaaja>();

        System.out.println("Peliin mahtuu 2-5 pelaajaa. Syötä pelaajien nimet yksi kerrallaan, ilman ääkkösiä. Tyhjä merkkijono aloittaa pelin.");

        while (true) {
            System.out.print("Pelaajan nimi: ");
            String nimi = this.lukija.nextLine();
            if (nimi.isEmpty()) {
                break;
            } else if (nimi.length() > 18) {
                System.out.println("Lyhyempi nimi, kiitos.");
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

    /**
     * Peliä pelataan yksi kierros, eli kaikki pelaajat saavat vuoron.
     */
    private void pelaaKierros() {
        ArrayList<Pelaaja> pelaajat = this.peli.getPelaajaLista();

        for (Pelaaja pelaaja : pelaajat) {
            this.pelaajanVuoro(pelaaja);
        }
    }

    /**
     * Metodi kertoo mitä yhden pelaajan vuoron aikana tapahtuu. Pelaaja voi
     * heittää noppia korkeintaan kolmesti, katsoa pistetaulukkoaan, asettaa
     * pisteitä taulukkoon tai valita noppia, joita haluaa lukita.
     *
     * @param pelaaja Pelaaja, jonka vuoro on.
     */
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

    /**
     * Apumetodi, joka tulostaa pelaajan mahdolliset toiminnot vuoron aikana.
     */
    private void tulostaToimintovalikko() {
        System.out.println("Mitä haluat tehdä? Syötä komennon numero ilman pistettä.");
        System.out.println("    1. Valitse noppia");
        System.out.println("    2. Heitä valitsemattomat nopat.");
        System.out.println("    3. Katso pistetaulukko.");
        System.out.println("    4. Aseta noppakäsi pistetaulukkoon.");
    }

    /**
     * Lukee käyttäjän syötteen.
     *
     * @return Merkkijono
     */
    private String lueKayttajanKomento() {
        return this.lukija.nextLine();
    }

    /**
     * Metodi kysyy pelaajalta nopat, jotka tämää haluaa valita. Jos noppa on jo
     * valittu, sen valinta poistetaan. Nopista syötetään järjestysnumerot ja
     * 0:n syöttäminen vahvistaa valinnan. Jos pelaaja ei syötä kokonaislukua,
     * metodi kertoo tästä.
     */
    private void valitseNoppia() {
        Noppakasi kasi = this.peli.getNoppakasi();

        System.out.println("\nSyötä yksi kerrallaan niiden noppien järjestysnumerot, jotka haluat valita. "
                + "\nVoit poistaa valinnan antamalla jo valitun nopan järjestysnumeron. "
                + "\nKun olet tehnyt haluamasi valinnat, syötä luku 0 palataksesi valikkoon.");

        while (true) {
            System.out.print("Nopan numero: ");

            try {
                int luku = this.lukija.nextInt();

                if (luku == 0) {
                    System.out.println("Nopat valittu.");
                    break;
                } else if (luku < 1 || luku > 5) {
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
                break;

            }

        }

        System.out.println("Palataan valikkoon.\n");
        lueKayttajanKomento();

    }

    /**
     * Asettaa pelaajan sen hetkisen noppakäden pistetaulukkoon. Pelaajalta
     * kysytään mihin yhdistelmään nopat halutaan laittaa. Yhdistelmän nimi
     * tulee kirjoittaa täsmälleen samoin kuin se mainitaan pistetaulukossa. Jos
     * taulukosta ei löydy pelaajan syötettä vastaavaa sanaa kysytään uudelleen.
     *
     * @param pelaaja Pelaaja, jonka pisteitä asetetaan.
     */
    private void asetaKasiTaulukkoon(Pelaaja pelaaja) {
        System.out.println("Pistetaulukkosi:");
        System.out.println(pelaaja.getTaulukko().toString());
        System.out.println("Mihin kohtaan haluat sijoittaa pisteesi?\n"
                + "Syötä sen kohdan nimi täsmälleen samoin kun se lukee taulukossa.");

        String minne = this.lueKayttajanKomento();
        if (pelaaja.getTaulukko().lisaaPisteet(minne) == false) {
            System.out.println("Kirjoititko varmasti oikein? Yritä uudelleen.");
            asetaKasiTaulukkoon(pelaaja);
        } else {
            pelaaja.getTaulukko().lisaaPisteet(minne);
            System.out.println("Pistetaulukkosi:");
            System.out.println(pelaaja.getTaulukko().toString());
        }
    }

    /**
     * Tulostaa pelaajan pistetaulukon
     *
     * @param pelaaja Kenen taulukko tulostetaan.
     */
    private void printtaaTaulukko(Pelaaja pelaaja) {
        while (true) {
            System.out.println("\n" + pelaaja.getTaulukko().toString());
            System.out.print("\nPaina enter palataksesi valikkoon.");
            this.lueKayttajanKomento();

            break;
        }

    }

    /**
     * Pelin lopuksi tulostetaan pelaajien pisteet.
     */
    private void pelinLopetus() {
        System.out.println("\nPeli loppui!");
        System.out.println(this.peli.tulokset());
    }

    /**
     * Kysyy pelaajat ja luo uuden Yatzypelin.
     */
    private void uusiPeli() {
        ArrayList<Pelaaja> pelaajat = this.kysyPelaajat();

        this.peli = new Yatzypeli(pelaajat);
        this.peli.luoPisteTaulukotPelaajille();
    }
}
