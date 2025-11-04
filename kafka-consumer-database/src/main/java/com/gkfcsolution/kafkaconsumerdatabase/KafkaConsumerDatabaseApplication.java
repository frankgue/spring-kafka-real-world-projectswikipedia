package com.gkfcsolution.kafkaconsumerdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class KafkaConsumerDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerDatabaseApplication.class, args);
    }

}
