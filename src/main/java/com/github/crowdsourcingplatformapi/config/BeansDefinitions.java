package com.github.crowdsourcingplatformapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeansDefinitions {
   /* @Bean
    public Map<String, String> getDescription() {
        Map<String, String> description = new HashMap();
        description.put("Overview", null);
        description.put("Requirements", null);
        description.put("Detailed Description", null);
        return description;
    }*/

   @Bean
   public ModelMapper getModelMapper(){
       return new ModelMapper();
   }
}
