package logiikka;

import java.util.ArrayList;
import yatzy.Noppa;
import yatzy.Noppakasi;

/**
 * Luokka, joka saa parametrina oliomuttujaksi noppakäden. Luokan avulla voidaan tarkistaa löytyykö noppakädestä haluttuja
 * noppayhdistelmiä.
 * @author Janne
 */

public class Kadentarkastaja {
    /**
     * Tarkastelun kohteena oleva noppakäsi.
     */
    private Noppakasi kasi;
    /**
     * Noppakäden sisältämä nopat listana.
     */
    private ArrayList<Noppa> nopat;

    
    /**
     * Konstruktori, jolle annetaan parametrina tarkastelun kohteeksi haluttava käsi. Konstruktori 
     * asettaa nopat suuruusjärjestykseen kutsumalla metodia <code>jarjestaKasi()</code>.
     * @param kasi Noppakäsi, jota halutaan tarkastella.
     */
    public Kadentarkastaja(Noppakasi kasi) {
        this.kasi = kasi;
        this.nopat = kasi.getNoppaLista();
        this.kasi.jarjestaKasi();
    }
    
    /**
     * Vaihtaa tarkasteltavan noppakäden. Käden nopat asetetaan suuruusjärjestykseen.
     * @param kasi Tarkastelvava käsi.
     */

    public void setKasi(Noppakasi kasi) {
        this.kasi = kasi;
        this.nopat = kasi.getNoppaLista();
        this.kasi.jarjestaKasi();
    }
    
    /**
     * Metodi kertoo onko noppakädessä luku <code>n</code>. 
     * @param n Silmäluku, josta ollaan kiinnostuneita.
     * @return <code>true</code>, jos kyseinen luku esiintyy kädessä, muulloin <code>false</code>.  
     */

    public boolean onkoKadessaLukuN(int n) {

        for (Noppa noppa : this.nopat) {
            if (noppa.getSilmaluku() == n) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tarkistaa löytyykö kädestä kaksi samaa lukua. Tämä tehdään vertaamalla vierekkäisten noppien silmälukuja, sillä
     * nopat ovat suuruusjärjestyksessä
     * @return <code>true</code>, jos kädessä on pari, muulloin <code>false</code>. 
     */

    public boolean onkoKadessaPari() {
        int iii = 1;

        while (iii <= 4) {
            if ((this.kasi.annaNopanNSilmaluku(iii + 1) - this.kasi.annaNopanNSilmaluku(iii)) == 0) {
                return true;
            }
            iii++;

        }

        return false;
    }
    
    /**
     * Tarkistaa löytyykö kädestä pieni suora, eli sisältääkö se nopat <code>2,3,4,5,6</code>.
     * @return <code>true</code>, jos kädessä on iso suora, muulloin <code>false</code>.
     */

    public boolean onkoKadessaIsoSuora() {
        int n = 1;
        if (this.kasi.annaNopanNSilmaluku(1) != 2) {
            return false;
        }
        while (n <= 4) {
            if ((this.kasi.annaNopanNSilmaluku(n + 1) - this.kasi.annaNopanNSilmaluku(n)) != 1) {
                return false;
            }
            n++;

        }
        return true;
    }
    
    /**
     * Tarkistaa löytyykö kädestä pieni suora, eli sisältääkö se nopat <code>1,2,3,4,5</code>.
     * @return <code>true</code>, jos kädessä on pieni suora, muulloin <code>false</code>.
     */

    public boolean onkoKadessaPieniSuora() {
        int n = 1;
        if (this.kasi.annaNopanNSilmaluku(1) != 1) {
            return false;
        }
        while (n <= 4) {
            if ((this.kasi.annaNopanNSilmaluku(n + 1) - this.kasi.annaNopanNSilmaluku(n)) != 1) {
                return false;
            }
            n++;

        }
        return true;
    }
    
    /**
     * Metodi tarkistaa onko kädessä vähintään kolme samaa lukua.
     * @return <code>true</code>, jos kädessä on kolmoset, muulloin <code>false</code>. 
     */

    public boolean onkoKadessaKolmoset() {
        int iii = 1;

        while (iii <= 3) {
            if (this.kasi.annaNopanNSilmaluku(iii) == this.kasi.annaNopanNSilmaluku(iii + 2)) {
                return true;
            }
            iii++;
        }

        return false;
    }
    
    /**
     * Metodi tarkistaa onko kädessä vähintään neljä samaa lukua.
     * @return <code>true</code>, jos kädessä on neloset, muulloin <code>false</code>. 
     */

    public boolean onkoKadessaNeloset() {
        if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(4) || this.kasi.annaNopanNSilmaluku(2) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
        }

        return false;
    }
    
    /**
     * Metodi tarkistaa onko kädessä Yatzy, eli ovatko kaikki luvut samoja.
     * @return <code>true</code>, jos kädessä on Yatzy, muulloin <code>false</code>. 
     */

    public boolean onkoKadessaYatzy() {
        if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
        }

        return false;
    }
    
    /**
     * Tarkistaa löytyykö kädestä kaksi paria. Parien tulee olla erilaiset, joten jos kädessä on neloset tai Yatzy, 
     * ei siinä voi olla kahta paria.
     * @return <code>true</code>, jos kädessä on kaksi paria, muulloin <code>false</code>. 
     */

    public boolean onkoKadessaKaksiParia() {
        if(this.onkoKadessaNeloset()) {
            return false;
        }
        else if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(2) && this.kasi.annaNopanNSilmaluku(3) == this.kasi.annaNopanNSilmaluku(4)) {
            return true;
            
        } else if (this.kasi.annaNopanNSilmaluku(2) == this.kasi.annaNopanNSilmaluku(3) && this.kasi.annaNopanNSilmaluku(4) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
            
        } else if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(2) && this.kasi.annaNopanNSilmaluku(4) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
            
        }
        return false;
    }
    
    /**
     * Tarkistaa onko kädessä täyskäsi. Yatzya ei voi laskea täyskädeksi.
     * @return <code>true</code>, jos kädessä on täyskäsi, muulloin <code>false</code>.
     */
    
    public boolean onkoKadessaTayskasi() {
        if(this.onkoKadessaYatzy()) {
            return false;    
        } else if(this.onkoKadessaNeloset()) {
            return false;
        }
        if(this.onkoKadessaKaksiParia() && this.onkoKadessaKolmoset()) {
            return true;
        }
        return false;
    }
}
