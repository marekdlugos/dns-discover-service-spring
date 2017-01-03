package cvut.ear.dns.services;

import cvut.ear.dns.models.Project;
import cvut.ear.dns.models.User;
import cvut.ear.dns.models.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface UserService extends UserDetailsService {
    void addUser(User user);
    User getUser(Long accId);
    User getUser(String username);
    void updateUser(User user);
    void deleteUser(Long accId);
    List<User> getUsers();
    void asignRoleToUser(Role role, User user);
    void assignProjectToUser(Project project, User user);


}
