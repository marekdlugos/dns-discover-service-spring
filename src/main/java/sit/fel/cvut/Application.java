package sit.fel.cvut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sit.fel.cvut.entity.User;
import sit.fel.cvut.repository.UserRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void load() {
        userRepository.save(new User("Marek Dlugos", "marek@rocketbuilt.tech", "tralala", "abc"));
        userRepository.save(new User("Martin Tlachac", "martin@tlachac.cz", "tralala", "abc"));
    }

}
