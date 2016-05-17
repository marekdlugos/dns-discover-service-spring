package sit.fel.cvut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.fel.cvut.entity.Project;
import sit.fel.cvut.repository.ProjectRepository;

@RestController
public class ProjectController {

//    @Autowired
//    ProjectRepository projectRepository;

    @RequestMapping(value = "/projects")
    public Iterable<Project> getProjects(){
//        return projectRepository.findAll();
        return null;
    }

}
