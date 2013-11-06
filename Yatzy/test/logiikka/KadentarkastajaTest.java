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
        Noppakasi kutoset = new Noppakasi(6,6,6,6,6);
        this.tar.setKasi(kutoset);
        
        assertTrue(tar.onkoKadessaLukuN(6));
        
        int iii=1;
        
        while(iii<=5) {
            assertTrue(tar.onkoKadessaLukuN(iii)==false);
            iii++;
        }
        
    }
    
    @Test
    public void tarkistaOnkoKadessaIsoSuora() {
        Noppakasi suora = new Noppakasi(2,3,4,5,6);
        this.tar.setKasi(suora);
        
        assertTrue(this.tar.onkoKadessaIsoSuora());
        
        Noppakasi eiSuora = new Noppakasi();
        this.tar.setKasi(eiSuora);
        this.kasi.valitseNoppa(1);
        this.kasi.heitaValitsemattomat();
        
        assertTrue(this.tar.onkoKadessaIsoSuora()==false);
    }
    
    @Test
    public void tarkistaOnkoKadessaPieniSuora() {
        Noppakasi suora = new Noppakasi(1,2,3,4,5);
        this.tar.setKasi(suora);
        
        assertTrue(this.tar.onkoKadessaPieniSuora());
        
        Noppakasi eiSuora = new Noppakasi(2,2,2,2,2);
        this.tar.setKasi(eiSuora);
        this.kasi.valitseNoppa(1);
        this.kasi.heitaValitsemattomat();
        
        assertTrue(this.tar.onkoKadessaPieniSuora()==false);
    }
    
    @Test
    public void tarkistaOnkoKadessaPari() {
        Noppakasi pari1 = new Noppakasi(1,1,2,3,4);
        Noppakasi pari2 = new Noppakasi(1,1,1,3,4);
        Noppakasi pari3 = new Noppakasi(1,2,3,6,6);
        Noppakasi pari4 = new Noppakasi(1,2,3,6,6);
        
        Noppakasi eiPari1 = new Noppakasi(1,2,3,4,5);
        Noppakasi eiPari2 = new Noppakasi(1,2,3,4,6);
        
        this.tar.setKasi(pari1);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari2);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari3);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(pari4);
        assertTrue(tar.onkoKadessaPari());
        this.tar.setKasi(eiPari1);
        assertTrue(!tar.onkoKadessaPari());
        this.tar.setKasi(eiPari2);
        assertTrue(!tar.onkoKadessaPari());
        
    }
}
