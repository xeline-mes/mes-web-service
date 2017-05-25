
package com.xeline.example.test;

import com.xeline.example.config.SpringAppConfiguration;
import com.xeline.example.service.GreetingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author XenRon
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringAppConfiguration.class})
public class GreetingServiceUnitTest {
    
    @Autowired
    private GreetingService greetingService;
    
    @Test
    public void testEnglishGreeting() {
        String greeting = greetingService.getGreeting("tom");
        Assert.assertEquals("Hello, tom!", greeting);
    }
}
