/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;

import java.util.ArrayList;
import java.util.List;


public class  AllaKompisarDao implements DaoInterface{
    List<kompisar> polare = new ArrayList<>();
    
    public AllaKompisarDao(){
        kompisar p1 = new kompisar(1,"Marcus", "02342342323412");
        kompisar p2 = new kompisar(2,"Jenny", "pelle42323412");
        kompisar p3 = new kompisar(3,"Batman", "asasd23412");
        
        polare.add(p1);
        polare.add(p2);
        polare.add(p3);
    }
    public List<kompisar> getAll(){
        return polare;
    }
    
    public void saveToFile(List<kompisar> i){
        
    }
    
    
}
