package logiikka;

import java.util.ArrayList;
import yatzy.Noppa;
import yatzy.Noppakasi;

public class Pistelaskuri {

    private Noppakasi kasi;
    private Kadentarkastaja tarkastaja;

    public Pistelaskuri(Noppakasi kasi) {
        this.kasi = kasi;
        this.tarkastaja = new Kadentarkastaja(this.kasi);
    }

    /**
     * Laskee kädessä olevan suurimman parin tuottaman pistemäärän. Jos kädessä
     * ei ole paria, palautuu arvo 0.
     *
     * @return Parin pisteet.
     */
    public int parinPisteet() {
        if (!this.tarkastaja.onkoKadessaPari()) {
            return 0;
        }

        return 2 * this.suurinLukuJotaNkpl(2);

    }

    /**
     * Laskee kädessä olevan kolmosten tuottaman pistemäärän. Jos kädessä ei ole
     * kolmosia, palautuu arvo 0.
     *
     * @return Parin pisteet.
     */
    public int kolmostenPisteet() {
        if (!this.tarkastaja.onkoKadessaKolmoset()) {
            return 0;
        }

        return 3 * this.suurinLukuJotaNkpl(3);

    }

    /**
     * Laskee kädessä olevan nelosten tuottaman pistemäärän. Jos kädessä ei ole
     * nelosia, palautuu arvo 0.
     *
     * @return Parin pisteet.
     */
    public int nelostenPisteet() {
        if (!this.tarkastaja.onkoKadessaNeloset()) {
            return 0;
        }

        return 4 * this.suurinLukuJotaNkpl(4);

    }

    /**
     * Palauttaa 50, jos kädessä on yatzy. Muulloin 0.
     *
     * @return 50 tai 0.
     */
    public int yatzyPisteet() {
        if (!this.tarkastaja.onkoKadessaYatzy()) {
            return 0;
        }

        return 50;
    }

    /**
     * Palauttaa 15, jos kädessä on pieni suora. Muulloin 0.
     *
     * @return 15 tai 0.
     */
    public int pieniSuoraPisteet() {
        if (!this.tarkastaja.onkoKadessaPieniSuora()) {
            return 0;
        }

        return 15;
    }

    /**
     * Palauttaa 20, jos kädessä on iso suora. Muulloin 0.
     *
     * @return 20 tai 0.
     */
    public int isoSuoraPisteet() {
        if (!this.tarkastaja.onkoKadessaIsoSuora()) {
            return 0;
        }

        return 20;
    }
    
    /**
     * Jos kädessä on täyskäsi, niin metodi palauttaa noppien silmälukujen summan.
     *
     * @return Noppien silmälukujen summa.
     */

    public int tayskasiPisteet() {
        if (!this.tarkastaja.onkoKadessaTayskasi()) {
            return 0;
        }
        return this.kadenSumma();
       
    }
    
    /**
     * Metodi antaa pisteet ykkösille, kakkosille jne. Parametri <code>n</code>
     * kertoo minkä luvun pisteitä halutaan laskea. Pisteet saadan laskemalla luvun <code>n</code>
     * esiintymiskerrat kerrottina <code>n</code>:llä.
     * @param n Luku, jonka pisteitä lasketaan.
     * @return Luvun <code>n</code> pistemäärä.  
     */
    
    public int luvunNPisteet(int n) {
        int lkm = this.laskeSilmaluvunNlkm(n);
        return n*lkm;
    }
    /**
     * Palauttaa sattuman pisteet, eli käden noppien silmäluvut laskettuna yhteen.
     * @return Silmälukujen summa.
     */
    public int sattumaPisteet() {
        return this.kadenSumma();
    }

    /**
     * Laskee kuinka monta kertaa tietty silmäluku
     * <code>n</code> esiintyy noppakädessä.
     *
     * @param n Jokin silmäluku.
     * @return Silmäluvun esiintymis lukumäärä.
     */
    private int laskeSilmaluvunNlkm(int n) {
        int iii = 0;
        ArrayList<Noppa> nopat = this.kasi.getNoppaLista();

        for (Noppa noppa : nopat) {
            if (noppa.getSilmaluku() == n) {
                iii++;
            }
        }

        return iii;
    }
    
    /**
     * Palauttaa suurimman luvun, joka esiintyy kädessä
     * <code>n</code> kertaa. Jos mitään lukua ei löydy
     * <code>n</code> kappaletta, palauttaa metodi nollan.
     *
     * @param n Haluttu määrä esiintymisiä
     * @return Suurin luku, jota on n kappaletta.
     */
    private int suurinLukuJotaNkpl(int n) {
        for (int m = 6; m >= 1; m--) {
            if (this.laskeSilmaluvunNlkm(m) >= n) {
                return m;
            }

        }
        return 0;
    }
    
    private int kadenSumma() {
        int summa = 0;
        ArrayList<Noppa> nopat = this.kasi.getNoppaLista();

        for (Noppa noppa : nopat) {
            summa = summa + noppa.getSilmaluku();
        }
        
        return summa;
        
    }
}
