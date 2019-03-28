package com.plantplaces.dao;

import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Plant;

public interface IPlantDao {
	
	public List<Plant> fetchPlants();
	
	public void save(Plant plant) throws Exception;
	
	public void update (Plant plant) throws Exception;
	
	public void delete (Plant plant) throws Exception;

	public List<Plant> fetchPlants(Plant plant);

	public Plant fetchPlant(int guid);

	public void insert(Session session, Plant plant) throws Exception;

}
