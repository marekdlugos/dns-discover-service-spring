package dns.discover.service;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Kuba on 5/24/2016.
 */
public class SeleniumTest {

    @Test
    public void CreateNewUser_test1(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/users.html");

        driver.findElement(By.id("new")).click();

        Page newUserPage = new Page(driver);

        newUserPage.uname.sendKeys("User name 1");
        newUserPage.email.sendKeys("email1@gmail.com");
        newUserPage.password.sendKeys("heslo");
        newUserPage.password2.sendKeys("heslo");

        driver.findElement(By.id("add")).click();

        String actualtext = driver.findElement(By.linkText("User name 1")).getText();
        String expectedText = "User name 1";

//        if (actualtext.contentEquals(expectedText)){
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Can't find new user");
//        }

        driver.close();
    }

    @Test
    public void EditUser_test1(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/users.html");

        driver.findElement(By.id("1")).click();

        Page newUserPage = new Page(driver);

        newUserPage.uname.clear();
        newUserPage.uname.sendKeys("Marek edit");
        newUserPage.email.clear();
        newUserPage.email.sendKeys("emailedit@gmail.com");
        newUserPage.password.clear();
        newUserPage.password.sendKeys("heslo");
        newUserPage.password2.clear();
        newUserPage.password2.sendKeys("heslo");

        driver.findElement(By.id("edit")).click();

//        String actualtext = driver.findElement(By.partialLinkText("Marek")).getText();
//        String expectedText = "Marek edit";
//
//        if (actualtext.contentEquals(expectedText)){
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Can't find edited user");
//        }

        driver.close();
    }

    @Test
    public void DeleteUser_test1(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/users.html");

        driver.findElement(By.id("pepa@pep.cz")).click();


//        String actualtext = driver.findElement(By.linkText("pepa@pep.cz")).getText();
//        String expectedText = null;
//
////        if (actualtext.contentEquals(expectedText)){
////            System.out.println("Test Passed!");
////        } else {
////            System.out.println("Find deleted user");
////        }

        driver.close();

    }

    @Test
    public void CreateNewRecord_test(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/records.html");

        driver.findElement(By.id("new")).click();

        RecordPage newRecord = new RecordPage(driver);

        newRecord.zone.sendKeys("Zone.com");
        WebElement mySelectElm = driver.findElement(By.id("host"));
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("@");
        newRecord.ttl.sendKeys("12345");
        mySelect = new Select(driver.findElement(By.id("type")));
        mySelect.selectByIndex(2);
        newRecord.mx_priority.sendKeys("2");
        newRecord.data.sendKeys("some data");
        newRecord.resp_person.sendKeys("Marek");
        newRecord.serial.sendKeys("1234567890");
        newRecord.refresh.sendKeys("10000");
        newRecord.retry.sendKeys("7200");
        newRecord.expire.sendKeys("5000");
        newRecord.minimum.sendKeys("100");
        mySelect = new Select(driver.findElement(By.id("project")));
        mySelect.selectByIndex(1);


        driver.findElement(By.id("add")).click();

//        String actualtext = driver.findElement(By.linkText("Zone.com")).getText();
//        String expectedText = "Zone.com";
//
//        if (actualtext.contentEquals(expectedText)){
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Can't find new DNSrecord");
//        }

        driver.close();
    }

    @Test
    public void EditRecord_test(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/records.html");

        driver.findElement(By.id("2")).click();

        RecordPage newRecord = new RecordPage(driver);

        newRecord.zone.clear();
        newRecord.zone.sendKeys("xxxEdit.com");
        WebElement mySelectElm = driver.findElement(By.id("host"));
        Select mySelect= new Select(mySelectElm);
        mySelect.selectByVisibleText("@");
        newRecord.ttl.clear();
        newRecord.ttl.sendKeys("12345");
        mySelect = new Select(driver.findElement(By.id("type")));
        mySelect.selectByIndex(2);
        newRecord.mx_priority.clear();
        newRecord.mx_priority.sendKeys("2");
        newRecord.data.clear();
        newRecord.data.sendKeys("some data");
        newRecord.resp_person.clear();
        newRecord.resp_person.sendKeys("Marek");
        newRecord.serial.clear();
        newRecord.serial.sendKeys("1234567890");
        newRecord.refresh.clear();
        newRecord.refresh.sendKeys("10000");
        newRecord.retry.clear();
        newRecord.retry.sendKeys("7200");
        newRecord.expire.clear();
        newRecord.expire.sendKeys("5000");
        newRecord.minimum.clear();
        newRecord.minimum.sendKeys("100");
        mySelect = new Select(driver.findElement(By.id("project")));
        mySelect.selectByIndex(1);


        driver.findElement(By.id("edit")).click();

//        String actualtext = driver.findElement(By.linkText("xxxEdit.com")).getText();
//        String expectedText = "xxxEdit.com";
//
//        if (actualtext.contentEquals(expectedText)){
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Can't find edited DNSrecord");
//        }

        driver.close();
    }

    @Test
    public void DeleteRecord_test1(){
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:8888/views/records.html");

        driver.findElement(By.id("adastra.cz")).click();


//        String actualtext = driver.findElement(By.linkText("pepa@pep.cz")).getText();
//        String expectedText = null;
//
////        if (actualtext.contentEquals(expectedText)){
////            System.out.println("Test Passed!");
////        } else {
////            System.out.println("Find deleted user");
////        }

        driver.close();

    }
}
