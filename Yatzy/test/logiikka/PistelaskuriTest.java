package logiikka;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import yatzy.Noppakasi;

public class PistelaskuriTest {

    private Pistelaskuri laskuri;
    private Noppakasi kasi;

    public PistelaskuriTest() {
    }

    @Before
    public void setUp() {
        this.kasi = new Noppakasi();
        this.laskuri = new Pistelaskuri(kasi);
    }

    @Test
    public void testaaParinPisteet() {
        Noppakasi pari1 = new Noppakasi(2, 2, 1, 5, 6);
        Noppakasi eiPari1 = new Noppakasi(1, 2, 3, 5, 6);

        this.laskuri.setKasi(pari1);
        assertTrue(this.laskuri.parinPisteet() == 4);

        this.laskuri.setKasi(eiPari1);
        assertTrue(this.laskuri.parinPisteet() == 0);
    }

    @Test
    public void testaaKolmostenPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 2, 5, 6);
        Noppakasi ei = new Noppakasi(1, 2, 3, 5, 6);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.kolmostenPisteet() == 6);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.kolmostenPisteet() == 0);
    }

    @Test
    public void testaaNelostenPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 2, 2, 6);
        Noppakasi ei = new Noppakasi(1, 2, 3, 5, 6);
        Noppakasi on2 = new Noppakasi(2, 2, 2, 2, 2);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.nelostenPisteet() == 8);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.nelostenPisteet() == 0);

        this.laskuri.setKasi(on2);
        assertTrue(this.laskuri.nelostenPisteet() == 8);


    }

    @Test
    public void testaaYatzyPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 2, 2, 2);
        Noppakasi ei = new Noppakasi(1, 2, 3, 5, 6);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.yatzyPisteet() == 50);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.yatzyPisteet() == 0);
    }

    @Test
    public void testaaTayskasiPisteet() {
        Noppakasi on = new Noppakasi(3, 3, 2, 2, 2);
        Noppakasi ei = new Noppakasi(1, 2, 3, 5, 6);
        Noppakasi on2 = new Noppakasi(6, 6, 2, 2, 2);
        Noppakasi ei2 = new Noppakasi(1, 1, 1, 1, 1);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.tayskasiPisteet() == 12);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.tayskasiPisteet() == 0);

        this.laskuri.setKasi(on2);
        assertTrue(this.laskuri.tayskasiPisteet() == 18);

        this.laskuri.setKasi(ei2);
        assertTrue(this.laskuri.tayskasiPisteet() == 0);
    }

    @Test
    public void testaaIsoSuoraPisteet() {
        Noppakasi on = new Noppakasi(2, 3, 4, 5, 6);
        Noppakasi ei = new Noppakasi(1, 2, 3, 5, 4);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.isoSuoraPisteet() == 20);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.isoSuoraPisteet() == 0);
    }

    @Test
    public void testaaPieniSuoraPisteet() {
        Noppakasi ei = new Noppakasi(2, 3, 4, 5, 6);
        Noppakasi on = new Noppakasi(1, 2, 3, 5, 4);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.pieniSuoraPisteet() == 15);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.pieniSuoraPisteet() == 0);
    }

    @Test
    public void testaaKaksiPariaPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 4, 4, 6);
        Noppakasi ei = new Noppakasi(4, 4, 4, 5, 4);
        Noppakasi ei2 = new Noppakasi(2, 2, 2, 2, 2);
        Noppakasi on2 = new Noppakasi(4, 4, 5, 5, 4);
        Noppakasi on3 = new Noppakasi(1, 1, 1, 2, 2);

        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.kaksiPariaPisteet() == 12);

        this.laskuri.setKasi(ei);
        assertTrue(this.laskuri.kaksiPariaPisteet() == 0);

        this.laskuri.setKasi(on2);
        assertTrue(this.laskuri.kaksiPariaPisteet() == 18);

        this.laskuri.setKasi(ei2);
        assertTrue(this.laskuri.kaksiPariaPisteet() == 0);

        this.laskuri.setKasi(on3);
        assertTrue(this.laskuri.kaksiPariaPisteet() == 6);
    }

    @Test
    public void testaaLuvunNPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 4, 4, 6);

        this.laskuri.setKasi(on);

        assertTrue(this.laskuri.luvunNPisteet(1) == 0);
        assertTrue(this.laskuri.luvunNPisteet(2) == 4);
        assertTrue(this.laskuri.luvunNPisteet(3) == 0);
        assertTrue(this.laskuri.luvunNPisteet(4) == 8);
        assertTrue(this.laskuri.luvunNPisteet(5) == 0);
        assertTrue(this.laskuri.luvunNPisteet(6) == 6);
    }

    @Test
    public void testaaSattumaPisteet() {
        Noppakasi on = new Noppakasi(2, 2, 4, 4, 6);
        Noppakasi on2 = new Noppakasi(1, 2, 1, 4, 1);
        
        this.laskuri.setKasi(on);
        assertTrue(this.laskuri.sattumaPisteet() == 18);
        
        this.laskuri.setKasi(on2);
        assertTrue(this.laskuri.sattumaPisteet() == 9);
        
        
    }
}
