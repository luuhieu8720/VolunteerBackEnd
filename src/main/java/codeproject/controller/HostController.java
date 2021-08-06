package codeproject.controller;

import codeproject.model.Host;
import codeproject.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/")
public class HostController {

    @Autowired
    private HostService hostService;

    @GetMapping("/hosts")
    public ResponseEntity<List<Host>> getAllHost(){
        List<Host> hosts = hostService.getAllHost();
        return new ResponseEntity<>(hosts, HttpStatus.OK);
    }

    @GetMapping("/hosts/{id}")
    public ResponseEntity<Host> getHost(@PathVariable Long id) {
        Host host = hostService.getHost(id);
        return new ResponseEntity<>(host, HttpStatus.OK);
    }

    @PostMapping("/host")
    public ResponseEntity<Host> addHost(@RequestBody Host host) {
        return new ResponseEntity<>(hostService.addHost(host), HttpStatus.OK);
    }

//    @PostMapping("/{hostId}/events/{projectId}/add")
//    public ResponseEntity<Host> addProject(@PathVariable Long hostId, @PathVariable Long projectId) {
//        Host host = hostService.addProjectToHost(hostId, projectId);
//        return new ResponseEntity<>(host, HttpStatus.OK);
//    }
}
