package com.plantplaces.dao;

import java.util.List;

import org.hibernate.Session;

import com.plantplaces.dto.Specimen;

public interface ISpecimenDao {

	
	public void save(Specimen specimen) throws Exception;

	public List<Specimen> specimensByPlantId(int plantId);

	public void insert(Session session, Specimen specimen);
	
}
