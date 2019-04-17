/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcu
 */
public class AllKompisarPers implements Serializable, DaoInterface{
    
    List<kompisar> polare = new ArrayList<>();
    
    public AllKompisarPers(){
        kompisar p1 = new kompisar(1,"Marcus", "02342342323412");
        kompisar p2 = new kompisar(2,"Jenny", "pelle42323412");
        kompisar p3 = new kompisar(3,"Batman", "asasd23412");
        
        polare.add(p1);
        polare.add(p2);
        polare.add(p3);
    }
    public List<kompisar> getAll(){
        
        
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream("C:\\Users\\marcu\\Java\\Ny mapp (2)\\Helloworld!\\fis.txt"));
            
                polare = (List<kompisar>)in.readObject();
                in.close();
  
        } catch (Exception ex) {
            Logger.getLogger(AllKompisarPers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return polare;
    }
    
    public void saveToFile(List<kompisar> i){
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("C:\\Users\\marcu\\Java\\Ny mapp (2)\\Helloworld!\\fis.txt"));
            
            out.writeObject(i);
            out.flush();
            System.out.println("sucess");
        } catch (IOException ex) {
            Logger.getLogger(AllKompisarPers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
