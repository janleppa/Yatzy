package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;

public class Main {

    public static void main(String[] args) {
        Noppakasi on1 = new Noppakasi(1, 1, 4, 4, 6);
        Kadentarkastaja tar = new Kadentarkastaja(on1);
        System.out.println(tar.onkoKadessaNeloset());
        System.out.println(on1);
        System.out.println(tar.onkoKadessaKaksiParia());
    }
}
