package yatzy;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class NoppaTest {

    private Noppa noppa;

    public NoppaTest() {
    }

    @Before
    public void setUp() {
        Noppa noppa = new Noppa();
        this.noppa = noppa;
    }

    @Test
    public void testaaEttaNopanArvotJarkevia() {
        int iii = 0;

        while (iii < 99) {
            this.noppa.heitaNoppa();
            iii++;
            assertTrue(this.noppa.getSilmaluku() <= 6 && this.noppa.getSilmaluku() >= 1);
        }
    }

    @Test
    public void testaaHeitaNoppa() {
        this.noppa.setSilmaluku(1);

        int iii = 0;
        int summa = 0;

        while (iii < 30) {
            iii++;
            this.noppa.heitaNoppa();
            summa = this.noppa.getSilmaluku() + summa;
        }

        assertTrue(summa != 30);


    }

    @Test
    public void testaaValitseMetodi() {
        this.noppa.valitse();
        assertTrue(this.noppa.onkoValittu() == true);
    }

    @Test
    public void testaaPoistaValintaMetodi() {
        this.noppa.poistaValinta();
        assertTrue(this.noppa.onkoValittu() == false);
    }
}
