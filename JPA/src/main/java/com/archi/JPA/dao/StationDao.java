/**
 * 
 */
package com.archi.JPA.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.archi.JPA.metier.Station;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;

/**
 * @author rudi
 *
 */
public class StationDao extends AbstractDAO<Station>{
	public StationDao(SessionFactory sessionFactory) {
		super(sessionFactory);
		// TODO Auto-generated constructor stub
	}

	
	
	public Station save(Station s) {
		
		return s;
		// TODO Auto-generated method stub

	}

	public void update(Station s) {
		// TODO Auto-generated method stub

	}

	public void delete(String s) {
		// TODO Auto-generated method stub

	}

	public List<Station> readAll() {
		// TODO Auto-generated method stub
		return null;
		
	}

	 public Optional<Station> findById(long id) {
	        return Optional.fromNullable(get(id));
	    }

}
