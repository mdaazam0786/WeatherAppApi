package com.example.Weather.API.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.servlet.annotation.HandlesTypes;
import lombok.Data;

import java.io.Serializable;

@Data
public class Wind implements Serializable {
    @JsonProperty("speed")
    private double speed;
    @JsonProperty("deg")
    private int deg;
    @JsonProperty("gust")
    private double gust;

}
