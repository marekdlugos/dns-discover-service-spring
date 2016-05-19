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

    @RequestMapping(value = "/users", method = GET)
    @RolesAllowed("ADMIN")
    public Iterable<Account> getUsers(){
        log.debug("GET Users");
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{userId}")
    public Account getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/users", method = POST)
    public Account createUser(@RequestBody Account account) {
        return userService.createUser(account);
    }

    @RequestMapping(value = "/users/{userId}", method = DELETE)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

}
