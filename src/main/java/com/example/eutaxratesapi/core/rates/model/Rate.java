package com.example.eutaxratesapi.core.rates.model;

import com.example.eutaxratesapi.core.rates.dto.RateDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long country_id;
    private String countryShortName;
    private String country;
    private String vat_name;
    private String vat_abbr;
    private double standard_rate;
    private double reduced_rate;
    private double reduced_rate_alt;
    private double super_reduced_rate;
    private double parking_rate;


}
