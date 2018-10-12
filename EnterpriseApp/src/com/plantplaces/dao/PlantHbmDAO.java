package com.plantplaces.dao;

import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plantplaces.dto.Plant;


@SuppressWarnings("unchecked")
@Named("plantDAO")
public class PlantHbmDAO implements IPlantDAO {

	@Override
	public List<Plant> fetchPlants() {
		// TODO fetching the list of the plants.
//		
//		List<Plant> plants = new ArrayList<Plant>();
//		
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		
////		org.hibernate.Query query = session.createQuery("select distinct p from Plant p ").list();
//
//		session.getTransaction().commit();
//		return plants;
		return null;
	}
	
	
	public List<Plant> fetchPlants(Plant plant){
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("from plant where common = :common ");
		query.setProperties(plant);
//		query.setParameter("common", plant.getCommon());

		@SuppressWarnings("rawtypes")
		List list = query.list();

		List<Plant> plants = Collections.checkedList(list, Plant.class);
		
		return plants;
		
		
	}
	
	

	@Override
	public void insert(Plant plant) throws Exception {
		// Save the entity to the database. . . 
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plant);
		session.getTransaction().commit();
		session.flush();
	}

	@Override
	public void update(Plant plant) throws Exception {
		// TODO Update the entity to the database.
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(plant);
		session.getTransaction().commit();

	}

	@Override
	public void delete(Plant plant) throws Exception {
		// TODO Delete plant
		

	}

}
