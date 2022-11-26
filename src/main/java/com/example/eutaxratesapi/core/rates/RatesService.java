package com.example.eutaxratesapi.core.rates;

import com.example.eutaxratesapi.core.rates.model.Rates;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatesService {

    private final TaxRepository taxRepository;
    private final ObjectMapper mapper;

    public void saveTaxsFromJsonFileToDB() {
        List<Rates> ratesList;
        try {
            ratesList = mapper
                    .readValue(
                            new File("src/main/resources/rates.json") ,
                            new TypeReference<>() {
                            });
            taxRepository.saveAll(ratesList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Rates> getAllRates(){
        return taxRepository.findAll();
    }

}
