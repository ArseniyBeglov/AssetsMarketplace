package ru.mycompany.assetsmarketplace.user.dto;

import ru.mycompany.assetsmarketplace.user.model.User;

public interface UserMapper {
    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
