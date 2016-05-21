package dns.discover.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dns.discover.service.entity.Account;
import dns.discover.service.service.UserService;

import javax.annotation.security.RolesAllowed;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * GET all Users
     *
     * @return Return all Users
     */
    @RequestMapping(value = "/users", method = GET)
    public Iterable<Account> getUsers(){
        log.debug("GET Users, was called");
        return userService.getUsers();
    }

    /**
     * GET specific User
     *
     * @param userId    Identification of User you want to GET
     * @return          Return specific User
     */
    @RequestMapping(value = "/users/{userId}")
    public Account getUser(@PathVariable Long userId){
        log.debug("GET specific User, was called");
        return userService.getUser(userId);
    }

    /**
     * POST create a new User
     *
     * @param account   New User object
     * @return          Return created User
     */
    @RequestMapping(value = "/users", method = POST)
    public Account createUser(@RequestBody Account account) {
        log.debug("POST create User, was called");
        return userService.createUser(account);
    }

    /**
     * PUT edit specific User
     *
     * @param userId     Identification of User you want to edit
     * @param account    Edited User
     * @return           Return edited User
     */
    @RequestMapping(value = "/users/{userId}", method = PUT)
    public Account editAccount(@PathVariable Long userId, @RequestBody Account account) {
        log.debug("PUT edit User, was called");
        return userService.editUser(userId, account);
    }

    @RequestMapping(value = "/users/{userId}", method = DELETE)
    public void deleteUser(@PathVariable Long userId){
        log.debug("DELETE delete User, was called");
        userService.deleteUser(userId);
    }

}
