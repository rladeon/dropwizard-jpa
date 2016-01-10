/**
 * 
 */
package com.archi.JPA.managed;

import org.hibernate.SessionFactory;

import io.dropwizard.lifecycle.Managed;

/**
 * @author rudi
 *
 */
public class DataBaseManaged implements Managed{

	/**
	 * 
	 */
	private SessionFactory c;
	
	
    public DataBaseManaged(SessionFactory _c) 
	 {
		 c = _c;
    }
 
    public void start() throws Exception {
    	c.openSession();
    }
 
    public void stop() throws Exception {
        c.close();
    }
}
