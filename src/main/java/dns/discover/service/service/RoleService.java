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

    @Transactional
    public Iterable<Role> getRoles(){
        return roleRepository.findAll();
    }

    @Transactional
    public Role getRole(Long roleId){
        return roleRepository.findOne(roleId);
    }

}
