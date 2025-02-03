package org.example.jobportal.mappers;

import org.example.jobportal.entities.User;
import org.example.jobportal.models.UserDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto user);

    default Page<UserDto> mapUserPageToDto(Page<User> userPage) {
        return userPage.map(this::userToUserDto);
    }
}
