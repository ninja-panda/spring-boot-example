package com.tuturself.demo.model;

import lombok.Data;

@Data
public class City {

    private Integer id;
    private String name;
    private Integer countryId;
    private String countryName;
}
