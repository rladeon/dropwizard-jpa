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

import com.archi.JPA.dao.StationDao;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonParseException;
/**
 * @author rudi
 *
 */

@Path("/crud")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DataResource {
	
	private StationDao data;
		
	public DataResource(StationDao collection2) {
        this.data = collection2;
    }
	@Path("/add")	
	@POST
    @Timed
    public Response publishNewData(@Context UriInfo uriInfo,String inputJsonObj) throws JsonParseException, IOException {
		String id = UUID.randomUUID().toString();
	    
	    
	    return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
	        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/edit/{id}")	
	@POST
    @Timed
    public Response editData(@Context UriInfo uriInfo,@PathParam(value = "id") String _id, String inputJsonObj) throws JsonParseException, IOException {
		String id = UUID.randomUUID().toString();

		
    
	    return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/delete/{id}")	
	@DELETE
    @Timed
    public Response deleteData(@Context UriInfo uriInfo,@PathParam(value = "id") String _id) throws JsonParseException, IOException {
		String id = UUID.randomUUID().toString();
	    	
    
		return Response.created(uriInfo.getAbsolutePathBuilder().path(id.toString()).build())
        .header("X-Document-ID", id.toString()).build();
	}
	@Path("/query/{id}")	
	@GET
    @Timed
    public List<Object> queryDataId(@Context UriInfo uriInfo,@PathParam(value = "id") String _id) throws JsonParseException, IOException {
		List<Object> res = new ArrayList<Object>();
	   
		return res;
	}
	@Path("/querymark/{keyword}")	
	@GET
    @Timed
    public List<Object> queryDataMark(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
	
	@Path("/querymodel/{keyword}")	
	@GET
    @Timed
    public List<Object> queryDataModel(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
	
	@Path("/queryserie/{keyword}")	
	@GET
    @Timed
    public List<Object> queryDataSerie(@Context UriInfo uriInfo,@PathParam(value = "keyword") String words) throws JsonParseException, IOException 
	{
		List<Object> res = new ArrayList<Object>();
		

	    return res;
	}
}
