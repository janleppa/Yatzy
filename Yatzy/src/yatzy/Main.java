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
       
       kayttis.run();
        
        
    }
}
