package codeproject.repository;

import codeproject.model.Project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select c from Project c where c.eventName like %?1%")
    List<Project> findByEventName(String eventName);
}