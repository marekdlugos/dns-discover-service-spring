package dns.discover.service.service;

import dns.discover.service.entity.Participation;
import dns.discover.service.entity.Project;
import dns.discover.service.repository.ParticipationRepository;
import dns.discover.service.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ParticipationRepository participationRepository;

    /**
     * Function finds all Projects
     *
     * @return Return all Projects in the app
     */
    @Transactional
    public Iterable<Project> getProjects(){
        return projectRepository.findAll();
    }

    /**
     * Function finds specific Project based on request
     *
     * @param projectId Identification of the Project you want to return
     * @return          Return specific Project
     */
    @Transactional
    public Project getProject(Long projectId){
        return projectRepository.findOne(projectId);
    }

    /**
     * Function deletes specific Project
     * @param projectId Identification of the Project you want to delete
     */
    @Transactional
    public void deleteProject(Long projectId){

        Project project = projectRepository.findOne(projectId);

        for (Participation p: project.getParticipations()
             ) {

            participationRepository.delete(p);

        }

        projectRepository.delete(projectId);

    }

    /**
     * Function creates a new Project
     *
     * @param project    New Project Object
     * @return           Return created Project
     */
    @Transactional
    public Project createProject(Project project){
        return projectRepository.save(project);

        // TODO: Participation update -> added users
        // TODO: Account_project_role -> add roles
    }

    /**
     * Function edits specific Project
     *
     * @param projectId    Identification of the Project you want to edit
     * @param project      Edited Project
     * @return             Return edited Project
     */
    @Transactional
    public Project editProject(Long projectId, Project project){
        project.setId(projectId);
        return projectRepository.save(project);

        // TODO: Account_project_role update -> update roles
        // TODO: Participation and Account_project_role delete -> Delete users from project
        // TODO: Participation and Roles update -> Add users to project
    }

}
