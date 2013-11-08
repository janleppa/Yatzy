package yatzy;

import java.util.Random;

public class Noppa implements Comparable<Noppa> {

    private Random random;
    private int silmaluku;
    /**
     * Yatzy-pelissä heittojen välillä voidaan valita tietty määrä noppia, 
     * joita ei heitetä. 
     * Tämä muuttuja kertoo onko kyseessä oleva noppa valittuna.
     */
    private boolean valittu;
    
    
    /**
     * Luo uuden Noppa-luokan ilmentymän, jonka silmäluku on 1 ja noppa ei ole valittu.
     */
    public Noppa() {
        this(1);

    }
    
    /**
     * Luo nopan, jonka silmäluvun käyttäjä antaa parametrina. Noppa ei ole valittu.
     * @param n Nopan silmäluku 
     */

    public Noppa(int n) {
        this.random = new Random();
        this.silmaluku = n;
        this.valittu = false;
    }
    
    /**
     *Palauttaa nopan merkkijonoesityksen, joka on nopan silmäluku. 
     */

    public String toString() {
        return "" + this.silmaluku;
    }

    public int getSilmaluku() {
        return this.silmaluku;
    }

    public void setSilmaluku(int n) {
        if (!(1 <= n && n <= 6)) {
        } else {
            this.silmaluku = n;
        }
    }
    
    /**
     * Nopan silmäluvuksi vaihtuu satunnainen kokonaisluku väliltä 1-6.
     */

    public void heitaNoppa() {
        int heitto = this.random.nextInt(6) + 1;
        this.silmaluku = heitto;
    }

    public boolean onkoValittu() {
        return this.valittu;
    }
    
    /**
     * Valitsee nopan. Eli oliomuuttujan "valittu" arvoksi tulee true.
     */

    public void valitse() {
        this.valittu = true;
    }
    
    /**
     * Poistaa nopan valinnan. 
     */

    public void poistaValinta() {
        this.valittu = false;
    }
    
    /**
     * Metodi mahdollistaa Noppa-luokan ilmentymien vertailun noppien silmälukujen perusteella.
     * @param o Noppa-luokan olio
     * @return 
     */

    @Override
    public int compareTo(Noppa o) {
        return this.silmaluku - o.silmaluku;
    }
}
