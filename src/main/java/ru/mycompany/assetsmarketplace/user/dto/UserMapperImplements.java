package ru.mycompany.assetsmarketplace.user.dto;

import org.springframework.stereotype.Component;
import ru.mycompany.assetsmarketplace.user.model.User;
@Component
public class UserMapperImplements implements UserMapper{
    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getPassword(),
                user.getEmail(),
                user.getNickname(),
                user.getBirthday(),
                user.getSex(),
                user.getAbout(),
                user.isSeller(),
                user.getSurname(),
                user.getName(),
                user.getPatronymic(),
                user.isConfirmed(),
                user.getConfirmToken(),
                user.getLanguage(),
                user.isMailing()
        );
    }

    @Override
    public User fromDto(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getNickname(),
                userDto.getEmail(),
                userDto.getBirthday(),
                userDto.getSex(),
                userDto.getAbout(),
                userDto.isSeller(),
                userDto.getSurname(),
                userDto.getName(),
                userDto.getPatronymic(),
                userDto.isConfirmed(),
                userDto.getConfirmToken(),
                userDto.getLanguage(),
                userDto.isMailing(),
                userDto.getPassword()
        );
    }
}
