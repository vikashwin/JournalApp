package com.engineeringdigest.journalApp.api.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {

        private Location location;
        private Current current;

    @Getter
    @Setter
    public class Current{

        private int temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        @JsonProperty("wind_speed")
        private int windSpeed;
        private int pressure;
        private int humidity;

    }

    @Getter
    @Setter
    public class Location{
        private String name;
        private String country;
        private String region;
        private String lat;
        private String lon;

    }



}
