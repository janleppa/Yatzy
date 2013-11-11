package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;
import logiikka.Pistelaskuri;

public class Main {

    public static void main(String[] args) {
        Noppakasi on = new Noppakasi(1,1,1,1,6);
        Pistelaskuri las = new Pistelaskuri(on);
        Pistetaulukko pis = new Pistetaulukko(las);
        System.out.println(pis);
        pis.lisaaLuvunNPisteet(1);
        System.out.println("---------------------");

        System.out.println(pis);
        System.out.println("---------------------");
        on.heitaValitsemattomat();
        System.out.println(on);
        pis.lisaaLuvunNPisteet(1);
        System.out.println("---------------------");
        System.out.println(pis);
        
    }
}
