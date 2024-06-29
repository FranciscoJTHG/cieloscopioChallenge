package com.francisco.cieloscopioChallenge.principal;

import com.francisco.cieloscopioChallenge.modelo.Ciudad;
import com.francisco.cieloscopioChallenge.modelo.WeatherData;
import com.francisco.cieloscopioChallenge.servicio.ConsumirAPI;
import com.francisco.cieloscopioChallenge.servicio.ObtenerDatos;
import com.francisco.cieloscopioChallenge.servicio.Utilidades;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, String> variables = System.getenv();
        String valueApiKey = variables.get("API_KEY");
        final String URL_CIUDAD = "https://api.openweathermap.org/geo/1.0/direct?q=";
        final String API_KEY = "&appid="+valueApiKey;
        final String URL_COORDENADAS = "https://api.openweathermap.org/data/2.5/weather?";
        Scanner teclado = new Scanner(System.in);
        ConsumirAPI consumirAPI = new ConsumirAPI();
        ObtenerDatos obtenerDatos = new ObtenerDatos();
        Utilidades utilidades = new Utilidades();
        String direccion;
        String Lenguaje = "&lang=es";
        String json;
        String busqueda = null;

        do {
            utilidades.imprimirMenu();

            busqueda = utilidades.obtenerCiudad(teclado.nextInt());

            if (!busqueda.equals("salir")) {

                // Armar URL
                direccion = URL_CIUDAD + busqueda + API_KEY;

                // Llamar al método ConsumirAPI
                json = consumirAPI.obtenerDatos(direccion);

                // Llamar al método ObtenerDatos
                List<Ciudad> ciudades = obtenerDatos.fromJsonToList(json, Ciudad.class);

                Optional<Ciudad> ciudadEncontrada = ciudades.stream().findFirst();

                if (ciudadEncontrada.isPresent()) {

                    String ciudadCountry = ciudadEncontrada.get().getName() + " - " + ciudadEncontrada.get().getCountry();

                    // Llamar al método ConstruirURL
                    direccion = utilidades.construirUrl(URL_COORDENADAS, ciudadEncontrada.get().getLatitud(), ciudadEncontrada.get().getLongitud(), API_KEY, Lenguaje);
                    json = consumirAPI.obtenerDatos(direccion);

                    WeatherData climaDatos = (WeatherData) obtenerDatos.fromJson(json, WeatherData.class);

                    utilidades.imprimirResultado(climaDatos, ciudadCountry);
                } else {
                    throw new IllegalArgumentException("Ciudad no encontrada: " + busqueda);
                }
            }
        } while (!busqueda.equals("salir"));

        System.out.println("Saliendo del programa...");
        teclado.close();

    }
}
