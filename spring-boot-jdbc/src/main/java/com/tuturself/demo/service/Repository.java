package com.tuturself.demo.service;

import com.tuturself.demo.mapper.CityMapper;
import com.tuturself.demo.mapper.CountryMapper;
import com.tuturself.demo.model.City;
import com.tuturself.demo.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private QueryProvider queryProvider;

    @Autowired
    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public City getCityById(Integer cityId) {
        String query = queryProvider.getCity() + " and ci.city_id = ?";
        return this.jdbcTemplate.queryForObject(query, new Object[]{cityId}, new CityMapper());
    }

    public List<City> getCityListByCountryId(Integer countryId) {
        String query = queryProvider.getCity() + " and co.country_id = ?";
        return this.jdbcTemplate.query(query, new Object[]{countryId}, new CityMapper());
    }

    public Country getCountryById(Integer countryId) {
        String query = queryProvider.getCountry() + " and co.country_id = ?";
        Country country = this.jdbcTemplate.queryForObject(query, new Object[]{countryId}, new CountryMapper());
        if (country != null) {
            country.setCityList(getCityListByCountryId(country.getId()));
        }
        return country;
    }

    public List<Country> getCountryList() {
        List<Country> countryList = this.jdbcTemplate.query(queryProvider.getCountry(), new CountryMapper());
        if (countryList != null && !countryList.isEmpty()) {
            countryList.forEach(country -> {
                country.setCityList(getCityListByCountryId(country.getId()));
            });
        }
        return countryList;
    }

    public void save(City city, boolean isUpdate) {
        if (isUpdate) {
            jdbcTemplate.update(queryProvider.getUpdateCity(), city.getName(), city.getId());
        } else {
            jdbcTemplate.update(queryProvider.getAddCity(), city.getName(), city.getCountryId());
        }
    }

    public void save(Country country, boolean isUpdate) {
        if (isUpdate) {
            jdbcTemplate.update(queryProvider.getUpdateCountry(), country.getName(), country.getId());
        } else {
            jdbcTemplate.update(queryProvider.getAddCountry(), country.getName());
        }
    }

    public void deleteCityById(Integer cityId) {
        String query = "delete from city where city_id = ?";
        jdbcTemplate.update(query, cityId);
    }
}
