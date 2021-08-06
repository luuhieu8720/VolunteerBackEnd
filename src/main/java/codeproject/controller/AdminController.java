package codeproject.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import codeproject.model.User;
import codeproject.repository.UserRepository;
import codeproject.request.ActionRequet;
import codeproject.response.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> showAllUser() {
		List<User> result = (List<User>) userRepository.findAll();
		if(result.size() > 0)
    		return result;
    	else
    		return new ArrayList<User>();
	}
	@GetMapping("/edit/{id}")
	public ResponseEntity<?> showUpdate(@PathVariable("id") long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		return ResponseEntity.ok(new JwtResponse(user.getName(),user.getUsername(),
												user.getPhone(),user.getAddress(),
												user.getRole(),user.getActive()));
	}
	@PostMapping("/edit/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id,@Valid @RequestBody ActionRequet update) {
		
		User oldUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	    oldUser.setActive(update.isActive());
	    userRepository.save(oldUser);
		return ResponseEntity.ok("thanh cong");
	}

}
