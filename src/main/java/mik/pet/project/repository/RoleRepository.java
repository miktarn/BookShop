package mik.pet.project.repository;

import java.util.Optional;
import mik.pet.project.model.Role;
import mik.pet.project.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
