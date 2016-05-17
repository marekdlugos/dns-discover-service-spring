package sit.fel.cvut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sit.fel.cvut.entity.Project;
import sit.fel.cvut.entity.User;
import sit.fel.cvut.repository.ProjectRepository;
import sit.fel.cvut.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    ProjectRepository projectRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void load() {
        User marek = new User("Marek Dlugos", "marek@rocketbuilt.tech", "tralala", "abc");
        User martin = new User("Martin Tlachac", "martin@tlachac.cz", "tralala", "abc");

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");
//        google.setUsers(Arrays.asList(marek, martin));
//        marek.setProject(google);
//        martin.setProject(google);

//        projectRepository.save(google);
//        projectRepository.save(ms);
        userRepository.save(marek);
        userRepository.save(martin);

    }

}
