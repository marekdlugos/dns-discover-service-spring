package cvut.ear.dns.security;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.User;
import cvut.ear.dns.services.ParticipationService;
import cvut.ear.dns.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Objects;

@Component
public class PermissionSecurityService {

    private UserService userService;
    private ParticipationService participationService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }

    public boolean hasPermissionToDeleteProject(Authentication authentication, Long projectID){
        //TODO
        System.out.println(authentication.toString());
        String principalName = authentication.getName();
        User currentUser = userService.getUser(principalName);
        if (currentUser.getRoles().getName().equals("ADMIN")){ return true;}
        List<Participation> participations = participationService.getParticiparions();
        for (Participation participation : participations){
            if (participation.getUserID().equals(currentUser.getId())
                    && participation.getProjectID().equals(projectID)){
                return Objects.equals(participation.getPermissions().getName(), "ADMIN");
            }
        }
        return false;
    }

    public boolean hasPermissionToEditProject(HttpServletRequest request, Long projectID){
        //TODO
        System.out.println(request.toString());
        Principal principal = request.getUserPrincipal();
        String principalName = principal.getName();
        User currentUser = userService.getUser(principalName);
        if (currentUser.getRoles().getName().equals("ADMIN")){ return true;}
        List<Participation> participations = participationService.getParticiparions();
        for (Participation participation : participations){
            if (participation.getUserID().equals(currentUser.getId())
                    && participation.getProjectID().equals(projectID)){
                return Objects.equals(participation.getPermissions().getName(), "ADMIN")
                        || Objects.equals(participation.getPermissions().getName(), "EDIT");
            }
        }
        return false;
    }
}
