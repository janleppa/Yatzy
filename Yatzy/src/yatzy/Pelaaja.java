
package yatzy;

/**
 * Pelaaja luokka kuvaa pelin pelaajia. Pelaajilla on nimi ja pistetaulukko. Pistetaulukko ei luoda pelaajan luonnin yhteydessä,
 * vaan se liitetään pelaajille myöhemmin.
 * @author Janne
 */

public class Pelaaja implements Comparable<Pelaaja> {
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

    /**
     * Mahdollistaa pelaajien vertaulun loppupisteiden perusteella.
     * @param pelaaja
     * @return Kokonaisluku, jonka avulla nopat laitetaan järjestykseen.
     */
    @Override
    public int compareTo(Pelaaja pelaaja) {
        return  pelaaja.Kerropisteet()-this.Kerropisteet(); 
    }
    
    /**
     * Palauttaa pelaajan loppupisteet
     * @return loppupisteet. 
     */
    
    public int Kerropisteet() {
        return this.pisteet.KerroLoppuPisteet();
    }
    
}
