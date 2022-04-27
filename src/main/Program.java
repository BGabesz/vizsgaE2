package main;

import java.util.Collections;
import java.util.Date;
import model.Festmeny;
import model.Galeria;
import model.KiallitasiTargy;

public class Program {

    public static void main(String[] args) throws CloneNotSupportedException {

        Galeria g1 = new Galeria();

        Festmeny f1 = new Festmeny("kep.txt", "Laci", "Kardok");
        Festmeny f2 = new Festmeny("kep.txt", new Date(), "Árpád", "Poharak");

        g1.felvesz(new Festmeny("Akárki", "A festmény címe"));
        g1.felvesz(new Festmeny(new Date(), "Kati", "Virágok"));
        g1.felvesz(new Festmeny(new Date(2055, 1, 1), "Kati", "Virágok"));
        g1.felvesz(f1);
        g1.felvesz(f2);

        galeriaKi(g1);

        //Készítő
        Collections.sort(g1.getTargyak());
        galeriaKi(g1);

        //Cim
        Collections.sort(g1.getTargyak(), KiallitasiTargy.CimRendezo());
        galeriaKi(g1);
        Festmeny f3 = new Festmeny("A", "V");
        Festmeny f5 = (Festmeny) f3.clone();
        System.out.println("");
        System.out.println(f3);
        System.out.println(f5);

        g1.mentes();
        System.out.println("Beolvasás");

        Galeria g2 = Galeria.beolvas("galeria.bin");
        galeriaKi(g2);
    }

    public static void galeriaKi(Galeria g1) {
        System.out.println(System.lineSeparator());
        for (KiallitasiTargy kiallitasiTargy : g1) {
            System.out.println(kiallitasiTargy);
        }
    }
}
