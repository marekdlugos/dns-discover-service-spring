package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.Permission;
import cvut.ear.dns.models.Role;
import cvut.ear.dns.repository.PermissionRepository;
import cvut.ear.dns.repository.RoleRepository;
import cvut.ear.dns.services.RoleService;
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
public class RoleServiceImpl implements RoleService {

    static Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    private RoleRepository roleRepository;
    private PermissionRepository permissionRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPermissionRepository(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void addRole(Role role) {
        LOG.info("Add role with name:" + role.getName());
        roleRepository.save(role);
    }

    @Override
    public Role getRole(Long id) {
        LOG.info("Ger role with id:" + id);
        return roleRepository.findOne(id);
    }

    @Override
    public Role getRole(String roleName) {
        LOG.info("Get role by name:" + roleName);
        return roleRepository.findByName(roleName);
    }

    @Override
    public void deleteRole(Long id) {
        LOG.info("Delete role with id:" + id);
        Role d_role = roleRepository.findOne(id);

        if (d_role != null){
            roleRepository.delete(id);
        }
    }

    @Override
    public void updateRole(Role role) {
        LOG.info("Delete role with id:" + role.getId());
        Role update_role = roleRepository.findOne(role.getId());

        update_role.setName(role.getName());
        update_role.setPermissions(role.getPermissions());

        roleRepository.save(update_role);
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void assignPermissionToRole(Permission permission, Role role) {
        LOG.info("Assign permission: " +permission.getName()+ " to role:" + role.getName());

        Role assign_role = roleRepository.findByName(role.getName());
        if (assign_role == null){
            throw new NoResultException("Role does not exist");
        }
        Permission assign_permission = permissionRepository.findByName(permission.getName());
        if (assign_permission == null){
            throw new NoResultException("Permission does not exist");
        }

        assign_role.getPermissions().add(assign_permission);
        roleRepository.save(assign_role);
    }
}
