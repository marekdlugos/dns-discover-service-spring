package dns.discover.service.service;

import dns.discover.service.DTO.ParticipationDTO;
import dns.discover.service.entity.Account;
import dns.discover.service.entity.Participation;
import dns.discover.service.entity.Project;
import dns.discover.service.entity.Role;
import dns.discover.service.repository.ParticipationRepository;
import dns.discover.service.repository.ProjectRepository;
import dns.discover.service.repository.RoleRepository;
import dns.discover.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ParticipationService {

    @Autowired
    ParticipationRepository participationRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Transactional
    public List<Participation> projectParticipation(Long projectId){

        Project project = projectRepository.findOne(projectId);

        return project.getParticipations();

    }

    @Transactional
    public void saveParticipations(List<ParticipationDTO> participationDTOs) {

        for (ParticipationDTO p : participationDTOs
             ) {
            Project project = projectRepository.findOne(p.getProjectId());
            for (Participation old : project.getParticipations()
                 ) {
                participationRepository.delete(old);
            }
            Account account = userRepository.findOne(p.getAccountId());

            List<Role> roles = new ArrayList<Role>();

            for (Long roleId : p.getRolesIds()) {
                Role role = roleRepository.findOne(roleId);
                roles.add(role);
            }

            Participation participation = new Participation(account, project);
            participation.setRoles(roles);
            participationRepository.save(participation);

        }

    }
}
