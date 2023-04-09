package com.ey.domain.repository;

import com.ey.domain.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

    public City findCityByCityCode(String cityCode);

}
