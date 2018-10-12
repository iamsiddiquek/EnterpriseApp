package com.plantplaces.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@ManagedBean
@Scope("request")
@Named
public class AddPlant {

	@Inject
	private
	Plant plant;
	
	@Inject
	private
	IPlantService plantService;

	
	public String execute() {
		String returnValue = "success";
		
		try {
			plantService.save(plant);
			//blow the growl when this executes success.
			FacesContext.getCurrentInstance().addMessage("addPlant", new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Plant Saved"));
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage("addPlant", new FacesMessage(FacesMessage.SEVERITY_ERROR,  "Error", "Could not save the Plant"));
			returnValue = "fail";
		}		
		return returnValue;
	}
	
	
	
	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}
	
	
}
