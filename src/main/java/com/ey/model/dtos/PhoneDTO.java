package com.ey.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonIgnore
    private CityDTO cityDTO;

    @JsonIgnore
    private CountryDTO countryDTO;

    @JsonIgnore
    private UserDTO userDTO;
}
