package org.example.jobportal.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobportal.models.UserDto;
import org.example.jobportal.services.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public PagedModel<UserDto> getUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.createUser(user);
    }
}

