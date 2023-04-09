package com.ey.services.ports;

import com.ey.domain.dtos.CountryDTO;

public interface CountryService {

    public void findAll();

    public CountryDTO findByCountryCode(String countryCode);

    public CountryDTO saveCountry(CountryDTO countryDTO);
}
