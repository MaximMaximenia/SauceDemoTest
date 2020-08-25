package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BasePage {

    public WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }


public void checkURL(String expectedUrl){
    Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
}
}
