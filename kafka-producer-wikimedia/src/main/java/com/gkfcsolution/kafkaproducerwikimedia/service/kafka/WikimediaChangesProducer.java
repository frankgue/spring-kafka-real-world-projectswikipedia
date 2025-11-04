package com.gkfcsolution.kafkaproducerwikimedia.service.kafka;

import com.gkfcsolution.kafkaproducerwikimedia.event.WikimediaChangesHandler;
import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2025 at 19:59
 * File: null.java
 * Project: spring-kafka-real-world-projectswikipedia
 *
 * @author Frank GUEKENG
 * @date 04/11/2025
 * @time 19:59
 */
@Service
@Slf4j
public class WikimediaChangesProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topic.name}")
    private String topicName;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        Headers headers = new Headers.Builder()
                .add("User-Agent", "GKFC-WikiKafkaBot/1.0 (https://gkfcsolutions.com)")
                .add("Accept", "text/event-stream")
                .build();

        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url))
                .headers(headers);
        EventSource eventSource = builder.build();
        eventSource.start();

        TimeUnit.MINUTES.sleep(10);
    }
}
