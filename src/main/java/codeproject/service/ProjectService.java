package codeproject.service;

import codeproject.model.Project;
import codeproject.model.exception.ResourceNotFoundException;
import codeproject.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getProject(Long id) {
        return projectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Project is not exist with id: " + id));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
}
