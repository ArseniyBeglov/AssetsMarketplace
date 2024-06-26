package ru.mycompany.assetsmarketplace.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mycompany.assetsmarketplace.user.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
