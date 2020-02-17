package com.example.fp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Repository
public class FlagPickerRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Continent> findAll() {
		return mongoTemplate.findAll(Continent.class);
	}

	public List<Continent> findByContinents(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").regex("^" +name+ "$","i"));
		return mongoTemplate.find(query, Continent.class);
	}

	public List<Country> findContries(List<String> countryNames) {
		List<Country> countries = new ArrayList<>();
		countryNames.forEach(country -> {
			Query query = new Query();
			query.addCriteria(Criteria.where("countries.name").in(countryNames));
			List<Continent> continents = mongoTemplate.find(query, Continent.class);
			continents.forEach(continent -> {
				List<Country> resCountries = continent.getCountries();
				resCountries.forEach(resCountry -> {
					countryNames.contains(resCountry.getName());
					countries.add(resCountry);
				});
			});
		});
		return countries;
	}

}