package com.github.crowdsourcingplatformapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeansDefinations {
    @Bean
    public Map<String,String> getDescription(){
        Map<String,String> description = new HashMap();
        description.put("Overview",null); description.put("Requirements",null); description.put("Detailed Description",null);
        return description;
    }
}
