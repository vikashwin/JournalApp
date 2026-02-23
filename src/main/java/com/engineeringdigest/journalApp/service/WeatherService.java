package com.engineeringdigest.journalApp.service;

import com.engineeringdigest.journalApp.api.response.WeatherResponse;
import com.engineeringdigest.journalApp.cache.AppCache;
import com.engineeringdigest.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")  //Be Careful about syntax
    private String apiKey;

//    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;


    public WeatherResponse getWeather(String city){
//        String finalAPI = API.replace("CITY",city).replace("API_KEY",apiKey);
        String finalAPI = appCache.appCache.get(AppCache.keys.WEATHER_KEY.toString()).replace(PlaceHolders.CITY,city).replace(PlaceHolders.API_KEY,apiKey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        //For Json to POJO
        WeatherResponse body = response.getBody();
        return body;

    }


}
