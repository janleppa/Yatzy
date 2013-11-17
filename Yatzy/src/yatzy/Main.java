package yatzy;

import TUI.Kayttis;
import java.util.ArrayList;
import java.util.Scanner;
import logiikka.Kadentarkastaja;
import logiikka.Pistelaskuri;

public class Main {

    public static void main(String[] args) {
       Scanner lukija = new Scanner(System.in);
       Kayttis kayttis = new Kayttis(lukija);
       
       Noppakasi kasi = new Noppakasi(1,3,5,6,2);
       kasi.heitaValitsemattomat();
       
       System.out.println(kasi);
       kasi.valitseNoppa(1);
       
       
       
       kasi.valitseNoppa(4);
       kasi.valitseNoppa(5);
       
       System.out.println(kasi);
       
       kasi.heitaValitsemattomat();
       
        System.out.println(kasi);
        
    }
}
