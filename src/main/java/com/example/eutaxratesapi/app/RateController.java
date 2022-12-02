package com.example.eutaxratesapi.app;

import com.example.eutaxratesapi.core.rates.RateService;

import com.example.eutaxratesapi.core.rates.dto.RateDTO;
import com.example.eutaxratesapi.core.rates.model.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RateController {
    private final RateService rateService;

    @GetMapping(path = "/rates")
    public ResponseEntity<List<RateDTO>> getEuVatRates() {
        List<RateDTO> allRates = rateService.getAllRates();
        if (allRates.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else
            return new ResponseEntity<>(allRates ,HttpStatus.OK);

    }

    @GetMapping(path = "/rates/{shortName}")
    public ResponseEntity<RateDTO> getEuRateForCountryShortName(@PathVariable String shortName) {
        try {
            RateDTO rate = rateService.getRateByShortName(shortName);
            return new ResponseEntity<>(rate ,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }
}

