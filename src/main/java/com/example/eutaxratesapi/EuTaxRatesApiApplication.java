package com.example.eutaxratesapi;

import com.example.eutaxratesapi.core.rates.RatesService;
import com.example.eutaxratesapi.core.rates.model.Rates;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EuTaxRatesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EuTaxRatesApiApplication.class ,args);


	}
}
