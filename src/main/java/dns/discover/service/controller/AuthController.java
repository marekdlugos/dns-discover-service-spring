package dns.discover.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Controller
public class AuthController {

    private String defaultPath = "forward:/views/login.html";

    @RequestMapping("/")
    public String defaultPath() {
        return defaultPath;
    }

    @RequestMapping("/logged")
    @ResponseBody
    public Map<String, Object> login(Principal user) {
        Map map = new HashMap();
        map.put("name", user.getName());
        map.put("role", "watcher");

        return map;
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {

            auth.inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER")
                    .and()
                    .withUser("admin").password("password").roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/user_ui/**", "/admin_ui/**", "/").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .csrf().disable();
        }


    }

}
