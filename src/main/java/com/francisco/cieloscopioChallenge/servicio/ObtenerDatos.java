package com.francisco.cieloscopioChallenge.servicio;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class ObtenerDatos<T> {

    private static final Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    // Método genérico para convertir JSON a un objeto de tipo T
    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    // Método genérico para convertir JSON a una lista de objetos de tipo T
    public <T> List<T> fromJsonToList(String json, Class<T> classOfT) {
        Type listType = TypeToken.getParameterized(List.class, classOfT).getType();
        return gson.fromJson(json, listType);
    }

    // Método genérico para convertir un objeto a JSON
    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    // Método genérico para convertir un JSON y parsearlo a objeto de tipo T
    public <T> T fromToJsonParse(String json, Class<T> classOfT) {

         JsonParser jsonParser = new JsonParser();

         JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
         // JsonObject getObject = jsonObject.getAsJsonObject(etiqueta);

        return gson.fromJson(json, classOfT);
    }
}
