package com.ey.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "EYSCHEMA", name = "TBL_COUNTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @Column(name = "countryid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer countryId;

    @Column(name = "countrycode", nullable = false, length = 3)
    public String countryCode;

    @Column(name = "countryname", nullable = false, length = 50)
    public String countryName;

}
