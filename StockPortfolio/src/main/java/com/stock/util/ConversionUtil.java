package com.stock.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversionUtil {

    
    public static String pojoToJSON(Object pojo) throws JsonGenerationException, JsonMappingException, IOException {
    
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writer().writeValueAsString(pojo);
            return json;
    
    }
    
}


