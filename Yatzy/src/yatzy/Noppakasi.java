package yatzy;

import java.util.ArrayList;
import java.util.Collections;

public class Noppakasi {

    private ArrayList<Noppa> nopat;

    public Noppakasi() {
        this(1, 1, 1, 1, 1);



    }

    public Noppakasi(int eka, int toka, int kolmas, int neljas, int viides) {
        this.nopat = new ArrayList<Noppa>();
        this.nopat.add(new Noppa(eka));
        this.nopat.add(new Noppa(toka));
        this.nopat.add(new Noppa(kolmas));
        this.nopat.add(new Noppa(neljas));
        this.nopat.add(new Noppa(viides));
    }

    public void heitaValitsemattomat() {
        for (Noppa noppa : this.nopat) {
            if (noppa.onkoValittu() == false) {
                noppa.heitaNoppa();
            }
        }
    }

    private void alustaKasi() {
        int iii = 1;
        while (iii <= 5) {
            this.nopat.add(new Noppa());
            iii++;

        }
    }

    public String toString() {

        String tulos = "";
        for (Noppa noppa : this.nopat) {
            tulos = tulos + noppa.toString() + " ";
        }

        return tulos;
    }

    public void valitseNoppa(int n) {
        this.nopat.get(n - 1).valitse();

    }

    public void poistaValintaNopalta(int n) {
        this.nopat.get(n - 1).poistaValinta();
    }

    public void jarjestaKasi() {
        Collections.sort(this.nopat);
    }

    public ArrayList<Noppa> getNoppaLista() {
        return this.nopat;
    }

    public Noppakasi KopioiKasi() {
        Noppakasi k = new Noppakasi();
        ArrayList<Noppa> kopioNopat = new ArrayList<Noppa>();

        for (Noppa noppa : this.nopat) {
            Noppa kopioNoppa = new Noppa(noppa.getSilmaluku());
            kopioNopat.add(kopioNoppa);
        }


        return k;
    }

    public void setNopat(ArrayList<Noppa> nopat) {
        this.nopat = nopat;
    }

    public int annaNopanNSilmaluku(int n) {
        return this.nopat.get(n - 1).getSilmaluku();
    }

    public Noppa getNoppaNroN(int n) {
        return this.nopat.get(n - 1);
    }
}
