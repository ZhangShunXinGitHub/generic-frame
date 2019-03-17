package com.generic.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {
    private static final ObjectMapper MAPPER=new ObjectMapper();
    public static String objectToJson(Object object){
        try {
            String value=MAPPER.writeValueAsString(object);
            return value;
        } catch (JsonProcessingException e) {
            log.error("Exception: ",e);
        }
        return null;
    }
}
