package dns.discover.service.controller;

import dns.discover.service.entity.Role;
import dns.discover.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * GET all the Roles
     *
     * @return Return all roles in application
     */
    @RequestMapping(value = "/roles")
    public Iterable<Role> getRoles(){
        return roleService.getRoles();
    }

    /**
     * GET specific Role
     *
     * @param roleId    Identification of Role that you want to GET
     * @return          Return specific Role
     */
    @RequestMapping(value = "/roles/{roleId}")
    public Role getRole(@PathVariable Long roleId) {
        return roleService.getRole(roleId);
    }
    
}
