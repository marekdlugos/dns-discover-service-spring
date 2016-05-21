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

    /**
     * Function finds all Users in the app
     *
     * @return Return all Users in the app
     */
    @Transactional
    public Iterable<Account> getUsers(){
        return userRepository.findAll();
    }

    /**
     * Function finds specific User based on the identification
     *
     * @param userId    Identification of User
     * @return          Return specific User
     */
    @Transactional
    public Account getUser(Long userId){
        return userRepository.findOne(userId);
    }

    /**
     * Function deletes specific User
     *
     * @param userId    Identification of User you want do delete
     */
    @Transactional
    public void deleteUser(Long userId){
        userRepository.delete(userId);
    }

    /**
     * Function creates a new User
     *
     * @param account    New User Object
     * @return           Return created User
     */
    @Transactional
    public Account createUser(Account account){
        return userRepository.save(account);
    }

    /**
     * Function edits a specific User
     *
     * @param userId    Identification of User you want to edit
     * @param user      Edited User
     * @return          Return Edited User
     */
    @Transactional
    public Account editUser(Long userId, Account user){
        user.setId(userId);
        return userRepository.save(user);
    }

}
