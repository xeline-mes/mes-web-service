
package com.xeline.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.xeline.example.service.HeaderService;
import com.xeline.example.service.impl.PowerbyHeaderServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author XenRon
 */
@Component
@Configuration
@ComponentScan(basePackages = {
    "com.xeline.example.service",
    "com.xeline.example.resource"
})
public class SpringAppConfiguration {
    
    @Configuration
    //@Profile("production")
    static class HeaderServiceConfiguration {
        
        @Bean
        public HeaderService headerService() {
            return new PowerbyHeaderServiceImpl();
        }
    }
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
    
}
