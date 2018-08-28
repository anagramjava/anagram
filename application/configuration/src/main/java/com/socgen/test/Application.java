package com.socgen.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.socgen.test.configuration")
public class Application  {

//    @Autowired
//    private FindAnagrams findAnagrams;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    //access command line arguments
//    @Override
//    public void run(String... args)  {
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("Press Enter to word");
//
//        String enteredWord = input.nextLine().trim();
//
//        findAnagrams.findAnagrams(enteredWord).forEach(System.out::println);
//    }
}
