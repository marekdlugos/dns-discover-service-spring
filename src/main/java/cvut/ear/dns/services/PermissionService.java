package cvut.ear.dns.services;

import cvut.ear.dns.models.Permission;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface PermissionService {

    void addPermission(Permission permission);
    Permission getPermission(Long id);
    Permission getPermisison(String name);
    void updatePermission(Permission permission);
    void  deletePermission(Long id);
    List<Permission> getPermissions();
}
