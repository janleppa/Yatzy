package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;
import logiikka.Pistelaskuri;

public class Main {

    public static void main(String[] args) {
        Noppakasi on = new Noppakasi(1,2,3,5,6);
        Pistelaskuri las = new Pistelaskuri(on);


        System.out.println(las.yatzyPisteet());
    }
}
