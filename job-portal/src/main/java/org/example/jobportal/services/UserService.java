package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.User;
import org.example.jobportal.mappers.UserMapper;
import org.example.jobportal.models.UserDto;
import org.example.jobportal.repos.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public PagedModel<UserDto> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);

        Page<UserDto> userDtos = userMapper.mapUserPageToDto(users);

        return new PagedModel<>(userDtos);
    }

    public UserDto createUser(UserDto user) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(user)));
    }
}
