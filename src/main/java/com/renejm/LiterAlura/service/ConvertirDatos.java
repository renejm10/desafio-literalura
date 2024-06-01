package com.renejm.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConvertirDatos implements IConvertirDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try{
            return  objectMapper.readValue(json,clase);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

}
