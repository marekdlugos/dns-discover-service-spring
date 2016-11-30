package dns.discover.service;

import java.util.ArrayList;
import java.util.List;

import dns.discover.service.controller.DnsRecordController;
import dns.discover.service.controller.ProjectController;
import dns.discover.service.controller.UserController;
import dns.discover.service.entity.Account;
import dns.discover.service.entity.DnsRecord;
import dns.discover.service.entity.Project;
import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class UnitTest {


    // Create new Account objects
    Account marek = new Account("Marek Dlugos", "marek@rocketbuilt.tech", "pass");
    Account martin = new Account("Martin Tlachac", "martin@tlachac.cz", "tralala");
    Account pepa = new Account("Pepa Strossmayer", "pepa@pep.cz", "xixi");

    Project google = new Project("Google", "Landing page");
    Project google2 = new Project("Google", "Landing page");

    DnsRecord adastra = new DnsRecord("adastra.cz", "adastra.cz.", 86400, "MX", 21000, "adastra.com", "adastra", 21094210, 32000, 12000, 29001, 21382);
    DnsRecord finance = new DnsRecord("xxx.cz", "xxx.cz.", 86400, "MX", 21000, "xxx.com", "xxx", 21094210, 32000, 12000, 29001, 21382);

    @Test
    public void Test1(){
        Long id = marek.getId();
        Long idTocompare = 1L;
        assertEquals(idTocompare, id);
    }
    @Test
    public void Test2(){

        assertEquals("Martin Tlachac", martin.getName()
        );
    }
    @Test
    public void Test3(){
        assertEquals("pepa@pep.cz", pepa.getEmail());
    }
    @Test
    public void Test4(){
        assertEquals(google.getName(), google2.getName());
    }
    @Test
    public void Test5(){
        assertEquals("xxx.cz", finance.getZone());
    }
    // integration tests
    @Test
    public void AddNewProject_test(){
        ProjectController pctrl = new ProjectController();
        pctrl.createProject(google);
        pctrl.createProject(google2);
        pctrl.deleteProject(2L);

        Iterable<Project> projects = pctrl.getProjects();
        //create new list
        ArrayList<Project> list = new ArrayList<Project>();
        ArrayList<Project> toCompare = new ArrayList<Project>();
        toCompare.add(google);

        if(projects != null) for (Project project : projects) {
            list.add(project);
        }

        assertEquals(toCompare, list);
    }
    @Test
    public void AddNewUser_test(){
        UserController uctrl = new UserController();
        uctrl.createUser(marek);
        uctrl.createUser(pepa);
        uctrl.deleteUser(1L);

        Iterable<Account> acounts = uctrl.getUsers();
        //create new list
        ArrayList<Account> list = new ArrayList<Account>();
        ArrayList<Account> toCompare = new ArrayList<Account>();
        toCompare.add(pepa);

        if(acounts != null) for (Account account : acounts) {
            list.add(account);
        }
        assertEquals(toCompare, list);
    }
    @Test
    public void AddNewRecord_test(){
        DnsRecordController rctrl = new DnsRecordController();
        ProjectController pctrl = new ProjectController();
        pctrl.createProject(google);
        rctrl.createDnsRecord(adastra, 1L);
        rctrl.createDnsRecord(finance, 1L);
        rctrl.deleteDnsRecord(1L);

        Iterable<DnsRecord> records = rctrl.getDnsRecords();
        //create new list
        ArrayList<DnsRecord> list = new ArrayList<DnsRecord>();
        ArrayList<DnsRecord> toCompare = new ArrayList<DnsRecord>();
        toCompare.add(finance);

        if(records != null) for (DnsRecord record : records) {
            list.add(record);
        }
        assertEquals(toCompare, list);
    }

}
