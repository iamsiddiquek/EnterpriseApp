package com.plantplaces.dao;

import java.util.List;

import org.junit.Test;

import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantHbmDAO extends TestCase {
		
	private PlantHbmDAO plantHbmDao;
	private List<Plant> fetchPlants;

	@Test
	public void verifyFetchByCommonName(){
		
		System.out.println("calling in test class . . . ");
//		assertTrue(true);
		assertTrue(fetchPlants.size() > 0);
		givenPlantDaoInstanciated();
		whenCommonNameIsRose();
		thenVerifyResults();
		
	}

	private void thenVerifyResults() {
		
		assertTrue(fetchPlants.size() > 0);
		for (Plant plant : fetchPlants) {
			assertEquals("Rose", plant.getCommon());
			System.out.println(plant.getCommon()+" check check . . . ");
		}
	}

	private void whenCommonNameIsRose() {		
		Plant plant = new Plant();
		plant.setCommon("Rose");
		fetchPlants = plantHbmDao.fetchPlants(plant);
	}

	private void givenPlantDaoInstanciated() {		
		plantHbmDao = new PlantHbmDAO();
		
	}
	
	

}
