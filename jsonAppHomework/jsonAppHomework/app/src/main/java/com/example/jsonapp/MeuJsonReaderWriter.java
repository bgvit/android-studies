package com.example.jsonapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MeuJsonReaderWriter {

    private GeoJson geoJson;
    private String json;

    public MeuJsonReaderWriter(String json){
        this.json = json;
    }

    public MeuJsonReaderWriter(GeoJson geoJson) {
        this.geoJson = geoJson;
    }

    public String createJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(new GeoJson());
    }

    public GeoJson readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (GeoJson) objectMapper.readValue(json, GeoJson.class);
    }
}
