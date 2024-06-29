package com.francisco.cieloscopioChallenge.modelo;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private double temperatura;
    @SerializedName("feels_like")
    private double sensacion;
    @SerializedName("temp_min")
    private double temperaturaMin;
    @SerializedName("temp_max")
    private double temperaturaMax;
    @SerializedName("pressure")
    private int presion;
    @SerializedName("humidity")
    private int humedad;

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getSensacion() {
        return sensacion;
    }

    public void setSensacion(double sensacion) {
        this.sensacion = sensacion;
    }

    public double getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(double temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public double getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(double temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    @Override
    public String toString() {
        return "Clima: " +
                "temperatura=" + temperatura +
                ", sensacion=" + sensacion +
                ", temperaturaMin=" + temperaturaMin +
                ", temperaturaMax=" + temperaturaMax +
                ", presion=" + presion +
                ", humedad=" + humedad;
    }
}
