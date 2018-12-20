package com.plantplaces.dto;

import java.io.Serializable;

import javax.inject.Named;

@Named
public class Specimen implements Serializable {

	private static final long serialVersionUID = 3150528394882066247L;
	private Integer id = 0;
	private Integer plantId = 0;
	private Double longitude = 0D;
	private Double latitude  = 0D;
	private String plantedBy = null;
	private String plantedDate = null;
	

	
	
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
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
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

}
