package org.javatx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MapperScan("org.javatx.mapper")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class,SecurityFilterAutoConfiguration.class})
@EnableJpaAuditing
public class JavatxApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavatxApplication.class, args);
    }

}
