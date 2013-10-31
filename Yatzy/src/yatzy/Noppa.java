
package yatzy;

import java.util.Random;

public class Noppa {
    private Random random;
    private int silmaluku;
    private boolean valittu;
    
    public Noppa() {
        this.random = new Random();
        this.silmaluku = 1;
        this.valittu = false;
        
    }
    
    public String toString() {
        return ""+this.silmaluku;
    }
    
    public int getSilmaluku() {
        return this.silmaluku;
    }
    
    public void heitaNoppa() {
        int heitto = this.random.nextInt(6) + 1;
        this.silmaluku = heitto;
    }
    
    public boolean onkoValittu() {
        return this.valittu;
    }
    
    public void valitse() {
        this.valittu = true;
    }
    
    public void poistaValinta() {
        this.valittu = false;
    }
    
}
