package com.ey.services.usecases;

import com.ey.domain.dtos.CountryDTO;
import com.ey.domain.entities.Country;
import com.ey.domain.repository.CountryRepository;
import com.ey.services.ports.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void findAll(){

        Iterable<Country> countries =  countryRepository.findAll();
        countries.forEach(c ->System.out.println(c.getCountryName()) );

        List<CountryDTO> dtos = new ArrayList<>();
        countries.forEach(c -> {
            CountryDTO dto = modelMapper.map(c, CountryDTO.class);
            dtos.add(dto);
        } );

        System.out.println("total: "+dtos.size());

    }

    @Override
    public CountryDTO findByCountryCode(String countryCode) {

        Country countryEnt = countryRepository.findCountryByCountryCode(countryCode);

        CountryDTO countryDto = modelMapper.map(countryEnt, CountryDTO.class);

        return countryDto;
    }

    @Override
    public CountryDTO saveCountry(CountryDTO countryDTO) {

        Country country = modelMapper.map(countryDTO, Country.class);

        countryRepository.save(country);

        countryDTO.setCountryId(country.getCountryId());

        return countryDTO;
    }
}
