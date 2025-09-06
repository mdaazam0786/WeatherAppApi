package com.example.Weather.API.service;

import com.example.Weather.API.response.WeatherResponse;

public interface WeatherService {

    WeatherResponse getTodaysWeather(String location);

    WeatherResponse getWeatherBetweenRange(String location, String startDate, String endDate);
}
