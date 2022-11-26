package com.example.eutaxratesapi.core.rates.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int country_id;
    private String country;
    private String vat_name;
    private String vat_abbr;
    private double standard_rate;
    private double reduced_rate;
    private double reduced_rate_alt;
    private boolean super_reduced_rate;
    private double parking_rate;
}
