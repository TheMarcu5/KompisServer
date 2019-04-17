/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KompisDao;

import java.util.List;
import javax.ws.rs.GET; 
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path; 
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/adresser")

public class KompisDao {
   //private static DaoInterface inter = new AllaKompisarDao();
   //private static DaoInterface inter = new AllKompisarPers();
   private static DaoInterface inter = new AllKompisarPersGson();
   //private static AllaKompisarDao alla = new AllaKompisarDao();
   private static List<kompisar> kompislistan = inter.getAll();
   
   
   @GET 
   @Path("/polarnas") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<kompisar> getPolare(){ 
      return inter.getAll();
}
   @GET 
   @Path("/polarna") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<kompisar> getPolarna(){
       
       
      return kompislistan;
}
   @GET 
   @Path("/polare/{name}") 
   @Produces(MediaType.APPLICATION_JSON) 
   public kompisar getPolare(@PathParam("name") String name){
      kompisar res = new kompisar();
      
       for(kompisar i: inter.getAll()){
          if(i.getName().equals(name) ){
              res = i;
              
          }
      }
      return res;
   }
   
   @GET 
   @Path("/polareId/{id}") 
   @Produces(MediaType.APPLICATION_JSON) 
   public kompisar getPolare(@PathParam("id")int id){
      kompisar res = new kompisar();
      
       for(kompisar i: kompislistan){
          if(i.getId()==id ){
              res = i;
              
          }
      }
      return res;
   }
   
   @GET 
   @Path("/polare/{name}/delete") 
   @Produces(MediaType.APPLICATION_XML) 
   public Response deletePolare(@PathParam("name") String name){
       Response res = new Response("Book deleted", Boolean.FALSE);
      
       int indexToRemove = -1;
       
       for(int i = 0; i<kompislistan.size(); i++){
           if(kompislistan.get(i).getName().equals(name)){
               indexToRemove = i;
           }
       }
       
       if(indexToRemove != -1){
           kompislistan.remove(indexToRemove);
           res.setStatus(Boolean.TRUE);
       }
       return res;
   }
   
   @POST
   @Path("/polare/add") 
    
   public Response addPolare(kompisar i){
      Response res = new Response("Book added", Boolean.FALSE);
       if(upsert(i)){
           res.setStatus(Boolean.TRUE);
       }
       else{
        kompislistan.add(i);
        res.setStatus(Boolean.TRUE);
       }
       inter.saveToFile(kompislistan);
       return res;
   }
   
   public boolean upsert(kompisar nykompis){
       for(int i = 0; i<kompislistan.size();i++){
           if(kompislistan.get(i).getId()== nykompis.getId()){
               kompislistan.set(i,nykompis);
               return true;
           }
       }
       return false;
   } 
}   
