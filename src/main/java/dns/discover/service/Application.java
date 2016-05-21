package dns.discover.service;

import dns.discover.service.entity.*;
import dns.discover.service.repository.*;
import dns.discover.service.thread.PrintThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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

    @Autowired
    ParticipationRepository participationRepository;

    /**
     * Main method
     *
     * @param args  Arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(PrintThread.class);

        PrintThread printThread1 = (PrintThread) ctx.getBean("printThread");
        printThread1.setName("Thread 1");

        PrintThread printThread2 = (PrintThread) ctx.getBean("printThread");
        printThread2.setName("Thread 2");

        PrintThread printThread3 = (PrintThread) ctx.getBean("printThread");
        printThread3.setName("Thread 3");

        PrintThread printThread4 = (PrintThread) ctx.getBean("printThread");
        printThread4.setName("Thread 4");

        PrintThread printThread5 = (PrintThread) ctx.getBean("printThread");
        printThread5.setName("Thread 5");

        printThread1.start();
        printThread2.start();
        printThread3.start();
        printThread4.start();
        printThread5.start();

    }

    @PostConstruct
    private void load() {
        Account marek = new Account("Marek Dlugos", "marek@rocketbuilt.tech", "tralala");
        Account martin = new Account("Martin Tlachac", "martin@tlachac.cz", "tralala");

        Project google = new Project("Google", "Landing page");
        Project ms = new Project("Microsoft", "page");
        projectRepository.save(google);
        projectRepository.save(ms);

        DnsRecord adastra = new DnsRecord("adastra.cz", "adastra.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382, google);
        DnsRecord finance = new DnsRecord("xxx.cz", "xxx.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382, ms);
        google.setDnsRecords(Arrays.asList(adastra, finance));
        dnsRecordRepository.save(adastra);
        dnsRecordRepository.save(finance);

        // Defining Roles in the App
        Role watcher = new Role("Watcher", "Can view only the records related to project he is assigned.");
        Role editor = new Role("Editor", "Can view, edit and delete records related to assigned project.");
        Role manager = new Role("Manager", "Can view, edit and delete records related to project. Add and delete another users (watchers and editors) related to project. Create and delete projects.");
        Role admin = new Role("Admin", "Can view, edit and delete all records in app. Add and delete another users (watchers, editors and managers) across whole app. Create and delete all projects.");
        roleRepository.save(watcher);
        roleRepository.save(editor);
        roleRepository.save(manager);
        roleRepository.save(admin);

        userRepository.save(marek);
        userRepository.save(martin);

        Participation marek_google = new Participation(marek, google);
        participationRepository.save(marek_google);

    }

}
