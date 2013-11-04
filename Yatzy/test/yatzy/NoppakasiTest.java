
package yatzy;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class NoppakasiTest {
    private Noppakasi kasi;
    
    public NoppakasiTest() {
    }
    
    @Before
    public void setUp() {
    this.kasi = new Noppakasi();    
    }
    
    @Test 
    public void testaaValitseNoppa() {
        assertTrue(this.kasi.getNoppaLista().get(0).onkoValittu()==false);
        this.kasi.valitseNoppa(1);
        assertTrue(this.kasi.getNoppaLista().get(0).onkoValittu()==true);
        
    }
    
    @Test
    public void testaaPoistaValinta() {
        this.kasi.valitseNoppa(1);
        assertTrue(this.kasi.getNoppaLista().get(0).onkoValittu()==true);
        this.kasi.poistaValintaNopalta(1);
        assertTrue(this.kasi.getNoppaLista().get(0).onkoValittu()==false);
    }
}
