/**
 * 
 */
package com.archi.JPA.health;

import org.hibernate.SessionFactory;

import com.codahale.metrics.health.HealthCheck;

/**
 * @author rudi
 *
 */
public class DataHealthCheck extends HealthCheck{


	SessionFactory s;
	 
    public DataHealthCheck(SessionFactory s) 
	 {
        super();
        this.s = s;
    }
 
    @Override
    protected Result check()  
    {
    	try
    	{
    		s.openSession();
    		return Result.healthy();
    	}
    	catch(Exception e)
    	{
    		s.close();
    		return Result.healthy();
    	}
    }

}
