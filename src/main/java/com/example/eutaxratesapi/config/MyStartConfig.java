package com.example.eutaxratesapi.config;

import com.example.eutaxratesapi.core.rates.RatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyStartConfig implements CommandLineRunner {

    private final RatesService ratesService;

    @Override
    public void run(String... args) throws Exception {
        ratesService.saveTaxsFromJsonFileToDB();
    }
}
