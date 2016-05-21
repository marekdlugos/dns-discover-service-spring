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

    /**
     * GET all Projects
     *
     * @return Return all projects
     */
    @RequestMapping(value = "/projects", method = GET)
    public Iterable<Project> getProjects(){
        return projectService.getProjects();
    }

    /**
     * GET specific Project details
     *
     * @param projectId Identification of Project you want to GET
     * @return          Return specific Project
     */
    @RequestMapping(value = "/projects/{projectId}", method = GET)
    public Project getProject(@PathVariable Long projectId) {
        return projectService.getProject(projectId);
    }

    /**
     * Create a new Project
     *
     * @param project   Project that you want to create
     * @return          Return created project
     */
    @RequestMapping(value = "/projects", method = POST)
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    /**
     * Edit specific Project
     *
     * @param projectId     Identification of Project that you want to edit
     * @param project       Edited Project
     * @return              Return edited Project
     */
    @RequestMapping(value = "/projects/{projectId}", method = PUT)
    public Project editDnsRecord(@PathVariable Long projectId, @RequestBody Project project) {
        return projectService.editProject(projectId, project);
    }

    /**
     * Delete specific Project
     *
     * @param projectId Identification of Project that you want to delete
     */
    @RequestMapping(value = "/projects/{projectId}", method = DELETE)
    public void deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
    }

}
