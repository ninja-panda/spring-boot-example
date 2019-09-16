package com.tuturself.demo.mapper;

import com.tuturself.demo.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet row, int rowNum) throws SQLException {
        City city = new City();
        city.setId(row.getInt("city_id"));
        city.setName(row.getString("city"));
        city.setCountryId(row.getInt("country_id"));
        city.setCountryName(row.getString("country"));
        return city;
    }
}
