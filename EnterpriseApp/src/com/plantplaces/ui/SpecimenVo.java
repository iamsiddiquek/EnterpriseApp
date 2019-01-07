package com.plantplaces.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import com.plantplaces.dto.Photo;
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
	@Inject
	private
	Photo photo;

    private UploadedFile file;

	
	
	
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
	


	private void loadSpecimens() {
		plantService.loadSpecimens(plant);
	}


    public void onRowSelect(SelectEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Selected", "Information of plant");
        FacesContext.getCurrentInstance().addMessage("searchGrowl", msg);
        Specimen specimen = ((Specimen) event.getObject()); 
        setSpecimen(specimen);
    }

    
     
    public void upload() {
    	if( specimen.getId() == 0) {
			FacesMessage message = new FacesMessage("Please Select Specimen before uploading Image");
			FacesContext.getCurrentInstance().addMessage(null, message);		 
    	}
    	else if(file != null) {
        	InputStream inputStream;
			try {
				photo.setSpecimenId(specimen.getId());
				inputStream = file.getInputstream();
	        	plantService.savePhoto(photo, inputStream);
				FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
				FacesContext.getCurrentInstance().addMessage(null, message);		 
			} catch (IOException e) {
				e.printStackTrace();
	            FacesMessage message = new FacesMessage("Un-Succesful", file.getFileName() + " cannot upload.");
	            FacesContext.getCurrentInstance().addMessage(null, message);
			}
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    
	
	
	
	

//############### START SETTER AND GETTER methodS ##################	
	
	public Plant getPlant() {
		return plant;
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
		loadSpecimens();
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public IPlantService getPlantService() {
		return plantService;
	}

	public void setPlantService(IPlantService plantService) {
		this.plantService = plantService;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

//############### END SETTER AND GETTER methodS ##################	
}
