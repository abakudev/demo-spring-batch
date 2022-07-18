package com.example.demo.springbatch.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type Object converter.
 */
@UtilityClass
public class ObjectConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectConverter.class);

    /**
     * Convert to json string.
     *
     * @param object the object
     * @return the string
     */
    public static String convertToJson(Object object) {
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();
            json = mapper.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.info("Error en deserializacion de Object a Json: {}", e.getMessage());
        }
        return json;
    }

}