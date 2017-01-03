package cvut.ear.dns.bootload;

import cvut.ear.dns.models.*;
import cvut.ear.dns.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;
    private DnsRecordService dnsRecordService;
    private ProjectService projectService;
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Starting application ...");

        User admin_acc = new User("admin", "heslo",
                "PrvniJm", "DruheJm", "admin@gmail.com");
        User user_acc = new User("user", "heslo",
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

        roleService.assignPermissionToRole(view_perm, user_role);
        roleService.assignPermissionToRole(view_perm, admin_role);
        roleService.assignPermissionToRole(edit_perm, admin_role);
        roleService.assignPermissionToRole(delete_perm, admin_role);
        roleService.assignPermissionToRole(create_perm, admin_role);

        userService.addUser(admin_acc);
        userService.addUser(user_acc);

        userService.asignRoleToUser(admin_role, admin_acc);

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");
        projectService.addProject(google);
        projectService.addProject(ms);

        DnsRecord adastra = new DnsRecord("adastra.cz", "adastra.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382);
        DnsRecord finance = new DnsRecord("xxx.cz", "xxx.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382);

        adastra.setProject(ms);
        finance.setProject(google);

        List<DnsRecord> google_records = new ArrayList<>();
        google_records.add(adastra);
        google_records.add(finance);
        google.setDnsRecords(google_records);

        dnsRecordService.addDnsRecord(adastra);
        dnsRecordService.addDnsRecord(finance);

        userService.assignProjectToUser(google, user_acc);
        userService.assignProjectToUser(google, admin_acc);
        userService.assignProjectToUser(ms, user_acc);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
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
