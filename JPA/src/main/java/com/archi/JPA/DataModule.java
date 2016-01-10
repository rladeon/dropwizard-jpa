/**
 * 
 */
package com.archi.JPA;

/*import javax.inject.Singleton;

import org.hibernate.SessionFactory;

import com.archi.JPA.dao.StationDao;
import com.archi.JPA.resource.DataResource;
import com.archi.JPA.resource.IndexResource;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;


public class DataModule implements Module{

	
	private StationDao m;
	private SessionFactory s;
	public DataModule(StationDao _m, SessionFactory s) 
	{
		// TODO Auto-generated constructor stub
		this.m = _m;
		this.s= s;
	}
	
	public DataModule() 
	{
		// TODO Auto-generated constructor stub
		
	}

	@Provides
	@Singleton
	StationDao provideStationDao() 
	{
	    return new StationDao(s);
	}
	
	@Provides
	@Singleton
	IndexResource provideIndexResource() {
	    return new IndexResource(m);
	  }
	@Provides
	@Singleton
	DataResource provideDataResource() {
	    return new DataResource(m);
	  }
		
	@Override
	public void configure(Binder arg0) {
	
		
	}
}
*/