package dns.discover.service;

import dns.discover.service.entity.Account;
import dns.discover.service.entity.Project;
import dns.discover.service.repository.ProjectRepository;
import dns.discover.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void load() {
        Account marek = new Account("Marek Dlugos", "marek@rocketbuilt.tech", "tralala", "abc");
        Account martin = new Account("Martin Tlachac", "martin@tlachac.cz", "tralala", "abc");

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");
        google.setAccounts(Arrays.asList(marek, martin));
        marek.setProject(google);
        martin.setProject(google);

        projectRepository.save(google);
        projectRepository.save(ms);
        userRepository.save(marek);
        userRepository.save(martin);

    }

}
