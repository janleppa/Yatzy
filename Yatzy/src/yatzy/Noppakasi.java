
package yatzy;

import java.util.ArrayList;

public class Noppakasi {
    private ArrayList<Noppa> nopat;
    
    public Noppakasi() {
        this.nopat = new ArrayList<Noppa>();
        this.alustaKasi();
        this.heitaValitsemattomat();
        
        
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
        String tulos = "";
        for(Noppa noppa : this.nopat) {
            tulos = tulos + noppa.toString() + " "; 
        }
        
        return tulos;
    }
    
}
