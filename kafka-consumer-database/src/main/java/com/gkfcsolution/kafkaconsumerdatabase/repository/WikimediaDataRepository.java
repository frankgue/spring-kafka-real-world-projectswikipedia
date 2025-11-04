package com.gkfcsolution.kafkaconsumerdatabase.repository;

import com.gkfcsolution.kafkaconsumerdatabase.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2025 at 00:03
 * File: null.java
 * Project: spring-kafka-real-world-projectswikipedia
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 00:03
 */
public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
}
