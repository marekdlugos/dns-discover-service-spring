package cvut.ear.dns.services;

import cvut.ear.dns.models.Account;
import cvut.ear.dns.models.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
public interface AccountService extends UserDetailsService {
    void addAccount(Account account);
    Account getAccount(Long accId);
    Account getAccount(String username);
    void updateAccount(Account account);
    void deleteAccount(Long accId);
    List<Account> getAccounts();
    void asignRoleToAccount(Role role, Account account);


}
