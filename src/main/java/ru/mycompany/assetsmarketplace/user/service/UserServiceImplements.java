package ru.mycompany.assetsmarketplace.user.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mycompany.assetsmarketplace.exceptions.NotFoundException;
import ru.mycompany.assetsmarketplace.exceptions.ValidateException;
import ru.mycompany.assetsmarketplace.user.dto.UserDto;
import ru.mycompany.assetsmarketplace.user.dto.UserMapper;
import ru.mycompany.assetsmarketplace.user.dto.UserMapperImplements;
import ru.mycompany.assetsmarketplace.user.model.User;
import ru.mycompany.assetsmarketplace.user.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImplements implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper = new UserMapperImplements();

    @Override
    public List<UserDto> getAll() {
        log.debug("Request GET to /users");
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getById(long id) {
        log.debug("Request GET to /users/{}",id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id = " + id + " is not found"));
        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        log.debug("Request POST to /users");
        validate(userDto);
        return userMapper.toDto(userRepository.save(userMapper.fromDto(userDto)));

    }

    @Transactional
    @Override
    public UserDto update(long id, UserDto userDto) {
        log.debug("Request PATCH to /users, with id = {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("User with id = " + id + " not found"));
        copyProperties(userDto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        log.debug("Request DELETE to /users/{}", id);
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        log.debug("Request DELETE to /users)");
        userRepository.deleteAll();
    }

    private void validate(UserDto userDto) {
        if (userDto.getEmail() == null)
            throw new ValidateException("Email cannot be empty.");
        if (userDto.getEmail().isBlank() || !userDto.getEmail().contains("@"))
            throw new ValidateException("Incorrect email: " + userDto.getEmail() + ".");
    }

    private void copyProperties(UserDto userDto, User user) {
        if (userDto.getEmail() != null) {
            user.setEmail(userDto.getEmail());
        }
        if (userDto.getNickname() != null) {
            user.setNickname(userDto.getNickname());
        }
        if (userDto.getBirthday() != null) {
            user.setBirthday(userDto.getBirthday());
        }
        if (userDto.getSex() != null) {
            user.setSex(userDto.getSex());
        }
        if (userDto.getAbout() != null) {
            user.setAbout(userDto.getAbout());
        }
        if (userDto.getIsSeller() != user.getIsSeller()) {
            user.setIsSeller(userDto.getIsSeller());
        }
        if (userDto.getSurname() != null) {
            user.setSurname(userDto.getSurname());
        }
        if (userDto.getName() != null) {
            user.setName(userDto.getName());
        }
        if (userDto.getPatronymic() != null) {
            user.setPatronymic(userDto.getPatronymic());
        }
        if (userDto.getIsConfirmed() != user.getIsConfirmed()) {
            user.setIsConfirmed(userDto.getIsConfirmed());
        }
        if (userDto.getConfirmToken() != null) {
            user.setConfirmToken(userDto.getConfirmToken());
        }
        if (userDto.getLanguage() != null) {
            user.setLanguage(userDto.getLanguage());
        }
        if (userDto.getIsMailing() != user.getIsMailing()) {
            user.setIsMailing(userDto.getIsMailing());
        }
        if (userDto.getPassword() != null) {
            user.setPassword(userDto.getPassword());
        }
    }

}