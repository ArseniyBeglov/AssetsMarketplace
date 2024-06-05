package ru.mycompany.assetsmarketplace.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mycompany.assetsmarketplace.user.enums.Role;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


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

    @Column(name = "nickname")
    private String nickname;


    @Column(name = "email", unique = true)
    String email;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "sex")
    private String sex;

    @Column(name = "about")
    private String about;

    @Column(name = "is_seller")
    private Boolean isSeller;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "is_confirmed")
    private Boolean isConfirmed;

    @Column(name = "confirm_token")
    private String confirmToken;

    @Column(name = "language")
    private String language;

    @Column(name = "is_mailling")
    private Boolean isMailing;

    @Column(name = "password", length = 1000)
    private String password;

    @Column(name="is_active")
    private Boolean isActive;

//    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "user_role",
//    joinColumns = @JoinColumn(name = "user_id"))
//    @Enumerated(EnumType.STRING)
//    private Set<Role> roles = new HashSet<>();
}
