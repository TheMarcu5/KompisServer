/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;


import KompisDao.AllaKompisarDao;
import KompisDao.kompisar;
import java.util.List;
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/HelloWorldService")


public class HelloWotrldService {
   
   @GET 
   @Path("/hi") 
   @Produces(MediaType.TEXT_PLAIN) 
   public String getHelloWorld(){ 
      return "Hello World, brought to you by HelloWorldService"; 
}  
}
