package com.dmtool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class DmtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmtoolApplication.class, args);
    }
}
