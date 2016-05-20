//package dns.discover.service.controller;
//
//import dns.discover.service.entity.Account;
//import dns.discover.service.repository.UserRepository;
//import dns.discover.service.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.security.Principal;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@Controller
//public class AuthController {
//
//    private String defaultPath = "forward:/views/login.html";
//
//    @RequestMapping("/")
//    public String defaultPath() {
//        return defaultPath;
//    }
//
//    @RequestMapping("/logged")
//    @ResponseBody
//    public Map<String, Object> login(Principal user) {
//        Map map = new HashMap();
//        map.put("name", user.getName());
//        map.put("role", "watcher");
//
//        return map;
//    }
//
//    @Configuration
//    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
//    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//        @Autowired
//        UserService userService;
//
//        @Autowired
//        public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
//
//            auth.userDetailsService(new UserDetailsService() {
//                @Override
//                public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
//                    Account user = userService.getUser(id);
//                    return (UserDetails)user;
//                    // return convert account to UserDetails;
//                }
//            }).passwordEncoder(new BCryptPasswordEncoder());
//        }
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/js/**", "/css/**", "/fonts/**", "/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//        }
//
//
//    }
//
//}
