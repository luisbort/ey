package com.ey.model.repository;

import com.ey.model.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    public Country findCountryByCountryCode(String countryCode);

}
