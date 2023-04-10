package com.ey.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(schema = "EYSCHEMA", name = "TBL_PHONES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    @Id
    @Column(name = "phoneid", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer phoneId;

    @Column(name = "PHONENUMBER", nullable = false)
    public Integer phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="countryid", nullable=false)
    public Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cityid", nullable=false)
    public City city;

    @ManyToOne
    @JoinColumn(name="userid")
    public User user;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("phoneId=").append(phoneId);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", country=").append(country);
        sb.append(", city=").append(city);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
