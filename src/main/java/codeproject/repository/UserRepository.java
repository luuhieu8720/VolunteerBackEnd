package codeproject.repository;

import codeproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndActive(String username, boolean active);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
