package dns.discover.service;

import dns.discover.service.entity.Account;
import dns.discover.service.entity.DnsRecord;
import dns.discover.service.entity.Project;
import dns.discover.service.entity.Role;
import dns.discover.service.repository.DnsRecordRepository;
import dns.discover.service.repository.ProjectRepository;
import dns.discover.service.repository.RoleRepository;
import dns.discover.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DnsRecordRepository dnsRecordRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    private void load() {
        Account marek = new Account("Marek Dlugos", "marek@rocketbuilt.tech", "tralala", "abc");
        Account martin = new Account("Martin Tlachac", "martin@tlachac.cz", "tralala", "abc");

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");

        DnsRecord adastra = new DnsRecord("adastra.cz", "adastra.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382);
        DnsRecord finance = new DnsRecord("xxx.cz", "xxx.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382);
        google.setDnsRecords(Arrays.asList(adastra, finance));
        adastra.setProject(google);
        finance.setProject(google);

        google.setAccounts(Arrays.asList(marek, martin));
        marek.setProjects(Arrays.asList(google));

        projectRepository.save(google);
        projectRepository.save(ms);
        dnsRecordRepository.save(adastra);
        dnsRecordRepository.save(finance);
        userRepository.save(marek);
        userRepository.save(martin);

        Role watcher = new Role("Watcher", "Can view only the records related to project he is assigned.");
        Role editor = new Role("Editor", "Can view, edit and delete records related to assigned project.");
        Role manager = new Role("Manager", "Can view, edit and delete records related to project. Add and delete another users (watchers and editors) related to project. Create and delete projects.");
        Role admin = new Role("Admin", "Can view, edit and delete all records in app. Add and delete another users (watchers, editors and managers) across whole app. Create and delete all projects.");
        roleRepository.save(watcher);
        roleRepository.save(editor);
        roleRepository.save(manager);
        roleRepository.save(admin);


    }

}
