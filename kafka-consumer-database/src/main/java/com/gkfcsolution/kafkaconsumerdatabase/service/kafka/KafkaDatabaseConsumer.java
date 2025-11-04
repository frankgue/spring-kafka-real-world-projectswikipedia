package com.gkfcsolution.kafkaconsumerdatabase.service.kafka;

import com.gkfcsolution.kafkaconsumerdatabase.entity.WikimediaData;
import com.gkfcsolution.kafkaconsumerdatabase.repository.WikimediaDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created on 2025 at 23:42
 * File: null.java
 * Project: spring-kafka-real-world-projectswikipedia
 *
 * @author Frank GUEKENG
 * @date 04/11/2025
 * @time 23:42
 */
@Service
@Slf4j
public class KafkaDatabaseConsumer {

    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){
        log.info(String.format("EVENT Message received => %s", eventMessage));

        WikimediaData wikimediaData = WikimediaData.builder()
                .wikiEventData(eventMessage)
                .build();

        dataRepository.save(wikimediaData);
    }
}
