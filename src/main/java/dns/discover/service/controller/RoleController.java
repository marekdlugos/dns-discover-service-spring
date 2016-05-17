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

    @RequestMapping(value = "/roles")
    public Iterable<Role> getRoles(){
        return roleService.getRoles();
    }

    @RequestMapping(value = "/roles/{roleId}")
    public Role getRole(@PathVariable Long roleId) {
        return roleService.getRole(roleId);
    }
    
}
