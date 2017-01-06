package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.DnsRecord;
import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.Project;
import cvut.ear.dns.repository.DnsRecordRepository;
import cvut.ear.dns.repository.ProjectRepository;
import cvut.ear.dns.services.ParticipationService;
import cvut.ear.dns.services.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    static Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private ProjectRepository projectRepository;
    private DnsRecordRepository dnsRecordRepository;
    private ParticipationService participationService;

    @Autowired
    public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }

    @Autowired
    public void setDnsRecordRepository(DnsRecordRepository dnsRecordRepository) {
        this.dnsRecordRepository = dnsRecordRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void addProject(Project project) {
        LOG.info("Add project with name:" + project.getName());
        projectRepository.save(project);
    }

    @Override
    public Project getProject(Long id) {
        LOG.info("Add project by id:" +id);
        return projectRepository.findOne(id);
    }

    @Override
    public void updateProject(Project project) {
        LOG.info("Update project with id:" +project.getId());
        Project upated_project = projectRepository.findOne(project.getId());

        upated_project.setName(project.getName());
        upated_project.setDescription(project.getDescription());
        //TODO update participations ??
        upated_project.setParticipations(project.getParticipations());

        projectRepository.save(upated_project);
    }

    @Override
    public void assignParticipationToProject(Participation participation) {
        LOG.info("Assign Participation: "+participation.getId()+"  to project: " +participation.getId().getProjectID());

        Project assign_project = projectRepository.findOne(participation.getId().getProjectID());
        if (assign_project == null){
            throw new NoResultException("Project does not exist");
        }
        assign_project.getParticipations().add(participation);
        projectRepository.save(assign_project);
    }


    @Override
    public void deleteProject(Long id) {
        LOG.info("Delete project with id:" + id);
        Project d_project = projectRepository.findOne(id);
        List<Participation> all_participations = participationService.getParticiparions();
        for (Participation all_participation : all_participations) {
            if (all_participation.getProjectID().equals(d_project.getId())) {
                participationService.deleteParticiparion(all_participation.getId());
            }
        }

        if (d_project != null){
            projectRepository.delete(id);
        }
    }

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
