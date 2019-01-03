package com.plantplaces.dao;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plantplaces.dto.Specimen;

@Named
public class SpecimenHbmDao implements ISpecimenDao {
	
	/* (non-Javadoc)
	 * @see com.plantplaces.dao.ISpecimen#addSpecimen(com.plantplaces.dto.Specimen)
	 */
	@Override
	public void addSpecimen(Specimen specimen) {
		// Save the entity to the database. . . 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(specimen);
		session.getTransaction().commit();
		session.flush();
	}

	
	
	public void fetchByPlantId(int plantId) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from Specimen where plantId = :plantId");
		query.setParameter("plantId", plantId);
	}
	
	
}
