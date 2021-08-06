package codeproject.controller;

import javax.imageio.spi.RegisterableService;
import javax.validation.Valid;

import codeproject.model.ChatMessage;
import codeproject.model.RegistrationProject;
import codeproject.model.User;
import codeproject.model.exception.ResourceNotFoundException;
import codeproject.repository.UserRepository;
import codeproject.request.UpdatePassword;
import codeproject.request.UpdateProfile;
import codeproject.response.JwtResponse;
import codeproject.response.MessageResponse;
import codeproject.service.RegisterProjectService;
import codeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/test")
public class UserController {
	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;
	
	@Autowired
    private SimpMessageSendingOperations messagingTemplate;

	@Autowired
	private RegisterProjectService registerProjectService;
	
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> showUpdate(@PathVariable("id") long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		return ResponseEntity.ok(new JwtResponse(user.getName(), user.getUsername(),
												user.getEmail(), user.getPhone(), 
												user.getDate(), user.getAddress(), 
												user.getAvatar(),user.getRole(),
												user.getGender()));
	}
	
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id,@Valid @RequestBody UpdateProfile update) {
		
		User oldUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		if (userRepository.existsByEmail(update.getEmail()) && !oldUser.getEmail().equals(update.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Email này đã được dùng!"));
		}
	    oldUser.setName(update.getName());
	    oldUser.setEmail(update.getEmail());
	    oldUser.setPhone(update.getPhone());
	    oldUser.setDate(update.getDate());
	    oldUser.setAddress(update.getAddress());
	    oldUser.setAvatar(update.getAvatar());
	    userRepository.save(oldUser);
		return ResponseEntity.ok("thanh cong");
	}
	
	@PostMapping("/password/{id}")
	public ResponseEntity<?> updatePassword(@PathVariable("id") long id,@Valid @RequestBody UpdatePassword update) {
		
		
		User oldUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		if(update.getNewPassword().equals(update.getOldPassword())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Mật khẩu mới và cũ không được trùng!"));	
			
		}
	
		
		if(!encoder.matches( update.getOldPassword(),oldUser.getPassword())) {
			
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Mật khẩu hiện tại không đúng!"));	
			
		}
		else {
			 oldUser.setPassword( encoder.encode(update.getNewPassword()));
			 userRepository.save(oldUser);
		}
	   
		return ResponseEntity.ok(new MessageResponse("Cập nhập mật khẩu thành công!"));
	}
	@GetMapping("/user")
	public String userAccess() {
		return "User Content.";
	}

//	@GetMapping("/users")
//	public ResponseEntity<List<User>> getAllUser() {
//		List<User> user = userRepository.findAll();
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}

//	@GetMapping("/users/{id}")
//	public ResponseEntity<User> getUserId(@PathVariable("id") Long id) {
//		User user = userRepository.findById(id).orElseThrow(() ->
//				new ResourceNotFoundException("User is not exist with id: " + id));
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserId(@PathVariable Long id) {
		User user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = userService.getAllUser();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/admin")
	public String adminAccess() {
		return "Admin Board.";
	}

	@PostMapping("/userRegister")
	public ResponseEntity<RegistrationProject> register(@RequestBody RegistrationProject registrationProject) {
		String name = registrationProject.getUser().getName();
    	ChatMessage chatMessage = new ChatMessage();
    	chatMessage.setSender(name);
    	chatMessage.setType(ChatMessage.MessageType.JOIN);
    	messagingTemplate.convertAndSend("/topic/" + registrationProject.getProject().getEventName(), chatMessage);
		return new ResponseEntity<>(userService.registerProject(registrationProject), HttpStatus.OK);
	}
}