package yatzy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import logiikka.Pistelaskuri;

public class Pistetaulukko {

    /**
     * Taulukko johon kirjataan pelaajan pisteet.
     */
    private LinkedHashMap<String, Integer> pisteet;
    /**
     * Laskuri, joka laskee annetun käden pisteet.
     */
    private Pistelaskuri laskuri;

    /**
     * Konstruktori luo uuden pistetaulukon. Taulukkoon on sijoitettu valmiiksi
     * alkioina eri pisteyhdistelmien nimet. Aluksi jokaiseen liittyvä
     * pistemäärä on
     * <code>null</code>.
     */
    public Pistetaulukko(Pistelaskuri laskuri) {
        this.pisteet = new LinkedHashMap<String, Integer>();
        this.lisaaTaulukonAlkiot();

        this.laskuri = laskuri;
    }
    
    /**
     * Lisää taulukkoon ykkösten pisteet.
     */

    public void lisaaLuvunNPisteet(int n) {
        this.pisteet.put("Ykköset", this.laskuri.luvunNPisteet(n));
    }
    
    /**
     * Tuottaa pistetaulukon merkkijonoesityksen. Jos johonkin noppayhdistelmään ei ole vielä liitetty pisteitä,
     * esiintyy taulukossa tällä kohtaa kirjain "x". Tulostuksessa käytetään apumetodia <code>montaTyhjaa</code> luomaan
     * sanan pituudesta riippuva määrä välilyöntejä, jotta taulukko näyttäisi siistiltä.
     * @return 
     */

    public String toString() {
        String taulukko = "";

        int summa = 0;

        for (Integer piste : this.pisteet.values()) {
            if (piste == null) {
            } else {
                summa = piste + summa;
            }
        }

        for (String alkio : this.pisteet.keySet()) {
            if (this.pisteet.get(alkio) == null) {
                taulukko = taulukko + alkio + this.montaTyhjaa(11-alkio.length()) + "         " + "x\n";
            } else {
                taulukko = taulukko + alkio + this.montaTyhjaa(11-alkio.length())+ "         " + this.pisteet.get(alkio) + "\n";
            }
        }

        taulukko = taulukko + "Yhteissumma" + "         " + summa;

        return taulukko;
    }

    /**
     * Apumetodi, joka luo taulukkopohjan.
     */
    private void lisaaTaulukonAlkiot() {
        this.pisteet.put("Ykköset", null);
        this.pisteet.put("Kakkoset", null);
        this.pisteet.put("Kolmoset", null);
        this.pisteet.put("Neloset", null);
        this.pisteet.put("Vitoset", null);
        this.pisteet.put("Pari", null);
        this.pisteet.put("Kaksi paria", null);
        this.pisteet.put("Kolme samaa", null);
        this.pisteet.put("Neljä samaa", null);
        this.pisteet.put("Pieni suora", null);
        this.pisteet.put("Iso suora", null);
        this.pisteet.put("Täyskäsi", null);
        this.pisteet.put("Sattuma", null);
        this.pisteet.put("Pieni suora", null);


    }
    
    private String montaTyhjaa(int n) {
        String merkki = "";
        int iii = 1;
        
        while (iii<= n) {
            merkki = merkki + " ";
            iii++;
        }
        
        return merkki;
        
    }
}
