package com.epam.lab3.modelsWeb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;

public class JSONCreator<E> {

    private Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public E unmarshall(String json, Class<E> dataClass) {
        return GSON.fromJson(json, dataClass);
    }

    public String marshall(E obj) {
        return GSON.toJson(obj);
    }

    public String marshallList(Collection<E> collection) {
        return GSON.toJson(collection);
    }

}
