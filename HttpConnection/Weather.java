package com.example.cs_ch.secondapp;

import java.util.HashMap;

/**
 * Created by cs_ch on 10/22/2016.
 */
public class Weather {
    private String cityName;
    private double currentTemp;
    private double minTemp;
    private double maxTemp;
    private double windSpeed;
    private double windDegree;

    public Weather(HashMap<String, ?> weatherHashMap) { //class string
        HashMap<String, ?> Maininfo = (HashMap<String, ?>) weatherHashMap.get("main");
        HashMap<String, ?> Windinfo = (HashMap<String, ?>) weatherHashMap.get("wind");
        this.cityName = (String)weatherHashMap.get("name"); //calling from website
        this.currentTemp = (Double)Maininfo.get("temp");
        this.minTemp = (Double)Maininfo.get("temp_min");
        this.maxTemp = (Double)Maininfo.get("temp_max");
        this.windSpeed = (Double)Windinfo.get("speed");
        this.windDegree = (Double)Windinfo.get("deg");
    }

    public String getCityName() {
        return this.cityName;
    }

    public double getCurrentTemp() {
        return this.currentTemp;
    }

    public double getMinTemp() {
        return this.minTemp;
    }

    public double getMaxTemp() {
        return this.maxTemp;
    }
    public double getWindSpeed() {
        return this.windSpeed;
    }
    public double getWindDegree() {
        return this.windDegree;
    }

}
