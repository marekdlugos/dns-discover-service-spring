package dns.discover.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kuba on 5/24/2016.
 */
public class RecordPage {

    public WebElement zone ;
    public WebElement host;
    public WebElement ttl;
    public WebElement type;
    public WebElement mx_priority;
    public WebElement data;
    public WebElement resp_person;
    public WebElement serial;
    public WebElement refresh;
    public WebElement retry;
    public WebElement expire;
    public WebElement minimum;
    public WebElement project;

    public RecordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
