
package com.xeline.example.test;

import com.xeline.example.config.JerseyAppConfiguration;
import com.xeline.example.config.SpringAppConfiguration;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author PaulSamsotha
 */
public class GreetingResourceIntegrationTest extends JerseyTest {
    
    @Override
    public Application configure() {
        JerseyAppConfiguration config = new JerseyAppConfiguration();
        AnnotationConfigApplicationContext context 
                = new AnnotationConfigApplicationContext(SpringAppConfiguration.class);
        context.getEnvironment().setActiveProfiles("production");
        config.property("contextConfig", context);
        return config;
    }
    
    @Test
    public void testGetGreeting() {
        Response response = target("greeting")
                .queryParam("name", "peeskillet")
                .request().get();
        
        Assert.assertEquals("Underdog", response.getHeaderString("X-Powered-By"));
        String message = response.readEntity(String.class);
        Assert.assertEquals("Bonjour, peeskillet!", message);
        System.out.println(message);
        
        response.close();
    }
}
