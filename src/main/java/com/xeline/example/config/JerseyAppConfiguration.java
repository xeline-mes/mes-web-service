
package com.xeline.example.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author XenRon
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig {
    
    public JerseyAppConfiguration() {
         packages("com.xeline.example");
    }
}
