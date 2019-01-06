package com.plantplaces.dao;

import java.util.List;

import com.plantplaces.dto.Specimen;

public interface ISpecimenDao {

	
	public void addSpecimen(Specimen specimen);

	List<Specimen> specimensByPlantId(int plantId);
	
}
