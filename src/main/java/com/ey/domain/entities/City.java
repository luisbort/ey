package com.ey.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "EYSCHEMA", name = "TBL_CITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @Column(name = "cityid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer cityId;

    @Column(name = "citycode", nullable = false, length = 4)
    public String cityCode;

    @Column(name = "cityname", nullable = false, length = 50)
    public String cityName;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("City{");
        sb.append("cityId=").append(cityId);
        sb.append(", cityCode='").append(cityCode).append('\'');
        sb.append(", cityName='").append(cityName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
