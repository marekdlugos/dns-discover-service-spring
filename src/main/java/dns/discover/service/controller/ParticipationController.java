package dns.discover.service.controller;

import dns.discover.service.DTO.ParticipationDTO;
import dns.discover.service.entity.DnsRecord;
import dns.discover.service.entity.Participation;
import dns.discover.service.service.ParticipationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ParticipationController {

    @Autowired
    ParticipationService participationService;

    /**
     * GET Project's users with their roles
     *
     * @param projectId Identification of Project you want to return users for
     * @return          Return Participation (account, project, role)
     */
    @RequestMapping(value = "/participations/{projectId}", method = GET)
    public List<Participation> projectParticipation(@PathVariable Long projectId) {
        return participationService.projectParticipation(projectId);
    }

    /**
     * POST save project, user Participation with user's role
     *
     * @param participationDTO Participation DTO (projectId, accountId, roleId)
     *
     */
    @RequestMapping(value = "/saveParticipation", method = POST)
    public void saveParticipations(@RequestBody List<ParticipationDTO> participationDTO){
        participationService.saveParticipations(participationDTO);
    }

}
