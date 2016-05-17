package sit.fel.cvut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import sit.fel.cvut.repository.UserRepository;

public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/test")
    public String hello(){
        return "Hello world!";
    }
}
