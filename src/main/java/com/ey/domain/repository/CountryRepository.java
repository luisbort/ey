package com.ey.domain.repository;

import com.ey.domain.entities.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    public Country findCountryByCountryCode(String countryCode);

}
