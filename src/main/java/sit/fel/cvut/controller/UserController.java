package sit.fel.cvut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sit.fel.cvut.entity.User;
import sit.fel.cvut.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/user/delete/{userId}", method = DELETE)
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }

//    @RequestMapping(value = "/user/create", method = POST)
//    public User createUser(String name, String email, String password, String salt) {
//        return userService.createUser(name, email, password, salt);
//    }

    @RequestMapping(value = "/user/create", method = POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
