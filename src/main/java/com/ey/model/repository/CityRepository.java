package com.ey.model.repository;

import com.ey.model.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Integer> {

    public City findCityByCityCode(String cityCode);

}
