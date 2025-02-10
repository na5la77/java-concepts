package com.javaconcepts.contentcalendar.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentJdbcTemplateRepository {
    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
    }


}
