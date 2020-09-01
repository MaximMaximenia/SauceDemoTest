package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

abstract public class BasePage {
    public WebDriverWait wait;
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }
    public abstract BasePage isPageOpened();
    public abstract BasePage openPage();

    public void expectedURL (String url ){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

}
