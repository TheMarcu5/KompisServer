/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;



import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "kompis")
/**
 *
 * @author marcu
 */
public class kompisar implements Serializable{
    private static final long SerialVersonUID = 1L;
    private int id;
    private String name;
    private String mobil;
    
    
    public kompisar(){
    }
    public kompisar(int id,String name, String mobil){
        this.name = name;
        this.mobil = mobil;
        this.id=id;
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id ) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getMobil() {
        return mobil;
    }

    /**
     * @param mobil the mobil to set
     */
    @XmlElement
    public void setMobil(String mobil) {
        this.mobil = mobil;
    }
    
}
