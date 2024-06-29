package com.francisco.cieloscopioChallenge.modelo;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("main")
    private Main main;

    @SerializedName("rain")
    private Rain rain;

    @SerializedName("wind")
    private Wind wind;

    public Main getMain() {
        return main;
    }

    public Rain getRain() {
        return rain;
    }

    public Wind getWind() {
        return wind;
    }
}
