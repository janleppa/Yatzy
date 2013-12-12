package logiikka;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import yatzy.Noppakasi;

public class KadentarkastajaTest {

    private Kadentarkastaja tar;
    private Noppakasi kasi;

    public KadentarkastajaTest() {
    }

    @Before
    public void setUp() {
        this.kasi = new Noppakasi();
        this.tar = new Kadentarkastaja(kasi);
    }

    @Test
    public void tarkistaMetodiOnkoKadessaLuku() {
        Noppakasi kutoset = new Noppakasi(6, 6, 6, 6, 6);
        this.tar.setKasi(kutoset);

        assertTrue(tar.onkoKadessaLukuN(6));

        int iii = 1;

        while (iii <= 5) {
            assertFalse(tar.onkoKadessaLukuN(iii));
            iii++;
        }

    }

    @Test
    public void tarkistaOnkoKadessaIsoSuora() {
        Noppakasi suora = new Noppakasi(2, 3, 4, 5, 6);
        this.tar.setKasi(suora);

        assertTrue(this.tar.onkoKadessaIsoSuora());

        Noppakasi eiSuora = new Noppakasi();
        this.tar.setKasi(eiSuora);
        this.kasi.valitseNoppa(1);
        this.kasi.heitaValitsemattomat();

        assertFalse(this.tar.onkoKadessaIsoSuora());
    }

    @Test
    public void tarkistaOnkoKadessaPieniSuora() {
        Noppakasi suora = new Noppakasi(1, 2, 3, 4, 5);
        this.tar.setKasi(suora);

        assertTrue(this.tar.onkoKadessaPieniSuora());

        Noppakasi eiSuora = new Noppakasi(2, 2, 2, 2, 2);
        this.tar.setKasi(eiSuora);
        this.kasi.valitseNoppa(1);
        this.kasi.heitaValitsemattomat();

        assertFalse(this.tar.onkoKadessaPieniSuora());
    }

    @Test
    public void tarkistaOnkoKadessaPari() {
        Noppakasi pari1 = new Noppakasi(1, 1, 2, 3, 4);
        Noppakasi pari2 = new Noppakasi(1, 1, 1, 3, 4);
        Noppakasi pari3 = new Noppakasi(1, 2, 3, 6, 6);
        Noppakasi pari4 = new Noppakasi(1, 2, 3, 6, 6);

        Noppakasi eiPari1 = new Noppakasi(1, 2, 3, 4, 5);
        Noppakasi eiPari2 = new Noppakasi(1, 2, 3, 4, 6);

        this.tar.setKasi(pari1);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari2);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari3);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari4);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(eiPari1);
        assertFalse(tar.onkoKadessaPari());
        this.tar.setKasi(eiPari2);
        assertFalse(tar.onkoKadessaPari());

    }

    @Test
    public void testaaOnkoKadessaKolmoset() {
        Noppakasi on1 = new Noppakasi(1, 4, 1, 4, 1);
        Noppakasi ei1 = new Noppakasi(1, 2, 1, 2, 6);
        Noppakasi on2 = new Noppakasi(6, 6, 6, 2, 2); 

        this.tar.setKasi(on1);
        assertTrue(this.tar.onkoKadessaKolmoset());
        
        this.tar.setKasi(on2);
        assertTrue(this.tar.onkoKadessaKolmoset());

        this.tar.setKasi(ei1);
        assertFalse(this.tar.onkoKadessaKolmoset());
    }

    @Test
    public void testaaOnkoKadessaNeloset() {
        Noppakasi on1 = new Noppakasi(1, 4, 1, 1, 1);
        Noppakasi ei1 = new Noppakasi(1, 2, 1, 2, 6);

        this.tar.setKasi(on1);
        assertTrue(this.tar.onkoKadessaNeloset());

        this.tar.setKasi(ei1);
        assertFalse(this.tar.onkoKadessaNeloset());
    }
    
    @Test
    public void testaaOnkoKadessaYatzy() {
        Noppakasi on1 = new Noppakasi(1, 1, 1, 1, 1);
        Noppakasi ei1 = new Noppakasi(1, 2, 1, 2, 6);
        
        this.tar.setKasi(on1);
        assertTrue(this.tar.onkoKadessaYatzy());

        this.tar.setKasi(ei1);
        assertFalse(this.tar.onkoKadessaYatzy());
    }
    
    @Test
    public void testaaOnkoKadessaTayskasi() {
        Noppakasi on1 = new Noppakasi(1, 1, 1, 2, 2);
        Noppakasi on2 = new Noppakasi(1, 6, 1, 6, 1); 
        Noppakasi ei1 = new Noppakasi(1, 2, 1, 2, 6);
        Noppakasi ei2 = new Noppakasi(1, 1, 1, 1, 1);
        
        this.tar.setKasi(on1);
        assertTrue(this.tar.onkoKadessaTayskasi());
        
        this.tar.setKasi(on2);
        assertTrue(this.tar.onkoKadessaTayskasi());

        this.tar.setKasi(ei1);
        assertFalse(this.tar.onkoKadessaTayskasi());
        
        this.tar.setKasi(ei2);
        assertFalse(this.tar.onkoKadessaTayskasi());
    }
    
    @Test
    public void testaaOnkoKadessaKaksiPari() {
        Noppakasi on1 = new Noppakasi(1, 1, 4, 4, 6);
        Noppakasi on2 = new Noppakasi(1, 6, 1, 6, 5); 
        Noppakasi ei1 = new Noppakasi(1, 2, 1, 3, 6);
        Noppakasi ei2 = new Noppakasi(6, 6, 4, 1, 6);
        
        this.tar.setKasi(on1);
        assertTrue(this.tar.onkoKadessaKaksiParia());
        
        this.tar.setKasi(on2);
        assertTrue(this.tar.onkoKadessaKaksiParia());

        this.tar.setKasi(ei1);
        assertFalse(this.tar.onkoKadessaKaksiParia());
        
        this.tar.setKasi(ei2);
        assertFalse(this.tar.onkoKadessaKaksiParia());
    }
}
