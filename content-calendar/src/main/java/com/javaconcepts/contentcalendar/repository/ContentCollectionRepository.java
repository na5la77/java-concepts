//package com.javaconcepts.contentcalendar.repository;
//
//import com.javaconcepts.contentcalendar.model.Content;
//import com.javaconcepts.contentcalendar.model.Status;
//import com.javaconcepts.contentcalendar.model.Type;
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ContentCollectionRepository {
//    private final List<Content> contentList = new ArrayList<>();
//
//    public ContentCollectionRepository() {
//    }
//
//    public List<Content> findAll() {
//        return contentList;
//    }
//
//    public Optional<Content> findById(Integer id) {
//        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
//    }
//
//    public void save(Content c) {
//        contentList.removeIf(co->co.id().equals(c.id()));
//        contentList.add(c);
//    }
//    public boolean existsById(Integer id) {
//        return contentList.stream().anyMatch(c -> c.id().equals(id));
//    }
//
//    @PostConstruct
//    private void init() {
//        Content c = new Content(1,
//                "My First Blog",
//                "My first blogpost",
//                Status.IDEA,
//                Type.ARTICLE,
//                LocalDateTime.now(),
//                null,
//                "");
//        contentList.add(c);
//    }
//
//    public void delete(Integer id) {
//        contentList.removeIf(c -> c.id().equals(id));
//    }
//}
