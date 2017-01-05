package cvut.ear.dns.controllers;

import cvut.ear.dns.models.User;
import cvut.ear.dns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Controller
public class LoginController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        //TODO security
        return "login";
    }


    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    @ResponseBody
    public Long currentUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User currentUser = userRepository.findByUsername(principal.getName());
        return currentUser.getId();
    }
}
