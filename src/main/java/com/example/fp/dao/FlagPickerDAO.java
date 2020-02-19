package com.example.fp.dao;

import java.util.List;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;

public interface FlagPickerDAO {

	/**
	 * Repository to fetch all continents
	 *
	 * @param
	 * @return List<Continent>
	 */
	public List<Continent> findAll();

	/**
	 * Repository to fetch continents by name
	 *
	 * @param name String
	 * @return continents List<Continent>
	 */
	public List<Continent> findByContinents(String name);

	/**
	 * Repository to find countries by name
	 *
	 * @param countryNames List<String>
	 * @return countries List<Country>
	 */
	public List<Country> findContries(List<String> countryNames);

}