
package yatzy;

import java.util.ArrayList;
import java.util.Collections;

public class Noppakasi {
    private ArrayList<Noppa> nopat;
    
    public Noppakasi() {
        this.nopat = new ArrayList<Noppa>();
        this.alustaKasi();
        
        
        
    }
    
    public void heitaValitsemattomat() {
        for(Noppa noppa : this.nopat) {
            if(noppa.onkoValittu() == false)
                noppa.heitaNoppa();
        }
    }
    
    public void alustaKasi() {
        int iii=1;
        while(iii<=5) {
            this.nopat.add(new Noppa());
            iii++;
            
        }
    }
    
    public String toString() {
        this.jarjestaKasi();
        String tulos = "";
        for(Noppa noppa : this.nopat) {
            tulos = tulos + noppa.toString() + " "; 
        }
        
        return tulos;
    }
    
    public void valitseNoppa(int n) {
        this.nopat.get(n-1).valitse();
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
        
        for(Noppa noppa : this.nopat) {
        Noppa kopioNoppa = new Noppa(noppa.getSilmaluku());    
        kopioNopat.add(kopioNoppa);    
        }
        
        
        return k;
    }
    
    public void setNopat(ArrayList<Noppa> nopat) {
        this.nopat = nopat;
    }
    
    public int annaNopanNSilmaluku(int n) {
        return this.nopat.get(n-1).getSilmaluku();
    }
    
}
