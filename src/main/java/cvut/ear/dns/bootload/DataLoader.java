package cvut.ear.dns.bootload;

import cvut.ear.dns.models.*;
import cvut.ear.dns.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;
    private DnsRecordService dnsRecordService;
    private ProjectService projectService;
    private PasswordEncoder passwordEncoder;
    private ParticipationService participationService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("Starting application ...");

        User admin_acc = new User("admin", "heslo",
                "PrvniJm", "DruheJm", "admin@gmail.com");
        User user_acc = new User("user", "heslo",
                "PrvniJm", "DruheJm", "user@gmail.com");

        Permission view_perm = new Permission("VIEW");
        Permission edit_perm = new Permission("EDIT");
        Permission admin_perm = new Permission("ADMIN");

        Role admin_role = new Role("ADMIN");
        Role user_role = new Role("USER");

        permissionService.addPermission(view_perm);
        permissionService.addPermission(edit_perm);
        permissionService.addPermission(admin_perm);

        roleService.addRole(admin_role);
        roleService.addRole(user_role);

        admin_acc.setEnabled(true);
        user_acc.setEnabled(true);

        userService.addUser(admin_acc);
        userService.addUser(user_acc);

        userService.asignRoleToUser(admin_role, admin_acc);

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");

        projectService.addProject(google);
        projectService.addProject(ms);

        DnsRecord adastra = new DnsRecord("adastra.cz", "adastra.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382);
        DnsRecord finance = new DnsRecord("xxx.cz", "xxx.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382);
        DnsRecord seznam = new DnsRecord("seznam.cz", "seznam.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382);
        DnsRecord fb = new DnsRecord("fb.cz", "fb.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382);

        dnsRecordService.addDnsRecord(adastra);
        dnsRecordService.addDnsRecord(finance);
        dnsRecordService.addDnsRecord(seznam);
        dnsRecordService.addDnsRecord(fb);

        // record have 1 project
        // project have multiple records

        dnsRecordService.assignProjectToDnsRecord(google, adastra);
        dnsRecordService.assignProjectToDnsRecord(ms, finance);
        dnsRecordService.assignProjectToDnsRecord(google, fb);
        dnsRecordService.assignProjectToDnsRecord(ms, seznam);

        Participation participation1 = new Participation(user_acc.getId(), google.getId(), admin_perm);
        Participation participation2 = new Participation(user_acc.getId(), ms.getId(), view_perm);
        Participation participation3 = new Participation(admin_acc.getId(), ms.getId(), admin_perm);

        participationService.addParticipation(participation1);
        participationService.addParticipation(participation2);
        participationService.addParticipation(participation3);


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

    @Autowired
    public void setParticipationService(ParticipationService participationService) {
        this.participationService = participationService;
    }
}
