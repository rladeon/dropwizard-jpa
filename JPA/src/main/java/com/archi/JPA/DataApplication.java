/**
 * 
 */
package com.archi.JPA;

import com.archi.JPA.dao.StationDao;
import com.archi.JPA.health.DataHealthCheck;
import com.archi.JPA.metier.Station;
import com.archi.JPA.resource.IndexResource;
import com.archi.JPA.exception.IOExceptionMapper;
import com.archi.JPA.health.DataHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author rudi
 *
 *
 */
public class DataApplication extends Application<DataConfiguration>{
		
	
	private StationDao m;
		
	public static void main(String[] args) throws Exception {
        new DataApplication().run(args);
    }
    /**
     * Hibernate bundle.
     */
    private final HibernateBundle<DataConfiguration> hibernateBundle
            = new HibernateBundle<DataConfiguration>(
                    Station.class
            ) {

                @Override
                public DataSourceFactory getDataSourceFactory(
                        DataConfiguration configuration
                ) {
                    return configuration.getDataSourceFactory();
                }

            };
	@Override
	public void initialize(Bootstrap<DataConfiguration> bootstrap) {
	
		bootstrap.addBundle(hibernateBundle);
	
	}
	
	 @Override
	    public String getName() {
	        return "data";
	    }
	
		@Override
		public void run(DataConfiguration arg0, Environment arg1) throws Exception {
			// TODO Auto-generated method stub
			final StationDao sdao = new StationDao(hibernateBundle.getSessionFactory());
    
			arg1.jersey().register(new IndexResource(sdao));
			arg1.jersey().register(new IOExceptionMapper());
	        arg1.healthChecks().register("Dispo hibernate session", new DataHealthCheck( hibernateBundle.getSessionFactory()));
		}
	
	
}
