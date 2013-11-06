package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;

public class Main {

    public static void main(String[] args) {
        Noppakasi yatzy = new Noppakasi(1,4,1,4,1);
        System.out.println(yatzy);
        Kadentarkastaja tar = new Kadentarkastaja(yatzy);
        System.out.println(tar.onkoKadessaIsoSuora());
        System.out.println(tar.onkoKadessaKolmoset());
    }
}
