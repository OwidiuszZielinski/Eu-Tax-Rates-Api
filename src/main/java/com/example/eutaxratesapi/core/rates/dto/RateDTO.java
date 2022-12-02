package com.example.eutaxratesapi.core.rates.dto;

import com.example.eutaxratesapi.core.rates.model.Rate;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.eutaxratesapi.core.rates.model.Rate} entity
 */
@Data
@Builder
public class RateDTO implements Serializable {
    private  long country_id;
    private  String countryShortName;
    private  String country;
    private  String vat_name;
    private  String vat_abbr;
    private  double standard_rate;
    private  double reduced_rate;
    private  double reduced_rate_alt;
    private  double super_reduced_rate;
    private  double parking_rate;

    public static List<RateDTO> fromRateList(List<Rate> rates){
        final List<RateDTO> listDTO = new ArrayList<>();
        for(Rate x :rates){
            listDTO.add(fromRate(x));
        }
        return listDTO;
    }

    public static RateDTO fromRate(Rate rate){
       return RateDTO.builder()
                .country_id(rate.getCountry_id())
                .countryShortName(rate.getCountryShortName())
                .country(rate.getCountry())
                .vat_name(rate.getVat_name())
                .vat_abbr(rate.getVat_abbr())
                .standard_rate(rate.getStandard_rate())
                .reduced_rate(rate.getReduced_rate())
                .reduced_rate_alt(rate.getReduced_rate_alt())
                .super_reduced_rate(rate.getSuper_reduced_rate())
                .parking_rate(rate.getParking_rate()).build();
    }


}