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
}
