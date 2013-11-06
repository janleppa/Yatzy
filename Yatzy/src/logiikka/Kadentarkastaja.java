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
        int iii = 1;

        while (iii <= 4) {
            if ((this.kasi.annaNopanNSilmaluku(iii + 1) - this.kasi.annaNopanNSilmaluku(iii)) == 0) {
                return true;
            }
            iii++;

        }

        return false;
    }

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

    public boolean onkoKadessaNeloset() {
        if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(4) || this.kasi.annaNopanNSilmaluku(2) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
        }

        return false;
    }

    public boolean onkoKadessaYatzy() {
        if (this.kasi.annaNopanNSilmaluku(1) == this.kasi.annaNopanNSilmaluku(5)) {
            return true;
        }

        return false;
    }

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
