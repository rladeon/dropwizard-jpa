/**
 * 
 */
package com.archi.JPA.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.archi.JPA.metier.Poi;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;

/**
 * @author rudi
 *
 */
public class PoiDao extends AbstractDAO<Poi>
{
	private SessionFactory sessionFactory;
	private Session n;
	private Transaction tx;
	private long PoiID;
	
	public PoiDao(SessionFactory _sessionFactory) 
	{
		super(_sessionFactory);
		// TODO Auto-generated constructor stub
		sessionFactory = _sessionFactory;
	}

	
	
	public long save(Poi s) 
	{
		n = sessionFactory.openSession();
		tx = null;
		PoiID = 0;
		
		try
		{
			tx = n.beginTransaction();
			PoiID = persist(s).getId();
			//PoiID = (long)n.save(s);
			tx.commit();
		}
		catch(HibernateException e)
		{
			if (tx!=null)
			{
				tx.rollback();
			}
			
			e.printStackTrace();
						
		}
		finally
		{
			n.close();
		}
		
		return PoiID;
		// TODO Auto-generated method stub

	}

	public void update(Poi s) {
		// TODO Auto-generated method stub

	}

	public void delete(String s) {
		// TODO Auto-generated method stub

	}

	public List<Poi> readAll() {
		// TODO Auto-generated method stub
		n = sessionFactory.openSession();
		Criteria cr = n.createCriteria(Poi.class);
						 
		List<Poi> results = list(cr);
		
		n.close();
		return results;
		
	}

	 public Optional<Poi> findById(long id) {
	        return Optional.fromNullable(get(id));
	    }



	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
