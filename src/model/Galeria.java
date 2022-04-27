
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Galeria implements Iterable<KiallitasiTargy>, Serializable{
    ArrayList<KiallitasiTargy> targyak;

    public Galeria() {
        this.targyak = new ArrayList<>();
    }
    
    public void felvesz(KiallitasiTargy e){
        
        if(e.getDate().after(new Date()) ){
            try {
                throw new Exception("Jövőbeli dátumot adunk meg");
            } catch (Exception ex) {
                Logger.getLogger(Galeria.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        else{
            this.targyak.add(e);
        }
        
    }

    public ArrayList<KiallitasiTargy> getTargyak() {
        return targyak;
    }
    
    

    @Override
    public Iterator<KiallitasiTargy> iterator() {
        return this.targyak.iterator();
    }
    
        public void mentes(){
        try (ObjectOutputStream objKi = new ObjectOutputStream(new FileOutputStream("galeria.bin"))) {
            objKi.writeObject(this);
            objKi.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static Galeria beolvas(String fajl){
        Galeria g = new Galeria();
        try(ObjectInputStream objBe = new ObjectInputStream(new FileInputStream(fajl))){
            g = (Galeria)objBe.readObject();           
            return g;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (InvalidClassException ex){
            System.err.println("Kompatibilitási hiba!");
        }catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return g;
    }
    
}
