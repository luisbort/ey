package com.ey.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    @JsonProperty("cityid")
    public Integer cityId;

    @JsonProperty("citycode")
    public String cityCode;

    @JsonProperty("cityname")
    public String cityName;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CityDTO{");
        sb.append("cityId=").append(cityId);
        sb.append(", cityCode='").append(cityCode).append('\'');
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
