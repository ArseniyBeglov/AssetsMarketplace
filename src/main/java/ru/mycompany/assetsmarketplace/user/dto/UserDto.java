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

    @Size(max = 255)
    private String password;

    @Email
    private String email;

    @Size(max = 255)
    private String nickname;

    private Date birthday;

    @Size(max = 10)
    private String sex;

    private String about;

    private boolean isSeller;

    @Size(max = 255)
    private String surname;

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String patronymic;

    private boolean isConfirmed;

    @Size(max = 255)
    private String confirmToken;

    @Size(max = 255)
    private String language;

    private boolean isMailing;
}
