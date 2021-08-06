package codeproject.controller;

import codeproject.model.ChatMessage;
import codeproject.model.Project;
import codeproject.model.User;
import codeproject.repository.UserRepository;
import codeproject.service.ProjectService;
import codeproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/test")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    
    @Autowired
	UserRepository userRepository;
    
    @Autowired
	UserService userService;

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project = projectService.getProject(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
	
    @GetMapping("/search")
    public ResponseEntity<List<Project>> getByName(@RequestParam String eventName) {
        return new ResponseEntity<>(projectService.getByName(eventName), HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@RequestBody Project projectUpdate, @PathVariable Long id) {
        Project project = projectService.getProject(id);
        projectService.addProject(project);

        project.setEventName(projectUpdate.getEventName());
        return new ResponseEntity<>(projectService.addProject(project), HttpStatus.OK);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deletePorject(id);
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
    	long id = project.getHost().getHotsId();
    	User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
    	ChatMessage chatMessage = new ChatMessage();
    	chatMessage.setSender(user.getName());
    	chatMessage.setType(ChatMessage.MessageType.JOIN);
    	messagingTemplate.convertAndSend("/topic/" + project.getEventName(), chatMessage);
        return new ResponseEntity<>(projectService.addProject(project), HttpStatus.OK);
    }
}
