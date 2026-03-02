package com.example.habittracker.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Ici je configure Jackson pour bien gerer les dates (LocalDate, LocalDateTime, etc.)
@Configuration
public class JacksonConfig {

    // Je fournis mon ObjectMapper a Spring
    @Bean
    public ObjectMapper objectMapper() {

        // Je cree un mapper JSON
        ObjectMapper mapper = new ObjectMapper();

        // J'ajoute le module pour les dates Java 8+
        mapper.registerModule(new JavaTimeModule());

        // Je renvoie le mapper configure
        return mapper;
    }
}
