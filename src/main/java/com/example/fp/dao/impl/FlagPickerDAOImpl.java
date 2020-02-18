package com.example.fp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Repository
public class FlagPickerRepository {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerRepository.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	/**
	 * Repository to fetch all continents
	 *
	 * @param 
	 * @return List<Continent>
	 */
	public List<Continent> findAll() {
		return mongoTemplate.findAll(Continent.class);
	}

	/**
	 * Repository to fetch continents by name
	 *
	 * @param name String
	 * @return continents List<Continent> 
	 */
	public List<Continent> findByContinents(String name) {
		LOGGER.info("Find by continents repository :: {}", name);
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").regex(name, "i"));
		return mongoTemplate.find(query, Continent.class);
	}

	/**
	 * Repository to find countries by name
	 *
	 * @param countryNames List<String>
	 * @return countries List<Country> 
	 */
	public List<Country> findContries(List<String> countryNames) {
		LOGGER.info("Find countries repository");
		List<Country> countries = new ArrayList<>();
			Query query = new Query();
			query.addCriteria(Criteria.where("countries.name").in(countryNames));
			List<Continent> continents = mongoTemplate.find(query, Continent.class);
			if(!CollectionUtils.isEmpty(continents)) {
				continents.forEach(continent -> {
					countries.addAll(continent.getCountries().stream().filter(e -> countryNames.contains(e.getName())).collect(Collectors.toList()));
				});
			}
		return countries;
	}

}