package com.example.eutaxratesapi.app;

import com.example.eutaxratesapi.core.rates.RatesService;

import com.example.eutaxratesapi.core.rates.TaxRepository;
import com.example.eutaxratesapi.core.rates.model.Rates;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RatesController {
    private final RatesService ratesService;

    @GetMapping(path = "/rates")
    public ResponseEntity<List<Rates>> getEuVatRates() {
        List<Rates> allRates = ratesService.getAllRates();
        if(allRates.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else
            return new ResponseEntity<>(allRates,HttpStatus.OK);

    }
}

