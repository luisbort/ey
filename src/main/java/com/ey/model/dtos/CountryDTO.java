package com.ey.model.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    @JsonProperty("countryid")
    public Integer countryId;

    @JsonProperty("countrycode")
    public String countryCode;

    @JsonProperty("countryname")
    public String countryName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CountryDTO{");
        sb.append("countryId=").append(countryId);
        sb.append(", countryCode='").append(countryCode).append('\'');
        sb.append(", countryName='").append(countryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
