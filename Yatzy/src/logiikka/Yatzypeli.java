package logiikka;

import java.util.ArrayList;
import java.util.Collections;
import yatzy.Noppakasi;
import yatzy.Pelaaja;
import yatzy.Pistetaulukko;

/**
 * Yatzy-peliä kokonaisuutena mallintava luokka. TÄmä luokka kerää pelin osat
 * yhteen ja vuorovaikuttaa käyttiksen kanssa.
 *
 * @author Janne
 */
public class Yatzypeli {

    /**
     * Pelaajat sisältävä lista.
     */
    private ArrayList<Pelaaja> pelaajat;
    /**
     * Pelissä käytettävä noppakäsi.
     */
    private Noppakasi kasi;
    /**
     * Pelissä käytettävä pistelaskuri.
     */
    private Pistelaskuri laskuri;

    /**
     * Konstruktori, joka luo uuden Yatzy-pelin. Konstruktori luo pelissä
     * käytettävät nopat sekä pistelaskurin.
     *
     * @param pelaajat Pelaajat sisältävä lista.
     */
    public Yatzypeli(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.kasi = new Noppakasi();
        this.laskuri = new Pistelaskuri(this.kasi);
    }

    /**
     * Metodi luo jokaiselle pelaajalla tyhjän pistetaulukon, ja liittää näihin
     * pelissä käytettävän pistelaskurin.
     */
    public void luoPisteTaulukotPelaajille() {

        for (Pelaaja pelaaja : this.pelaajat) {
            pelaaja.setTaulukko(new Pistetaulukko(this.laskuri));
        }
    }

    /**
     * Metodi tarkistaa jatkuuko peli. Jos jokaisen pelaajan pistetaulukko on
     * täynnä, peli loppuu. Muussa tapauksessa pelataan edelleen.
     */
    public boolean jatkuukoPeli() {
        for (Pelaaja pelaaja : this.pelaajat) {
            if (pelaaja.getTaulukko().onkoTaulukkoTaynna() == false) {
                return true;
            }
        }

        return false;
    }

    /**
     * Palauttaa pelaajalistan
     *
     * @return ArrayList, joka sisältää pelaajat.
     */
    public ArrayList<Pelaaja> getPelaajaLista() {
        return this.pelaajat;
    }

    /**
     * Palauttaa pelin noppakäden.
     *
     * @return Noppakäsi
     */
    public Noppakasi getNoppakasi() {
        return this.kasi;
    }
    
    /**
     * Luo pelin lopullisen pistetaulukon merkkijonoesityksen.
     * @return Pistetaulukko.
     */

    public String tulokset() {
        String tulokset = "";

        Collections.sort(this.pelaajat);
        String voittaja = this.pelaajat.get(0).getNimi();

        tulokset = tulokset + "Pelin voitti pelaaja " + voittaja + ". Onnea!\n";
        
        tulokset = tulokset + "Lopullinen pistetilanne: \n";
        
        for(Pelaaja pelaaja : this.pelaajat) {
            tulokset = tulokset + pelaaja.getNimi() + montaTyhjaa(25-pelaaja.getNimi().length()) + pelaaja.Kerropisteet() + "\n";
        }

        return tulokset;
    }
    
    /**
     * Apumetodi, jolla luodaan haluttu määrä välilyöntejä.
     *
     * @param n Kuinka monta välilyöntiä halutaan.
     * @return Merkkijono, joka sisältää välilyöntejä.
     */
    private String montaTyhjaa(int n) {
        String merkki = "";
        int iii = 1;

        while (iii <= n) {
            merkki = merkki + " ";
            iii++;
        }

        return merkki;

    }
    
    
}
