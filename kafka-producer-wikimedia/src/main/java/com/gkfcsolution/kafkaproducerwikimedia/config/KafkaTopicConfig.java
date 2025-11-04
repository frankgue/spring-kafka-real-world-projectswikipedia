package com.gkfcsolution.kafkaproducerwikimedia.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Created on 2025 at 19:57
 * File: null.java
 * Project: spring-kafka-real-world-projectswikipedia
 *
 * @author Frank GUEKENG
 * @date 04/11/2025
 * @time 19:57
 */
@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(topicName)
                .build();
    }

    public void sendMessage(){

    }
}
