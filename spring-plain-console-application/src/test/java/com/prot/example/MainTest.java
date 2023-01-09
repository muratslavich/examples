package com.prot.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(JavaConfiguration.class)
class MainTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void contextStarted() {
        Thing bean = applicationContext.getBean(Thing.class);
        assertNotNull(bean);
    }

}