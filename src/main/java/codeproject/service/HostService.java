package codeproject.service;

import codeproject.model.Host;
import codeproject.model.Project;
import codeproject.model.exception.ResourceNotFoundException;
import codeproject.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    @Autowired
    private ProjectService projectService;

    public Host getHost(Long id) {
        return hostRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Host is not exist with id: " + id));
    }

//    public List<Host> getAllHost() {
//        return hostRepository.findAll();
//    }

    public List<Host> getAllHost() {
        return StreamSupport
                .stream(hostRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Host addHost(Host host) {
        return hostRepository.save(host);
    }

//    @Transactional
//    public Host addProjectToHost(Long hostId, Long projectId) {
//        Host host = getHost(hostId);
//        Project project = projectService.getProject(projectId);
//
//        host.addProject(project);
//        project.setHost(host);
//        return host;
//    }
}
