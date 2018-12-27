package com.plantplaces.dto;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.Table;

@Named
@Table(name="specimen", catalog="enterpriseapp")
public class Specimen implements Serializable {

	private static final long serialVersionUID = 3150528394882066247L;
	private Integer id;
	private Integer plantId;
	private String longitude;
	private String latitude;
	private String plantedBy;
	private String plantedDate;
	private String description;
	

	
	
//##################### Start toString method ########################
	@Override
	public String toString() {
		return "Specimen [id=" + id + ", plantId=" + plantId + ", longitude=" + longitude + ", latitude=" + latitude
				+ ", plantedBy=" + plantedBy + ", plantedDate=" + plantedDate + "]";
	}
//##################### End toString method ########################
//############### START SETTER AND GETTER methodS ##################	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getPlantedBy() {
		return plantedBy;
	}
	public void setPlantedBy(String plantedBy) {
		this.plantedBy = plantedBy;
	}
	public String getPlantedDate() {
		return plantedDate;
	}
	public void setPlantedDate(String plantedDate) {
		this.plantedDate = plantedDate;
	}
	public Integer getPlantId() {
		return plantId;
	}
	public void setPlantId(Integer plantId) {
		this.plantId = plantId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
