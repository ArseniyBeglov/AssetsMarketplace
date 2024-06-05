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
                user.getIsSeller(),
                user.getSurname(),
                user.getName(),
                user.getPatronymic(),
                user.getIsConfirmed(),
                user.getConfirmToken(),
                user.getLanguage(),
                user.getIsMailing(),
                user.getIsActive()
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
                userDto.getIsSeller(),
                userDto.getSurname(),
                userDto.getName(),
                userDto.getPatronymic(),
                userDto.getIsConfirmed(),
                userDto.getConfirmToken(),
                userDto.getLanguage(),
                userDto.getIsMailing(),
                userDto.getPassword(),
                userDto.getIsActive()
        );
    }
}
