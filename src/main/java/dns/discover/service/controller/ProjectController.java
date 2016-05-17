package dns.discover.service.controller;

import dns.discover.service.entity.Project;
import dns.discover.service.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/projects")
    public Iterable<Project> getProjects(){
        return projectService.getProjects();
    }

    @RequestMapping(value = "/projects/{projectId}")
    public Project getProject(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }

    @RequestMapping(value = "/projects", method = POST)
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @RequestMapping(value = "/projects/{projectId}", method = DELETE)
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

}
