package mik.pet.project.repository;

import mik.pet.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByEmail(String email);
}
