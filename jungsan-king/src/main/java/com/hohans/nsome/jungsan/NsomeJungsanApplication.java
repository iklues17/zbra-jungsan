package com.hohans.nsome.jungsan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hohans.nsome.web.SimpleCORSFilter;

@SpringBootApplication
public class NsomeJungsanApplication {

    public static void main(String[] args) {
        SpringApplication.run(NsomeJungsanApplication.class, args);
    }
    
    @Bean
    public SimpleCORSFilter simpleCORSFilter(){
    	return new SimpleCORSFilter();
    }
}
