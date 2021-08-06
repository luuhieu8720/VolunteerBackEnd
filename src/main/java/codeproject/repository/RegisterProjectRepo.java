package codeproject.repository;

import codeproject.model.RegistrationProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterProjectRepo extends JpaRepository<RegistrationProject, Long> {
}
