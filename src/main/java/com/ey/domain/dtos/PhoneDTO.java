package com.ey.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    @JsonProperty("number")
    private String phoneNumber;

    @JsonProperty("citycode")
    private String cityCode;

    @JsonProperty("countrycode")
    private String countryCode;

    private CityDTO cityDTO;

    private CountryDTO countryDTO;

    private UserDTO userDTO;
}
