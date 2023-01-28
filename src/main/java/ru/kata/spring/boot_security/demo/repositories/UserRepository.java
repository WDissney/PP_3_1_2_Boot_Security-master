package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    User findUserByUserName(String name);

}
