package com.example.fp.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "continents")
public class Continent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -315889338183441887L;

	@Id
	private String continent;
	private List<Country> countries;

	public String getContinent() {
		return continent;
	}

	public void setContinent(String name) {
		this.continent = name;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
