//package org.example.jobportal.controllers;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.jobportal.entities.User;
//import org.example.jobportal.services.UserService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//@Slf4j
//@RequiredArgsConstructor
//public class JobApplicationController {
//    private final UserService userService;
//
//  @GetMapping
//    public List<User> getUsers() {
//        System.out.println("asdadda");
//        return userService.getAllUsers();
//    }
//
//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        user.setUsername("aaaa");
//        return userService.createUser(user);
//    }
//}
//
