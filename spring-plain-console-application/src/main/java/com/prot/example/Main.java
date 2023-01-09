package com.prot.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
    }
}