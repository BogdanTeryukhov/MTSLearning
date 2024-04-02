package org.mts.lab2.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public ObjectMapper mapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }
}
