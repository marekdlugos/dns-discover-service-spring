package sit.fel.cvut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sit.fel.cvut.entity.User;
import sit.fel.cvut.repository.UserRepository;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public User getUser(Long userId){
        return userRepository.findOne(userId);
    }

    @Transactional
    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }

    @Transactional
    public User createUser(String name, String email, String password, String salt){
        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setSalt(salt);

        return userRepository.save(user);
    }

    @Transactional
    public User createUser(User user){
        return userRepository.save(user);
    }

}
