package com.plantplaces.ui;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.dto.Specimen;
import com.plantplaces.service.IPlantService;
import com.plantplaces.service.ISpecimenService;

@Named
@ManagedBean
@Scope("session")
public class SpecimenVo implements Serializable {

	private static final long serialVersionUID = -1867171764912985264L;
	@Inject
	private Plant plant; 
	@Inject
	private IPlantService plantService;
	@Inject
	private ISpecimenService specimenService;
	@Inject
	private Specimen specimen;
	
	public String save() {
		specimen.setPlantId(plant.getGuid());
		System.out.println("Plant In specimenVO: "+plant);

		try {
			plantService.save(specimen);
			return "specimenSaved";
		} catch (Exception e) {
			e.printStackTrace();
			return "specimenFailed";
		}
  		
//		if(specimen != null) {
//			specimenService.addSpecimen(specimen);
//		}
//		FacesContext.getCurrentInstance().addMessage("addSpecimen", new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Specimen Saved"));
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







	public IPlantService getPlantService() {
		return plantService;
	}







	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

//############### END SETTER AND GETTER methodS ##################	
}
