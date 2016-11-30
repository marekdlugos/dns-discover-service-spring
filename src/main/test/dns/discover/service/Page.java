package dns.discover.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kuba on 5/24/2016.
 */
public class Page {

    public WebElement uname;
    public WebElement email;
    public WebElement password;
    public WebElement password2;

    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
