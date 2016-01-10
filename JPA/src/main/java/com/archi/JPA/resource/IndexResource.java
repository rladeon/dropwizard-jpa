/**
 * 
 */
package com.archi.JPA.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.archi.JPA.dao.StationDao;
import com.archi.JPA.metier.Station;
import com.codahale.metrics.annotation.Timed;
/**
 * @author rudi
 *
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class IndexResource {

	/**
	 * 
	 */
	private StationDao data;
    public IndexResource(StationDao collection2) {
        this.data = collection2;
    }
	
	@GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<Station> index() {
   		
		return data.readAll();
    
    }
	

}
