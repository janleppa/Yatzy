package yatzy;

import logiikka.Pistelaskuri;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class PistetaulukkoTest {

    private Pistetaulukko pis;
    private Pistelaskuri las;

    public PistetaulukkoTest() {
    }

    @Before
    public void setUp() {
        this.las = new Pistelaskuri(new Noppakasi());
        this.pis = new Pistetaulukko(this.las);
    }

    @Test
    public void testaaLisaaLuvunNPisteet() {
        Noppakasi kutoset = new Noppakasi(6, 6, 6, 6, 2);
        this.las.setKasi(kutoset);

        for (int i = 1; i <= 6; i++) {
            pis.lisaaLuvunNPisteet(i);
        }

        assertTrue(this.pis.getPisteetNrona("Ykkoset") == 0);
        assertTrue(this.pis.getPisteetNrona("Kakkoset") == 2);
        assertTrue(this.pis.getPisteetNrona("Kolmoset") == 0);
        assertTrue(this.pis.getPisteetNrona("Neloset") == 0);
        assertTrue(this.pis.getPisteetNrona("Vitoset") == 0);
        assertTrue(this.pis.getPisteetNrona("Kutoset") == 24);

    }

    @Test
    public void testaaLisaaParinPisteet() {
        Noppakasi pari = new Noppakasi(6, 6, 3, 2, 2);
        this.las.setKasi(pari);

        this.pis.lisaaParinPisteet();

        assertTrue(this.pis.getPisteetNrona("Pari") == 12);

    }

    @Test
    public void testaaLisaaKahdenParinPisteet() {
        Noppakasi pari = new Noppakasi(6, 6, 3, 2, 2);
        this.las.setKasi(pari);

        this.pis.lisaaKaksiPariaPisteet();

        assertTrue(this.pis.getPisteetNrona("Kaksi paria") == 16);
    }
    
    @Test 
    public void testaaLisaaPienenSuoranPisteet() {
    Noppakasi suora = new Noppakasi(1, 2, 3, 4, 5);
        this.las.setKasi(suora);

        this.pis.lisaaPienenSuoranPisteet();

        assertTrue(this.pis.getPisteetNrona("Pieni suora") == 15);    
    }
    
    @Test 
    public void testaaLisaaIsonSuoranPisteet() {
    Noppakasi suora = new Noppakasi(6, 2, 3, 4, 5);
        this.las.setKasi(suora);

        this.pis.lisaaIsonSuoranPisteet();

        assertTrue(this.pis.getPisteetNrona("Iso suora") == 20);    
    }
    
    @Test
    public void testaaKolmeSamaaPisteet() {
        Noppakasi kolmoset = new Noppakasi(6, 6, 6, 2, 2);
        this.las.setKasi(kolmoset);

        this.pis.lisaaKolmostenPisteet();

        assertTrue(this.pis.getPisteetNrona("Kolme samaa") == 18);
    }
    
    @Test
    public void testaaNeljaSamaaPisteet() {
        Noppakasi neloset = new Noppakasi(6, 2, 2, 2, 2);
        this.las.setKasi(neloset);

        this.pis.lisaaNelostenPisteet();

        assertTrue(this.pis.getPisteetNrona("Nelja samaa") == 8);
    }
    
    @Test
    public void testaaTayskasiPisteet() {
        Noppakasi takari = new Noppakasi(6, 6, 2, 2, 2);
        this.las.setKasi(takari);

        this.pis.lisaaTayskadenPisteet();

        assertTrue(this.pis.getPisteetNrona("Tayskasi") == 18);
    }
    
    @Test
    public void testaaYatzyPisteet() {
        Noppakasi yatzy  = new Noppakasi(2, 2, 2, 2, 2);
        this.las.setKasi(yatzy);

        this.pis.lisaaYatzynPisteet();

        assertTrue(this.pis.getPisteetNrona("Yatzy") == 50);
    }
    
    
    
    
    @Test
    public void testaaOnkoTaulukkoTaynna(){
        Noppakasi pari = new Noppakasi(6, 6, 3, 2, 2);
        this.las.setKasi(pari);

        this.pis.lisaaKaksiPariaPisteet();
        
        assertFalse(this.pis.onkoTaulukkoTaynna());
        
    }
    
    @Test
    public void testaaOnkoTaulukkoTaynna2(){
        this.pis.getTaulukko().put("Ykkoset", 1);
        this.pis.getTaulukko().put("Kakkoset", 1);
        this.pis.getTaulukko().put("Kolmoset", 1);
        this.pis.getTaulukko().put("Neloset", 1);
        this.pis.getTaulukko().put("Vitoset", 1);
        this.pis.getTaulukko().put("Kutoset", 1);
        this.pis.getTaulukko().put("Pari", 1);
        this.pis.getTaulukko().put("Kaksi paria", 1);
        this.pis.getTaulukko().put("Kolme samaa", 1);
        this.pis.getTaulukko().put("Nelja samaa", 1);
        this.pis.getTaulukko().put("Pieni suora", 1);
        this.pis.getTaulukko().put("Iso suora", 1);
        this.pis.getTaulukko().put("Tayskasi", 1);
        this.pis.getTaulukko().put("Sattuma", 1);
        this.pis.getTaulukko().put("Yatzy", 1);
        
        assertTrue(this.pis.onkoTaulukkoTaynna());
        
    }
}
