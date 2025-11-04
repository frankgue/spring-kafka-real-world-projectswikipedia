package com.gkfcsolution.kafkaconsumerdatabase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2025 at 00:00
 * File: null.java
 * Project: spring-kafka-real-world-projectswikipedia
 *
 * @author Frank GUEKENG
 * @date 05/11/2025
 * @time 00:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "wikimedia_recentchange")
public class WikimediaData extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;
}
