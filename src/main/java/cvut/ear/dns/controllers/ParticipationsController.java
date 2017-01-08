package cvut.ear.dns.controllers;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.ParticipationWrapper;
import cvut.ear.dns.models.Permission;
import cvut.ear.dns.models.Project;
import cvut.ear.dns.services.ParticipationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ParticipationsController {

    private static final Logger log = LoggerFactory.getLogger(ParticipationsController.class);
    private ParticipationService participationService;

    @Autowired
    public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }

    //@PreAuthorize("@permissionSecurityService.hasPermissionToEditProject(#wrapper.getParticipations().get(0).getProjectID())")
    @RequestMapping(value = "/participation", method = POST)
    public void createProject(@RequestBody ParticipationWrapper wrapper) {
        log.debug("POST create a new participations, was called");
        for(Participation participation : wrapper.getParticipations()){
            participationService.addParticipation(participation);
        }
    }
}
