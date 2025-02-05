package com.javaconcepts.contentcalendar.repository;

import com.javaconcepts.contentcalendar.model.Content;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentCollectionRepository {
    private final List<Content> content = new ArrayList<>();
    public ContentCollectionRepository(){}
    public List<Content> findAll(){
        return content;
    }
}
