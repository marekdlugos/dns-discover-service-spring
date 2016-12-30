package cvut.ear.dns.services.impl;

import cvut.ear.dns.models.Account;
import cvut.ear.dns.models.Role;
import cvut.ear.dns.repository.AccountRepository;
import cvut.ear.dns.repository.RoleRepository;
import cvut.ear.dns.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    static Logger LOG = LoggerFactory.getLogger(AccountServiceImpl.class);

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void addAccount(Account account) {
        LOG.info("Adding account:" + account.getUsername());
        asignRoleToAccount(roleRepository.findByName("USER"), account);
        accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long accId) {
        LOG.info("Get account by id:" + accId);
        return accountRepository.findOne(accId);
    }

    @Override
    public Account getAccount(String username) {
        LOG.info("Get account by username:" + username);
        return accountRepository.findByUsername(username);
    }

    @Override
    public void updateAccount(Account account) {
        LOG.info("Update account with id:" + account.getId());
        Account updated_account = accountRepository.findOne(account.getId());

        updated_account.setUsername(account.getUsername());
        updated_account.setFirstName(account.getFirstName());
        updated_account.setLastName(account.getLastName());
        updated_account.setEmail(account.getEmail());
        updated_account.setPassword(account.getPassword());
        updated_account.setRoles(account.getRoles());
        updated_account.setLastAccessedDate(account.getLastAccessedDate());

        accountRepository.save(updated_account);
    }

    @Override
    public void deleteAccount(Long accId) {
        LOG.info("Delete account by id:" + accId);
        Account d_account = accountRepository.findOne(accId);

        if (d_account != null){
            accountRepository.delete(accId);
        }
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void asignRoleToAccount(Role role, Account account) {
        LOG.info("Assign role: " +role.getName()+ " to account:" + account.getUsername());

        Role assign_role = roleRepository.findByName(role.getName());
        if (assign_role == null){
            throw new NoResultException("Role does not exist");
        }
        Account assign_account = accountRepository.findByUsername(account.getUsername());
        if (assign_account == null){
            throw new NoResultException("Account does not exist");
        }

        assign_account.getRoles().add(assign_role);
        accountRepository.save(assign_account);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        LOG.info("Load user by username:" + s);

        Account account = null;
        try {
            account = getAccount(s);
        }catch (UsernameNotFoundException e1){
            e1.printStackTrace();
        }
        if (account == null){
            LOG.warn("NO USER FOUND");
            throw new UsernameNotFoundException("No such user " + s);
        }else if (account.getRoles().isEmpty()){
            LOG.warn("USER HAS NO AUTHORITIES!!");
            throw new UsernameNotFoundException("User has no authorities" + s);
        }

        account.setLastAccessedDate(Calendar.getInstance().getTime());

        try {
            updateAccount(account);
        }catch (UsernameNotFoundException e1){
            e1.printStackTrace();
        }

        return account;
    }
}
