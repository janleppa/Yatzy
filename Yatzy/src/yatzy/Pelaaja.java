
package yatzy;

public class Pelaaja {
    /**
     *Taulukko, johon pelaajan pisteet kirjataan.
     */
    private Pistetaulukko pisteet;
    /**
     * Pelaajan nimi
     */
    private String nimi;
    
    /**
     * Konstruktorille annetaan parametrina pelaajan nimi ja pistetaulukko.
     * @param nimi Pelaajan nimi.
     * @param pisteet Pistetaulukko. 
     */
    public Pelaaja(String nimi) {
        this.nimi = nimi;
        
    }
    /**
     * Palauttaa pelaajan pistetaulukon.
     * @return Pistetaulukko.
     */
    public Pistetaulukko getTaulukko() {
        return this.pisteet;
    }
    
    /**
     * Palauttaa pelaajan nimen.
     * @return nimi.
     */
    
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * Asettaa annetun pistetaulukon pelaajalle
     * @param taulukko Pistetaulukko olio. 
     */
    public void setTaulukko(Pistetaulukko taulukko) {
        this.pisteet = taulukko;
    }
    
}
