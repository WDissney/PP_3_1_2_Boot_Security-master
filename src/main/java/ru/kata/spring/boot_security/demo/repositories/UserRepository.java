package ru.kata.spring.boot_security.demo.repositories;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.kata.spring.boot_security.demo.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "User.roles")
    User findUserByUserName(String name);
    User getUserById(Long id);

}
