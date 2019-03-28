package com.plantplaces.dao;

import org.hibernate.Session;

public abstract class PlantPlacesDao<T> {

	public void save(T dto) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		insert(session, dto);
		session.getTransaction().commit();
		session.flush();
	}

	abstract protected void insert(Session session, T dto) throws Exception;
	
}
