package com.prot.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
    @Bean
    public OtherThing otherThing() {
        return new OtherThing();
    }

    @Bean
    public Thing thing() {
        return new Thing(otherThing());
    }
}
