package cvut.ear.dns.services;

import cvut.ear.dns.models.Permission;
import cvut.ear.dns.models.Role;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface RoleService {

    void addRole(Role role);
    Role getRole(Long id);
    Role getRole(String roleName);
    void deleteRole(Long id);
    void updateRole(Role role);
    List<Role> getRoles();
    void assignPermissionToRole(Permission permission, Role role);
}
