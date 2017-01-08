package cvut.ear.dns.controllers;

import cvut.ear.dns.models.Permission;
import cvut.ear.dns.services.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PermissionsController {


    private PermissionService permissionService;

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    private static final Logger log = LoggerFactory.getLogger(PermissionsController.class);

    /**
     * GET all the Permissions
     *
     * @return Return all permissions in application
     */
    @RequestMapping(value = "/permissions")
    public List<Permission> getPermissions(){
        log.debug("GET permissions, was called");
        return permissionService.getPermissions();
    }
    
}
