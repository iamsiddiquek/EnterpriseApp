package com.plantplaces.ui;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Plant;
import com.plantplaces.service.IPlantService;

@Named
@ManagedBean
@Scope("session")
public class SearchPlants implements Serializable {

	private static final long serialVersionUID = 1401883819418520422L;
//###################### START INJECTS, DECLARATIONS, ##################################
	
	@Inject
	private Plant plant;
	@Inject
	private IPlantService plantService;
	@Inject
	private SpecimenVo specimenVo;

	private List<Plant> plants;
	
//###################### END INJECTS, DECLARATIONS, ##################################	
	/**
	 * Handle button clicks from searches.
	 * @return the next navigation.
	 */
	public String execute() {
		
		plants = plantService.fetchPlants(plant);
		
		if (plants.size() > 0){
			return "success";
		} else {
			return "noresults";
		}
	}

	public List<Plant> completePlants(String query) {
		return plantService.filterPlants(query);
	}


    public void onRowSelect(SelectEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Selected", "Information of plant");
        FacesContext.getCurrentInstance().addMessage("searchGrowl", msg);
//        this.plant.setCommon(null);
        Plant selectedPlant = ((Plant) event.getObject()); 
        System.out.println("\nSearchPlant ->  SpecimenVo.setPlant -> getObject:: "+selectedPlant);
        specimenVo.setPlant(selectedPlant);
        FacesContext.getCurrentInstance().getExternalContext().redirect("specimen.xhtml");
    }

	
	
	
	
// ####################### START SETTER AND GETTER  ############################
	
	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	public SpecimenVo getSpecimenVo() {
		return specimenVo;
	}

	public void setSpecimenVo(SpecimenVo specimenVo) {
		this.specimenVo = specimenVo;
	}

// ####################### START SETTER AND GETTER ############################
	
}
