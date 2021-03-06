package yatzy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import logiikka.Pistelaskuri;

/**
 * Yatzy-pelissä pelaajat keräävät pisteitä erilaisista noppayhdistelmistä ja
 * kirjaavat niitä ylös. Pistetaulukko luokka mallintaa taulukko, johon pisteet
 * merkitään.
 *
 * @author Janne
 */
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
     * Lisää taulukkoon luvun
     * <code>n</code> tuottamat pisteet. Metodilla hoituu siis pisteiden lisäys
     * ykkösille, kakkosille, kolmosille jne.
     */
    public void lisaaLuvunNPisteet(int n) {
        if (n == 1) {
            this.pisteet.put("Ykkoset", this.laskuri.luvunNPisteet(n));
        } else if (n == 2) {
            this.pisteet.put("Kakkoset", this.laskuri.luvunNPisteet(n));
        } else if (n == 3) {
            this.pisteet.put("Kolmoset", this.laskuri.luvunNPisteet(n));
        } else if (n == 4) {
            this.pisteet.put("Neloset", this.laskuri.luvunNPisteet(n));
        } else if (n == 5) {
            this.pisteet.put("Vitoset", this.laskuri.luvunNPisteet(n));
        } else if (n == 6) {
            this.pisteet.put("Kutoset", this.laskuri.luvunNPisteet(n));
        } else {
        }
    }

    /**
     * Lisää taulukkoon pienen suoran pisteet.
     */
    public void lisaaPienenSuoranPisteet() {
        this.pisteet.put("Pieni suora", this.laskuri.pieniSuoraPisteet());
    }

    /**
     * Lisää taulukkoon ison suoran pisteet.
     */
    public void lisaaIsonSuoranPisteet() {
        this.pisteet.put("Iso suora", this.laskuri.isoSuoraPisteet());
    }

    /**
     * Lisää taulukkoon täyskäden pisteet.
     */
    public void lisaaTayskadenPisteet() {
        this.pisteet.put("Tayskasi", this.laskuri.tayskasiPisteet());
    }

    /**
     * Lisää taulukkoon parin pisteet.
     */
    public void lisaaParinPisteet() {
        this.pisteet.put("Pari", this.laskuri.parinPisteet());
    }

    /**
     * Lisää taulukkoon kahden parin pisteet.
     */
    public void lisaaKaksiPariaPisteet() {
        this.pisteet.put("Kaksi paria", this.laskuri.kaksiPariaPisteet());
    }

    /**
     * Lisää taulukkoon kolmen saman pisteet.
     */
    public void lisaaKolmostenPisteet() {
        this.pisteet.put("Kolme samaa", this.laskuri.kolmostenPisteet());
    }

    /**
     * Lisää taulukkoon neljän saman pisteet.
     */
    public void lisaaNelostenPisteet() {
        this.pisteet.put("Nelja samaa", this.laskuri.nelostenPisteet());
    }

    /**
     * Lisää pisteet Yatzylle.
     */
    public void lisaaYatzynPisteet() {
        this.pisteet.put("Yatzy", this.laskuri.yatzyPisteet());
    }

    /**
     * Lisää pisteet "Sattuma" kohtaan
     */
    public void lisaaSattumaPisteet() {
        this.pisteet.put("Sattuma", this.laskuri.sattumaPisteet());
    }

    /**
     * Tuottaa pistetaulukon merkkijonoesityksen. Jos johonkin noppayhdistelmään
     * ei ole vielä liitetty pisteitä, esiintyy taulukossa tällä kohtaa kirjain
     * "x". Tulostuksessa käytetään apumetodia
     * <code>montaTyhjaa</code> luomaan sanan pituudesta riippuva määrä
     * välilyöntejä, jotta taulukko näyttäisi siistiltä.
     *
     * @return taulukon merkkijonoesitys
     */
    @Override
    public String toString() {
        String taulukko = "";


        int summa = pisteidenSumma();



        for (String alkio : this.pisteet.keySet()) {
            if (this.pisteet.get(alkio) == null) {
                taulukko = taulukko + alkio + this.montaTyhjaa(11 - alkio.length()) + "         " + "x\n";
            } else {
                taulukko = taulukko + alkio + this.montaTyhjaa(11 - alkio.length()) + "         " + this.pisteet.get(alkio) + "\n";
            }
        }

        taulukko = taulukko + "Yhteissumma" + "         " + summa;

        return taulukko;
    }

    /**
     * Palauttaa halutun noppayhdistelmän pisteet. Jos pisteitä ei vielä ole,
     * palautetaan
     * <code>-1</code>.
     *
     * @param mille Minkä yhdistelmän pisteet halutaan.
     * @return Pisteet tai <code>-1</code>.
     */
    public int getPisteetNrona(String mille) {
        if (this.pisteet.get(mille) == null) {
            return -1;
        }
        return this.pisteet.get(mille);
    }

    /**
     * Apumetodi, joka luo taulukkopohjan.
     */
    private void lisaaTaulukonAlkiot() {
        this.pisteet.put("Ykkoset", null);
        this.pisteet.put("Kakkoset", null);
        this.pisteet.put("Kolmoset", null);
        this.pisteet.put("Neloset", null);
        this.pisteet.put("Vitoset", null);
        this.pisteet.put("Kutoset", null);
        this.pisteet.put("Pari", null);
        this.pisteet.put("Kaksi paria", null);
        this.pisteet.put("Kolme samaa", null);
        this.pisteet.put("Nelja samaa", null);
        this.pisteet.put("Pieni suora", null);
        this.pisteet.put("Iso suora", null);
        this.pisteet.put("Tayskasi", null);
        this.pisteet.put("Sattuma", null);
        this.pisteet.put("Yatzy", null);


    }

    /**
     * Metodi kertoo onko taulukon jokaisella riville merkitty pistemäärä.
     *
     * @return <code>true</code>, jos taulukko täysi, * *      * muulloin <code>false</code>.
     */
    public boolean onkoTaulukkoTaynna() {
        for (Integer piste : this.pisteet.values()) {
            if (piste == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Apumetodi, jolla luodaan haluttu määrä välilyöntejä.
     *
     * @param n Kuinka monta välilyöntiä halutaan.
     * @return Merkkijono, joka sisältää välilyöntejä.
     */
    private String montaTyhjaa(int n) {
        String merkki = "";
        int iii = 1;

        while (iii <= n) {
            merkki = merkki + " ";
            iii++;
        }

        return merkki;

    }

    public HashMap<String, Integer> getTaulukko() {
        return this.pisteet;
    }
    
    /**
     * Lisää pisteet parametrin osoittamaan paikkaa. Jos lisäys onnistui palautuu true, muulloin false. 
     * Pisteitä ei lisätä, jos taulukossa on tällä kohtaa jo pisteet.
     * @param mihin Mihin kohtaan taulukkoa pisteet halutaan.
     * @return True jos lisäys onnistui, false muuten.
     */

    public boolean lisaaPisteet(String mihin) {
        if (this.pisteet.containsKey(mihin)) {
            if (mihin.equals("Ykkoset") && this.pisteet.get("Ykkoset")==null) {
                this.lisaaLuvunNPisteet(1);
                return true;
            } else if (mihin.equals("Kakkoset") && this.pisteet.get("Kakkoset")==null) {
                this.lisaaLuvunNPisteet(2);
                return true;
            } else if (mihin.equals("Kolmoset") && this.pisteet.get("Kolmoset")==null) {
                this.lisaaLuvunNPisteet(3);
                return true;
            } else if (mihin.equals("Neloset") && this.pisteet.get("Neloset")==null) {
                this.lisaaLuvunNPisteet(4);
                return true;
            } else if (mihin.equals("Vitoset") && this.pisteet.get("Vitoset")==null) {
                this.lisaaLuvunNPisteet(5);
                return true;
            } else if (mihin.equals("Kutoset") && this.pisteet.get("Kutoset")==null) {
                this.lisaaLuvunNPisteet(6);
                return true;
            } else if (mihin.equals("Pari") && this.pisteet.get("Pari")==null) {
                this.lisaaParinPisteet();
                return true;
            } else if (mihin.equals("Kaksi paria") && this.pisteet.get("Kaksi paria")==null) {
                this.lisaaKaksiPariaPisteet();
                return true;
            } else if (mihin.equals("Kolme samaa") && this.pisteet.get("Kolme samaa")==null) {
                this.lisaaKolmostenPisteet();
                return true;
            } else if (mihin.equals("Nelja samaa") && this.pisteet.get("Nelja samaa")==null) {
                this.lisaaNelostenPisteet();
                return true;
            } else if (mihin.equals("Pieni suora") && this.pisteet.get("Pieni suora")==null) {
                this.lisaaPienenSuoranPisteet();
                return true;
            } else if (mihin.equals("Iso suora") && this.pisteet.get("Iso suora")==null) {
                this.lisaaIsonSuoranPisteet();
                return true;
            } else if (mihin.equals("Tayskasi") && this.pisteet.get("Tayskasi")==null) {
                this.lisaaTayskadenPisteet();
                return true;
            } else if (mihin.equals("Sattuma") && this.pisteet.get("Sattuma")==null) {
                this.lisaaSattumaPisteet();
                return true;
            } else if (mihin.equals("Yatzy") && this.pisteet.get("Yatzy")==null) {
                this.lisaaYatzynPisteet();
               return true;

            }
        }
        
        return false;
    }

    /**
     * Laskee taulukon pisteiden summan.
     *
     * @return Pisteiden summa.
     */
    private int pisteidenSumma() {
        int summa = 0;

        for (Integer piste : this.pisteet.values()) {
            if (piste == null) {
            } else {
                summa = piste + summa;
            }
        }

        return summa;
    }

    /**
     * Yatzyssa saa 50 bonuspistettä, jos taulukon yläosan yhdistelmien, eli
     * yhdistelmien ykkösistä kutosiin asti yhtenlaskettu pistepotti on
     * vähintään 63. Metodi tarkistaa onko tämä totta.
     *
     * @return
     */
    private boolean onkoValisummaTarpeeksi() {

        int ylasumma = this.pisteet.get("Ykkoset") + this.pisteet.get("Kakkoset") + this.pisteet.get("Kolmoset") + this.pisteet.get("Neloset")
                + this.pisteet.get("Vitoset") + this.pisteet.get("Kutoset");

        if (ylasumma >= 63) {
            return true;
        }

        return false;


    }
    
    /**
     * Metodi kertoo pelaajan lopulliset pisteet.
     * @return loppupisteet
     */

    public int KerroLoppuPisteet() {
        if (onkoValisummaTarpeeksi()) {
            return 50 + pisteidenSumma();
        } else {
            return pisteidenSumma();
        }
    }
    
    /**
     * Hieman erilainen pistetaulukon merkkijonoesitys graafista käyttistä varten.
     * Kohtien väliin luodaan aina tyhjä rivi.
     * @return Pistetaulukon merkkijonoesitys
     */
    
     public String toStringGraafiselle() {
        String taulukko = "";


        int summa = pisteidenSumma();



        for (String alkio : this.pisteet.keySet()) {
            if (this.pisteet.get(alkio) == null) {
                taulukko = taulukko + alkio + this.montaTyhjaa(11 - alkio.length()) + "         " + "x\n\n";
            } else {
                taulukko = taulukko + alkio + this.montaTyhjaa(11 - alkio.length()) + "         " + this.pisteet.get(alkio) + "\n\n";
            }
        }

        taulukko = taulukko + "Yhteissumma" + "         " + summa;

        return taulukko;
    }
     
}
