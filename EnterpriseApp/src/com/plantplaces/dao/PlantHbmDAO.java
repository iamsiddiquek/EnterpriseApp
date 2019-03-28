package com.plantplaces.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Query;
import org.hibernate.Session;

import com.plantplaces.dto.Plant;


@SuppressWarnings("unchecked")
@Named("plantDAO")
public class PlantHbmDAO extends PlantPlacesDao<Plant> implements IPlantDao {

	@Override
	public List<Plant> fetchPlants() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Plant");
		List<Plant> list = new ArrayList<Plant>();
		list = query.list();		
		return list;
	}
	
	
	@Override
	public List<Plant> fetchPlants(Plant plant){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Plant where common like :common ");
		// setProperties is bit more dynamic it will check the :common or another name which is write as param reference and 
		// hibernate will checks either it is available in the class like in my situation setProperties uses PLANT class.
		// query.setProperties(plant);
		query.setParameter("common", "%"+plant.getCommon()+"%");
		@SuppressWarnings("rawtypes")
		List list = query.list();
		List<Plant> plants = Collections.checkedList(list, Plant.class);
		return plants;
	}
	
	@Override
	public Plant fetchPlant(int guid) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Plant where guid = :guid ");
		query.setParameter("guid", guid);
		Plant plant = (Plant) query.uniqueResult();

		return plant;
	}
	

	@Override
	public void insert(Session session, Plant plant) throws Exception {
		// Save the entity to the database. . . 
		session.save(plant);
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
