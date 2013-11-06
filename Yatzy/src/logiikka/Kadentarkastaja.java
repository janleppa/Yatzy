package logiikka;

import java.util.ArrayList;
import yatzy.Noppa;
import yatzy.Noppakasi;

public class Kadentarkastaja {

    private Noppakasi kasi;
    private ArrayList<Noppa> nopat;

    public Kadentarkastaja(Noppakasi kasi) {
        this.kasi = kasi;
        this.nopat = kasi.getNoppaLista();
        this.kasi.jarjestaKasi();
    }

    public void setKasi(Noppakasi kasi) {
        this.kasi = kasi;
        this.nopat = kasi.getNoppaLista();
        this.kasi.jarjestaKasi();
    }

    public boolean onkoKadessaLukuN(int n) {

        for (Noppa noppa : this.nopat) {
            if (noppa.getSilmaluku() == n) {
                return true;
            }
        }
        return false;
    }

    public boolean onkoKadessaPari() {
        int iii=1;
        
        while(iii<=4) {
            if((this.kasi.annaNopanNSilmaluku(iii+1)-this.kasi.annaNopanNSilmaluku(iii))== 0) {
                return true;
            }
            iii++;
                
        }
        
        return false;
    }

    public boolean onkoKadessaIsoSuora() {
        int n = 1;
        if(this.kasi.annaNopanNSilmaluku(1) != 2) {
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
    
    public boolean onkoKadessaPieniSuora() {
        int n = 1;
        if(this.kasi.annaNopanNSilmaluku(1) != 1) {
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
}
