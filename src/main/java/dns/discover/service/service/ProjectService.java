package dns.discover.service.service;

import dns.discover.service.entity.Project;
import dns.discover.service.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Transactional
    public Iterable<Project> getProjects(){
        return projectRepository.findAll();
    }

    @Transactional
    public Project getProject(Long projectId){
        return projectRepository.findOne(projectId);
    }

    @Transactional
    public void deleteProject(Long projectId){
        projectRepository.delete(projectId);
    }

    @Transactional
    public Project createProject(Project project){
        return projectRepository.save(project);
    }

}
