package dns.discover.service.service;

import dns.discover.service.entity.Role;
import dns.discover.service.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    /**
     * Function finds all Roles
     *
     * @return  Return all Roles in the app
     */
    @Transactional
    public Iterable<Role> getRoles(){
        return roleRepository.findAll();
    }

    /**
     * Function finds specific Role
     *
     * @param roleId    Identification of specific Role
     * @return          Return specific Role
     */
    @Transactional
    public Role getRole(Long roleId){
        return roleRepository.findOne(roleId);
    }

}
