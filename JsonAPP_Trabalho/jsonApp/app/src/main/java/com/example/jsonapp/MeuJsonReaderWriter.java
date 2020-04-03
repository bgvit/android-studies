package com.example.jsonapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class MeuJsonReaderWriter {

    private String nome, telefone;
    private String json;

    public MeuJsonReaderWriter(String json){
        this.json = json;
    }

    public MeuJsonReaderWriter(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String createJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(new Agenda(nome, telefone));
    }

    public Agenda readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return (Agenda) objectMapper.readValue(json, Agenda.class);
    }
}
