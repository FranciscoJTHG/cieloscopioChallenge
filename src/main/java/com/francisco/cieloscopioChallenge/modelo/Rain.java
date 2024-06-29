package com.francisco.cieloscopioChallenge.modelo;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("1h")
    private double h;

    public double getH() {
        return h;
    }

    @Override
    public String toString() {
        return "Rain: " + "h= " + h;
    }
}
