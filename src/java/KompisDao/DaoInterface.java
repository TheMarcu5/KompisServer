/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;

import java.util.List;

/**
 *
 * @author marcu
 */
public interface DaoInterface {
    public List<kompisar> getAll();
    public void saveToFile(List<kompisar> i);
    
}
