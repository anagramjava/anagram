package com.socgen.test.configuration;


import com.socgen.test.entity.Dictionary;
import com.socgen.test.rest.WordEndpoint;
import com.socgen.test.usecase.FindAnagrams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EntrypointConfiguration {

    @Bean
    public WordEndpoint dictionaryEndpoint(Dictionary  dictionary , FindAnagrams findAnagrams){
        return new WordEndpoint(dictionary,findAnagrams);
    }
}
