
package com.xeline.example.service.impl;

import org.springframework.stereotype.Service;

import com.xeline.example.service.GreetingService;

/**
 *
 * @author XenRon
 */
@Service
public class EnglishGreetingServiceImpl implements GreetingService {

    @Override
    public String getGreeting(String name) {
        return "Hello, " + name + "!";
    }  
}
