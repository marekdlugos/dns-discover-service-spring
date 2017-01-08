package cvut.ear.dns.services;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.Project;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface ProjectService {

    void addProject(Project project);
    Project getProject(Long id);
    void updateProject(Project project);
    void deleteProject(Long id);
    List<Project> getProjects();
    void assignParticipationToProject(Participation participation);

}
