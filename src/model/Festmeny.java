package model;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Festmeny extends KiallitasiTargy implements Cloneable,Serializable{

    String eleresiUt;
    public UUID id;

    public Festmeny(String eleresiUt, String keszito, String cim) {
        super(keszito, cim);
        this.eleresiUt = eleresiUt;
    }

    public Festmeny(String keszito, String cim) {
        super(keszito, cim);
 id = UUID.randomUUID();
    }

    public Festmeny(Date datum, String keszito, String cim) {
        super(datum, keszito, cim);
    }

    public Festmeny(String eleresiUt, Date datum, String keszito, String cim) {
        super(datum, keszito, cim);
        this.eleresiUt = eleresiUt;
    }

    public String getEleresiUt() {
        return eleresiUt;
    }

    @Override
    public String toString() {
        return super.toString()+"Festmeny{" + "eleresiUt=" + eleresiUt + ", id=" + id + '}';
    }

 
    

    //„megjelenítés folyamatban…”, ha nem létezik, akkor azt, hogy „nem lehet megjeleníteni!
    public void megjelenit() {
        try {
            List<String> stringkLista = Files.readAllLines(Paths.get(this.eleresiUt));
            System.out.println("Megjelenítés folyamatban!");
        } catch (IOException ex) {
            System.out.println("Nem lehet megjeleníteni!");
        }
    }
    
    @Override
     public Object clone() throws CloneNotSupportedException {
        
        Festmeny fest = new Festmeny(this.getKeszito(),this.getCim());
        return fest;
    }

 

}
