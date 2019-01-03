package com.plantplaces.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.plantplaces.dao.IPlantDao;
import com.plantplaces.dao.ISpecimenDao;
import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
public class PlantService implements IPlantService {

//###################### START INJECTS, DECLARATIONS, ##################################
	
	@Inject
	private	IPlantDao plantDAO;
		
	private List<Plant> allPlants;
	
	@Inject
	private ISpecimenDao specimenDao;
	
//###################### END INJECTS, DECLARATIONS, ##################################
	
	
	
	
	@Override
	public List<Plant> filterPlants(String filter) {
		if (allPlants == null ) {
			allPlants = getPlantDAO().fetchPlants();
		}
		
		// the collection we are returning.
		List<Plant> returnPlants = new ArrayList<>();

		// filter the list.
		// interview all possible plants (allPlants), and move plants that contain the filter text into our subset collection (returnPlans)
		for (Plant plant : allPlants) {

			if (plant.toString().toLowerCase().contains(filter.toLowerCase())) {
				// this plant matches our criteria, so add it to the collection that will be returned from this method.
				returnPlants.add(plant);
			}
		}
		
		return returnPlants;
	}


	@Override
	public void save(Plant plant) throws Exception {
		if(!plant.getGenus().equals(null) || !plant.getGenus().isEmpty()) {
			plantDAO.insert(plant);
		}else
			throw new Exception("Genius is required.");
	}
	
	/**
	 * return list of plants that matches the search criteria
	 * parameter have search criteria
	 * returns list of matching result.
	 */
	@Override
	public List<Plant> fetchPlants(Plant plant){
		List<Plant> plants = plantDAO.fetchPlants(plant);
		
		return plants;
	}

	
	@Override
	public Plant fetchPlant(int guid) {
		return plantDAO.fetchPlant(guid);
	}


	@Override
	public void save(Specimen specimen)throws Exception{
		specimenDao.addSpecimen(specimen);
	}

	
	
	// ########################## GETTER AND SETTERS #####################################
	public IPlantDao getPlantDAO() {
		return plantDAO;
	}

	public void setPlantDAO(IPlantDao plantDAO) {
		this.plantDAO = plantDAO;
	}

	public ISpecimenDao getSpecimenDao() {
		return specimenDao;
	}

	public void setSpecimenDao(ISpecimenDao specimenDao) {
		this.specimenDao = specimenDao;
	}


}
