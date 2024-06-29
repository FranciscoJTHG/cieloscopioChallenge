package com.francisco.cieloscopioChallenge.modelo;

import com.google.gson.annotations.SerializedName;

public class Ciudad {
    @SerializedName("name")
    private String name;
    @SerializedName("lat")
    private double latitud;
    @SerializedName("lon")
    private double longitud;
    @SerializedName("country")
    private String country;
    @SerializedName("state")
    private String state;

    public Ciudad() {
    }

    public Ciudad(String name, double latitud, double longitud, String country, String state) {
        this.name = name;
        this.latitud = latitud;
        this.longitud = longitud;
        this.country = country;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
