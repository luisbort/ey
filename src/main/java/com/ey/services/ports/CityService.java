package com.ey.services.ports;

import com.ey.domain.dtos.CityDTO;

import java.util.List;

public interface CityService {

    public List<CityDTO> findAll();

    public CityDTO findCityByCityCode(String cityCode);
}
