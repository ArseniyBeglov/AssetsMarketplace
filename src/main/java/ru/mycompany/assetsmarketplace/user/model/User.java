package ru.mycompany.assetsmarketplace.user.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(max = 255)
    @Column(name = "nickname")
    private String nickname;


    @Column(name = "email", unique = true)
    String email;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Size(max = 10)
    @Column(name = "sex")
    private String sex;

    @Column(name = "about")
    private String about;

    @Column(name = "is_seller")
    private boolean isSeller;

    @Size(max = 255)
    @Column(name = "surname")
    private String surname;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @Size(max = 255)
    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Size(max = 255)
    @Column(name = "confirm_token")
    private String confirmToken;

    @Size(max = 255)
    @Column(name = "language")
    private String language;

    @Column(name = "is_mailling")
    private boolean isMailing;

    @Size(max = 255)
    @Column(name = "password")
    private String password;
}
