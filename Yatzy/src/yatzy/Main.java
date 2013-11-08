package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;
import logiikka.Pistelaskuri;

public class Main {

    public static void main(String[] args) {
        Noppakasi on1 = new Noppakasi(6, 6, 6, 6, 4);
        Pistelaskuri las = new Pistelaskuri(on1);


        System.out.println(las.luvunNPisteet(4));
    }
}
