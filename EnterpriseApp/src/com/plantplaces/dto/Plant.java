package com.plantplaces.dto;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.Table;


@Named
@Table(name="plants", catalog="enterpriseapp")
public class Plant implements Serializable {
	
	private static final long serialVersionUID = 25756422266802005L;
	private String name;
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	private Integer guid;

	private List<Specimen> specimens;
	
//############### START toString method ##################
	@Override
	public String toString() {
		return "Plant [name=" + name + ", genus=" + genus + ", species=" + species + ", cultivar=" + cultivar
				+ ", common=" + common + ", guid=" + guid + "]";
	}
// ############# END toString method ######################
//############### START SETTER AND GETTER methodS ##################	
	
	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getCultivar() {
		return cultivar;
	}

	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}

	public String getCommon() {
		return common;
	}

	public void setCommon(String common) {
		this.common = common;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGuid() {
		return guid;
	}

	public void setGuid(Integer guid) {
		this.guid = guid;
	}

	public List<Specimen> getSpecimens() {
		return specimens;
	}

	public void setSpecimens(List<Specimen> specimens) {
		this.specimens = specimens;
	}


	
//############### END SETTER AND GETTER methodS ##################	
}
