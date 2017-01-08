package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.ParticipationId;
import cvut.ear.dns.repository.*;
import cvut.ear.dns.services.ParticipationService;
import cvut.ear.dns.services.ProjectService;
import cvut.ear.dns.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipationServiceImpl implements ParticipationService {

    static Logger LOG = LoggerFactory.getLogger(ParticipationServiceImpl.class);

    private UserService userService;
    private ProjectService projectService;
    private ParticipationRepository participationRepository;

    @Autowired
    public void setParticipationRepository(ParticipationRepository participationRepository) {
        this.participationRepository = participationRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public void addParticipation(Participation participation) {
        LOG.info("Creating participation (userID-projectID-permissions): "
                +participation.getUserID()+"-"+participation.getProjectID()+"-"
                +participation.getPermissions().getName());
        if (participation.getId() == null){
            ParticipationId participationId = new ParticipationId(participation.getUserID(), participation.getProjectID());
            participation.setId(participationId);
        }
        participationRepository.save(participation);

        //userService.assignParticipationToUser(participation);
        //projectService.assignParticipationToProject(participation);
    }

    @Override
    public Participation getParticiparion(ParticipationId particId) {
        LOG.info("Get participation by id: " + particId);
        return participationRepository.findOne(particId);
    }

    @Override
    public void updateParticiparion(Participation participarion) {
        LOG.info("Update participation with id: " + participarion.getId());
        Participation updated_participation = participationRepository.findOne(participarion.getId());

        updated_participation.setPermissions(participarion.getPermissions());

        participationRepository.save(updated_participation);
    }

    @Override
    public void deleteParticiparion(ParticipationId particId) {
        LOG.info("Delete participation with id: "+particId);

        Participation del_participation = participationRepository.findOne(particId);

        if (del_participation != null){
            userService.getUser(del_participation.getId().getUserID()).getParticipations().remove(del_participation);
            projectService.getProject(del_participation.getId().getProjectID()).getParticipations().remove(del_participation);
            participationRepository.delete(del_participation);
        }
    }

    @Override
    public List<Participation> getParticiparions() {
        LOG.info("Get all participation ");
        return participationRepository.findAll();
    }
}
