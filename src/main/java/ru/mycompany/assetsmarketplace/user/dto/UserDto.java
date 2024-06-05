package ru.mycompany.assetsmarketplace.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String password;
    @Email
    private String email;
    private String nickname;
    private Date birthday;
    private String sex;
    private String about;
    private Boolean isSeller;
    private String surname;
    private String name;
    private String patronymic;
    private Boolean isConfirmed;
    private String confirmToken;
    private String language;
    private Boolean isMailing;
    private Boolean isActive;
}
