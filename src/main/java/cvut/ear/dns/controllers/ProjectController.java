package cvut.ear.dns.controllers;

import cvut.ear.dns.models.Project;
import cvut.ear.dns.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    private ProjectService projectService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    /**
     * GET all Projects
     *
     * @return Return all projects
     */
    @RequestMapping(value = "/projects", method = GET)
    public List<Project> getProjects(){
        log.debug("GET Projects, was called");
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
        log.debug("GET a specific User, was called");
        return projectService.getProject(projectId);
    }

    /**
     * Create a new Project
     *
     * @param project   Project that you want to create
     * @return          Return created project
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/projects", method = POST)
    public Project createProject(@RequestBody Project project) {
        log.debug("POST create a new Project, was called");
        projectService.addProject(project);
        return projectService.getProject(project.getId());
    }

    /**
     * Edit specific Project
     *
     * @param projectId     Identification of Project that you want to edit
     * @param project       Edited Project
     * @return              Return edited Project
     */
    @PreAuthorize("@permissionSecurityService.hasPermissionToEditProject(#projectId)")
    @RequestMapping(value = "/projects/{projectId}", method = PUT)
    public Project editProject(@PathVariable Long projectId, @RequestBody Project project) {
        log.debug("PUT edit Project, was called");
        project.setId(projectId);
        projectService.updateProject(project);
        return projectService.getProject(project.getId());
    }

    /**
     * Delete specific Project
     *
     * @param projectId Identification of Project that you want to delete
     */
    @PreAuthorize("@permissionSecurityService.hasPermissionToDeleteProject(authentication, #projectId)")
    @RequestMapping(value = "/projects/{projectId}", method = DELETE)
    public void deleteProject(@PathVariable Long projectId) {
        log.debug("DELETE Project, was called");
        projectService.deleteProject(projectId);
    }

}
