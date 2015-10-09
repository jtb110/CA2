
package api;

import Utility.JSONConverter;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.*;
import control.*;
import exceptions.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Emil
 */
@Path("person")
public class PersonResource {
    Gson gson;

    ControlCRUD cc = new ControlCRUD();
    @Context
    private UriInfo context;
    

    public PersonResource() {
        gson = new GsonBuilder()
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create();
}

    @GET
    @Path("complete")
    @Produces("application/json")
    public String getAllPersons() throws NotFoundException {
        return JSONConverter.getJSONFromPersonList(cc.getAllPersons());
    }
    
   
    
    @GET
    @Path("complete/{id}")
    @Produces("application/json")
    public String getPersonByID(@PathParam("id") int id) throws NotFoundException {
        return JSONConverter.getJSONFromPerson(cc.getPerson(id));
    }

    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
        
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public String CreateNewPerson(String person) {
        
        Person p = JSONConverter.getPersonFromJson(person);
        p = cc.createPerson(p);
        return JSONConverter.getJSONFromPerson(p);
    }
    
}