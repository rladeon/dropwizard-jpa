/**
 * 
 */
package com.archi.JPA.resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.archi.JPA.dao.PoiDao;
import com.archi.JPA.metier.Poi;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.hibernate.UnitOfWork;
/**
 * @author rudi
 *
 */

@Path("/crud")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DataResource {
	
	private PoiDao data;
		
	public DataResource(PoiDao collection2) {
        this.data = collection2;
    }
	@Path("/add")	
	@POST
    @Timed
    @UnitOfWork
    public Response publishNewData(@Context UriInfo uriInfo,String inputJsonObj) throws JsonParseException, IOException {
		Integer id = 17;
		 ObjectMapper mapper = new ObjectMapper();
		    JsonFactory factory = mapper.getFactory();
		    JsonParser jp = factory.createJsonParser( inputJsonObj );
		    JsonNode actualObj = mapper.readTree( jp );
		    
		    // If you want a value
		    String title = actualObj.get( "title").textValue();
		    String lat = actualObj.get( "lat").textValue();
		    String lng = actualObj.get( "lng").textValue();
		    String alt = actualObj.get( "alt").textValue();
		    String description = actualObj.get( "description").textValue();
		    Poi s = new Poi(title,lat,lng,alt,description);
		    data.save(s);
		    
	    return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
	        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/edit/{id}")	
	@POST
    @Timed
    @UnitOfWork
    public Response editData(@Context UriInfo uriInfo,@PathParam(value = "id") String _id, String inputJsonObj) throws JsonParseException, IOException {
		String id = UUID.randomUUID().toString();

		
    
	    return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/delete/{id}")	
	@DELETE
    @Timed
    @UnitOfWork
    public Response deleteData(@Context UriInfo uriInfo,@PathParam(value = "id") String _id) throws JsonParseException, IOException {
		String id = UUID.randomUUID().toString();
	    	
    
		return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/query/{id}")	
	@GET
    @Timed
    @UnitOfWork
    public List<Object> queryDataId(@Context UriInfo uriInfo,@PathParam(value = "id") String _id) throws JsonParseException, IOException {
		List<Object> res = new ArrayList<Object>();
	   
		return res;
	}
	@Path("/querymark/{keyword}")	
	@GET
    @Timed
    @UnitOfWork
    public List<Object> queryDataMark(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
	
	@Path("/querymodel/{keyword}")	
	@GET
    @Timed
    @UnitOfWork
    public List<Object> queryDataModel(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
	
	@Path("/queryserie/{keyword}")	
	@GET
    @Timed
    @UnitOfWork
    public List<Object> queryDataSerie(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
}
