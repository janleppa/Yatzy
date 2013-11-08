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
}
