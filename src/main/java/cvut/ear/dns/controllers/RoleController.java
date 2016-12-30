package cvut.ear.dns.controllers;

import cvut.ear.dns.models.Role;
import cvut.ear.dns.services.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class RoleController {


    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    /**
     * GET all the Roles
     *
     * @return Return all roles in application
     */
    @RequestMapping(value = "/roles")
    public List<Role> getRoles(){
        log.debug("GET Roles, was called");
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
        log.debug("GET specific Role, was called");
        return roleService.getRole(roleId);
    }
    
}
