package com.tuturself.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Country {

    private Integer id;
    private String name;
    private List<City> cityList;
}
