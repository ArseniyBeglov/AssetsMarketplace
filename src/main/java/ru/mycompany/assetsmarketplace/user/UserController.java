package ru.mycompany.assetsmarketplace.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mycompany.assetsmarketplace.user.dto.UserDto;
import ru.mycompany.assetsmarketplace.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserDto create(@Valid  @RequestBody UserDto userDto) {
        return userService.create(userDto);
    }

    @PatchMapping("/{id}")
    public UserDto patch(@PathVariable long id, @RequestBody UserDto userDto) {
        return userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        userService.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }
}
