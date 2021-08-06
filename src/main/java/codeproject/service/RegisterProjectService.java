package codeproject.service;

import codeproject.model.RegistrationProject;
import codeproject.repository.RegisterProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegisterProjectService {

    @Autowired
    private RegisterProjectRepo registerProjectRepo;

    public List<RegistrationProject> getAllRegistration() {
        return registerProjectRepo.findAll();
    }

    public RegistrationProject userRegister(RegistrationProject register) {
        return registerProjectRepo.save(register);
    }
}
