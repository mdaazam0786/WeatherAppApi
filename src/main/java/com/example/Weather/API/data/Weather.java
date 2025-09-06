package com.example.Weather.API.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Struct;

@Data
public class Weather implements Serializable {
    @JsonProperty("id")
    private int id;
    @JsonProperty("main")
    private String main;
    @JsonProperty("description")
    private String desc;
    @JsonProperty("icon")
    private String icon;
}
