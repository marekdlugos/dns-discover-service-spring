package cvut.ear.dns.controllers;

import cvut.ear.dns.models.Account;
import cvut.ear.dns.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
public class AccountController {


    AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    /**
     * GET all Accounts
     *
     * @return Return all Accounts
     */
    @RequestMapping(value = "/Accounts", method = GET)
    public List<Account> getAccounts(){
        log.debug("GET Accounts, was called");
        return accountService.getAccounts();
    }

    /**
     * GET specific Account
     *
     * @param AccountId    Identification of Account you want to GET
     * @return          Return specific Account
     */
    @RequestMapping(value = "/Accounts/{AccountId}")
    public Account getAccount(@PathVariable Long AccountId){
        log.debug("GET specific Account, was called");
        return accountService.getAccount(AccountId);
    }

    /**
     * GET specific Account
     *
     * @param username    Identification of Account you want to GET
     * @return          Return specific Account
     */
    @RequestMapping(value = "/Accounts/{username}")
    public Account getAccount(@PathVariable String username){
        log.debug("GET specific Account, was called");
        return accountService.getAccount(username);
    }

    /**
     * POST create a new Account
     *
     * @param account   New Account object
     * @return          Return created Account
     */
    @RequestMapping(value = "/Accounts", method = POST)
    public Account createAccount(@RequestBody Account account) {
        log.debug("POST create Account, was called");
        accountService.addAccount(account);
        return accountService.getAccount(account.getUsername());
    }

    /**
     * PUT edit specific Account
     *
     * @param AccountId     Identification of Account you want to edit
     * @param account    Edited Account
     * @return           Return edited Account
     */
    @RequestMapping(value = "/Accounts/{AccountId}", method = PUT)
    public Account editAccount(@PathVariable Long AccountId, @RequestBody Account account) {
        log.debug("PUT edit Account, was called");
        account.setId(AccountId);
        accountService.updateAccount(account);
        return accountService.getAccount(account.getUsername());
    }

    @RequestMapping(value = "/Accounts/{AccountId}", method = DELETE)
    public void deleteAccount(@PathVariable Long AccountId){
        log.debug("DELETE delete Account, was called");
        accountService.deleteAccount(AccountId);
    }

}
