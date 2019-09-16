package com.tuturself.demo;

import com.tuturself.demo.model.City;
import com.tuturself.demo.model.Country;
import com.tuturself.demo.service.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class API {

    private String message = "Data saved successfully";

    @Autowired
    private Repository repository;

    @GetMapping("/city/{cityId}")
    public ResponseEntity getCity(@PathVariable("cityId") Integer cityId) {
        City city = repository.getCityById(cityId);
        return new ResponseEntity(city, HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}/cities")
    public ResponseEntity getCityListByCountryId(@PathVariable("countryId") Integer countryId) {
        List<City> cityList = repository.getCityListByCountryId(countryId);
        return new ResponseEntity(cityList, HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity getCountryById(@PathVariable("countryId") Integer countryId) {
        Country country = repository.getCountryById(countryId);
        return new ResponseEntity(country, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity getCountryList() {
        List<Country> countryList = repository.getCountryList();
        return new ResponseEntity(countryList, HttpStatus.OK);
    }

    @PostMapping("/country")
    public ResponseEntity addCountry(@RequestParam("name") String countryName) {
        Country country = new Country();
        country.setName(countryName);
        repository.save(country, false);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PutMapping("/country/{countryId}")
    public ResponseEntity updateCountryById(@PathVariable("countryId") Integer countryId,
                                            @RequestParam("name") String countryName) {
        Country country = new Country();
        country.setId(countryId);
        country.setName(countryName);
        repository.save(country, true);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PostMapping("/city")
    public ResponseEntity addCity(@RequestParam("countryId") Integer countryId,
                                  @RequestParam("name") String cityName) {
        City city = new City();
        city.setCountryId(countryId);
        city.setName(cityName);
        repository.save(city, false);
        return new ResponseEntity(message, HttpStatus.OK);
    }

    @PutMapping("/city/{cityId}")
    public ResponseEntity updateCityById(@PathVariable("cityId") Integer cityId,
                                         @RequestParam("name") String cityName,
                                         @RequestParam("countryId") Integer countryId) {
        City city = new City();
        city.setId(cityId);
        city.setName(cityName);
        city.setCountryId(countryId);
        return new ResponseEntity(city, HttpStatus.OK);
    }

    @DeleteMapping("/city/{cityId}")
    public ResponseEntity deleteCity(@PathVariable("cityId") Integer cityId) {
        repository.deleteCityById(cityId);
        return new ResponseEntity("The City with cityId" + cityId + " is deleted from database", HttpStatus.OK);
    }
}
