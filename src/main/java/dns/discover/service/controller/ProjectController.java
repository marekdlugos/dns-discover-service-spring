package dns.discover.service.controller;

import dns.discover.service.entity.Project;
import dns.discover.service.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/projects")
    public Iterable<Project> getProjects(){
        return projectRepository.findAll();
    }

}
