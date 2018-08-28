package com.socgen.test.configuration;

import com.socgen.test.entity.Dictionary;
import com.socgen.test.usecase.FindAnagrams;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {


    @Bean
    public FindAnagrams findAnagrams(Dictionary dictionary){
        return new FindAnagrams(dictionary);
    }

    @Bean(initMethod = "process")
    public Dictionary dictionary (){
        String fileName = "/Users/neelam/Downloads/words.txt";
        return new Dictionary(fileName);
    }
}
