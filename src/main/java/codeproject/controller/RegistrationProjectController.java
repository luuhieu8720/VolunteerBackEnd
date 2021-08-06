package codeproject.controller;

import codeproject.model.RegistrationProject;
import codeproject.service.RegisterProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
public class RegistrationProjectController {

    @Autowired
    private RegisterProjectService registerProjectService;

    @GetMapping("/registrations")
    public ResponseEntity<List<RegistrationProject>> getAll() {
        return new ResponseEntity<>(registerProjectService.getAllRegistration(), HttpStatus.OK);
    }

}