
package logiikka;

import java.util.ArrayList;
import yatzy.Noppakasi;
import yatzy.Pelaaja;
import yatzy.Pistetaulukko;

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
    
}
