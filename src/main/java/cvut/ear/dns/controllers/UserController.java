package cvut.ear.dns.controllers;

import cvut.ear.dns.models.User;
import cvut.ear.dns.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {


    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * GET all Users
     *
     * @return Return all Users
     */
    @RequestMapping(value = "/users", method = GET)
    public List<User> getUsers(){
        log.debug("GET Users, was called");
        return userService.getUsers();
    }

    /**
     * GET specific User
     *
     * @param UserId    Identification of User you want to GET
     * @return          Return specific User
     */
    @RequestMapping(value = "/users/{UserId}")
    public User getUserById(@PathVariable Long UserId){
        log.debug("GET specific User, was called");
        return userService.getUser(UserId);
    }

    /**
     * POST create a new User
     *
     * @param user   New User object
     * @return          Return created User
     */
    @RequestMapping(value = "/users", method = POST)
    public User createUser(@RequestBody User user) {
        log.debug("POST create User, was called");
        userService.addUser(user);
        return userService.getUser(user.getUsername());
    }

    /**
     * PUT edit specific User
     *
     * @param UserId     Identification of User you want to edit
     * @param user    Edited User
     * @return           Return edited User
     */
    @RequestMapping(value = "/users/{UserId}", method = PUT)
    public User editUser(@PathVariable Long UserId, @RequestBody User user) {
        log.debug("PUT edit User, was called");
        user.setId(UserId);
        userService.updateUser(user);
        return userService.getUser(user.getUsername());
    }

    @RequestMapping(value = "/users/{UserId}", method = DELETE)
    public void deleteUser(@PathVariable Long UserId){
        log.debug("DELETE delete User, was called");
        userService.deleteUser(UserId);
    }
}
