package com.francisco.cieloscopioChallenge.modelo;

import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("speed")
    private double velocidad;
    @SerializedName("deg")
    private int grados;
    @SerializedName("gust")
    private double rafaga;

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getGrados() {
        return grados;
    }

    public void setGrados(int grados) {
        this.grados = grados;
    }

    public double getRafaga() {
        return rafaga;
    }

    public void setRafaga(double rafaga) {
        this.rafaga = rafaga;
    }

    @Override
    public String toString() {
        return "Wind: " +
                "velocidad=" + velocidad +
                ", grados=" + grados +
                ", rafaga=" + rafaga;
    }
}
