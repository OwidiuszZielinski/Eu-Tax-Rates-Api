package com.example.eutaxratesapi.core.rates;

import com.example.eutaxratesapi.core.rates.model.Rate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RateService {

    private final TaxRepository taxRepository;
    private final ObjectMapper mapper;

    public void saveTaxsFromJsonFileToDB() {
        List<Rate> rateList;
        try {
            rateList = mapper
                    .readValue(
                            new File("src/main/resources/rates.json") ,
                            new TypeReference<>() {
                            });
            taxRepository.saveAll(rateList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Rate> getAllRates(){
        return taxRepository.findAll();
    }

    public Rate getRateByShortName(String shortName){
        return taxRepository.findByCountryShortName(shortName);
    }

}
