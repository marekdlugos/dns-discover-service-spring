package dns.discover.service;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import dns.discover.service.controller.ProjectController;
import dns.discover.service.entity.Account;
import dns.discover.service.entity.Project;
import junit.framework.JUnit4TestAdapter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class UnitTest {


    // Create new Account objects
    Account marek = new Account("Marek Dlugos", "marek@rocketbuilt.tech", "pass");
    Account martin = new Account("Martin Tlachac", "martin@tlachac.cz", "tralala");
    Account pepa = new Account("Pepa Strossmayer", "pepa@pep.cz", "xixi");

    @Test
    public void Test1(){
        long value = marek.getId();
        long exp = 1l;
        assertEquals(exp, value);
    }
    @Test
    public void Test2(){
        assertEquals("Martin Tlachac", martin.getName());
    }
    @Test
    public void Test3(){
        assertEquals("pepa@pep.cz", pepa.getEmail());
    }
    @Test
    public void Test4(){
        Project google = new Project("Google", "Landing page");
        Project google2 = new Project("Google", "Landing page");
        assertEquals(google.getName(), google2.getName());
    }


}
