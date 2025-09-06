package com.example.Weather.API.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data

public class Coord implements Serializable {
    @JsonProperty("lat")
    private double lat;
    @JsonProperty("lon")
    private double lon;
}
