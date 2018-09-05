package com.plantplaces.dto;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;


@Named
@ManagedBean
@Scope("session")
public class Plant implements Serializable {
	
	private static final long serialVersionUID = 25756422266802005L;
	private String name;
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	
	
	//############### START toString method ##################

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return genus + "  " + species + " " + cultivar + " " + common;
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
	
	//############### END SETTER AND GETTER methodS ##################	

}
