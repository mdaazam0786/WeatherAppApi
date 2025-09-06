package com.example.Weather.API.response;

import com.example.Weather.API.data.Coord;
import com.example.Weather.API.data.Main;
import com.example.Weather.API.data.Weather;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private Coord coord;
    private Main main;
    private List<Weather> weather;

    @JsonProperty("base")
    private String base;
    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private int id;

    @JsonProperty("cod")
    private int status;

}
