package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.Permission;
import cvut.ear.dns.repository.PermissionRepository;
import cvut.ear.dns.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    static Logger LOG = LoggerFactory.getLogger(PermissionServiceImpl.class);

    private PermissionRepository permissionRepository;

    @Autowired
    public void setPermissionRepository(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public void addPermission(Permission permission) {
        LOG.info("Adding permission:" + permission.getName());
        permissionRepository.save(permission);
    }

    @Override
    public Permission getPermission(Long id) {
        LOG.info("Get permission by id:" + id);
        return permissionRepository.findOne(id);
    }

    @Override
    public Permission getPermisison(String name) {
        LOG.info("Adding permission by name:" + name);
        return permissionRepository.findByName(name);
    }

    @Override
    public void updatePermission(Permission permission) {
        LOG.info("Update permission with id:" + permission.getId());

        Permission updated_permission = permissionRepository.findOne(permission.getId());

        updated_permission.setName(permission.getName());

        permissionRepository.save(updated_permission);
    }

    @Override
    public void deletePermission(Long id) {
        LOG.info("Delete permission with id:" + id);

        Permission d_Permission = permissionRepository.findOne(id);

        if (d_Permission != null){
            permissionRepository.delete(id);
        }
    }

    @Override
    public List<Permission> getPermissions() {
        return permissionRepository.findAll();
    }
}
