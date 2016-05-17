package dns.discover.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import dns.discover.service.entity.Account;
import dns.discover.service.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users")
    public Iterable<Account> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/{userId}")
    public Account getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/user/delete/{userId}", method = DELETE)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

//    @RequestMapping(value = "/user/create", method = POST)
//    public Account createUser(String name, String email, String password, String salt) {
//        return userService.createUser(name, email, password, salt);
//    }

    @RequestMapping(value = "/user/create", method = POST)
    public Account createUser(@RequestBody Account account) {
        return userService.createUser(account);
    }
}
