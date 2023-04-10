package com.ey.model.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    @JsonProperty("number")
    @NotNull(message = "number must not be null")
    private String phoneNumber;

    @JsonProperty("citycode")
    @NotNull(message = "citycode must not be null")
    private String cityCode;

    @JsonProperty("countrycode")
    @NotNull(message = "countrycode must not be null")
    private String countryCode;

    @JsonIgnore
    private CityDTO cityDTO;

    @JsonIgnore
    private CountryDTO countryDTO;

    @JsonIgnore
    private UserDTO userDTO;
}
