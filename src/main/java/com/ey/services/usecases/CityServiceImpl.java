package com.ey.services.usecases;

import com.ey.model.dtos.CityDTO;
import com.ey.model.entities.City;
import com.ey.model.repository.CityRepository;
import com.ey.services.ports.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CityDTO> findAll(){
        Iterable<City> allCities = cityRepository.findAll();
        List<CityDTO> cities = new ArrayList<>();
        allCities.forEach(city -> {
            CityDTO cityDTO = modelMapper.map(city, CityDTO.class);
            cities.add(cityDTO);
        });
        return cities;
    }

    @Override
    public CityDTO findCityByCityCode(String cityCode){

        City city = cityRepository.findCityByCityCode(cityCode);

        System.out.println(city);

        CityDTO cityDto = modelMapper.map(city, CityDTO.class);

        System.out.println(cityDto);

        return cityDto;
    }
}
