package com.terria.sidedish;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class SideDishApplicationTest {

    @Test
    void contextLoads() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SideDishApplication.class);
        assertThat(ac).isNotNull();
    }
}