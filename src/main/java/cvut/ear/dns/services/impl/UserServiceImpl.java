package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.Participation;
import cvut.ear.dns.models.Project;
import cvut.ear.dns.models.User;
import cvut.ear.dns.models.Role;
import cvut.ear.dns.repository.ProjectRepository;
import cvut.ear.dns.repository.UserRepository;
import cvut.ear.dns.repository.RoleRepository;
import cvut.ear.dns.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Service
public class UserServiceImpl implements UserService {

    static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        LOG.info("Adding user: " + user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        asignRoleToUser(roleRepository.findByName("USER"), user);
    }

    @Override
    public User getUser(Long accId) {
        LOG.info("Get account by id: " + accId);
        return userRepository.findOne(accId);
    }

    @Override
    public User getUser(String username) {
        LOG.info("Get account by username: " + username);
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        LOG.info("Update user with id: " + user.getId());
        User updated_user = userRepository.findOne(user.getId());

        updated_user.setUsername(user.getUsername());
        updated_user.setFirstName(user.getFirstName());
        updated_user.setLastName(user.getLastName());
        updated_user.setEmail(user.getEmail());
        updated_user.setPassword(user.getPassword());
        updated_user.setRoles(user.getRoles());
        updated_user.setLastAccessedDate(user.getLastAccessedDate());

        userRepository.save(updated_user);
    }

    @Override
    public void deleteUser(Long accId) {
        LOG.info("Delete account by id: " + accId);
        User d_user = userRepository.findOne(accId);

        if (d_user != null){
            userRepository.delete(accId);
        }
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void asignRoleToUser(Role role, User user) {
        LOG.info("Assign role: " +role.getName()+ " to user: " + user.getUsername());

        Role assign_role = roleRepository.findByName(role.getName());
        if (assign_role == null){
            throw new NoResultException("Role does not exist");
        }
        User assign_user = userRepository.findByUsername(user.getUsername());
        if (assign_user == null){
            throw new NoResultException("User does not exist");
        }

        assign_user.setRoles(assign_role);
        userRepository.save(assign_user);
    }

    @Override
    public void assignParticipationToUser(Participation participation) {
        LOG.info("Assign Participation: "+participation.getId()+"  to user: " +participation.getId().getUserID());

        User assign_user = userRepository.findOne(participation.getId().getUserID());
        if (assign_user == null){
            throw new NoResultException("User does not exist");
        }

        assign_user.getParticipations().add(participation);
        userRepository.save(assign_user);
    }

    /**
     * @return current logged user
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOG.info("Load user by username:" + s);

        User user = null;
        try {
            user = getUser(s);
        }catch (UsernameNotFoundException e1){
            e1.printStackTrace();
        }
        if (user == null){
            LOG.warn("NO USER FOUND");
            throw new UsernameNotFoundException("No such user " + s);
        }else if (user.getRoles() == null){
            LOG.warn("USER HAS NO AUTHORITIES!!");
            throw new UsernameNotFoundException("User has no authorities" + s);
        }

        user.setLastAccessedDate(Calendar.getInstance().getTime());

        try {
            updateUser(user);
        }catch (UsernameNotFoundException e1){
            e1.printStackTrace();
        }

        return user;
    }
}
