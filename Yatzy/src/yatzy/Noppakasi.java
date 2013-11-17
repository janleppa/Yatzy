package yatzy;

import java.util.ArrayList;
import java.util.Collections;

public class Noppakasi {

    /**
     * Lista, joka pitää sisällään käden
     * <code>Noppa</code>-oliot.
     */
    private ArrayList<Noppa> nopat;

    /**
     * Konstruktori luo uuden noppakäden, jossa jokaisen nopan silmäluku on
     * <code>1</code>.
     */
    public Noppakasi() {
        this(1, 1, 1, 1, 1);



    }

    /**
     * Konstruktori, joka mahdollistaa halutunlaisen käden luomisen
     *
     * @param eka Ensimmäisen nopan silmäluku.
     * @param toka Toisen nopan silmäluku.
     * @param kolmas Kolmannen nopan silmäluku.
     * @param neljas Neljännen nopan silmäluku.
     * @param viides Viidennen nopan silmäluku.
     */
    public Noppakasi(int eka, int toka, int kolmas, int neljas, int viides) {
        this.nopat = new ArrayList<Noppa>();
        this.nopat.add(new Noppa(eka));
        this.nopat.add(new Noppa(toka));
        this.nopat.add(new Noppa(kolmas));
        this.nopat.add(new Noppa(neljas));
        this.nopat.add(new Noppa(viides));
    }

    /**
     * Heittää kädestä nopat, jotka eivät ole valittuja.
     */
    public void heitaValitsemattomat() {
        for (Noppa noppa : this.nopat) {
            if (noppa.onkoValittu() == false) {
                noppa.heitaNoppa();
            }
        }
    }

    /**
     * Apumetodi uuden käden luomiseen.
     */
    private void alustaKasi() {
        int iii = 1;
        while (iii <= 5) {
            this.nopat.add(new Noppa());
            iii++;

        }
    }

    /**
     * Palauttaa käden merkkijonoesityksen, jossa näkyy noppien silmäluvut
     * pilkuin erotettuina. Nopat esitetään suuruusjärjestyksessä.
     *
     * @return
     */
    public String toString() {
        this.jarjestaKasi();
        String tulos = "";
        for (Noppa noppa : this.nopat) {
            tulos = tulos + noppa.toString() + " ";
        }

        return tulos;
    }

    /**
     * Valitsee kädestä nopan numero
     * <code>n</code>. Ensimmäisen nopan numero on
     * <code>1</code>.
     *
     * @param n Nopan järjestysluku.
     */
    public void valitseNoppa(int n) {
        this.nopat.get(n - 1).valitse();

    }

    /**
     * Poistaa valinnan nopalta numero
     * <code>n</code>. Ensimmäisen nopan numero on
     * <code>1</code>.
     *
     * @param n Nopan järjestysluku.
     */
    public void poistaValintaNopalta(int n) {
        this.nopat.get(n - 1).poistaValinta();
    }

    /**
     * Nopat asetetaan suuruusjärjestykseen pienimmästä alkaen.
     */
    public void jarjestaKasi() {
        Collections.sort(this.nopat);
    }

    /**
     * Palauttaa noppakäden nopat listana.
     *
     * @return <code>ArrayList</code>, joka sisältää <code>Noppa</code> oliot.
     */
    public ArrayList<Noppa> getNoppaLista() {
        return this.nopat;
    }

    /**
     * Metodi, jolla voidaam kopioda annettu käsi.
     *
     * @return Palauttaa <code>Noppakasi</code>-olion kopion.
     */
    public Noppakasi KopioiKasi() {
        Noppakasi k = new Noppakasi();
        ArrayList<Noppa> kopioNopat = new ArrayList<Noppa>();

        for (Noppa noppa : this.nopat) {
            Noppa kopioNoppa = new Noppa(noppa.getSilmaluku());
            kopioNopat.add(kopioNoppa);
        }


        return k;
    }

    /**
     * Asettaa noppakädeksi parametrina saadun noppia sisältävän lista.
     *
     * @param nopat <code>ArrayList</code> joka
     * sisältää <code>Noppa</code>-olioita.
     */
    public void setNopat(ArrayList<Noppa> nopat) {
        this.nopat = nopat;
    }

    /**
     * Kertoo halutun nopan silmäluvun.
     *
     * @param n Nopan järjestysluku
     * @return Kysytyn nopan silmäluku.
     */
    public int annaNopanNSilmaluku(int n) {
        return this.nopat.get(n - 1).getSilmaluku();
    }

    /**
     * Palauttaa Noppakädestä halutun nopan.
     *
     * @param n Nopan järjestysluku.
     * @return <code>Noppa</code> olio.
     */
    public Noppa getNoppaNroN(int n) {
        return this.nopat.get(n - 1);
    }
}
