package com.plantplaces.ui;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.ISpecimenService;

@Named
@ManagedBean
@Scope("request")
public class SpecimenVo {
	
	@Inject
	private Plant plant; 
	
	@Inject
	private ISpecimenService specimenService;
	
	@Inject
	private Specimen specimen;
	
	public void save() {
		specimen.setPlantId(plant.getGuid());
		if(specimen != null) {			
			specimenService.addSpecimen(specimen);
		}
		FacesContext.getCurrentInstance().addMessage("addSpecimen", new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Specimen Saved"));
	}
	
	
	
	
	
	

//############### START SETTER AND GETTER methodS ##################	
	
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

	public ISpecimenService getSpecimenService() {
		return specimenService;
	}

	public void setSpecimenService(ISpecimenService specimenService) {
		this.specimenService = specimenService;
	}

//############### END SETTER AND GETTER methodS ##################	
}
