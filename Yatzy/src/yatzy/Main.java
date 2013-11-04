package yatzy;

import java.util.ArrayList;
import logiikka.Kadentarkastaja;

public class Main {

    public static void main(String[] args) {
        
        
        
        Noppakasi isosuora = new Noppakasi();
        System.out.println(isosuora);
        ArrayList<Noppa> suora = new ArrayList<>();
        suora.add(new Noppa(2));
        suora.add(new Noppa(3));
        suora.add(new Noppa(4));
        suora.add(new Noppa(5));
        suora.add(new Noppa(6));
        isosuora.setNopat(suora);
        System.out.println(isosuora);
        
        Kadentarkastaja tar = new Kadentarkastaja(isosuora);
        System.out.println(tar.onkoKadessaIsoSuora());
        
        isosuora.heitaValitsemattomat();
        System.out.println(isosuora);
        System.out.println(tar.onkoKadessaIsoSuora());
        
        
        
        
        
        
        
    }
}
