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
    public Account createUser(String name, String email, String password, String salt){
        Account account = new Account();

        account.setName(name);
        account.setEmail(email);
        account.setPassword(password);
        account.setSalt(salt);

        return userRepository.save(account);
    }

    @Transactional
    public Account createUser(Account account){
        return userRepository.save(account);
    }

}
