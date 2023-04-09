package com.ey.controllers.city.read;

import com.ey.domain.dtos.CityDTO;
import com.ey.services.ports.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/findAllCities")
    public List<CityDTO> findAllCities(){

        return cityService.findAll();
    }

    @PostMapping(value = "/findCityByCode")
    public ResponseEntity<CityDTO> create(@Valid @RequestBody CityDTO cityDTO) {

        CityDTO city = cityService.findCityByCityCode(cityDTO.getCityCode());

        return new ResponseEntity(city, HttpStatus.CREATED);
    }

}
