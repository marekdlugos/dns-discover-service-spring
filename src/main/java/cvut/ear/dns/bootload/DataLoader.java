package cvut.ear.dns.bootload;

import cvut.ear.dns.models.Account;
import cvut.ear.dns.models.Permission;
import cvut.ear.dns.models.Role;
import cvut.ear.dns.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by Kuba on 30-Dec-16.
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private AccountService accountService;
    private RoleService roleService;
    private PermissionService permissionService;
    private DnsRecordService dnsRecordService;
    private ProjectService projectService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Starting application ...");

        Account admin_acc = new Account("admin", "heslo",
                "PrvniJm", "DruheJm", "admin@gmail.com");
        Account user_acc = new Account("user", "heslo",
                "PrvniJm", "DruheJm", "user@gmail.com");

        Permission view_perm = new Permission("VIEW");
        Permission edit_perm = new Permission("EDIT");
        Permission delete_perm = new Permission("DELETE");
        Permission create_perm = new Permission("CREATE");

        Role admin_role = new Role("ADMIN");
        Role user_role = new Role("USER");

        permissionService.addPermission(view_perm);
        permissionService.addPermission(edit_perm);
        permissionService.addPermission(delete_perm);
        permissionService.addPermission(create_perm);

        roleService.addRole(admin_role);
        roleService.addRole(user_role);

        admin_acc.setEnabled(true);
        user_acc.setEnabled(true);

        accountService.addAccount(admin_acc);
        accountService.addAccount(user_acc);

        roleService.assignPermissionToRole(view_perm, user_role);
        roleService.assignPermissionToRole(view_perm, admin_role);
        roleService.assignPermissionToRole(edit_perm, admin_role);
        roleService.assignPermissionToRole(delete_perm, admin_role);
        roleService.assignPermissionToRole(create_perm, admin_role);

        accountService.asignRoleToAccount(admin_role, admin_acc);
        accountService.asignRoleToAccount(user_role, user_acc);
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Autowired
    public void setDnsRecordService(DnsRecordService dnsRecordService) {
        this.dnsRecordService = dnsRecordService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
