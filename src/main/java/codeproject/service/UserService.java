package codeproject.service;

import codeproject.model.RegistrationProject;
import codeproject.model.User;
import codeproject.model.exception.ResourceNotFoundException;
import codeproject.repository.RegisterProjectRepo;
import codeproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegisterProjectRepo registerProjectRepo;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User is not exist with id: " + id));
    }

    public RegistrationProject registerProject(RegistrationProject registrationProject) {
        return registerProjectRepo.save(registrationProject);
    }
}
