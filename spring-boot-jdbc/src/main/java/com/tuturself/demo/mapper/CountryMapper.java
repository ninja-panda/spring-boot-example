package com.tuturself.demo.mapper;

import com.tuturself.demo.model.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet row, int rowNum) throws SQLException {
        Country country = new Country();
        country.setId(row.getInt("country_id"));
        country.setName(row.getString("country"));
        return country;
    }
}
