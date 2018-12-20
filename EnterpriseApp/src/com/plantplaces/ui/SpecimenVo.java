package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;

@Named
@ManagedBean
@Scope("request")
public class SpecimenVo {
	
	@Inject
	private Plant plant; 
	@Inject
	private Specimen specimen;
	
	
	
	
	
	
	public void save() {
		System.out.println(plant);
		System.out.println(specimen);
	}
	
	
	
	
	
	
	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public Specimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(Specimen specimen) {
		this.specimen = specimen;
	}
	
}
