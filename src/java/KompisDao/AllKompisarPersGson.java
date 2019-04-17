/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcu
 */
public class AllKompisarPersGson implements Serializable,DaoInterface {
    List<kompisar> polare = new ArrayList<>();
    
    public AllKompisarPersGson(){
        kompisar p1 = new kompisar(1,"Marcus", "02342342323412");
        kompisar p2 = new kompisar(2,"Jenny", "pelle42323412");
        kompisar p3 = new kompisar(3,"Batman", "asasd23412");
        
        polare.add(p1);
        polare.add(p2);
        polare.add(p3);
    }
    public List<kompisar> getAll(){
        String json = new String();
        //List<kompisar> fis = new ArrayList<kompisar>();
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\marcu\\Java\\Ny mapp (2)\\Helloworld!\\allaJson.json"));)
        {
            java.lang.reflect.Type listType = new TypeToken<ArrayList<kompisar>>(){}.getType();
            polare = new Gson().fromJson(br, listType);
            
            
        }catch(IOException e){
            e.printStackTrace();
        }
            return polare;
    }
    
    public void saveToFile(List<kompisar> i){
        Gson gson = new Gson();
        String json = gson.toJson(i);
        try (FileWriter writer = new FileWriter("C:\\Users\\marcu\\Java\\Ny mapp (2)\\Helloworld!\\allaJson.json");)
        {
            writer.write(json);
            
        } catch (IOException ex) {
            Logger.getLogger(AllKompisarPersGson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
