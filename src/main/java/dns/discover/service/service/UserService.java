package dns.discover.service.service;

import dns.discover.service.entity.Account;
import dns.discover.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Iterable<Account> getUsers(){
        return userRepository.findAll();
    }

    @Transactional
    public Account getUser(Long userId){
        return userRepository.findOne(userId);
    }

    @Transactional
    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }

    @Transactional
    public Account createUser(Account account){
        return userRepository.save(account);
    }

    @Transactional
    public Account editUser(Account account){
        return userRepository.save(account);
    }

    @Transactional
    public Account editUser(Long userId, Account user){
        user.setId(userId);
        return userRepository.save(user);
    }

}
