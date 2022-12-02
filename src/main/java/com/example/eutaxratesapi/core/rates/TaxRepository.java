package com.example.eutaxratesapi.core.rates;

import com.example.eutaxratesapi.core.rates.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Rate,Long> {
     Rate findByCountryShortName(String shortName);

}
