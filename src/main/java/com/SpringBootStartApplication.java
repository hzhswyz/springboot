package com;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootStartApplication  {
    private static final Logger log = LoggerFactory.getLogger(SpringBootStartApplication.class);
    public static void main(String[] args) {
        log.info("Hello Start");
        //RequestMappingHandlerAdapter
        SpringApplication.run(SpringBootStartApplication.class, args);
    }

}
