
package logiikka;

import java.util.ArrayList;
import yatzy.Noppakasi;
import yatzy.Pelaaja;
import yatzy.Pistetaulukko;

/**
 * Yatzy-peliä kokonaisuutena mallintava luokka. TÄmä luokka kerää pelin osat yhteen ja vuorovaikuttaa käyttiksen kanssa.
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
     * Konstruktori, joka luo uuden Yatzy-pelin. Konstruktori luo pelissä käytettävät nopat sekä pistelaskurin. 
     * @param pelaajat Pelaajat sisältävä lista. 
     */
    public Yatzypeli(ArrayList<Pelaaja> pelaajat) {
        this.pelaajat = pelaajat;
        this.kasi = new Noppakasi();
        this.laskuri = new Pistelaskuri(this.kasi);
    }
    
    /**
     * Metodi luo jokaiselle pelaajalla tyhjän pistetaulukon, ja liittää näihin pelissä käytettävän pistelaskurin.
     */
    public void luoPisteTaulukotPelaajille() {
        
        for(Pelaaja pelaaja : this.pelaajat) {
            pelaaja.setTaulukko(new Pistetaulukko(this.laskuri));
        }
    }
    
    /**
     * Metodi tarkistaa jatkuuko peli. Jos jokaisen pelaajan pistetaulukko on täynnä, peli loppuu. Muussa tapauksessa pelataan edelleen.
     */
    
    public boolean jatkuukoPeli() {
        for(Pelaaja pelaaja : this.pelaajat) {
            if(pelaaja.getTaulukko().onkoTaulukkoTaynna() == false) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Palauttaa pelaajalistan
     * @return ArrayList, joka sisältää pelaajat.
     */
    
    public ArrayList<Pelaaja> getPelaajaLista() {
        return this.pelaajat;
    }
    
    /**
     * Palauttaa pelin noppakäden.
     * @return Noppakäsi 
     */
    
    public Noppakasi getNoppakasi() {
        return this.kasi;
    }
    
    public String tulokset() {
        String tulokset = "";
        
        return tulokset;
    }
    
}
