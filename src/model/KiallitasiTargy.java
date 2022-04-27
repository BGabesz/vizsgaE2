package model;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Date;

class CimRendezoComparator implements Comparator<KiallitasiTargy> {

    @Override
    public int compare(KiallitasiTargy egyik, KiallitasiTargy masik) {
        Collator col = Collator.getInstance();
        return col.compare(egyik.getCim(), masik.getCim());
    }

}

public abstract class KiallitasiTargy implements Comparable<KiallitasiTargy>,Serializable {

    private Date datum = new Date();
    //készítője, címe
    private String keszito, cim;

    public KiallitasiTargy(String keszito, String cim) {
        this.keszito = keszito;
        this.cim = cim;
    }
    

    public KiallitasiTargy(Date datum, String keszito, String cim) {
        this(keszito, cim);
        this.datum = datum;
       
    }

    public Date getDate() {
        return this.datum;
    }

    public String getKeszito() {
        return keszito;
    }

    public String getCim() {
        return cim;
    }
    
    public static CimRendezoComparator CimRendezo(){
        return new CimRendezoComparator();
    }

    @Override
    public int compareTo(KiallitasiTargy t) {
        Collator col = Collator.getInstance();
        return col.compare(this.getKeszito(), t.getKeszito());
    }

    @Override
    public String toString() {
        return "KiallitasiTargy{" + "datum=" + datum + ", keszito=" + keszito + ", cim=" + cim + '}';
    }
    
}
