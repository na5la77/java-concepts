package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.User;
import org.example.jobportal.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}

