package ru.mycompany.assetsmarketplace.user.service;

import ru.mycompany.assetsmarketplace.user.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAll();

    UserDto getById(long id);

    UserDto create(UserDto userDto);

    UserDto update(long id, UserDto userDto);

    void deleteById(long id);

    void deleteAll();
}
