package logiikka;

import java.util.ArrayList;
import yatzy.Noppa;
import yatzy.Noppakasi;

/**
 * Pistelaskuri luokka saa parametrina noppakäden, josta se laskee noppayhdistelmien pisteitä. Avuksi luodaan Kadentarkastaja-olio,
 * jonka avulla pistelasku yksinkertaistuu, koska laskuri tietää mikä yhdistelmä kädestä löytyy tai ei löydy.
 * @author Janne
 */

public class Pistelaskuri {

    /**
     * Käsi, jonka tuottamia pistemääriä halutaan laskea.
     */
    private Noppakasi kasi;
    /**
     * Tarkastaja auttaa pisteiden laskemisessa.
     */
    private Kadentarkastaja tarkastaja;

    /**
     * Konstruktorille annetaan parametrina tarkasteltava käsi. Sama käsi
     * annetaan myös oliomuuttujalle
     * <code>tarkastaja</code>. Käsi asetetaan suuruusjärjestykseen pistelaskua
     * helpottamaan.
     *
     * @param kasi Tarkasteltava käsi.
     */
    public Pistelaskuri(Noppakasi kasi) {
        this.kasi = kasi;
        this.tarkastaja = new Kadentarkastaja(this.kasi);
        this.kasi.jarjestaKasi();
    }

    /**
     * Metodi vaihtaa tarkasteltavan käden. Käsi asetetaan suuruusjärjestykseen.
     *
     * @param kasi Uusi käsi.
     */
    public void setKasi(Noppakasi kasi) {
        this.kasi = kasi;
        this.tarkastaja.setKasi(kasi);
        this.kasi.jarjestaKasi();
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
     * Jos kädessä on täyskäsi, niin metodi palauttaa noppien silmälukujen
     * summan.
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
     * Metodi etsii kädestä kaksi paria, ja laskee näiden summan. Apuna käytetään metodia <code>luvunNPisteet(n)</code>,
     * jolla tarkistetaan, mikä on kädessä esiintyvien <code>n</code>:ien summa. Jos se on suurempaa tai 
     * yhtäsuurta kuin <code>2*n</code>, niin kädessä on pari, joka tuottaa pisteet <code>2*n</code>.  
     * @return Kahden parin pisteet.
     */

    public int kaksiPariaPisteet() {
        if (!this.tarkastaja.onkoKadessaKaksiParia()) {
            return 0;
        }

        int summa = 0;

        for (int n = 6; n >= 1; n--) {

            if (this.luvunNPisteet(n) >= 2 * n) {
                summa = summa + 2 * n;
            }
        }

        return summa;
    }

    /**
     * Metodi antaa pisteet ykkösille, kakkosille jne. Parametri
     * <code>n</code> kertoo minkä luvun pisteitä halutaan laskea. Pisteet
     * saadan laskemalla luvun
     * <code>n</code> esiintymiskerrat kerrottina
     * <code>n</code>:llä.
     *
     * @param n Luku, jonka pisteitä lasketaan.
     * @return Luvun <code>n</code> pistemäärä.
     */
    public int luvunNPisteet(int n) {
        int lkm = this.laskeSilmaluvunNlkm(n);
        return n * lkm;
    }

    /**
     * Palauttaa sattuman pisteet, eli käden noppien silmäluvut laskettuna
     * yhteen.
     *
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
     * @return Silmäluvun esiintymislukumäärä.
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
    
    /**
     * Metodi laskee käden noppien silmälukujen summan.
     * @return Käden noppien silmälukujen summa.
     */

    private int kadenSumma() {
        int summa = 0;
        ArrayList<Noppa> nopat = this.kasi.getNoppaLista();

        for (Noppa noppa : nopat) {
            summa = summa + noppa.getSilmaluku();
        }

        return summa;

    }
}
