package com.francisco.cieloscopioChallenge.servicio;

import com.francisco.cieloscopioChallenge.modelo.WeatherData;

import java.util.Scanner;

public class Utilidades {

    Scanner teclado = new Scanner(System.in);

    public String construirUrl(String urlCoordenadas, double lat, double lon, String apiKey, String leng) {
        String url = urlCoordenadas + "lat=" + lat + "&lon=" + lon + apiKey + leng;
        return url;
    }

    public String obtenerCiudad(int opcion){
        switch (opcion) {
            case 1: return "Caracas";
            case 2: return "Monterrey";
            case 3: return "Bogota";
            case 4: return "London";
            case 5: return "Lima";
            case 6:
                System.out.print("Ingrese el nombre de la ciudad: ");
                return teclado.nextLine();
            case 8: return "salir";
            default: throw new IllegalArgumentException("Opción inválida");
        }
    }

    public void imprimirMenu() {
        System.out.println("********** CIELOSCOPIO **********");
        System.out.println("1) - Caracas - (VE)");
        System.out.println("2) - Monterrey - (MX)");
        System.out.println("3) - Bogota - (CO)");
        System.out.println("4) - London - (GB)");
        System.out.println("5) - Lima - (PE)");
        System.out.println("6) - Otra Ciudad");
        System.out.println("8) - Salir");
        System.out.print("Ingrese una opción: \n");
        System.out.println("**********************************\n");
    }

    public void imprimirResultado(WeatherData datosClima, String ciudadCountry) {
        System.out.println("Ciudad: " + ciudadCountry);
        System.out.println("temperatura: " + convertirCelsius(datosClima.getMain().getTemperatura()));
        System.out.println("sensacion: " + convertirCelsius(datosClima.getMain().getSensacion()));
        System.out.println("temperaturaMin: " + convertirCelsius(datosClima.getMain().getTemperaturaMin()));
        System.out.println("temperaturaMax: " + convertirCelsius(datosClima.getMain().getTemperaturaMax()));
        System.out.println("presion: " + datosClima.getMain().getPresion());
        System.out.println("humedad: " + datosClima.getMain().getHumedad());
        System.out.println("Velocidad Viento: " + convertirVelocidad(datosClima.getWind().getVelocidad()));
        System.out.println("Rafaga viento: " + convertirVelocidad(datosClima.getWind().getRafaga()));
        System.out.println("\n");
    }

    public String convertirCelsius(double temp) {
        return String.format("%.2f",temp - 273.15) + " °C";
    }

    public String convertirVelocidad(double vel) {
        return String.format("%.2f",vel * 3.6) + " Km/H";
    }
}
