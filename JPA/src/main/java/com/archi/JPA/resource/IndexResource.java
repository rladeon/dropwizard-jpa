/**
 * 
 */
package com.archi.JPA.resource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.archi.JPA.dao.PoiDao;
import com.archi.JPA.metier.Poi;
import com.codahale.metrics.annotation.Timed;

import io.dropwizard.hibernate.UnitOfWork;
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
	private PoiDao data;
    public IndexResource(PoiDao collection2) {
        this.data = collection2;
    }
	
	@GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    @UnitOfWork
    public List<Object> index() {
		List<Object> datas = new ArrayList<Object>();
        List<Poi> poies = data.readAll();
		try {
			for (Iterator<Poi> iterator =
					poies.iterator(); iterator.hasNext();){
			
		    
		    	datas.add(iterator.next());
		    }
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		return datas;
    
    }
	

}
